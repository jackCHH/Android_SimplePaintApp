package com.example.jackhou.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class PaintView extends View{

    private PainterPresenter painterPresenter;
    private Paint paint;
    private Path path;
    private ArrayList<Path> pathList;
    private ArrayList<Paint> paintList;
    private int[] colorHash;
    private float currentX;
    private float currentY;
    private float endX;
    private float endY;
    private boolean circleFlag = false;


    public PaintView(Context context, AttributeSet attrs){
        super(context, attrs);
        initColorArray();
        resetArrays();
        initCanvas(1,0);
        painterPresenter = new PainterPresenter();
    }

    public void resetArrays(){
        pathList = new ArrayList<Path>();
        paintList = new ArrayList<Paint>();
    }

    public void initColorArray(){
        colorHash = new int[] {Color.BLACK, Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA, Color.WHITE};
    }

    private void initCanvas(int stroke_size, int color_key){
        path = new Path();
        pathList.add(path);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(colorHash[color_key]);
        paint.setStrokeWidth(10*stroke_size);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paintList.add(paint);
    }

    public void clear(int strokeSize, int color_key){
        resetArrays();
        invalidate();
        initCanvas(strokeSize,color_key);
    }

    public void erase(){
        initCanvas(5, 7);
    }

    public void updateStroke(int strokeSize, int key){
        initCanvas(strokeSize, key);
    }

    public void updateColor(int strokeSize, int key){
        initCanvas(strokeSize, key);
    }

    public void drawCircle(int key){
        circleFlag = true;
    }

    protected void onDraw(Canvas canvas){
        canvas.drawColor(Color.WHITE);

        if(!circleFlag){
            for(int i = 0; i < paintList.size(); i++){
                canvas.drawPath(pathList.get(i), paintList.get(i));
            }
        }
        else{
            if(currentX != 0.0f && currentY != 0.0f && endX != 0.0f && endY != 0.0f){
                float radius = painterPresenter.calculate(currentX, currentY, endX, endY);
                canvas.drawCircle(currentX,currentY,radius,paint);
                circleFlag = false;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        if(!circleFlag){
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                path.moveTo(x,y);
            }
            else if(event.getAction() == MotionEvent.ACTION_MOVE){
                path.lineTo(x,y);
            }
            else{
                return false;
            }

        }
        else{
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                currentX = x;
                currentY = y;
            }
            else if(event.getAction() == MotionEvent.ACTION_UP){
                endX = x;
                endY = y;
            }
            else{
                return false;
            }
        }
        postInvalidate();
        return true;
    }
}
