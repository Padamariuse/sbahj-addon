package com.jup.sbahjaddon.blocks;

import java.util.List;
import java.util.Random;

import com.jup.sbahjaddon.items.SbahjItems;
import com.jup.sbahjaddon.items.TabSbahj;
import com.mraof.minestuck.block.BlockStrawberry;
import com.mraof.minestuck.item.TabMinestuck;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class BlockBigSandwhich extends BlockStrawberry
{
	protected BlockBigSandwhich() 
	{
		super();
		this.setSoundType(SoundType.PLANT);
		setUnlocalizedName("big_sandwhich");
		setDefaultState(getDefaultState().withProperty(FACING, EnumFacing.UP));
		this.setCreativeTab(TabSbahj.instance);
		setHardness(0.7F);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return SbahjItems.sandwhich;
    }
	
	@Override
	public int quantityDropped(Random random)
    {
        return 3 + random.nextInt(3);
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
