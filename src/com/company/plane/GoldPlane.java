package com.company.plane;

public class GoldPlane extends Plane {
    private static double fare = 6000;

    public GoldPlane(){}

    public GoldPlane(double fuelCapacity, double costKm, double maxSpeed, String engineType, int passengers, Boolean wifi) {
        super("Gold", fuelCapacity, costKm, maxSpeed, engineType, passengers, fare, true, wifi);
    }



    public static double getFare() {
        return fare;
    }

    public static void setFare(double fare) {
        GoldPlane.fare = fare;
    }

    private String getWifiString(){
        if(getWifi() == true){
            return "Sí";
        } else {
            return "No";
        }
    }

    @Override
    public String toString(){
        return "Gold - Catering: Sí - Wifi: " + this.getWifiString() +
                " - Capacidad: " + super.getPassengerCapacity() + " personas";
    }
}