package SYMULACJA_SWIATA_JAVA;
import SYMULACJA_SWIATA_JAVA.organizmy.Rosliny.*;
import SYMULACJA_SWIATA_JAVA.organizmy.Zwierzeta.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;
import java.util.Scanner;
import javax.swing.*;
public class MainWindow {
    private final JFrame window;

    private static final int max_width = 600;
    private static final int max_height = 600;

    private int width;
    private int height;


    private Komentator komentator;

    private int jakieZwierzeDodac;


    //GridV2 worldGrid;
    Grid worldGrid;
    private Swiat Glowny_swiat;

    private class nextRoundListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e){

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if(Glowny_swiat.getCzlowiek() != null) {
                if (keyCode == KeyEvent.VK_UP) {
                    Glowny_swiat.getCzlowiek().setKierunek_ruchu('G');
                    Glowny_swiat.wykonajTure();
                    worldGrid.repaint();
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    Glowny_swiat.getCzlowiek().setKierunek_ruchu('L');
                    Glowny_swiat.wykonajTure();
                    worldGrid.repaint();
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    Glowny_swiat.getCzlowiek().setKierunek_ruchu('P');
                    Glowny_swiat.wykonajTure();
                    worldGrid.repaint();
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    Glowny_swiat.getCzlowiek().setKierunek_ruchu('D');
                    Glowny_swiat.wykonajTure();
                    worldGrid.repaint();
                } else if (keyCode == KeyEvent.VK_SPACE) {
                    Glowny_swiat.getCzlowiek().setCzy_aktywowoac_umiejetnosc(true);
                }
                komentator.wyswietl_komentarze();

            }else{
                Glowny_swiat.wykonajTure();
                worldGrid.repaint();
                komentator.wyswietl_komentarze();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public Komentator getKomentator(){
        return komentator;
    }




    private class Grid extends JPanel{
        private final int size_of_rects;
        private final int start_x = 40;
        private final int start_y = 40;

        @Override
        public void paintComponent(Graphics g){
            setBackground(new Color(86, 82, 84));
            super.paintComponent(g);

            for(int i = 0; i < width; i++){
                for(int j = 0; j < height ; j++){
                    g.setColor(Color.black);
                    g.drawRect(start_x + i*size_of_rects, start_y + j*size_of_rects,size_of_rects,size_of_rects);

                    if(Glowny_swiat.getORGANIZMY_rozstawienie()[i][j] != null) {
                        g.setColor(Glowny_swiat.getORGANIZMY_rozstawienie()[i][j].rysowanie());
                        g.fillRect(start_x + i * size_of_rects, start_y + j * size_of_rects, size_of_rects, size_of_rects);

                    }else{
                        g.setColor(new Color(86, 82, 84));
                        g.fillRect(start_x + i*size_of_rects, start_y + j*size_of_rects,size_of_rects,size_of_rects);
                    }
                    g.setColor(Color.black);

                }
            }
        }
        public int getSize_of_rects(){
            return size_of_rects;
        }

        Grid(){
            this.size_of_rects = max_width/Math.max(width,height);
            this.setPreferredSize(new Dimension(max_width,max_height));
           // this.addMouseListener(new GridClickListener());
        }



    }

    public class GridV2 extends JPanel{
        private final int sizeOfRects;

        private class Rect extends JPanel{
            public Rect(int x,int y){
                this.setPreferredSize(new Dimension(sizeOfRects,sizeOfRects));
                this.setBorder(BorderFactory.createLineBorder(Color.black));
                if(Glowny_swiat.getORGANIZMY_rozstawienie()[x][y] != null){
                    this.setBackground(Glowny_swiat.getORGANIZMY_rozstawienie()[x][y].rysowanie());
                }else{
                    this.setBackground(new Color(199, 82, 84));
                }
            }
        }




        @Override
        public void paintComponent(Graphics g){
            setBackground(new Color(86, 82, 84));
            super.paintComponent(g);
            int start_x = 40;
            int start_y = 40;

            Box plansza = Box.createHorizontalBox();
            Box row;


            for(int i = 0; i < width ; i++){
                row = Box.createVerticalBox();
                for(int j = 0; j < height ; j++){
                    row.add(new Rect(i,j));
                }
                plansza.add(row);
            }

            this.add(plansza);


        }





        GridV2(){
            this.sizeOfRects = max_width/Math.max(width,height);
            this.setPreferredSize(new Dimension(max_width, max_height));

        }


    }

    public JFrame getWindow() {
        return window;
    }

    private class UpperMenu extends JMenuBar{

        public UpperMenu(){
            this.setBackground(Color.lightGray);
            //this.setLayout(new FlowLayout(FlowLayout.LEFT, 10,4));
            this.setBorder(BorderFactory.createLineBorder(Color.black));

            JMenu options = new JMenu("Opcje");

            JMenuItem save = new JMenuItem("Zapisz");
            JMenuItem load = new JMenuItem("Wczytaj");

            options.add(save);
            options.add(load);

            addListeners(save,load);




            JMenu chooseAnimal = new JMenu("Wybierze jaki organizm dodać");
            JMenuItem Owca = new JMenuItem("Owca");
            JMenuItem Wilk = new JMenuItem("Wilk");
            JMenuItem Antylopa = new JMenuItem("Antylopa");
            JMenuItem Zolw = new JMenuItem("Zolw");
            JMenuItem Lis = new JMenuItem("Lis");
            JMenuItem Mlecz = new JMenuItem("Mlecz");
            JMenuItem Barszcz_sosnowskiego = new JMenuItem("Barszcz_sosnowskiego");
            JMenuItem Guarana = new JMenuItem("Guarana");
            JMenuItem Trawa = new JMenuItem("Trawa");
            JMenuItem Wilcze_jagody = new JMenuItem("Wilcze_jagody");

            chooseAnimal.add(Trawa);
            chooseAnimal.add(Owca);
            chooseAnimal.add(Wilcze_jagody);
            chooseAnimal.add(Wilk);
            chooseAnimal.add(Zolw);
            chooseAnimal.add(Barszcz_sosnowskiego);
            chooseAnimal.add(Lis);
            chooseAnimal.add(Mlecz);
            chooseAnimal.add(Guarana);
            chooseAnimal.add(Antylopa);

            Trawa.addActionListener(new subActionListener(1));
            Owca.addActionListener(new subActionListener(2));
            Wilcze_jagody.addActionListener(new subActionListener(3));
            Wilk.addActionListener(new subActionListener(4));
            Zolw.addActionListener(new subActionListener(5));
            Barszcz_sosnowskiego.addActionListener(new subActionListener(6));
            Lis.addActionListener(new subActionListener(7));
            Mlecz.addActionListener(new subActionListener(8));
            Guarana.addActionListener(new subActionListener(9));
            Antylopa.addActionListener(new subActionListener(10));







            this.add(options);
            this.add(chooseAnimal, BorderLayout.EAST);
        }

        private void addListeners(JMenuItem save_opt, JMenuItem load_opt){
            save_opt.addActionListener(save_listener ->{
                save_state();
            });

            load_opt.addActionListener(load_listener->{
                load_state();
            });
        }


        private class subActionListener implements ActionListener {

            int i;

            @Override
            public void actionPerformed(ActionEvent e) {
                jakieZwierzeDodac = i;
            }

            public subActionListener(int i){
                this.i = i;
            }
        }

    }

    private class GridClickListener implements MouseListener {
        private final int start_X = 40;
        private final int start_Y = 40;

        private final int size_of_rects = worldGrid.getSize_of_rects();


        private class Point{
            private int x;
            private int y;

/*            public int getX() {
                return x;
            }

            public int getY() {
                return y;
            }*/

            public Point(int x, int y){
                this.x = x;
                this.y = y;
            }

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y= e.getY();
            Point pointOnMap = calculatePointOnMap(x,y);
            try {
                if (Glowny_swiat.getORGANIZMY_rozstawienie()[pointOnMap.x][pointOnMap.y] == null) {
                    if (jakieZwierzeDodac == 1) {
                        new Trawa(pointOnMap.x, pointOnMap.y, Glowny_swiat);
                    } else if (jakieZwierzeDodac == 2) {
                        new Owca(pointOnMap.x, pointOnMap.y, Glowny_swiat);
                    } else if (jakieZwierzeDodac == 3) {
                        new Wilcze_jagody(pointOnMap.x, pointOnMap.y, Glowny_swiat);
                    } else if (jakieZwierzeDodac == 4) {
                        new Wilk(pointOnMap.x, pointOnMap.y, Glowny_swiat);
                    } else if (jakieZwierzeDodac == 5) {
                        new Zolw(pointOnMap.x, pointOnMap.y, Glowny_swiat);
                    } else if (jakieZwierzeDodac == 6) {
                        new Barszcz_sosnowskiego(pointOnMap.x, pointOnMap.y, Glowny_swiat);
                    } else if (jakieZwierzeDodac == 7) {
                        new Lis(pointOnMap.x, pointOnMap.y, Glowny_swiat);
                    } else if (jakieZwierzeDodac == 8) {
                        new Mlecz(pointOnMap.x, pointOnMap.y, Glowny_swiat);
                    } else if (jakieZwierzeDodac == 9) {
                        new Guarana(pointOnMap.x, pointOnMap.y, Glowny_swiat);
                    } else if (jakieZwierzeDodac == 10) {
                        new Antylopa(pointOnMap.x, pointOnMap.y, Glowny_swiat);
                    }
                    worldGrid.repaint();

                }
            }catch(ArrayIndexOutOfBoundsException xd){

            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }



        private Point calculatePointOnMap(int mouse_x, int mouse_y){
            int x;
            int y;
            x = (mouse_x -40)/size_of_rects;
            y = (mouse_y-40)/size_of_rects;
            return new Point(x,y);
        }

    }





    private class infoPanel extends JPanel{
        private Box mainBox = Box.createVerticalBox();
        public infoPanel(){
            this.setLayout(new FlowLayout(FlowLayout.CENTER,2,5));
            this.setPreferredSize(new Dimension(400,700));
            JLabel desc = new JLabel("Legenda:");
            mainBox.add(desc, BorderLayout.NORTH);
            mainBox.add(new infoLabel(new Color(131, 103, 71), "Antylopa"));
            mainBox.add(new infoLabel(new Color(128, 16, 16), "Lis"));
            mainBox.add(new infoLabel(new Color(234, 59, 65), "Guarana"));
            mainBox.add(new infoLabel(new Color(166, 161, 106), "Mlecz"));
            mainBox.add(new infoLabel(new Color(128, 154, 6), "Barszcz_sosnowskiego"));
            mainBox.add(new infoLabel(Color.white, "Owca"));
            mainBox.add(new infoLabel(new Color(0, 63, 0), "Trawa"));
            mainBox.add(new infoLabel(new Color(87, 39, 112), "Wilcze_jagody"));
            mainBox.add(new infoLabel(new Color(30, 29, 29), "Wilk"));
            mainBox.add(new infoLabel(new Color(126, 255, 0), "Zolw"));
            mainBox.add(new infoLabel(new Color(225, 170, 202), "Czlowiek"));

            this.add(mainBox, BorderLayout.CENTER);
        }



        private class infoLabel extends JPanel{

            private Color organism_color;

            private final int rectSize;

            @Override
            public void paintComponent(Graphics g){
                g.setColor(organism_color);
                g.drawRect(160,10,rectSize,rectSize);
                g.fillRect(160,10,rectSize,rectSize);
            }

            public infoLabel(Color kolor, String name){
                this.setPreferredSize(new Dimension(170,20));
                this.rectSize = 10;
                this.organism_color = kolor;
                //this.setBorder(BorderFactory.createLineBorder(Color.black));
                this.add(new JLabel(name), BorderLayout.CENTER);
            }

        }




    }






    MainWindow(int width, int height){
        window = new JFrame("Iwo Czartowski 193066");
        this.width = width;
        this.height = height;
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(1100, 750);
        window.setLocationRelativeTo(null);
        Glowny_swiat = new Swiat(width,height);
        worldGrid = new Grid();
        window.addKeyListener(new nextRoundListener());
        window.add(worldGrid, BorderLayout.CENTER);

        window.add(new infoPanel(), BorderLayout.EAST);
        window.setJMenuBar(new UpperMenu());
        worldGrid.addMouseListener(new GridClickListener());
        this.jakieZwierzeDodac = 0;
        //this.komentator = new Komentator(this);
        //window.add(opis,BorderLayout.EAST);
        //size_of_rects = max_width/Math.max(width,height);
    }


    public void show(){
        window.setVisible(true);
        this.komentator = new Komentator(this);
        this.komentator.setVisible(true);
    }

    private void save_state(){
        System.out.println(Glowny_swiat.getORGANIZMY().size());
        String file_name = JOptionPane.showInputDialog("Podaj nazwe po jaką zapisać stan");
        //File save_to = new File(file_name);
        try{
            FileWriter writer = new FileWriter(file_name);

            writer.write(String.valueOf(Glowny_swiat.getSzerokosc()));
            writer.write('\n');
            writer.write(String.valueOf(Glowny_swiat.getWysokosc()));
            writer.write('\n');
            if(Glowny_swiat.getCzlowiek() == null){
                writer.write("0");
                writer.write('\n');
                writer.write("0");
                writer.write('\n');
//                writer.write("0");
//                writer.write('\n');
//                writer.write("0");
//                writer.write('\n');
            }else{
                writer.write("1");
                writer.write('\n');
                writer.write(String.valueOf(Glowny_swiat.getCzlowiek().getCzas_trwania_umiejetnosci()));
                writer.write('\n');
//                writer.write(String.valueOf(Glowny_swiat.getCzlowiek().getPolozenieX()));
//                writer.write('\n');
//                writer.write(String.valueOf(Glowny_swiat.getCzlowiek().getPolozenieY()));
//                writer.write('\n');
            }

            int i = 0;

            while(i < Glowny_swiat.getORGANIZMY().size()){
                writer.write(String.valueOf(Glowny_swiat.getORGANIZMY().get(i).getWiek()));
                writer.write(' ');
                writer.write(String.valueOf(Glowny_swiat.getORGANIZMY().get(i).getSila()));
                writer.write(' ');
                writer.write(String.valueOf(Glowny_swiat.getORGANIZMY().get(i).getPolozenieX()));
                writer.write(' ');
                writer.write(String.valueOf(Glowny_swiat.getORGANIZMY().get(i).getPolozenieY()));
                writer.write(' ');
                writer.write(Glowny_swiat.getORGANIZMY().get(i).getClass().getName());
                writer.write('\n');

                i++;
            }




            writer.close();
        } catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void load_state(){
        System.out.println("wczytano stan symulacji");
        String file_name = JOptionPane.showInputDialog("Podaj nazwę pliku z którego zczytać stan");

        int szerokosc;
        int wysokosc;
        int czy_czlowiek_zyje;
        int czas_trwania_umiejetnosci;
      //  int polozenie_czlowiekaX;
      //  int polozenie_czlowiekY;

        String curr_line;

        try{
            File plik = new File(file_name);
            Scanner scanner = new Scanner(plik);

            curr_line = scanner.nextLine();
            szerokosc = Integer.parseInt(curr_line);
            curr_line = scanner.nextLine();
            wysokosc = Integer.parseInt(curr_line);
            curr_line = scanner.nextLine();
            czy_czlowiek_zyje = Integer.parseInt(curr_line);
            curr_line = scanner.nextLine();
            czas_trwania_umiejetnosci = Integer.parseInt(curr_line);
//            curr_line = scanner.nextLine();
//            polozenie_czlowiekaX = Integer.parseInt(curr_line);
//            curr_line = scanner.nextLine();
//            polozenie_czlowiekY = Integer.parseInt(curr_line);

            window.remove(worldGrid);
            Glowny_swiat = new Swiat(szerokosc,wysokosc/*,czas_trwania_umiejetnosci*/,czy_czlowiek_zyje);
            this.width = szerokosc;
            this.height =wysokosc;
            worldGrid = new Grid();
            window.add(worldGrid,BorderLayout.CENTER);
            worldGrid.revalidate();
            window.revalidate();

            while(scanner.hasNextLine()){
                curr_line = scanner.nextLine();
                String[] fragmenty = curr_line.split(" ");
                System.out.println(fragmenty[4]);
                if(fragmenty[4].equals("SYMULACJA_SWIATA_JAVA.organizmy.Zwierzeta.Czlowiek")){
                    Glowny_swiat.dodaj_nowy_organizm(fragmenty[4],
                            Integer.parseInt(fragmenty[2]), Integer.parseInt(fragmenty[3]),
                            Integer.parseInt(fragmenty[1]), Integer.parseInt(fragmenty[0]));

                    Glowny_swiat.getCzlowiek().setCzasTrwaniaUmiejetnosci(czas_trwania_umiejetnosci);
                }else {
                    Glowny_swiat.dodaj_nowy_organizm(fragmenty[4],
                            Integer.parseInt(fragmenty[2]), Integer.parseInt(fragmenty[3]),
                            Integer.parseInt(fragmenty[1]), Integer.parseInt(fragmenty[0]));

                }
            }


            scanner.close();

        } catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(new JFrame(), "Taki plik nie istnieje!",
                    "Zła nazwa pliku",JOptionPane.ERROR_MESSAGE);
            //e.printStackTrace();
        }
        worldGrid.repaint();

    }



}

