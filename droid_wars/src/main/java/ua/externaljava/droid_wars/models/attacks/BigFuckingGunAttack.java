package ua.externaljava.droid_wars.models.attacks;

public class BigFuckingGunAttack implements Attack {
    private final static int ATTACK_STRENGTH = 60;
    private final static int ENERGY_CONSUMPTION = 50;

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
