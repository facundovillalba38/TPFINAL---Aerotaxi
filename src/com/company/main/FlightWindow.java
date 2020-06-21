package com.company.main;


import com.company.company.Company;
import com.company.flight.Destination;
import com.company.flight.Flight;
import com.company.plane.Plane;
import com.company.user.User;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;


public class FlightWindow extends JFrame {
    private JPanel flightPanel = new JPanel();
    private JTextField dateTxt = new JTextField();
    private JDateChooser calendar = new JDateChooser();
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


        flightPanel.setLayout(null);
        this.getContentPane().add(flightPanel);

        validateCityBtn();

        setWindow(c);

    }


    private void setWindow(Company c){

        int x1 = 40, height = 25;

        //FIRST ROW -- USER COMBO BOX

        userLbl.setText("Usuario:");
        userLbl.setBounds(x1,60,100,height);
        flightPanel.add(userLbl);

        //String[]userList = {"---", "Gonzalo Lascar - DNI: 35621123", "Facundo Villalba - DNI: 35111111", "Carlos Pérez - DNI: 23669987"};
        List<User> userList = c.getUsers();
        userBox = new JComboBox(userList.toArray());
        userBox.setBounds(100,60,300,height);
        String userItem = "- Elija usuario -";
        userBox.addItem(userItem);
        userBox.setSelectedItem(userItem);
        flightPanel.add(userBox);

        userBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!userBox.getSelectedItem().equals(userItem)){
                    userTxt.setText(userBox.getSelectedItem().toString());
                    System.out.println(userTxt.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Debe elegir un usuario!", "Atención", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //SECOND ROW -- DATE TXT

        dateLbl.setText("Fecha:");
        dateLbl.setBounds(x1, 100, 120,height);
        flightPanel.add(dateLbl);

        calendar.setBounds(100, 100, 100, height);
        calendar.setDateFormatString("yyyy-MM-dd");
        flightPanel.add(calendar);

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

        //String []planeList = {"Gold Plane - Capacidad: 7 - Catering: Sí - WiFi: Sí", "Bronze Plane - Capacidad: 10 - Catering: No - WiFi: No"};
        List<Plane>planeList = c.getPlanes();
        planeBox = new JComboBox(planeList.toArray());
        planeBox.setBounds(90, 260, 320, height);
        String planeItem = "- Elija avión -";
        planeBox.addItem(planeItem);
        planeBox.setSelectedItem(planeItem);
        flightPanel.add(planeBox);

        planeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!planeBox.getSelectedItem().equals(planeItem)){
                    planeTxt.setText(planeBox.getSelectedItem().toString());
                    System.out.println(planeTxt.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Debe elegir un avión!", "Atención", JOptionPane.ERROR_MESSAGE);
                }
            }
        });



        //SEVENTH ROW -- PRICE TXT

        priceLbl.setText("Precio:");
        priceLbl.setBounds(x1, 300, 50, height);
        flightPanel.add(priceLbl);

        totalCostLbl.setText("$ "+"0");
        totalCostLbl.setBounds(100, 300, 100, height);
        flightPanel.add(totalCostLbl);

        // EIGHTH ROW -- BOOK BUTTON

        bookBtn.setText("Reservar");
        bookBtn.setBounds(380, 380, 80, height);
        flightPanel.add(bookBtn);

        bookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Verification of combo boxes with if sentence

                if (userBox.getSelectedItem().equals(userItem) || planeBox.getSelectedItem().equals(planeItem)) {

                    JOptionPane.showMessageDialog(null, "Verifique el usuario o el avión.", "Atención", JOptionPane.ERROR_MESSAGE);

                } else {

                    //PARSING CALENDAR TO LOCALDATE
                    LocalDate dateFlight = calendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                    //CHECK IF BOOK FLIGHT DATE IS POSIBLE -> if it's 0, date is today. If it's greater dateFlight is greater than today

                    if (dateFlight.compareTo(LocalDate.now()) >= 0) {

                        //Get passengers
                        int passengers = Integer.parseInt(companionTxt.getText());
                        passengers++;    //Companion plus de person who books the flight = total passengers!


                        //BOOK FLIGHT METHOD

                        Plane planeSelected = (Plane) planeBox.getSelectedItem();
                        int planeSelectedOccupation = planeSelected.getPassengerCapacity();
                        Company company = Company.getCompany();
                        List<Flight> flights = company.getFlights();

                        //CREATE FLIGHT INSTANCE
                        Flight newFlight = new Flight();
                        newFlight.setId();

                        //Occupation verification
                        Boolean exist = false;
                        if (passengers <= planeSelectedOccupation) {
                            if (!flights.isEmpty()) {
                                for (Flight f : flights) {
                                    if (f.getDepartureDate().equals(dateFlight)) {
                                        exist = true;

                                    }
                                }
                                if (exist) {
                                    JOptionPane.showMessageDialog(null, "Ya hay un vuelo resevado para la fecha ingresada.", "Error", JOptionPane.ERROR_MESSAGE);
                                } else if (getSelectedOriginCity() == getSelectedDestinyCity()) {
                                    JOptionPane.showMessageDialog(null, "La ciudad de origen no puede ser la misma que la ciudad de destino.", "Error", JOptionPane.ERROR_MESSAGE);

                                } else {  // if the origin != destination
                                    List<Flight> cFlights = c.getFlights();
                                    Boolean sameDay = false;
                                    for (Flight f : cFlights) {
                                        if (f.getDepartureDate() == dateFlight && f.getPlaneCategory().getId() == ((Plane) planeBox.getSelectedItem()).getId()) {
                                            sameDay = true;
                                        }
                                    }
                                    if (sameDay == false) {
                                        newFlight.bookFlightSwing(c, (User) userBox.getSelectedItem(), dateFlight, getSelectedOriginCity(), getSelectedDestinyCity(), passengers, (Plane) planeBox.getSelectedItem());
                                        JOptionPane.showMessageDialog(null, "La reserva se ha realizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Ya hay un vuelo para el avión seleccionado en esa fecha", "Error", JOptionPane.ERROR_MESSAGE);
                                    }

                                }
                            } else if (getSelectedOriginCity() == getSelectedDestinyCity()) {
                                JOptionPane.showMessageDialog(null, "La ciudad de origen no puede ser la misma que la ciudad de destino.", "Error", JOptionPane.ERROR_MESSAGE);

                            } else {  // if the origin != destination
                                newFlight.bookFlightSwing(c, (User) userBox.getSelectedItem(), dateFlight, getSelectedOriginCity(), getSelectedDestinyCity(), passengers, (Plane) planeBox.getSelectedItem());
                                JOptionPane.showMessageDialog(null, "La reserva se ha realizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            }


                        } else {
                            JOptionPane.showMessageDialog(null, "El avión elegido no puede transportar esa cantidad de pasajeros.", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                        //Set Total Cost Label
                        totalCostLbl.setText("$ " + String.valueOf(newFlight.getTotalCost()));

                    } else {
                        JOptionPane.showMessageDialog(null, "La fecha elegida no es posible.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
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

    private Destination getSelectedOriginCity(){
        if(bsasBtn.isSelected()){
            return Destination.BUENOSAIRES;
        } else if(cordobaBtn.isSelected()){
            return Destination.CORDOBA;
        } else if (montevideoBtn.isSelected()){
            return Destination.MONTEVIDEO;
        } else {
            return Destination.SANTIAGODECHILE;
        }
    }

    private Destination getSelectedDestinyCity(){
        if(bsasDestBtn.isSelected()){
            return Destination.BUENOSAIRES;
        } else if(cordobaDestBtn.isSelected()){
            return Destination.CORDOBA;
        } else if (montevideoDestBtn.isSelected()){
            return Destination.MONTEVIDEO;
        } else {
            return Destination.SANTIAGODECHILE;
        }
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
