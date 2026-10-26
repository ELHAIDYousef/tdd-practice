package com.theodo.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

    private BowlingGame game;

    @Before 
    public void setUp() {
        game = new BowlingGame();
    }

    @Test 
    public void gutterGameScoreZero() {
        roll(20, 0);
        assertEquals(0, game.score());
    }

    @Test 
    public void fourThenThreeInAllFramesScoreSeventy() {
        rollFrame(10, 4, 3);
        assertEquals(70, game.score());
    }

    @Test 
    public void oneSpareAddsTheNextRoll() {
        rollAll(4, 6, 5, 3);
        roll(16, 0);
        assertEquals(23, game.score());
    }

    @Test 
    public void oneStrikeAddsTheNextTwoRolls() {
        rollAll(10, 5, 3);
        assertEquals(26, game.score());
    }

    @Test 
    public void perfectGameScores300() {
        roll(12, 10);
        assertEquals(300, game.score());
    }

    // ================== private helper methods ==================


    private void roll(int rolls, int pins) { 
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

    private void rollFrame(int frames, int firstRoll, int secondRoll) {
        for (int i = 0; i < frames; i++) {
            game.roll(firstRoll);
            game.roll(secondRoll);
        }
    }

    private void rollAll(int... pins) {
        for (int pin : pins) {
            game.roll(pin);
        }
    }
    
}