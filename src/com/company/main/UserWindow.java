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

                boolean error = false;
                String name = nameTxt.getText();
                String surname = surnameTxt.getText();
                String dni = dniTxt.getText();
                String age = ageTxt.getText();

                try {

                    if(!nameTxt.getText().isEmpty() && !surnameTxt.getText().isEmpty() && !dniTxt.getText().isEmpty() && !ageTxt.getText().isEmpty()) {

                        //Method to create an user --> first validate non empty fields
                        createUser(name, surname, dni, age);

                    }

                    throw new CompleteUserFieldsException(nameTxt, surnameTxt, dniTxt, ageTxt);

                }catch(CompleteUserFieldsException ex){
                    error = true;
                    System.out.println(ex.getMessage());
                    if(!ex.getMessage().isEmpty()){
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

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

    private void createUser(String name, String surname, String userDni, String userAge){
        boolean error = false;
        int dni, age;

        try {

            //In next conditions verify that both name and surname inputs don't have numbers

            if(stringHasNumber(name)){
                error = true;
                JOptionPane.showMessageDialog(null, "El nombre ingresado no es válido.");
            }

            if(stringHasNumber(surname)){
                error = true;
                JOptionPane.showMessageDialog(null, "El apellido ingresado no es válido.");
            }

            dni = Integer.parseInt(userDni);
            age = Integer.parseInt(userAge);

        } catch (NumberFormatException ex){
            error = true;
            dni = 0;
            age = 0;
            JOptionPane.showMessageDialog(null, "Corrija campos DNI y/o Edad, por favor.");
        }

        //If not error --> create an user
        if(!error){
            User user = new User(name, surname, dni, age);
            Company company = Company.getCompany();
            company.addUser(user);
            company.showUsers();
        }
    }

    private boolean stringHasNumber(String string){

        for(char c : string.toCharArray()){
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

}
