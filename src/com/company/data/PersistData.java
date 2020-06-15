package com.company.data;

import com.company.flight.Destination;
import com.company.flight.Flight;
import com.company.plane.Plane;
import com.company.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.time.LocalDate;
import java.util.Date;

public class PersistData {
    private String path = "C:\\Users\\faaaa\\Desktop\\Facu\\Programacion - UTN\\SEGUNDO AÑO\\PRIMER CUATRI\\Programacion y Laboratorio III\\Práctico\\TP2 - Aerotaxi\\archivos";

    public PersistData() {}

    public String getPath() {
        return path;
    }

    public void User2Json(User user, String file){
        File f = new File(this.path + "\\"+file);
        ObjectMapper mapper = new ObjectMapper();
        try{
            if(!f.exists()){
                System.out.println("Creando Archivo...");
                f.createNewFile();
                System.out.println("Archivo "+f.getName()+" creado");
            }
            mapper.writeValue(f, user);

        }catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void Json2User(String file){
        File f = new File(this.path + "\\"+file);
        ObjectMapper mapper = new ObjectMapper();
        try{
            if(!f.exists()){
                System.out.println("El archivo que quiere leer no existe");
            }else{
                User user = mapper.readValue(f, User.class);
                System.out.println("JACKSON: "+user.toString());
            }
        }catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void Plane2Json(Plane plane, String file){
        File f = new File(this.path + "\\"+file);
        ObjectMapper mapper = new ObjectMapper();
        try{
            if(!f.exists()){
                System.out.println("Creando Archivo...");
                f.createNewFile();
                System.out.println("Archivo "+f.getName()+" creado");
            }
            mapper.writeValue(f, plane);

        }catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void Json2Plane(String file){
        File f = new File(this.path + "\\"+file);
        ObjectMapper mapper = new ObjectMapper();
        try{
            if(!f.exists()){
                System.out.println("El archivo que quiere leer no existe");
            }else{
                Plane plane = mapper.readValue(f, Plane.class);
                System.out.println("JACKSON: "+plane.toString());
            }
        }catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void Flight2Json(Flight flight, String file){
        File f = new File(this.path + "\\"+file);
        ObjectMapper mapper = new ObjectMapper();
        try{
            if(!f.exists()){
                System.out.println("Creando Archivo...");
                f.createNewFile();
                System.out.println("Archivo "+f.getName()+" creado");
            }
            mapper.writeValue(f, flight);

        }catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void Json2Flight(String file){
        File f = new File(this.path + "\\"+file);
        ObjectMapper mapper = new ObjectMapper();
        try{
            if(!f.exists()){
                System.out.println("El archivo que quiere leer no existe");
            }else{
                Flight flight = mapper.readValue(f, Flight.class);
                System.out.println("JACKSON: "+flight.toString());
            }
        }catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public static void main (String args[]){
        PersistData persistData = new PersistData();
        File f = new File(persistData.getPath());




            User user = new User("facundo", "villalba", 202020, 20);

            Plane plane = new Plane(10, 10, 10, "hgoas", 10, 10);

            Flight flight = new Flight();
            flight.setClient(user);
            //LocalDate date = new Date(LocalDate.now());
            //flight.setDepartureDate();
            flight.setOriginDestination(Destination.BUENOSAIRES);
            flight.setFinalDestination(Destination.CORDOBA);
            flight.setPassengers(20);
            flight.setPlaneCategory(plane);



            //persistData.User2Json(user, "user.json");
            //persistData.Json2User("user.json");
            //persistData.Plane2Json(plane, "plane.json");
            //persistData.Json2Plane("plane.json");
            persistData.Flight2Json(flight, "flight.json");
            persistData.Json2Flight("flight.json");






    }



}
