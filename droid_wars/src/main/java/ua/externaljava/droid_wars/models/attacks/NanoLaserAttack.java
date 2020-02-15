package ua.externaljava.droid_wars.models.attacks;

public class NanoLaserAttack implements Attack {

    private final static int ATTACK_STRENGTH = 4;
    private final static int ENERGY_CONSUMPTION = 1;

    @Override
    public int attack() {
        System.out.println("Attacking with nano laser!");
        return ATTACK_STRENGTH;
    }

    @Override
    public int getEnergyConsumption() {
        return ENERGY_CONSUMPTION;
    }
}
