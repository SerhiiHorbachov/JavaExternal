package ua.externaljava.droid_wars.models.attacks;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigFuckingGunAttackTest {

    static Attack bigFuckingGunAttack;

    @BeforeAll
    static void setUp() {
        bigFuckingGunAttack = new BigFuckingGunAttack();
    }

    @Test
    void getEnergyConsumption_ShouldReturnIntValue_whenMethodUsed() {
        int expected = 50;
        bigFuckingGunAttack.getEnergyConsumption();
        assertEquals(expected, bigFuckingGunAttack.getEnergyConsumption());
    }

    @Test
    void attack_ShouldReturnIntValue_whenMethodUsed() {
        int expectedAttack = 60;
        bigFuckingGunAttack.attack();
        assertEquals(expectedAttack, bigFuckingGunAttack.attack());
    }

}