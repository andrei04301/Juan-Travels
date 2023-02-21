package com.example.topjuantech_ojt;

import java.io.Serializable;

public class User implements Serializable {
    String EstablishmentName , City, Id, Spot;

    public User(){}

    public User(String establishmentName, String city, String id, String spot) {
        EstablishmentName = establishmentName;
        City = city;
        Id = id;
        Spot = spot;
    }

    public String getEstablishmentName() {
        return EstablishmentName;
    }

    public void setEstablishmentName(String establishmentName) {
        EstablishmentName = establishmentName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getSpot() {
        return Spot;
    }

    public void setSpot(String spot) {
        Spot = spot;
    }
}
