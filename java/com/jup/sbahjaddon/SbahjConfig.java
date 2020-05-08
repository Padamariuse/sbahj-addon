package com.jup.sbahjaddon;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SbahjConfig 
{
	
	public static Configuration config;
	public static Side gameSide;
	
	public static boolean nutTime;
	
	public static void loadConfigFile(File file, Side side)
	{
		gameSide = side;
		config = new Configuration(file, true);
		config.load();
		
		config.save();
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.getModID().equals(Sbahj.class.getAnnotation(Mod.class).modid()))
		{
			nutTime = config.get("General", "nutTime", true, "if this is true you can harvest nuts from the earth").setLanguageKey("sbahjaddon.config.nutTime").getBoolean();
			config.save();
			
		}
	}

}
