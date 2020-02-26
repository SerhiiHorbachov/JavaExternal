package ua.externaljava.droid_wars.models;

import ua.externaljava.droid_wars.helpers.Serializator;
import ua.externaljava.droid_wars.models.behavior.FlyAble;
import ua.externaljava.droid_wars.models.behavior.SwimAble;
import ua.externaljava.droid_wars.models.droids.BattleDroid;
import ua.externaljava.droid_wars.models.user.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Game implements Serializable {
    private static final String SERIALIZATION_FILE_PATH = "src/main/resources/droids.data";

    private static final long serialVersionUID = 1L;
    private transient User authorizedUser;
    private List<BattleDroid> droids = new ArrayList<>();
    private BattleDroid firstDroidToBattle;
    private BattleDroid secondDroidToBattle;

    public Game() {
        try {
            File serializationData = new File(SERIALIZATION_FILE_PATH);
            if(serializationData.length() != 0){
                droids = Serializator.deserialization(SERIALIZATION_FILE_PATH);
            }
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }
    }

    public List<BattleDroid> getDroids() {
        return droids;
    }

    public void setDroids(List<BattleDroid> droids) {
        this.droids = droids;
    }

    public User getAuthorizedUser() {
        return authorizedUser;
    }

    public void setAuthorizedUser(User authorizedUser) {
        this.authorizedUser = authorizedUser;
    }

    public BattleDroid getFirstDroidToBattle() {
        return firstDroidToBattle;
    }

    public void setFirstDroidToBattle(BattleDroid firstDroidToBattle) {
        this.firstDroidToBattle = firstDroidToBattle;
    }

    public BattleDroid getSecondDroidToBattle() {
        return secondDroidToBattle;
    }

    public void setSecondDroidToBattle(BattleDroid secondDroidToBattle) {
        this.secondDroidToBattle = secondDroidToBattle;
    }

    public void addDroid(BattleDroid newDroid){
        droids.add(newDroid);
    }

    public void showDroids(){
        for (int i = 0; i < droids.size(); i++) {
            System.out.println((i + 1) + " - " + droids.get(i).toString());
        }
    }

    public void updateDroid(int droidPosition, int energy, int health, int protection){
        droids.get(droidPosition).setEnergy(energy);
        droids.get(droidPosition).setHealth(health);
        droids.get(droidPosition).setProtection(protection);

        if(health <= 0 || energy <= 0){
            droids.get(droidPosition).setAlive(false);
        }
        if(health > 0 && energy > 0) {
            droids.get(droidPosition).setAlive(true);
        }
    }

    public void deleteDroid(int droidNumber){
        droids.remove(droidNumber -1);
    }

    public BattleDroid chooseDroidForBattle(List<BattleDroid> droids, int droidNumber){
        return droids.get(--droidNumber);
    }

    public List<BattleDroid> filterSwimAble(){
        List<BattleDroid> swimAbleDroids = new ArrayList<>();

        for(BattleDroid droid : droids){
            if(droid instanceof SwimAble){
                swimAbleDroids.add(droid);
            }
        }

        return swimAbleDroids;
    }

    public List<BattleDroid> filterFlyAble(){
        List<BattleDroid> flyAbleDroids = new ArrayList<>();

        for(BattleDroid droid : droids){
            if(droid instanceof FlyAble){
                flyAbleDroids.add(droid);
            }
        }

        return flyAbleDroids;
    }

    public void sortDroidsByEnergy(){
        Collections.sort(droids, new Comparator<BattleDroid>() {
            @Override
            public int compare(BattleDroid battleDroid1, BattleDroid battleDroid2) {
                return battleDroid1.getEnergy() - battleDroid2.getEnergy();
            }
        });
    }


}
