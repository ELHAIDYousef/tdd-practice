package ma.yousef;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Yousef ELHAID
 */
public class RomanNumeralsTest {

    private void assertRoman(String expected, int number) {
        assertEquals(expected, RomanNumerals.of(number));
    }

    @Test
    public void convertsOne() {
        assertRoman("I", 1);
    }
    @Test
    public void convertsTwo() {
        assertRoman("II", 2);
    }
    @Test
    public void convertsThree() {
        assertRoman("III", 3);
    }

    @Test
    public void convertsFive() {
        assertRoman("V", 5);
    }

    @Test
    public void convertsSix() {
        assertRoman("VI", 6);
    }

    @Test
    public void convertsFour() {
        assertRoman("IV", 4);
    }



}
