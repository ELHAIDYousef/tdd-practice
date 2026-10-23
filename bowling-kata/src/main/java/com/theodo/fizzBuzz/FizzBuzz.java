package com.theodo.fizzBuzz;

/**
 * FizzBuzz
 */
public class FizzBuzz {

    public String get(int number) {
        if (isFizz(number) && isBuzz(number)) {
            return "FizzBuzz";
        }
        else if (isBuzz(number)) {
            return "Buzz";
        }
        else if (isFizz(number) ) {
            return "Fizz";
        }
        return String.valueOf(number);
    }


    // ====================== Helper private methods ======================

    private boolean isFizz(int number) {
        return number % 3 == 0;
    }

    private boolean isBuzz(int number) {
        return number % 5 == 0;
    }

}
