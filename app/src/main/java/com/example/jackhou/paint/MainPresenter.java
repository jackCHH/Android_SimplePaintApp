package com.example.jackhou.paint;

public class MainPresenter {

    private PaintView view;

    public MainPresenter(PaintView view){
        this.view = view;
    }

    public void clear(int strokeWidth, int colorOption){
        view.clear(strokeWidth, colorOption);
    }

    public void erase(){
        view.erase();
    }

    public void updateColor(int strokeWidth, int colorOption){
        view.updateColor(strokeWidth, colorOption);
    }

    public void updateStroke(int strokeWidth, int colorOption){
        view.updateStroke(strokeWidth, colorOption);
    }

    public void drawCircle(int colorOption){
        view.drawCircle(colorOption);
    }

}
