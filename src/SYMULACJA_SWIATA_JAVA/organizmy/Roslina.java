package SYMULACJA_SWIATA_JAVA.organizmy;

import SYMULACJA_SWIATA_JAVA.Komentator;
import SYMULACJA_SWIATA_JAVA.organizmy.Organizm;

import java.awt.*;

abstract public class Roslina extends Organizm {

    @Override
    public void akcja() {
        int czy_rozsieje = ((int)Math.floor(Math.random() * 50)) % 20;
        int dec = ((int)Math.floor(Math.random() * 20)) % 4;
        int X = getPolozenieX();
        int Y = getPolozenieY();
        int X_pre = X;
        int Y_pre = Y;

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
            Komentator.addWydarzenie(this, "rozsiało się", null);

        }
    }



    @Override
    public void walka(Organizm atakujacy) {
        int x = getPolozenieX();
        int y = getPolozenieY();

        //GetReferencja()->wyswietl_wydarzenie(atakujacy, "zjadl", this);
        getRef_do_swiata().getORGANIZMY_rozstawienie()[atakujacy.getPolozenieX()][atakujacy.getPolozenieY()] = null;
        getRef_do_swiata().usunOrganizm(x, y);
        atakujacy.setPolozenie(x, y);
        Komentator.addWydarzenie(atakujacy, "zjadł", this);

    }







}
