package com.example.hilay_app.exception;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException(String code, String message){
        super(message);
    }
}