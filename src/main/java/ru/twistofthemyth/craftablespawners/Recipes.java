package ru.twistofthemyth.craftablespawners;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Recipes {
    public static void addSpawnerRecipe(JavaPlugin plugin) {
        ShapedRecipe spawnerRecipe = new ShapedRecipe(new NamespacedKey(plugin, "empty_spawner"), new ItemStack(Material.SPAWNER, 1));
        spawnerRecipe.shape("DDD", "DND", "DDD");
        spawnerRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        spawnerRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        plugin.getServer().addRecipe(spawnerRecipe);
    }
}
