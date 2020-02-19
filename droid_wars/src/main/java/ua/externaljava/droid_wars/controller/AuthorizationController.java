package ua.externaljava.droid_wars.controller;

import ua.externaljava.droid_wars.exceptions.NoRecordException;
import ua.externaljava.droid_wars.models.user.User;
import ua.externaljava.droid_wars.services.DatabaseManipulator;
import ua.externaljava.droid_wars.view.AuthorizationView;
import ua.externaljava.droid_wars.view.RegistrationView;

import java.util.Scanner;

public class AuthorizationController {
    AuthorizationView authorizationView;

    public AuthorizationController(AuthorizationView authorizationView) {
        this.authorizationView = authorizationView;
    }

    public User adminAuthorization() {
        User authorizedUser = new User();
        String[] data;
        Scanner scanner = new Scanner(System.in);

        authorizationView.printAdminInvitation();

        while(true) {
            authorizationView.printEmailPrompt();
            String email = requestEmail(scanner);
            authorizationView.printPasswordPrompt();
            String password = requestPassword(scanner);

            try{
                data = DatabaseManipulator.getAdminData(email, password);
                break;
            } catch(NoRecordException e){
                authorizationView.printAuthorizationError();
            }

        }

        authorizedUser.setNickName(data[0]);
        authorizedUser.setRole(data[1]);
        authorizedUser.setEmail(data[2]);

        return authorizedUser;

    }

    public User userAuthorization() {
        User authorizedUser = new User();
        Scanner scanner = new Scanner(System.in);
        String[] data;

        authorizationView.printUserInvitation();

        while(true) {
            authorizationView.printEmailPrompt();
            String email = requestEmail(scanner);
            authorizationView.printPasswordPrompt();
            String password = requestPassword(scanner);

            try{
                data = DatabaseManipulator.getUserData(email, password);
                break;
            } catch(NoRecordException e){
                authorizationView.printAuthorizationError();
            }

        }

        authorizedUser.setNickName(data[0]);
        authorizedUser.setRole(data[1]);
        authorizedUser.setEmail(data[2]);

        return authorizedUser;

    }


    private String requestEmail(Scanner scan) {
        String email = "";

        while (true) {
            try {
                email = scan.next();
                if (!DatabaseManipulator.checkRecordByEmail(email)) {
                    throw new IllegalArgumentException(RegistrationView.INVALID_EMAIL);
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + RegistrationView.BLANK_SPACE + RegistrationView.TRY_AGAIN);
            }

        }

        return email;
    }

    private String requestPassword(Scanner scan) {
        String password = scan.next();
        return password;
    }


}
