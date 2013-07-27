package io.github.psgs.serverutils.commands;

import io.github.psgs.serverutils.ServerUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.Location;

public class LeaveCommand implements CommandExecutor {

    private ServerUtils plugin;

    public LeaveCommand(ServerUtils plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("leave")) {
            final String senderName = sender.getName();

                final String name = plugin.getConfig().getString("hub");
                World w = Bukkit.getServer().getWorld(name);

                //Define Hub Spawn here
                Location hub = new Location(w, -526.5, 61, -187.5);
                plugin.getServer().getPlayer(senderName).teleport(hub);
                sender.sendMessage(ChatColor.GOLD + "You left the game!");
        }
        return false;
    }
}
