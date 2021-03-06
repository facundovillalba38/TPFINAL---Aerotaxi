package com.company.flight;

import com.company.company.Company;
import com.company.plane.Plane;
import com.company.user.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Flight {
    private int id;
    private User client;
    private LocalDate departureDate;
    private Destination originDestination;
    private Destination finalDestination;
    private int passengers;
    private Plane planeCategory;
    private double totalCost;

    public Flight() {}

    public void setId(){
        this.id = getLastFlightId();
    }

    private int getLastFlightId(){
        int lastId = 0;

        Company company = Company.getCompany();
        List<Flight> flights = company.getFlights();

        if(flights.size() > 0){
            lastId = flights.get(flights.size()-1).getID();
            lastId++;
        }

        return lastId;
    }

    public int getID(){
        return this.id;
    }

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
        int planeId = scanner.nextInt();
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

    public void bookFlightSwing(Company c, User u, LocalDate date, Destination origin, Destination destiny, int passengers, Plane plane){
        this.setClient(u);
        this.setDepartureDate(date);
        this.setOriginDestination(origin);
        this.setFinalDestination(destiny);
        this.setPassengers(passengers);
        this.setPlaneCategory(plane);
        this.calculateTotalCost();
        c.addFlight(this);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "ID: " + this.getID() +
                "\n- " + this.getClient().getSurname() +
                "\n - " + this.getDepartureDate() +
                "\n De: " + this.getOriginDestination() +
                "\n A: " + this.getFinalDestination() +
                "\n $ " + this.getTotalCost();
    }
}





