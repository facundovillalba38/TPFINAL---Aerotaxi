package com.company.main;

import com.company.company.Company;
import com.company.user.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserWindow extends JFrame {
    private JPanel userPanel;
    private JButton registerUserBtn;
    private JTextField nameTxt;
    private JTextField surnameTxt;
    private JTextField dniTxt;
    private JTextField ageTxt;
    private JButton backPageBtn;

    public UserWindow(){
        super("Registrar Usuario");

        setContentPane(userPanel);

        registerUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                User user = new User();
                //Company company = new Company();

                String name = nameTxt.getText();
                String surname = surnameTxt.getText();
                int dni = Integer.parseInt(dniTxt.getText());
                int age = Integer.parseInt(ageTxt.getText());

                user.registerUserSwing(name, surname, dni, age);
                Company company = Company.getCompany();
                company.addUser(user);
                company.showUsers();

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

}
