package com.theodo.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;


public class StringCalculatorTest {

    private StringCalculator calculator;

    @Before
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void emptyStringReturnsZero() {
        assertSum(0, "");
    }

    @Test
    public void singleNumberReturnsItself() {
        assertSum(1, "1");
    }

    @Test
    public void twoNumbersReturnTheirSum() {
        assertSum(3, "1,2");
    }

    @Test 
    public void anyAmountOfNumbersIsAdded() {
        assertSum(10, "1,2,3,4");
    }

    @Test 
    public void newLineIsAlsoADelimiter() {
        assertSum(6, "1\n2,3");
    }

    @Test
    public void customDelimiterIsSupported() {
        assertSum(3, "//;\n1;2");
    }

    @Test 
    public void customDelimiterWithRegexDotIsTakenLiterally() {
        assertSum(3, "//.\n1.2");
    }

    @Test 
    public void customDelimiterWithRegexStarIsTakenLiterally() {
        assertSum(6, "//*\n1*2*3");
    }

    @Test
    public void negativeNumberThrowsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.add("-1,2"));

        assertEquals("negatives not allowed: -1", exception.getMessage());
    }

    @Test 
    public void allNegativesAreListedInTheMessage() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.add("-1,2,-3"));

        assertEquals("negatives not allowed: -1 , -3", exception.getMessage());
    }
















    // =============== Helper private method ===============
    private void assertSum(int expected, String numbers) {
        assertEquals(expected, calculator.add(numbers));
    }
}