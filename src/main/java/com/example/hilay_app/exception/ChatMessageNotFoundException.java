package com.example.hilay_app.exception;

public class ChatMessageNotFoundException extends RuntimeException {
    public ChatMessageNotFoundException(String code, String message){
        super(message);
    }
}