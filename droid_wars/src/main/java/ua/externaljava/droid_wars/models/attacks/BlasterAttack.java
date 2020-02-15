package ua.externaljava.droid_wars.models.attacks;

public class BlasterAttack implements Attack {

    private final static int ATTACK_STRENGTH = 10;
    private final static int ENERGY_CONSUMPTION = 3;

    @Override
    public int attack() {
        System.out.println("Attacking with blaster!");

        return ATTACK_STRENGTH;
    }

    @Override
    public int getEnergyConsumption() {
        return ENERGY_CONSUMPTION;
    }
}
