package SimpleOres.core;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import SimpleOres.core.content.SimpleBucket;
import SimpleOres.core.content.SimpleDoorItem;
import SimpleOres.core.api.SimpleIngot;

public class Items 
{		
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
        copperIngot = new SimpleIngot(Config.copperIngotID, "simpleores", SimpleOres.tabSimpleMaterials).setUnlocalizedName("copperIngot");
		tinIngot = new SimpleIngot(Config.tinIngotID, "simpleores", SimpleOres.tabSimpleMaterials).setUnlocalizedName("tinIngot");
		mythrilIngot = new SimpleIngot(Config.mythrilIngotID, "simpleores", SimpleOres.tabSimpleMaterials).setUnlocalizedName("mythrilIngot");
		adamantiumIngot = new SimpleIngot(Config.adamantiumIngotID, "simpleores", SimpleOres.tabSimpleMaterials).setUnlocalizedName("adamantiumIngot");
		onyxGem = new SimpleIngot(Config.onyxGemID, "simpleores", SimpleOres.tabSimpleMaterials).setUnlocalizedName("onyxGem");
		copperBucket = new SimpleBucket(Config.copperBucketID, 0).setUnlocalizedName("copperBucket").setMaxStackSize(16);
		copperBucketWater = new SimpleBucket(Config.copperBucketWaterID, Block.waterMoving.blockID).setContainerItem(copperBucket).setUnlocalizedName("copperBucketWater");
		mythrilRod = new SimpleIngot(Config.mythrilRodID, "simpleores", SimpleOres.tabSimpleMaterials).setUnlocalizedName("mythrilRod");
		onyxRod = new SimpleIngot(Config.onyxRodID, "simpleores", SimpleOres.tabSimpleMaterials).setUnlocalizedName("onyxRod");
		copperDoorItem = new SimpleDoorItem(Config.copperDoorItemID, "copper").setUnlocalizedName("copperDoor");
		onyxDoorItem = new SimpleDoorItem(Config.onyxDoorItemID, "onyx").setUnlocalizedName("onyxDoor");
	}
}
