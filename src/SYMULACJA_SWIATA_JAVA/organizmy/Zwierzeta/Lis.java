package SYMULACJA_SWIATA_JAVA.organizmy.Zwierzeta;

import SYMULACJA_SWIATA_JAVA.Komentator;
import SYMULACJA_SWIATA_JAVA.Swiat;
import SYMULACJA_SWIATA_JAVA.organizmy.Zwierze;

import java.awt.*;

public class Lis extends Zwierze {

    @Override
    public Color rysowanie() {
        return new Color(128, 16, 16);
    }

    public Lis(int polozenie_x, int polozenie_y, Swiat ref_do_swiata){
        setSila(3);
        setInicjatywa(7);
        setWiek(0);
        setRef_do_swiata(ref_do_swiata);
        init_coords(polozenie_x,polozenie_y);
        ref_do_swiata.dodajOrganizmDoListy(this);
        getRef_do_swiata().getORGANIZMY_rozstawienie()[polozenie_x][polozenie_y] = this;
        setDo_usuniecia(false);
       // ref_do_swiata.dodajOrganizmDoListy(this);

    }

    public boolean sub_akcja(int x, int y){
        if (getRef_do_swiata().getORGANIZMY_rozstawienie()[x][y] != null) {
            if (getRef_do_swiata().getORGANIZMY_rozstawienie()[x][y].getSila() <= getSila()) {
                return true;
            }
		else return false;
        }
	else return true;
    }


    @Override
    public void akcja(){
        int dec = ((int)Math.floor(Math.random() * 20)) % 4;
        int x = getPolozenieX();
        int y = getPolozenieY();
        int x_pre = x;
        int y_pre = y;
        int szer = getRef_do_swiata().getSzerokosc();
        int wysok = getRef_do_swiata().getWysokosc();




        if (dec == 0) {

            if (x + 1 < szer && sub_akcja(x+1,y)) {
                x++;
            }
            else if (x - 1 >= 0 && sub_akcja(x -1, y)) {
                x--;
            }
            else if (y + 1 < wysok && sub_akcja(x, y + 1)) {
                y++;
            }
            else if (y - 1 >= 0 && sub_akcja(x , y- 1)) {
                y--;
            }

        }
        else if (dec == 1) {
            if (x - 1 >= 0 && sub_akcja(x - 1, y)) {
                x--;
            }
            else if (x + 1 < szer && sub_akcja(x + 1, y)) {
                x++;
            }
            else if (y - 1 >= 0 && sub_akcja(x, y - 1)) {
                y--;
            }
            else if (y + 1 < wysok && sub_akcja(x , y + 1)) {
                y++;
            }
        }
        else if (dec == 2) {
            if (y - 1 >= 0 && sub_akcja(x, y - 1)) {
                y--;
            }
            else if (y + 1 < wysok && sub_akcja(x, y + 1)) {
                y++;
            }
            else if (x - 1 >= 0 && sub_akcja(x - 1, y)) {
                x--;
            }
            else if (x + 1 < szer && sub_akcja(x + 1, y)) {
                x++;
            }
        }
        else{
            if (y + 1 < wysok && sub_akcja(x, y + 1)) {
                y++;
            }
            else if (y - 1 >= 0 && sub_akcja(x, y - 1)) {
                y--;
            }
            else if (x - 1 >= 0 && sub_akcja(x - 1, y)) {
                x--;
            }
            else if (x + 1 < szer && sub_akcja(x + 1, y)) {
                x++;
            }

        }
        if (getRef_do_swiata().getORGANIZMY_rozstawienie()[x][y] != null) {

            //do zmiany na kolizjaV2
            //kolizja(GetReferencja()->GetRozstawienieOganizmow()[x][y]);
            kolizja(x, y);
        }
	else {
            setPolozenie(x,y);
            getRef_do_swiata().getORGANIZMY_rozstawienie()[x_pre][y_pre] = null;

        }
    }








}
