package com.test.automation;

public class Calculator {
    Calculator(String expr){
        this.expr = expr.trim();
    }

    Double result() {
        return RPNProcessor.count(SYATransformer.makePostfix(this.expr));
    }

    private final String expr;
}
