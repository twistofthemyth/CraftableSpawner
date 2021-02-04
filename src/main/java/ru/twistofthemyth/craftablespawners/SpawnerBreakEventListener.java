package ru.twistofthemyth.craftablespawners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.logging.Level;

public class SpawnerBreakEventListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        final Block block = event.getBlock();
        if (block.getBlockData().getMaterial().equals(Material.SPAWNER)) {
            final CreatureSpawner spawner = (CreatureSpawner) block.getState();
            block.getWorld().dropItemNaturally(block.getLocation(),
                    new ItemStack(Utils.entityToEgg(spawner.getSpawnedType()), 1));
            Plugin.logger.log(Level.INFO, "Выдаю " + Utils.entityToEgg(spawner.getSpawnedType()) + "за поломку спавнера");
        }
    }
}
