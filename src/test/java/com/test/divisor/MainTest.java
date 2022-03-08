package com.test.divisor;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MainTest {
    @Test
    public void testDivZeroOnPositive() {
        assertEquals(Main.div(0, 3), 0);
    }

    @Test
    public void testDivZeroOnNegative() {
        assertEquals(Main.div(0, -3), 0);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testDivZeroOnZero() {
        Main.div(0, 0);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testDivNegativeOnZero() {
        Main.div(-5, 0);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testDivPositiveOnZero() {
        Main.div(5, 0);
    }

    @Test
    public void testDivPositiveOnPositive() {
        assertEquals(Main.div(15, 3), 5);
    }

    @Test
    public void testDivNegativeOnNegative() {
        assertEquals(Main.div(-15, -3), 5);
    }

    @Test
    public void testDivNegativeOnPositive() {
        assertEquals(Main.div(-15, 3), -5);
    }

    @Test
    public void testDivPositiveOnNegative() {
        assertEquals(Main.div(15, -3), -5);
    }
}