package ua.externaljava.droid_wars.models.attacks;

import java.io.Serializable;

public class BigFuckingGunAttack implements Attack, Serializable {
    private final static int ATTACK_STRENGTH = 60;
    private final static int ENERGY_CONSUMPTION = 50;
    private static final long serialVersionUID = 1L;


    @Override
    public int attack() {
        System.out.println("Attacking with BFG!");
        return ATTACK_STRENGTH;
    }

    @Override
    public int getEnergyConsumption() {
        return ENERGY_CONSUMPTION;
    }

}
