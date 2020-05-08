package com.jup.sbahjaddon.world.lands;

import static com.mraof.minestuck.world.lands.LandAspectRegistry.fromNameTerrain;

import com.jup.sbahjaddon.world.SbahjConsortStuff;
import com.mraof.minestuck.world.lands.LandAspectRegistry;
import com.mraof.minestuck.world.storage.loot.MinestuckLoot;

import net.minecraft.util.ResourceLocation;

public class SbahjLandRegistries 
{
	public static void registerShit()
	{
		LandAspectRegistry.registerLandAspect(new LandAspectSubway());
		SbahjConsortStuff.consortStuff();
	}
}
