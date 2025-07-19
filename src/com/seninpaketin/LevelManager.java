package com.seninpaketin;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class LevelManager {

    private static final File file = new File(Main.getInstance().getDataFolder(), "data.yml");
    private static final YamlConfiguration data = YamlConfiguration.loadConfiguration(file);

    public static int getXpRequired(int level) {
        return level * level * 10;
    }

    public static int getXp(UUID uuid) {
        return data.getInt(uuid.toString() + ".xp", 0);
    }

    public static int getLevel(UUID uuid) {
        return data.getInt(uuid.toString() + ".level", 1);
    }

    public static void addXp(UUID uuid, int amount) {
        int xp = getXp(uuid) + amount;
        int level = getLevel(uuid);

        while (xp >= getXpRequired(level)) {
            xp -= getXpRequired(level);
            level++;
        }

        data.set(uuid.toString() + ".xp", xp);
        data.set(uuid.toString() + ".level", level);
        save();
    }

    private static void save() {
        try {
            data.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
