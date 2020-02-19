package ua.externaljava.droid_wars.controller;

import ua.externaljava.droid_wars.factory.DroidFactory;
import ua.externaljava.droid_wars.helpers.Dialogs;
import ua.externaljava.droid_wars.models.droids.BattleDroid;
import ua.externaljava.droid_wars.models.user.User;
import ua.externaljava.droid_wars.view.GameView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    DroidFactory droidFactory;
    BattleField battleField;
    RegistrationController registration;
    AuthorizationController authorization;
    User authorizedUser;
    GameView gameView;
    List<BattleDroid> droids = new ArrayList<>();
    BattleDroid firstDroidToBattle;
    BattleDroid secondDroidToBattle;


    public GameController(DroidFactory droidFactory, BattleField battleField, RegistrationController registration,
                          AuthorizationController authorization, GameView gameView) {
        this.droidFactory = droidFactory;
        this.battleField = battleField;
        this.registration = registration;
        this.authorization = authorization;
        this.gameView = gameView;
    }


    public void start() throws InterruptedException {
        while (true) {

            System.out.println(gameView.bundle.getString(GameView.MAIN_MENU_OPERATIONS));

            int option = 0;

            Scanner scanner = new Scanner(System.in);
            option = Integer.parseInt(scanner.next());

            if (option == 1) {
                registration.register();
            } else if (option == 2) {
                authorizedUser = authorization.adminAuthorization();
                adminMenu();
            } else if (option == 3) {
                authorizedUser = authorization.userAuthorization();
                userMenu();

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
                    if (option != 1 && option != 2 && option != 3 && option != 4 && option != 0) {
                        throw new IllegalArgumentException(gameView.bundle.getString(GameView.NOT_SUPPORTED_OPERATION));
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + gameView.bundle.getString(GameView.ADMIN_MENU_OPTION));
                }

            }

            if (option == 0) {
                break;
            } else if (option == 1) {
                createDroid();
            }

        }

    }

    private void userMenu() throws InterruptedException {
        while (true) {
            System.out.println(gameView.bundle.getString(GameView.USER_MENU_OPTION));
            int option = -1;
            while (true) {

                try {
                    option = Dialogs.requestInt();
                    if (option != 0 && option != 1) {
                        throw new IllegalArgumentException(gameView.bundle.getString(GameView.NOT_SUPPORTED_OPERATION));
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + gameView.bundle.getString(GameView.USER_MENU_OPTION));
                }

            }

            if (option == 0) {
                break;
            } else if (option == 1) {

                if (droids.size() < 2) {
                    gameView.printMessage(gameView.bundle.getString(GameView.NO_DROIDS));
                    break;
                }
                setDroidsForBattle();
                if (firstDroidToBattle != null && secondDroidToBattle != null) {
                    battleField.startBattle(firstDroidToBattle, secondDroidToBattle);
                } else {
                    break;
                }
            }

        }

    }

    private void setDroidsForBattle() {
        listDroids(droids);
        int firstDroidToFightNumber = retrieveDroidPosition();
        firstDroidToBattle = authorizedUser.chooseDroidForBattle(droids, firstDroidToFightNumber);
        listDroids(droids);
        int secontDroidToFightNumber = retrieveDroidPosition();
        secondDroidToBattle = authorizedUser.chooseDroidForBattle(droids, secontDroidToFightNumber);
    }

    private int retrieveDroidPosition() {
        int droidToFight = -1;
        while (true) {
            try {
                droidToFight = Dialogs.requestInt();
                if (droidToFight > droids.size()) {
                    throw new IndexOutOfBoundsException(gameView.bundle.getString(GameView.TRY_AGAIN));
                }
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                listDroids(droids);
            }
        }
        return droidToFight;
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
        droids.add(droidFactory.createDroid(droidType));
    }

    private void listDroids(List<BattleDroid> droids) {
        gameView.printMessage(gameView.bundle.getString(GameView.CHOOSE_DROID));
        for (int i = 0; i < droids.size(); i++) {
            System.out.println((i + 1) + " - " + droids.get(i).toString());
        }
    }


}
