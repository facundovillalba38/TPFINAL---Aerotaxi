package com.company.main;

import com.company.company.Company;
import com.company.user.User;

import javax.swing.*;
import java.util.List;

public class UserListWindow extends JFrame {
    private JPanel userListPanel;
    private JList userJlist;
    private JButton showListBtn;
    DefaultListModel listModel = new DefaultListModel();

    public UserListWindow(){
        super("Lista de Usuarios Registrados");

        Company company = Company.getCompany();
        List<User> users = company.getUsers();
        for(User u : users){
            listModel.addElement(u);
        }

        userJlist = new JList(listModel);


        setContentPane(userJlist);



    }
}
