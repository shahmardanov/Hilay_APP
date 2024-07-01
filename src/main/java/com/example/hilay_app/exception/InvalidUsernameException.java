package com.example.hilay_app.exception;

public class InvalidUsernameException extends RuntimeException {
    public InvalidUsernameException(String code,String message) {
        super(message);
    }
}