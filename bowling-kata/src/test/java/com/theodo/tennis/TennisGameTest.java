package com.theodo.tennis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Yousef ELHAID
 */
public class TennisGameTest {

    private TennisGame game;

    @Before
    public void setUp() {
        game = new TennisGame("player1", "player2");
    }

    @Test
    public void newGameIsLoveAll() {
        assertEquals("Love-All", game.getScore());
    }

    @Test
    public void player1ScoresOnce() {
        pointsFor("player1", 1);
        assertEquals("Fifteen-Love", game.getScore());
    }

    @Test
    public void player1ScoresTwice() {
        pointsFor("player1", 2);
        assertEquals("Thirty-Love", game.getScore());
    }

    @Test
    public void player1ScoresThreeTimes() {
        pointsFor("player1", 3);
        assertEquals("Forty-Love", game.getScore());
    }

    @Test
    public void player2ScoresOnce() {
        pointsFor("player2", 1);
        assertEquals("Love-Fifteen", game.getScore());
    }

    @Test
    public void bothScoreOnce() {
        pointsFor("player1", 1);
        pointsFor("player2", 1);
        assertEquals("Fifteen-All", game.getScore());

    }

    @Test
    public void bothScoreTwice() {
        pointsFor("player1", 2);
        pointsFor("player2", 2);
        assertEquals("Thirty-All", game.getScore());
    }

    @Test
    public void bothScoreThreeTimesIsDeuce() {
        pointsFor("player1", 3);
        pointsFor("player2", 3);
        assertEquals("Deuce", game.getScore());
    }

    @Test
    public void player1WinsWithoutLosingAPoint() {
        pointsFor("player1", 4);
        assertEquals("Win for player1", game.getScore());
    }

    @Test
    public void player2WinsWithoutLosingAPoint() {
        pointsFor("player2", 4);

        assertEquals("Win for player2", game.getScore());
    }

    @Test
    public void advantagePlayer1() {
        pointsFor("player1", 5);
        pointsFor("player2", 4);
        assertEquals("Advantage player1", game.getScore());
    }

    @Test
    public void advantagePlayer2() {
        pointsFor("player2", 5);
        pointsFor("player1", 4);
        assertEquals("Advantage player2", game.getScore());

    }

    @Test
    public void backToDeuceAfterAdvantage() {
        pointsFor("player1", 3);
        pointsFor("player2", 3); // 3 – 3 : Deuce
        pointsFor("player1", 1); // 4 – 3 : Advantage player1
        pointsFor("player2", 1); // 4 – 4 : retour à Deuce

        assertEquals("Deuce", game.getScore());
    }

    @Test
    public void winAfterAdvantage() {
        pointsFor("player1", 3);
        pointsFor("player2", 3);
        pointsFor("player1", 1);
        pointsFor("player1", 1);

        assertEquals("Win for player1", game.getScore());
    }

    @Test
    public void unknownPlayerIsRejected() {
        assertThrows(IllegalArgumentException.class, 
            () -> game.wonPoint("bob"));
    }

    private void pointsFor(String player, int points) {
        for (int i = 0; i < points; i++) {
            game.wonPoint(player);
        }
    }

}