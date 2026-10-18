package ma.yousef.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Yousef ELHAID
 */
public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void gettingZeroFromZeros() {
        rollMany(20,0);
        assertEquals(0 , bowlingGame.score());
    }

    @Test
    public void gettingTwentyFromOnes() {
        rollMany(20,1);
        assertEquals(20,bowlingGame.score());
    }


    private void rollMany(int rolls, int pins){
        for (int i = 0 ; i < rolls ; i++) {
            bowlingGame.roll(pins);
        }
    }
}
