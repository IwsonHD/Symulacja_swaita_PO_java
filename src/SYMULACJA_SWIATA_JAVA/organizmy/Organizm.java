package SYMULACJA_SWIATA_JAVA.organizmy;
import SYMULACJA_SWIATA_JAVA.Swiat;

import java.awt.*;

public abstract class Organizm {
    private int  wiek;
    private int sila;
    private int inicjatywa;
    private boolean do_usuniecia;
    Swiat ref_do_swiata;

    private class COORDS{
        private int x;
        private int y;

        public COORDS(int X, int Y){
            this.x = X;
            this.y = Y;
        }

    }
    private COORDS polozenie;

    public abstract void akcja();
    //public abstract void kolizja(int atak_na_X, int atak_na_Y);
    public abstract void walka(Organizm atakujacy);
    //public abstract void rozmnazanie();
    public abstract Color rysowanie();
    public int getSila(){
        return this.sila;
    }
    public int getWiek(){
        return this.wiek;
    }
    public int getInicjatywa(){
        return this.inicjatywa;
    }
    public int getPolozenieX(){
        return this.polozenie.x;
    }
    public int getPolozenieY(){
        return this.polozenie.y;
    }
    public boolean getDo_usuniecia(){
        return this.do_usuniecia;
    }
    public Swiat getRef_do_swiata(){
        return ref_do_swiata;
    }
    public void setRef_do_swiata(Swiat swiat){
        this.ref_do_swiata = swiat;
    }
    public void setWiek(int wiek){
        this.wiek = wiek;
    }
    public void setSila(int sila){
        this.sila = sila;
    }

    public void init_coords(int X, int Y){
        this.polozenie = new COORDS(X,Y);
    }
    public void setInicjatywa(int inicjatywa){
        this.inicjatywa = inicjatywa;
    }
    public void setPolozenie(int X, int Y){
        this.polozenie.x = X;
        this.polozenie.y = Y;
        getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y] = this;
    }



    public void setPolozenie(COORDS polozenie){
        this.polozenie = polozenie;
    }

    public void setDo_usuniecia(boolean y_n){
        this.do_usuniecia = y_n;
    }

    public void incrementWiek(){
        this.wiek ++;
    }


}
