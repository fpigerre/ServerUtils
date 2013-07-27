package io.github.psgs.serverutils.commands;

/**
 * OresomeUtils | OresomeCraft administration plugin
 *
 * @author Zach De Koning (Zachoz)
 */

import io.github.psgs.serverutils.ServerUtils;
import org.bukkit.command.CommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SendAllCommand implements CommandExecutor {

    private ServerUtils plugin;

    public SendAllCommand(ServerUtils plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("sendall")) {
            if (sender.hasPermission("utils.sendall")) {


                sender.sendMessage(ChatColor.GOLD + "Sent all users to server: " + args[0]);
                for (Player p : Bukkit.getOnlinePlayers()) {
                    ByteArrayOutputStream b = new ByteArrayOutputStream();
                    DataOutputStream out = new DataOutputStream(b);
                    try {
                        out.writeUTF("Connect");
                        out.writeUTF(args[0]);
                    } catch (IOException ex) { /* Impossible */ }
                    p.sendPluginMessage(ServerUtils.getInstance(), "BungeeCord", b.toByteArray());
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have the perms for this!");
            }
        }
        return false;
    }
}
