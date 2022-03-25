package com.test.automation;

public class Calculator {
    Calculator(String expr){
        this.expr = expr.trim();
    }

    Double calculate() {
        return RPN.count(SYA.transform(expr));
    }

    private final String expr;
}
