package com.example.hilay_app.exception;

public class ChatGroupNotFoundException extends RuntimeException {
    public ChatGroupNotFoundException(String code, String message){
        super(message);
    }
}