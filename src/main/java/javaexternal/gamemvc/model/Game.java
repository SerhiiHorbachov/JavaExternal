package javaexternal.gamemvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private final static int DEFAULT_RAND_MIN = 0;
    private final static int DEFAULT_RAND_MAX = 100;

    private int minValue;
    private int maxValue;
    private int randomNumber;
    Random r;

    List<Integer> previousResponses = new ArrayList();

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void memorizeResponse(int userResponse){
        previousResponses.add(userResponse);
    }

    public List<Integer> getPreviousResponses() {
        return previousResponses;
    }

    public static int getDefaultRandMax() {
        return DEFAULT_RAND_MAX;
    }
}
