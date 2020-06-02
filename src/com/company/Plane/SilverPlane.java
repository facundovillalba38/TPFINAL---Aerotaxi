package com.company.Plane;

public class SilverPlane extends Plane{
    private Boolean catering;

    public SilverPlane(double fuelCapacity, double costKm, double maxSpeed, String engineType) {
        super(fuelCapacity, costKm, maxSpeed, engineType);
        this.catering = true;
    }
}


