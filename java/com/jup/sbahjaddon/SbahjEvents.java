package com.jup.sbahjaddon;

import java.util.Iterator;
import java.util.Random;

import com.jup.sbahjaddon.captchalogue.SweetBrosModus;
import com.jup.sbahjaddon.items.SbahjItems;
import com.mraof.minestuck.MinestuckConfig;
import com.mraof.minestuck.event.ServerEventHandler;
import com.mraof.minestuck.inventory.captchalouge.HashmapModus;
import com.mraof.minestuck.inventory.captchalouge.Modus;
import com.mraof.minestuck.network.skaianet.SkaianetHandler;
import com.mraof.minestuck.util.MinestuckPlayerData;
import com.mraof.minestuck.util.PostEntryTask;

import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.world.BlockEvent;

public class SbahjEvents 
{
	public static final SbahjEvents instance = new SbahjEvents();
	
	private boolean danceActivated;
	
	@SubscribeEvent
    public void squirrelNut(BlockEvent.BreakEvent event) {
        if(!event.getWorld().isRemote && !event.getPlayer().isCreative() && (event.getState().getBlock() == Blocks.DIRT || event.getState().getBlock() == Blocks.GRASS)) 
        {
            Random ran = new Random();
            int num = ran.nextInt(100);
            if(num <= 5) {
                ItemStack nutitem = new ItemStack(SbahjItems.nut);
                EntityItem nut = new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), nutitem);
                event.getWorld().spawnEntity(nut);
                ITextComponent message = new TextComponentTranslation("event.nut");
                message.getStyle().setColor(TextFormatting.AQUA);
                event.getPlayer().sendMessage(message);
            }
        }
	}
	
	@SubscribeEvent
	public void sweetBroModusActivate(PlayerTickEvent event)
	{
		if(event.player.isSneaking() && danceActivated != true)
		{
			Modus modus = MinestuckPlayerData.getData(event.player).modus;
			if(modus instanceof SweetBrosModus)
			{
				((SweetBrosModus) modus).danceActivate();
				danceActivated = true;
			}
		} else if(!event.player.isSneaking())
		{
			danceActivated = false;
		}
	}
	
	@SubscribeEvent
	public void lootLoad(LootTableLoadEvent evt) 
	{
	    if (evt.getName().toString().equals("minestuck:chests/medium_basic")) 
	    {
	    	addSbahjPool("sbahjaddon:chests/sbahj_medium_basic", evt);
	    } else if (evt.getName().toString().equals("minestuck:gameplay/consort_food"))
	    {
	    	addSbahjPool("sbahjaddon:gameplay/sbahj_consort_food", evt);
	    }
	}
	
	public void addSbahjPool(String resourceLocation, LootTableLoadEvent evt)
	{
		LootEntry entry = new LootEntryTable(new ResourceLocation(resourceLocation), 1, 1, new LootCondition[0], "sbahj_loot_entry"); 
    	LootPool pool = new LootPool(new LootEntry[] { entry }, new LootCondition[0], new RandomValueRange(1), new RandomValueRange(0, 1), "sbahj_loot_pool");

    	evt.getTable().addPool(pool);
	}
}
