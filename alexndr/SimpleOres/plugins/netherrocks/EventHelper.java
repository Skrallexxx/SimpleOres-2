package alexndr.SimpleOres.plugins.netherrocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import alexndr.SimpleOres.api.helpers.LogHelper;

public class EventHelper 
{
	/**
	 * Detects whether the player is wearing a full set of Fyrite Armor, then if they are on fire will cancel the "damage" event, making the player fireproof.
	 */
	@ForgeSubscribe
	public void onBurnDamage(LivingAttackEvent event)
	{   	
		if(event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entity;
			
			ItemStack helmet = player.getCurrentItemOrArmor(4);
			ItemStack chest = player.getCurrentItemOrArmor(3);
			ItemStack legs = player.getCurrentItemOrArmor(2);
			ItemStack boots = player.getCurrentItemOrArmor(1);
			
	        if(helmet != null && chest != null && legs != null && boots != null)
	        {
	        	if(helmet.getItem() == Content.fyriteHelm && chest.getItem() == Content.fyriteChest && legs.getItem() == Content.fyriteLegs && boots.getItem() == Content.fyriteBoots)
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
	@ForgeSubscribe
	public void onFallDamage(LivingAttackEvent event)
	{  	
		if(event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entity;
			
			ItemStack helmet = player.getCurrentItemOrArmor(4);
			ItemStack chest = player.getCurrentItemOrArmor(3);
			ItemStack legs = player.getCurrentItemOrArmor(2);
			ItemStack boots = player.getCurrentItemOrArmor(1);
			
	        
	        if(helmet != null && chest != null && legs != null && boots != null)
	        {
	        	if(helmet.getItem() == Content.illumeniteHelm && chest.getItem() == Content.illumeniteChest && legs.getItem() == Content.illumeniteLegs && boots.getItem() == Content.illumeniteBoots)
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
				if(helmet.getItem() == Content.malachiteHelm && chest.getItem() == Content.malachiteChest && legs.getItem() == Content.malachiteLegs && boots.getItem() == Content.malachiteBoots)
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
	
	@ForgeSubscribe
	public void onPlayerJump(LivingJumpEvent event)
	{
		if(event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entity;
			
			ItemStack helmet = player.getCurrentItemOrArmor(4);
			ItemStack chest = player.getCurrentItemOrArmor(3);
			ItemStack legs = player.getCurrentItemOrArmor(2);
			ItemStack boots = player.getCurrentItemOrArmor(1);
			
			if(helmet != null && chest != null && legs != null && boots != null)
			{
				if(helmet.getItem() == Content.malachiteHelm && chest.getItem() == Content.malachiteChest && legs.getItem() == Content.malachiteLegs && boots.getItem() == Content.malachiteBoots)
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
