package com.jourboon.main.events;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import com.jourboon.main.CrazyThief;

public class EntityDeathManager implements Listener{
	
	private CrazyThief plugin;
	public EntityDeathManager(CrazyThief plugin) {
		this.plugin = plugin;
	}
		
		private ItemStack[] goldbag = {
				new ItemStack(Material.GOLD_NUGGET, 16),
				new ItemStack(Material.GOLD_INGOT, 2),
				new ItemStack(Material.GOLD_ORE, 3),
				new ItemStack(Material.GOLD_BLOCK, 1),
				new ItemStack(Material.DIAMOND, 1),
				new ItemStack(Material.GOLDEN_APPLE, 2),
				new ItemStack(Material.GOLDEN_AXE, 1),
				new ItemStack(Material.GOLDEN_HELMET, 1),
				new ItemStack(Material.GOLDEN_HOE, 1),
				new ItemStack(Material.GOLDEN_LEGGINGS, 1),
				new ItemStack(Material.GOLDEN_CHESTPLATE, 1),
				new ItemStack(Material.GOLDEN_BOOTS, 1),
				new ItemStack(Material.GOLDEN_PICKAXE, 1),
				new ItemStack(Material.GOLDEN_SHOVEL, 1),
				new ItemStack(Material.GOLDEN_SWORD, 1),
				new ItemStack(Material.GOLDEN_CARROT, 4),
				new ItemStack(Material.ENDER_PEARL, 1),
				new ItemStack(Material.DIRT, 35),
		};
		
		@EventHandler
		public void onDeath(EntityDeathEvent event) {
			if (!(event.getEntity() instanceof Villager))
				return;
			if (event.getEntity().getCustomName() == null)
				return;
			if (!event.getEntity().getCustomName().contains("Thief Villager"))
				return;
			
			Random r = new Random();
			event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), goldbag[r.nextInt(goldbag.length + 0) - 0]);
			
			for (ItemStack item : plugin.stolenItems) {
				if (item != null)
					event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), item);
			
		}

	}
}
