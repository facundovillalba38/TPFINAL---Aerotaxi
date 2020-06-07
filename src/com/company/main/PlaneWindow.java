package com.company.main;

import javax.swing.*;

public class PlaneWindow extends JFrame {
    private JPanel planePanel;
    private JRadioButton goldRadioButton;
    private JRadioButton bronzeRadioButton;
    private JRadioButton silverRadioButton;
    private JTextField fuelTxt;
    private JTextField speedTxt;
    private JTextField engineTxt;
    private JTextField passengersTxt;
    private JButton registerPlaneBtn;
    private JCheckBox síCheckBox;
    private JCheckBox noCheckBox;


    public PlaneWindow(){
        super("Flota");

        setContentPane(planePanel);


    }
}
