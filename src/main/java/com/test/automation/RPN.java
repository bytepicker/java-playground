package com.test.automation;

import java.util.EmptyStackException;
import java.util.Stack;

//https://en.wikipedia.org/wiki/Reverse_Polish_notation

public class RPN {
    static Double count(String expr) throws ArithmeticException, EmptyStackException {
        for(String token : expr.split("\\s+")){
            switch (token){
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
