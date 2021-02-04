package ru.twistofthemyth.craftablespawners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.logging.Level;

public class SpawnerClickEventListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onClick(PlayerInteractEvent event) {
        if (event.useInteractedBlock().equals(Event.Result.DENY)) return;
        final Block block = event.getClickedBlock();
        final ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        if (block != null && block.getBlockData().getMaterial().equals(Material.SPAWNER)) {
            final CreatureSpawner spawner = (CreatureSpawner) block.getState();
            if (Utils.entityToEgg(spawner.getSpawnedType()).equals(item.getType()) ||
                    !spawner.getSpawnedType().equals(EntityType.EXPERIENCE_ORB)) {
                return;
            }

            final EntityType transformedEgg = Utils.eggToEntity(item.getType());
            if (transformedEgg != null) {
                item.setAmount(item.getAmount() - 1);
                spawner.setSpawnedType(transformedEgg);
                spawner.setSpawnCount(4);
                spawner.update();
                Plugin.logger.log(Level.INFO, "Активирую спавнер");
            }
        }
    }
}
