package com.company.main;

import javax.swing.*;

public class CompleteUserFieldsException extends Exception {

    private JTextField userNameTxt;
    private JTextField userSurnameTxt;
    private JTextField userDniTxt;
    private JTextField userAgeTxt;

    public CompleteUserFieldsException(JTextField userNameTxt, JTextField userSurnameTxt, JTextField userDniTxt, JTextField userAgeTxt) {
        this.userNameTxt = userNameTxt;
        this.userSurnameTxt = userSurnameTxt;
        this.userDniTxt = userDniTxt;
        this.userAgeTxt = userAgeTxt;
    }

    public JTextField getUserNameTxt() {
        return userNameTxt;
    }

    public JTextField getUserSurnameTxt() {
        return userSurnameTxt;
    }

    public JTextField getUserDniTxt() {
        return userDniTxt;
    }

    public JTextField getUserAgeTxt() {
        return userAgeTxt;
    }

    @Override
    public String getMessage(){
        String message = "";

        if(this.getUserNameTxt().getText().isEmpty()){
            message += "Debes introducir un nombre.\n";
        }

        if(this.getUserSurnameTxt().getText().isEmpty()){
            message += "Debes introducir un apellido.\n";
        }

        if(this.getUserDniTxt().getText().isEmpty()){
            message += "Debes introducir un DNI.\n";
        }

        if(this.getUserAgeTxt().getText().isEmpty()){
            message += "Debes introducir una edad.\n";
        }

        return message;
    }
}
