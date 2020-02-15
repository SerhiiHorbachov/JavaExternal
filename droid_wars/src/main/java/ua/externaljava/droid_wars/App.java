package ua.externaljava.droid_wars;


import ua.externaljava.droid_wars.controller.BattleField;
import ua.externaljava.droid_wars.factory.DroidFactory;
import ua.externaljava.droid_wars.view.DroidsView;

public class App {
    public static void main(String[] args) throws InterruptedException {
        DroidFactory droidFactory = new DroidFactory();
        DroidsView view = new DroidsView();
        BattleField battleField = new BattleField(view);
        battleField.startBattle(droidFactory.createDroid("MurdererBattleDroid"), droidFactory.createDroid("LightBattleDroid"));
    }
}
