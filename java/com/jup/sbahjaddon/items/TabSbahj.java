package com.jup.sbahjaddon.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabSbahj extends CreativeTabs 
{
	public static final TabSbahj instance = new TabSbahj("tabMod");
	
	private TabSbahj(String label)
	{
		super(label);
	}
	
	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(SbahjItems.nut);
	}
}
