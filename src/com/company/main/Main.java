package com.company.main;

import com.company.company.Company;
import com.company.flight.Flight;
import com.company.plane.GoldPlane;
import com.company.plane.Plane;
import com.company.user.User;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        //Create company and load our lists with the file information
        Company company = Company.getCompany();
        company.getUsers();
        company.getPlanes();
        company.getFlights();


        //Now, invoke the swing interface
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MainWindow();
                frame.setSize(500,500);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });


    }
}
