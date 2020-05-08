package com.jup.sbahjaddon.proxy;

import com.jup.sbahjaddon.client.*;
import com.jup.sbahjaddon.client.renderer.RenderUnrealAir;
import com.jup.sbahjaddon.entity.item.*;
import com.mraof.minestuck.client.model.ModelNakagator;
import com.mraof.minestuck.client.renderer.entity.RenderEntityMinestuck;
import com.mraof.minestuck.client.renderer.entity.RenderHangingArt;
import com.mraof.minestuck.entity.consort.EntityNakagator;

import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy 
{
	@Override
	public void preInit(FMLPreInitializationEvent event) 
	{
		MinecraftForge.EVENT_BUS.register(ModelHandler.class);
		
		RenderingRegistry.registerEntityRenderingHandler(EntityUnrealAir.class, RenderUnrealAir.getFactory(1.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityConksuckBoot.class, manager -> new RenderHangingArt<>(manager, "conksuck_boot"));
	}
	
	@Override
	public void init() 
	{
	
	}
}

