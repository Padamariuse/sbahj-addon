package com.jup.sbahjaddon.items;

import java.util.List;

import javax.annotation.Nullable;

import com.mraof.minestuck.util.Echeladder;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemGoldenSandwhich extends ItemFood
{
	private final int expamount;
	public ItemGoldenSandwhich(int amount, int expamount, boolean isWolfFood) 
	{
		super(amount, isWolfFood);
		this.expamount = expamount;
		this.setCreativeTab(SbahjItems.tabSbahj);
	}
	
	public ItemGoldenSandwhich(int amount, float saturation, int expamount, boolean isWolfFood) 
	{
		super(amount, saturation, isWolfFood);
		this.expamount = expamount;
	}
	
	@Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        String key = getUnlocalizedName()+".tooltip";
        if(!I18n.translateToLocal(key).equals(key))
            tooltip.add(I18n.translateToLocal(key));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) 
	{
		Echeladder.increaseProgress((EntityPlayerMP) player, expamount);
		super.onFoodEaten(stack, worldIn, player);
	}
}
