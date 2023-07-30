package SYMULACJA_SWIATA_JAVA.organizmy.Rosliny;

import SYMULACJA_SWIATA_JAVA.Komentator;
import SYMULACJA_SWIATA_JAVA.Swiat;
import SYMULACJA_SWIATA_JAVA.organizmy.Organizm;
import SYMULACJA_SWIATA_JAVA.organizmy.Roslina;

import java.awt.*;

public class Guarana extends Roslina {
    @Override
    public Color rysowanie() {
        return new Color(234, 59, 65);
    }

    public Guarana(int polozenie_x, int polozenie_y, Swiat ref_do_swiata){
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
    public void walka(Organizm atakujacy){
        int x = getPolozenieX();
        int y = getPolozenieY();

        Komentator.addWydarzenie(atakujacy, "zjadł guarane i zwiekszył swoja siłę",null);
        getRef_do_swiata().usunOrganizm(x,y);
        getRef_do_swiata().getORGANIZMY_rozstawienie()[atakujacy.getPolozenieX()][atakujacy.getPolozenieY()] = null;
        atakujacy.setPolozenie(x,y);
        atakujacy.setSila(atakujacy.getSila() + 3);

    }

}
