package ua.externaljava.droid_wars.controller;

import ua.externaljava.droid_wars.models.user.User;
import ua.externaljava.droid_wars.services.DatabaseManipulator;
import ua.externaljava.droid_wars.view.RegistrationView;

import java.util.Scanner;
import java.util.regex.Pattern;


public class RegistrationController {

    private static final String ROLE_PATTERN = "[a,A,u,U]";
    private static final String EMAIL_PATTERN = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    private static final String NICKNAME_PATTERN = "^[a-zA-z0-9]{5,}$";
    private static final String PWD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    User user;
    RegistrationView registration;

    public RegistrationController(RegistrationView registration) {
        this.registration = registration;
        user = new User();
    }

    public void register() {
        Scanner scanner = new Scanner(System.in);
        registration.printInvitation();
        user.setRole(requestRole(scanner));

        registration.printEmailRequest();

        while (true) {
            user.setEmail(requestEmail(scanner));
            if (DatabaseManipulator.checkRecordByEmail(user.getEmail())) {
                registration.printMessage(registration.EMAIL_EXISTS);
            } else {
                break;
            }
        }

        registration.printNickNameRequest();
        user.setNickName(requestNickname(scanner));
        registration.printPasswordRequest();
        user.setPassword(requestPassword(scanner));
        registration.printRegistrationSuccess(user.getNickName());
        System.out.println(user.toString());
        DatabaseManipulator.saveRecord(user.getNickName(), user.getRole(), user.getEmail(), user.getPassword());
    }

    private String requestRole(Scanner scan) {
        Pattern pattern = Pattern.compile(ROLE_PATTERN);
        String token = "";

        while (true) {
            try {
                token = scan.next();
                if (!pattern.matcher(token).matches()) {
                    throw new IllegalArgumentException(RegistrationView.INVALID_ROLE);
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                registration.printInvitation();
            }
        }

        if (token.equals("A") || token.equals("a")) {
            token = "admin";
        } else if (token.equals("U") || token.equals("u")) {
            token = "user";
        }

        return token;
    }

    private String requestEmail(Scanner scan) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        String email = "";

        while (true) {
            try {
                email = scan.next();
                if (!pattern.matcher(email).matches()) {
                    throw new IllegalArgumentException(registration.bundle.getString(RegistrationView.INVALID_EMAIL));
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + RegistrationView.BLANK_SPACE + registration.bundle.getString(RegistrationView.TRY_AGAIN));
            }

        }

        return email;
    }

    private String requestNickname(Scanner scan) {
        Pattern pattern = Pattern.compile(NICKNAME_PATTERN);
        String nickname = "";

        while (true) {
            try {
                nickname = scan.next();
                if (!pattern.matcher(nickname).matches()) {
                    throw new IllegalArgumentException(registration.bundle.getString(RegistrationView.NICKNAME_REQUIREMENT));
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + RegistrationView.BLANK_SPACE + registration.bundle.getString(RegistrationView.TRY_AGAIN));
            }

        }

        return nickname;
    }

    private String requestPassword(Scanner scan) {
        Pattern pattern = Pattern.compile(PWD_PATTERN);
        String password = "";

        while (true) {
            try {
                password = scan.next();
                if (!pattern.matcher(password).matches()) {
                    throw new IllegalArgumentException(registration.bundle.getString(RegistrationView.PWD_REQUIREMENT));
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + RegistrationView.BLANK_SPACE + registration.bundle.getString(RegistrationView.TRY_AGAIN));
            }

        }

        return password;
    }


}
