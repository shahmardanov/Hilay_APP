package com.example.hilay_app.exception;

public class MainCategoryExistsException extends RuntimeException {
    public MainCategoryExistsException(String code, String message){
        super(message);
    }
}