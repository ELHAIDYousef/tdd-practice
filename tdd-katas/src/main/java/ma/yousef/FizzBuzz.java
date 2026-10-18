package ma.yousef;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Yousef ELHAID
 */
public class FizzBuzz {

    private static final Map<Integer, String> RULES = new LinkedHashMap<>();

    static {
        RULES.put(3, "Fizz");
        RULES.put(5, "Buzz");
        RULES.put(7, "Whizz");
        RULES.put(13,"Rizz");
    }

    public static String of(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Le nombre doit etre positif : " + number);
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> rule : RULES.entrySet()) {
            if (number % rule.getKey() == 0) {
                result.append(rule.getValue());
            }
        }
        return result.isEmpty() ? String.valueOf(number) : result.toString();
    }
}