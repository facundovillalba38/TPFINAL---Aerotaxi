package com.company.main;

import com.company.company.Company;
import com.company.plane.Plane;
import com.company.user.User;

import javax.swing.*;
import java.util.List;

public class PlaneListWindow extends JFrame {
    private JPanel planeListPanel;
    private JButton showListBtn;
    private JList planeJlist;
    DefaultListModel listModel = new DefaultListModel();

    public PlaneListWindow(){
        super("Lista de Aviones Registrados");

        Company company = Company.getCompany();
        List<Plane> planes = company.getPlanes();
        for(Plane p : planes){
            listModel.addElement(p);
        }

        planeJlist = new JList(listModel);


        setContentPane(planeJlist);



    }


}
