package com.example.hilay_app.exception;

public class ImageFileNotFoundException extends RuntimeException {
    public ImageFileNotFoundException(String code, String message){
        super(message);
    }
}