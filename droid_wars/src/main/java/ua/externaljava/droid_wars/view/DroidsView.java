package ua.externaljava.droid_wars.view;

public class DroidsView {

    public static final String BEFORE_ROUND = "Before round: ";
    public static final String AFTER_ROUND = "After round: ";
    public static final String LINE_SEPARATOR = ".....";
    public static final String ITERATION_SEPARATOR = "------";
    private static final String COLON_SPACE = ": ";
    public static final String ROUND = "ROUND ";

    public void printState(String name, int amount) {
        System.out.println(name + COLON_SPACE + amount);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printName(String name) {
        System.out.println(name);
    }

    public void printStatistics(String statistics) {
        System.out.println(statistics);
    }

}
