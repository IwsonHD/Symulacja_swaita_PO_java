package SYMULACJA_SWIATA_JAVA.organizmy.Zwierzeta;

import SYMULACJA_SWIATA_JAVA.Komentator;
import SYMULACJA_SWIATA_JAVA.Swiat;
import SYMULACJA_SWIATA_JAVA.organizmy.Organizm;
import SYMULACJA_SWIATA_JAVA.organizmy.Zwierze;

import java.awt.*;

public class Antylopa extends Zwierze {

    public Color rysowanie(){
        return new Color(131, 103, 71);
    }

    public Antylopa(int polozenie_x, int polozenie_y, Swiat ref_do_swiata){
        setSila(4);
        setInicjatywa(4);
        setWiek(0);
        setRef_do_swiata(ref_do_swiata);
        init_coords(polozenie_x,polozenie_y);
        ref_do_swiata.dodajOrganizmDoListy(this);
        getRef_do_swiata().getORGANIZMY_rozstawienie()[polozenie_x][polozenie_y] = this;
        setDo_usuniecia(false);
      //  ref_do_swiata.dodajOrganizmDoListy(this);

    }

    @Override
    public void akcja(){
        int dec = ((int)Math.floor(Math.random() * 20))%4;
        int x = getPolozenieX();
        int y = getPolozenieY();
        int x_pre = x;
        int y_pre = y;


        if (dec == 0) {
            if (x + 2 < getRef_do_swiata().getSzerokosc()) {
                x+= 2;
            }
		else {
                x-=2;
            }
        }
        else if (dec == 1) {
            if (x - 2 >= 0) {
                x-=2;
            }
            else {
                x+=2;
            }
        }
        else if (dec == 2) {
            if (y - 2 >= 0) {
                y-=2;
            }
            else {
                y+=2;
            }
        }
        else {
            if (y + 2 < getRef_do_swiata().getWysokosc()) {
                y+=2;
            }
		else {
                y-=2;
            }
        }
        //Zaktualizowanie polozenia w tablic
        //Trzeba bedzie dodac tutaj aktywacje kolizji w razie napotaknia innego organizmu

        if (getRef_do_swiata().getORGANIZMY_rozstawienie()[x][y] != null) {

            kolizja(x, y);
        }
	else {
            setPolozenie(x,y);
            getRef_do_swiata().getORGANIZMY_rozstawienie()[x_pre][y_pre] = null;
        }
    }



    @Override
    public void kolizja(int atak_na_X, int atak_na_Y){
        Organizm pod_natarciem = getRef_do_swiata().getORGANIZMY_rozstawienie()[atak_na_X][atak_na_Y];


        if (pod_natarciem.getClass().equals(this.getClass())) {
            //rozmnazanie
            if(pod_natarciem.getWiek() > 5 && this.getWiek() > 5){
                rozmnazanie();
            }
        }
        else {
            int flee_factor = ((int)Math.floor(Math.random() * 20)) % 2;

            if (flee_factor == 0) {
                pod_natarciem.walka(this);
            }
            else {
                int dec = ((int)Math.floor(Math.random() * 20)) % 4;
                int X = getPolozenieX();
                int Y = getPolozenieY();
                int x_pre = X;
                int y_pre = Y;

                if (dec == 0) {
                    if (X + 1 < getRef_do_swiata().getSzerokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X + 1][Y] != null) {
                        X++;
                    }
                    else if (X - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X - 1][Y] != null) {
                        X--;
                    }
                }
                else if (dec == 1) {
                    if (X - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X - 1][Y] != null) {
                        X--;
                    }
                    else if (X + 1 < getRef_do_swiata().getSzerokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X + 1][Y] != null) {
                        X++;
                    }
                }
                else if (dec == 2) {
                    if (Y - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y - 1] != null) {
                        Y--;
                    }
                    else if (Y + 1 < getRef_do_swiata().getWysokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y + 1] != null) {
                        Y++;
                    }
                }
                else {
                    if (Y + 1 < getRef_do_swiata().getWysokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y + 1] != null) {
                        Y++;
                    }
                    else if (Y - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y - 1] != null) {
                        Y--;
                    }
                }
                if (X == x_pre && Y == y_pre) {
                    getRef_do_swiata().usunOrganizm(X,Y);
                    return;
                }

                setPolozenie(X,Y);
                getRef_do_swiata().getORGANIZMY_rozstawienie()[x_pre][y_pre] = null;


            }
        }






    }



    @Override
    public void walka(Organizm atakujacy){
        int x = getPolozenieX();
        int y = getPolozenieY();
        int x_atakujacy = atakujacy.getPolozenieX();
        int y_atakujacy = atakujacy.getPolozenieY();
        int flee_factor = ((int)Math.floor(Math.random() * 20)) % 2;

        if (flee_factor == 0) {


            if (atakujacy.getSila() >= getSila()) {

                //usuniecie this
                //GetReferencja()->wyswietl_wydarzenie(atakujacy, "zabil", this);
                Komentator.addWydarzenie(atakujacy,"zjadl",this);
                getRef_do_swiata().usunOrganizm(x,y);


            }
            else {

                //usuniecie atakujacego
                Komentator.addWydarzenie(this,"zabilo", atakujacy);
                //GetReferencja()->wyswietl_wydarzenie(this, "zabil", atakujacy);
                getRef_do_swiata().usunOrganizm(x_atakujacy, y_atakujacy);
            }
        }
        else {
            int dec = ((int)Math.floor(Math.random() * 20)) % 4;
            int X = getPolozenieX();
            int Y = getPolozenieY();
            int x_pre = X;
            int y_pre = Y;

            if (dec == 0) {
                if (X + 1 < getRef_do_swiata().getSzerokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X + 1][Y] != null) {
                    X++;
                }
                else if (X - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X - 1][Y] != null) {
                    X--;
                }
            }
            else if (dec == 1) {
                if (X - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X - 1][Y] != null) {
                    X--;
                }
                else if (X + 1 < getRef_do_swiata().getSzerokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X + 1][Y] != null) {
                    X++;
                }
            }
            else if (dec == 2) {
                if (Y - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y - 1] != null) {
                    Y--;
                }
                else if (Y + 1 < getRef_do_swiata().getWysokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y + 1] != null) {
                    Y++;
                }
            }
            else {
                if (Y + 1 < getRef_do_swiata().getWysokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y + 1] != null) {
                    Y++;
                }
                else if (Y - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y - 1] != null) {
                    Y--;
                }
            }
            if (X == x_pre && Y == y_pre) {
                Komentator.addWydarzenie(this,"nie miala gdzie uciec", null);
                getRef_do_swiata().usunOrganizm(X,Y);
                return;
            }
            Komentator.addWydarzenie(this,"uciekla",null);
            setPolozenie(X,Y);
            getRef_do_swiata().getORGANIZMY_rozstawienie()[x_pre][y_pre] = null;

        }
    }






}
