package me.farhan.motdrotator;

import me.farhan.motdrotator.Commands.MOTDCommand;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MOTDRotator extends JavaPlugin implements Listener {

    private MOTDManager motdManager;

    @Override
    public void onEnable() {
        saveDefaultConfig(); // loads config.yml
        motdManager = new MOTDManager(this);
        motdManager.startRotation();

        getCommand("motd").setExecutor(new MOTDCommand(this));
        Bukkit.getPluginManager().registerEvents(this, this);

        getLogger().info("MOTDRotator enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("MOTDRotator disabled.");
    }

    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {
        event.setMotd(motdManager.getCurrentMOTD());
    }

    public MOTDManager getMotdManager() {
        return motdManager;
    }
}
