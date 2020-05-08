package com.jup.sbahjaddon.client;

import com.mraof.minestuck.client.gui.captchalouge.QueueGuiHandler;
import com.mraof.minestuck.client.gui.captchalouge.QueuestackGuiHandler;
import com.mraof.minestuck.client.gui.captchalouge.SylladexGuiHandler;
import com.mraof.minestuck.inventory.captchalouge.Modus;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class SweetBroGuiHandler extends QueuestackGuiHandler
{
	public SweetBroGuiHandler(Modus modus) 
	{
		super(modus);
		textureIndex = 0;
	}
}
