package com.example.hilay_app.exception;

public class QuestionLevelNotFoundException extends RuntimeException {
    public QuestionLevelNotFoundException(String code, String message){
        super(message);
    }
}