package com.example.nearest_offer;

public class mytask {
    String name,description,address,lati,longi;

    public mytask(String name, String description, String address, String lati, String longi) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.lati = lati;
        this.longi = longi;
    }

    public mytask() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLati() {
        return lati;
    }

    public void setLati(String lati) {
        this.lati = lati;
    }

    public String getLongi() {
        return longi;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }
}
