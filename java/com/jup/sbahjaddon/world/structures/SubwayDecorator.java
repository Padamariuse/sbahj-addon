package com.jup.sbahjaddon.world.structures;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Random;

import com.jup.sbahjaddon.blocks.SbahjBlocks;
import com.mraof.minestuck.entity.consort.*;
import com.mraof.minestuck.entity.consort.EnumConsort.MerchantType;
import com.mraof.minestuck.world.MinestuckDimensionHandler;
import com.mraof.minestuck.world.lands.decorator.structure.SimpleStructureDecorator;
import com.mraof.minestuck.world.lands.gen.ChunkProviderLands;
import com.mraof.minestuck.world.lands.structure.blocks.StructureBlockUtil;
import com.mraof.minestuck.world.storage.loot.MinestuckLoot;

import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;

public class SubwayDecorator extends SimpleStructureDecorator {

	public SubwayDecorator(Biome... biomes)
    {
        super(biomes);
    }
	
	@Override
	public float getPriority() {
		return 0.2F;
	}
	
	protected static Rotation getRotation(EnumFacing facing)
    {
        switch(facing)
        {
            case NORTH: return Rotation.CLOCKWISE_180;
            case WEST: return Rotation.CLOCKWISE_90;
            case EAST: return Rotation.COUNTERCLOCKWISE_90;
            default: return Rotation.NONE;
        }
    }
	
	@Override
	protected BlockPos generateStructure(World world, Random random, BlockPos pos, ChunkProviderLands provider) {
		int rotation = random.nextInt(3);
		int hasChest = random.nextInt(7);
        final Template template;
        
        if(hasChest == 1)
        {
        	template = world.getSaveHandler().getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("sbahjaddon:subway_chest"));
        }
        else
        {
        	template = world.getSaveHandler().getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("sbahjaddon:subway"));
        }
        
        final PlacementSettings settings = new PlacementSettings().setRotation(getRotation(EnumFacing.getHorizontal(rotation)));
    
        Random ran = new Random();
        pos = world.getHeight(pos);
        pos = pos.down(1);
        
        Map<BlockPos, String> datablocks = template.getDataBlocks(pos, settings);
        
        for (Map.Entry<BlockPos, String> entry : datablocks.entrySet())
        {
            BlockPos blockpos = entry.getKey();
            if ("shopkeeper".equals(entry.getValue()))
            {
                world.setBlockToAir(blockpos);
                
                Class<? extends EntityConsort> c = MinestuckDimensionHandler.getAspects(world.provider.getDimension()).aspectTerrain.getConsortType().getConsortClass();
                
				try 
				{
					EntityConsort consort = c.getConstructor(World.class).newInstance(world);
					
	                consort.setPositionAndRotation(blockpos.getX(), blockpos.getY(), blockpos.getZ(), random.nextFloat()*360F, 0);
	                
	                consort.onInitialSpawn(null, null);
	                consort.setHomePosAndDistance(blockpos, 1);
	                consort.merchantType=EnumConsort.MerchantType.FOOD;
	                
	                consort.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(consort)), null);
	                
	                world.spawnEntity(consort);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
            }
            
            if ("chest".equals(entry.getValue()))
            {
                world.setBlockToAir(blockpos);
                StructureBlockUtil.placeLootChest(blockpos, world, null, EnumFacing.getHorizontal(rotation).getOpposite(), MinestuckLoot.BASIC_MEDIUM_CHEST, random);
            }
        }
        
        template.addBlocksToWorld(world, pos, settings);
		
        return pos;
	}

	@Override
	public int getCount(Random random) {
		return random.nextFloat() < 0.15F ? 1 : 0;
	}

}
