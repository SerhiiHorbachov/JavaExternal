package ua.externaljava.game.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serhii Horbachov Feb 2020.
 *
 */
public class GameModel {
    private int minValue;
    private int maxValue;
    private int numberToGuess;

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

    public int getNumberToGuess() {
        return numberToGuess;
    }

    public void setNumberToGuess(int randomNumber) {
        this.numberToGuess = randomNumber;
    }

    public void addResponse(int response){
        previousResponses.add(response);
    }

    public List<Integer> getPreviousResponses() {
        return previousResponses;
    }



}
