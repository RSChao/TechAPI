package com.rschao.plugins.techapi.tech;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerTechniqueManager {
    // Map<playerUUID, Map<fruitId, techniqueIndex>>
    private static final Map<UUID, Map<String, Integer>> playerTechniques = new HashMap<>();

    public static int getCurrentTechnique(UUID playerId, String fruitId) {
        Map<String, Integer> techs = playerTechniques.get(playerId);
        if (techs == null) return 0; // default to first technique
        return techs.getOrDefault(fruitId, 0);
    }

    // Optional: set the current technique
    public static void setCurrentTechnique(UUID playerId, String fruitId, int techniqueIndex) {
        playerTechniques.computeIfAbsent(playerId, k -> new HashMap<>()).put(fruitId, techniqueIndex);
    }
}