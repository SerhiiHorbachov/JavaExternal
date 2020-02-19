package ua.externaljava.game;

import ua.externaljava.game.controller.GameController;
import ua.externaljava.game.model.GameModel;
import ua.externaljava.game.view.GameView;

public class Main {
    public static void main(String[] args) {
        GameModel model = new GameModel();
        GameView view = new GameView();
        GameController controller = new GameController(model, view);
        controller.initGame();

    }
}
