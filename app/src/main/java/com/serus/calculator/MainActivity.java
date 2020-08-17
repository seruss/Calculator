package com.serus.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDot,
            btnPlusMinus, btnPlus, btnMinus, btnMultiply, btnDivide, btnPercent, btnC, btnEquals;
    private TextView result;
    private LogicModule logicModule;
    private GestureDetector gestureDetector;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setLayoutContent();
        logicModule = new LogicModule();
        result.setText(logicModule.getScreenContent());

        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(MotionEvent event1, MotionEvent event2,
                                   float velocityX, float velocityY) {
                float diffX = event1.getX() - event2.getX();
                float diffY = event1.getY() - event2.getY();
                if(Math.abs(diffX)>Math.abs(diffY)) {
                        logicModule.pop();
                        result.setText(logicModule.getScreenContent());
                        return false;
                }
                return true;
            }
        });

        result.setOnTouchListener(new TextView.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
    }


    private void setLayoutContent() {
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnPlusMinus = (Button) findViewById(R.id.btnPlusMinus);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnPercent = (Button) findViewById(R.id.btnPercent);
        btnC = (Button) findViewById(R.id.btnC);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        result = (TextView) findViewById(R.id.textViewResult);
    }

    public void numericInput(View view) {
        Button clicked = (Button) view;
        logicModule.push(clicked.getText().toString());
        result.setText(logicModule.getScreenContent());
    }

    public void removeResult(View view) {
        logicModule.clear();
        result.setText(logicModule.getScreenContent());
    }

    public void performOperation(View view) {
        CircularButton clicked = (CircularButton) view;
        clicked.onClick(view);
        //logicModule.getOperation(clicked.getId());
    }
}
