package com.company.plane;

public class SilverPlane extends Plane{
    private Boolean catering;

    public SilverPlane(double fuelCapacity, double costKm, double maxSpeed, String engineType, int passengers) {
        super(fuelCapacity, costKm, maxSpeed, engineType, passengers);
        this.catering = true;
    }
}


