package SYMULACJA_SWIATA_JAVA.organizmy.Rosliny;

import SYMULACJA_SWIATA_JAVA.Swiat;
import SYMULACJA_SWIATA_JAVA.organizmy.Roslina;

import java.awt.*;

public class Trawa extends Roslina {

    @Override
    public Color rysowanie() {
        return new Color(0, 63, 0);
    }

    public Trawa(int polozenie_x, int polozenie_y, Swiat ref_do_swiata){
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


}
