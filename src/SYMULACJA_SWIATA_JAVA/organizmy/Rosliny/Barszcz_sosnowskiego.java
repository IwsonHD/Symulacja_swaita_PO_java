package SYMULACJA_SWIATA_JAVA.organizmy.Rosliny;

import SYMULACJA_SWIATA_JAVA.Komentator;
import SYMULACJA_SWIATA_JAVA.Swiat;
import SYMULACJA_SWIATA_JAVA.organizmy.Roslina;
import SYMULACJA_SWIATA_JAVA.organizmy.Zwierze;

import java.awt.*;

public class Barszcz_sosnowskiego extends Roslina {

    @Override
    public Color rysowanie() {
        return new Color(128, 154, 6);
    }

    public Barszcz_sosnowskiego(int polozenie_x, int polozenie_y, Swiat ref_do_swiata){
        setSila(4);
        setInicjatywa(4);
        setWiek(0);
        setRef_do_swiata(ref_do_swiata);
        init_coords(polozenie_x,polozenie_y);
        ref_do_swiata.dodajOrganizmDoListy(this);
        getRef_do_swiata().getORGANIZMY_rozstawienie()[polozenie_x][polozenie_y] = this;
        setDo_usuniecia(false);
       // ref_do_swiata.dodajOrganizmDoListy(this);

    }

    public void zabij_zwierzeta_obok(int x, int y){
        int szeroksc = getRef_do_swiata().getSzerokosc();
        int wysokosc = getRef_do_swiata().getWysokosc();




        if (x + 1 < szeroksc && getRef_do_swiata().getORGANIZMY_rozstawienie()[x + 1][y] != null) {
            if ((getRef_do_swiata().getORGANIZMY_rozstawienie()[x + 1][y]) instanceof Zwierze) {
                //GetReferencja()->wyswietl_wydarzenie(this, "zabil", GetReferencja()->GetRozstawienieOganizmow()[x+1][y]);
                Komentator.addWydarzenie(this,"zatruł",getRef_do_swiata().getORGANIZMY_rozstawienie()[x + 1][y]);
                getRef_do_swiata().usunOrganizm(x+1, y);
            }
        }

        if (x - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[x - 1][y] != null) {
            if ((getRef_do_swiata().getORGANIZMY_rozstawienie()[x -1][y]) instanceof Zwierze) {
                //GetReferencja()->wyswietl_wydarzenie(this, "zabil", GetReferencja()->GetRozstawienieOganizmow()[x+1][y]);
                Komentator.addWydarzenie(this,"zatruł",getRef_do_swiata().getORGANIZMY_rozstawienie()[x-1][y]);
                getRef_do_swiata().usunOrganizm(x-1, y);
            }
        }

        if (y + 1 < wysokosc && getRef_do_swiata().getORGANIZMY_rozstawienie()[x][y + 1] != null) {
            if ((getRef_do_swiata().getORGANIZMY_rozstawienie()[x][y+1]) instanceof Zwierze) {
                //GetReferencja()->wyswietl_wydarzenie(this, "zabil", GetReferencja()->GetRozstawienieOganizmow()[x+1][y]);
                Komentator.addWydarzenie(this,"zatruł",getRef_do_swiata().getORGANIZMY_rozstawienie()[x][y+1]);
                getRef_do_swiata().usunOrganizm(x, y+1);
            }
        }

        if (y - 1 > 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[x][y - 1] != null) {
            if ((getRef_do_swiata().getORGANIZMY_rozstawienie()[x][y-1]) instanceof Zwierze) {
                //GetReferencja()->wyswietl_wydarzenie(this, "zabil", GetReferencja()->GetRozstawienieOganizmow()[x+1][y]);
                Komentator.addWydarzenie(this,"zatruł",getRef_do_swiata().getORGANIZMY_rozstawienie()[x][y-1]);
                getRef_do_swiata().usunOrganizm(x, y-1);
            }
        }


    }



    @Override
    public void akcja(){
        int czy_rozsieje = ((int)Math.floor(Math.random() * 50)) % 20;
        int dec = ((int)Math.floor(Math.random() * 20)) % 4;
        int X = getPolozenieX();
        int Y = getPolozenieY();
        int X_pre = X;
        int Y_pre = Y;
        zabij_zwierzeta_obok(X,Y);
        if (czy_rozsieje == 2) {
            if (dec == 0) {
                if (X + 1 < getRef_do_swiata().getSzerokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X + 1][Y] == null) {
                    X++;
                }
                else if (X - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X - 1][Y] == null) {
                    X--;
                }
            }
            else if (dec == 1) {
                if (X - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X - 1][Y] == null) {
                    X--;
                }
                else if (X + 1 < getRef_do_swiata().getSzerokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X + 1][Y] == null) {
                    X++;
                }
            }
            else if (dec == 2) {
                if (Y - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y - 1] == null) {
                    Y--;
                }
                else if (Y + 1 < getRef_do_swiata().getWysokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y + 1] == null) {
                    Y++;
                }
            }
            else {
                if (Y + 1 < getRef_do_swiata().getWysokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y + 1] == null) {
                    Y++;
                }
                else if (Y - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y - 1] == null) {
                    Y--;
                }
            }
            if (X == X_pre && Y == Y_pre) {
                return;
            }

            getRef_do_swiata().stworz_nowy_organizm(this,X,Y);

        }
    }






}
