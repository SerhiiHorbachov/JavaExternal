package javaexternal.droids.entities.droids;

import javaexternal.droids.entities.attack.BigFuckingGunAttack;

public class MurdererBattleDroid extends BattleDroid{
    public MurdererBattleDroid(int energy, int health, int protection) {
        super(energy, health, protection, "MurdererBattleDroid");
        setAttack(new BigFuckingGunAttack());
    }
}
