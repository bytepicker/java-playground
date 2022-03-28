package com.test.fibo;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MainTest {
    @Test
    public void testFiboInputEqualsZero() {
        assertEquals(Main.fibo(0), 0);
    }

    @Test
    public void testFiboInputEqualsOne() {
        assertEquals(Main.fibo(1), 1);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testFiboNegativeInput() { Main.fibo(-1); }

    @Test
    public void testFiboInputEqualsTwo() {
        assertEquals(Main.fibo(2), 1);
    }

    @Test
    public void testFiboInputEqualsFive() {
        assertEquals(Main.fibo(5), 5);
    }

    @Test
    public void testFiboInputEqualsEight() {
        assertEquals(Main.fibo(8), 21);
    }

    @Test
    public void testFiboInputEqualsNine() {
        assertEquals(Main.fibo(9), 34);
    }

    @Test
    public void testFiboInputEqualsTwelve() {
        assertEquals(Main.fibo(12), 144);
    }
}