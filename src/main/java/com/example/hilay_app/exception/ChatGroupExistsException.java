package com.example.hilay_app.exception;

public class ChatGroupExistsException extends RuntimeException {
    public ChatGroupExistsException(String code, String message){
        super(message);
    }
}