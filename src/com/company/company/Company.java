package com.company.company;

import com.company.flight.Flight;
import com.company.plane.Plane;
import com.company.user.User;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<User>users;
    private List<Plane>planes;
    private List<Flight>flights;

    public Company(){
        this.users = new ArrayList<>();
        this.planes = new ArrayList<>();
        this.flights = new ArrayList<>();
    }



    //USERS

    public void addUser(User u){
        users.add(u);
    }

    public void deleteUser(User u){
        users.remove(u);
    }

    public void showUserList(){
        for(User u : users){
            System.out.println(u);
        }
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

    public Plane getPlaneById(String planeId){
        Plane selectedPlane = new Plane();
        for(Plane p : planes){
            if(p.getId().equals(planeId)){
                selectedPlane = p;
            }
        }
        return selectedPlane;
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


}
