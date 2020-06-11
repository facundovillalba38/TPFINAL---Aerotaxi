package com.company.main;

import com.company.company.Company;
import com.company.plane.Plane;
import com.company.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PlaneListWindow extends JFrame {
    private JPanel planeListPanel = new JPanel();
    private JButton backPageBtn = new JButton();
    private JList planeJlist;
    DefaultListModel listModel = new DefaultListModel();
    private JLabel windowLbl = new JLabel();

    public PlaneListWindow(){
        super("Lista de Aviones Registrados");

        Company company = Company.getCompany();
        List<Plane> planes = company.getPlanes();
        for(Plane p : planes){
            listModel.addElement(p + " - ID: " + p.getId());
        }

        planeJlist = new JList(listModel);
        planeListPanel.setLayout(null);
        setContentPane(planeListPanel);

        planeJlist.setBounds(40, 50, 400, 300);
        planeListPanel.add(planeJlist);

        windowLbl.setText("Listado de flota de la empresa");
        windowLbl.setBounds(40, 10, 150, 25);
        planeListPanel.add(windowLbl);

        backPageBtn.setText("Volver");
        backPageBtn.setBounds(40, 400, 100, 25);
        planeListPanel.add(backPageBtn);

        backPageBtn.addActionListener(new ActionListener() {

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
