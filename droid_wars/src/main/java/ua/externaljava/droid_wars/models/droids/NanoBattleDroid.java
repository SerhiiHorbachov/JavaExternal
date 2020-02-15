package ua.externaljava.droid_wars.models.droids;

import ua.externaljava.droid_wars.models.attacks.NanoLaserAttack;

public class NanoBattleDroid extends BattleDroid {

    public NanoBattleDroid(int energy, int health, int protection) {
        super(energy, health, protection, "NanoBattleDroid");
        setAttack(new NanoLaserAttack());
    }
}
