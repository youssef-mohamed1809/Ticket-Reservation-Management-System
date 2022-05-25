package com.ticketreservationmanagementsystemgui;

public class Admin extends User {
    Admin(String username, String password) {
        super(username, password);
        job = "Admin";
    }
}