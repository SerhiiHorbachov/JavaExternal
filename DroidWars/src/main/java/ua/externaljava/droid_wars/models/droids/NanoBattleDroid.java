package ua.externaljava.droid_wars.models.droids;

import ua.externaljava.droid_wars.models.attacks.NanoLaserAttack;
import ua.externaljava.droid_wars.models.behavior.FlyAble;
import ua.externaljava.droid_wars.models.behavior.SwimAble;

public class NanoBattleDroid extends BattleDroid implements FlyAble, SwimAble {

    public NanoBattleDroid(int energy, int health, int protection) {
        super(energy, health, protection, "NanoBattleDroid");
        setAttack(new NanoLaserAttack());
    }

}
