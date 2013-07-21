package io.github.psgs.serverutils.commands;

import io.github.psgs.serverutils.ServerUtils;
import org.bukkit.command.CommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class OpCommand implements CommandExecutor {

    private ServerUtils plugin;

    public OpCommand(ServerUtils plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("op")) {
            if (!sender.isOp() || !sender.hasPermission("bukkit.command.op") || !sender.hasPermission("bukkit.command.op.take") || !sender.hasPermission("bukkit.command.op.give")) {
                sender.sendMessage(ChatColor.RED + "I don't think so!");
            } else {
                if (sender.isOp() || sender.hasPermission("bukkit.command.op") || sender.hasPermission("bukkit.command.op.give")) {
                    final String name = args[0];
                    plugin.getServer().getPlayer(name).setOp(true);
                    sender.sendMessage(args[0] + " has been Opped!");
                }
            }
        }
        return false;
    }
}
