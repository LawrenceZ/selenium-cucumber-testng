package com.mydemo.pages;

public enum CalculatorButton {
    ONE("Btn1"),
    TWO("Btn2"),
    THREE("Btn3"),
    ZERO("Btn0"),
    PLUS("BtnPlus"),
    MINUS("BtnMinus"),
    MULTIPLY("BtnMult"),
    LEFT_PARENTHESIS("BtnParanL"),
    RIGHT_PARENTHESIS("BtnParanR"),
    SIN("BtnSin"),
    EQUAL("BtnCalc");

    private final String id;

    CalculatorButton(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}