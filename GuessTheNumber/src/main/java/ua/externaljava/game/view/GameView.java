package ua.externaljava.game.view;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Serhii Horbachov Feb 2020.
 *
 */
public class GameView {

    // Resource Bundle Installation's
    static String MESSAGES_BUNDLE_NAME = "localization";
    public static final ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, new Locale("ua"));

    private static final String EQUALS = "=";
    private static final String BLANK = " ";
    private static final String COLON = ":";

    public static final String USER_MIN_RANGE_INPUT_MESSAGE = "USER_MIN_RANGE_INPUT_MESSAGE";
    public static final String USER_MAX_RANGE_INPUT_MESSAGE = "USER_MAX_RANGE_INPUT_MESSAGE";
    public static final String WRONG_INPUT_DATA = "WRONG_INPUT_DATA";
    public static final String MAX_LESS_MIN_VALUE_ERROR = "MAX_LESS_MIN_VALUE_ERROR";
    public static final String TRY_AGAIN = "TRY_AGAIN";
    public static final String GREATER = "GREATER";
    public static final String LESS = "LESS";
    private static final String SUCCESS_MESSAGE = "SUCCESS_MESSAGE";
    private static final String REQUEST_TO_ENTER_NUMBER = "REQUEST_TO_ENTER_NUMBER";
    private static final String PREVIOUS_ATTEMPTS = "PREVIOUS_ATTEMPTS";
    private static final String RANGE = "RANGE";
    private static final String LAST_TRY = "LAST_TRY";
    private static final String NUMBER_OF_ATTEMPTS = "NUMBER_OF_ATTEMPTS";

    public void printPreviousAttempts(List<Integer> integerList, int min, int max) {
        System.out.println(bundle.getString("RANGE") + COLON + BLANK + min + BLANK + max);

        if (!integerList.isEmpty()) {
            System.out.print(bundle.getString("PREVIOUS_ATTEMPTS") + COLON + BLANK);
            for (int i = 0; i < integerList.size(); i++) {
                System.out.print(integerList.get(i) + ", ");
            }
            System.out.print("\n");
            System.out.println(bundle.getString("LAST_TRY") + COLON + BLANK + integerList.get(integerList.size() - 1));
        }
    }

    public void printGameStatistics(List<Integer> integerList, int min, int max) {
        System.out.println(bundle.getString(SUCCESS_MESSAGE));
        System.out.println(bundle.getString(NUMBER_OF_ATTEMPTS)+ COLON + BLANK + integerList.size());
        printPreviousAttempts(integerList, min, max);
    }

    public void printRequestToEnterNumber(int min, int max) {
        System.out.println(bundle.getString(REQUEST_TO_ENTER_NUMBER) + BLANK + min + BLANK + max);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
