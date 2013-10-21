package SimpleOres.plugins.fusion;

import cpw.mods.fml.common.ICraftingHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class HandlerCrafting implements ICraftingHandler
{
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) 
	{
		if(item.itemID == Content.fusionFurnace.blockID)
		{
			player.addStat(Achievements.fusionAch, 1);
		}
	}
	
	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) 
	{
		if(item.itemID == Content.bronzeIngot.itemID)
		{
			player.addStat(Achievements.bronzeAch, 1);
		}
	}
}
