package com.jourboon.main.events;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import com.jourboon.main.CrazyThief;
import com.jourboon.main.mobs.VillagerThief;

import net.minecraft.server.v1_16_R3.WorldServer;

public class BlockPlacingManager implements Listener{
	
	private CrazyThief plugin;
	public BlockPlacingManager(CrazyThief plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		if (!event.getBlock().getType().equals(Material.GOLD_BLOCK)) 
			return;
		
		Random r = new Random();
		if ((r.nextInt(1000 + 0) - 0) > 100)
			return;
		
		VillagerThief chipeur = new VillagerThief(event.getPlayer().getLocation());
		WorldServer world = ((CraftWorld) event.getPlayer().getWorld()).getHandle();
		world.addEntity(chipeur);
		
		event.setCancelled(true);
		
		for (ItemStack item : event.getPlayer().getInventory().getContents()) 
			plugin.stolenItems.add(item);
		event.getPlayer().getInventory().clear();
	}

}
