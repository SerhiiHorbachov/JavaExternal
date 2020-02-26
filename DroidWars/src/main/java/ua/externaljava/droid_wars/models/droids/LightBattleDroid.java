package ua.externaljava.droid_wars.models.droids;

import ua.externaljava.droid_wars.models.attacks.BlasterAttack;
import ua.externaljava.droid_wars.models.behavior.FlyAble;

public class LightBattleDroid extends BattleDroid implements FlyAble {

    public LightBattleDroid(int energy, int health, int protection) {
        super(energy, health, protection, "LightBattleDroid");
        setAttack(new BlasterAttack());
    }
    public LightBattleDroid(){

    }
}
