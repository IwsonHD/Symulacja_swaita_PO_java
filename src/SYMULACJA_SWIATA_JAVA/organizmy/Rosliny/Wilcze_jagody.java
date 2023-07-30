package SYMULACJA_SWIATA_JAVA.organizmy.Rosliny;

import SYMULACJA_SWIATA_JAVA.Komentator;
import SYMULACJA_SWIATA_JAVA.Swiat;
import SYMULACJA_SWIATA_JAVA.organizmy.Organizm;
import SYMULACJA_SWIATA_JAVA.organizmy.Roslina;

import java.awt.*;

public class Wilcze_jagody extends Roslina {
    @Override
    public Color rysowanie() {
        return new Color(87, 39, 112);
    }

    @Override
    public void walka(Organizm atakujacy){
        int x = getPolozenieX();
        int y = getPolozenieY();
        //GetReferencja()->wyswietl_wydarzenie(this, "zabil", atakujacy);
        Komentator.addWydarzenie(this,"zatruło", atakujacy);
        getRef_do_swiata().usunOrganizm(atakujacy.getPolozenieX(),atakujacy.getPolozenieY());
        getRef_do_swiata().usunOrganizm(x,y);
    }

    public Wilcze_jagody(int polozenie_x, int polozenie_y, Swiat ref_do_swiata){
        setSila(99);
        setInicjatywa(0);
        setWiek(0);
        setRef_do_swiata(ref_do_swiata);
        init_coords(polozenie_x,polozenie_y);
        ref_do_swiata.dodajOrganizmDoListy(this);
        getRef_do_swiata().getORGANIZMY_rozstawienie()[polozenie_x][polozenie_y] = this;
        setDo_usuniecia(false);
        //ref_do_swiata.dodajOrganizmDoListy(this);

    }


}
