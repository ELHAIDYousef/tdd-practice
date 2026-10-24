package com.theodo.vegas.f;

import java.util.List;

/**
 *
 * @author Yousef ELHAID
 */
public class Player {

    public int playDay(int total, List<Integer> results) {
        if (isDrawOnFirstGame(results)) {
            return total;
        }
        if (isLossOnFirstGame(results)) {
            return total / 2;
        }
        return total + dayScore(results);
    }

    public int playWeek(List<List<Integer>> days) {
        int total = 0;
        for (List<Integer> day : days) {
            total = playDay(total, day);
        }
        return total;
    }

    private boolean isDrawOnFirstGame(List<Integer> results) {
        return results.get(0) == 0;
    }

    private boolean isLossOnFirstGame(List<Integer> results) {
        return results.get(0) < 0;
    }

    private int dayScore(List<Integer> results) {
        int wins = results.size() - 1;
        int lastResult = results.get(wins);
        int sumOfWins = results.subList(0, wins).stream()
                .mapToInt(Integer::intValue)
                .sum();
        return sumOfWins + wins * lastResult;
    }
}