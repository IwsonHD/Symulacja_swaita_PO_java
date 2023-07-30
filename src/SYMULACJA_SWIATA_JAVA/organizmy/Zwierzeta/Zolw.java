package SYMULACJA_SWIATA_JAVA.organizmy.Zwierzeta;

import SYMULACJA_SWIATA_JAVA.Komentator;
import SYMULACJA_SWIATA_JAVA.Swiat;
import SYMULACJA_SWIATA_JAVA.organizmy.Organizm;
import SYMULACJA_SWIATA_JAVA.organizmy.Zwierze;

import java.awt.*;

public class Zolw extends Zwierze {
    @Override
    public Color rysowanie(){
        return new Color(126, 255, 0);
    }


    public Zolw(int polozenie_x, int polozenie_y, Swiat ref_do_swiata){
        setSila(2);
        setInicjatywa(1);
        setWiek(0);
        setRef_do_swiata(ref_do_swiata);
        init_coords(polozenie_x,polozenie_y);
        ref_do_swiata.dodajOrganizmDoListy(this);
        getRef_do_swiata().getORGANIZMY_rozstawienie()[polozenie_x][polozenie_y] = this;
        setDo_usuniecia(false);
       // ref_do_swiata.dodajOrganizmDoListy(this);

    }

    @Override
    public void akcja(){
        int move_factor =  ((int)Math.floor(Math.random() * 20)) % 4;

        if (move_factor == 0) {
            int dec = ((int)Math.floor(Math.random() * 20)) % 4;
            int x = getPolozenieX();
            int y = getPolozenieY();
            int x_pre = x;
            int y_pre = y;


            if (dec == 0) {
                if (x + 1 < getRef_do_swiata().getSzerokosc()) {
                    x++;
                }
			else {
                    x--;
                }
            }
            else if (dec == 1) {
                if (x - 1 >= 0) {
                    x--;
                }
                else {
                    x++;
                }
            }
            else if (dec == 2) {
                if (y - 1 >= 0) {
                    y--;
                }
                else {
                    y++;
                }
            }
            else {
                if (y + 1 < getRef_do_swiata().getWysokosc()) {
                    y++;
                }
			else {
                    y--;
                }
            }
            //Zaktualizowanie polozenia w tablic
            //Trzeba bedzie dodac tutaj aktywacje kolizji w razie napotaknia innego organizmu

            if(getRef_do_swiata().getORGANIZMY_rozstawienie()[x][y] != null){
                kolizja(x,y);
                //System.out.println(X);
                //System.out.println(Y);
            }else{
                this.setPolozenie(x,y);
                //getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y] = this;
                getRef_do_swiata().getORGANIZMY_rozstawienie()[x_pre][y_pre] = null;
            }
        }

    }

    @Override
    public void walka( Organizm atakujacy){
        int x = getPolozenieX();
        int y = getPolozenieY();
        int x_atakujacy = atakujacy.getPolozenieX();
        int y_atakujacy = atakujacy.getPolozenieY();

        if (atakujacy.getSila() >= getSila()) {

            //usuniecie this
            if (atakujacy.getSila() >= 5) {
                //GetReferencja()->wyswietl_wydarzenie(atakujacy, "zabil", this);
                Komentator.addWydarzenie(atakujacy,"zbil", this);
                getRef_do_swiata().usunOrganizm(x, y);
                getRef_do_swiata().getORGANIZMY_rozstawienie()[atakujacy.getPolozenieX()][atakujacy.getPolozenieY()] = null;
                atakujacy.setPolozenie(x, y);
                //GetReferencja()->GetRozstawienieOganizmow()[x][y] = atakujacy;
            }
            else {
                Komentator.addWydarzenie(this,"odbił atak",atakujacy);
                //GetReferencja()->wyswietl_wydarzenie(this, "odbila atak", atakujacy);
            }

        }
        else {
            Komentator.addWydarzenie(this,"zabił",atakujacy);
            //usuniecie atakujacego
            //GetReferencja()->wyswietl_wydarzenie(this, "zabil", atakujacy);
            getRef_do_swiata().usunOrganizm(x_atakujacy, y_atakujacy);

        }
    }




}
