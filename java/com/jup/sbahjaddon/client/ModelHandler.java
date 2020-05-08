package com.jup.sbahjaddon.client;

import com.mraof.minestuck.item.weapon.ItemDualWeapon;
import com.mraof.minestuck.alchemy.*;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import static com.mraof.minestuck.item.MinestuckItems.candy;
import static com.jup.sbahjaddon.blocks.SbahjBlocks.*;
import static com.jup.sbahjaddon.items.SbahjItems.*;

@SideOnly(Side.CLIENT)
public class ModelHandler {

	@SubscribeEvent
	public static void handleModelRegistry(ModelRegistryEvent event)
	{
		itemModels();
		blockModels();
	}
	
	private static void itemModels()
	{
		register(nut);
		register(sandwhich);
		register(pantshitterDeluxe);
		register(turkeyHole);
		register(chunkyCheese);
		register(goldenSandwhich);
		register(hotGod);
		register(jelly);
		register(jellyHotGod);
		register(unrealAir);
		register(weirdStonk);
		register(theSpoon);
		register(sweetBrosModus);
		register(conksuckBoot);
		register(videoGame);
	}
	
	private static void blockModels()
	{
		register(exampleBlock);
		register(bigSandwhich);
		register(subwayBread);
		register(turkey);
		register(tomato);
		register(cheese);
		register(subwayVent);
		register(cugarCube);
	}
	
	private static void register(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Item.REGISTRY.getNameForObject(item), "inventory"));
	}
	
	private static void register(Item item, int meta, String modelResource)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation("sbahjaddon:"+modelResource, "inventory"));
	}
	
	private static void register(Block block)
	{
		register(Item.getItemFromBlock(block));
	}
	
	private static class DualWeaponDefinition implements ItemMeshDefinition
	{
		private Item item;
		public DualWeaponDefinition(Item item){
			this.item=item;
		}
		@Override
		public ModelResourceLocation getModelLocation(ItemStack stack)
		{
			if(((ItemDualWeapon)this.item).IsDrawn(stack)){
				
				return new ModelResourceLocation(item.getRegistryName() + "_drawn","inventory");
			}else
				return new ModelResourceLocation(item.getRegistryName() + "_sheathed","inventory");
			
		}
	}	
	
}

