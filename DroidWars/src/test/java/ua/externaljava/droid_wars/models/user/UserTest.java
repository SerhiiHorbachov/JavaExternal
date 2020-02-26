package ua.externaljava.droid_wars.models.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.externaljava.droid_wars.models.droids.BattleDroid;
import ua.externaljava.droid_wars.models.droids.LightBattleDroid;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    static User user;
    static List<BattleDroid> droids;

    @BeforeEach
    void setUp() {
        user = new User();
        droids = new ArrayList<>();
    }

    @Test
    void chooseDroidForBattle_ShouldReturnDroid_WhenDroidRequested() {
        BattleDroid expectedDroid = new LightBattleDroid(700, 700, 700);
        int expectedDroidHash = expectedDroid.hashCode();
        System.out.println("Expected: " + expectedDroidHash);

        droids.add(new LightBattleDroid(200, 200, 200));
        droids.add(new LightBattleDroid(300, 300, 300));
        droids.add(expectedDroid);
        droids.add(new LightBattleDroid(500, 500, 500));
        droids.add(new LightBattleDroid(600, 600, 600));

        int actualDroidHash = user.chooseDroidForBattle(droids, 3).hashCode();
        assertEquals(expectedDroidHash, actualDroidHash);
    }

}