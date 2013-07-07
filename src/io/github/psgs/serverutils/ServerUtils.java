package io.github.psgs.serverutils;

import org.bukkit.plugin.java.JavaPlugin;

public class ServerUtils extends JavaPlugin {

	@Override
	public void onEnable() {

		this.getLogger().info(
				"[" + getDescription().getName() + "] "
						+ getDescription().getName() + " "
						+ getDescription().getVersion() + " is enabled!");
	} // Logs to console that plugin is enabled

	@Override
	public void onDisable() {
		this.getLogger().info(
				"[" + getDescription().getName() + "] "
						+ getDescription().getName() + " "
						+ getDescription().getVersion() + " is disabled!");
	} // Logs to console that plugin is disabled
}