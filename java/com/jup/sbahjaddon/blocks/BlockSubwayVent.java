package com.jup.sbahjaddon.blocks;

import java.util.Random;

import com.jup.sbahjaddon.items.SbahjItems;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSubwayVent extends BlockSbahj
{
	public BlockSubwayVent(Material blockMaterialIn) 
	{
		super(blockMaterialIn);
		this.blockHardness = 2.0F;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		ItemStack stonk = new ItemStack(SbahjItems.weirdStonk);
		if(worldIn.isRemote)
		{
			playerIn.addItemStackToInventory(stonk);
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) 
	{
		entityIn.fall(fallDistance, 0.0F);
		super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
	}
	
	@Override
	public void onLanded(World worldIn, Entity entityIn) 
	{
		Random ran = new Random();
		entityIn.motionY += 1 + (ran.nextDouble() * 2.0D);
	}
	
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
