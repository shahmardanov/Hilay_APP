package com.example.hilay_app.exception;

public class ImageFileNameExistsException extends RuntimeException {
    public ImageFileNameExistsException(String code, String message){
        super(message);
    }
}