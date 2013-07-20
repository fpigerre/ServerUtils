package io.github.psgs.serverutils;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;

import io.github.psgs.serverutils.commands.OpCommand;
import io.github.psgs.serverutils.commands.PartyCommand;
import io.github.psgs.serverutils.commands.PluginCommand;
import io.github.psgs.serverutils.credits.CreditCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.RegisteredServiceProvider;

import io.github.psgs.serverutils.horseprotection.*;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class ServerUtils extends JavaPlugin {

    ServerUtils plugin;

    public void ServerUtils(ServerUtils plugin) {
        this.plugin = plugin;
    }

    private static final Logger log = Logger.getLogger("Minecraft");

    public static Economy econ = null;
    public static Permission perms = null;

    private ArrayList<CurrentEditMode> playersEditing;

    @Override
    public void onEnable() {

        File config = new File(this.getDataFolder(), "config.yml");
        if (!config.exists()) {
            this.saveDefaultConfig();
            this.getConfig().options().copyHeader(true);
            System.out.println("[" + getDescription().getName()
                    + "] No config.yml detected, config.yml created");
        } // Checks if config.yml exists and creates if false

        // Sets up Vault Economy
        setupEconomy();
        /*if (!setupEconomy()) {
            log.severe(String.format(
					"[%s] - Disabled due to no Vault dependency found!",
					getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}*/

        playersEditing = new ArrayList<CurrentEditMode>();

        //Register Horse Stuff
        getCommand("horse").setExecutor(new HorseProtectionCommands(this));
        getServer().getPluginManager().registerEvents(
                new HorseInteractListener(this), this);
        getServer().getPluginManager().registerEvents(
                new HorseDamageListener(this), this);

        //Register Commands
        getCommand("op").setExecutor(new OpCommand(this));
        getCommand("party").setExecutor(new PartyCommand(this));
        getCommand("credits").setExecutor(new CreditCommand(this));

        this.getLogger().info(
                "[" + getDescription().getName() + "] "
                        + getDescription().getName() + " "
                        + getDescription().getVersion() + " is enabled!");
    } // Logs to console that plugin is enabled

    @Override
    public void onDisable() {
        this.getLogger().info(
                getDescription().getName() + " "
                        + getDescription().getVersion() + " is disabled!");
    } // Logs to console that plugin is disabled

    // Horse Protection - OresomeCraft plugin by @Zachoz and Pegabeavercorn
    public void setEdit(String name, EditType editType, String misc) {
        CurrentEditMode e = null;
        for (CurrentEditMode edit : playersEditing) {
            if (edit.playerName.equalsIgnoreCase(name)) {
                if (editType == EditType.NONE) {
                    e = edit;
                } else {
                    edit.editType = editType;
                    edit.additionalInfo = misc;
                    return;
                }
            }
        }
        if (editType != EditType.NONE) {
            playersEditing.add(new CurrentEditMode(name, editType, misc));
        } else if (e != null) {
            playersEditing.remove(e);
        }
    }

    public EditType containsPlayer(String name) {
        for (CurrentEditMode edit : playersEditing) {
            if (edit.playerName.equalsIgnoreCase(name)) {
                return edit.editType;
            }
        }
        return EditType.NONE;
    }

    public String getAdditionalInfo(String name) {
        for (CurrentEditMode edit : playersEditing) {
            if (edit.playerName.equalsIgnoreCase(name)) {
                return edit.additionalInfo;
            }
        }
        return null;
    }

    // Vault - Economy Plugin

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer()
                .getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
}