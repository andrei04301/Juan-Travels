package com.example.topjuantech_ojt;

import java.io.Serializable;

public class UserDetails implements Serializable {
    String  Firstname, Lastname,
            PhoneNumber, Email, Status;
    public UserDetails(){}
    public UserDetails(String firstname, String lastname,
                String email, String phoneNumber, String status) {
        Firstname = firstname;
        Lastname= lastname;
        Email=email;
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
}
