package ua.externaljava.droid_wars.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.externaljava.droid_wars.models.user.User;
import ua.externaljava.droid_wars.services.DatabaseManipulator;
import ua.externaljava.droid_wars.view.GameView;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Pattern;


public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    private static final String ROLE_PATTERN = "[a,A,u,U]";
    private static final String EMAIL_PATTERN = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    private static final String NICKNAME_PATTERN = "^[a-zA-z0-9]{5,}$";
    private static final String PWD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    User user;
    GameView gameView;

    public RegistrationController(GameView gameView) {
        this.gameView = gameView;
        user = new User();
    }

    public void register() {
        Scanner scanner = new Scanner(System.in);
        gameView.printInvitation();
        user.setRole(requestRole(scanner));

        gameView.printEmailRequest();

        while (true) {
            user.setEmail(requestEmail(scanner));
            if (DatabaseManipulator.checkRecordByEmail(user.getEmail())) {
                gameView.printEmailExists();
            } else {
                break;
            }
        }

        gameView.printNickNameRequest();
        user.setNickName(requestNickname(scanner));
        gameView.printPasswordRequest();
        user.setPassword(requestPassword(scanner));
        gameView.printRegistrationSuccess(user.getNickName());
        DatabaseManipulator.saveRecord(user.getNickName(), user.getRole(), user.getEmail(), user.getPassword());

        logger.info("Registered:{} {}", user.toString(), LocalDateTime.now());
    }

    private String requestRole(Scanner scan) {
        Pattern pattern = Pattern.compile(ROLE_PATTERN);
        String token = "";

        while (true) {
            try {
                token = scan.next();
                if (!pattern.matcher(token).matches()) {
                    throw new IllegalArgumentException(gameView.bundle.getString(GameView.INVALID_ROLE));
                }
                break;
            } catch (IllegalArgumentException e) {
                logger.error(e.getMessage(), e);
                System.out.println(e.getMessage());
                gameView.printInvitation();
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
                    throw new IllegalArgumentException(gameView.bundle.getString(gameView.INVALID_EMAIL));
                }
                break;
            } catch (IllegalArgumentException e) {
                logger.error(e.getMessage(), e);
                System.out.println(e.getMessage() + GameView.BLANK_SPACE + gameView.bundle.getString(GameView.TRY_AGAIN));
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
                    throw new IllegalArgumentException(gameView.bundle.getString(GameView.NICKNAME_REQUIREMENT));
                }
                break;
            } catch (IllegalArgumentException e) {
                logger.error(e.getMessage(), e);
                System.out.println(e.getMessage() + GameView.BLANK_SPACE + gameView.bundle.getString(GameView.TRY_AGAIN));
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
                    throw new IllegalArgumentException(gameView.bundle.getString(GameView.PWD_REQUIREMENT));
                }
                break;
            } catch (IllegalArgumentException e) {
                logger.error(e.getMessage(), e);
                System.out.println(e.getMessage() + GameView.BLANK_SPACE + gameView.bundle.getString(GameView.TRY_AGAIN));
            }
        }

        return password;
    }


}
