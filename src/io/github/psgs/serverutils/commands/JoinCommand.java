package io.github.psgs.serverutils.commands;

import io.github.psgs.serverutils.ServerUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.Location;

public class JoinCommand implements CommandExecutor {

    private ServerUtils plugin;

    public JoinCommand(ServerUtils plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("join")) {
            final String senderName = sender.getName();
            if (args[0].equalsIgnoreCase("dropper")) {

                final String name = plugin.getConfig().getString("dropperWorld");
                World w = Bukkit.getServer().getWorld(name);

                //Define Dropper Spawn here
                Location dropperSpawn = new Location(w, 12.59, 9, -0.5, -90, 0);
                plugin.getServer().getPlayer(senderName).teleport(dropperSpawn);
                sender.sendMessage(ChatColor.GOLD + "You teleported to the Dropper spawn zone!");
            }
        }
        return false;
    }
}
