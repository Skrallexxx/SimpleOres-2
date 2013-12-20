package alexndr.SimpleOres.plugins.fusion;

import cpw.mods.fml.common.registry.GameRegistry;
import alexndr.SimpleOres.api.SimpleArmor;
import alexndr.SimpleOres.api.SimpleAxe;
import alexndr.SimpleOres.api.SimpleHoe;
import alexndr.SimpleOres.api.SimpleIngot;
import alexndr.SimpleOres.api.SimpleOre;
import alexndr.SimpleOres.api.SimplePickaxe;
import alexndr.SimpleOres.api.SimpleShovel;
import alexndr.SimpleOres.api.SimpleSword;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

public class Content 
{
	public static FusionPlugin mod;
	
	/**
	 * Creating the blocks.
	 */
	public static Block bronzeBlock;
	public static Block thyriumBlock;
	public static Block sinisiteBlock;
	public static Block fusionFurnace;
	public static Block fusionFurnaceOn;
	
	/**
	 * Creating the item int's. Fairly obvious.
	 */
	public static Item bronzeIngot;
	public static Item sinisiteIngot;
	public static Item thyriumIngot;
	public static Item thyriumRod;
	public static Item sinisiteRod;
	
	public static Item smallBronzeChunk;
	public static Item mediumBronzeChunk;
	public static Item largeBronzeChunk;
	public static Item smallThyriumChunk;
	public static Item mediumThyriumChunk;
	public static Item largeThyriumChunk;
	public static Item smallSinisiteChunk;
	public static Item mediumSinisiteChunk;
	public static Item largeSinisiteChunk;
	
	/**
	 * Creating the tool items.
	 */
	public static Item bronzePick;
	public static Item bronzeAxe;
	public static Item bronzeShovel;
	public static Item bronzeSword;
	public static Item bronzeHoe;
	public static Item thyriumPick;
	public static Item thyriumAxe;
	public static Item thyriumShovel;
	public static Item thyriumSword;
	public static Item thyriumHoe;
	public static Item sinisitePick;
	public static Item sinisiteAxe;
	public static Item sinisiteShovel;
	public static Item sinisiteSword;
	public static Item sinisiteHoe;
	public static Item thyriumBow;
	public static Item sinisiteBow;
	
	/**
	 * Creating the armor items.
	 */
	public static Item bronzeHelm;
	public static Item bronzeChest;
	public static Item bronzeLegs;
	public static Item bronzeBoots;
	public static Item thyriumHelm;
	public static Item thyriumChest;
	public static Item thyriumLegs;
	public static Item thyriumBoots;
	public static Item sinisiteHelm;
	public static Item sinisiteChest;
	public static Item sinisiteLegs;
	public static Item sinisiteBoots;
	
	/**
	 * The method that gives the armor items their properties and names. This is called by the main SimpleOres class.
	 */
	public static void doArmor()
	{
        //Armour Details
        bronzeHelm = new SimpleArmor(Config.bronzeHelmID, mod.armorBronze, mod.rendererBronze, 0).setType("bronze").modId("simpleOresfusion").setUnlocalizedName("bronzeHelm");
		bronzeChest = new SimpleArmor(Config.bronzeChestID, mod.armorBronze, mod.rendererBronze, 1).setType("bronze").modId("simpleOresfusion").setUnlocalizedName("bronzeChest");
		bronzeLegs = new SimpleArmor(Config.bronzeLegsID, mod.armorBronze, mod.rendererBronze, 2).setType("bronze").modId("simpleOresfusion").setUnlocalizedName("bronzeLegs");
		bronzeBoots = new SimpleArmor(Config.bronzeBootsID, mod.armorBronze, mod.rendererBronze, 3).setType("bronze").modId("simpleOresfusion").setUnlocalizedName("bronzeBoots");
        thyriumHelm = new SimpleArmor(Config.thyriumHelmID, mod.armorThyrium, mod.rendererThyrium, 0).setType("thyrium").modId("simpleOresfusion").setUnlocalizedName("thyriumHelm");
		thyriumChest = new SimpleArmor(Config.thyriumChestID, mod.armorThyrium, mod.rendererThyrium, 1).setType("thyrium").modId("simpleOresfusion").setUnlocalizedName("thyriumChest");
		thyriumLegs = new SimpleArmor(Config.thyriumLegsID, mod.armorThyrium, mod.rendererThyrium, 2).setType("thyrium").modId("simpleOresfusion").setUnlocalizedName("thyriumLegs");
		thyriumBoots = new SimpleArmor(Config.thyriumBootsID, mod.armorThyrium, mod.rendererThyrium, 3).setType("thyrium").modId("simpleOresfusion").setUnlocalizedName("thyriumBoots");
        sinisiteHelm = new SimpleArmor(Config.sinisiteHelmID, mod.armorSinisite, mod.rendererSinisite, 0).setType("sinisite").modId("simpleOresfusion").setUnlocalizedName("sinisiteHelm");
		sinisiteChest = new SimpleArmor(Config.sinisiteChestID, mod.armorSinisite, mod.rendererSinisite, 1).setType("sinisite").modId("simpleOresfusion").setUnlocalizedName("sinisiteChest");
		sinisiteLegs = new SimpleArmor(Config.sinisiteLegsID, mod.armorSinisite, mod.rendererSinisite, 2).setType("sinisite").modId("simpleOresfusion").setUnlocalizedName("sinisiteLegs");
		sinisiteBoots = new SimpleArmor(Config.sinisiteBootsID, mod.armorSinisite, mod.rendererSinisite, 3).setType("sinisite").modId("simpleOresfusion").setUnlocalizedName("sinisiteBoots");
	}
	
	/**
	 * The method that gives blocks their properties, names etc, harvest levels and registers them. This is called by the main SimpleOres class.
	 */
	public static void doBlocks()
	{
		//Block Properties
		bronzeBlock = new SimpleOre(Config.bronzeBlockID, Material.iron).modId("simpleoresfusion").setHardness(Settings.bronzeBlockHardness).setResistance(Settings.bronzeBlockResistance).setUnlocalizedName("bronzeBlock");
		thyriumBlock = new SimpleOre(Config.thyriumBlockID, Material.iron).modId("simpleoresfusion").setHardness(Settings.thyriumBlockHardness).setResistance(Settings.thyriumBlockResistance).setUnlocalizedName("thyriumBlock");
		sinisiteBlock = new SimpleOre(Config.sinisiteBlockID, Material.iron).modId("simpleoresfusion").setHardness(Settings.sinisiteBlockHardness).setResistance(Settings.sinisiteBlockResistance).setUnlocalizedName("sinisiteBlock");
		fusionFurnace = new FusionFurnace(Config.fusionFurnaceID, false).setHardness(Settings.fusionFurnaceHardness).setResistance(Settings.fusionFurnaceResistance).setUnlocalizedName("fusionFurnace");
		fusionFurnaceOn = new FusionFurnace(Config.fusionFurnaceOnID, true).setHardness(Settings.fusionFurnaceHardness).setResistance(Settings.fusionFurnaceResistance).setLightValue(Settings.fusionFurnaceLightValue).setUnlocalizedName("fusionFurnaceOn");
		
		//Block Registering
		GameRegistry.registerBlock(fusionFurnace, "fusionFurnace");
		GameRegistry.registerBlock(fusionFurnaceOn, "fusionFurnaceOn");
	}	
	
	/**
	 * The method that gives items their properties, names etc, harvest levels and registers them. This is called by the main SimpleOres class.
	 */
	public static void doItems()
	{
		//Item Details
		bronzeIngot = new SimpleIngot(Config.bronzeIngotID).modId("simpleoresfusion").setUnlocalizedName("bronzeIngot");
		sinisiteIngot = new SimpleIngot(Config.sinisiteIngotID).modId("simpleoresfusion").setUnlocalizedName("sinisiteIngot");
		thyriumIngot = new SimpleIngot(Config.thyriumIngotID).modId("simpleoresfusion").setUnlocalizedName("thyriumIngot");
		thyriumRod = new SimpleIngot(Config.thyriumRodID).modId("simpleoresfusion").setUnlocalizedName("thyriumRod");
		sinisiteRod = new SimpleIngot(Config.sinisiteRodID).modId("simpleoresfusion").setUnlocalizedName("sinisiteRod");	
		smallBronzeChunk = new SimpleIngot(Config.smallBronzeChunkID).modId("simpleoresfusion").setUnlocalizedName("smallBronzeChunk");
		mediumBronzeChunk = new SimpleIngot(Config.mediumBronzeChunkID).modId("simpleoresfusion").setUnlocalizedName("mediumBronzeChunk");
		largeBronzeChunk = new SimpleIngot(Config.largeBronzeChunkID).modId("simpleoresfusion").setUnlocalizedName("largeBronzeChunk");
		smallThyriumChunk = new SimpleIngot(Config.smallThyriumChunkID).modId("simpleoresfusion").setUnlocalizedName("smallThyriumChunk");
		mediumThyriumChunk = new SimpleIngot(Config.mediumThyriumChunkID).modId("simpleoresfusion").setUnlocalizedName("mediumThyriumChunk");
		largeThyriumChunk = new SimpleIngot(Config.largeThyriumChunkID).modId("simpleoresfusion").setUnlocalizedName("largeThyriumChunk");
		smallSinisiteChunk = new SimpleIngot(Config.smallSinisiteChunkID).modId("simpleoresfusion").setUnlocalizedName("smallSinisiteChunk");
		mediumSinisiteChunk = new SimpleIngot(Config.mediumSinisiteChunkID).modId("simpleoresfusion").setUnlocalizedName("mediumSinisiteChunk");
		largeSinisiteChunk = new SimpleIngot(Config.largeSinisiteChunkID).modId("simpleoresfusion").setUnlocalizedName("largeSinisiteChunk");
	}
	
	/**
	 * The method that gives the tools their properties and names, as well as registering them as their respective tool type. This is called by the main SimpleOres class.
	 */
	public static void doTools()
	{
		//Tool Details
		bronzePick = new SimplePickaxe(Config.bronzePickID, mod.toolBronze).modId("simpleoresfusion").setUnlocalizedName("bronzePick");
		bronzeAxe = new SimpleAxe(Config.bronzeAxeID, mod.toolBronze).modId("simpleoresfusion").setUnlocalizedName("bronzeAxe");
		bronzeShovel = new SimpleShovel(Config.bronzeShovelID, mod.toolBronze).modId("simpleoresfusion").setUnlocalizedName("bronzeShovel");
		bronzeSword = new SimpleSword(Config.bronzeSwordID, mod.toolBronze).modId("simpleoresfusion").setUnlocalizedName("bronzeSword");
		bronzeHoe = new SimpleHoe(Config.bronzeHoeID, mod.toolBronze).modId("simpleoresfusion").setUnlocalizedName("bronzeHoe");
		thyriumPick = new SimplePickaxe(Config.thyriumPickID, mod.toolThyrium).modId("simpleoresfusion").setUnlocalizedName("thyriumPick");
		thyriumAxe = new SimpleAxe(Config.thyriumAxeID, mod.toolThyrium).modId("simpleoresfusion").setUnlocalizedName("thyriumAxe");
		thyriumShovel = new SimpleShovel(Config.thyriumShovelID, mod.toolThyrium).modId("simpleoresfusion").setUnlocalizedName("thyriumShovel");
		thyriumSword = new SimpleSword(Config.thyriumSwordID, mod.toolThyrium).modId("simpleoresfusion").setUnlocalizedName("thyriumSword");
		thyriumHoe = new SimpleHoe(Config.thyriumHoeID, mod.toolThyrium).modId("simpleoresfusion").setUnlocalizedName("thyriumHoe");
		sinisitePick = new SimplePickaxe(Config.sinisitePickID, mod.toolSinisite).modId("simpleoresfusion").setUnlocalizedName("sinisitePick");
		sinisiteAxe = new SimpleAxe(Config.sinisiteAxeID, mod.toolSinisite).modId("simpleoresfusion").setUnlocalizedName("sinisiteAxe");
		sinisiteShovel = new SimpleShovel(Config.sinisiteShovelID, mod.toolSinisite).modId("simpleoresfusion").setUnlocalizedName("sinisiteShovel");
		sinisiteSword = new SimpleSword(Config.sinisiteSwordID, mod.toolSinisite).modId("simpleoresfusion").setUnlocalizedName("sinisiteSword");
		sinisiteHoe = new SimpleHoe(Config.sinisiteHoeID, mod.toolSinisite).modId("simpleoresfusion").setUnlocalizedName("sinisiteHoe");
		thyriumBow = new SimpleBow(Config.thyriumBowID, 900, mod.toolThyrium).setFull3D().setUnlocalizedName("thyriumBow");
		sinisiteBow = new SimpleBow(Config.sinisiteBowID, 1200, mod.toolSinisite).setFull3D().setUnlocalizedName("sinisiteBow");
		
		//Tool Registering
        MinecraftForge.setToolClass(bronzePick, "pickaxe", 2);
        MinecraftForge.setToolClass(bronzeShovel, "shovel", 2);
        MinecraftForge.setToolClass(bronzeAxe, "axe", 2);
        MinecraftForge.setToolClass(thyriumPick, "pickaxe", 3);
        MinecraftForge.setToolClass(thyriumShovel, "shovel", 3);
        MinecraftForge.setToolClass(thyriumAxe, "axe", 3);
        MinecraftForge.setToolClass(sinisitePick, "pickaxe", 4);
        MinecraftForge.setToolClass(sinisiteShovel, "shovel", 4);
        MinecraftForge.setToolClass(sinisiteAxe, "axe", 4);	
        
        //Register Items
        GameRegistry.registerItem(thyriumBow, "thyriumBow");
        GameRegistry.registerItem(sinisiteBow, "sinisiteBow");
	}
}
