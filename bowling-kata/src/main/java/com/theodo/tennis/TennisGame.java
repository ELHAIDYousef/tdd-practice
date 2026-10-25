package com.theodo.tennis;

/**
 *
 * @author Yousef ELHAID
 */
public class TennisGame {

    private static final String[] POINT_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};

    private final String player1Name;
    private final String player2Name;

    private int player1Points;
    private int player2Points;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName)) {
            player1Points++;
        } else if (player2Name.equals(playerName)) {
            player2Points++;
        } else {
            throw new IllegalArgumentException("Unknown player: " + playerName);
        }
    }

    public String getScore() {
        if (player1Points == player2Points) {
            return equalScore();
        }
        if (isEndGame()) {
            return endGameScore();
        }
        return POINT_NAMES[player1Points] + "-" + POINT_NAMES[player2Points];
    }

    private String equalScore() {
        if (player1Points >= 3) {
            return "Deuce";
        }
        return POINT_NAMES[player1Points] + "-All";
    }

    private boolean isEndGame() {
        return player1Points >= 4 || player2Points >= 4;
    }

    private String endGameScore() {
        if (Math.abs(player1Points - player2Points) >= 2) {
            return "Win for " + leaderName();
        }
        return "Advantage " + leaderName();
    }

    private String leaderName() {
        return player1Points > player2Points ? player1Name : player2Name;
    }
}