package ua.externaljava.droid_wars.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class RegistrationView {

    private static final String MESSAGES_BUNDLE_NAME = "messages";

    private static final String CHOOSE_ROLE = "choose_role";
    public static final String ROLE_ADMIN = "role_admin";
    public static final String ROLE_USER = "role_user";
    private static final String NICK_NAME_REQUEST = "nick_name_request";
    private static final String EMAIL_REQUEST = "email_request";
    private static final String PASSWORD_REQUEST = "password_request";
    public static final String BLANK_SPACE = " ";
    private static final String COLON = ":";
    private static final String DASH = "-";
    private static final String COMMA = ",";
    private static final String OPTION_ADMIN = "A";
    private static final String OPTION_USER = "U";
    private static final String REGISTRATION_SUCCESS = "registration_success";
    public static final String TRY_AGAIN = "try_again";
    public static final String INVALID_ROLE = "invalid_role";
    public static final String INVALID_EMAIL = "invalid_email";
    public static final String PWD_REQUIREMENT = "password_requirement";
    public static final String NICKNAME_REQUIREMENT = "nickname_requirement";
    public static final String EMAIL_EXISTS = "email_exists";

    public ResourceBundle bundle;

    public RegistrationView(String language) {
        bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, new Locale(language));
    }

    public void printInvitation() {
        System.out.println(bundle.getString(CHOOSE_ROLE) + COLON + BLANK_SPACE + OPTION_ADMIN + DASH + bundle.getString(ROLE_ADMIN) + COMMA + BLANK_SPACE + OPTION_USER + DASH + bundle.getString(ROLE_USER));
    }

    public void printNickNameRequest() {
        System.out.println(bundle.getString(NICK_NAME_REQUEST));
    }

    public void printEmailRequest() {
        System.out.println(bundle.getString(EMAIL_REQUEST));
    }

    public void printPasswordRequest() {
        System.out.println(bundle.getString(PASSWORD_REQUEST));
    }

    public void printRegistrationSuccess(String name){
        System.out.println(name + COMMA + BLANK_SPACE + bundle.getString(REGISTRATION_SUCCESS));
    }

    public void printWrong(){
        System.out.println(bundle.getString(TRY_AGAIN));
    }

    public void printMessage(String message) {
        System.out.println(message);
    }


}
