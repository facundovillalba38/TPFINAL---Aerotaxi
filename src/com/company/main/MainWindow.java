package com.company.main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JPanel mainWindow;
    private JButton goUserBtn;
    private JButton goPlaneBtn;
    private JButton goFlightBtn;





    public MainWindow(){
        super("Empresa de Aerotaxi");

        setContentPane(mainWindow);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
    }

}