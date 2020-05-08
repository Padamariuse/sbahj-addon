package com.jup.sbahjaddon.world.structures;

import java.util.Random;

import com.jup.sbahjaddon.blocks.SbahjBlocks;
import com.mraof.minestuck.world.lands.decorator.structure.SimpleStructureDecorator;
import com.mraof.minestuck.world.lands.gen.ChunkProviderLands;
import com.mraof.minestuck.world.lands.structure.blocks.StructureBlockUtil;
import com.mraof.minestuck.world.storage.loot.MinestuckLoot;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class SandwichStackDecorator extends SimpleStructureDecorator 
{
	public SandwichStackDecorator(Biome... biomes)
	{
		super(biomes);
	}
	
	@Override
	public float getPriority() 
	{
		return 0.25F;
	}

	@Override
	protected BlockPos generateStructure(World world, Random random, BlockPos pos, ChunkProviderLands provider) 
	{
		final int width = 2 + random.nextInt(2);
		final int height;
		if(random.nextInt(4) == 1)
		{
			height = 33 + random.nextInt(48);
		} else
		{
			height = 7 + random.nextInt(48);
		}
		
		final IBlockState ingredients[] = new IBlockState[] {SbahjBlocks.cheese.getDefaultState(), SbahjBlocks.turkey.getDefaultState(), SbahjBlocks.tomato.getDefaultState(), Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.DECAYABLE, false)};
		
		pos = world.getTopSolidOrLiquidBlock(pos);
		pos = pos.up(height);
		if(random.nextInt(9) == 8)
		{
			EnumFacing[] facing = new EnumFacing[] {EnumFacing.EAST, EnumFacing.WEST, EnumFacing.SOUTH, EnumFacing.EAST};
			pos = pos.up(1);
			world.setBlockState(pos, Blocks.CHEST.getDefaultState().withProperty(BlockChest.FACING, facing[random.nextInt(facing.length)]), 2);
			
			TileEntity te = world.getTileEntity(pos);
			if(te instanceof TileEntityChest)
			{
				TileEntityChest chest = (TileEntityChest) te;
				chest.setLootTable(MinestuckLoot.BASIC_MEDIUM_CHEST, random.nextLong());
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
		
		return pos;
	}

	@Override
	public int getCount(Random random) 
	{
		return random.nextFloat() < 0.25F ? 1 : 0;
	}

}
