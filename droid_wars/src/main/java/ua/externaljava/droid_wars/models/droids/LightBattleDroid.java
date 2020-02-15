package ua.externaljava.droid_wars.models.droids;

import ua.externaljava.droid_wars.models.attacks.BlasterAttack;

public class LightBattleDroid extends BattleDroid {

    public LightBattleDroid(int energy, int health, int protection) {
        super(energy, health, protection, "LightBattleDroid");
        setAttack(new BlasterAttack());
    }
}
