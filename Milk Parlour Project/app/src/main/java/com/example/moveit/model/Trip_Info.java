package com.example.moveit.model;

public class Trip_Info {

    String trip_id;
    String bus_id;
    String route_id;
    float price;
    long pickup_date_time;
    long dropping_date_time;

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public String getBus_id() {
        return bus_id;
    }

    public void setBus_id(String bus_id) {
        this.bus_id = bus_id;
    }

    public String getRoute_id() {
        return route_id;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

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
}
