package com.company.data;

import com.company.company.Company;
import com.company.flight.Destination;
import com.company.flight.Flight;
import com.company.plane.Plane;
import com.company.user.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

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
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

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

    public List<Flight> Json2Flight(String file){
        File f = new File(this.path + "\\"+file);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
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
        return flights;
    }


    public void removeJsonFlight(String file, List<Flight>flightList){
        File f = new File(this.path + "\\"+file);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        try{
            if(!f.exists()){
                System.out.println("El archivo que quiere leer no existe");
            }else{
                mapper.writeValue(f, flightList);
            }
        }catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

    }



}
