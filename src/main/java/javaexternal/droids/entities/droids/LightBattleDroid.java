package javaexternal.droids.entities.droids;

import javaexternal.droids.entities.attack.BlasterAttack;

public class LightBattleDroid extends BattleDroid {

    public LightBattleDroid(int energy, int health, int protection) {
        super(energy, health, protection, "LightBattleDroid");
        setAttack(new BlasterAttack());
    }
}
