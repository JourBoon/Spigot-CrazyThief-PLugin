package com.jourboon.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.jourboon.main.events.BlockPlacingManager;
import com.jourboon.main.events.EntityDamageManager;
import com.jourboon.main.events.EntityDeathManager;

public class CrazyThief extends JavaPlugin{
	
	public List<ItemStack> stolenItems = new ArrayList<>();
	
	@Override
	public void onEnable() {
		PluginManager plm = this.getServer().getPluginManager();
		plm.registerEvents(new EntityDamageManager(), this);
		plm.registerEvents(new EntityDeathManager(this), this);
		plm.registerEvents(new BlockPlacingManager(this), this);
	}
	
	@Override
	public void onDisable() {
		
	}
}
