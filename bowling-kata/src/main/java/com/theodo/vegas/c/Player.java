package com.theodo.vegas.c;

/**
 *
 * @author Yousef ELHAID
 */
public class Player {

    private static final int DAYS_IN_WEEK = 7;

    private int total;
    private int wins;
    private int daysPlayed;

    public int total() {
        if (isDayInProgress()) {
            throw new IllegalStateException("The day is not finished: keep playing");
        }
        return total;
    }

    public void play(int result) {
        if (isWeekOver()) {
            throw new IllegalStateException("The week is over: 7 days already played");
        }
        if (result > 0) {
            win(result);
        } else {
            endDay(result);
        }
    }

    private void win(int result) {
        total += result;
        wins++;
    }

    private void endDay(int lastResult) {
        if (isLossOnFirstGame(lastResult)) {
            total /= 2;
        } else {
            total += wins * lastResult;
        }
        wins = 0;
        daysPlayed++;
    }

    private boolean isLossOnFirstGame(int lastResult) {
        return wins == 0 && lastResult < 0;
    }

    private boolean isDayInProgress() {
        return wins > 0;
    }

    private boolean isWeekOver() {
        return daysPlayed >= DAYS_IN_WEEK;
    }
}   