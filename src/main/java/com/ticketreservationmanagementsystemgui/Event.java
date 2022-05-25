package com.ticketreservationmanagementsystemgui;

public class Event  {
    String name;
    String place;
    String date;
    String start_time;
    String end_time;
    String description;
    int tickets;
    Event(String name,String place,String date,String start_time,String end_time,int tickets,String description){
        this.name= name;
        this.place=place;
        this.date=date;
        this.start_time=start_time;
        this.end_time = end_time;
        this.description=description;
        this.tickets=tickets;
    }

    Event(String name,String place,String date,String start_time,String end_time,int tickets){
        this.name= name;
        this.place=place;
        this.date=date;
        this.start_time=start_time;
        this.end_time = end_time;
        this.tickets=tickets;
    }
    void editevent(String name,String place,String date,String start_time,String end_time,int tickets,String description) {
        this.name= name;
        this.place=place;
        this.date=date;
        this.start_time=start_time;
        this.end_time = end_time;
        this.description=description;
        this.tickets=tickets;
    }

    @Override
    public String toString(){
        String event;
        event = "Event name: " + this.name + "\n";
        event += "Event location: " + this.place + "\n";
        event += "Event date: " + this.date + "\n";
        event += "Start time: " + this.start_time + "\n";
        event += "End time: " + this.end_time + "\n";
        event += "Available tickets: " + this.tickets + "\n";
        event += "Description: " + this.description;
        return event;
    }

}
