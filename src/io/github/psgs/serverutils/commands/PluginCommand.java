package io.github.psgs.serverutils.commands;

import io.github.psgs.serverutils.ServerUtils;
import org.bukkit.command.CommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class PluginCommand implements CommandExecutor {

    private ServerUtils plugin;

    public PluginCommand(ServerUtils plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("plugins")) {
            if (!sender.isOp() || !sender.hasPermission("bukkit.command.plugins")) {
                sender.sendMessage(ChatColor.RED + "I don't think so!");
            }
        }

        if (cmd.getName().equalsIgnoreCase("?")) {
            if (!sender.isOp() || !sender.hasPermission("bukkit.command.plugins")) {
                sender.sendMessage(ChatColor.RED + "I don't think so!");
            }
        }
        return false;
    }
}
