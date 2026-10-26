package com.theodo.bowling;

/**
 *
 * @author Yousef ELHAID
 */
public class BowlingGame {

    private final int ALL_FRAMES = 10;

    private int[] score = new int[21];
    private int currentRoll;

    public void roll(int pins) {
        score[currentRoll++] = pins;
    }

    public int score() {
        int sum = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < ALL_FRAMES; frame++) {
            if (isStrike(frameIndex)) {
                sum += strikeBonus(frameIndex);
                frameIndex++;
            }
            else if (isSpare(frameIndex)) {
                sum += spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                sum += sumOfFrame(frameIndex);
                frameIndex += 2;
            }
                
            
        }
        return sum;
    }

    // ================== private helper methods ==================


    private boolean isStrike(int frameIndex) {
        return score[frameIndex] == 10;
    }

    private boolean isSpare(int frameIndex) {
        return sumOfFrame(frameIndex) == 10;
    }

    private int strikeBonus(int frameIndex) {
        return 10 + sumOfFrame(frameIndex + 1);
    }

    private int spareBonus(int frameIndex) {
        return 10 + score[frameIndex+ 2];
    }

    private int sumOfFrame(int frameIndex) {
        return score[frameIndex] + score[frameIndex+ 1];
    }
}