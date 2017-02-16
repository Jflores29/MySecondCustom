package com.javier.mysecondcustom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.icu.text.RelativeDateTimeFormatter;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.content.res.TypedArray;
import android.graphics.Paint.Style;
import android.util.AttributeSet;

/**
 * Created by User on 1/18/2017.
 */

public class MySecondCustom extends View {

    private MySecondCustom myView;
    private int circleCol, labelCol;
    private String circleText;
    private Paint circlePaint;
    private GestureDetector mDetector;



    public MySecondCustom(Context context, AttributeSet attrs){
        super(context, attrs);
        circlePaint =  new Paint();
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyCustomView,0,0);
        try
        {
            circleText = a.getString(R.styleable.MyCustomView_circleLabel);
            circleCol = a.getInteger(R.styleable.MyCustomView_circleColor, 0);
            labelCol = a.getInteger(R.styleable.MyCustomView_labelColor, 0);
        } finally {
            a.recycle();
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        int viewWidthHalf = this.getMeasuredWidth()/2;
        int viewHeightHalf = this.getMeasuredHeight()/2;
        int radius = 0;

        if(viewWidthHalf>viewHeightHalf)
        {
            radius = viewHeightHalf -10;
        }
        else{ radius =   viewWidthHalf -10;}


        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);


        circlePaint.setColor(circleCol);

        canvas.drawCircle(viewWidthHalf,viewHeightHalf, radius, circlePaint);

        circlePaint.setColor(labelCol);

        circlePaint.setTextAlign(Paint.Align.CENTER);
        circlePaint.setTextSize(50);

        canvas.drawText(circleText, viewWidthHalf, viewHeightHalf, circlePaint);
        mDetector = new GestureDetector(MySecondCustom.this.getContext(), new mListener());

    }
    class mListener extends GestureDetector.SimpleOnGestureListener {


        @Override
        public boolean onDown(MotionEvent e) {


            return true;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        boolean result = mDetector.onTouchEvent(event);

        switch (event.getAction()) {
            case  MotionEvent.ACTION_UP:
                setCircleCol(Color.RED);
                setLabelCol(Color.BLUE);
                result = true;
                break;
            case MotionEvent.ACTION_DOWN:
                setCircleCol(Color.GREEN);
                setLabelCol(Color.RED);
                result = true;

                break;


        }
        return result;
    }





    public int getCircleCol() {
        return circleCol;
    }

    public void setCircleCol(int newColor) {
        circleCol =newColor;

        invalidate();
        requestLayout();


    }

    public int getLabelCol() {
        return labelCol;
    }

    public void setLabelCol(int newColor) {
        labelCol=newColor;
        invalidate();
        requestLayout();

    }

    public String getCircleText(String newLabel) {
        circleText= newLabel;
        invalidate();
        requestLayout();

        return circleText;
    }

    public void setCircleText(String circleText) {
        this.circleText = circleText;
    }

}


