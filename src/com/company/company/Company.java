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
        this.users = usersFromFile;
        return usersFromFile;
    }




    //PLANES

    public void addPlane(Plane p){
        planes.add(p);

        //Persist user information
        PersistData persistData = new PersistData();
        persistData.Plane2Json(planes, "plane.json");
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
        List<Plane>planesFromFile = new ArrayList<>();
        //Get persisted user information
        PersistData persistData = new PersistData();
        planesFromFile = persistData.Json2Plane("plane.json");
        this.planes = planesFromFile;
        return planesFromFile;

    }




    //FLIGHTS

    public void addFlight(Flight f){
        flights.add(f);

        PersistData persistData = new PersistData();
        persistData.Flight2Json(flights, "flight.json");
    }

    public void deleteFlight(Flight f){
        //Remove it from list
        this.flights.remove(getFlightById(f.getID()));

        //Open json file and remove it from there
        PersistData persistData = new PersistData();
        persistData.removeJsonFlight("flight.json", flights);
    }

    public void showFlightList(){
        for(Flight f : flights){
            System.out.println(f);
        }
    }

    public Flight getFlightById(int id){
        Flight f = new Flight();
        for(Flight flight : flights){
            if(flight.getID() == id){
                f = flight;
            }
        }
        return f;
    }

    public List<Flight> getFlights() {
        List<Flight>flightsFromFile = new ArrayList<>();

        //Get persisted user information
        PersistData persistData = new PersistData();
        flightsFromFile = persistData.Json2Flight("flight.json");
        this.flights = flightsFromFile;
        return flightsFromFile;
    }
}
