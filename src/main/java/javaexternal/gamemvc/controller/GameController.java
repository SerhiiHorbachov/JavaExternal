package javaexternal.gamemvc.controller;

import javaexternal.gamemvc.model.Game;
import javaexternal.gamemvc.view.GameView;

import java.util.Random;

public class GameController {
    private Game model;
    private GameView view;

    public GameController(Game model, GameView view){
        this.model = model;
        this.view = view;
    }

    private int rand(){
        return new Random().nextInt(model.getDefaultRandMax()) + 1;
    }

    public int rand(int min, int max){
        return new Random().nextInt((max - min) + 1) + min;
    }
}
