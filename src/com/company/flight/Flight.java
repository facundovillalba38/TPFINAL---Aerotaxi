package com.company.flight;

import com.company.company.Company;
import com.company.plane.Plane;
import com.company.user.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

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
        if(this.getPlaneCategory().getPassengerCapacity()<passengers){
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

    private void calculateTotalCost(){
        this.totalCost = (calculateDistance(this.originDestination, this.finalDestination)*this.planeCategory.getCostKm()) + (this.passengers * 3500) + this.planeCategory.getPlaneFare();
    }


    private double calculateDistance(Destination destination1, Destination destination2){
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

    public void bookFlight(Company c, User u){

        this.setClient(u);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresar fecha de viaje (yyyy-mm-dd):");
        String departureDate = scanner.nextLine();
        this.setDepartureDate(LocalDate.parse(departureDate));


        System.out.println("Ingrese origen del viaje: (Destinos: BUENOSAIRES, CORDOBA, SANTIAGODECHILE, MONTEVIDEO)");
        String originCity = scanner.nextLine();
        this.setOriginDestination(Destination.valueOf(originCity.toUpperCase()));

        System.out.println("Ingrese destino del viaje: (Destinos: BUENOSAIRES, CORDOBA, SANTIAGODECHILE, MONTEVIDEO)");
        String destinyCity = scanner.nextLine();
        this.setFinalDestination(Destination.valueOf(destinyCity.toUpperCase()));


        System.out.println("Listado flota:");
        c.showPlaneList();

        System.out.println("Ingrese ID del avión:");
        String planeId = scanner.next();
        this.setPlaneCategory(c.getPlaneById(planeId));

        /*System.out.println("Ingrese la cantidad de acompañantes:");
        int companion = scanner.nextInt();
        companion++;
        this.setPassengers(companion);*/

        int companion = 0;
        do {

             System.out.println("Ingrese la cantidad de acompañantes: pasajeros:"+getPlaneCategory().toString());
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" no es un numero valido.\n", input);
            }
            companion = scanner.nextInt();
            companion++;
            if(companion > this.getPlaneCategory().getPassengerCapacity()){
                System.out.println("La cantidad de acompañantes no puede superar la capacidad maxima de pasajeros del avion");
            }
        } while (companion > this.getPlaneCategory().getPassengerCapacity());
        this.setPassengers(companion);

        this.calculateTotalCost();

        c.addFlight(this);
    }


}





