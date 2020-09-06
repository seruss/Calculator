package com.serus.calculator;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.view.View;

public class CircularButton extends androidx.appcompat.widget.AppCompatButton implements View.OnClickListener {

    private static CircularButton selected;
    private TransitionDrawable transition = new TransitionDrawable( new Drawable[] {
            getResources().getDrawable(R.drawable.orange_button),
            getResources().getDrawable(R.drawable.white_button)
    });

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
        if(clicked.getId()!=R.id.btnEquals) {
            clicked.setBackground(transition);
            if(selected!=null && selected!=clicked) {
                setDeselected(selected);
                setSelected(clicked);
            }
            selected=clicked;
        } else {
            if(selected!=null) setDeselected(selected);
        }

    }


    private void setSelected(CircularButton clicked) {
        clicked.setBackground(transition);
        transition.startTransition(100);
        clicked.setTextColor(getResources().getColor(R.color.colorAccent));
    }

    private void setDeselected(CircularButton clicked) {
        clicked.setBackground(transition);
        transition.resetTransition();
        clicked.setTextColor(getResources().getColor(R.color.colorWhite));
    }
}
