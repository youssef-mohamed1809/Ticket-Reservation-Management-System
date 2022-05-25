package com.ticketreservationmanagementsystemgui;

import java.util.ArrayList;

public class Client {
    String name;
    String nationalID;
    String gender;
    String mobile;
    String serial_number;
    ArrayList<Event> events = new ArrayList<Event>();

    Client(){

    }

    public Client(String name, String nationalID, String gender, String mobile, String serial_number) {
        this.name = name;
        this.nationalID = nationalID;
        this.gender = gender;
        this.mobile = mobile;
        this.serial_number = serial_number;
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }
    public void removeEvent(Event event){this.events.remove(event);}
}
