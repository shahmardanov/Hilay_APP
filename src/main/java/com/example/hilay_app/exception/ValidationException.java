package com.example.hilay_app.exception;

public class ValidationException extends RuntimeException {
    public ValidationException(String code, String message){
        super(message);
    }
}