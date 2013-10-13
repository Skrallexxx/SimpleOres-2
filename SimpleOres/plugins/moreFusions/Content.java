package SimpleOres.plugins.moreFusions;

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
		steelBlock = new SimpleOre(Config.steelBlockID, Material.iron, "morefusions", SimpleOres.tabSimpleBlocks).setHardness(7.0F).setResistance(12.0F).setCreativeTab(SimpleOres.tabSimpleBlocks).setUnlocalizedName("steelBlock");
		
		steelChunkSmall = new SimpleIngot(Config.steelChunkSmallID, "morefusions", SimpleOres.tabSimpleMaterials).setUnlocalizedName("steelChunkSmall");
		steelChunkMedium = new SimpleIngot(Config.steelChunkMediumID, "morefusions", SimpleOres.tabSimpleMaterials).setUnlocalizedName("steelChunkMedium");
		steelChunkLarge = new SimpleIngot(Config.steelChunkLargeID, "morefusions", SimpleOres.tabSimpleMaterials).setUnlocalizedName("steelChunkLarge");
		steelIngot = new SimpleIngot(Config.steelIngotID, "morefusions", SimpleOres.tabSimpleMaterials).setUnlocalizedName("steelIngot");
		steelPick = new SimplePickaxe(Config.steelPickID, MoreFusions.toolSteel, "morefusions", SimpleOres.tabSimpleTools).setUnlocalizedName("steelPick");
		steelAxe = new SimpleAxe(Config.steelAxeID, MoreFusions.toolSteel, "morefusions", SimpleOres.tabSimpleTools).setUnlocalizedName("steelAxe");
		steelShovel = new SimpleShovel(Config.steelShovelID, MoreFusions.toolSteel, "morefusions", SimpleOres.tabSimpleTools).setUnlocalizedName("steelShovel");
		steelSword = new SimpleSword(Config.steelSwordID, MoreFusions.toolSteel, "morefusions", SimpleOres.tabSimpleCombat).setUnlocalizedName("steelSword");
		steelHoe = new SimpleHoe(Config.steelHoeID, MoreFusions.toolSteel, "morefusions", SimpleOres.tabSimpleTools).setUnlocalizedName("steelHoe");
		steelHelm = new SimpleArmor(Config.steelHelmID, MoreFusions.armorSteel, MoreFusions.rendererSteel, 0, "steel", "morefusions", SimpleOres.tabSimpleCombat).setUnlocalizedName("steelHelm");
		steelChest = new SimpleArmor(Config.steelChestID, MoreFusions.armorSteel, MoreFusions.rendererSteel, 1, "steel", "morefusions", SimpleOres.tabSimpleCombat).setUnlocalizedName("steelChest");
		steelLegs = new SimpleArmor(Config.steelLegsID, MoreFusions.armorSteel, MoreFusions.rendererSteel, 2, "steel", "morefusions", SimpleOres.tabSimpleCombat).setUnlocalizedName("steelLegs");
		steelBoots = new SimpleArmor(Config.steelBootsID, MoreFusions.armorSteel, MoreFusions.rendererSteel, 3, "steel", "morefusions", SimpleOres.tabSimpleCombat).setUnlocalizedName("steelBoots");
		
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
