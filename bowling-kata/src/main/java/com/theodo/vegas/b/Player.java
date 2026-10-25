package com.theodo.vegas.b;

/**
 *
 * @author Yousef ELHAID
 */
public class Player {

    private final Game game;
    private final int DAYS = 7;

    public Player(Game game) {
        this.game = game;
    }
    public int playWeek() {
        int total = 0;
        for (int day = 0; day < DAYS; day++) {
            total = playDay(total);
        }

        return total;
    }

    public int playDay(int total) {
        int firstResult = nextResult();
        if (isLostOnTheFirstGame(firstResult)) {
            return total/2;
        }
        
        return total + dailyScore(firstResult);
        
    }


    


    private int nextResult() {
        return game.play();
    }

    private int dailyScore(int result) {
        int gains = 0;
        int wins = 0;
        while (isWinning(result)) {
            gains += result;
            wins++;
            result = nextResult();
        }
        return gains + wins * result;
    }

    private boolean isWinning(int result) {
        return result > 0;
    }

    private boolean isLostOnTheFirstGame(int result) {
        return result < 0;
    }


    
}