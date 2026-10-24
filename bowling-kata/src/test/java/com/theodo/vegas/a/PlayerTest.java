package com.theodo.vegas.a;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {
        player = new Player();
    }

    @Test
    public void drawOnFirstGameKeepsTheTotal() {
        assertEquals(13, player.playDay(13, 0));
    }

    @Test
    public void lossOnFirstGameHalvesTheTotal() {
        assertEquals(15, player.playDay(30, -1));
    }

    @Test
    public void oneWinThenDraw() {
        assertEquals(20, player.playDay(19, 1, 0));
    }

    @Test
    public void oneWinThenLoss() {
        assertEquals(19, player.playDay(15, 5, -1));
    }

    @Test
    public void manyWinsThenLoss() {
        assertEquals(16, player.playDay(0, 5, 5, 5, 5, -1));
    }

    @Test
    public void manyWinsThenDraw() {
        assertEquals(26, player.playDay(16, 5, 5, 0));
    }

    @Test
    public void dayScoreCanBeNegative() {
        assertEquals(-9, player.playDay(0, 1, -10));
    }

    @Test
    public void oddTotalIsHalvedDown() {
        assertEquals(6, player.playDay(13, -1));
    }

    @Test
    public void sevenDrawsGiveZero() {
        assertEquals(0, player.playWeek(
                day(0), day(0), day(0), day(0), day(0), day(0), day(0)));
    }

    @Test
    public void weekFromTheStatementGivesTwenty() {
        assertEquals(20, player.playWeek(
                day(5, 5, 5, 5, -1), // jour 1 → 16
                day(5, 5, 0), // jour 2 → 26
                day(-2), // jour 3 → 13
                day(0), // jour 4 → 13
                day(3, 3, -2), // jour 5 → 15
                day(5, -1), // jour 6 → 19
                day(1, 0))); // jour 7 → 20
    }

    private static int[] day(int... results) {
        return results;
    }

}
