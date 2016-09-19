package com.example.jackhou.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class PaintView extends View {

    private Paint paint;
    private Path path = new Path();

    public PaintView(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        
    }

    protected void onDraw(Canvas canvas){

        canvas.drawPath(path, paint);

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

    public void clear(){
        path = new Path();
        invalidate();
    }


}
