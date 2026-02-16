package com.example.demo.Model;

public class Vehicle {
    int id;
    String licensePlate;
    VehicleType type;
    String ownerCity;
    VehicleStatus status;
   public Vehicle(){}
    public Vehicle(int id, String licensePlate, VehicleType type, String ownerCity, VehicleStatus status) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.type = type;
        this.ownerCity = ownerCity;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }

    public String getOwnerCity() {
        return ownerCity;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public void setOwnerCity(String ownerCity) {
        this.ownerCity = ownerCity;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }
    public String toString(){
       return id + "|" + licensePlate + "|" + type + "|" + ownerCity + "|" + status;
    }
}
