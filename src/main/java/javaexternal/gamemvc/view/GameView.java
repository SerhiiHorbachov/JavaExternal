package javaexternal.gamemvc.view;

import java.util.List;

public class GameView {
    public static String USER_MIN_RANGE_INPUT_MESSAGE = "Please input min range value, INT: ";
    public static String USER_MAX_RANGE_INPUT_MESSAGE = "Please input max range value, INT: ";
    public static final String WRONG_INPUT_DATA = "Wrong input! Repeat please! ";
    public static final String MAX_LESS_MIN_VALUE_ERROR = "Max value cannot be less than min value.";
    public static final String TRY_AGAIN = "You didn't guess the number, try again...";
    public static final String GREATER = "The number to guess is greater than your number.";
    public static final String LESS = "The number to guess is less than your number.";
    private static String SUCCESS_MESSAGE = "Congrats, you won the game! ;)";

    public void printPreviousAttempts(List<Integer> integerList, int min, int max) {
        System.out.println("Range: " + min + " to " + max);

        if (!integerList.isEmpty()) {
            System.out.print("Previous attempts: ");
            for (int i = 0; i < integerList.size(); i++) {
                System.out.print(integerList.get(i) + ", ");
            }
            System.out.print("\n");
            System.out.println("Your last try: " + integerList.get(integerList.size() - 1));
        }
    }

    public void printGameStatistics(List<Integer> integerList, int min, int max) {
        System.out.println(SUCCESS_MESSAGE);
        System.out.println("Number of attempts: " + integerList.size());
        printPreviousAttempts(integerList, min, max);
    }

    public void printRequestToEnterNumber(int min, int max) {
        System.out.println("Guess the number in range: " + min + " to " + max);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
