package com.jup.sbahjaddon.blocks;

import java.util.List;

import com.jup.sbahjaddon.items.SbahjItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class BlockSbahj extends Block
{
	public BlockSbahj(Material blockMaterialIn) 
	{
		super(blockMaterialIn);
		this.setCreativeTab(SbahjItems.tabSbahj);
	}
	
	public BlockSbahj(Material blockMaterialIn, MapColor blockMapColorIn) 
	{
		super(blockMaterialIn, blockMapColorIn);
		this.setCreativeTab(SbahjItems.tabSbahj);
	}
	
	@Override
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) 
	{
        String key = getUnlocalizedName()+".tooltip";
        if(!I18n.translateToLocal(key).equals(key))
            tooltip.add(I18n.translateToLocal(key));
		super.addInformation(stack, player, tooltip, advanced);
	}
}
