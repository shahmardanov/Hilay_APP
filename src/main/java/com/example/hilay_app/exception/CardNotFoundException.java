package com.example.hilay_app.exception;

public class CardNotFoundException extends RuntimeException {
    public CardNotFoundException(String code, String message){
        super(message);
    }
}