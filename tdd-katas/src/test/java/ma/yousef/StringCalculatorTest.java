package ma.yousef;

import org.junit.Test;

import static ma.yousef.StringCalculator.add;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 *
 * @author Yousef ELHAID
 */
public class StringCalculatorTest {

    @Test
    public void emptyStringReturnsZero() {
        assertEquals(0, add(""));
    }

    @Test
    public void singleNumberReturnsItself() {
        assertEquals(1, add("1"));
    }

    @Test
    public void twoNumbersAreSummed() {
        assertEquals(3, add("1,2"));
    }

    @Test
    public void anyAmountOfNumbersIsSummed() {
        assertEquals(10, add("1,2,3,4"));
    }

    @Test
    public void newLineIsAlsoADelimiter() {
        assertEquals(6, add("1\n2,3"));
    }

    @Test
    public void customDelimiterCanBeDefined() {
        assertEquals(3, add("//;\n1;2"));
    }

    @Test
    public void regexSpecialCharacterCanBeACustomDelimiter() {
        assertEquals(3, add("//.\n1.2"));
    }

    @Test
    public void customDelimiterCanHaveSeveralCharacters() {
        assertEquals(6, add("//***\n1***2***3"));
    }

    @Test
    public void negativeNumberIsRejected() {
        assertRejected("1,-2", "Négatifs interdits : -2");
    }

    @Test
    public void allNegativeNumbersAreListedInMessage() {
        assertRejected("1,-2,-3", "Négatifs interdits : -2, -3");
    }

    @Test
    public void numbersBiggerThan1000AreIgnored() {
        assertEquals(2, add("2,1001"));
    }

    @Test
    public void thousandIsStillCounted() {
        assertEquals(1002, add("2,1000"));
    }

    private void assertRejected(String input, String expectedMessage) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> add(input));
        assertEquals(expectedMessage, e.getMessage());
    }
}