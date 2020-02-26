package ua.externaljava.droid_wars.models.attacks;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NanoLaserAttackTest {
    static Attack nanoLaserAttack;

    @BeforeAll
    static void setUp() {
        nanoLaserAttack = new NanoLaserAttack();
    }

    @Test
    void getEnergyConsumption_ShouldReturnIntValue_whenMethodUsed() {
        int expected = 1;
        nanoLaserAttack.getEnergyConsumption();
        assertEquals(expected, nanoLaserAttack.getEnergyConsumption());
    }

    @Test
    void attack_ShouldReturnIntValue_whenMethodUsed() {
        int expected = 4;
        nanoLaserAttack.attack();
        assertEquals(expected, nanoLaserAttack.attack());
    }
}