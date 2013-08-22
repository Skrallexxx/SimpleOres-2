package SimpleOres.core;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import SimpleOres.core.conf.IDs;
import SimpleOres.core.conf.Localisation;
import SimpleOres.core.item.SimpleBucket;
import SimpleOres.core.item.SimpleDoorItem;
import SimpleOres.core.api.SimpleIngot;

public class Items 
{
	/**
	 * Linking to the classes for easier reference.
	 */
	public static SimpleOres mod;
	public static Achievements achievements;
	public static Armor armor;
	public static Blocks blocks;
	public static IDs config;
	public static Items items;
	public static Localisation local;
	public static Recipes recipes;
	public static Tools tools;
		
	/**
	 * Creating the item int's. Fairly obvious.
	 */
//======================================= CREATION ======================================================= 	
	public static Item copperIngot;
	public static Item tinIngot;
	public static Item mythrilIngot;
	public static Item adamantiumIngot;
	public static Item onyxGem;
	public static Item copperBucket;
	public static Item copperBucketWater;
	public static Item mythrilRod;
	public static Item onyxRod;

	public static Item copperDoorItem;
	public static Item onyxDoorItem;
	
	/**
	 * The method that gives items their properties, names etc, harvest levels and registers them. This is called by the main SimpleOres class.
	 */
	public static void doItems()
	{
		//Item Details
        copperIngot = new SimpleIngot(config.copperIngotID, "simpleores").setUnlocalizedName("copperIngot");
		tinIngot = new SimpleIngot(config.tinIngotID, "simpleores").setUnlocalizedName("tinIngot");
		mythrilIngot = new SimpleIngot(config.mythrilIngotID, "simpleores").setUnlocalizedName("mythrilIngot");
		adamantiumIngot = new SimpleIngot(config.adamantiumIngotID, "simpleores").setUnlocalizedName("adamantiumIngot");
		onyxGem = new SimpleIngot(config.onyxGemID, "simpleores").setUnlocalizedName("onyxGem");
		copperBucket = new SimpleBucket(config.copperBucketID, 0).setUnlocalizedName("copperBucket").setMaxStackSize(16);
		copperBucketWater = new SimpleBucket(config.copperBucketWaterID, Block.waterMoving.blockID).setUnlocalizedName("copperBucketWater");
		mythrilRod = new SimpleIngot(config.mythrilRodID, "simpleores").setUnlocalizedName("mythrilRod");
		onyxRod = new SimpleIngot(config.onyxRodID, "simpleores").setUnlocalizedName("onyxRod");
		copperDoorItem = new SimpleDoorItem(config.copperDoorItemID, "copper").setUnlocalizedName("copperDoor");
		onyxDoorItem = new SimpleDoorItem(config.onyxDoorItemID, "onyx").setUnlocalizedName("onyxDoor");
		
		//Item Naming
		LanguageRegistry.addName(copperIngot, local.copperIngotName);
		LanguageRegistry.addName(tinIngot, local.tinIngotName);
		LanguageRegistry.addName(mythrilIngot, local.mythrilIngotName);
		LanguageRegistry.addName(adamantiumIngot, local.adamantiumIngotName);	
		LanguageRegistry.addName(onyxGem, local.onyxGemName);
		LanguageRegistry.addName(copperBucket, local.copperBucketName);
		LanguageRegistry.addName(copperBucketWater, local.copperBucketWaterName);
		LanguageRegistry.addName(mythrilRod, local.mythrilRodName);
		LanguageRegistry.addName(onyxRod, local.onyxRodName);
		LanguageRegistry.addName(copperDoorItem, local.copperDoorName);
		LanguageRegistry.addName(onyxDoorItem, local.onyxDoorName);
	}
}
