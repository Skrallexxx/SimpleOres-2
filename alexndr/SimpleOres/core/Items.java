package alexndr.SimpleOres.core;

import cpw.mods.fml.common.registry.GameRegistry;
import alexndr.SimpleOres.api.SimpleIngot;
import alexndr.SimpleOres.core.conf.Config;
import alexndr.SimpleOres.core.content.SimpleBucket;
import alexndr.SimpleOres.core.content.SimpleDoorItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Items 
{
	/**
	 * The method that gives items their properties, names etc, harvest levels and registers them. This is called by the main SimpleOres class.
	 */
	public static void doItems()
	{
		//Item Details
        copperIngot = new SimpleIngot(Config.copperIngotID).setUnlocalizedName("copperIngot");
		tinIngot = new SimpleIngot(Config.tinIngotID).setUnlocalizedName("tinIngot");
		mythrilIngot = new SimpleIngot(Config.mythrilIngotID).setUnlocalizedName("mythrilIngot");
		adamantiumIngot = new SimpleIngot(Config.adamantiumIngotID).setUnlocalizedName("adamantiumIngot");
		onyxGem = new SimpleIngot(Config.onyxGemID).setUnlocalizedName("onyxGem");
		copperBucket = new SimpleBucket(Config.copperBucketID, 0).setUnlocalizedName("copperBucket").setMaxStackSize(16);
		copperBucketWater = new SimpleBucket(Config.copperBucketWaterID, Block.waterMoving.blockID).setContainerItem(copperBucket).setUnlocalizedName("copperBucketWater");
		mythrilRod = new SimpleIngot(Config.mythrilRodID).setUnlocalizedName("mythrilRod");
		onyxRod = new SimpleIngot(Config.onyxRodID).setUnlocalizedName("onyxRod");
		copperDoorItem = new SimpleDoorItem(Config.copperDoorItemID, "copper").setUnlocalizedName("copperDoor");
		onyxDoorItem = new SimpleDoorItem(Config.onyxDoorItemID, "onyx").setUnlocalizedName("onyxDoor");
		
		//Register Items
		GameRegistry.registerItem(copperBucket, "copperBucket");
		GameRegistry.registerItem(copperBucketWater, "copperBucketWater");
		GameRegistry.registerItem(copperDoorItem, "copperDoorItem");
		GameRegistry.registerItem(onyxDoorItem, "onyxDoorItem");
	}
	
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
}
