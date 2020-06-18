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
    private JTextField passengersTxt;
    private ButtonGroup wifiGroup;
    private JRadioButton yesWifiBtn;
    private JRadioButton noWifiBtn;
    private JButton registerPlaneBtn;
    private JButton planeListBtn;
    private JButton backPageBtn;
    private ButtonGroup engineGroup;
    private JRadioButton reactionEngineBtn;
    private JRadioButton propellerEngineBtn;
    private JRadioButton pistonsEngineBtn;


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

        engineGroup = new ButtonGroup();
        engineGroup.add(reactionEngineBtn);
        engineGroup.add(propellerEngineBtn);
        engineGroup.add(pistonsEngineBtn);


        registerPlaneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String fuelCapacitiy = fuelTxt.getText();
                double costKm = 300;
                String maxSpeed = speedTxt.getText();
                String passengers = passengersTxt.getText();
                boolean wifi = validateWifi();
                String engineType = engineSelection();

                if(!onlyNumberInput(fuelCapacitiy) || !onlyNumberInput(maxSpeed) || !onlyNumberInput(passengers)){

                    JOptionPane.showMessageDialog(null, "Sólo se admiten valores numéricos.", "Advertencia", JOptionPane.ERROR_MESSAGE);

                } else {

                    try {
                        if (fuelTxt.getText().isEmpty() || engineType.isEmpty() || speedTxt.getText().isEmpty() || passengersTxt.getText().isEmpty() || !yesWifiBtn.isSelected() || !noWifiBtn.isSelected()) {

                            //Method to generate a new plane instance
                            createPlane(fuelCapacitiy, costKm, maxSpeed, engineType, passengers, wifi);

                        }
                        throw new CompleteAllFieldsException(goldBtn, silverBtn, bronzeBtn, fuelTxt, speedTxt, engineType, passengersTxt, yesWifiBtn, noWifiBtn);

                    } catch (CompleteAllFieldsException ex) {
                        System.out.println(ex.getMessage());
                        if (ex.getMessage().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "El avión se registró exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }
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
                        dispose();
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

        if(engine.isEmpty()){
            error = true;
        }

        if(!error) {

            if (goldBtn.isSelected()) {
                GoldPlane goldPlane = new GoldPlane(fuelCapacity, costKm, maxSpeed, engine, pass, wifi);
                System.out.println("GOLD Plane has been created.");
                System.out.println(goldPlane);
                Company company = Company.getCompany();
                company.addPlane(goldPlane);


            } else if (silverBtn.isSelected()) {
                SilverPlane silverPlane = new SilverPlane(fuelCapacity, costKm, maxSpeed, engine, pass, false);
                System.out.println("SILVER Plane has been created.");
                System.out.println(silverPlane);
                Company company = Company.getCompany();
                company.addPlane(silverPlane);


            } else if (bronzeBtn.isSelected()) {
                BronzePlane bronzePlane = new BronzePlane(fuelCapacity, costKm, maxSpeed, engine, pass);
                System.out.println("BRONZE Plane has been created.");
                System.out.println(bronzePlane);
                Company company = Company.getCompany();
                company.addPlane(bronzePlane);

            }

        } else {
            System.out.println("No se pudo crear avión.");
}

    }

    private boolean validateWifi(){
        boolean wifi = yesWifiBtn.isSelected() ? true : false;
        return wifi;
    }

    private String engineSelection(){
        String engine = "";
        if(reactionEngineBtn.isSelected()){
            engine = "Reacción";
        }
        if(propellerEngineBtn.isSelected()){
            engine = "Hélice";
        }
        if(pistonsEngineBtn.isSelected()){
            engine = "Pistones";
        }
        return engine;
    }


    private boolean onlyNumberInput(String string){

        for(char c : string.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}
