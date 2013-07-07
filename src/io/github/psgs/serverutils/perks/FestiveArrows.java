package io.github.psgs.serverutils.perks;

/**
 * FestiveArrows | FestiveArrows Plugin
 * 
 * @author YukonAppleGeek
 */

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

public class FestiveArrows implements Listener {

	@EventHandler
	public void onBowShoot(EntityShootBowEvent event) {
		FireworkMeta fireworkMeta = (FireworkMeta) (new ItemStack(
				Material.FIREWORK)).getItemMeta();
		Firework firework = (Firework) event
				.getProjectile()
				.getLocation()
				.getWorld()
				.spawnEntity(event.getProjectile().getLocation(),
						EntityType.FIREWORK);

		fireworkMeta.addEffect(FireworkEffect.builder().with(Type.BURST)
				.withColor(Color.RED).withColor(Color.WHITE)
				.withColor(Color.BLUE).withTrail().build());
		firework.setFireworkMeta(fireworkMeta);
		event.getProjectile().setPassenger(firework);
	}

}