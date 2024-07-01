package com.example.hilay_app.exception;

public class SubCategoryNotFoundException extends RuntimeException {
    public SubCategoryNotFoundException(String code, String message){
        super(message);
    }
}