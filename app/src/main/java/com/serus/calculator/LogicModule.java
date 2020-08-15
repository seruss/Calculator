package com.serus.calculator;


import java.util.ArrayList;
import java.util.Stack;

public class LogicModule {

    private final String DEFAULT_VALUE = "0";
    private String screenContent;
    private Stack<Integer> stack;

    public LogicModule() {
        screenContent = DEFAULT_VALUE;
        stack = new Stack();
    }

    public String getScreenContent() {
        return screenContent;
    }

    public void push(String content) {
        if(content.equals(".")) {
            if(!screenContent.contains(".")&&!screenContent.isEmpty()) {
                screenContent+=".";
            }
        }
        else {
            if(screenContent.equals("0")) screenContent=content;
            else screenContent+=content;
        }
    }

    public void pop() {
        if(screenContent.length()==1) screenContent=DEFAULT_VALUE;
        else screenContent = screenContent.substring(0,screenContent.length()-1);
    }

    public void clear() {
        screenContent = DEFAULT_VALUE;
    }

    public void getOperation(int operationId) {
        switch (operationId) {
            case R.id.btnMultiply: {

            }
            break;
            case R.id.btnDivide: {

            }
            break;
            case R.id.btnPlus: {
                System.out.println("Xd");
            }
            break;
            case R.id.btnMinus: {

            }

        }
    }
}
