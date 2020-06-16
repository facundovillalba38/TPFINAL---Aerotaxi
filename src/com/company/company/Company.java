package com.company.company;

import com.company.data.PersistData;
import com.company.flight.Flight;
import com.company.plane.Plane;
import com.company.user.User;


import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<User>users;
    private List<Plane>planes;
    private List<Flight>flights;
    private static Company company;

    private Company(){
        this.users = new ArrayList<>();
        this.planes = new ArrayList<>();
        this.flights = new ArrayList<>();
    }

    public static Company getCompany(){
        if(company == null){
            company = new Company();
        }
        return company;
    }



    //USERS

    public void addUser(User u){
        users.add(u);

        //Persist user information
        PersistData persistData = new PersistData();
        persistData.User2Json(users, "user.json");
    }

    public void deleteUser(User u){
        users.remove(u);
    }

    public void showUsers(){
        for(User u : users){
            System.out.println(u);
        }
    }

    public List<User> getUsers() {
        List<User>usersFromFile = new ArrayList<User>();
        //Get persisted user information
        PersistData persistData = new PersistData();
        usersFromFile = persistData.Json2User("user.json");
        return usersFromFile;
    }




    //PLANES

    public void addPlane(Plane p){
        planes.add(p);
    }

    public void deletePlane(Plane p){
        planes.remove(p);
    }

    public void showPlaneList(){
        for(Plane p : planes){
            System.out.println(p);
        }
    }

    public void showFreePlaneList(){
        for(Plane p : planes){
            if(p.isBusy() == false){
                System.out.println(p);
            }
        }
    }

    public Plane getPlaneById(int planeId){
        Plane selectedPlane = new Plane();
        for(Plane p : planes){
            if(p.getId() == planeId){
                selectedPlane = p;
            }
        }
        return selectedPlane;
    }

    public List<Plane> getPlanes() {
        return planes;
    }




    //FLIGHTS

    public void addFlight(Flight f){
        flights.add(f);
    }

    public void deleteFlight(Flight f){
        flights.remove(f);
    }

    public void showFlightList(){
        for(Flight f : flights){
            System.out.println(f);
        }
    }

    public Flight getFlightByUserDNI(int dni){
        Flight f = new Flight();
        for(Flight flight : flights){
            if(flight.getClient().getDni() == dni){
                f = flight;
            }
        }
        return f;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
