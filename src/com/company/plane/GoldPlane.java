package com.company.plane;

public class GoldPlane extends Plane {
    private Boolean catering;
    private Boolean wifi;

    public GoldPlane(double fuelCapacity, double costKm, double maxSpeed, String engineType, int passengers, Boolean wifi) {
        super(fuelCapacity, costKm, maxSpeed, engineType, passengers);
        this.catering = true;
        this.wifi = wifi;
    }
}