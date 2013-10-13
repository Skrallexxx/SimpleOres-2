package SimpleOres.plugins.Netherrocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class HandlerEvent 
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
			
		    if(event.entity instanceof EntityPlayer)
		    {
		        EntityPlayer eventPlayer = (EntityPlayer)event.entity;
		        
		        if(helmet != null && chest != null && legs != null && boots != null)
		        {
		        	if(helmet.getItem() == Armor.fyriteHelm && chest.getItem() == Armor.fyriteChest && legs.getItem() == Armor.fyriteLegs && boots.getItem() == Armor.fyriteBoots)
		        	{
		    	    	if(event.source.equals(DamageSource.lava) || event.source.equals(DamageSource.inFire) || event.source.equals(DamageSource.onFire))
		    	    	{
		    	        	event.setCanceled(true);
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
			
		    if(event.entity instanceof EntityPlayer)
		    {
		        EntityPlayer eventPlayer = (EntityPlayer)event.entity;
		        
		        if(helmet != null && chest != null && legs != null && boots != null)
		        {
		        	if(helmet.getItem() == Armor.illumeniteHelm && chest.getItem() == Armor.illumeniteChest && legs.getItem() == Armor.illumeniteLegs && boots.getItem() == Armor.illumeniteBoots)
		        	{
		    	    	if(event.source.equals(DamageSource.fall))
		    	    	{
		    	        	event.setCanceled(true);
		    	    	}
		        	}
		        }
		    }
		}
	}
}
