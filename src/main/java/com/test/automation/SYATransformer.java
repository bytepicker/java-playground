package com.test.automation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://en.wikipedia.org/wiki/Shunting-yard_algorithm

public class SYATransformer {
    private static final Map<String, Operator> operators = Stream.of(new Object[][]{
            {"+", Operator.ADD},
            {"-", Operator.SUBSTRACT},
            {"*", Operator.MULTIPLY},
            {"/", Operator.DIVIDE},
            {"^", Operator.POWER},
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Operator) data[1]));

    static String makePostfix(String expression) {
        if (expression == null || expression.trim().length() == 0)
            throw new IllegalArgumentException("Empty expression or null");

        return new String();
    }
}
