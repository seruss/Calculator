package com.serus.calculator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class CircularButton extends androidx.appcompat.widget.AppCompatButton implements View.OnClickListener {

    private CircularButton selected;

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
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int size = Math.min(width, height);
        setMeasuredDimension(size, size);
    }

    @Override
    public void onClick(View view) {
        CircularButton clicked = (CircularButton) view;
        if (clicked.getId() != R.id.btnEquals) {
            selected = clicked;
        }
    }


    private void setProperties() {
        Drawable background = this.getBackground();
        int textColor = this.getTextColors().getDefaultColor();
    }
}
