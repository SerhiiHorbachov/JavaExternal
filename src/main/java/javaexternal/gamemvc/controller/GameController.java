package javaexternal.gamemvc.controller;

import javaexternal.gamemvc.model.GameModel;
import javaexternal.gamemvc.view.GameView;

import java.util.Random;
import java.util.Scanner;

public class GameController {

    private final static int DEFAULT_RAND_MIN = 0;
    private final static int DEFAULT_RAND_MAX = 100;
    private int userMinValue;
    private int userMaxValue;

    private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void processUser(Scanner scan) {
        int tryCount = 0;

        while (true) {
            tryCount++;
            view.printRequestToEnterNumber(model.getMinValue(), model.getMaxValue());
            view.printPreviousAttempts(model.getPreviousResponses(), model.getMinValue(), model.getMaxValue());
            int userGuess = getIntFromUser(scan);
            model.addResponse(userGuess);
            if (model.getNumberToGuess() != userGuess) {
                view.printMessage(GameView.TRY_AGAIN);
                if (model.getNumberToGuess() < userGuess) {
                    view.printMessage(GameView.LESS);
                } else {
                    view.printMessage(GameView.GREATER);
                }
            } else {
                break;
            }

            if (tryCount == 1) {
                model.setMinValue(userMinValue);
                model.setMaxValue(userMaxValue);
                model.setNumberToGuess(rand(userMinValue, userMaxValue));
            }
        }

        view.printGameStatistics(model.getPreviousResponses(), model.getMinValue(), model.getMaxValue());
    }

    public void initGame(Scanner scan) {
        model.setMinValue(DEFAULT_RAND_MIN);
        model.setMaxValue(DEFAULT_RAND_MAX);
        model.setNumberToGuess(rand());
        view.printMessage(GameView.USER_MIN_RANGE_INPUT_MESSAGE);
        userMinValue = getIntFromUser(scan);
        view.printMessage(GameView.USER_MAX_RANGE_INPUT_MESSAGE);
        userMaxValue = getMaxValueFromUser(scan);
        processUser(scan);
    }

    public void setValueRange(int min, int max) {
        model.setMinValue(min);
        model.setMaxValue(max);
    }

    public void memorizeAttempt(int attemptNumber) {
        model.addResponse(attemptNumber);
    }

    private int getIntFromUser(Scanner scan) {
        while (!scan.hasNextInt()) {
            view.printMessage(GameView.WRONG_INPUT_DATA);
            scan.next();
        }
        return scan.nextInt();
    }

    private int getMaxValueFromUser(Scanner scan) {
        int number = 0;
        while (true) {
            while (!scan.hasNextInt()) {
                view.printMessage(GameView.WRONG_INPUT_DATA);
                scan.next();
            }
            number = scan.nextInt();
            if (number <= userMinValue) {
                view.printMessage(GameView.MAX_LESS_MIN_VALUE_ERROR);
                view.printMessage(GameView.USER_MAX_RANGE_INPUT_MESSAGE);
            } else {
                break;
            }
        }
        return number;
    }

    private int rand() {
        return new Random().nextInt((DEFAULT_RAND_MAX - DEFAULT_RAND_MIN) + 1) + DEFAULT_RAND_MIN;
    }

    private int rand(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

}
