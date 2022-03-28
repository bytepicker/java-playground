package com.test.fizzbuzz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();
        sc.close();
        StringBuffer result = new StringBuffer();
        if(inputNumber%3 == 0) {
            result.append("fizz");
        }
        if(inputNumber%5 ==0) {
            result.append("buzz");
        }
        System.out.println(result);
    }
}
