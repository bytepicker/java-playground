package com.test.automation;

public enum Operator {
    ADD(1), SUBSTRACT(1), MULTIPLY(2), DIVIDE(2), POWER(3);
    final int priority;
    Operator(int priority) { this.priority = priority; }
}
