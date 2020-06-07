package com.company.main;

import javax.swing.*;

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

    }
}
