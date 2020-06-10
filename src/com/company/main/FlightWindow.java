package com.company.main;


import com.company.company.Company;
import com.company.flight.Flight;
import com.company.user.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class FlightWindow extends JFrame {
    private JPanel flightPanel = new JPanel();
    private JTextField dateTxt = new JTextField();
    private JTextField companionTxt = new JTextField();
    private JLabel totalCostLbl = new JLabel();
    private JRadioButton bsasBtn = new JRadioButton();
    private JRadioButton cordobaBtn = new JRadioButton();
    private JRadioButton montevideoBtn= new JRadioButton();;
    private JRadioButton sgoChileBtn= new JRadioButton();;
    private JRadioButton bsasDestBtn= new JRadioButton();;
    private JRadioButton cordobaDestBtn= new JRadioButton();;
    private JRadioButton montevideoDestBtn= new JRadioButton();;
    private JRadioButton sgoChileDestBtn= new JRadioButton();;
    private JComboBox planeBox;
    private JButton bookBtn = new JButton();
    private JComboBox userBox;
    private JLabel userLbl = new JLabel();
    private JLabel dateLbl = new JLabel();
    private JLabel originLbl = new JLabel();
    private JLabel destinyLbl = new JLabel();
    private JLabel companionLbl = new JLabel();
    private JLabel planeLbl = new JLabel();
    private JLabel priceLbl = new JLabel();
    private ButtonGroup originGroup;
    private ButtonGroup destinationGroup;
    private JTextField userTxt = new JTextField();
    private JTextField planeTxt = new JTextField();
    private JButton backPageBtn = new JButton();

    public FlightWindow() {
        super("Reserva de Vuelos");

        Company c = Company.getCompany();
        Flight f = new Flight();

        flightPanel.setLayout(null);
        this.getContentPane().add(flightPanel);

        validateCityBtn();

        setWindow(c, f);

    }


    private void setWindow(Company c, Flight f){

        int x1 = 40, height = 25;

        //FIRST ROW -- USER COMBO BOX

        userLbl.setText("Usuario:");
        userLbl.setBounds(x1,60,100,height);
        flightPanel.add(userLbl);

        //String[]userList = {"---", "Gonzalo Lascar - DNI: 35621123", "Facundo Villalba - DNI: 35111111", "Carlos Pérez - DNI: 23669987"};
        List<User> userList = c.getUsers();
        userBox = new JComboBox(userList.toArray());
        userBox.setBounds(100,60,300,height);
        userBox.addItem("- Elija usuario -");
        userBox.setSelectedItem("- Elija usuario -");
        flightPanel.add(userBox);

        userBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(userBox.getSelectedIndex() != 0){
                    userTxt.setText(userBox.getSelectedItem().toString());
                    System.out.println(userTxt.getText());
                }
            }
        });

        //SECOND ROW -- DATE TXT

        dateLbl.setText("Fecha (yyyy-mm-dd):");
        dateLbl.setBounds(x1, 100, 120,height);
        flightPanel.add(dateLbl);

        dateTxt.setBounds(160, 100,75,height);
        flightPanel.add(dateTxt);

        //THIRD ROW -- ORIGIN BUTTONS

        originLbl.setText("Origen:");
        originLbl.setBounds(x1, 140,50, height);
        flightPanel.add(originLbl);

        bsasBtn.setText("Buenos Aires");
        bsasBtn.setBounds(90, 140, 100, height);
        flightPanel.add(bsasBtn);

        cordobaBtn.setText("Córdoba");
        cordobaBtn.setBounds(190,140,70, height);
        flightPanel.add(cordobaBtn);

        montevideoBtn.setText("Montevideo");
        montevideoBtn.setBounds(260,140,90, height);
        flightPanel.add(montevideoBtn);

        sgoChileBtn.setText("Santiago de Chile");
        sgoChileBtn.setBounds(350,140,120, height);
        flightPanel.add(sgoChileBtn);

        //FOURTH ROW -- DESTINATION BUTTONS

        destinyLbl.setText("Destino:");
        destinyLbl.setBounds(x1, 180,50, height);
        flightPanel.add(destinyLbl);

        bsasDestBtn.setText("Buenos Aires");
        bsasDestBtn.setBounds(90, 180, 100, height);
        flightPanel.add(bsasDestBtn);

        cordobaDestBtn.setText("Córdoba");
        cordobaDestBtn.setBounds(190,180,70, height);
        flightPanel.add(cordobaDestBtn);

        montevideoDestBtn.setText("Montevideo");
        montevideoDestBtn.setBounds(260,180,90, height);
        flightPanel.add(montevideoDestBtn);

        sgoChileDestBtn.setText("Santiago de Chile");
        sgoChileDestBtn.setBounds(350,180,120, height);
        flightPanel.add(sgoChileDestBtn);

        //FIFTH ROW -- COMPANION TXT

        companionLbl.setText("Acompañantes:");
        companionLbl.setBounds(x1, 220, 90, 25);
        flightPanel.add(companionLbl);

        companionTxt.setBounds(130, 220,25, height);
        flightPanel.add(companionTxt);

        //SIXTH ROW -- PLANE COMBO BOX

        planeLbl.setText("Avión:");
        planeLbl.setBounds(x1, 260, 75, height);
        flightPanel.add(planeLbl);

        String []planeList = {"---", "Gold Plane - Capacidad: 7 - Catering: Sí - WiFi: Sí", "Bronze Plane - Capacidad: 10 - Catering: No - WiFi: No"};
        planeBox = new JComboBox(planeList);
        planeBox.setBounds(90, 260, 320, height);
        flightPanel.add(planeBox);

        planeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(planeBox.getSelectedIndex() != 0){
                    planeTxt.setText(planeBox.getSelectedItem().toString());
                    System.out.println(planeTxt.getText());
                }
            }
        });

        //SEVENTH ROW -- PRICE TXT

        priceLbl.setText("Precio:");
        priceLbl.setBounds(x1, 300, 50, height);
        flightPanel.add(priceLbl);

        totalCostLbl.setText("$ "+"0");
        totalCostLbl.setBounds(100, 300, 50, height);
        flightPanel.add(totalCostLbl);

        // EIGHTH ROW -- BOOK BUTTON

        bookBtn.setText("Reservar");
        bookBtn.setBounds(380, 380, 80, height);
        flightPanel.add(bookBtn);

        bookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //f.bookFlightSwing();
            }
        });

        //BACK BUTTON

        backPageBtn.setText("Volver");
        backPageBtn.setBounds(x1, 380, 80, height);
        flightPanel.add(backPageBtn);

        backPageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame mainWindow = new MainWindow();
                        WindowSetting windowSetting = new WindowSetting();
                        windowSetting.windowSettings(mainWindow);
                        dispose();
                    }
                });
            }
        });


    }






    private void validateCityBtn(){

        originGroup = new ButtonGroup();
        originGroup.add(bsasBtn);
        originGroup.add(cordobaBtn);
        originGroup.add(montevideoBtn);
        originGroup.add(sgoChileBtn);

        destinationGroup = new ButtonGroup();
        destinationGroup.add(bsasDestBtn);
        destinationGroup.add(cordobaDestBtn);
        destinationGroup.add(montevideoDestBtn);
        destinationGroup.add(sgoChileDestBtn);

        disableSameCity();

    }

    private void disableSameCity(){

        bsasBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bsasDestBtn.setEnabled(false);
                cordobaDestBtn.setEnabled(true);
                montevideoDestBtn.setEnabled(true);
                sgoChileDestBtn.setEnabled(true);
            }
        });

        cordobaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cordobaDestBtn.setEnabled(false);
                bsasDestBtn.setEnabled(true);
                montevideoDestBtn.setEnabled(true);
                sgoChileDestBtn.setEnabled(true);
            }
        });

        montevideoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                montevideoDestBtn.setEnabled(false);
                bsasDestBtn.setEnabled(true);
                cordobaDestBtn.setEnabled(true);
                sgoChileDestBtn.setEnabled(true);
            }
        });

        sgoChileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sgoChileDestBtn.setEnabled(false);
                bsasDestBtn.setEnabled(true);
                cordobaDestBtn.setEnabled(true);
                montevideoDestBtn.setEnabled(true);
            }
        });
    }


}
