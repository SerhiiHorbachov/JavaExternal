package javaexternal.droids.factory;

import javaexternal.droids.entities.droids.*;

public class DroidFactory {

    BattleDroid droid = null;

    public BattleDroid createDroid(String type) {

        if (type.equals("LightBattleDroid")) {
            droid = new LightBattleDroid(300, 300, 400);
        } else if (type.equals("NanoBattleDroid")) {
            droid = new NanoBattleDroid(300, 300, 400);
        } else if (type.equals("MurdererBattleDroid")) {
            droid = new MurdererBattleDroid(300, 300, 400);
        }

        return droid;
    }
}
