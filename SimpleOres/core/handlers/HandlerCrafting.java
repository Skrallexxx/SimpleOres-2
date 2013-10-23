package SimpleOres.core.handlers;

import SimpleOres.core.Achievements;
import SimpleOres.core.SimpleOres;
import SimpleOres.core.Tools;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class HandlerCrafting implements ICraftingHandler
{
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) 
	{
		if(item.itemID == Item.pickaxeIron.itemID)
		{
			player.addStat(Achievements.ironPickAch, 1);
		}
		if(item.itemID == Tools.adamantiumPick.itemID)
		{
			player.addStat(Achievements.adamantiumPickAch, 1);
		}
		if(item.itemID == Tools.onyxPick.itemID)
		{
			player.addStat(Achievements.onyxPickAch, 1);
		}
		if(item.itemID == Tools.mythrilBow.itemID)
		{
			player.addStat(Achievements.mythrilBowAch, 1);
		}
		if(item.itemID == Tools.onyxBow.itemID)
		{
			player.addStat(Achievements.onyxBowAch, 1);
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) 
	{
		
	}
}
