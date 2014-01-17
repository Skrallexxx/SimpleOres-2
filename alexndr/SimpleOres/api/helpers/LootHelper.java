package alexndr.SimpleOres.api.helpers;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class LootHelper 
{
	/**
	 * Adds itemstacks to the loot list.
	 * 
	 * @param location The location of the chest you want to add loot to. These can all be found in ChestGenHooks.
	 * @param stack The ItemStack you want to add to the chest.
	 * @param minChance The minimum chance for the stack to spawn.
	 * @param maxChance The maximum chance for the stack to spawn.
	 * @param itemWeight How often the item is chosen(higher number is higher chance(lower is lower))
	 */
	public static void addLoot(String location, ItemStack stack, int minChance, int maxChance, int itemWeight)
	{
		ChestGenHooks.getInfo(location).addItem(new WeightedRandomChestContent(stack, minChance, maxChance, itemWeight));
	}
	
	public static void addLoot()
	{
		
	}
}
