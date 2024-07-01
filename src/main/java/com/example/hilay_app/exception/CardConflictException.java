package com.example.hilay_app.exception;

public class CardConflictException extends RuntimeException {
    public CardConflictException(String code, String message){
        super(message);
    }
}