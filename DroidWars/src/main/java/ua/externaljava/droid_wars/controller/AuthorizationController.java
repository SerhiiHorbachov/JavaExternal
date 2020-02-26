package ua.externaljava.droid_wars.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.externaljava.droid_wars.exceptions.NoRecordException;
import ua.externaljava.droid_wars.models.user.User;
import ua.externaljava.droid_wars.services.DatabaseManipulator;
import ua.externaljava.droid_wars.view.GameView;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AuthorizationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);

    private GameView gameView;


    public AuthorizationController(GameView gameView) {
        this.gameView = gameView;
    }

    public User adminAuthorization() {
        User authorizedUser = new User();
        String[] data;
        Scanner scanner = new Scanner(System.in);

        gameView.printAdminInvitation();

        while(true) {
            gameView.printEmailPrompt();
            String email = requestEmail(scanner);
            gameView.printPasswordPrompt();
            String password = requestPassword(scanner);

            try{
                data = DatabaseManipulator.getAdminData(email, password);
                break;
            } catch(NoRecordException e){
                logger.error(e.getMessage(), e);
                gameView.printAuthorizationError();
            }

        }

        authorizedUser.setNickName(data[0]);
        authorizedUser.setRole(data[1]);
        authorizedUser.setEmail(data[2]);

        logger.info("Authorized:{} {}", authorizedUser.toString(), LocalDateTime.now());

        return authorizedUser;
    }

    public User userAuthorization() {
        User authorizedUser = new User();
        Scanner scanner = new Scanner(System.in);
        String[] data;

        gameView.printUserInvitation();

        while(true) {
            gameView.printEmailPrompt();
            String email = requestEmail(scanner);
            gameView.printPasswordPrompt();
            String password = requestPassword(scanner);

            try{
                data = DatabaseManipulator.getUserData(email, password);
                break;
            } catch(NoRecordException e){
                logger.error(e.getMessage(), e);
                gameView.printAuthorizationError();
            }

        }

        authorizedUser.setNickName(data[0]);
        authorizedUser.setRole(data[1]);
        authorizedUser.setEmail(data[2]);

        logger.info("Authorized:{} {}", authorizedUser.toString(), LocalDateTime.now());

        return authorizedUser;

    }


    private String requestEmail(Scanner scan) {
        String email = "";

        while (true) {
            try {
                email = scan.next();
                if (!DatabaseManipulator.checkRecordByEmail(email)) {
                    throw new IllegalArgumentException(gameView.bundle.getString(GameView.INVALID_EMAIL));
                }
                break;
            } catch (IllegalArgumentException e) {
                logger.error(e.getMessage(), e);
                System.out.println(e.getMessage());
            }

        }

        return email;
    }

    private String requestPassword(Scanner scan) {
        String password = scan.next();
        return password;
    }

}
