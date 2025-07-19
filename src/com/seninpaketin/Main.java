package com.seninpaketin;

import com.seninpaketin.events.KillListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new KillListener(), this);

        getCommand("seviye").setExecutor((sender, cmd, label, args) -> {
            if (sender instanceof org.bukkit.entity.Player player) {
                int level = LevelManager.getLevel(player.getUniqueId());
                int xp = LevelManager.getXp(player.getUniqueId());
                int nextXp = LevelManager.getXpRequired(level);
                player.sendMessage("§aSeviyen: §e" + level + " §7(" + xp + "/" + nextXp + " XP)");
            }
            return true;
        });

        getLogger().info("KlanPlugin etkin!");
    }

    public static Main getInstance() {
        return instance;
    }
}
