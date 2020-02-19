package ua.externaljava.droid_wars.models.droids;

public abstract class Droid {
    private static final int CAPACITY = 1000;

    private int energy;
    private int health;
    private int protection;
    private boolean isAlive = true;
    private String name;

    public Droid(int energy, int health, int protection, String name) {
        this.energy = energy;
        this.health = health;
        this.protection = protection;
        this.name = name;
    }

    public static int getCAPACITY() {
        return CAPACITY;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getName() {
        return name;
    }

    public String printStatus() {
        return name + ": Energy: " + energy + "; Health: " + health + "; Protections: " + protection + "; Is alive: " + isAlive;
    }

    public int checkState() {
        return energy + health + protection;
    }

    public void receiveDamage(int damageLevel) {
        if (protection < damageLevel) {
            damageLevel = damageLevel - protection;
            protection = 0;
            health = health - damageLevel;
        } else {
            protection = protection - damageLevel;
        }

        if (energy <= 0 || health <= 0) {
            isAlive = false;
        }

    }

    @Override
    public String toString() {
        return "Droid{" +
                "energy=" + energy +
                ", health=" + health +
                ", protection=" + protection +
                ", isAlive=" + isAlive +
                ", name='" + name + '\'' +
                '}';
    }
}
