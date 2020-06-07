package com.company.main;

import javax.swing.*;

public class WindowSetting {

    public WindowSetting(){}

    public void windowSettings(JFrame frame) {
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
