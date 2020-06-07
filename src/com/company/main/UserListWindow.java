package com.company.main;

import javax.swing.*;

public class UserListWindow extends JFrame {
    private JPanel userListPanel;
    private JList userJlist;
    private JButton showListBtn;
    DefaultListModel listModel = new DefaultListModel();

    public UserListWindow(){
        super("Lista de Usuarios Registrados");

        String[]userList = {"Gonzalo Lascar - DNI: 35621123", "Facundo Villalba - DNI: 33333333", "Carla Gómez - DNI: 25654789"};

        for(String i : userList){
            listModel.addElement(i);
        }

        userJlist = new JList(listModel);


        setContentPane(userJlist);

    }
}
