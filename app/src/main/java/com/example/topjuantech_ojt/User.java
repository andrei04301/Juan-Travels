package com.example.topjuantech_ojt;

import java.io.Serializable;

public class User implements Serializable {
    String EstablishmentName , City, AdminID, EstablishmentType;

    public User(){}

    public User(String establishmentName, String city, String adminID, String establishmentType) {
        EstablishmentName = establishmentName;
        City = city;
        AdminID = adminID;
        EstablishmentType = establishmentType;
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

    public String getAdminID() {
        return AdminID;
    }

    public void setAdminID(String adminID) {
        AdminID = adminID;
    }

    public String getEstablishmentType() {
        return EstablishmentType;
    }

    public void setEstablishmentType(String spot) {
        EstablishmentType = EstablishmentType;
    }
}
