package com.example.hilay_app.exception;

public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(String code, String message){
        super(message);
    }
}