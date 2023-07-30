package SYMULACJA_SWIATA_JAVA;

import SYMULACJA_SWIATA_JAVA.organizmy.Organizm;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Komentator extends JFrame {

    private static List<String> komentarze;
    private JFrame mainWindow;
    private JPanel mainPanel;
    private Box nowe_komentarze;

    public Komentator(MainWindow mainWindow){
        this.mainWindow = mainWindow.getWindow();
      //  this.setContentPane(new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        komentarze = new ArrayList<String>();
        this.setSize(600,400);
        this.setBackground(Color.black);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(this.mainWindow.getLocationOnScreen().x + 1000, this.mainWindow.getLocationOnScreen().y);
        JLabel titleLabel = new JLabel("WYDARZENIA");
        titleLabel.setFont(new Font("Arial", Font.BOLD,30));
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        this.add(titlePanel, BorderLayout.NORTH);
        mainPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        this.add(scrollPane);
        this.nowe_komentarze = Box.createVerticalBox();
        mainPanel.add(nowe_komentarze,BorderLayout.CENTER);
    }



    public static void addWydarzenie(Organizm organizm1, String co_zrobil, Organizm organizm2) {
        String nazwa_Organizm1 = organizm1.getClass().getSimpleName();//.split(".")[2];
        String nazwa_Organizm2;
        String out;
        if(organizm2 != null){
            nazwa_Organizm2 = organizm2.getClass().getSimpleName();//.split(".")[2];
        }else{
            nazwa_Organizm2 = null;
        }

        if(nazwa_Organizm2 != null){
            out = nazwa_Organizm1 +" "+ co_zrobil +" "+ nazwa_Organizm2;
        }else{
            out = nazwa_Organizm1 + " " + co_zrobil;
        }

        komentarze.add(out);
    }

    public static void addWydarzenie(int ile_organizmow){
        komentarze.add("Aktualnie żyje " + ile_organizmow + " organizmó");
    }

    public void wyswietl_komentarze(){
      //  this.mainPanel.removeAll();
        nowe_komentarze.removeAll();
        nowe_komentarze.revalidate();
        int i = 0;

        while(i < komentarze.size()){
            nowe_komentarze.add(new JLabel(komentarze.get(i)) );
            i++;
        }

        //this.mainPanel.revalidate();
        //this.mainPanel.add(nowe_komentarze, BorderLayout.CENTER);
        nowe_komentarze.revalidate();
        komentarze.clear();
    }



}
