package ma.yousef;

/**
 *
 * @author Yousef ELHAID
 */
public class Greeter {

    public String greet(String name) {
        return "Bonjour " + (name == null ? "inconnu" : name);
    }
}