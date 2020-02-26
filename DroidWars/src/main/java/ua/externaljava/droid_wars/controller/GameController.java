package ua.externaljava.droid_wars.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.externaljava.droid_wars.factory.DroidFactory;
import ua.externaljava.droid_wars.helpers.Dialogs;
import ua.externaljava.droid_wars.helpers.Serializator;
import ua.externaljava.droid_wars.models.Game;
import ua.externaljava.droid_wars.models.droids.BattleDroid;
import ua.externaljava.droid_wars.view.GameView;

import java.util.Scanner;

public class GameController {
    private static final String SERIALIZATION_FILE_PATH = "src/main/resources/droids.data";
    private static final Logger logger = LoggerFactory.getLogger(GameController.class);

    DroidFactory droidFactory;
    BattleField battleField;
    RegistrationController registration;
    AuthorizationController authorization;
    GameView gameView;
    Game game;

    public GameController(DroidFactory droidFactory, BattleField battleField, RegistrationController registration,
                          AuthorizationController authorization, GameView gameView) {
        this.droidFactory = droidFactory;
        this.battleField = battleField;
        this.registration = registration;
        this.authorization = authorization;
        this.gameView = gameView;
        game = new Game();
    }

    public void start() {
        while (true) {

            System.out.println(gameView.bundle.getString(GameView.MAIN_MENU_OPERATIONS));

            int option = -1;

            Scanner scanner = new Scanner(System.in);
            option = Integer.parseInt(scanner.next());

            if (option == 1) {
                registration.register();
            } else if (option == 2) {
                game.setAuthorizedUser(authorization.adminAuthorization());
                adminMenu();
            } else if (option == 3) {
                game.setAuthorizedUser(authorization.userAuthorization());
                userMenu();
            } else if (option == 0){
                logger.info("Session ended.");
                System.exit(0);
            }

        }
    }

    private void adminMenu() {
        while (true) {
            System.out.println(gameView.bundle.getString(GameView.ADMIN_MENU_OPTION));
            int option = -1;
            while (true) {

                try {
                    option = Dialogs.requestInt();
                    if (option < 0 && option > 3) {
                        throw new IllegalArgumentException(gameView.bundle.getString(GameView.NOT_SUPPORTED_OPERATION));
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    logger.error(e.getMessage(), e);
                    System.out.println(e.getMessage() + gameView.bundle.getString(GameView.ADMIN_MENU_OPTION));
                }

            }

            if (option == 0) {
                break;
            } else if (option == 1) {
                createDroid();
            } else if (option == 2) {
                deleteDroid();
            } else if (option == 3) {
                game.showDroids();
            } else if (option == 4) {
                updateDroid();
            }
        }
    }

    private void userMenu() {
        while (true) {
            gameView.printUserMenu();
            int option = -1;
            while (true) {

                try {
                    option = Dialogs.requestInt();
                    if (option < 0 && option > 4) {
                        throw new IllegalArgumentException(gameView.bundle.getString(GameView.NOT_SUPPORTED_OPERATION));
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    gameView.printUserMenu();
                }

            }

            if (option == 0) {
                break;
            } else if (option == 1) {

                if (game.getDroids().size() < 2) {
                    gameView.printMessage(gameView.bundle.getString(GameView.NO_DROIDS));
                    break;
                }

                setDroidsForBattle();
                System.out.println(game.getFirstDroidToBattle());
                System.out.println(game.getSecondDroidToBattle());
                if (game.getFirstDroidToBattle() != null && game.getSecondDroidToBattle() != null) {
                    try {
                        battleField.startBattle(game.getFirstDroidToBattle(), game.getSecondDroidToBattle());
                        Serializator.serializationDroidList(game.getDroids(), SERIALIZATION_FILE_PATH);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            } else if(option == 2){
                printSwimAbleDroids();
            } else if(option == 3){
                printFlyAbleDroids();
            } else if(option == 4) {
                sortDroidsByEnergy();
            }
        }
    }

    private void setDroidsForBattle() {
        System.out.println("Choose first droid: ");
        game.showDroids();
        int firstDroidToFightNumber = retrieveDroidPosition();
        game.setFirstDroidToBattle(game.getAuthorizedUser().chooseDroidForBattle(game.getDroids(), firstDroidToFightNumber));
        System.out.println("Choose second droid: ");
        game.showDroids();
        int secondDroidToFightNumber = retrieveDroidPosition();
        game.setSecondDroidToBattle(game.getAuthorizedUser().chooseDroidForBattle(game.getDroids(),
                secondDroidToFightNumber));

    }

    private void updateDroid() {
        int droidNumber = -1;
        int newEnergy = 0;
        int newHealth = 0;
        int newProtection = 0;


        if (game.getDroids().size() == 0) {
            gameView.printMessage(gameView.bundle.getString(GameView.NO_DROIDS_TO_EDIT));
            return;
        }

        gameView.printMessage(gameView.bundle.getString(GameView.CHOOSE_DROIDS_TO_UPDATE));
        game.showDroids();
        System.out.println();
        droidNumber = retrieveDroidPosition() - 1;

        gameView.printMessage(gameView.bundle.getString(GameView.SET_ENERGY_LEVEL));
        while (true) {
            try {
                newEnergy = Dialogs.requestInt();
                if (newEnergy < 0) {
                    throw new IllegalArgumentException(gameView.bundle.getString(GameView.TRY_AGAIN));
                }
                break;
            } catch (IllegalArgumentException e) {
                logger.error(e.getMessage(), e);
                System.out.println(e.getMessage());
            }
        }

        gameView.printMessage(gameView.bundle.getString(GameView.SET_HEALTH_LEVEL));
        while (true) {
            try {
                newHealth = Dialogs.requestInt();
                if (newHealth < 0) {
                    throw new IllegalArgumentException(gameView.bundle.getString(GameView.TRY_AGAIN));
                }
                break;
            } catch (IllegalArgumentException e) {
                logger.error(e.getMessage(), e);
                System.out.println(e.getMessage());
            }
        }

        gameView.printMessage(gameView.bundle.getString(GameView.SET_PROTECTION_LEVEL));
        while (true) {
            try {
                newProtection = Dialogs.requestInt();
                if (newProtection < 0) {
                    throw new IllegalArgumentException(gameView.bundle.getString(GameView.TRY_AGAIN));
                }
                break;
            } catch (IllegalArgumentException e) {
                logger.error(e.getMessage(), e);
                System.out.println(e.getMessage());
            }
        }

        game.updateDroid(droidNumber, newEnergy, newHealth, newProtection);
        Serializator.serializationDroidList(game.getDroids(), SERIALIZATION_FILE_PATH);
    }

    private int retrieveDroidPosition() {
        int droidPosition = -1;
        while (true) {
            try {
                droidPosition = Dialogs.requestInt();
                if (droidPosition > game.getDroids().size()) {
                    throw new IndexOutOfBoundsException(gameView.bundle.getString(GameView.TRY_AGAIN));
                }
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.error(e.getMessage(), e);
                System.out.println(e.getMessage());
                game.showDroids();
            }
        }
        return droidPosition;
    }


    private void deleteDroid() {
        game.showDroids();
        int droidPositionToDelete = retrieveDroidPosition();
        game.deleteDroid(droidPositionToDelete);
        Serializator.serializationDroidList(game.getDroids(), "SERIALIZATION_FILE_PATH");
    }

    private void createDroid() {
        int droidOption = 0;
        String droidType = "";

        System.out.println(gameView.bundle.getString(GameView.DROIDS_OPTIONS));
        while (true) {
            try {
                droidOption = Dialogs.requestInt();
                if (droidOption != 1 && droidOption != 2 && droidOption != 3) {
                    throw new UnsupportedOperationException(gameView.bundle.getString(GameView.NOT_SUPPORTED_OPERATION));
                }
                break;
            } catch (UnsupportedOperationException e) {
                logger.error(e.getMessage(), e);
                System.out.println(e.getMessage() + gameView.bundle.getString(GameView.DROIDS_OPTIONS));
            }
        }

        if (droidOption == 1) {
            droidType = "LightBattleDroid";
        } else if (droidOption == 2) {
            droidType = "NanoBattleDroid";
        } else if (droidOption == 3) {
            droidType = "MurdererBattleDroid";
        }
        game.addDroid(droidFactory.createDroid(droidType));
        Serializator.serializationDroidList(game.getDroids(), SERIALIZATION_FILE_PATH);
    }

    private void printSwimAbleDroids(){
        for(BattleDroid droid : game.filterSwimAble()){
            System.out.println(droid);
        }
    }

    private void printFlyAbleDroids(){
        for(BattleDroid droid : game.filterFlyAble()){
            System.out.println(droid);
        }
    }

    private void sortDroidsByEnergy(){
        game.sortDroidsByEnergy();
        game.showDroids();
    }

}
