package com.jup.sbahjaddon.items;

import com.jup.sbahjaddon.entity.item.EntityUnrealAir;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemUnrealAir extends ItemSbahj
{
	private int level;
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) 
	{
		EntityPlayer player = ((EntityPlayer) entityIn);
		if(!player.world.isRemote)
		{	
			player.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 1, 3));
		}
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
	@Override
	public boolean onEntityItemUpdate(EntityItem entityItem) 
	{
		entityItem.addVelocity(0.0D, 0.045D, 0.0D);
		return super.onEntityItemUpdate(entityItem);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (!playerIn.capabilities.isCreativeMode)
        {
            itemstack.shrink(1);
        }
        
        if (worldIn.isRemote)
        {
            EntityUnrealAir unrealAir = new EntityUnrealAir(worldIn);
            worldIn.spawnEntity(unrealAir);
        }
        
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
