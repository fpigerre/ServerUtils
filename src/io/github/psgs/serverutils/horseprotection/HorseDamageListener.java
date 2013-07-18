package io.github.psgs.serverutils.horseprotection;

/**
 * HorseProtection | OresomeCraft administration plugin
 *
 * @author Zach De Koning (Zachoz), Pegabeavercorn
 */

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import io.github.psgs.serverutils.ServerUtils;
import io.github.psgs.serverutils.horseprotection.*;

public class HorseDamageListener implements Listener {

    private ServerUtils plugin;

    public HorseDamageListener(ServerUtils plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getEntityType() == EntityType.HORSE) {
            if (plugin.getConfig().getString(event.getEntity().getUniqueId().toString() + ".Owner") != null) {
                event.setCancelled(true);
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (p.hasPermission("HorseProtection.moderator") && (event.getDamager() instanceof Player)) {
                        p.sendMessage(ChatColor.RED + "User" + ChatColor.DARK_RED + ((Player) event.getDamager()).getName()
                                + ChatColor.RED + " tried to damage a horse belonging to "
                                + plugin.getConfig().getString(event.getEntity().getUniqueId().toString() + ".Owner"));

                    }
                }
            }
        }
    }
}
