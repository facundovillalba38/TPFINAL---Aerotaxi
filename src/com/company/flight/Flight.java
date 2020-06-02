package com.company.flight;

import com.company.plane.Plane;
import com.company.user.User;

import java.time.LocalDate;

public class Flight {
    private User client;
    private LocalDate departureDate;
    private Destination originDestination;
    private Destination finalDestination;
    private int passengers;
    private Plane planeCategory;
    private double totalCost;

    public Flight() {}

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public Destination getOriginDestination() {
        return originDestination;
    }

    public void setOriginDestination(Destination originDestination) {
        this.originDestination = originDestination;
    }

    public Destination getFinalDestination() {
        return finalDestination;
    }

    public void setFinalDestination(Destination finalDestination) {
        // Validamos que la ciudad de origen y destino no sean la misma
        if(this.originDestination != finalDestination){
            this.finalDestination = finalDestination;
        }
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        // Si los pasajeros exceden la capacidad del avion
        if(this.planeCategory.getPassengerCapacity() < passengers){
            System.out.println("No tenemos aviones disponibles con esa capacidad de pasajeros");
        }
        this.passengers = passengers;
    }

    public Plane getPlaneCategory() {
        return planeCategory;
    }

    public void setPlaneCategory(Plane planeCategory) {
        this.planeCategory = planeCategory;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void calculateTotalCost(){
        this.totalCost = (calculateDistance(this.originDestination, this.finalDestination)*this.planeCategory.getCostKm()) + (this.passengers * 3500) + this.planeCategory.getPlaneFare();
    }

    public double calculateDistance(Destination destination1, Destination destination2){
        double distance = 0.0;
        if((destination1.equals(originDestination.BUENOSAIRES) && destination2.equals(finalDestination.CORDOBA))||
                (destination1.equals(originDestination.CORDOBA) && destination2.equals(finalDestination.BUENOSAIRES))){
            distance = 695;
        }else if((destination1.equals(originDestination.BUENOSAIRES) && destination2.equals(finalDestination.SANTIAGODECHILE))||
                (destination1.equals(originDestination.SANTIAGODECHILE) && destination2.equals(finalDestination.BUENOSAIRES))){
            distance = 1400;
        }else if((destination1.equals(originDestination.BUENOSAIRES) && destination2.equals(finalDestination.MONTEVIDEO))||
                (destination1.equals(originDestination.MONTEVIDEO) && destination2.equals(finalDestination.BUENOSAIRES))){
            distance = 950;
        }else if((destination1.equals(originDestination.CORDOBA) && destination2.equals(finalDestination.MONTEVIDEO))||
                (destination1.equals(originDestination.MONTEVIDEO) && destination2.equals(finalDestination.CORDOBA))){
            distance = 1190;
        }else if((destination1.equals(originDestination.CORDOBA) && destination2.equals(finalDestination.SANTIAGODECHILE))||
                (destination1.equals(originDestination.SANTIAGODECHILE) && destination2.equals(finalDestination.CORDOBA))){
            distance = 1050;
        }else if((destination1.equals(originDestination.MONTEVIDEO) && destination2.equals(finalDestination.SANTIAGODECHILE))||
                (destination1.equals(originDestination.SANTIAGODECHILE) && destination2.equals(finalDestination.MONTEVIDEO))){
            distance = 2100;
        }

        return distance;
    }



}





