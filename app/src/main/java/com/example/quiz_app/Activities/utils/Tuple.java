package com.example.quiz_app.Activities.utils;

import java.io.Serializable;

public class Tuple implements Serializable {
    public double x;
    public double y;

    public Tuple(double x, double y){
        this.x = x;
        this.y = y;
    }
}
