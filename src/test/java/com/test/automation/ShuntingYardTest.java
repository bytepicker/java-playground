package com.test.automation;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ShuntingYardTest {

    @Test
    public void testTokenizeWithSpaces() {
        List<String> tokens = ShuntingYard.tokenize("     3 + 2  -22 * 323");
        assertEquals(tokens.size(), 7);
    }

    @Test
    public void testTokenizeSingleDigit() {
        List<String> tokens = ShuntingYard.tokenize("5");
        assertEquals(tokens.size(), 1);
    }

    @Test
    public void testTokenizeSingleFloatComaSeparated() {
        List<String> tokens = ShuntingYard.tokenize("-3,14");
        assertEquals(tokens.size(), 2);
    }

    @Test
    public void testTokenizeSingleFloatDotSeparated() {
        List<String> tokens = ShuntingYard.tokenize("7.62");
        assertEquals(tokens.size(), 1);
    }

    @Test
    public void testTokenizeDotSeparatedExpressionWithSpaces() {
        List<String> tokens = ShuntingYard.tokenize("2.12 + 1         - 3");
        assertEquals(tokens.size(), 5);
    }

    @Test
    public void testTokenizeComaSeparatedExpressionWithSpaces() {
        List<String> tokens = ShuntingYard.tokenize("-3,34 * 653    ^ -2 +   3");
        assertEquals(tokens.size(), 9);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTokenizeNullStringInput(){
        ShuntingYard.tokenize(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTokenizeEmptyStringInput(){
        ShuntingYard.tokenize("");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTokenizeLettersInInput(){
        ShuntingYard.tokenize("3 + 2f");
    }

    @Test
    public void testTransformWithSpaces() {
        assertEquals(ShuntingYard.transform("2 +    3"), "2 3 + ");
    }

    @Test
    public void testTransformFloatComaSeparatedWithSpaces() {
        assertEquals(ShuntingYard.transform("2,4 -    3,15"), "2.4 3.15 - ");
    }

    @Test
    public void testTransformFloatDotSeparatedWithSpaces() {
        assertEquals(ShuntingYard.transform("34.3 ^  0.32"), "34.3 0.32 ^ ");
    }

    @Test
    public void testTransformSingleDigit() {
        assertEquals(ShuntingYard.transform("-54"),"54 - ");
    }

    @Test
    public void testTransformComplexInput() {
        assertEquals(ShuntingYard.transform("5*(10-100)  + 1000/6 + 7*8"),"5 10 100 - * 1000 6 / + 7 8 * + ");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTransformWrongMultiplySign(){
        ShuntingYard.transform("6 x 8");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTransformEmptyStringInput(){
        ShuntingYard.transform("");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTransformNullStringInput(){
        ShuntingYard.transform(null);
    }

}