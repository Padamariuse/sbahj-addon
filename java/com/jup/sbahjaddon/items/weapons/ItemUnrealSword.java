package com.jup.sbahjaddon.items.weapons;

import java.util.Random;

import com.mraof.minestuck.item.weapon.ItemWeapon;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class ItemUnrealSword extends ItemWeapon
{

	public ItemUnrealSword(ToolMaterial material, int maxUses, double damageVsEntity, double weaponSpeed, int enchantability, String name) 
	{
		super(material, maxUses, damageVsEntity, weaponSpeed, enchantability, name);
	}
	
	public ItemUnrealSword(int maxUses, double damageVsEntity, double weaponSpeed, int enchantability, String name) 
	{
		super(maxUses, damageVsEntity, weaponSpeed, enchantability, name);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase player) 
	{
		Random ran = new Random();
        int num = ran.nextInt(100);
        if(num <= 90)
        {
        	tossEntity(target);
        } else
        {
        	tossEntity(player);
        }
		return super.hitEntity(stack, target, player);
	}
	
	public void tossEntity(EntityLivingBase target)
	{
		if(target.world.isRemote)
		{
			Random ran = new Random();
	        int num = ran.nextInt(5) + 4;
			target.addVelocity(0, num, 0);
		}
	}
}
