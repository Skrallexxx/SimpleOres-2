package alexndr.SimpleOres.plugins.netherrocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import alexndr.SimpleOres.api.helpers.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHelper 
{
	/**
	 * Detects whether the player is wearing a full set of Fyrite Armor, then if they are on fire will cancel the "damage" event, making the player fireproof.
	 */
	@SubscribeEvent
	public void onBurnDamage(LivingAttackEvent event)
	{   	
		if(event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entity;
			
			ItemStack helmet = player.getCurrentArmor(3);
			ItemStack chest = player.getCurrentArmor(2);
			ItemStack legs = player.getCurrentArmor(1);
			ItemStack boots = player.getCurrentArmor(0);
			
	        if(helmet != null && chest != null && legs != null && boots != null)
	        {
	        	if(helmet.getItem() == Content.fyrite_helmet && chest.getItem() == Content.fyrite_chestplate && legs.getItem() == Content.fyrite_leggings && boots.getItem() == Content.fyrite_boots)
	        	{
	    	    	if(event.source.equals(DamageSource.lava) || event.source.equals(DamageSource.inFire) || event.source.equals(DamageSource.onFire))
	    	    	{
	    	        	event.setCanceled(true);
	    	        	player.extinguish();
	    	        	if(event.isCanceled())
	    	        	{
		    	        	LogHelper.verboseInfo("Netherrocks Plugin: Fire/Lava damage cancelled by wearing a full set of Fyrite Armor");
	    	        	}
	    	    	}
	        	}
	        }
		}
	}
	
	/**
	 * Detects whether the player is wearing a full set of Illumenite Armor, then if they take fall damage it will cancel the "damage" even, meaning the player doesn't take any fall damage.
	 */
	@SubscribeEvent
	public void onFallDamage(LivingAttackEvent event)
	{  	
		if(event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entity;
			
			ItemStack helmet = player.getCurrentArmor(3);
			ItemStack chest = player.getCurrentArmor(2);
			ItemStack legs = player.getCurrentArmor(1);
			ItemStack boots = player.getCurrentArmor(0);
			
	        
	        if(helmet != null && chest != null && legs != null && boots != null)
	        {
	        	if(helmet.getItem() == Content.illumenite_helmet && chest.getItem() == Content.illumenite_chestplate && legs.getItem() == Content.illumenite_leggings && boots.getItem() == Content.illumenite_boots)
	        	{
	    	    	if(event.source.equals(DamageSource.fall) && Settings.enableArmorEffects)
	    	    	{
	    	        	event.setCanceled(true);
	    	        	if(event.isCanceled())
	    	        	{
		    	        	LogHelper.verboseInfo("Netherrocks Plugin: Fall damage cancelled by wearing a full set of Illumenite Armor");
	    	        	}
	    	    	}
	        	}
	        }
	        
			if(helmet != null && chest != null && legs != null && boots != null)
			{
				if(helmet.getItem() == Content.malachite_helmet && chest.getItem() == Content.malachite_chestplate && legs.getItem() == Content.malachite_leggings && boots.getItem() == Content.malachite_boots)
				{	
					if(event.source.equals(DamageSource.fall) && Settings.enableArmorEffects)
					{
						if(player.fallDistance < Settings.malachiteArmorMinFallHeight)
						{
							event.setCanceled(true);
		    	        	LogHelper.verboseInfo("Netherrocks Plugin: Fall damage reduced by wearing a full set of Malachite Armor");
						}
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onPlayerJump(LivingJumpEvent event)
	{
		if(event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entity;
			
			ItemStack helmet = player.getCurrentArmor(3);
			ItemStack chest = player.getCurrentArmor(2);
			ItemStack legs = player.getCurrentArmor(1);
			ItemStack boots = player.getCurrentArmor(0);
			
			if(helmet != null && chest != null && legs != null && boots != null)
			{
				if(helmet.getItem() == Content.malachite_helmet && chest.getItem() == Content.malachite_chestplate && legs.getItem() == Content.malachite_leggings && boots.getItem() == Content.malachite_boots)
				{	
					if(!player.isSneaking() && Settings.enableArmorEffects)
					{
						player.motionY += Settings.malachiteArmorJumpBoostAmount;
	    	        	LogHelper.verboseInfo("Netherrocks Plugin: Player jump height modified by wearing a full set of Malachite Armor");
					}
				}
			}
		}
	}
	
}
