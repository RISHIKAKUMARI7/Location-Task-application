package com.example.nearest_offer;

public class Myoffer {

    String name,number,address,offer,lat,longi;

    public Myoffer() {
    }

    public Myoffer(String name, String number, String address, String offer, String lat, String longi) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.offer = offer;
        this.lat = lat;
        this.longi = longi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongi() {
        return longi;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }
}
