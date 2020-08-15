package com.serus.calculator;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class CircularButton extends androidx.appcompat.widget.AppCompatButton {

    public CircularButton(Context context) {
        super(context);
    }

    public CircularButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircularButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int size = width > height ? height : width;
        setMeasuredDimension(size, size);
    }
}
