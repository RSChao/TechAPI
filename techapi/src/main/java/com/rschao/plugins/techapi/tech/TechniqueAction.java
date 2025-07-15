package com.rschao.plugins.techapi.tech;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@FunctionalInterface
public interface TechniqueAction {
    void execute(Player player, ItemStack fruit, Object... args);
    //boolean executeCheck(Player player, ItemStack fruit, Object... args);
}
