package com.example.backtms.controllers;

import java.util.ArrayList;

public class Test {
    private String type;
    private int samples;
    private ArrayList<Reading> readings;
    //GETS y SETS


    public Test() {
    }

    public Test(String type, int samples) {
        this.type = type;
        this.samples = samples;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSamples() {
        return samples;
    }

    public void setSamples(int samples) {
        this.samples = samples;
    }
}
