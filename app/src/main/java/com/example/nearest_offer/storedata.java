package com.example.nearest_offer;

public class storedata {
public String lati,longi,vicinity,username,name;
public Double ratng;

    public storedata(String lati, String longi, String vicinity, String username, String name, Double ratng) {
        this.lati = lati;
        this.longi = longi;
        this.vicinity = vicinity;
        this.username = username;
        this.name = name;
        this.ratng = ratng;
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

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRatng() {
        return ratng;
    }

    public void setRatng(Double ratng) {
        this.ratng = ratng;
    }
}
