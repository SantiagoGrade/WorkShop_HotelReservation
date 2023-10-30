package com.example.HotelReservationWorkshop.exceptions;

public class DuplicateException extends RuntimeException{
    public DuplicateException(String message){
        super(message);
    }
}
