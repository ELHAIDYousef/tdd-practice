package com.theodo.vegas;

public class Gambler {
    private int total;
    private int wins;

    public void play(int result) {
        if (lossFirstGame(result)) {
            total /= 2;
        } else if (isWin(result)) {
            win(result);
        } else {
            endOfDay(result);
        }
    }

    public int total() {
        if (isDayInProgress()) {
            throw new IllegalStateException("The day is not over");
        }
        return total;
    }

    

    // =================== Private helper methods ===================

    private boolean isWin(int result) {
        return result > 0;
    }

    private void win(int result) {
        total += result;
        wins++;
    }

    private void endOfDay(int result) {
        total += result * wins;
        wins = 0;
    }

    private boolean lossFirstGame(int result) {
        return result < 0 && wins == 0;
    }

    private boolean isDayInProgress() {
        return wins > 0;
    }

}