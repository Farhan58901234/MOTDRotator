package me.farhan.motdrotator.Commands;

import me.farhan.motdrotator.MOTDRotator;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MOTDCommand implements CommandExecutor {

    private final MOTDRotator plugin;

    public MOTDCommand(MOTDRotator plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("motd.reload")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
            return true;
        }

        plugin.getMotdManager().loadConfig();
        sender.sendMessage(ChatColor.GREEN + "MOTD config reloaded!");
        return true;
    }
}
