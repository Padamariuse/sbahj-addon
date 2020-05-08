package com.jup.sbahjaddon.entity.item;

import java.util.EnumSet;
import java.util.Set;

import com.jup.sbahjaddon.items.SbahjItems;
import com.mraof.minestuck.entity.item.EntityHangingArt;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityConksuckBoot extends EntityHangingArt<EntityConksuckBoot.ConksuckBootArt>
{
	public EntityConksuckBoot(World worldIn)
	{
		super(worldIn);
	}
	
	public EntityConksuckBoot(World worldIn, BlockPos pos, EnumFacing facing) 
	{
		super(worldIn, pos, facing);
	}

	@Override
	public Set getArtSet() 
	{
		return EnumSet.allOf(ConksuckBootArt.class);
	}

	@Override
	public ConksuckBootArt getDefault() 
	{
		return ConksuckBootArt.NORMAL;
	}

	@Override
	public ItemStack getStackDropped() 
	{
		return new ItemStack(SbahjItems.conksuckBoot);
	}
	
	public static enum ConksuckBootArt implements EntityHangingArt.IArt
	{
		NORMAL("Normal", 16, 16, 0, 0);
		
		private final String title;
		private final int sizeX, sizeY;
		private final int offsetX, offsetY;
		
		private ConksuckBootArt(String title, int sizeX, int sizeY, int offsetX, int offsetY)
		{
			this.title = title;
			this.sizeX = sizeX;
			this.sizeY = sizeY;
			this.offsetX = offsetX;
			this.offsetY = offsetY;
		}
		
		@Override
		public String getTitle()
		{return title;}
		@Override
		public int getSizeX()
		{return sizeX;}
		@Override
		public int getSizeY()
		{return sizeY;}
		@Override
		public int getOffsetX()
		{return offsetX;}
		@Override
		public int getOffsetY()
		{return offsetY;}
	}
}
