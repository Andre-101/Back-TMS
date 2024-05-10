package com.example.backtms.entity;

public class Reading {
    private int t;
    private int x;
    //GETS y SETS


    public Reading(int t, int x) {
        this.t = t;
        this.x = x;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
