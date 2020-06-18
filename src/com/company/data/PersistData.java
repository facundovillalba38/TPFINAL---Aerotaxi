package com.company.data;

import com.company.flight.Destination;
import com.company.flight.Flight;
import com.company.plane.Plane;
import com.company.user.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

public class PersistData {
    //private String path = "C:\\Users\\faaaa\\Desktop\\Facu\\Programacion - UTN\\SEGUNDO AÑO\\PRIMER CUATRI\\Programacion y Laboratorio III\\Práctico\\TP2 - Aerotaxi\\archivos";
    private String path = "archivos";

    public PersistData() {}

    public String getPath() {
        return path;
    }

    public void User2Json(List<User> users, String file){
        File f = new File(this.path + "\\"+file);
        ObjectMapper mapper = new ObjectMapper();
        try{
            if(!f.exists()){
                System.out.println("Creando Archivo...");
                f.createNewFile();
                System.out.println("Archivo "+f.getName()+" creado");
            }
            mapper.writeValue(f, users);

        }catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<User> Json2User(String file){
        File f = new File(this.path + "\\"+file);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        List<User> users = new ArrayList<>();
        //User user = new User();
        try{
            if(!f.exists()){
                System.out.println("El archivo que quiere leer no existe");
            }else{

                users = mapper.readValue(f, new TypeReference<List<User>>(){});

                System.out.println("JACKSON: "+users.toString());
            }
        }catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return users;
    }

    public void Plane2Json(List<Plane>planes, String file){
        File f = new File(this.path + "\\"+file);
        ObjectMapper mapper = new ObjectMapper();
        try{
            if(!f.exists()){
                System.out.println("Creando Archivo...");
                f.createNewFile();
                System.out.println("Archivo "+f.getName()+" creado");
            }
            mapper.writeValue(f, planes);

        }catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Plane> Json2Plane(String file){
        File f = new File(this.path + "\\"+file);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        List<Plane>planes = new ArrayList<>();
        try{
            if(!f.exists()){
                System.out.println("El archivo que quiere leer no existe");
            }else{
                planes = mapper.readValue(f, new TypeReference<List<Plane>>(){});
                System.out.println("JACKSON: "+planes.toString());
            }
        }catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return planes;
    }

    public void Flight2Json(List<Flight> flights, String file){
        File f = new File(this.path + "\\"+file);
        ObjectMapper mapper = new ObjectMapper();

        try{
            if(!f.exists()){
                System.out.println("Creando Archivo...");
                f.createNewFile();
                System.out.println("Archivo "+f.getName()+" creado");
            }
            mapper.writeValue(f, flights);

        }catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void Json2Flight(String file){
        File f = new File(this.path + "\\"+file);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        List<Flight> flights = new ArrayList<>();
        try{
            if(!f.exists()){
                System.out.println("El archivo que quiere leer no existe");
            }else{
                flights = mapper.readValue(f, new TypeReference<List<Flight>>(){});
                System.out.println("JACKSON: "+flights.toString());
            }
        }catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }


    /*public static void main (String args[]){
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






    }*/



}
