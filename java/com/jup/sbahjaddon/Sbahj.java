package com.jup.sbahjaddon;

import java.util.Calendar;

import com.jup.sbahjaddon.blocks.SbahjBlocks;
import com.jup.sbahjaddon.captchalogue.ModusHandler;
import com.jup.sbahjaddon.entity.SbahjEntities;
import com.jup.sbahjaddon.items.SbahjItems;
import com.jup.sbahjaddon.proxy.CommonProxy;
import com.jup.sbahjaddon.world.LootTableRegistry;
import com.jup.sbahjaddon.world.lands.SbahjLandRegistries;
import com.mraof.minestuck.event.ServerEventHandler;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Sbahj.MODID, name = Sbahj.MODNAME, version = Sbahj.VERSION, useMetadata = true, dependencies = "required-after:minestuck@[1.4.292,);" ,acceptedMinecraftVersions = "[1.12,1.12.2]")
public class Sbahj {

    public static final String MODID = "sbahjaddon";
    public static final String MODNAME = "sbahj addon";
    public static final String VERSION = "0.0.1";

    @SidedProxy(clientSide = "com.jup.sbahjaddon.proxy.ClientProxy", serverSide = "com.jup.sbahjaddon.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static Sbahj instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
    	
      	MinecraftForge.EVENT_BUS.register(SbahjBlocks.class);
    	MinecraftForge.EVENT_BUS.register(SbahjItems.class);
    	MinecraftForge.EVENT_BUS.register(SbahjEvents.instance);
    	
    	SbahjConfig.loadConfigFile(event.getSuggestedConfigurationFile(), event.getSide());
    	proxy.preInit(event);
    	
    }
    

    @EventHandler
    public void init(FMLInitializationEvent e) 
    {
        proxy.init();
        
    	SbahjEntities.registerEntities();
    	
        SbahjAlchemyRecipes.registerVanillaRecipes();
    	SbahjAlchemyRecipes.registerMinestuckRecipes();
    	SbahjAlchemyRecipes.registerModRecipes();
    	
    	ModusHandler.registerModii();
    	
    	LootTableRegistry.registerLootTables();
    	
    	SbahjLandRegistries.registerShit();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) 
    {
    	
        proxy.postInit();
    
    }
    
    public static boolean isDayToday(int month, int day)
    {
    	return Calendar.getInstance().get(Calendar.MONTH) == month - 1 && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == day;
    }
}


