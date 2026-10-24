package com.theodo.vegas.a;

/**
 *
 * @author Yousef ELHAID
 */
public class Player {

    public int playWeek(int[]... days) {
        int total = 0;
        for (int[] day : days) {
            total = playDay(total, day);
        }
        return total;
    }

    public int playDay(int total, int... results) {
        if (isDrawOnFirstGame(results)) {
            return total;
        }
        if (isLossOnFirstGame(results)) {
            return total / 2;
        }
        int wins = results.length - 1;
        int lastResult = results[wins];
        return total + sumOfWins(results, wins) + wins * lastResult;
    }

    private boolean isDrawOnFirstGame(int[] results) {
        return results[0] == 0;
    }

    private boolean isLossOnFirstGame(int[] results) {
        return results[0] < 0;
    }

    private int sumOfWins(int[] results, int wins) {
        int sum = 0;
        for (int game = 0; game < wins; game++) {
            sum += results[game];
        }
        return sum;
    }
}