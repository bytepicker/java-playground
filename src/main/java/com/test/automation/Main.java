package com.test.automation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        try {
            Calculator calculator = new Calculator(sc.nextLine());
            System.out.println(calculator.calculate());
//        } catch (Throwable err){
//            System.out.println("Exception: " + err.getMessage());
//        }
    }
}