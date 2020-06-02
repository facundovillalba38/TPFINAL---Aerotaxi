package com.company.plane;

public class GoldPlane extends Plane {
    private Boolean catering;
    private Boolean wifi;
    private static double fare = 6000;

    public GoldPlane(double fuelCapacity, double costKm, double maxSpeed, String engineType, int passengers, Boolean wifi) {
        super(fuelCapacity, costKm, maxSpeed, engineType, passengers, fare);
        this.catering = true;
        this.wifi = wifi;
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

    public static double getFare() {
        return fare;
    }

    public static void setFare(double fare) {
        GoldPlane.fare = fare;
    }
}