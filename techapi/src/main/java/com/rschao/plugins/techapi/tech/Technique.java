package com.rschao.plugins.techapi.tech;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.rschao.plugins.techapi.tech.cooldown.CooldownManager;
import com.rschao.plugins.techapi.tech.feedback.hotbarMessage;
public class Technique {
    private final String id;
    private final String name;
    private final boolean isUltimate;
    private final TechniqueAction action;
    private long cooldownMillis; // e.g., 5000 for 5 seconds

    public Technique(String id, String name, boolean isUltimate, long cooldownMillis, TechniqueAction action) {
        this.id = id;
        this.name = name;
        this.isUltimate = isUltimate;
        this.cooldownMillis = cooldownMillis;
        this.action = action;
    }
    
    /**
     * Executes the technique for the given player using the specified fruit item.
     * If the player is on cooldown, it sends a hotbar message indicating the remaining time.
     * This method is used to trigger the technique action.
     * 
     * @param player player using the technique
     * @param fruit the fruit item used to execute the technique
     * @param code additional parameters for the technique action
     */
    public void use(Player player, ItemStack fruit, Object... code) {
        if (CooldownManager.isOnCooldown(player, getId())) {
            long remaining = CooldownManager.getRemaining(player, getId());
            hotbarMessage.sendHotbarMessage(player, "On cooldown! Wait " + (remaining / 1000.0) + " seconds.");
            return;
        }

        // Execute the technique
        action.execute(player, fruit, code);

        // Set the cooldown
        CooldownManager.setCooldown(player, getId(), getCooldownMillis());
    }
    /**
     * gives the unique identifier of the technique.
     * 
     * @return the unique identifier of the technique
     */
    public String getId() {
        return id;
    }
    /**
     * gives the name of the technique.
     * 
     * @return the name of the technique
     */
    public String getName() {
        return name;
    }
    /**
     * checks if the technique is an ultimate technique.
     * 
     * @return true if the technique is an ultimate technique, false otherwise
     */
    public boolean isUltimate() {
        return isUltimate;
    }
    /**
     * gives the action associated with the technique.
     * 
     * @return the action associated with the technique
     */
    public long getCooldownMillis() {
        return cooldownMillis;
    }
    /**
     * static utility method
     * 
     * @return an empty array of Objects, used to represent a null value
     */
    public static Object[] nullValue(){
        return (Object[])null;
    }
    /**
     * sets the cooldown duration for the technique.
     * 
     * @param cooldownMillis the cooldown duration in milliseconds
     */
    public void setCooldownMillis(long cooldownMillis) {
        this.cooldownMillis = cooldownMillis;
    }
}
