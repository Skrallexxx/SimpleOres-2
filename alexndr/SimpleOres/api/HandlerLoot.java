package alexndr.SimpleOres.api;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class HandlerLoot 
{
	/**
	 * Adds itemstacks to the loot list.
	 * 
	 * @param location The location of the chest you want to add loot to. These can all be found in ChestGenHooks.
	 * @param stack The ItemStack you want to add to the chest.
	 * @param minChance The minimum chance for the stack to spawn.
	 * @param maxChance The maximum chance for the stack to spawn.
	 * @param howMany How many 'slots' it gan generate in. ie. How many can generate in the chest.
	 */
	public static void addLoot(String location, ItemStack stack, int minChance, int maxChance, int howMany)
	{
		ChestGenHooks.getInfo(location).addItem(new WeightedRandomChestContent(stack, minChance, maxChance, howMany));
	}
	
	public static void addLoot()
	{
		
	}
}
