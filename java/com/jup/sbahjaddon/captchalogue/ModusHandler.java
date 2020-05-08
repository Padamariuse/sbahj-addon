package com.jup.sbahjaddon.captchalogue;

import com.jup.sbahjaddon.items.SbahjItems;
import com.mraof.minestuck.inventory.captchalouge.CaptchaDeckHandler;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ModusHandler 
{
	public static void registerModii()
	{
		CaptchaDeckHandler.registerModusType(new ResourceLocation("sweet_bros_modus"), SweetBrosModus.class, new ItemStack(SbahjItems.sweetBrosModus));
	}
}
