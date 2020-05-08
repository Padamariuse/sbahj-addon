package com.jup.sbahjaddon.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemPantshitter extends ItemModFood
{
	public static DamageSource SHIT_PANTS = new DamageSource("sbahj-shitPants");
	
	public ItemPantshitter(int amount, float saturation) 
	{
		super(amount, saturation, false);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) 
	{
		player.attackEntityFrom(SHIT_PANTS, 4.0F);
		super.onFoodEaten(stack, worldIn, player);
	}

}
