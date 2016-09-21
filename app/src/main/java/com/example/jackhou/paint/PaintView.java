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

public class PaintView extends View {

    private Paint paint;
    private Path path;
    private ArrayList<Path> pathList;
    private ArrayList<Paint> paintList;
    private int[] colorHash;
//    private Bitmap bitmap;
//    private Canvas c;

    public PaintView(Context context, AttributeSet attrs){
        super(context, attrs);
        initColorArray();
        resetArrays();
        initCanvas(1,0);
    }

    public void resetArrays(){
        pathList = new ArrayList<Path>();
        paintList = new ArrayList<Paint>();
    }

    public void initColorArray(){
        colorHash = new int[] {Color.BLACK, Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN, Color.TRANSPARENT};
    }

    private void initCanvas(int stroke_size, int color_key){
        path = new Path();
        pathList.add(path);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(colorHash[color_key]);
        paint.setStrokeWidth(10*stroke_size);
        paint.setStyle(Paint.Style.STROKE);
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
//
//        Bitmap bitmap = Bitmap.createBitmap(this.getWidth(), this.getHeight(), Bitmap.Config.ARGB_8888);
//        c.drawBitmap(bitmap, 0,0,null);
//        this.draw(c);
//
//        File file = new File(Environment.getExternalStorageDirectory() + "/sign.png");
//
//        try {
//            bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(file));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void updateStroke(int strokeSize, int key){
        initCanvas(strokeSize, key);
    }

    public void updateColor(int strokeSize, int key){
        initCanvas(strokeSize, key);
    }

    protected void onDraw(Canvas canvas){

        for(int i = 0; i < paintList.size(); i++){
            canvas.drawPath(pathList.get(i), paintList.get(i));
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float X = event.getX();
        float Y = event.getY();

        if(event.getAction() == MotionEvent.ACTION_DOWN){

            path.moveTo(X,Y);
        }
        else if(event.getAction() == MotionEvent.ACTION_MOVE){
            path.lineTo(X,Y);
        }
        else{
            return false;
        }

        postInvalidate();
        return true;
    }
}
