package ua.externaljava.droid_wars.models.droids;

import ua.externaljava.droid_wars.models.attacks.Attack;

import java.io.Serializable;

public abstract class BattleDroid extends Droid implements Serializable {

    private Attack attack;
    private static final long serialVersionUID = 1L;


    public BattleDroid(int energy, int health, int protection, String name) {
        super(energy, health, protection, name);
    }

    public BattleDroid(){

    }

    public int attack() {
        if (attack == null) {
            System.out.println("No Weapon..cannot attack.");
            return 0;
        }

        setEnergy(getEnergy() - attack.getEnergyConsumption());
        return attack.attack();
    }

    protected void setAttack(Attack attack) {
        this.attack = attack;
    }

    @Override
    public String toString() {
        return "BattleDroid{" +
                "attack=" + attack.getClass().getSimpleName() +
                "} " + super.toString();
    }
}
