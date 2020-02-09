package javaexternal.gamemvc;

import javaexternal.gamemvc.controller.GameController;
import javaexternal.gamemvc.model.GameModel;
import javaexternal.gamemvc.view.GameView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameModel model = new GameModel();
        GameView view = new GameView();
        GameController controller = new GameController(model, view);

        try(Scanner scanner = new Scanner(System.in)){
            controller.initGame(scanner);
        }

    }

}
