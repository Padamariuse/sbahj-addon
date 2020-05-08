package com.jup.sbahjaddon.entity;

import com.jup.sbahjaddon.Sbahj;
import com.jup.sbahjaddon.entity.item.*;
import com.mraof.minestuck.Minestuck;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class SbahjEntities 
{
	public static int currentEntityIdOffset = 0;
	
	public static void registerEntities()
	{
		registerEntity(EntityConksuckBoot.class, "conksuckBoot", "conksuck_boot");
		registerEntity(EntityUnrealAir.class, "unrealAir", "unreal_air");
	}
	
	public static void registerEntity(Class<? extends Entity> entityClass, String name)
	{
		registerEntity(entityClass, name, name, 80, 3, true);
	}
	
	//registers entity with forge and minecraft, and increases currentEntityIdOffset by one in order to prevent id collision
	public static void registerEntity(Class<? extends Entity> entityClass, String name, String registryName)
	{
		registerEntity(entityClass, name, registryName, 80, 3, true);
	}

	public static void registerEntity(Class<? extends Entity> entityClass, String name, String registryName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(new ResourceLocation("sbahjaddon", registryName), entityClass, "sbahjaddon." + name, currentEntityIdOffset, Sbahj.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
		currentEntityIdOffset++;
	}
}
