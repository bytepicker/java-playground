package com.test.fibo;

public class Main {
    public static int fibo(int inputNumber){
        if(inputNumber < 0) { throw new RuntimeException("Positive input only"); }

        if (inputNumber == 0 || inputNumber == 1) { return inputNumber; }
        return fibo(inputNumber - 1) + fibo(inputNumber - 2);
    }
}