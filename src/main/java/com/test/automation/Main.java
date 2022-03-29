package com.test.automation;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                String expression = sc.nextLine();
                System.out.println(Calculator.calculate(ShuntingYard.transform(expression)));
            }
        } catch (Throwable err) {
            System.out.println("Caught an exception: " + err.getMessage() + Arrays.toString(err.getStackTrace()));
        }
    }
}