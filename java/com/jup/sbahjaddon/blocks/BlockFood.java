package com.jup.sbahjaddon.blocks;

import java.util.Random;

import com.jup.sbahjaddon.items.SbahjItems;
import com.jup.sbahjaddon.items.TabSbahj;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;

public class BlockFood extends BlockSbahj
{
	private Item itemDropped;
	private int baseAmount;
	private int randomAmount;
	
	protected BlockFood(Material material, SoundType soundtype, Item itemDropped, int baseAmount, int randomAmount) 
	{
		super(material);
		this.setSoundType(soundtype);
		this.setCreativeTab(TabSbahj.instance);
		setHardness(0.5F);
		this.itemDropped = itemDropped;
		this.baseAmount = baseAmount;
		this.randomAmount = randomAmount;
	}
	
	protected BlockFood(Material material, SoundType soundtype, CreativeTabs tab, Item itemDropped, int baseAmount, int randomAmount) 
	{
		super(material);
		this.setSoundType(soundtype);
		this.setCreativeTab(tab);
		setHardness(0.5F);
		this.itemDropped = itemDropped;
		this.baseAmount = baseAmount;
		this.randomAmount = randomAmount;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return itemDropped;
    }
	
	@Override
	public int quantityDropped(Random random)
    {
        return baseAmount + random.nextInt(randomAmount);
    }
}
