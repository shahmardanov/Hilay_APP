package com.example.hilay_app.exception;

public class AnswerNotFoundException extends RuntimeException {
    public AnswerNotFoundException(String code, String message){
        super(message);
    }
}