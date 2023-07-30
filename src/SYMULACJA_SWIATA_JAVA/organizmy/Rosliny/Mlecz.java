package SYMULACJA_SWIATA_JAVA.organizmy.Rosliny;

import SYMULACJA_SWIATA_JAVA.Komentator;
import SYMULACJA_SWIATA_JAVA.Swiat;
import SYMULACJA_SWIATA_JAVA.organizmy.Roslina;

import java.awt.*;

public class Mlecz extends Roslina {
    @Override
    public Color rysowanie() {
        return new Color(166, 161, 106);
    }

    public Mlecz(int polozenie_x, int polozenie_y, Swiat ref_do_swiata){
        setSila(0);
        setInicjatywa(0);
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
        int czy_rozsieje;
        int dec = ((int)Math.floor(Math.random() * 50)) % 4;
        int X = getPolozenieX();
        int Y = getPolozenieY();
        int X_pre = X;
        int Y_pre = Y;
        for(int i = 0 ; i < 3; i++){
            czy_rozsieje = ((int)Math.floor(Math.random() * 20)) % 20;
            if (czy_rozsieje == 2) {
                if (dec == 0) {
                    if (X + 1 < getRef_do_swiata().getSzerokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X + 1][Y] == null) {
                        X++;
                    } else if (X - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X - 1][Y] == null) {
                        X--;
                    }
                } else if (dec == 1) {
                    if (X - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X - 1][Y] == null) {
                        X--;
                    } else if (X + 1 < getRef_do_swiata().getSzerokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X + 1][Y] == null) {
                        X++;
                    }
                } else if (dec == 2) {
                    if (Y - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y - 1] == null) {
                        Y--;
                    } else if (Y + 1 < getRef_do_swiata().getWysokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y + 1] == null) {
                        Y++;
                    }
                } else {
                    if (Y + 1 < getRef_do_swiata().getWysokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y + 1] == null) {
                        Y++;
                    } else if (Y - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y - 1] == null) {
                        Y--;
                    }
                }
                if (X == X_pre && Y == Y_pre) {
                    return;
                }
                Komentator.addWydarzenie(this,"rozsiał się",null);
                getRef_do_swiata().stworz_nowy_organizm(this, X, Y);
            }
        }
    }






}
