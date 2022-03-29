package com.test.automation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//this class turns infix math expression to postfix Reverse Polish Notation
//https://en.wikipedia.org/wiki/Shunting-yard_algorithm

public class ShuntingYard {
    private static final Map<String, Operator> operators = Stream.of(new Object[][]{
            {"+", Operator.ADD},
            {"-", Operator.SUBTRACT},
            {"*", Operator.MULTIPLY},
            {"/", Operator.DIVIDE},
            {"^", Operator.POWER},
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Operator) data[1]));

    static List<String> tokenize(String expression) {
        if (expression == null || expression.trim().length() == 0)
            throw new IllegalArgumentException("Empty expression or null");

        if (operators.containsKey(expression.substring(expression.length() - 1))) {
            throw new IllegalArgumentException("Expression ends with operator");
        }

        //remove all blank spaces and turn negative numbers to 0- expression
        expression = expression.replaceAll("\\s+", "");
        expression = expression.replace("(-", "(0-");

        List<String> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile("((([0-9]*[.])?[0-9]+)|([\\+\\-\\*\\/\\(\\)\\^]))");
        Matcher matcher = pattern.matcher(expression);
        int index = 0;

        while (matcher.find()) {
            if (matcher.start() != index) {
                throw new IllegalArgumentException("Invalid Expression:" + expression);
            }
            tokens.add(matcher.group().trim());
            index += tokens.get(tokens.size() - 1).length();
        }
        if (index != expression.length()) {
            throw new IllegalArgumentException("Invalid expression");
        }
        return tokens;
    }

    static String transform(String expression) throws IndexOutOfBoundsException, NullPointerException, IllegalArgumentException {
        if (expression == null || expression.trim().length() == 0)
            throw new IllegalArgumentException("Empty expression or null");

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        List<String> tokens = tokenize(expression);

        for (String token : tokens) {
            if (operators.containsKey(token)) {
                // it's an operator
                while (!stack.empty() && operators.containsKey(stack.peek())
                        && ((operators.get(token).priority <= operators.get(stack.peek()).priority && !token.equals("^")) ||
                        (operators.get(token).priority < operators.get(stack.peek()).priority && token.equals("^")))) {
                    sb.append(stack.pop()).append(" ");
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                // pop the stack until opening bracket is found
                while (!stack.isEmpty()) {
                    if (!stack.peek().equals("(")) {
                        sb.append(stack.pop()).append(" ");
                    } else {
                        break;
                    }
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // removes opening bracket
                }
            } else {
                // it's a number
                sb.append(token).append(" ");
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        return sb.toString();
    }
}