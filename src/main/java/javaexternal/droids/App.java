package javaexternal.droids;

import javaexternal.droids.controller.BattleField;
import javaexternal.droids.factory.DroidFactory;
import javaexternal.droids.view.DroidsView;

public class App {
    public static void main(String[] args) throws InterruptedException {

        DroidFactory droidFactory = new DroidFactory();
        DroidsView view = new DroidsView();
        BattleField battleField = new BattleField(view);
        battleField.startBattle(droidFactory.createDroid("MurdererBattleDroid"), droidFactory.createDroid("LightBattleDroid"));

    }

}
