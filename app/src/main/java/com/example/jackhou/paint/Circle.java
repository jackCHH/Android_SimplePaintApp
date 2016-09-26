package com.example.jackhou.paint;

public class Circle {

    private float x;
    private float y;
    private float radius;

    public Circle(float x, float y, float radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

    public float getRadius(){
        return this.radius;
    }
}
