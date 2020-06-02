package com.company.plane;

public class Plane {
    private double fuelCapacity;
    private double costKm;
    private double maxSpeed;
    private String engineType;
    private int passengerCapacity;
    private double planeFare;

    public Plane(){}

    public Plane(double fuelCapacity, double costKm, double maxSpeed, String engineType, int passengers, double planeFare) {
        this.fuelCapacity = fuelCapacity;
        this.costKm = costKm;
        this.maxSpeed = maxSpeed;
        this.engineType = engineType;
        this.passengerCapacity = passengers;
        this.planeFare = planeFare;
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
}
