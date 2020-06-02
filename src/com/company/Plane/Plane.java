package com.company.plane;

public class Plane {
    private double fuelCapacity;
    private double costKm;
    private double maxSpeed;
    private String engineType;
    private int passengerCapacity;
    private double planeFare;

    public Plane(){

    }

    public Plane(double fuelCapacity, double costKm, double maxSpeed, String engineType) {
        this.fuelCapacity = fuelCapacity;
        this.costKm = costKm;
        this.maxSpeed = maxSpeed;
        this.engineType = engineType;
    }
}
