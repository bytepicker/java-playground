package com.test.automation;

import java.util.EmptyStackException;
import java.util.Stack;

//this class gets postfix math expression and calculates the result
//https://en.wikipedia.org/wiki/Reverse_Polish_notation

public class Calculator {
    static Double calculate(String expression) throws NumberFormatException, EmptyStackException {
        if (expression == null || expression.trim().length() == 0)
            throw new IllegalArgumentException("Empty expression or null");

        for (String token : expression.split("\\s+")) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    double divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                case "^":
                    double exponent = stack.pop();
                    stack.push(Math.pow(stack.pop(), exponent));
                    break;
                default:
                    stack.push(Double.parseDouble(token));
                    break;
            }
        }
        return stack.pop();
    }

    static Stack<Double> stack = new Stack<>();
}
