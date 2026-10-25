package com.theodo.vegas.b;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 *
 * @author Yousef ELHAID
 */
public class PlayerTest {

    @Test
    public void drawOnFirstGameKeepsTheTotal() {
        assertEquals(13, playerWith(0).playDay(13));
    }

    @Test
    public void lossOnFirstGameHalvesTheTotal() {
        assertEquals(10, playerWith(-1).playDay(20));
    }

    @Test
    public void oneWinThenDraw() {
        assertEquals(5, playerWith(5, 0).playDay(0));
    }

    @Test
    public void oneWinThenLoss() {
        assertEquals(19, playerWith(5, -1).playDay(15));
    }

    @Test
    public void manyWinsThenLoss() {
        assertEquals(16, playerWith(5, 5, 5, 5, -1).playDay(0));
    }

    @Test
    public void manyWinsThenDraw() {
        assertEquals(26, playerWith(5, 5, 0).playDay(16));
    }

    @Test
    public void dayScoreCanBeNegative() {
        assertEquals(-9, playerWith(1, -10).playDay(0));
    }

    @Test
    public void winningPlayerKeepsPlaying() {
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> playerWith(5).playDay(0));
        assertEquals("Game is not finish!!! keep playing...", exception.getMessage());
    }

    @Test
    public void sevenDrawsGiveZero() {
        assertEquals(0, playerWith(0, 0, 0, 0, 0, 0, 0).playWeek());
    }

    @Test
    public void weekFromTheStatementGivesTwenty() {
        Player player = playerWith(
                5, 5, 5, 5, -1, // jour 1 → 16
                5, 5, 0, // jour 2 → 26
                -2, // jour 3 → 13
                0, // jour 4 → 13
                3, 3, -2, // jour 5 → 15
                5, -1, // jour 6 → 19
                1, 0); // jour 7 → 20

        assertEquals(20, player.playWeek());
    }




    private Player playerWith(int... results) {
        PrimitiveIterator.OfInt iterator = IntStream.of(results).iterator();
        return new Player(() -> {
            if (!iterator.hasNext()) {
                throw new IllegalStateException("Game is not finish!!! keep playing...");
            }
            return iterator.nextInt();
        });
    }
}