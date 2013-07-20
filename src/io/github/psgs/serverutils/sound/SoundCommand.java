package io.github.psgs.serverutils.sound;

import io.github.psgs.serverutils.ServerUtils;
import org.bukkit.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class SoundCommand implements CommandExecutor {

    ServerUtils plugin;

    public SoundCommand(ServerUtils plugin) {
        this.plugin = plugin;

    }

    final String name = plugin.getConfig().getString("hubWorld");
    World w = Bukkit.getServer().getWorld(name);
    Location hub = new Location(w, -526.5, 61, -187.5);

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("sound")) {
            if (sender.hasPermission("utils.sound")) {
                if (args.length == 0) {


                    sender.sendMessage(ChatColor.DARK_PURPLE + "+-+-+-+-+-+-+["
                            + ChatColor.GREEN + "Available Sounds" + ChatColor.DARK_PURPLE
                            + "]+-+-+-+-+-+-+");
                    sender.sendMessage(ChatColor.GREEN + "Cave");
                    sender.sendMessage(ChatColor.GREEN + "Rain");
                    sender.sendMessage(ChatColor.GREEN + "Thunder");
                    sender.sendMessage(ChatColor.GREEN + "Fizz");
                    sender.sendMessage(ChatColor.GREEN + "Wither");
                    sender.sendMessage(ChatColor.GREEN + "Piano");
                    sender.sendMessage(ChatColor.DARK_PURPLE
                            + "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                    return true;
                } else {
                    if (args[0].equalsIgnoreCase("cave")) {
                        w.playSound(hub, Sound.AMBIENCE_CAVE, 10, 5);
                    } else {
                        if (args[0].equalsIgnoreCase("rain")) {
                            w.playSound(hub, Sound.AMBIENCE_RAIN, 10, 5);
                        } else {
                            if (args[0].equalsIgnoreCase("thunder")) {
                                w.playSound(hub, Sound.AMBIENCE_THUNDER, 10, 5);
                            } else {
                                if (args[0].equalsIgnoreCase("fizz")) {
                                    w.playSound(hub, Sound.FIZZ, 10, 5);
                                } else {
                                    if (args[0].equalsIgnoreCase("wither")) {
                                        w.playSound(hub, Sound.WITHER_DEATH, 10, 5);
                                    } else {
                                        if (args[0].equalsIgnoreCase("piano")) {
                                            w.playSound(hub, Sound.NOTE_PIANO, 10, 5);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}