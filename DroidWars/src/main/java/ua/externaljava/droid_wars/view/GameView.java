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
    public static final String NO_DROIDS_TO_EDIT = "no_droids_to_edit";
    public static final String CHOOSE_DROIDS_TO_UPDATE = "choose_droid_to_update";
    public static final String SET_ENERGY_LEVEL = "set_energy_level";
    public static final String SET_HEALTH_LEVEL = "set_health_level";
    public static final String SET_PROTECTION_LEVEL = "set_protection_level";
    private static final String CHOOSE_ROLE = "choose_role";
    public static final String BLANK_SPACE = " ";
    private static final String COLON = ":";
    private static final String DASH = "-";
    private static final String COMMA = ",";
    private static final String OPTION_ADMIN = "A";
    private static final String OPTION_USER = "U";
    public static final String ROLE_ADMIN = "role_admin";
    public static final String ROLE_USER = "role_user";
    private static final String EMAIL_REQUEST = "email_request";
    public static final String EMAIL_EXISTS = "email_exists";
    private static final String NICK_NAME_REQUEST = "nick_name_request";
    private static final String PASSWORD_REQUEST = "password_request";
    private static final String REGISTRATION_SUCCESS = "registration_success";
    public static final String INVALID_EMAIL = "invalid_email";
    public static final String PWD_REQUIREMENT = "password_requirement";
    public static final String NICKNAME_REQUIREMENT = "nickname_requirement";
    public static final String INVALID_ROLE = "invalid_role";
    public static final String AUTHORIZE_ADMIN_INVITATION = "authorize_admin_invitation";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String AUTHORIZATION_ERROR = "No record found.";
    public static final String AUTHORIZE_USER_INVITATION = "Please authorize as a user";

    public ResourceBundle bundle;

    public GameView(String language) {
        bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, new Locale(language));
    }

    public void printInvitation() {
        System.out.println(bundle.getString(CHOOSE_ROLE) + COLON + BLANK_SPACE + OPTION_ADMIN + DASH + bundle.getString(ROLE_ADMIN) + COMMA + BLANK_SPACE + OPTION_USER + DASH + bundle.getString(ROLE_USER));
    }

    public void printEmailRequest() {
        System.out.println(bundle.getString(EMAIL_REQUEST));
    }

    public void printEmailExists() {
        System.out.println(bundle.getString(EMAIL_EXISTS));
    }

    public void printNickNameRequest() {
        System.out.println(bundle.getString(NICK_NAME_REQUEST));
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printUserMenu() {
        System.out.println(bundle.getString(USER_MENU_OPTION));
    }

    public void printPasswordRequest() {
        System.out.println(bundle.getString(PASSWORD_REQUEST));
    }

    public void printRegistrationSuccess(String name) {
        System.out.println(name + COMMA + BLANK_SPACE + bundle.getString(REGISTRATION_SUCCESS));
    }

    public void printInvalidEmail() {
        System.out.println(bundle.getString(INVALID_EMAIL));
    }

    public void printAdminInvitation(){
        System.out.println(bundle.getString(AUTHORIZE_ADMIN_INVITATION));
    }

    public void printEmailPrompt(){
        System.out.println(EMAIL);
    }

    public void printPasswordPrompt(){
        System.out.println(PASSWORD);
    }

    public void printAuthorizationError(){
        System.out.println(AUTHORIZATION_ERROR);
    }

    public void printUserInvitation(){
        System.out.println(AUTHORIZE_USER_INVITATION);
    }

}
