package com.test.automation;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTest {

    @Test
    public void testSingleOperatorInput() {
        assertEquals(Calculator.calculate("2 3 +"), new Double(5));
    }

    @Test
    public void testTwoOperatorsInput() {
        assertEquals(Calculator.calculate("5 7 2 / +"), new Double(8.5));
    }

    @Test
    public void testWithBracketsInput() {
        assertEquals(Calculator.calculate("5 7 + 2 *"), new Double(24));
    }

    @Test
    public void testAllOperatorsWithBracketsInput() {
        assertEquals(Calculator.calculate("3 4 2 * 1 5 - 2 3 ^ ^ / +"), new Double(3.0001220703125));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullStringInput(){
        Calculator.calculate(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmptyStringInput(){
        Calculator.calculate("");
    }
}