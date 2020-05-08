package com.jup.sbahjaddon.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemVideoGame extends ItemSbahj
{
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		ItemStack mainhand = playerIn.getHeldItemMainhand();
		ItemStack offhand = playerIn.getHeldItemOffhand();
		if((mainhand.getItem() == SbahjItems.videoGame && offhand.getItem() == SbahjItems.videoGame))
		{
			int count = getCount(mainhand) + getCount(offhand);
			if(worldIn.isRemote)
			{
				ItemStack stack = new ItemStack(SbahjItems.videoGame);
				setCount(stack, count);
				
				playerIn.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH, 1.8F, 1.0F);
				playerIn.inventory.removeStackFromSlot(playerIn.inventory.getSlotFor(playerIn.getHeldItemMainhand()));
				playerIn.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, stack);
			}
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
	{
		if(isInCreativeTab(tab))
		{
			items.add(setCount(new ItemStack(this), 1));
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		tooltip.add(I18n.translateToLocalFormatted("item.videoGame.amount", getCount(stack)));
	}
	
	public static ItemStack setCount(ItemStack stack, int value)
	{
		NBTTagCompound nbt = stack.getTagCompound();
		if(nbt == null)
		{
			nbt = new NBTTagCompound();
			stack.setTagCompound(nbt);
		}
		nbt.setInteger("value", value);
		return stack;
	}
	
	public static int getCount(ItemStack stack)
	{
		if(!stack.hasTagCompound() || !stack.getTagCompound().hasKey("value", 99))
			return 1;
		else return stack.getTagCompound().getInteger("value");
	}
	
}
