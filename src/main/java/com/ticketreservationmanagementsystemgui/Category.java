package com.ticketreservationmanagementsystemgui;

import java.util.ArrayList;

public class Category {


    String name;

    ArrayList<Event> events = new ArrayList<Event>();

    Category(String name){
        this.name=name;

    }

    void editname(String name){
        this.name=name;
    }
}
