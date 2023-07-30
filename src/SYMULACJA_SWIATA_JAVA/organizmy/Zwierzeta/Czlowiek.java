package SYMULACJA_SWIATA_JAVA.organizmy.Zwierzeta;

import SYMULACJA_SWIATA_JAVA.Komentator;
import SYMULACJA_SWIATA_JAVA.Swiat;
import SYMULACJA_SWIATA_JAVA.organizmy.Zwierze;

import java.awt.*;

public class Czlowiek extends Zwierze {

    private char kierunek_ruchu;
    private int czas_trwania_umiejetnosci;
    boolean czy_aktywowoac_umiejetnosc;

    public void setKierunek_ruchu(char kierunek_ruchu) {
        this.kierunek_ruchu = kierunek_ruchu;
    }

    public char getKierunek_ruchu(){
        return this.kierunek_ruchu;
    }
    public int getCzas_trwania_umiejetnosci(){return this.czas_trwania_umiejetnosci;}

    public void setCzasTrwaniaUmiejetnosci(int czasTrwaniaUmiejetnosci){
        this.czas_trwania_umiejetnosci = czasTrwaniaUmiejetnosci;
    }
    public void decrementCzasTrawaniaUmiejetnosciAndSila(){
        if(this.czas_trwania_umiejetnosci > 0){
            this.setSila(getSila()-1);
            this.czas_trwania_umiejetnosci--;
        }
    }

    public boolean getCzy_aktywowac_umiejetnosc(){
        return czy_aktywowoac_umiejetnosc;
    }
    public void setCzy_aktywowoac_umiejetnosc(boolean T_F){
        this.czy_aktywowoac_umiejetnosc = T_F;
    }


    @Override
    public Color rysowanie() {
        return new Color(225, 170, 202);
    }

    @Override
    public void akcja(){
        int x = getPolozenieX();
        int y = getPolozenieY();
        int x_pre = x;
        int y_pre = y;

        int wysokosc = getRef_do_swiata().getWysokosc();
        int szerokosc = getRef_do_swiata().getSzerokosc();

        decrementCzasTrawaniaUmiejetnosciAndSila();

        if(czy_aktywowoac_umiejetnosc){
            System.out.println("Uzyto umiejetnosc");
            uzyj_umiejetnosci();
        }


        if (kierunek_ruchu == 'D' && y + 1 < wysokosc) {
            //ruch w dol
            y++;
        }
        else if (kierunek_ruchu == 'G' && y - 1 >= 0) {
            y--;
        }
        else if (kierunek_ruchu == 'P' && x + 1 < szerokosc) {
            x++;
        }
        else if (kierunek_ruchu == 'L' && x - 1 >= 0) {
            x--;
        }

        setKierunek_ruchu('N');//nie kieruj sie w zadna strone;
        if (x == x_pre && y == y_pre) {
            return;
        }

        if(getRef_do_swiata().getORGANIZMY_rozstawienie()[x][y] != null){
            kolizja(x,y);
        }else{
            setPolozenie(x,y);
            getRef_do_swiata().getORGANIZMY_rozstawienie()[x_pre][y_pre] = null;
        }



    }

    public void uzyj_umiejetnosci(){
        if(getCzas_trwania_umiejetnosci() == 0){
            setSila(getSila()+5);
            setCzasTrwaniaUmiejetnosci(5);
            setCzy_aktywowoac_umiejetnosc(false);
            //getRef_do_swiata().
            Komentator.addWydarzenie(this,"użył umiejętności",null);
        }else{
            Komentator.addWydarzenie(this, "nie może jeszcze użyć umiejętności",null);
            //System.out.println("nie mozna jeszcze uzyc umiejetnosci");
        }
    }




    public Czlowiek(int polozenie_x, int polozenie_y, Swiat ref_do_swiata){
        setSila(5);
        setInicjatywa(4);
        setWiek(0);
        setRef_do_swiata(ref_do_swiata);
        init_coords(polozenie_x,polozenie_y);
        ref_do_swiata.dodajOrganizmDoListy(this);
        getRef_do_swiata().getORGANIZMY_rozstawienie()[polozenie_x][polozenie_y] = this;
        setDo_usuniecia(false);
        //ref_do_swiata.dodajOrganizmDoListy(this);
        setKierunek_ruchu('N');
        setCzasTrwaniaUmiejetnosci(0);
        setCzy_aktywowoac_umiejetnosc(false);

    }







}
