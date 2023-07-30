package SYMULACJA_SWIATA_JAVA.organizmy.Zwierzeta;


import SYMULACJA_SWIATA_JAVA.Swiat;
import SYMULACJA_SWIATA_JAVA.organizmy.Zwierze;

import java.awt.*;

public class Wilk extends Zwierze {
    @Override
    public Color rysowanie() {
        return new Color(30, 29, 29);
    }

    public Wilk(int polozenie_x, int polozenie_y, Swiat ref_do_swiata){
        setSila(9);
        setInicjatywa(5);
        setWiek(0);
        setRef_do_swiata(ref_do_swiata);
        init_coords(polozenie_x,polozenie_y);
        ref_do_swiata.dodajOrganizmDoListy(this);
        getRef_do_swiata().getORGANIZMY_rozstawienie()[polozenie_x][polozenie_y] = this;
        setDo_usuniecia(false);
        //ref_do_swiata.dodajOrganizmDoListy(this);

    }

}
