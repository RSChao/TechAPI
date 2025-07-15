# Documentation:

**TechRegistry**
Manages the registration and retrieval of techniques for different fruits.

registerTechnique(String fruitId, Technique technique): Registers a technique for a specific fruit.

getNormalTechniques(String fruitId): Returns all non-ultimate techniques for a fruit.

getUltimateTechniques(String fruitId): Returns all ultimate techniques for a fruit.

getAllTechniques(String fruitId): Returns all techniques (normal and ultimate) for a fruit.

**hotbarMessage**
Utility for sending messages to a player's hotbar (action bar).

sendHotbarMessage(Player player, String message): Sends a message to the player's action bar.

**CooldownManager**

Handles cooldowns for player techniques.

isOnCooldown(Player player, String techniqueId): Checks if a player is on cooldown for a technique.

setCooldown(Player player, String techniqueId, long cooldownMillis): Sets a cooldown for a technique.

getRemaining(Player player, String techniqueId): Gets the remaining cooldown time in milliseconds.

removeCooldown(Player player, String techniqueId): Removes a specific technique's cooldown.

removeAllCooldowns(Player player): Removes all cooldowns for a player.

**PlayerTechniqueManager**

Tracks which technique a player currently has selected for each fruit.

getCurrentTechnique(UUID playerId, String fruitId): Gets the index of the currently selected technique for a fruit.

setCurrentTechnique(UUID playerId, String fruitId, int techniqueIndex): Sets the current technique index for a fruit.

**TechniqueAction**

Functional interface representing an action performed by a technique. Just a tool for executing the techniques, you wont use this much aside from the Technique declaration

execute(Player player, ItemStack fruit, Object... args): Executes the technique's action.

**Technique**

Represents a technique with an ID, name, ultimate status, cooldown, and action.

use(Player player, ItemStack fruit, Object... code): Executes the technique, handling cooldowns and feedback.

getId(): Returns the technique's unique ID.

getName(): Returns the technique's name.

isUltimate(): Returns whether the technique is an ultimate.

getCooldownMillis(): Returns the cooldown duration in milliseconds.

nullValue(): Returns a null Object array (utility).

**cooldownHelper**

Utility for converting time units to milliseconds.

hour: Constant for one hour in milliseconds.

secondsToMiliseconds(int seconds): Converts seconds to milliseconds.

minutesToMiliseconds(int minutes): Converts minutes to milliseconds.

**Awakening**

Tracks which fruits have been awakened by which players.

isAwakened(String playerId, String fruitId): Checks if a player has awakened a fruit.

setAwakened(String playerId, String fruitId, boolean awakened): Sets or unsets a fruit as awakened for a player.
