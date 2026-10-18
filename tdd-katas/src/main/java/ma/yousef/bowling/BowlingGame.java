package ma.yousef.bowling;

/**
 *
 * @author Yousef ELHAID
 */
public class BowlingGame {

    private int score;

    public void roll(int pins) {
        score += pins;
    }

    public int score() {
        return score;
    }
}
