package SYMULACJA_SWIATA_JAVA.organizmy;

import SYMULACJA_SWIATA_JAVA.Komentator;

public abstract class Zwierze extends Organizm{
    @Override
    public void akcja(){
        int dec = ((int)Math.floor(Math.random() * 20))%4;
        int X = getPolozenieX();
        int Y = getPolozenieY();
        int X_pre = X;
        int Y_pre = Y;
        if (dec == 0) {
            if (X + 1 < getRef_do_swiata().getSzerokosc()) {
                X++;
            }
		else {
                X--;
            }
        }
        else if (dec == 1) {
            if (X - 1 >= 0) {
                X--;
            }
            else {
                X++;
            }
        }
        else if (dec == 2) {
            if (Y - 1 >= 0) {
                Y--;
            }
            else {
                Y++;
            }
        }
        else {
            if (Y + 1 < getRef_do_swiata().getWysokosc()) {
                Y++;
            }
		else {
                Y--;
            }
        }

        if(getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y] != null){
            kolizja(X,Y);
            //System.out.println(X);
            //System.out.println(Y);
        }else{
            this.setPolozenie(X,Y);
            //getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y] = this;
            getRef_do_swiata().getORGANIZMY_rozstawienie()[X_pre][Y_pre] = null;
        }

    }

    public void kolizja(int atak_na_X, int atak_na_Y){
        Organizm pod_natarciem = getRef_do_swiata().getORGANIZMY_rozstawienie()[atak_na_X][atak_na_Y];

        if(pod_natarciem.getClass().equals(this.getClass())){
           if(pod_natarciem.getWiek() > 5 && this.getWiek() > 5){
               rozmnazanie();
           }
        }else{
            pod_natarciem.walka(this);
        }
    }
    @Override
    public void walka(Organizm atakujacy){
        int X = getPolozenieX();
        int Y = getPolozenieY();
        int X_atakujacy = atakujacy.getPolozenieX();
        int Y_atakujacy = atakujacy.getPolozenieY();

        if(atakujacy.getSila()  >= this.getSila()){
            Komentator.addWydarzenie(atakujacy,"zabil",this);
            getRef_do_swiata().usunOrganizm(X,Y);
            atakujacy.setPolozenie(X,Y);
            getRef_do_swiata().getORGANIZMY_rozstawienie()[X_atakujacy][Y_atakujacy] = null;


        }else{
            Komentator.addWydarzenie(this, "zabil", atakujacy);
            getRef_do_swiata().usunOrganizm(X_atakujacy, Y_atakujacy);
        }
    }


    public void rozmnazanie(){
        int dec = ((int)Math.floor(Math.random() * 20))%4;
        int X = getPolozenieX();
        int Y = getPolozenieY();
        int x_pre = X;
        int y_pre = Y;

        if (dec == 0) {
            if (X + 1 < getRef_do_swiata().getSzerokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X + 1][Y] != null) {
                X++;
            }
		else if (X - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X - 1][Y] != null) {
                X--;
            }
        }
        else if (dec == 1) {
            if (X - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X - 1][Y] != null) {
                X--;
            }
		else if (X + 1 < getRef_do_swiata().getSzerokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X + 1][Y] != null) {
                X++;
            }
        }
        else if (dec == 2) {
            if (Y - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y - 1] != null) {
                Y--;
            }
		else if (Y + 1 < getRef_do_swiata().getWysokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y + 1] != null) {
                Y++;
            }
        }
        else {
            if (Y + 1 < getRef_do_swiata().getWysokosc() && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y + 1] != null) {
                Y++;
            }
		else if (Y - 1 >= 0 && getRef_do_swiata().getORGANIZMY_rozstawienie()[X][Y - 1] != null) {
                Y--;
            }
        }
        if (X == x_pre && Y == y_pre) {
            return;
        }

        getRef_do_swiata().stworz_nowy_organizm(this,X,Y);
        Komentator.addWydarzenie(this,"rozmnozyl się", null);

    }




}
