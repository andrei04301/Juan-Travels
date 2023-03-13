package com.example.topjuantech_ojt;

import java.io.Serializable;

public class User implements Serializable {
    String EstablishmentName , City, AdminID,
            EstablishmentType, Firstname, Lastname,
            PhoneNumber, Email, Status;

    public User(){}

    public User(String establishmentName, String city, String adminID,
                String establishmentType, String firstname, String lastname,
                String phoneNumber, String status) {
        EstablishmentName = establishmentName;
        City = city;
        AdminID = adminID;
        EstablishmentType = establishmentType;
        Firstname = firstname;
        Lastname= lastname;
        PhoneNumber= phoneNumber;
        Status=status;


    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
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
