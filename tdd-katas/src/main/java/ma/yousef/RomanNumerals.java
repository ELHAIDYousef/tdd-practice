package ma.yousef;

/**
 *
 * @author Yousef ELHAID
 */
public class RomanNumerals {

    public static String of(int number) {
        String result = "";
        int rest = number;
        if (rest >= 5) {
            result += "V";
            rest -= 5;
        }
        if (rest >= 4) {
            result += "IV";
            rest -= 4;
        }
        while (rest >= 1) {
            result += "I";
            rest -= 1;
        }
        return result;
    }
}
