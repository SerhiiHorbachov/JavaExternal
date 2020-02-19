package ua.externaljava.droid_wars.controller;

import ua.externaljava.droid_wars.models.droids.BattleDroid;
import ua.externaljava.droid_wars.view.DroidsView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BattleField {

    private final static int PAUSE_SEC = 1;

    private BattleDroid droid1;
    private BattleDroid droid2;
    private List<BattleDroid> droids = new ArrayList<>();
    private DroidsView view;

    public BattleField(DroidsView view) {
        this.view = view;
    }

    public void startBattle(BattleDroid droid1, BattleDroid droid2) throws InterruptedException {
        setFighters(droid1, droid2);
        int roundCount = 0;
        while(true) {
            roundCount++;
            view.printMessage(DroidsView.ROUND + roundCount);
            battleRound(droid1, droid2);
            if(!droid1.isAlive() || !droid2.isAlive()) {
                break;
            }
        }

    }

    private void battleRound(BattleDroid droid1, BattleDroid droid2) throws InterruptedException {
        view.printMessage(DroidsView.BEFORE_ROUND);
        view.printState(droid1.getName(), droid1.checkState());
        view.printState(droid2.getName(), droid2.checkState());

        view.printMessage(DroidsView.LINE_SEPARATOR);
        pause(PAUSE_SEC);
        view.printName(droid1.getName());
        droid2.receiveDamage(droid1.attack());

        view.printMessage(DroidsView.LINE_SEPARATOR);
        pause(PAUSE_SEC);
        view.printName(droid2.getName());
        droid1.receiveDamage(droid2.attack());
        view.printMessage(DroidsView.LINE_SEPARATOR);

        view.printMessage(DroidsView.AFTER_ROUND);
        view.printState(droid1.getName(), droid1.checkState());
        view.printState(droid2.getName(), droid2.checkState());

        view.printMessage(DroidsView.LINE_SEPARATOR);
        view.printStatistics(droid1.printStatus());
        view.printStatistics(droid2.printStatus());
        view.printMessage(DroidsView.ITERATION_SEPARATOR);
        TimeUnit.SECONDS.sleep(1);

    }

    public void setFighters(BattleDroid droid1, BattleDroid droid2) {
        this.droid1 = droid1;
        this.droid2 = droid2;
    }
    private void pause(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);

    }

}
