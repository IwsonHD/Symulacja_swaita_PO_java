package SYMULACJA_SWIATA_JAVA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow {
    final private JFrame startWindow;

    public static int tryParse(String text){
        try{
            return Integer.parseInt(text);
        }catch(NumberFormatException e){
            return -1;
        }
    }



    public StartWindow(){
        startWindow = new JFrame("Iwo Czartowski 193066");
        startWindow.setLayout(new BorderLayout());
        startWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        startWindow.setSize(400,200);
        startWindow.setLocationRelativeTo(null);
        JPanel startPanel = new JPanel();
        startPanel.setBackground(Color.gray);
        startPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
        JLabel startLabel = new JLabel("Wybierz rozmiary planszy, a nastepnie rozpocznij symulacje");
        startLabel.setFont(new Font("Arial", Font.BOLD, 13));
        startPanel.add(startLabel, BorderLayout.NORTH);
        startWindow.add(startPanel);
        addOptions(startPanel);



    }

    public void addOptions(JPanel panel){
        JTextField heightTextField = new JTextField(10);
        JTextField widthTextField = new JTextField(10);
        JButton startButton = new JButton("Rozpocznij");



        heightTextField.setToolTipText("Podaj wysokosc");
        widthTextField.setToolTipText(("Podaj szerokosc"));
        JLabel heightDesc = new JLabel("wysokosc: ");
        JLabel widthDesc = new JLabel(("szerokosc: "));

        Box mainBox = Box.createHorizontalBox();

        Box descBox = Box.createVerticalBox();
        Box textFieldsBox = Box.createVerticalBox();
        descBox.add(Box.createVerticalStrut(20));
        textFieldsBox.add(Box.createVerticalStrut(20));
        descBox.add(heightDesc);
        descBox.add(Box.createVerticalStrut(10));
        descBox.add(widthDesc);
        textFieldsBox.add(heightTextField);
        textFieldsBox.add(Box.createVerticalStrut(10));
        textFieldsBox.add(widthTextField);
        mainBox.add(descBox);

        mainBox.add(textFieldsBox);
        mainBox.add(Box.createHorizontalStrut(10));
        mainBox.add(startButton);

        startButton.addActionListener(actionListener -> {
            int w = tryParse(widthTextField.getText());
            int h = tryParse(heightTextField.getText());
            if(w >7 && w <300 && h > 7 && h < 300){
                startWindow.setVisible(false);
                new MainWindow(w,h).show();
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Podano nie właściwe wejscie!",
                        "Złe wejście",JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(mainBox);
    }


    public void showStartInterface(){
        startWindow.setVisible(true);
    }






}
