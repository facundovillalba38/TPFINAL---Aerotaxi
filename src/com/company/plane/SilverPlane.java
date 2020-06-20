package com.company.plane;

public class SilverPlane extends Plane{
    private static double fare = 4000;

    public SilverPlane(double fuelCapacity, double costKm, double maxSpeed, String engineType, int passengers, boolean wifi) {
        super("Silver", fuelCapacity, costKm, maxSpeed, engineType, passengers, fare, true, wifi);

    }

    public static double getFare() {
        return fare;
    }

    public static void setFare(double fare) {
        SilverPlane.fare = fare;
    }

    @Override
    public String toString(){
        return "Silver - Catering: Sí - Wifi: No" +
                " - Capacidad: " + super.getPassengerCapacity() + " personas";
    }
}


