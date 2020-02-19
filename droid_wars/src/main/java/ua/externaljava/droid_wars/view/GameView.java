package ua.externaljava.droid_wars.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class GameView {
    private static final String MESSAGES_BUNDLE_NAME = "messages";
    public static final String MAIN_MENU_OPERATIONS = "main_menu_operations";
    public static final String NOT_SUPPORTED_OPERATION = "not_supported_option";
    public static final String ADMIN_MENU_OPTION = "admin_menu_options";
    public static final String USER_MENU_OPTION = "user_menu_options";
    public static final String DROIDS_OPTIONS = "droids_options";
    public static final String NO_DROIDS = "no_droids";
    public static final String CHOOSE_DROID = "choose_droids";
    public static final String TRY_AGAIN = "try_again";

    public ResourceBundle bundle;


    public GameView(String language) {
        bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, new Locale(language));
    }
    public void printMessage(String message){
        System.out.println(message);
    }
}
