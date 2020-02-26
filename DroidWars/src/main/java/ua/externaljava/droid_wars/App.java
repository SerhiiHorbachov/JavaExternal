package ua.externaljava.droid_wars;

import ua.externaljava.droid_wars.controller.AuthorizationController;
import ua.externaljava.droid_wars.controller.BattleField;
import ua.externaljava.droid_wars.controller.GameController;
import ua.externaljava.droid_wars.controller.RegistrationController;
import ua.externaljava.droid_wars.factory.DroidFactory;
import ua.externaljava.droid_wars.helpers.Dialogs;
import ua.externaljava.droid_wars.view.DroidsView;
import ua.externaljava.droid_wars.view.GameView;

public class App {
    public static void main(String[] args) {

        String language = Dialogs.requestLanguage();
        GameView gameView = new GameView(language);
        RegistrationController registrationController = new RegistrationController(gameView);
        AuthorizationController authorizationController = new AuthorizationController(gameView);
        DroidsView droidsView = new DroidsView();
        BattleField battleField = new BattleField(droidsView);
        DroidFactory droidFactory = new DroidFactory();

        GameController gameController = new GameController(droidFactory, battleField,
                registrationController, authorizationController, gameView);

        gameController.start();

    }
}