package com.company.main;

import com.company.company.Company;
import com.company.flight.Flight;
import com.company.user.User;

import javax.swing.*;
import java.util.List;

public class FlightListWindow extends JFrame{
    private JPanel flightListPanel;
    private JButton showListBtn;
    private JList flightJlist;
    DefaultListModel listModel = new DefaultListModel();

    public FlightListWindow(){
        super("Lista de Vuelos Programados");

        Company company = Company.getCompany();
        List<Flight> flights = company.getFlights();
        for(Flight f : flights){
            listModel.addElement(f);
        }

        flightJlist = new JList(listModel);


        setContentPane(flightJlist);



    }

}
