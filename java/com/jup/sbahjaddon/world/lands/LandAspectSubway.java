package com.jup.sbahjaddon.world.lands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.jup.sbahjaddon.blocks.SbahjBlocks;
import com.jup.sbahjaddon.world.structures.*;
import com.mraof.minestuck.block.MinestuckBlocks;
import com.mraof.minestuck.entity.consort.EnumConsort;
import com.mraof.minestuck.world.biome.BiomeMinestuck;
import com.mraof.minestuck.world.lands.decorator.ILandDecorator;
import com.mraof.minestuck.world.lands.decorator.SingleBlockDecorator;
import com.mraof.minestuck.world.lands.gen.ChunkProviderLands;
import com.mraof.minestuck.world.lands.gen.DefaultTerrainGen;
import com.mraof.minestuck.world.lands.gen.ILandTerrainGen;
import com.mraof.minestuck.world.lands.structure.IGateStructure;
import com.mraof.minestuck.world.lands.structure.blocks.StructureBlockRegistry;
import com.mraof.minestuck.world.lands.terrain.TerrainLandAspect;

import net.minecraft.block.BlockCake;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LandAspectSubway extends TerrainLandAspect
{
	static Vec3d fogColor = new Vec3d(0.9D, 0.6D, 0.2D);
	static Vec3d skyColor = new Vec3d(0.9D, 0.1D, 0.05D);
	
	@Override
	public String getPrimaryName() 
	{
		return "subway";
	}
	
	@Override
	public IGateStructure getGateStructure() 
	{
		return new GateStructureSandwichStack();
	}
	
	@Override
	public String[] getNames() 
	{
		return new String[] {"subway", "sandwiches", "subs"};
	}

	@Override
	public void registerBlocks(StructureBlockRegistry registry) 
	{
		registry.setBlockState("surface", SbahjBlocks.exampleBlock.getDefaultState());
		registry.setBlockState("upper", Blocks.DIRT.getDefaultState());
		registry.setBlockState("structure_primary", Blocks.COBBLESTONE.getDefaultState());
		registry.setBlockState("structure_primary_decorative", Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE_SMOOTH));
		registry.setBlockState("structure_primary_stairs", Blocks.STONE_BRICK_STAIRS.getDefaultState());
		registry.setBlockState("structure_secondary", MinestuckBlocks.treatedPlanks.getDefaultState());
		registry.setBlockState("structure_secondary_decorative", Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CRACKED));
		registry.setBlockState("structure_secondary_stairs", Blocks.STONE_STAIRS.getDefaultState());
		registry.setBlockState("village_path", Blocks.GRASS_PATH.getDefaultState());
		registry.setBlockState("bush", Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.FERN));
		registry.setBlockState("structure_wool_1", Blocks.WOOL.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.BROWN));
		registry.setBlockState("structure_wool_2", Blocks.WOOL.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.RED));
		registry.setBlockState("structure_wool_3", Blocks.WOOL.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.GREEN));
	}
	
	@Override
	public ILandTerrainGen createTerrainGenerator(ChunkProviderLands chunkProvider, Random rand)
	{
		DefaultTerrainGen terrainGen = new DefaultTerrainGen(chunkProvider, rand);
		terrainGen.normalVariation -= 0.2F;
		terrainGen.roughVariation += 2.0F;
		terrainGen.oceanVariation += 0.3F;
		return terrainGen;
	}
	
	@Override
	public List<ILandDecorator> getDecorators() 
	{
		ArrayList<ILandDecorator> list = new ArrayList<>();
		list.add(new AirBlockDecorator(SbahjBlocks.bigSandwhich, 1, BiomeMinestuck.mediumNormal, BiomeMinestuck.mediumOcean));
		list.add(new AirBlockDecorator(SbahjBlocks.bigSandwhich, 2, BiomeMinestuck.mediumRough));
		list.add(new SandwichStackDecorator(BiomeMinestuck.mediumNormal, BiomeMinestuck.mediumRough));
		list.add(new SubwayDecorator(BiomeMinestuck.mediumNormal));
		return list;
	}

	@Override
	public Vec3d getFogColor() 
	{
		return fogColor;
	}
	
	@Override
	public Vec3d getSkyColor() 
	{
		return skyColor;
	}

	@Override
	public EnumConsort getConsortType() 
	{
		return EnumConsort.NAKAGATOR;
	}
}
