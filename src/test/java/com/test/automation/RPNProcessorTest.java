package com.test.automation;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RPNProcessorTest {

    @Test
    public void testSingleOperatorInput() {
        assertEquals(RPNProcessor.count("2 3 +"), new Double(5));
    }

    @Test
    public void testTwoOperatorsInput() {
        assertEquals(RPNProcessor.count("5 7 2 / +"), new Double(8.5));
    }

    @Test
    public void testWithBracketsInput() {
        assertEquals(RPNProcessor.count("5 7 + 2 *"), new Double(24));
    }

    @Test
    public void testAllOperatorsWithBracketsInput() {
        assertEquals(RPNProcessor.count("3 4 2 * 1 5 - 2 3 ^ ^ / +"), new Double(3.0001220703125));
    }
}