package com.example.hilay_app.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String code, String message){
        super(message);
    }
}