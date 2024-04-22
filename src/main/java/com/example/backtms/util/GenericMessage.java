package com.example.backtms.util;

public class GenericMessage {

    private String description;


    public GenericMessage(String description) {
        this.description = description;
    }

    public GenericMessage() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
