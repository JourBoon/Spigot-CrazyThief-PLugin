package com.jourboon.main.mobs;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityPlayer;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.EntityVillager;
import net.minecraft.server.v1_16_R3.PathfinderGoalAvoidTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalPanic;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomStrollLand;

public class VillagerThief extends EntityVillager {
	
	public VillagerThief(Location loc) {
		super(EntityTypes.VILLAGER, ((CraftWorld) loc.getWorld()).getHandle());
		
		this.setPosition(loc.getX(), loc.getY(), loc.getZ());
		
		this.setCustomName(new ChatComponentText(ChatColor.GOLD + "" + ChatColor.BOLD + "Thief Villager"));
		this.setCustomNameVisible(true);
		this.setHealth(100);
		
		this.goalSelector.a(0, new PathfinderGoalAvoidTarget<EntityPlayer>(this, EntityPlayer.class, 20, 1.0D, 1.0D));
		this.goalSelector.a(1, new PathfinderGoalPanic(this, 2.0D));
		this.goalSelector.a(2, new PathfinderGoalRandomStrollLand(this, 0.6D));
		this.goalSelector.a(3, new PathfinderGoalRandomLookaround(this));
	}

}
