package com.seninpaketin.events;

import com.seninpaketin.LevelManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillListener implements Listener {

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player killer) {
            LevelManager.addXp(killer.getUniqueId(), 25);
            killer.sendMessage("§aBir oyuncu öldürdün! +25 XP");
        }
    }
}
