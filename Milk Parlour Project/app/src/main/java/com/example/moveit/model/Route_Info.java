package com.example.moveit.model;

public class Route_Info {

    String route_id;
    String bus_id;
    String origin;
    String destination;
    String bus_name;
    String bus_number;
    long pickup_date_time;
    long dropping_date_time;

    public long getPickup_date_time() {
        return pickup_date_time;
    }

    public void setPickup_date_time(long pickup_date_time) {
        this.pickup_date_time = pickup_date_time;
    }

    public long getDropping_date_time() {
        return dropping_date_time;
    }

    public void setDropping_date_time(long dropping_date_time) {
        this.dropping_date_time = dropping_date_time;
    }



    public String getRoute_id() {
        return route_id;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public String getBus_id() {
        return bus_id;
    }

    public void setBus_id(String bus_id) {
        this.bus_id = bus_id;
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


    public String getBus_name() {
        return bus_name;
    }

    public void setBus_name(String bus_name) {
        this.bus_name = bus_name;
    }

    public String getBus_number() {
        return bus_number;
    }

    public void setBus_number(String bus_number) {
        this.bus_number = bus_number;
    }
}
