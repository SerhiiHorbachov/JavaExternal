package ua.externaljava.droid_wars;

import ua.externaljava.droid_wars.controller.AuthorizationController;
import ua.externaljava.droid_wars.controller.BattleField;
import ua.externaljava.droid_wars.controller.GameController;
import ua.externaljava.droid_wars.controller.RegistrationController;
import ua.externaljava.droid_wars.factory.DroidFactory;
import ua.externaljava.droid_wars.helpers.Dialogs;
import ua.externaljava.droid_wars.view.AuthorizationView;
import ua.externaljava.droid_wars.view.DroidsView;
import ua.externaljava.droid_wars.view.GameView;
import ua.externaljava.droid_wars.view.RegistrationView;

public class App {
    public static void main(String[] args) throws InterruptedException {

        String language = Dialogs.requestLanguage();
        DroidsView droidsView = new DroidsView();
        BattleField battleField = new BattleField(droidsView);
        RegistrationView registrationView = new RegistrationView(language);
        RegistrationController registrationController = new RegistrationController(registrationView);
        AuthorizationView authorizationView = new AuthorizationView();
        AuthorizationController authorizationController = new AuthorizationController(authorizationView);
        DroidFactory droidFactory = new DroidFactory();
        GameView gameView = new GameView(language);

        GameController gameController = new GameController(droidFactory, battleField,
                registrationController, authorizationController, gameView);

        gameController.start();



    }
}