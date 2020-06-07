package com.company.main;

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
    private JButton listUsersBtn;

    public UserWindow(){
        super("Registrar Usuario");

        setContentPane(userPanel);

        registerUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                User user = new User();

                String name = nameTxt.getText();
                String surname = surnameTxt.getText();
                int dni = Integer.parseInt(dniTxt.getText());
                int age = Integer.parseInt(ageTxt.getText());

                user.registerUserSwing(name, surname, dni, age);
                System.out.println(user);
            }
        });


        listUsersBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame userListWindow = new UserListWindow();

                        WindowSetting windowSetting = new WindowSetting();
                        windowSetting.windowSettings(userListWindow);

                    }
                });

            }
        });
    }

}
