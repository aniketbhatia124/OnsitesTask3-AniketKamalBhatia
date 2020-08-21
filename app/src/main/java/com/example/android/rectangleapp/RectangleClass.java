package com.example.android.rectangleapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import static android.graphics.Bitmap.createBitmap;

public class RectangleClass extends View {


    public Paint box;
    float left=50,right=400,bottom=400,top=50;
    float prevpointX,prevpointY,currpointX,currpointY;






    public RectangleClass(Context context) {
        super(context);
        init(null);


    }

    public RectangleClass(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RectangleClass(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RectangleClass(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {


                                                      //    java.lang.NullPointerException: Attempt to invoke virtual method 'long android.graphics.Paint.getNativeInstance()' on a null object reference
                                          //    at android.graphics.Canvas.drawCircle(Canvas.java:1169)-- Paint object values must be defined in init() for all constructors

        box = new Paint();
        box.setStyle(Paint.Style.FILL);
        box.setColor(Color.BLACK);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);


    }

    @RequiresApi(api = Build.VERSION_CODES.M)


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(left,top,right,bottom,box);
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }



    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        performClick();




        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            prevpointX = event.getX();
            prevpointY= event.getY();
        }


           if (event.getAction() == MotionEvent.ACTION_MOVE) {
               currpointX=event.getX();
               currpointY=event.getY();
               if(prevpointX>left+100&&prevpointX<right-100&&prevpointY<bottom-100&&prevpointY>top+100) {

                   left = left + (currpointX - prevpointX);
                   right = right + (currpointX - prevpointX);
                   top = top + (currpointY - prevpointY);
                   bottom = bottom + (currpointY- prevpointY);
                   prevpointX=currpointX;
                   prevpointY=currpointY;
               }

               else if((prevpointX<=left+50&&prevpointX>=left-50)&&prevpointY>top&&prevpointY<bottom){
                   left= left+(currpointX-prevpointX);
                   prevpointX=currpointX;
                   prevpointY=currpointY;
               }


               else if((prevpointX<=right+50&&prevpointX>=right-50)&&prevpointY>top&&prevpointY<bottom){
                   right= right+(currpointX-prevpointX);
                   prevpointX=currpointX;
                   prevpointY=currpointY;
               }

               else if(prevpointX>left&&prevpointX<right&&(prevpointY<=top+50&&prevpointY>=top-50)){
                   top=top+(currpointY-prevpointY);
                   prevpointX=currpointX;
                   prevpointY=currpointY;
               }

               else if(prevpointX>left&&prevpointX<right&&(prevpointY<=bottom+50&&prevpointY>=bottom-50)){
                   bottom=bottom+(currpointY-prevpointY);
                   prevpointX=currpointX;
                   prevpointY=currpointY;
               }

               invalidate();

        }




        return true;
    }
}
