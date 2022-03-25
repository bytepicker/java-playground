package com.test.automation;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.regex.Pattern;

//https://en.wikipedia.org/wiki/Shunting-yard_algorithm

public class SYA {
    static String transform(String infix) throws ArithmeticException, EmptyStackException {
        StringBuffer result = new StringBuffer();
        for(String token : infix.split("\\s+")) {
            if(!isNumeric(token)){
                stack.push(token);
            } else {
                result.append(token).append(" ");
            }
        }

        for(String operator : stack){
            result.append(operator).append(" ");
        }
        return result.toString();
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        return pattern.matcher(strNum).matches();
    }

    static Stack<String> stack = new Stack<>();
}
