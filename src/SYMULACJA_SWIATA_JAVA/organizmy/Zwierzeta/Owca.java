package SYMULACJA_SWIATA_JAVA.organizmy.Zwierzeta;


import SYMULACJA_SWIATA_JAVA.Swiat;
import SYMULACJA_SWIATA_JAVA.organizmy.Zwierze;

import java.awt.*;

public class Owca extends Zwierze {

/*    public void kolizja(int x, int y){
        System.out.println("kolizja");
    }

    @Override
    public void walka(Organizm atakujacy) {
        System.out.println("walka");
    }*/

    @Override
    public Color rysowanie() {
        return Color.white;
    }

    public Owca(int polozenie_x, int polozenie_y, Swiat ref_do_swiata){
        setSila(4);
        setInicjatywa(4);
        setWiek(0);
        setRef_do_swiata(ref_do_swiata);
        init_coords(polozenie_x,polozenie_y);
        ref_do_swiata.dodajOrganizmDoListy(this);
        getRef_do_swiata().getORGANIZMY_rozstawienie()[polozenie_x][polozenie_y] = this;
        setDo_usuniecia(false);
        //ref_do_swiata.dodajOrganizmDoListy(this);

    }


}
