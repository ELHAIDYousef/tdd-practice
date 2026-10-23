package com.theodo.calculator;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author Yousef ELHAID
 */
public class StringCalculator {

    private static final String DEFAULT_DELIMITERS = ",|\n";
    private static final String CUSTOM_PREFIX = "//";

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] values = splitNumbers(numbers);
        checkNegatives(values);
        return sum(values);
    }

    private String[] splitNumbers(String input) {
        if (hasCustomDelimiter(input)) {
            int newLineIndex = input.indexOf('\n');
            String delimiter = input.substring(CUSTOM_PREFIX.length(), newLineIndex);
            String body = input.substring(newLineIndex + 1);
            return body.split(Pattern.quote(delimiter));
        }
        return input.split(DEFAULT_DELIMITERS);
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_PREFIX);
    }

    private int sum(String[] numbers) {
        return Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .sum();
    }

    private void checkNegatives(String[] numbers) {
        String negatives = Arrays.stream(numbers)
                            .mapToInt(Integer::parseInt)
                            .filter(v -> v < 0)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" , "));
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives);
        }
    }
}

