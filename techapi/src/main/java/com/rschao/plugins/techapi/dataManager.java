package com.rschao.plugins.techapi;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class dataManager {
    public static void saveToConfig(File file, String key, Object value) {
        File configFile = file;
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);
        config.set(key, value);
        try {
            config.save(configFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Debugging output
        System.out.println("Saving " + key + " to " + file.getName() + ": " + value);
    }
    public static Object loadFromConfig(File file, String key) {
        File configFile = file;
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);
        Object value = config.get(key);
        // Debugging output
        System.out.println("Loading " + key + " from " + file.getName() + ": " + value);
        return value;
    }
}
