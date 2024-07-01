package com.example.hilay_app.exception;

public class StudentExistsException extends RuntimeException {
    public StudentExistsException(String code, String message){
        super(message);
    }
}