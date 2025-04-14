package com.flantechtree.common.data;

import java.util.HashMap;
import java.util.Map;

public class TechTreeManager {
    private static final Map<String, TechTree> techTrees = new HashMap<>();

    public static void loadAllTrees() {
        System.out.println("[TechTreeManager] Loading tech trees...");

        TechTree germany = new TechTree("Germany");

        // Land
        germany.addNode("land", new TechNode("kar98k", "Kar98k Rifle", 10));
        germany.addNode("land", new TechNode("stg44", "StG-44 Assault Rifle", 20, "kar98k"));

        // Air
        germany.addNode("air", new TechNode("bf109", "Messerschmitt Bf 109", 50));

        // Navy
        germany.addNode("navy", new TechNode("uBoat", "Type VII U-Boat", 60));

        techTrees.put("Germany", germany);
    }

    // NOTICE: Tech Tree setup isnt fully complete and i might COMPLETELY overhaul the code. dont expect anything to fucking work.

    public static TechTree getTree(String name) {
        return techTrees.get(name);
    }
}