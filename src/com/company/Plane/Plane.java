package com.company.Plane;

public class Plane {
    private double fuelCapacity;
    private double costKm;
    private double maxSpeed;
    private String engineType;

    public Plane(){

    }

    public Plane(double fuelCapacity, double costKm, double maxSpeed, String engineType) {
        this.fuelCapacity = fuelCapacity;
        this.costKm = costKm;
        this.maxSpeed = maxSpeed;
        this.engineType = engineType;
    }
}
