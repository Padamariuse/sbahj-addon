package com.jup.sbahjaddon.entity.item;

import com.jup.sbahjaddon.items.SbahjItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class EntityUnrealAir extends Entity
{
	public EntityUnrealAir(World worldIn) 
	{
		super(worldIn);
	}
	
	@Override
    public double getMountedYOffset()
    {
        return 0.0;
    }
	
	@Override
	protected void entityInit() 
	{
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) 
	{
		
	}
	
	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) 
	{
		
	}
	
	@Override
	protected boolean canBeRidden(Entity entityIn) 
	{
		return true;
	}
}
