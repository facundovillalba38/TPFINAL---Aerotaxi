package com.company.main;

import com.company.main.FlightListWindow;
import com.company.flight.Flight;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JPanel mainWindow = new JPanel();
    private JButton goUserBtn = new JButton();
    private JButton goPlaneBtn = new JButton();
    private JButton goFlightBtn = new JButton();
    private JButton showFlightBtn = new JButton();
    private JLabel imageLbl = new JLabel();

    public MainWindow(){
        super("Empresa de Aerotaxi");

        mainWindow.setLayout(null);
        setContentPane(mainWindow);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLbl.setIcon(new ImageIcon("src/img/avion.jpg"));
        imageLbl.setBounds(0, -20, 500, 500);
        mainWindow.add(imageLbl, 0);

        goUserBtn.setText("Registro de Usuario");
        goUserBtn.setBounds(20, 20, 200, 25);
        mainWindow.add(goUserBtn, 0);

        goUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame userWindow = new UserWindow();
                        WindowSetting windowSetting = new WindowSetting();
                        windowSetting.windowSettings(userWindow);
                        dispose();
                    }
                });
            }
        });


        goPlaneBtn.setText("Registro de Flota");
        goPlaneBtn.setBounds(20, 60, 200, 25);
        mainWindow.add(goPlaneBtn, 1);

        goPlaneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame planeWindow = new PlaneWindow();
                        WindowSetting windowSetting = new WindowSetting();
                        windowSetting.windowSettings(planeWindow);
                        dispose();
                    }
                });
            }
        });


        goFlightBtn.setText("Registro de Vuelos");
        goFlightBtn.setBounds(20, 100, 200, 25);
        mainWindow.add(goFlightBtn, 2);

        goFlightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame flightWindow = new FlightWindow();
                        WindowSetting windowSetting = new WindowSetting();
                        windowSetting.windowSettings(flightWindow);
                        dispose();
                    }
                });
            }
        });


        showFlightBtn.setText("Mostrar Vuelos");
        showFlightBtn.setBounds(20, 140, 200, 25);
        mainWindow.add(showFlightBtn, 3);

        showFlightBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame flightListWindow = new FlightListWindow();
                        WindowSetting windowSetting = new WindowSetting();
                        windowSetting.windowSettings(flightListWindow);
                        dispose();
                    }
                });
            }
        });
    }

}
