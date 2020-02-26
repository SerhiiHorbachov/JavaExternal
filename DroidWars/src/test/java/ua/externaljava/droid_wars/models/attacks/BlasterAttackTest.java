package ua.externaljava.droid_wars.models.attacks;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlasterAttackTest {
    static Attack blasterAttack;

    @BeforeAll
    static void setUp() {
        blasterAttack = new BlasterAttack();
    }

    @Test
    void getEnergyConsumption_ShouldReturnIntValue_whenMethodUsed() {
        int expected = 3;
        blasterAttack.getEnergyConsumption();
        assertEquals(expected, blasterAttack.getEnergyConsumption());
    }

    @Test
    void attack_ShouldReturnIntValue_whenMethodUsed() {
        int expected = 10;
        blasterAttack.attack();
        assertEquals(expected, blasterAttack.attack());
    }
}