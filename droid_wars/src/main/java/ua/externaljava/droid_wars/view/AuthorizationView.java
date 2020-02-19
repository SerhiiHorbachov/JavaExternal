package ua.externaljava.droid_wars.view;

public class AuthorizationView{

    public static final String AUTHORIZE_ADMIN_INVITATION = "Please authorize as an administrator";
    public static final String AUTHORIZE_USER_INVITATION = "Please authorize as a user";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String AUTHORIZATION_ERROR = "No record found.";

    public void printAdminInvitation(){
        System.out.println(AUTHORIZE_ADMIN_INVITATION);
    }

    public void printUserInvitation(){
        System.out.println(AUTHORIZE_USER_INVITATION);
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


}
