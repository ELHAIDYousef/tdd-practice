package ma.yousef;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author Yousef ELHAID
 */
public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiters = ",|\n";
        String body = numbers;
        if (numbers.startsWith("//")) {
            delimiters += "|" + Pattern.quote(numbers.substring(2, 3));
            body = numbers.substring(4);
        }
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
        for (String part : body.split(delimiters)) {
            int value = Integer.parseInt(part);
            if (value < 0) {
                negatives.add(value);
            } else if (value <= 1000) {
                sum += value;
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Négatifs interdits : "
                    + negatives.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        return sum;
    }
}