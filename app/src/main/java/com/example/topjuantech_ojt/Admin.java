package com.example.topjuantech_ojt;

import java.io.Serializable;

public class Admin implements Serializable {
    String ProductName , ProductPrice, Id, Spot;

    public Admin(){}

    public Admin(String productName, String productPrice, String id, String spot) {
        ProductName = productName;
        ProductPrice = productPrice;
        Id = id;
        Spot = spot;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
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
