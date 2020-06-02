package com.company.Plane;

public class GoldPlane extends Plane {
    private Boolean catering;
    private Boolean wifi;

    public GoldPlane(double fuelCapacity, double costKm, double maxSpeed, String engineType, Boolean wifi) {
        super(fuelCapacity, costKm, maxSpeed, engineType);
        this.catering = true;
        this.wifi = wifi;
    }
}