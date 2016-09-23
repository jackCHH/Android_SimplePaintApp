package com.example.jackhou.paint;

public class PainterPresenter {

    public float calculate(float x1, float y1, float x2, float y2){
        float distanceX = Math.abs(x2-x1);
        float distanceY = Math.abs(y2-y1);

        return (float)Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY,2));
    }

}
