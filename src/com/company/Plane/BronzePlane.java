package com.company.plane;

public class BronzePlane extends Plane {
    private static double fare = 3000;

    public BronzePlane(double fuelCapacity, double costKm, double maxSpeed, String engineType, int passengers) {
        super(fuelCapacity, costKm, maxSpeed, engineType, passengers, fare, false, false);
    }

    public static double getFare() {
        return fare;
    }

    public static void setFare(double fare) {
        BronzePlane.fare = fare;
    }

    @Override
    public String toString(){
        return "Bronze - Catering: No - Wifi: No" +
                " - Capacidad: " + super.getPassengerCapacity() + " personas";
    }
}
