package com.example.hilay_app.exception;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String code,String message) {
        super(message);
    }
}