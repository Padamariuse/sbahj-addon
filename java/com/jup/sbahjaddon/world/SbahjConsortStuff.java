package com.jup.sbahjaddon.world;

import static com.mraof.minestuck.item.MinestuckItems.onion;
import static com.mraof.minestuck.world.lands.LandAspectRegistry.fromNameTerrain;
import static com.mraof.minestuck.world.lands.LandAspectRegistry.fromNameTitle;
import static com.mraof.minestuck.world.storage.loot.MinestuckLoot.CONSORT_FOOD_STOCK;

import com.jup.sbahjaddon.blocks.SbahjBlocks;
import com.jup.sbahjaddon.items.SbahjItems;
import com.mraof.minestuck.entity.consort.ConsortDialogue;
import com.mraof.minestuck.entity.consort.ConsortRewardHandler;
import com.mraof.minestuck.entity.consort.MessageType;
import com.mraof.minestuck.entity.consort.EnumConsort.MerchantType;
import com.mraof.minestuck.entity.consort.MessageType.ChainMessage;
import com.mraof.minestuck.entity.consort.MessageType.ChoiceMessage;
import com.mraof.minestuck.entity.consort.MessageType.DelayMessage;
import com.mraof.minestuck.entity.consort.MessageType.DescriptionMessage;
import com.mraof.minestuck.entity.consort.MessageType.MerchantGuiMessage;
import com.mraof.minestuck.entity.consort.MessageType.PurchaseMessage;
import com.mraof.minestuck.entity.consort.MessageType.SingleMessage;

import net.minecraft.item.ItemStack;

public class SbahjConsortStuff 
{
	public static void consortStuff()
	{
		//Consort Dialogue
		ConsortDialogue.addMessage("sbahjSpreading");
			//Subway Land
		ConsortDialogue.addMessage(new ChainMessage(new SingleMessage("refreshingTaste.1"), new DescriptionMessage("refreshingTaste.2"))).landTerrain(fromNameTerrain("subway"));
		ConsortDialogue.addMessage(new ChainMessage(new SingleMessage("abundantAccess.1"), new SingleMessage("abundantAccess.2"))).landTerrain(fromNameTerrain("subway"));
		ConsortDialogue.addMessage(new SingleMessage("buyFromSubway")).landTerrain(fromNameTerrain("subway"));
		ConsortDialogue.addMessage(new ChoiceMessage(new ChainMessage(new DescriptionMessage("subwayAd")),
				new SingleMessage[]
						{
								new SingleMessage("subwayAd.buy"),
								new SingleMessage("subwayAd.deny")
						},
				new MessageType[] {
						new PurchaseMessage(false, LootTableRegistry.CONSORT_SUBWAY, 375, "purchase",
								new ChainMessage(1,
										new DescriptionMessage("subwayAd.item"),
										new SingleMessage("subwayAd.purchase")
								)
						),
						new SingleMessage("subwayAd.noPurchase")
				}
		)).landTerrain(fromNameTerrain("subway"));
		
		ConsortDialogue.addMessage(new MerchantGuiMessage(new SingleMessage("subwayFoodShop", "landName"), CONSORT_FOOD_STOCK)).type(MerchantType.FOOD).landTerrain(fromNameTerrain("subway"));
		
		//Shop Pricing
		ConsortRewardHandler.registerPrice(new ItemStack(SbahjItems.sandwhich), 20, 40);
		ConsortRewardHandler.registerPrice(new ItemStack(SbahjBlocks.bigSandwhich), 100, 350);
	}
}
