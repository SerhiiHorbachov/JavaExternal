package ua.externaljava.droid_wars.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.externaljava.droid_wars.models.droids.BattleDroid;
import ua.externaljava.droid_wars.models.droids.LightBattleDroid;

import static org.junit.jupiter.api.Assertions.*;

class DroidFactoryTest {

    static DroidFactory factory;

    @BeforeAll
    static void setUp(){
        factory = new DroidFactory();
    }

    @Test
    void createDroid_ShouldReturnDroid_WhenDroidNameIsPassed(){
        String expectedDroidName = "LightBattleDroid";
        BattleDroid actualDroid = factory.createDroid(expectedDroidName);
        boolean isInstanceOf = actualDroid instanceof LightBattleDroid;
        assertEquals(true, isInstanceOf);

    }


}