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
	// write your code here

        /*User u = new User();
        Company c = new Company();

        GoldPlane gold1 = new GoldPlane(1000,300,950,"motor",10,true);

        c.addPlane(gold1);

        u.registerUser();

        c.addUser(u);

        System.out.println(u);

        u.hireFlight(c);

        Flight f = c.getFlightByUserDNI(u.getDni());
        System.out.println("Usuario del vuelo: " + f.getClient().getName() + " " + f.getClient().getSurname());
        System.out.println(f.getTotalCost());*/

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
