package com.example.moveit.model;

public class Mysubitems {

    private String origin;
    private String destination;
    private String bustime;
    private String date;
    private String journyhours;

    public Mysubitems(String origin,String destination,String bustime,String date,String journyhours) {
        this.origin = origin;
        this.destination = destination;
        this.bustime = bustime;
        this.date = date;
        this.journyhours = journyhours;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBustime() {
        return bustime;
    }

    public void setBustime(String bustime) {
        this.bustime = bustime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getJournyhours() {
        return journyhours;
    }

    public void setJournyhours(String journyhours) {
        this.journyhours = journyhours;
    }
}
