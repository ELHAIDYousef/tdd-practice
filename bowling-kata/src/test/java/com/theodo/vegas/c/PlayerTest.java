package com.theodo.vegas.c;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Yousef ELHAID
 */
public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {
        player = new Player();
    }

    // --- Une journée ---
    @Test
    public void newPlayerHasZeroTotal() {
        assertEquals(0, player.total());
    }

    @Test
    public void oneWinThenDraw() {
        playGames(5, 0);

        assertEquals(5, player.total());
    }

    @Test
    public void oneWinThenLoss() {
        playGames(5, -1);

        assertEquals(4, player.total());
    }

    @Test
    public void manyWinsThenLoss() {
        playGames(5, 5, 5, 5, -1);

        assertEquals(16, player.total());
    }

    @Test
    public void dayScoreCanBeNegative() {
        playGames(1, -10);

        assertEquals(-9, player.total());
    }

    // --- Plusieurs journées ---
    @Test
    public void countersRestartEachDay() {
        playGames(5, -1,   // jour 1 → 4
                  5, -1);  // jour 2 → 8

        assertEquals(8, player.total());
    }

    @Test
    public void lossOnFirstGameHalvesTheTotal() {
        playGames(5, -1,   // jour 1 → 4
                  -1);     // jour 2 → 4 ÷ 2

        assertEquals(2, player.total());
    }

    @Test
    public void totalIsNotAvailableDuringAnUnfinishedDay() {
        playGames(5);

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> player.total());

        assertEquals("The day is not finished: keep playing", exception.getMessage());
    }

    // --- La semaine ---
    @Test
    public void weekFromTheStatementGivesTwenty() {
        playTheWeekFromTheStatement();

        assertEquals(20, player.total());
    }

    @Test
    public void playingAfterSevenDaysIsRejected() {
        playTheWeekFromTheStatement();

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> player.play(1));

        assertEquals("The week is over: 7 days already played", exception.getMessage());
    }

    private void playTheWeekFromTheStatement() {
        playGames(5, 5, 5, 5, -1,   // jour 1 → 16
                  5, 5, 0,          // jour 2 → 26
                  -2,               // jour 3 → 13
                  0,                // jour 4 → 13
                  3, 3, -2,         // jour 5 → 15
                  5, -1,            // jour 6 → 19
                  1, 0);            // jour 7 → 20
    }

    private void playGames(int... results) {
        for (int result : results) {
            player.play(result);
        }
    }
}