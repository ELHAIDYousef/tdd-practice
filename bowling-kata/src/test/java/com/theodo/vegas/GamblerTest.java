package com.theodo.vegas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class GamblerTest {

    private Gambler gambler;

    @Before
    public void setUp() {
        gambler = new Gambler();
    }

    @Test
    public void drawGameKeepsTheTotalAtZero() {
        playAll(0);
        assertEquals(0, gambler.total());
    }

    @Test
    public void winThenDrawKeepsTheTotal() {
        playAll(5, 0);
        assertEquals(5, gambler.total());
    }

    @Test
    public void finalTotalOfGainsIsMultipliedByNumberOfWins() {
        playAll(5, 5, 5, 5, -1);
        assertEquals(16, gambler.total());
    }

    @Test
    public void winsCounterResetEveryDay() {
        playAll(5, 0);
        playAll(5, 5, -1);
        assertEquals(13, gambler.total());
    }

    @Test
    public void lossAtFirstGameHalvesTheTotal() {
        playAll(5, 5, 0);
        playAll(-1);
        assertEquals(5, gambler.total());
    }

    @Test
    public void allDaysScoresTheRightTotal() {
        playAll(5, 5, 5, 5, -1);
        playAll(5, 5, 0);
        playAll(-2);
        playAll(0);
        playAll(3, 3, -2);
        playAll(5, -1);
        playAll(1, 0);
        assertEquals(20, gambler.total());
    }

    @Test
    public void totalIsNotAvailableWhileTheDayIsInProgress() {
        playAll(5); // gain → la journée continue
        IllegalStateException e = assertThrows(
                IllegalStateException.class,
                () -> gambler.total());
        assertEquals("The day is not over", e.getMessage());
    }

    // =================== Private helper methods ===================

    private void playAll(int... results) {
        for (int result : results) {
            gambler.play(result);
        }
    }

}
