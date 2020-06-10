package com.company.main;

import com.company.company.Company;
import com.company.plane.BronzePlane;
import com.company.plane.GoldPlane;
import com.company.plane.SilverPlane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaneWindow extends JFrame {
    private JPanel planePanel;
    private ButtonGroup planeTypeGroup;
    private JRadioButton goldBtn;
    private JRadioButton bronzeBtn;
    private JRadioButton silverBtn;
    private JTextField fuelTxt;
    private JTextField speedTxt;
    private JTextField engineTxt;
    private JTextField passengersTxt;
    private ButtonGroup wifiGroup;
    private JRadioButton yesWifiBtn;
    private JRadioButton noWifiBtn;
    private JButton registerPlaneBtn;
    private JButton planeListBtn;
    private JButton backPageBtn;


    public PlaneWindow(){
        super("Flota");

        setContentPane(planePanel);

        planeTypeGroup = new ButtonGroup();
        planeTypeGroup.add(goldBtn);
        planeTypeGroup.add(silverBtn);
        planeTypeGroup.add(bronzeBtn);

        wifiGroup = new ButtonGroup();
        wifiGroup.add(yesWifiBtn);
        wifiGroup.add(noWifiBtn);



        registerPlaneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String fuelCapacitiy = fuelTxt.getText();
                double costKm = 300;
                String maxSpeed = speedTxt.getText();
                String engineType = engineTxt.getText();
                String passengers = passengersTxt.getText();
                boolean wifi = validateWifi();

                try {
                    if(fuelTxt.getText().isEmpty() || engineTxt.getText().isEmpty() || speedTxt.getText().isEmpty() || passengersTxt.getText().isEmpty() || !yesWifiBtn.isSelected() || !noWifiBtn.isSelected()){

                        //Method to generate a new plane instance
                        createPlane(fuelCapacitiy, costKm, maxSpeed, engineType, passengers, wifi);

                    } throw new CompleteAllFieldsException(goldBtn, silverBtn, bronzeBtn, fuelTxt, speedTxt, engineTxt, passengersTxt, yesWifiBtn, noWifiBtn);

                } catch (CompleteAllFieldsException ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, "No se pudo crear avión.","Error" ,JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });


        planeListBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame planeListWindow = new PlaneListWindow();
                        WindowSetting windowSetting = new WindowSetting();
                        windowSetting.windowSettings(planeListWindow);

                    }
                });

            }
        });


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


    private void createPlane(String fuel, double costKm, String speed, String engine, String passengers, boolean wifi){
        boolean error = false;
        int pass;
        double fuelCapacity, maxSpeed;

        try {

            pass = Integer.parseInt(passengers);
            fuelCapacity = Double.parseDouble(fuel);
            maxSpeed = Double.parseDouble(speed);

        } catch (NumberFormatException ex){
            error = true;
            pass = 0;
            fuelCapacity = 0;
            maxSpeed = 0;
        }

        if(!error) {

            if (goldBtn.isSelected()) {
                GoldPlane goldPlane = new GoldPlane(fuelCapacity, costKm, maxSpeed, engine, pass, wifi);
                System.out.println("GOLD Plane has been created.");
                System.out.println(goldPlane);
                Company company = Company.getCompany();
                company.addPlane(goldPlane);
                //TODO add to GoldPlane List

            } else if (silverBtn.isSelected()) {
                SilverPlane silverPlane = new SilverPlane(fuelCapacity, costKm, maxSpeed, engine, pass);
                System.out.println("SILVER Plane has been created.");
                System.out.println(silverPlane);
                Company company = Company.getCompany();
                company.addPlane(silverPlane);
                //TODO add to SilverPlane List

            } else if (bronzeBtn.isSelected()) {
                BronzePlane bronzePlane = new BronzePlane(fuelCapacity, costKm, maxSpeed, engine, pass);
                System.out.println("BRONZE Plane has been created.");
                System.out.println(bronzePlane);
                Company company = Company.getCompany();
                company.addPlane(bronzePlane);

                //TODO add to BronzePlane List
            }

        } else {
            System.out.println("No se pudo crear avión.");
        }

    }



    private boolean validateWifi(){
        boolean wifi = yesWifiBtn.isSelected() ? true : false;
        return wifi;
    }
}
