package ru.twistofthemyth.craftablespawners;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Plugin extends JavaPlugin {

    public static Logger logger;

    @Override
    public void onEnable() {
        logger = Logger.getLogger("CraftableSpawner");
        logger.log(Level.INFO, "Starting CraftableSpawner...");

        getServer().getPluginManager().registerEvents(new SpawnerBreakEventListener(), this);
        getServer().getPluginManager().registerEvents(new SpawnerClickEventListener(), this);
        getServer().getPluginManager().registerEvents(new SpawnerPlaceEventListener(), this);

        Recipes.addSpawnerRecipe(this);
    }

    @Override
    public void onDisable() {
        logger.log(Level.INFO, "Closing CraftableSpawner...");
    }
}
