package com.company.plane;

public class SilverPlane extends Plane{
    private Boolean catering;
    private static double fare = 4000;

    public SilverPlane(double fuelCapacity, double costKm, double maxSpeed, String engineType, int passengers) {
        super(fuelCapacity, costKm, maxSpeed, engineType, passengers, fare);
        this.catering = true;
    }

    public Boolean getCatering() {
        return catering;
    }

    public void setCatering(Boolean catering) {
        this.catering = catering;
    }

    public static double getFare() {
        return fare;
    }

    public static void setFare(double fare) {
        SilverPlane.fare = fare;
    }
}


