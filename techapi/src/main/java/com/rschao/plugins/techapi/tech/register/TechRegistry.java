package com.rschao.plugins.techapi.tech.register;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rschao.plugins.techapi.tech.Technique;

public class TechRegistry {
    private static final Map<String, List<Technique>> fruitTechniques = new HashMap<>();
    /**
     * Registers a technique for a specific fruit.
     * This method allows you to add a technique to a fruit's list of techniques.
     * @param fruitId the unique identifier of the fruit
     * @param technique the technique to be registered
     */
    public static void registerTechnique(String fruitId, Technique technique) {
        fruitTechniques.computeIfAbsent(fruitId, k -> new ArrayList<>()).add(technique);
    }
    /**
     * Retrieves all normal techniques (non-ultimate) for a specific fruit.
     * @param fruitId the unique identifier of the fruit
     * @return a list of normal techniques for the specified fruit
     */
    public static List<Technique> getNormalTechniques(String fruitId) {
        return fruitTechniques.getOrDefault(fruitId, List.of())
            .stream().filter(t -> !t.isUltimate()).toList();
    }
    /**
     * Retrieves all ultimate techniques for a specific fruit.
     * @param fruitId the unique identifier of the fruit
     * @return a list of ultimate techniques for the specified fruit
     */

    public static List<Technique> getUltimateTechniques(String fruitId) {
        return fruitTechniques.getOrDefault(fruitId, List.of())
            .stream().filter(Technique::isUltimate).toList();
    }
    /**
     * Retrieves all techniques (both normal and ultimate) for a specific fruit.
     * @param fruitId the unique identifier of the fruit
     * @return a list of all techniques for the specified fruit
     */
    //a method to get all techniques (normal and ultimates) from a fruit
    public static List<Technique> getAllTechniques(String fruitId) {
        return fruitTechniques.getOrDefault(fruitId, List.of());
    }


}
