package ua.externaljava.droid_wars.models.droids;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroidTest {

    @Test
    void receiveDamage_ShouldReduceDroidProtection_WhenDroidIsAttacked(){
        Droid nanoBattleDroid = new NanoBattleDroid(300,300,300);
        nanoBattleDroid.receiveDamage(10);
        int expectedProtection = 290;
        int actualProtection = nanoBattleDroid.getProtection();
        assertEquals(expectedProtection, actualProtection);
    }

    @Test
    void receiveDamage_ShouldReduceDroidHealth_WhenDamageExceedsProtection(){
        Droid nanoBattleDroid = new NanoBattleDroid(300,300,5);
        nanoBattleDroid.receiveDamage(10);
        int expectedHealth = 295;
        int actualHealth = nanoBattleDroid.getHealth();
        assertEquals(expectedHealth, actualHealth);
    }

    @Test
    void receiveDamage_ShouldSetIsAliveToFalse_WhenDamageExceedsHealthAndProtectionIsZero(){
        Droid nanoBattleDroid = new NanoBattleDroid(300,5,0);
        nanoBattleDroid.receiveDamage(10);
        assertEquals(false, nanoBattleDroid.isAlive());
    }

}