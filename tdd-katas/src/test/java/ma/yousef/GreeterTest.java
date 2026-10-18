package ma.yousef;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Yousef ELHAID
 */
public class GreeterTest {

    private Greeter greeter;

    @Before
    public void setUp() {
        greeter = new Greeter();
    }

    @Test
    public void greetsPersonByName() {
        assertEquals("Bonjour Yousef", greeter.greet("Yousef"));
    }

    @Test
    public void greetsAnotherPerson() {
        assertEquals("Bonjour Sara", greeter.greet("Sara"));
    }

    @Test
    public void greetsUnknownWhenNameIsNull() {
        assertEquals("Bonjour inconnu", greeter.greet(null));
    }
}