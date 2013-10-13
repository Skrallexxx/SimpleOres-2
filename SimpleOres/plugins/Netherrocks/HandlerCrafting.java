package SimpleOres.plugins.Netherrocks;

import cpw.mods.fml.common.ICraftingHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class HandlerCrafting implements ICraftingHandler
{
	/**
	 * Triggers certain events when an item is taken from crafting. At the moment only used for triggering achievements, but technically can be used
	 * for many things.
	 */
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) 
	{
		if(item.itemID == Blocks.netherFurnace.blockID)
		{
			player.addStat(Achievements.netherFurnaceAch, 1);
		}
	}

	/**
	 * Triggers certain events when an item is taken from a furnace. At the moment not used for anything, but technically can be used
	 * for many things.
	 */
	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) 
	{
		
	}
}
