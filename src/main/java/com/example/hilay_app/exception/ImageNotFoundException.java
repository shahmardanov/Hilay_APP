package com.example.hilay_app.exception;

public class ImageNotFoundException extends RuntimeException {
    public ImageNotFoundException(String code, String message){
        super(message);
    }
}