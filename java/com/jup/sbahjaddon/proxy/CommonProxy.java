package com.jup.sbahjaddon.proxy;

import com.jup.sbahjaddon.SbahjConfig;
import com.jup.sbahjaddon.SbahjEvents;
import com.jup.sbahjaddon.blocks.SbahjBlocks;
import com.jup.sbahjaddon.items.SbahjItems;
import com.jup.sbahjaddon.world.lands.SbahjLandRegistries;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event)
	{
		SbahjConfig.loadConfigFile(event.getSuggestedConfigurationFile(), event.getSide());
	}
	
	public void init()
	{
		
	}
	
	public void postInit()
	{
		
	}
}
