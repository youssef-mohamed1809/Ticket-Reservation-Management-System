package com.ticketreservationmanagementsystemgui;

public abstract class User {
    String username;
    String password;
    String job;

    User(){

    }
    User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
