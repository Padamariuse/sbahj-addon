package com.jup.sbahjaddon.world;

import com.jup.sbahjaddon.Sbahj;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableRegistry 
{
	private static final String MODID = Sbahj.MODID;
	public static final ResourceLocation MEDIUM_BASIC = new ResourceLocation(MODID, "sbahjaddon:chests/sbahj_medium_basic");
	public static final ResourceLocation SUBWAY = new ResourceLocation(MODID, "sbahjaddon:chests/subway");
	public static final ResourceLocation CONSORT_SUBWAY = new ResourceLocation(MODID, "gameplay/consort_subway");
	public static final ResourceLocation CONSORT_FOOD = new ResourceLocation(MODID, "gameplay/sbahj_consort_food");
	
	public static void registerLootTables()
	{
    	LootTableList.register(MEDIUM_BASIC);
    	LootTableList.register(SUBWAY);
    	LootTableList.register(CONSORT_SUBWAY);
    	LootTableList.register(CONSORT_FOOD);
	}
}
