package com.jup.sbahjaddon.world.structures;

import java.util.Random;

import com.jup.sbahjaddon.blocks.SbahjBlocks;
import com.mraof.minestuck.world.lands.gen.ChunkProviderLands;
import com.mraof.minestuck.world.lands.structure.IGateStructure;
import com.mraof.minestuck.world.storage.loot.MinestuckLoot;

import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GateStructureSandwichStack implements IGateStructure
{

	@Override
	public BlockPos generateGateStructure(World world, BlockPos pos, ChunkProviderLands provider) 
	{
		Random random = new Random();
		final int width = 2;
		final int height = 15 + random.nextInt(11);
		
		final IBlockState ingredients[] = new IBlockState[] {SbahjBlocks.cheese.getDefaultState(), SbahjBlocks.turkey.getDefaultState(), SbahjBlocks.tomato.getDefaultState(), Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.DECAYABLE, false)};
		
		pos = world.getTopSolidOrLiquidBlock(pos);
		pos = pos.up(height);
		BlockPos gatePos = pos.up(4);
		
		for(int x = -width; x <= width; x++)
		{
		    for(int z = -width; z<= width; z++)
		    {
		    	if(Math.abs(x) + Math.abs(z) >= width+2)
		    	{
		    	} else
		    	{
		    	    world.setBlockState(pos.north(x).west(z), SbahjBlocks.subwayBread.getDefaultState());
		    	}
		    }
		}
		
		pos = pos.down(1);
		
		for(int y = 0; y < height - 1; y++)
		{
			final int ingredient = random.nextInt(ingredients.length);
			for(int x = -width; x <= width; x++)
			{
			    for(int z = -width; z<= width; z++)
			    {
			    	if(Math.abs(x) + Math.abs(z) >= width+2)
			    	{ 
			    	} else
			    	{
			    	    world.setBlockState(pos.north(x).west(z), ingredients[ingredient]);
			    	}
			    }
			}
			pos = pos.down(1);
		}
		
		for(int x = -width; x <= width; x++)
		{
		    for(int z = -width; z<= width; z++)
		    {
		    	if(Math.abs(x) + Math.abs(z) >= width+2)
		    	{
		    	} else
		    	{
		    	    world.setBlockState(pos.north(x).west(z), SbahjBlocks.subwayBread.getDefaultState());
		    	}
		    }
		}
		
		return gatePos;
	}

}
