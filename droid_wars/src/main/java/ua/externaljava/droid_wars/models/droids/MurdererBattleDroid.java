package ua.externaljava.droid_wars.models.droids;

import ua.externaljava.droid_wars.models.attacks.BigFuckingGunAttack;

public class MurdererBattleDroid extends BattleDroid {
    public MurdererBattleDroid(int energy, int health, int protection) {
        super(energy, health, protection, "MurdererBattleDroid");
        setAttack(new BigFuckingGunAttack());
    }
}
