package com.company.plane;


import com.company.company.Company;

import java.util.List;

public class Plane {
    private int id;
    private double fuelCapacity;
    private double costKm;
    private double maxSpeed;
    private String engineType;
    private int passengerCapacity;
    private double planeFare;
    private boolean busy;
    private boolean catering;
    private boolean wifi;


    public Plane(){}

    public Plane(double fuelCapacity, double costKm, double maxSpeed, String engineType, int passengers, double planeFare, boolean catering, boolean wifi) {
        this.id = getLastPlaneId();
        this.fuelCapacity = fuelCapacity;
        this.costKm = costKm;
        this.maxSpeed = maxSpeed;
        this.engineType = engineType;
        this.passengerCapacity = passengers;
        this.planeFare = planeFare;
        this.catering = catering;
        this.wifi = wifi;
        this.busy = false;
    }

    private int getLastPlaneId(){
        int lastId = 0;

        Company company = Company.getCompany();
        List<Plane> planes = company.getPlanes();

        if(planes.size() > 0){
            lastId = planes.get(planes.size()-1).getId();
            lastId++;
        }

        return lastId;
    }

    public int getId(){
        return id;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getCostKm() {
        return costKm;
    }

    public void setCostKm(double costKm) {
        this.costKm = costKm;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public double getPlaneFare() {
        return planeFare;
    }

    public void setPlaneFare(double planeFare) {
        this.planeFare = planeFare;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public Boolean getCatering() {
        return catering;
    }

    public void setCatering(Boolean catering) {
        this.catering = catering;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    @Override
    public String toString(){
        return "Avión ID: " + this.getId() + " - Cantidad pasajeros máxima: " + this.getPassengerCapacity() +
                " - Ocupado: " + this.isBusy();
    }
}
