package com.company.main;

import com.company.company.Company;
import com.company.flight.Flight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FlightListWindow extends JFrame{
    private JPanel flightListPanel = new JPanel();
    private JLabel titleLbl = new JLabel();
    private JList flightList;
    DefaultListModel listModel = new DefaultListModel();
    private JButton backPageBtn = new JButton();
    private JButton cancelFlightBtn = new JButton();
    private JLabel cancelFlightLbl = new JLabel();
    private JComboBox flightToCancel;

    public FlightListWindow(){
        super("Lista de Vuelos Programados");

        flightListPanel.setLayout(null);
        this.getContentPane().add(flightListPanel);

        setWindow();

    }




    private void setWindow(){

        // TITLE LABEL

        titleLbl.setText("Listado de Vuelos");
        titleLbl.setBounds(40, 10, 100, 25);
        flightListPanel.add(titleLbl);

        Company company = Company.getCompany();

        // FLIGHTS LIST

        List<Flight> flights = company.getFlights();
        reloadList();

        // CANCELL FLIGHT SECTION

        cancelFlightLbl.setText("Cancelar vuelo:");
        cancelFlightLbl.setBounds(40, 330, 75, 25);
        flightListPanel.add(cancelFlightLbl);

        flightToCancel = new JComboBox(flights.toArray());
        flightToCancel.addItem("- Elija vuelo para cancelarlo -");
        flightToCancel.setSelectedItem("- Elija vuelo para cancelarlo -");
        flightToCancel.setBounds(40, 360, 300, 25);
        flightListPanel.add(flightToCancel);

        cancelFlightBtn.setText("Aceptar");
        cancelFlightBtn.setBounds(350, 360, 90, 25);
        flightListPanel.add(cancelFlightBtn);

        cancelFlightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Flight cancelFlight = (Flight) flightToCancel.getSelectedItem();
                Company company = Company.getCompany();
                company.deleteFlight(cancelFlight);

                //Show message
                String message = "El vuelo a nombre de " + cancelFlight.getClient().getName() + " " +
                        cancelFlight.getClient().getSurname() + " ha sido cancelado exitosamente.";

                JOptionPane.showMessageDialog(null, message, "Éxito", JOptionPane.INFORMATION_MESSAGE);

                //Return to main page
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

        // BACK PAGE BUTTON

        backPageBtn.setText("Volver");
        backPageBtn.setBounds(40, 410, 100, 25);
        flightListPanel.add(backPageBtn);

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

    private void reloadList(){
        Company company = Company.getCompany();

        List<Flight> flights = company.getFlights();

        for(Flight f : flights){
            listModel.addElement(f);
        }
        flightList = new JList(listModel);
        flightList.setBounds(40, 40, 400, 270);
        flightListPanel.add(flightList);
    }
}
