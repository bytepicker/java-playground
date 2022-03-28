package com.test.divisor;

public class Main {
    public static int div(int a, int b) {
        if(b == 0) { throw new RuntimeException("Sorry, no division by zero"); }
        if(a == 0) { return 0; }

        int result = 0;
        boolean anyOfNumbersIsNegative = ((a > 0 && b < 0) || (a < 0 && b > 0));

        //Convert to positive obj
        int unsignedA = Math.abs(a);
        int unsignedB = Math.abs(b);

        //Check the largest n such that unsignedB >= 2^n
        int powerBit = 0;
        for (int i = 0; i < 32; i++) {
            if (Integer.compareUnsigned(((1 << i) & unsignedB), 0) != 0) {
                powerBit = i;
            }
        }

        //unsignedA can hold 2^(31-powerBit) bits
        for (int i = 31 - powerBit; i >= 0; i--) {
            if (Integer.compareUnsigned((unsignedB << i), unsignedA) < 1) {
                result += (1 << i);
                unsignedA -= (unsignedB << i);
            }
        }

        return anyOfNumbersIsNegative ? ~result + 1 : result;
    }
}