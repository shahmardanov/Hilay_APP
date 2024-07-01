package com.example.hilay_app.exception;

public class UserAnswerNotFoundException extends RuntimeException {
    public UserAnswerNotFoundException(String code, String message){
        super(message);
    }
}