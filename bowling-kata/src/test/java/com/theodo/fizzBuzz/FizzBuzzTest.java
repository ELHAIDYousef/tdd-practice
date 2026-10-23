package com.theodo.fizzBuzz;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before 
    public void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    // [1] => 1
    @Test 
    public void oneShouldReturnOne() {
        assertEquals("1", fizzBuzz.get(1));
    }

    // [2] => 2
    @Test
    public void twoShouldReturnTwo() {
        assertEquals("2", fizzBuzz.get(2) );
    }

    // [3] => Fizz
    @Test 
    public void threeShouldReturnFizz() {
        assertEquals("Fizz", fizzBuzz.get(3));
    }

    // [6] => Fizz
    @Test 
    public void sixShouldReturnSix() {
        assertEquals("Fizz", fizzBuzz.get(6));
    }

    // [5] => Buzz
    @Test 
    public void fiveShouldReturnBuzz() {
        assertEquals("Buzz", fizzBuzz.get(5));
    }

    // [10] => Buzz
    @Test 
    public void tenShouldReturnTen() {
        assertEquals("Buzz", fizzBuzz.get(10));
    }

    // [15] => FizzBuzz
    @Test 
    public void fifteenShouldReturnFefteen() {
        assertEquals("FizzBuzz", fizzBuzz.get(15));
    }

    
}
