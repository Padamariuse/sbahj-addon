package com.jup.sbahjaddon.world.structures;

import java.util.Random;

import com.jup.sbahjaddon.blocks.SbahjBlocks;
import com.mraof.minestuck.world.lands.decorator.structure.SimpleStructureDecorator;
import com.mraof.minestuck.world.lands.gen.ChunkProviderLands;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class AirBlockDecorator extends SimpleStructureDecorator
{
	private Block block;
	private int tries;

	public AirBlockDecorator(Block block, int tries, Biome... biomes)
    {
        super(biomes);
        this.block = block;
        this.tries = tries;
    }
	
	@Override
	public float getPriority() 
	{
		return 1F;
	}

	@Override
	protected BlockPos generateStructure(World world, Random random, BlockPos pos, ChunkProviderLands provider) 
	{
		Random ran = new Random();
        pos = world.getHeight(pos);
        pos = pos.up(15 + ran.nextInt(50));
        
        if(!world.getBlockState(pos).isFullBlock())
        {
        	world.setBlockState(pos, block.getDefaultState());
        }
        
		return pos;
	}

	@Override
	public int getCount(Random random) 
	{
		return tries;
	}

}
