package com.company.main;

import javax.swing.*;

public class CompleteAllFieldsException extends Exception {

    private JRadioButton goldBtn;
    private JRadioButton bronzeBtn;
    private JRadioButton silverBtn;
    private JTextField fuelTxt;
    private JTextField speedTxt;
    private String engineTxt;
    private JTextField passengersTxt;
    private JRadioButton yesWifiBtn;
    private JRadioButton noWifiBtn;

    public CompleteAllFieldsException(JRadioButton goldBtn, JRadioButton bronzeBtn, JRadioButton silverBtn, JTextField fuelTxt, JTextField speedTxt, String engineTxt, JTextField passengersTxt, JRadioButton yesWifiBtn, JRadioButton noWifiBtn) {
        this.goldBtn = goldBtn;
        this.bronzeBtn = bronzeBtn;
        this.silverBtn = silverBtn;
        this.fuelTxt = fuelTxt;
        this.speedTxt = speedTxt;
        this.engineTxt = engineTxt;
        this.passengersTxt = passengersTxt;
        this.yesWifiBtn = yesWifiBtn;
        this.noWifiBtn = noWifiBtn;
    }

    public JRadioButton getGoldBtn() {
        return goldBtn;
    }

    public JRadioButton getBronzeBtn() {
        return bronzeBtn;
    }

    public JRadioButton getSilverBtn() {
        return silverBtn;
    }

    public boolean validatePlaneBtn(){
        boolean planeSelected;
        if(!getGoldBtn().isSelected() && !getSilverBtn().isSelected() && !getBronzeBtn().isSelected()){
            planeSelected = false;
        } else {
            planeSelected = true;
        }
        return planeSelected;
    }

    public JTextField getFuelTxt() {
        return fuelTxt;
    }

    public JTextField getSpeedTxt() {
        return speedTxt;
    }

    public String getEngineTxt() {
        return engineTxt;
    }

    public JTextField getPassengersTxt() {
        return passengersTxt;
    }

    public JRadioButton getYesWifiBtn() {
        return yesWifiBtn;
    }

    public JRadioButton getNoWifiBtn() {
        return noWifiBtn;
    }

    public boolean validateWifiBtn(){
        boolean wifi;
        if(!getYesWifiBtn().isSelected() && !getNoWifiBtn().isSelected()){
            wifi = false;
        } else wifi = true;
        return wifi;
    }

    @Override
    public String getMessage(){
        String message = "";

        if(validatePlaneBtn() == false){
            message += "Debes elegir un avión.\n";
        }

        if(goldBtn.isSelected()){
            if(validateWifiBtn() == false){
                message += "Debes seleccionar wifi.\n";
            }
        }


        if(getFuelTxt().getText().isEmpty()){
            message += "Debes completar la casilla de combustible.\n";
        }

        if(getSpeedTxt().getText().isEmpty()){
            message += "Debes completar la casilla de velocidad.\n";
        }

        if(getEngineTxt().isEmpty()){
            message += "Debes completar la casilla de motor.\n";
        }

        if(getPassengersTxt().getText().isEmpty()){
            message += "Debes completar la casilla de pasajeros.\n";
        }

        return message;
    }

}
