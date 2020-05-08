package com.jup.sbahjaddon.items;

import com.mraof.minestuck.entity.item.*;
import com.mraof.minestuck.item.ItemHanging;
import com.mraof.minestuck.item.MinestuckItems;
import com.mraof.minestuck.item.TabMinestuck;
import com.mraof.minestuck.item.weapon.ItemWeapon;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityHanging;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import static com.jup.sbahjaddon.blocks.SbahjBlocks.*;

import com.jup.sbahjaddon.entity.item.EntityConksuckBoot;
import com.jup.sbahjaddon.items.weapons.ItemUnrealSword;

public class SbahjItems 
{
	
	public static CreativeTabs tabSbahj = TabSbahj.instance;
	
	public static Item nut = new ItemModFood(1, 0.1F, false).setRegistryName("nut").setUnlocalizedName("nut").setCreativeTab(SbahjItems.tabSbahj);
	public static Item sandwhich = new ItemModFood(4, 0.0F, false).setRegistryName("sandwhich").setUnlocalizedName("sandwhich").setCreativeTab(SbahjItems.tabSbahj);
	public static Item pantshitterDeluxe = new ItemPantshitter(6, 0.0F).setRegistryName("pantshitter_deluxe").setUnlocalizedName("pantshitterDeluxe").setCreativeTab(SbahjItems.tabSbahj);
	public static Item turkeyHole = new ItemModFood(-5, 0.0F, true).setRegistryName("turkey_hole").setUnlocalizedName("turkeyHole").setCreativeTab(SbahjItems.tabSbahj);
	public static Item chunkyCheese = new ItemChunkyCheese(2, 0.3F, false).setRegistryName("chunky_cheese").setUnlocalizedName("chunkyCheese").setCreativeTab(SbahjItems.tabSbahj);
	public static Item goldenSandwhich = new ItemGoldenSandwhich(2, 0.3F, 150, false).setRegistryName("golden_sandwhich").setUnlocalizedName("goldenSandwhich").setCreativeTab(SbahjItems.tabSbahj).setMaxStackSize(1);
	public static Item hotGod = new ItemModFood(3, 0.0F, true).setRegistryName("hot_god").setUnlocalizedName("hotGod").setCreativeTab(SbahjItems.tabSbahj);
	public static Item jelly = new ItemJelly().setRegistryName("jelly").setUnlocalizedName("jelly").setCreativeTab(SbahjItems.tabSbahj).setMaxStackSize(1);
	public static Item jellyHotGod = new ItemModFood(10, 0.5F, true).setRegistryName("jelly_hot_god").setUnlocalizedName("jellyHotGod").setCreativeTab(SbahjItems.tabSbahj);
	public static Item unrealAir = new ItemUnrealAir().setRegistryName("unreal_air").setUnlocalizedName("unrealAir").setCreativeTab(SbahjItems.tabSbahj);
	public static Item weirdStonk = new ItemSbahj().setRegistryName("weird_stonk").setUnlocalizedName("weirdStonk").setCreativeTab(SbahjItems.tabSbahj);
	public static Item sweetBrosModus = new Item().setRegistryName("sweet_bros_modus").setUnlocalizedName("sweetBrosModus").setCreativeTab(SbahjItems.tabSbahj).setMaxStackSize(1);
	public static Item videoGame = new ItemVideoGame().setRegistryName("video_game").setUnlocalizedName("videoGame").setCreativeTab(SbahjItems.tabSbahj).setMaxStackSize(1);

	public static Item theSpoon = new ItemWeapon(384, 1.5D, -2.2D, 5, "theSpoon").setRegistryName("the_spoon").setCreativeTab(SbahjItems.tabSbahj);
	public static Item unrealSord = new ItemUnrealSword(59, 2, -2.4D, 5, "unrealSord").setRegistryName("unreal_sord");
	
	public static Item conksuckBoot = new ItemHanging()
	{
		@Override
		public EntityHanging createEntity(World worldIn, BlockPos pos, EnumFacing facing, ItemStack stack, int meta)
		{
			return new EntityConksuckBoot(worldIn, pos, facing);
		}
	}.setRegistryName("conksuck_boot").setUnlocalizedName("conksuckBoot").setCreativeTab(SbahjItems.tabSbahj);
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		IForgeRegistry<Item> registry = event.getRegistry();
		
		//ItemBlocks
		registerItemBlock(registry, new ItemBlock(exampleBlock));
		registerItemBlock(registry, new ItemBlock(bigSandwhich));
		registerItemBlock(registry, new ItemBlock(subwayBread));
		registerItemBlock(registry, new ItemBlock(turkey));
		registerItemBlock(registry, new ItemBlock(tomato));
		registerItemBlock(registry, new ItemBlock(cheese));
		registerItemBlock(registry, new ItemBlock(subwayVent));
		registerItemBlock(registry, new ItemBlock(cugarCube));
		
		//Items
		registry.register(nut);
		registry.register(sandwhich);
		registry.register(pantshitterDeluxe);
		registry.register(turkeyHole);
		registry.register(chunkyCheese);
		registry.register(goldenSandwhich);
		registry.register(hotGod);
		registry.register(jelly);
		registry.register(jellyHotGod);
		registry.register(unrealAir);
		registry.register(weirdStonk);
		registry.register(sweetBrosModus);
		registry.register(conksuckBoot);
		registry.register(videoGame);

		registry.register(theSpoon);
		registry.register(unrealSord);
	}
	
	private static Item registerItemBlock(IForgeRegistry<Item> registry, ItemBlock item)
	{
		registry.register(item.setRegistryName(item.getBlock().getRegistryName()));
		return item;
	}

}
