package ua.externaljava.droid_wars.models;

import org.junit.jupiter.api.*;

import ua.externaljava.droid_wars.models.droids.BattleDroid;
import ua.externaljava.droid_wars.models.droids.LightBattleDroid;
import ua.externaljava.droid_wars.models.droids.MurdererBattleDroid;
import ua.externaljava.droid_wars.models.droids.NanoBattleDroid;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GameTest {

    static Game game;
    List<BattleDroid> SwimAbleAndFlyAbleDroids = new ArrayList<>();

    @BeforeAll
    static void setUp(){
        game = new Game();
        game.setDroids(new ArrayList<>());
        BattleDroid droid = new NanoBattleDroid(200, 200, 200);
        game.addDroid(droid);

    }

    @Test
    @Order(1)
    void addDroidShouldAddDroidToList() {
        BattleDroid droid = new NanoBattleDroid(200, 200, 200);
        int sizeBeforeAdding = game.getDroids().size();
        game.addDroid(droid);
        int sizeAfterAdding = game.getDroids().size();
        assertEquals(sizeBeforeAdding, sizeAfterAdding - 1);
    }

    @Test
    @Order(2)
    void removeDroid() {
        int amountOfDroidsBeforeRemoving = game.getDroids().size();
        game.deleteDroid(1);
        int amountOfDroidsAfterRemoving = game.getDroids().size();
        assertEquals(amountOfDroidsBeforeRemoving, amountOfDroidsAfterRemoving + 1);
    }

    @Disabled
    @Test
    @Order(3)
    void showDroids() {
    }

    @Test
    @Order(4)
    public void filterSwimAbleShouldReturnListOfBattleDroidsThatAreInstancesOfSwimAble(){
        List<BattleDroid> SwimAbleAndFlyAbleDroids = new ArrayList<>();
        List<BattleDroid> expectedSwimAbleDroids = new ArrayList<>();

        BattleDroid flyAble1 = new LightBattleDroid(200, 200, 200);
        BattleDroid swimAndFly1 = new NanoBattleDroid(200, 200, 200);
        BattleDroid flyAble2 = new LightBattleDroid(200, 200, 200);
        BattleDroid swimAndFly2 = new NanoBattleDroid(200, 200, 200);
        BattleDroid swimAble1 = new MurdererBattleDroid(200, 200, 200);
        BattleDroid swimAble2 = new MurdererBattleDroid(200, 200, 200);

        SwimAbleAndFlyAbleDroids.add(flyAble1);
        SwimAbleAndFlyAbleDroids.add(swimAndFly1);
        SwimAbleAndFlyAbleDroids.add(flyAble2);
        SwimAbleAndFlyAbleDroids.add(swimAndFly2);
        SwimAbleAndFlyAbleDroids.add(swimAble1);
        SwimAbleAndFlyAbleDroids.add(swimAble2);

        expectedSwimAbleDroids.add(swimAndFly1);
        expectedSwimAbleDroids.add(swimAndFly2);
        expectedSwimAbleDroids.add(swimAble1);
        expectedSwimAbleDroids.add(swimAble2);

        game.setDroids(SwimAbleAndFlyAbleDroids);

        List<BattleDroid> actualSwimAbleDroids = game.filterSwimAble();

        assertEquals(expectedSwimAbleDroids, actualSwimAbleDroids);
    }

    @Test
    @Order(5)
    public void filterFlyAbleShouldReturnListOfBattleDroidsThatAreInstancesOfFlyAble(){
        List<BattleDroid> SwimAbleAndFlyAbleDroids = new ArrayList<>();
        List<BattleDroid> expectedFlyAbleDroids = new ArrayList<>();

        BattleDroid flyAble1 = new LightBattleDroid(200, 200, 200);
        BattleDroid swimAndFly1 = new NanoBattleDroid(200, 200, 200);
        BattleDroid flyAble2 = new LightBattleDroid(200, 200, 200);
        BattleDroid swimAndFly2 = new NanoBattleDroid(200, 200, 200);
        BattleDroid swimAble1 = new MurdererBattleDroid(200, 200, 200);
        BattleDroid swimAble2 = new MurdererBattleDroid(200, 200, 200);

        SwimAbleAndFlyAbleDroids.add(flyAble1);
        SwimAbleAndFlyAbleDroids.add(swimAndFly1);
        SwimAbleAndFlyAbleDroids.add(flyAble2);
        SwimAbleAndFlyAbleDroids.add(swimAndFly2);
        SwimAbleAndFlyAbleDroids.add(swimAble1);
        SwimAbleAndFlyAbleDroids.add(swimAble2);

        expectedFlyAbleDroids.add(flyAble1);
        expectedFlyAbleDroids.add(swimAndFly1);
        expectedFlyAbleDroids.add(flyAble2);
        expectedFlyAbleDroids.add(swimAndFly2);

        game.setDroids(SwimAbleAndFlyAbleDroids);

        List<BattleDroid> actualFlyAbleDroids = game.filterFlyAble();

        assertEquals(expectedFlyAbleDroids, actualFlyAbleDroids);
    }

    @Test
    @Order(5)
    public void sortDroidsByEnergy(){
        List<BattleDroid> droidsToBeSorted = new ArrayList<>();
        List<BattleDroid> sortedDroids = new ArrayList<>();
        BattleDroid droid1 = new LightBattleDroid(100, 100, 100);
        BattleDroid droid2 = new LightBattleDroid(200, 200, 200);
        BattleDroid droid3 = new LightBattleDroid(300, 300, 300);
        BattleDroid droid4 = new LightBattleDroid(400, 400, 400);
        BattleDroid droid5 = new LightBattleDroid(500, 500, 500);
        game.setDroids(droidsToBeSorted);

        droidsToBeSorted.add(droid3);
        droidsToBeSorted.add(droid4);
        droidsToBeSorted.add(droid2);
        droidsToBeSorted.add(droid5);
        droidsToBeSorted.add(droid1);

        sortedDroids.add(droid1);
        sortedDroids.add(droid2);
        sortedDroids.add(droid3);
        sortedDroids.add(droid4);
        sortedDroids.add(droid5);

        game.sortDroidsByEnergy();

        assertEquals(sortedDroids, game.getDroids());
    }

}