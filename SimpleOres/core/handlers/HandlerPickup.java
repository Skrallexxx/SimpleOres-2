package SimpleOres.core.handlers;
import SimpleOres.core.Achievements;
import SimpleOres.core.Blocks;
import SimpleOres.core.Items;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPickupNotifier;

public class HandlerPickup implements IPickupNotifier
{
	/**
	 * Linking to the classes for easier reference.
	 */
	public static Achievements achievements;
	public static Blocks blocks;
	public static Items items;
	
	public void notifyPickup(EntityItem entityitem, EntityPlayer player) 
	{
		if(entityitem.getEntityItem().itemID == blocks.copperOre.blockID) 
		{ 
			player.addStat(achievements.simpleOresAch, 1); 
		}  	
		if(entityitem.getEntityItem().itemID == items.onyxGem.itemID) 
		{ 
			player.addStat(achievements.onyxAch, 1); 
		}
		else if(entityitem.getEntityItem().itemID == blocks.adamantiumOre.blockID) 
		{ 
			player.addStat(achievements.adamantiumAch, 1); 
		}
	}
}
