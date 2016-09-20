package com.example.jackhou.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class PaintView extends View {

    private Paint paint;
    private Path path;
    private ArrayList<Path> pathList;
    private ArrayList<Paint> paintList;
    private SparseArray colorHash;




    public PaintView(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    private void init(){

        colorHash = new SparseArray(5);
        colorHash.append(0, Color.BLACK);
        colorHash.append(1, Color.RED);
        colorHash.append(2, Color.BLUE);
        colorHash.append(3, Color.YELLOW);
        colorHash.append(4, Color.GREEN);

        pathList = new ArrayList<Path>();
        paintList = new ArrayList<Paint>();

        path = new Path();
        pathList.add(path);


        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paintList.add(paint);

    }

    public void clear(){
        pathList = new ArrayList<Path>();
        paintList = new ArrayList<Paint>();
        invalidate();
        init();
    }

    public void updateStroke(int size, int key){

        path = new Path();
        paint = new Paint();
        pathList.add(path);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor((int)colorHash.get(key));
        paint.setStrokeWidth(10*size);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paintList.add(paint);

    }

    public void updateColor(int size, int key){
        path = new Path();
        paint = new Paint();
        pathList.add(path);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor((int)colorHash.get(key));
        paint.setStrokeWidth(10*size);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paintList.add(paint);
    }


    protected void onDraw(Canvas canvas){

        Log.i("Paint Size", Integer.toString(paintList.size()));
        Log.i("Path Size", Integer.toString(pathList.size()));


        for(int i = 0; i < paintList.size(); i++){
            canvas.drawPath(pathList.get(i), paintList.get(i));
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        if(event.getAction() == MotionEvent.ACTION_DOWN){

            path.moveTo(touchX, touchY);
        }
        else if(event.getAction() == MotionEvent.ACTION_MOVE){
            path.lineTo(touchX, touchY);
        }
        else{
            return false;
        }

        postInvalidate();
        return true;


    }




}
