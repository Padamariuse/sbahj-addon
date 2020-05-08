package com.jup.sbahjaddon.blocks;

import com.jup.sbahjaddon.items.SbahjItems;
import com.mraof.minestuck.item.MinestuckItems;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class SbahjBlocks {
	
	public static Block exampleBlock = new BlockSbahj(Material.CLAY).setRegistryName("example_block").setUnlocalizedName("exampleBlock").setCreativeTab(SbahjItems.tabSbahj);
	public static Block bigSandwhich = new BlockBigSandwhich().setRegistryName("big_sandwhich").setUnlocalizedName("bigSandwhich").setCreativeTab(SbahjItems.tabSbahj);
	public static Block subwayBread = new BlockSbahj(Material.CLOTH).setHardness(0.8F).setRegistryName("subway_bread").setUnlocalizedName("subwayBread").setCreativeTab(SbahjItems.tabSbahj);
	public static Block cheese = new BlockFood(Material.CLAY, SoundType.SLIME, SbahjItems.chunkyCheese, 3, 4).setRegistryName("cheese").setUnlocalizedName("cheese");
	public static Block turkey = new BlockFood(Material.SPONGE, SoundType.SLIME, SbahjItems.turkeyHole, 3, 4).setRegistryName("turkey").setUnlocalizedName("turkey");
	public static Block tomato = new BlockSbahj(Material.SPONGE).setHardness(0.4F).setRegistryName("tomato").setUnlocalizedName("tomato").setCreativeTab(SbahjItems.tabSbahj);
	public static Block subwayVent = new BlockSubwayVent(Material.IRON).setRegistryName("subway_vent").setUnlocalizedName("subwayVent");
	public static Block cugarCube = new BlockSbahj(Material.SAND).setHardness(0.4F).setRegistryName("cugar_cube").setUnlocalizedName("cugarCube");
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		IForgeRegistry<Block> registry = event.getRegistry();
		//blocks
		registry.register(exampleBlock);
		registry.register(bigSandwhich);
		registry.register(subwayBread);
		registry.register(cheese);
		registry.register(turkey);
		registry.register(tomato);
		registry.register(subwayVent);
		registry.register(cugarCube);
	}

}
