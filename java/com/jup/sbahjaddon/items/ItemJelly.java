package com.jup.sbahjaddon.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemJelly extends Item
{
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		ItemStack jellyHotGod = new ItemStack(SbahjItems.jellyHotGod);
		ITextComponent message;
		if(playerIn.getHeldItemMainhand().getItem() == SbahjItems.jelly && playerIn.getHeldItemOffhand().getItem() == SbahjItems.hotGod)
		{
			playerIn.playSound(SoundEvents.ENTITY_SLIME_SQUISH, 1.0F, 1.0F);
			playerIn.inventory.removeStackFromSlot(playerIn.inventory.getSlotFor(playerIn.getHeldItemMainhand()));
			playerIn.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, ItemStack.EMPTY);
			if(playerIn.addItemStackToInventory(jellyHotGod))
			{
				playerIn.addItemStackToInventory(jellyHotGod);
			} else
			{
				Entity hotGod = new EntityItem(playerIn.world, playerIn.posX, playerIn.posY, playerIn.posZ, jellyHotGod);
				playerIn.world.spawnEntity(hotGod);
			}
		} else if(playerIn.getHeldItemMainhand().getItem() == SbahjItems.jelly && playerIn.getHeldItemOffhand().getItem() == SbahjItems.theSpoon)
		{
			message = new TextComponentTranslation("item.jelly.yum"); 
					
			playerIn.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1.0F, 1.0F);
			playerIn.getHeldItemOffhand().damageItem(2, playerIn);
			playerIn.inventory.removeStackFromSlot(playerIn.inventory.getSlotFor(playerIn.getHeldItemMainhand()));
			playerIn.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 180));
			if(worldIn.isRemote)
				playerIn.sendMessage(message);
		} else if(playerIn.getHeldItemOffhand().getItem() == SbahjItems.jelly && playerIn.getHeldItemMainhand().getItem() == SbahjItems.hotGod)
		{
			message = new TextComponentTranslation("item.jelly.rightClickWrongHands");
			if(worldIn.isRemote)	
				playerIn.sendMessage(message);
		} else if(playerIn.getHeldItemOffhand().getItem() == SbahjItems.jelly || playerIn.getHeldItemMainhand().getItem() == SbahjItems.jelly)
		{
			message = new TextComponentTranslation("item.jelly.ifOnly");
			if(worldIn.isRemote)
				playerIn.sendMessage(message);
		}
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        String key = getUnlocalizedName()+".tooltip";
        if(!I18n.translateToLocal(key).equals(key))
            tooltip.add(I18n.translateToLocal(key));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
