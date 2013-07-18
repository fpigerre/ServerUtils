package io.github.psgs.serverutils.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class OpCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("op")) {
            if (sender.isOp() || sender.hasPermission("blah")) {
                //Do Nothing
            } else {
                sender.sendMessage(ChatColor.RED + "I don't think so!");
            }
        }
        return false;
    }
}
