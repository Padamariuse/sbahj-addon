package com.jup.sbahjaddon.items;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemChunkyCheese extends ItemFood
{
	public ItemChunkyCheese(int amount, float saturation, boolean isWolfFood) 
	{
		super(amount, saturation, isWolfFood);
	}
	
	public ItemChunkyCheese(int amount, boolean isWolfFood) 
	{
		super(amount, isWolfFood);
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
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) 
	{
		Random ran = new Random();
		if(ran.nextInt(4) == 1)
		{
			entityLiving.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 60, 2));
		}
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}
}
