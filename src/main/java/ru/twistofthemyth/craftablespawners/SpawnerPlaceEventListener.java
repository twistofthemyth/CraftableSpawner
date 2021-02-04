package ru.twistofthemyth.craftablespawners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.logging.Level;

public class SpawnerPlaceEventListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        final Block block = event.getBlock();
        if (block.getBlockData().getMaterial().equals(Material.SPAWNER)) {
            final CreatureSpawner spawner = (CreatureSpawner) block.getState();
            spawner.setSpawnedType(EntityType.EXPERIENCE_ORB);
            spawner.setSpawnCount(0);
            spawner.update();
            Plugin.logger.log(Level.INFO, "Ставлю неактивный спавнер");
        }
    }
}
