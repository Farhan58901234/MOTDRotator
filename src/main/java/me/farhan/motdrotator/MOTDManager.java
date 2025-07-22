
package me.farhan.motdrotator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.List;
import java.util.Random;

public class MOTDManager {

    private final MOTDRotator plugin;
    private List<String> motds;
    private String currentMOTD;
    private int index = 0;
    private boolean random;
    private BukkitTask rotationTask;

    public MOTDManager(MOTDRotator plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void loadConfig() {
        plugin.reloadConfig();
        motds = plugin.getConfig().getStringList("motds");
        random = plugin.getConfig().getBoolean("random", false);
        index = 0;
        updateCurrentMOTD();
        startRotation();
    }

    public void startRotation() {
        if (rotationTask != null && !rotationTask.isCancelled()) {
            rotationTask.cancel();
        }

        int interval = plugin.getConfig().getInt("interval", 60);

        rotationTask = new BukkitRunnable() {
            @Override
            public void run() {
                updateCurrentMOTD();
            }
        }.runTaskTimer(plugin, 0L, interval * 20L);
    }

    private void updateCurrentMOTD() {
        if (motds == null || motds.isEmpty()) {
            currentMOTD = ChatColor.RED + "No MOTDs configured!";
            return;
        }

        if (random) {
            Random rand = new Random();
            currentMOTD = colorize(motds.get(rand.nextInt(motds.size())));
        } else {
            currentMOTD = colorize(motds.get(index));
            index = (index + 1) % motds.size();
        }

        Bukkit.getLogger().info("[MOTDRotator] Updated MOTD: " + ChatColor.stripColor(currentMOTD));
    }

    public String getCurrentMOTD() {
        return currentMOTD;
    }

    private String colorize(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
