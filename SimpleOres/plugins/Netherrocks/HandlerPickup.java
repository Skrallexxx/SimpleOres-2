package SimpleOres.plugins.Netherrocks;

import cpw.mods.fml.common.IPickupNotifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;

public class HandlerPickup  implements IPickupNotifier
{
	/**
	 * Detects when the player picks up a certain item or block, and then triggers an achievement.
	 */
	public void notifyPickup(EntityItem item, EntityPlayer player) 
	{
		if(item.getEntityItem().itemID == Blocks.fyriteOre.blockID) 
		{ 
			player.addStat(Achievements.netherRocksAch, 1); 
		}  
	}
}
