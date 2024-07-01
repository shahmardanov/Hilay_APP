package com.example.hilay_app.exception;

public class MainCategoryNotFoundException extends RuntimeException {
    public MainCategoryNotFoundException(String code, String message){
        super(message);
    }
}