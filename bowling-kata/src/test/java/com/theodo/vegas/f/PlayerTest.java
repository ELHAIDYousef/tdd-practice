package com.theodo.vegas.f;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
    public void drawOnFirstGameKeepsTheTotal() {
        assertEquals(13, playDay(13, 0));
    }

    @Test
    public void lossOnFirstGameHalvesTheTotal() {
        assertEquals(15, playDay(30, -1));
    }

    @Test
    public void oneWinThenDraw() {
        assertEquals(20, playDay(19, 1, 0));
    }

    @Test
    public void oneWinThenLoss() {
        assertEquals(19, playDay(15, 5, -1));
    }

    @Test
    public void manyWinsThenLoss() {
        assertEquals(16, playDay(0, 5, 5, 5, 5, -1));
    }

    @Test
    public void manyWinsThenDraw() {
        assertEquals(26, playDay(16, 5, 5, 0));
    }

    @Test
    public void dayScoreCanBeNegative() {
        assertEquals(-9, playDay(0, 1, -10));
    }

    @Test
    public void oddTotalIsHalvedDown() {
        assertEquals(6, playDay(13, -1));
    }

    // --- Une semaine ---
    @Test
    public void sevenDrawsGiveZero() {
        List<List<Integer>> days = List.of(
                day(0), day(0), day(0), day(0), day(0), day(0), day(0));

        assertEquals(0, player.playWeek(days));
    }

    @Test
    public void weekFromTheStatementGivesTwenty() {
        List<List<Integer>> days = List.of(
                day(5, 5, 5, 5, -1),   // jour 1 → 16
                day(5, 5, 0),          // jour 2 → 26
                day(-2),               // jour 3 → 13
                day(0),                // jour 4 → 13
                day(3, 3, -2),         // jour 5 → 15
                day(5, -1),            // jour 6 → 19
                day(1, 0));            // jour 7 → 20

        assertEquals(20, player.playWeek(days));
    }

    private int playDay(int total, Integer... results) {
        return player.playDay(total, day(results));
    }

    private List<Integer> day(Integer... results) {
        return List.of(results);
    }
}