package com.jup.sbahjaddon.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemModFood extends ItemFood
{
	public ItemModFood(int amount, boolean isWolfFood) 
	{
		super(amount, isWolfFood);
	}
	
	public ItemModFood(int amount, float saturation, boolean isWolfFood) 
	{
		super(amount, saturation, isWolfFood);
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
