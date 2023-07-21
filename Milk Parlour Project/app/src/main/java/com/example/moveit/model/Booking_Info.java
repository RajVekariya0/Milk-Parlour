package com.example.moveit.model;

public class Booking_Info {
    String bus_id;
    String u_id;
    String trip_id;
    long trip_date;
    int no_of_seat;
    int seat_number;
    float total_amount;

    public String getBus_id() {
        return bus_id;
    }

    public void setBus_id(String bus_id) {
        this.bus_id = bus_id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public long getTrip_date() {
        return trip_date;
    }

    public void setTrip_date(long trip_date) {
        this.trip_date = trip_date;
    }

    public int getNo_of_seat() {
        return no_of_seat;
    }

    public void setNo_of_seat(int no_of_seat) {
        this.no_of_seat = no_of_seat;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }
}
