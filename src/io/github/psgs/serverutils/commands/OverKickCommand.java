package io.github.psgs.serverutils.commands;

import io.github.psgs.serverutils.ServerUtils;
import org.bukkit.command.CommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class OverKickCommand implements CommandExecutor {

    private ServerUtils plugin;

    public OverKickCommand(ServerUtils plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("overkick")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.GOLD + "Please specify a player to OverKick!");
            } else {
                if (sender.isOp()) {
                    final String name = args[0];
                    if (plugin.getServer().getPlayer(name).isOnline()) {
                        plugin.getServer().getPlayer(name).kickPlayer(ChatColor.RED + "You've been OverKicked by " + sender.getName());
                        sender.sendMessage(ChatColor.GOLD + "You OverKicked " + name);
                    } else {
                        sender.sendMessage(name + ChatColor.GOLD + " is not online!");
                    }
                }
            }
        }
        return false;
    }
}
