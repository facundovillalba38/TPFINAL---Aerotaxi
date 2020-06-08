package com.company.main;

import javax.swing.*;
import java.awt.*;

public class FlightWindow extends JFrame {
    private JPanel flightPanel;
    private JTextField userDniTxt;
    private JTextField dateTxt;
    private JTextField companionTxt;
    private JLabel totalCostLbl;
    private JRadioButton bsasBtn;
    private JRadioButton cordobaBtn;
    private JRadioButton montevideoBtn;
    private JRadioButton sgoChileBtn;
    private JRadioButton bsasDestBtn;
    private JRadioButton cordobaDestBtn;
    private JRadioButton montevideoDestBtn;
    private JRadioButton sgoChileDestBtn;
    private JTextField planeIdTxt;
    private JButton bookBtn;
    private ButtonGroup originGroup;
    private ButtonGroup destinationGroup;

    public FlightWindow() {
        super("Reserva de Vuelos");

        //CONFIGURATION
        setSize(550,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //**************

        setContentPane(flightPanel);

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

    }


}
