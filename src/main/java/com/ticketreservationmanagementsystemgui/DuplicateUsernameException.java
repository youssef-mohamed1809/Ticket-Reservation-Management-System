package com.ticketreservationmanagementsystemgui;

public class DuplicateUsernameException extends Exception{
    DuplicateUsernameException(String s){
        super(s);
    }
}
