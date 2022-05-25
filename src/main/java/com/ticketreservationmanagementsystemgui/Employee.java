package com.ticketreservationmanagementsystemgui;

public class Employee extends User {
    Employee(String username, String password) {
        super(username, password);
        job = "Employee";
    }
}