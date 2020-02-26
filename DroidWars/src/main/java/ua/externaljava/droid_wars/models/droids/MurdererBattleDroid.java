package ua.externaljava.droid_wars.models.droids;

import ua.externaljava.droid_wars.models.attacks.BigFuckingGunAttack;
import ua.externaljava.droid_wars.models.behavior.SwimAble;

public class MurdererBattleDroid extends BattleDroid implements SwimAble {
    public MurdererBattleDroid(int energy, int health, int protection) {
        super(energy, health, protection, "MurdererBattleDroid");
        setAttack(new BigFuckingGunAttack());
    }



}
