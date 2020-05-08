package com.jup.sbahjaddon;

import com.mraof.minestuck.alchemy.*;
import com.mraof.minestuck.alchemy.CombinationRegistry.*;
import com.mraof.minestuck.block.MinestuckBlocks;
import com.mraof.minestuck.item.MinestuckItems;

import static com.mraof.minestuck.item.MinestuckItems.clawHammer;
import static com.mraof.minestuck.item.MinestuckItems.katana;
import static com.mraof.minestuck.item.MinestuckItems.regisword;
import static com.mraof.minestuck.item.MinestuckItems.sbahjPoster;
import static com.mraof.minestuck.item.MinestuckItems.sledgeHammer;
import static com.mraof.minestuck.item.MinestuckItems.sord;
import static com.mraof.minestuck.alchemy.CombinationRegistry.Mode.*;

import com.jup.sbahjaddon.blocks.SbahjBlocks;
import com.jup.sbahjaddon.items.SbahjItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SbahjAlchemyRecipes {

	public static void registerMinestuckRecipes() 
	{
		GristRegistry.addGristConversion(new ItemStack(SbahjBlocks.exampleBlock), new GristSet(GristType.Build, 1));
		GristRegistry.addGristConversion(new ItemStack(SbahjBlocks.bigSandwhich), new GristSet(new GristType[] {GristType.Build, GristType.Amber, GristType.Iodine}, new int[] {22, 15, 8}));
		GristRegistry.addGristConversion(new ItemStack(SbahjBlocks.cugarCube), new GristSet(new GristType[] {GristType.Artifact, GristType.Chalk}, new int [] {-8, 4}));
		
		GristRegistry.addGristConversion(new ItemStack(SbahjItems.jelly), new GristSet(GristType.Amber, 3));
		GristRegistry.addGristConversion(new ItemStack(SbahjItems.sandwhich), new GristSet(new GristType[] {GristType.Artifact, GristType.Build}, new int [] {-120, 140}));
		GristRegistry.addGristConversion(new ItemStack(SbahjItems.pantshitterDeluxe), new GristSet(new GristType[] {GristType.Artifact, GristType.Build, GristType.Cobalt}, new int [] {120, 70, 40}));
		GristRegistry.addGristConversion(new ItemStack(SbahjItems.goldenSandwhich), new GristSet(new GristType[] {GristType.Artifact, GristType.Build}, new int [] {-120, 140}));
		GristRegistry.addGristConversion(new ItemStack(SbahjItems.turkeyHole), new GristSet(new GristType[] {GristType.Artifact, GristType.Iodine}, new int [] {-12, 1}));
		GristRegistry.addGristConversion(new ItemStack(SbahjItems.chunkyCheese), new GristSet(new GristType[] {GristType.Artifact, GristType.Chalk, GristType.Iodine}, new int [] {-2, 2, 2}));
		GristRegistry.addGristConversion(new ItemStack(SbahjItems.nut), new GristSet(GristType.Amber, 2));
		GristRegistry.addGristConversion(new ItemStack(SbahjItems.hotGod), new GristSet(GristType.Iodine, 7));
		GristRegistry.addGristConversion(new ItemStack(SbahjItems.jellyHotGod), new GristSet(new GristType[] {GristType.Artifact, GristType.Amber, GristType.Iodine}, new int [] {-120, 4, 12}));
		
		GristRegistry.addGristConversion(new ItemStack(SbahjItems.unrealAir), new GristSet(GristType.Build, 0));
		GristRegistry.addGristConversion(new ItemStack(SbahjItems.sweetBrosModus), new GristSet(new GristType[] {GristType.Artifact, GristType.Build}, new int [] {-120, 140}));
		GristRegistry.addGristConversion(new ItemStack(SbahjItems.theSpoon), new GristSet(new GristType[] {GristType.Build, GristType.Rust, GristType.Artifact}, new int [] {12, 8, -25}));
		GristRegistry.addGristConversion(new ItemStack(SbahjItems.conksuckBoot), new GristSet(new GristType[] {GristType.Artifact}, new int [] {-100}));

		CombinationRegistry.addCombination(new ItemStack(SbahjItems.sandwhich), new ItemStack(Items.PRISMARINE_SHARD), MODE_AND, false, false, new ItemStack(SbahjItems.pantshitterDeluxe));
		CombinationRegistry.addCombination(new ItemStack(Items.MINECART), new ItemStack(MinestuckItems.sbahjPoster), MODE_AND, false, false, new ItemStack(SbahjItems.unrealAir));
		CombinationRegistry.addCombination(new ItemStack(Items.MINECART), new ItemStack(SbahjItems.weirdStonk), MODE_AND, false, false, new ItemStack(SbahjItems.unrealAir));
		CombinationRegistry.addCombination(new ItemStack(MinestuckItems.modusCard, 1, 0), new ItemStack(MinestuckItems.sbahjPoster), MODE_AND, false, false, new ItemStack(SbahjItems.sweetBrosModus));
		CombinationRegistry.addCombination(new ItemStack(MinestuckItems.modusCard, 1, 1), new ItemStack(MinestuckItems.sbahjPoster), MODE_AND, false, false, new ItemStack(SbahjItems.sweetBrosModus));
	}
	
	public static void registerVanillaRecipes() 
	{
	
		
	}
	public static void registerModRecipes() 
	{
		
	}
}
