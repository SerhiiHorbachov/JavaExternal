package javaexternal.droids.entities.droids;

import javaexternal.droids.entities.attack.NanoLaserAttack;

public class NanoBattleDroid extends BattleDroid {

    public NanoBattleDroid(int energy, int health, int protection) {
        super(energy, health, protection, "NanoBattleDroid");
        setAttack(new NanoLaserAttack());
    }
}
