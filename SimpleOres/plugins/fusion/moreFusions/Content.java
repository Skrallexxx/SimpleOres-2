package SimpleOres.plugins.fusion.moreFusions;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import SimpleOres.core.SimpleOres;
import SimpleOres.core.api.SimpleArmor;
import SimpleOres.core.api.SimpleAxe;
import SimpleOres.core.api.SimpleHoe;
import SimpleOres.core.api.SimpleIngot;
import SimpleOres.core.api.SimpleOre;
import SimpleOres.core.api.SimplePickaxe;
import SimpleOres.core.api.SimpleShovel;
import SimpleOres.core.api.SimpleSword;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

public class Content 
{
	public static Block steelBlock;
	
	public static Item steelChunkSmall;
	public static Item steelChunkMedium;
	public static Item steelChunkLarge;
	public static Item steelIngot;
	public static Item steelPick;
	public static Item steelAxe;
	public static Item steelShovel;
	public static Item steelSword;
	public static Item steelHoe;
	public static Item steelHelm;
	public static Item steelChest;
	public static Item steelLegs;
	public static Item steelBoots;
	
	public static void doContent()
	{
		//Descriptions
		steelBlock = new SimpleOre(Config.steelBlockID, Material.iron, "morefusions").setHardness(7.0F).setResistance(12.0F).setCreativeTab(SimpleOres.tabSimpleBlocks).setUnlocalizedName("steelBlock");
		
		steelChunkSmall = new SimpleIngot(Config.steelChunkSmallID, "morefusions").setUnlocalizedName("steelChunkSmall");
		steelChunkMedium = new SimpleIngot(Config.steelChunkMediumID, "morefusions").setUnlocalizedName("steelChunkMedium");
		steelChunkLarge = new SimpleIngot(Config.steelChunkLargeID, "morefusions").setUnlocalizedName("steelChunkLarge");
		steelIngot = new SimpleIngot(Config.steelIngotID, "morefusions").setUnlocalizedName("steelIngot");
		steelPick = new SimplePickaxe(Config.steelPickID, MoreFusions.toolSteel, "morefusions").setUnlocalizedName("steelPick");
		steelAxe = new SimpleAxe(Config.steelAxeID, MoreFusions.toolSteel, "morefusions").setUnlocalizedName("steelAxe");
		steelShovel = new SimpleShovel(Config.steelShovelID, MoreFusions.toolSteel, "morefusions").setUnlocalizedName("steelShovel");
		steelSword = new SimpleSword(Config.steelSwordID, MoreFusions.toolSteel, "morefusions").setUnlocalizedName("steelSword");
		steelHoe = new SimpleHoe(Config.steelHoeID, MoreFusions.toolSteel, "morefusions").setUnlocalizedName("steelHoe");
		steelHelm = new SimpleArmor(Config.steelHelmID, MoreFusions.armorSteel, MoreFusions.rendererSteel, 0, "steel", "morefusions").setUnlocalizedName("steelHelm");
		steelChest = new SimpleArmor(Config.steelChestID, MoreFusions.armorSteel, MoreFusions.rendererSteel, 1, "steel", "morefusions").setUnlocalizedName("steelChest");
		steelLegs = new SimpleArmor(Config.steelLegsID, MoreFusions.armorSteel, MoreFusions.rendererSteel, 2, "steel", "morefusions").setUnlocalizedName("steelLegs");
		steelBoots = new SimpleArmor(Config.steelBootsID, MoreFusions.armorSteel, MoreFusions.rendererSteel, 3, "steel", "morefusions").setUnlocalizedName("steelBoots");
		
		//Naming
		LanguageRegistry.addName(steelBlock, "Steel Block");
		LanguageRegistry.addName(steelChunkSmall, "Small Steel Chunk");
		LanguageRegistry.addName(steelChunkMedium, "Medium Steel Chunk");
		LanguageRegistry.addName(steelChunkLarge, "Large Steel Chunk");
		LanguageRegistry.addName(steelIngot, "Steel Ingot");
		LanguageRegistry.addName(steelPick, "Steel Pickaxe");
		LanguageRegistry.addName(steelAxe, "Steel Axe");
		LanguageRegistry.addName(steelShovel, "Steel Shovel");
		LanguageRegistry.addName(steelSword, "Steel Sword");
		LanguageRegistry.addName(steelHoe, "Steel Hoe");
		LanguageRegistry.addName(steelHelm, "Steel Helmet");
		LanguageRegistry.addName(steelChest, "Steel Chestplate");
		LanguageRegistry.addName(steelLegs, "Steel Leggings");
		LanguageRegistry.addName(steelBoots, "Steel Boots");
		
		//Block Registering
		GameRegistry.registerBlock(steelBlock, "steelBlock");
		
		//Tool Registering
        MinecraftForge.setToolClass(steelPick, "pickaxe", 2);
        MinecraftForge.setToolClass(steelShovel, "shovel", 2);
        MinecraftForge.setToolClass(steelAxe, "axe", 2);
	}
}
