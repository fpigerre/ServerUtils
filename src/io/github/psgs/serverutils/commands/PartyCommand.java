package io.github.psgs.serverutils.commands;

import io.github.psgs.serverutils.ServerUtils;
import org.bukkit.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.Effect;

public class PartyCommand implements CommandExecutor {

    ServerUtils plugin;

    public PartyCommand(ServerUtils plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        final String name = plugin.getConfig().getString("hubWorld");
        World w = Bukkit.getServer().getWorld(name);
        Location hub = new Location(w, -526.5, 61, -187.5);

        if (cmd.getName().equalsIgnoreCase("party")) {
            if (sender.isOp() || sender.hasPermission("utils.party")) {
                w.playEffect(hub, Effect.STEP_SOUND, 152);

            } else {
                sender.sendMessage(ChatColor.RED + "I don't think so!");
            }
        }
        return false;
    }
}
