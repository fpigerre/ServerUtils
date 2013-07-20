package io.github.psgs.serverutils.credits;

import io.github.psgs.serverutils.ServerUtils;
import org.bukkit.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CreditCommand implements CommandExecutor {

    ServerUtils plugin;

    public CreditCommand(ServerUtils plugin) {
        this.plugin = plugin;

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("credits")) {
            if (sender.isOp() || sender.hasPermission("utils.credits")) {
                final String player = sender.getName();
                //If balance == 0
                if (plugin.econ.getBalance(player) == 0) {
                    sender.sendMessage(ChatColor.RED + "You have no credits!");
                } else {
                    //Return balance
                    sender.sendMessage(ChatColor.GOLD + "You have " + ChatColor.AQUA + plugin.econ.getBalance(player) + ChatColor.GOLD + " credits!");
                }
            }
        }
        return false;
    }
}