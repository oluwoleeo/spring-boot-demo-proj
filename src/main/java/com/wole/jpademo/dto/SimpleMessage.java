package com.wole.jpademo.dto;

public class SimpleMessage {
    String message;

    public SimpleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
