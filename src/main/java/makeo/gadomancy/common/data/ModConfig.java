package makeo.gadomancy.common.data;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * This class is part of the Gadomancy Mod
 * Gadomancy is Open Source and distributed under the
 * GNU LESSER GENERAL PUBLIC LICENSE
 * for more read the LICENSE file
 *
 * Created by makeo @ 15.09.2015 18:25
 */
public class ModConfig {

    private static Configuration config;

    @Sync
    public static int golemDatawatcherId = 29;
    @Sync
    public static int dimOuterId = -73;
    public static boolean doLightCalculations = true;
    public static int maxMazeCount = -1;

    //Skyblock stuff
    @Sync
    public static boolean ancientStoneRecipes = false;

    private ModConfig() {}

    public static void init(File file) {
        config = new Configuration(file);

        config.load();

        loadFromConfig();

        config.save();
    }

    private static void loadFromConfig() {
        golemDatawatcherId = config.getInt("datawatcherId", "golem", 29, 0, 31, "Do not edit unless you know what are you doing!");
        dimOuterId = config.getInt("dimOuterId", "dimension", -73, Integer.MIN_VALUE, Integer.MAX_VALUE, "Dimension Id for the eldrich mazes accessed via Node Manipulator");
        doLightCalculations = config.getBoolean("calculateEldritchLight", "dimension", true, "TRUE = Calculating Light values for the Gadomancy-Eldritch Mazes; FALSE = No calculation, but some Light Bugs - Calculating the Light takes ~2 seconds -> Can be measured when trying to enter the eldritch mazed via Gadomancy Eldritch portal.");
        maxMazeCount = config.getInt("maxMazeCount", "dimension", -1, -1, Integer.MAX_VALUE, "Defines how many Eldritch mazes may exist at the same time using the Gadomancy Eldritch ritual. (-1 = infinite) Note that 1 maze = 1 player; Once the player finishes the maze, the maze closes itself and teleports the player out.");

        ancientStoneRecipes = config.getBoolean("ancientStoneRecipes", "skyblock", false, "TRUE = Adds recipes for Ancient Stone and Ancient Stone Pedestal (This may be usefull for severs and skyblock packs to craft the Node Manipulator and get more primodial pearls)");
    }
}
