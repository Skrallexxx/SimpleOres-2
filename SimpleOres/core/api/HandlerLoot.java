package SimpleOres.core.api;

import java.util.HashMap;
import java.util.Map;

import SimpleOres.core.Armor;
import SimpleOres.core.Items;
import SimpleOres.core.Tools;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

/**
 * Adds SimpleOres loot to the various dungeon chests, etc. 
 */
public class HandlerLoot 
{
	private static final HandlerLoot lootHandler = new HandlerLoot();
	
	/**
	 * Allows the addLoot functions to be called from elsewhere.
	 */
	public static final HandlerLoot lootHandler()
	{
		return lootHandler;
	}
	
	private HandlerLoot()
	{
		
	}
	
	/**
	 * Adds items to the loot list. 
	 * 
	 * @param location = the location of the chest you want to add the loot to. These can all be found in ChestGenHooks.
	 * @param item = the item you want added to the chest.
	 * @param minChance = the minimum chance for the item to spawn.
	 * @param maxChance = the maximum chance for the item to spawn.
	 * @param howOften = how many loot 'slots' it can generate in. ie. How many can generate in the chest.
	 */
	public void addLoot(String location, Item item, int minChance, int maxChance, int howOften)
	{
		ChestGenHooks.getInfo(location).addItem(new WeightedRandomChestContent(new ItemStack(item), minChance, maxChance, howOften));
	}
	
	/**
	 * Adds blocks to the loot list.
	 * 
	 * @param location = the location of the chest you want to add the loot to. These can all be found in ChestGenHooks.
	 * @param stack = the itemstack you want added to the chest.
	 * @param minChance = the minimum chance for the stack to spawn.
	 * @param maxChance = the maximum chance for the stack spawn.
	 * @param howOften = how many loot 'slots' it can generate in. ie. How many can generate in the chest.
	 */
	public void addLoot(String location, ItemStack stack, int minChance, int maxChance, int howOften)
	{
		ChestGenHooks.getInfo(location).addItem(new WeightedRandomChestContent(stack, minChance, maxChance, howOften));
	}
	
	/**
	 * SimpleOres 2 loot. I need to fix this up, as it doesn't follow the correct format. It DOES work, however it isn't correct. 
	 */
	public static void addLoot()
	{			
		ChestGenHooks.getInfo("villageBlacksmith").addItem(new WeightedRandomChestContent(new ItemStack(Tools.mythrilPick), 1, 1, 10));
		ChestGenHooks.getInfo("villageBlacksmith").addItem(new WeightedRandomChestContent(new ItemStack(Armor.adamantiumChest), 1, 1, 4));
		ChestGenHooks.getInfo("villageBlacksmith").addItem(new WeightedRandomChestContent(new ItemStack(Items.mythrilIngot), 2, 3, 20));
		
		ChestGenHooks.getInfo("mineshaftCorridor").addItem(new WeightedRandomChestContent(new ItemStack(Tools.mythrilAxe), 1, 1, 10));
		ChestGenHooks.getInfo("mineshaftCorridor").addItem(new WeightedRandomChestContent(new ItemStack(Tools.adamantiumSword), 1, 1, 4));
		ChestGenHooks.getInfo("mineshaftCorridor").addItem(new WeightedRandomChestContent(new ItemStack(Items.adamantiumIngot), 2, 3, 15));
		
		ChestGenHooks.getInfo("pyramidDesertyChest").addItem(new WeightedRandomChestContent(new ItemStack(Items.adamantiumIngot), 1, 2, 5));
		
		ChestGenHooks.getInfo("pyramidJungleChest").addItem(new WeightedRandomChestContent(new ItemStack(Tools.adamantiumPick), 1, 1, 5));
		ChestGenHooks.getInfo("pyramidJungleChest").addItem(new WeightedRandomChestContent(new ItemStack(Tools.mythrilSword), 1, 1, 8));
		ChestGenHooks.getInfo("pyramidJungleChest").addItem(new WeightedRandomChestContent(new ItemStack(Armor.mythrilLegs), 1, 1, 10));
		
		ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(new ItemStack(Armor.mythrilHelm), 1, 1, 10));
		ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(new ItemStack(Armor.adamantiumBoots), 1, 1, 5));
		ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(new ItemStack(Tools.adamantiumSword), 1, 1, 5));
		
	}
}
