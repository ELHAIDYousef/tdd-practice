package ma.yousef;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Yousef ELHAID
 */

@RunWith(Parameterized.class)
public class FizzBuzzTest {

    @Parameterized.Parameters(name = "{0} -> {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, "1"}, {2, "2"},
                {3, "Fizz"}, {6, "Fizz"},
                {5, "Buzz"}, {10, "Buzz"},
                {7, "Whizz"}, {14, "Whizz"},
                {15, "FizzBuzz"}, {30, "FizzBuzz"},
                {21, "FizzWhizz"}, {35, "BuzzWhizz"},
                {13 , "Rizz"},
                {105, "FizzBuzzWhizz"}

        });
    }

    private final int number;
    private final String expected;

    public FizzBuzzTest(int number, String expected) {
        this.number = number;
        this.expected = expected;
    }

    @Test
    public void convertsNumberToFizzBuzzWord() {
        assertEquals(expected, FizzBuzz.of(number));
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectZero(){
        FizzBuzz.of(0);
    }


}
