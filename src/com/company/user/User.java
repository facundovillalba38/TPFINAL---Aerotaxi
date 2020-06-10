package com.company.user;

import com.company.company.Company;
import com.company.flight.Flight;

import java.util.Scanner;

public class User {
    private String name;
    private String surname;
    private int dni;
    private int age;

    public User(){}

    public User(String name, String surname, int dni, int age) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void registerUser(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name: ");
        String name = scanner.nextLine();
        this.setName(name);

        System.out.println("Surname: ");
        String surname = scanner.nextLine();
        this.setSurname(surname);

        System.out.println("DNI: ");
        int dni = scanner.nextInt();
        this.setDni(dni);

        System.out.println("Age: ");
        int age = scanner.nextInt();
        this.setAge(age);
    }

    public void registerUserSwing(String name, String surname, int dni, int age){
        this.setName(name);
        this.setSurname(surname);
        this.setDni(dni);
        this.setAge(age);
    }

    public void hireFlight(Company c){

        Flight f = new Flight();
        f.bookFlight(c, this);
    }

    public void cancelFlight(){

        //TODO cancell flight
    }

    @Override
    public String toString(){
        return this.getName() + " " + this.getSurname() + " - DNI: " + this.getDni()
                + " - Edad: " + this.getAge();
    }
}

