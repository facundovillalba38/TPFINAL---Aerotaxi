package com.company.main;

import com.company.company.Company;
import com.company.plane.GoldPlane;
import com.company.user.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JTextField userSurname;
    private JTextField userName;
    private JTextField userDni;
    private JTextField userAge;
    private JButton registerUserBtn;
    private JLabel userLbl;
    private JLabel nameLbl;
    private JLabel surnameLbl;
    private JLabel dniLbl;
    private JLabel ageLbl;
    private JPanel mainWindow;


    private JMenuBar menuBar;
    private JMenu archivo;
    private JMenuItem salir;


    public Window(){
        super("Aerotaxi");

        setContentPane(mainWindow);

        menuBar = new JMenuBar();
        archivo = new JMenu("Archivo");
        salir = new JMenuItem("Salir");

        menuBar.add(archivo);
        archivo.add(salir);

        setJMenuBar(menuBar);

        registerUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                Company c = new Company();

                GoldPlane gold1 = new GoldPlane(1000,300,950,"motor",10,true);

                c.addPlane(gold1);

                String name = userName.getText();
                String surname = userSurname.getText();
                int dni = Integer.parseInt(userDni.getText());
                int age = Integer.parseInt(userAge.getText());

                user.registerUserSwing(name, surname, dni, age);

                System.out.println(user);
            }
        });
    }

}
