package SYMULACJA_SWIATA_JAVA;

import SYMULACJA_SWIATA_JAVA.organizmy.*;
import SYMULACJA_SWIATA_JAVA.organizmy.Rosliny.*;
import SYMULACJA_SWIATA_JAVA.organizmy.Zwierzeta.*;
import SYMULACJA_SWIATA_JAVA.Komentator;

import java.util.ArrayList;
import java.util.List;

public class Swiat {
    private final int szerokosc;
    private final int wysokosc;
    private Czlowiek czlowiek;

    private final Organizm[][] ORGANIZMY_rozstawienie;


    List<Organizm> ORGANIZMY;
    List<Organizm> doUsuniecia;

    Swiat(int szerokosc, int wysokosc){
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        ORGANIZMY_rozstawienie = new Organizm[szerokosc][wysokosc];
        for(int i = 0 ; i < szerokosc;i++){
            for(int j = 0; j < wysokosc ; j++){
                ORGANIZMY_rozstawienie[i][j] = null;
            }
        }
        ORGANIZMY = new ArrayList<Organizm>();
        doUsuniecia = new ArrayList<Organizm>();
        spawn_first_animals();
        //TESTY
 /*       new Owca(5,0,this);
        new Owca(2,3,this);
        new Wilk(2,2,this);
        new Wilk(3,3,this);
//        new Antylopa(9,2,this);
//        new Antylopa(4,6,this);
//        new Zolw(1,9,this);
//        new Zolw(5,5,this);
//        new Lis(7,7, this);
//        new Lis(7,8,this);
        new Trawa(3,8,this);
        new Mlecz(4,6,this);
        new Guarana(4,9,this);
//        new Wilcze_jagody(5,7,this);
//        new Barszcz_sosnowskiego(5,8,this);
//        new Barszcz_sosnowskiego(10,15,this);
        this.czlowiek = new Czlowiek(5,5,this);*/
    }

    Swiat(int szerokosc, int wysokosc/*, int czas_trwania_umiejetnosci*/, int czy_czlowiek){
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        ORGANIZMY_rozstawienie = new Organizm[szerokosc][wysokosc];
        for(int i = 0 ; i < szerokosc;i++){
            for(int j = 0; j < wysokosc ; j++){
                ORGANIZMY_rozstawienie[i][j] = null;
            }
        }
        ORGANIZMY = new ArrayList<Organizm>();
        doUsuniecia = new ArrayList<Organizm>();
        if(czy_czlowiek == 1) {
           // this.czlowiek = new Czlowiek(5, 5, this);
           // this.czlowiek.setCzasTrwaniaUmiejetnosci(czas_trwania_umiejetnosci);
        }else{
            this.czlowiek = null;
        }
    }

    protected void spawn_first_animals(){
        int x;
        int y;

        for(int i = 0 ; i < 2 + (((int)Math.floor(Math.random() * 20))%3); i++){
            do{
              x = ((int)Math.floor(Math.random() * 210)) % szerokosc;
              y = ((int)Math.floor(Math.random() * 210)) % wysokosc;
            }while(ORGANIZMY_rozstawienie[x][y] != null);

            new Owca(x,y,this);
        }

        for(int i = 0 ; i < 2 + (((int)Math.floor(Math.random() * 20))%3); i++){
            do{
                x = ((int)Math.floor(Math.random() * 210)) % szerokosc;
                y = ((int)Math.floor(Math.random() * 210)) % wysokosc;
            }while(ORGANIZMY_rozstawienie[x][y] != null);

            new Wilk(x,y,this);
        }

        for(int i = 0 ; i < 2 + (((int)Math.floor(Math.random() * 20))%3); i++){
            do{
                x = ((int)Math.floor(Math.random() * 210)) % szerokosc;
                y = ((int)Math.floor(Math.random() * 210)) % wysokosc;
            }while(ORGANIZMY_rozstawienie[x][y] != null);

            new Antylopa(x,y,this);
        }

        for(int i = 0 ; i < 2 + (((int)Math.floor(Math.random() * 20))%3); i++){
            do{
                x = ((int)Math.floor(Math.random() * 210)) % szerokosc;
                y = ((int)Math.floor(Math.random() * 210)) % wysokosc;
            }while(ORGANIZMY_rozstawienie[x][y] != null);

            new Barszcz_sosnowskiego(x,y,this);
        }

        for(int i = 0 ; i < 2 + (((int)Math.floor(Math.random() * 20))%3); i++){
            do{
                x = ((int)Math.floor(Math.random() * 210)) % szerokosc;
                y = ((int)Math.floor(Math.random() * 210)) % wysokosc;
            }while(ORGANIZMY_rozstawienie[x][y] != null);

            new Guarana(x,y,this);
        }

        for(int i = 0 ; i < 2 + (((int)Math.floor(Math.random() * 20))%3); i++){
            do{
                x = ((int)Math.floor(Math.random() * 210)) % szerokosc;
                y = ((int)Math.floor(Math.random() * 210)) % wysokosc;
            }while(ORGANIZMY_rozstawienie[x][y] != null);

            new Lis(x,y,this);
        }

        for(int i = 0 ; i < 2 + (((int)Math.floor(Math.random() * 20))%3); i++){
            do{
                x = ((int)Math.floor(Math.random() * 210)) % szerokosc;
                y = ((int)Math.floor(Math.random() * 210)) % wysokosc;
            }while(ORGANIZMY_rozstawienie[x][y] != null);

            new Mlecz(x,y,this);
        }

        for(int i = 0 ; i < 2 + (((int)Math.floor(Math.random() * 20))%3); i++){
            do{
                x = ((int)Math.floor(Math.random() * 210)) % szerokosc;
                y = ((int)Math.floor(Math.random() * 210)) % wysokosc;
            }while(ORGANIZMY_rozstawienie[x][y] != null);

            new Trawa(x,y,this);
        }

        for(int i = 0 ; i < 2 + (((int)Math.floor(Math.random() * 210))%3); i++){
            do{
                x = ((int)Math.floor(Math.random() * 210)) % szerokosc;
                y = ((int)Math.floor(Math.random() * 201)) % wysokosc;
            }while(ORGANIZMY_rozstawienie[x][y] != null);

            new Wilcze_jagody(x,y,this);
        }

        for(int i = 0 ; i < 2 + (((int)Math.floor(Math.random() * 20))%3); i++){
            do{
                x = ((int)Math.floor(Math.random() * 201)) % szerokosc;
                y = ((int)Math.floor(Math.random() * 210)) % wysokosc;
            }while(ORGANIZMY_rozstawienie[x][y] != null);

            new Zolw(x,y,this);
        }

        do{
            x = ((int)Math.floor(Math.random() * 210)) % szerokosc;
            y = ((int)Math.floor(Math.random() * 210)) % wysokosc;
        }while(ORGANIZMY_rozstawienie[x][y] != null);

        this.czlowiek = new Czlowiek(x,y,this);

    }





    public Organizm[][] getORGANIZMY_rozstawienie(){
        return ORGANIZMY_rozstawienie;
    }

    public List<Organizm> getORGANIZMY(){
        return ORGANIZMY;
    }

    public int getSzerokosc(){
        return szerokosc;
    }
    public int getWysokosc(){
        return wysokosc;
    }

    public Czlowiek getCzlowiek(){
        return this.czlowiek;
    }

    public void setCzlowiek(Czlowiek czlowiek){
        this.czlowiek = czlowiek;
    }


    public void stworz_nowy_organizm(Organizm rodzic, int polozenie_x, int polozenie_y){

       // Organizm nowy_organizm;

        if(rodzic instanceof Owca) {
            new Owca(polozenie_x,polozenie_y, this);

        } else if (rodzic instanceof Wilk) {
            new Wilk(polozenie_x,polozenie_y,this);

        } else if (rodzic instanceof Lis) {
           new Lis(polozenie_x,polozenie_y,this);

        } else if (rodzic instanceof Antylopa) {
             new Antylopa(polozenie_x,polozenie_y,this);

        } else if (rodzic instanceof Zolw) {
             new Zolw(polozenie_x,polozenie_y,this);

        } else if (rodzic instanceof Trawa) {
             new Trawa(polozenie_x,polozenie_y,this);
        } else if (rodzic instanceof Mlecz) {
           new Mlecz(polozenie_x,polozenie_y,this);
        } else if(rodzic instanceof Guarana) {
            new Guarana(polozenie_x,polozenie_y,this);
        } else if (rodzic instanceof Wilcze_jagody) {
             new Wilcze_jagody(polozenie_x,polozenie_y,this);
        } else{

        }


        //ORGANIZMY_rozstawienie[polozenie_x][polozenie_y] = nowy_organizm;
        //return nowy_organizm;

    }

    public void dodaj_nowy_organizm(String class_name, int polozenie_x, int polozenie_y,int sila, int wiek){

        Organizm nowy_organizm;
        //System.out.println(class_name);
        if(class_name.equals("SYMULACJA_SWIATA_JAVA.organizmy.Zwierzeta.Owca")) {
            nowy_organizm = new Owca(polozenie_x,polozenie_y, this);
            nowy_organizm.setSila(sila);
            nowy_organizm.setWiek(wiek);

        } else if (class_name.equals("SYMULACJA_SWIATA_JAVA.organizmy.Zwierzeta.Wilk")) {
            //System.out.println("xddasdasdad");
            nowy_organizm = new Wilk(polozenie_x,polozenie_y,this);
            nowy_organizm.setSila(sila);
            nowy_organizm.setWiek(wiek);
        } else if (class_name.equals("SYMULACJA_SWIATA_JAVA.organizmy.Zwierzeta.Lis")) {
            nowy_organizm = new Lis(polozenie_x,polozenie_y,this);
            nowy_organizm.setSila(sila);
            nowy_organizm.setWiek(wiek);
        } else if (class_name.equals("SYMULACJA_SWIATA_JAVA.organizmy.Zwierzeta.Antylopa")) {
            nowy_organizm = new Antylopa(polozenie_x,polozenie_y,this);
            nowy_organizm.setSila(sila);
            nowy_organizm.setWiek(wiek);
        } else if (class_name.equals("SYMULACJA_SWIATA_JAVA.organizmy.Zwierzeta.Zolw")) {
            nowy_organizm = new Zolw(polozenie_x,polozenie_y,this);
            nowy_organizm.setSila(sila);
            nowy_organizm.setWiek(wiek);
        } else if (class_name.equals("SYMULACJA_SWIATA_JAVA.organizmy.Rosliny.Trawa")) {

            nowy_organizm = new Trawa(polozenie_x,polozenie_y,this);
            nowy_organizm.setSila(sila);
            nowy_organizm.setWiek(wiek);
        } else if (class_name.equals("SYMULACJA_SWIATA_JAVA.organizmy.Rosliny.Mlecz")) {
            nowy_organizm = new Mlecz(polozenie_x,polozenie_y,this);
            nowy_organizm.setSila(sila);
            nowy_organizm.setWiek(wiek);
        } else if(class_name.equals("SYMULACJA_SWIATA_JAVA.organizmy.Rosliny.Guarana")) {
            nowy_organizm = new Guarana(polozenie_x,polozenie_y,this);
            nowy_organizm.setSila(sila);
            nowy_organizm.setWiek(wiek);
        } else if (class_name.equals("SYMULACJA_SWIATA_JAVA.organizmy.Rosliny.Wilcze_jagody")) {
            nowy_organizm = new Wilcze_jagody(polozenie_x,polozenie_y,this);
            nowy_organizm.setSila(sila);
            nowy_organizm.setWiek(wiek);
        } else if (class_name.equals("SYMULACJA_SWIATA_JAVA.organizmy.Rosliny.Barszcz_sosnowskiego")) {
            nowy_organizm = new Barszcz_sosnowskiego(polozenie_x,polozenie_y,this);
            nowy_organizm.setSila(sila);
            nowy_organizm.setWiek(wiek);
        } else if (class_name.equals("SYMULACJA_SWIATA_JAVA.organizmy.Zwierzeta.Czlowiek")) {
            this.czlowiek = new Czlowiek(polozenie_x,polozenie_y,this);
            this.czlowiek.setSila(sila);
            this.czlowiek.setWiek(wiek);

        } else{
            nowy_organizm = null;
        }


        //ORGANIZMY_rozstawienie[polozenie_x][polozenie_y] = nowy_organizm;
        //return nowy_organizm;

    }





    public void dodajOrganizmDoListy(Organizm nowy_organizm){
        int i = 0;
        while(i < ORGANIZMY.size()){
            if(ORGANIZMY.get(i).getInicjatywa() < nowy_organizm.getInicjatywa()) {
                ORGANIZMY.add(i, nowy_organizm);
                return;
            }
            i++;
        }
        ORGANIZMY.add(nowy_organizm);
    }

    public void wykonajTure(){
        Komentator.addWydarzenie(ORGANIZMY.size());
        int i = 0;
        while(i < ORGANIZMY.size()){
            if(!ORGANIZMY.get(i).getDo_usuniecia()) {
                ORGANIZMY.get(i).incrementWiek();
                ORGANIZMY.get(i).akcja();
            }
            i++;
        }

        if(!doUsuniecia.isEmpty()){
            usunDoUsunieciaV2();
        }
    }

    public void usunOrganizm(int polozenie_x, int polozenie_y){
        int i = 0;
        while(i < ORGANIZMY.size()){
            if(ORGANIZMY.get(i).getPolozenieX() == polozenie_x && ORGANIZMY.get(i).getPolozenieY() == polozenie_y){
                //System.out.println(polozenie_x + " "+polozenie_y);


                ORGANIZMY.get(i).setDo_usuniecia(true);
                doUsuniecia.add(ORGANIZMY_rozstawienie[polozenie_x][polozenie_y]);
                if(ORGANIZMY_rozstawienie[polozenie_x][polozenie_y] instanceof Czlowiek){
                    this.czlowiek = null;
                }
                ORGANIZMY_rozstawienie[polozenie_x][polozenie_y] = null;
            }
            i++;
        }


    }

    public void usunDoUsuniecia(){

        int i =0;
        while(i < doUsuniecia.size()){
            System.out.println(doUsuniecia.get(i).getClass().getName());

            ORGANIZMY.remove(doUsuniecia.get(i));
           //usun = doUsuniecia.get(i)
           i++;
        }
        doUsuniecia.clear();
    }

    public void usunDoUsunieciaV2(){
        int i = 0;
        while(i < ORGANIZMY.size()){
            if(ORGANIZMY.get(i).getDo_usuniecia()) {
                ORGANIZMY.remove(i);
            }
            i++;
        }
    }



}
