package SimpleOres.core.handlers;

import SimpleOres.core.Achievements;
import SimpleOres.core.Armor;
import SimpleOres.core.Blocks;
import SimpleOres.core.Items;
import SimpleOres.core.Recipes;
import SimpleOres.core.SimpleOres;
import SimpleOres.core.Tools;
import SimpleOres.core.conf.IDs;
import SimpleOres.core.conf.Localisation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class HandlerCrafting implements ICraftingHandler
{
	/**
	 * Linking to the classes for easier reference.
	 */
	public static Achievements achievements;
	public static Blocks blocks;
	public static Items items;
	public static Tools tools;
	
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) 
	{
		if(item.itemID == Item.pickaxeIron.itemID)
		{
			player.addStat(achievements.ironPickAch, 1);
		}
		if(item.itemID == tools.adamantiumPick.itemID)
		{
			player.addStat(achievements.adamantiumPickAch, 1);
		}
		if(item.itemID == tools.onyxPick.itemID)
		{
			player.addStat(achievements.onyxPickAch, 1);
		}
		if(item.itemID == tools.mythrilBow.itemID)
		{
			player.addStat(achievements.mythrilBowAch, 1);
		}
		if(item.itemID == tools.onyxBow.itemID)
		{
			player.addStat(achievements.onyxBowAch, 1);
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) 
	{
		
	}
}
