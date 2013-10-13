package SimpleOres.plugins.fusion;

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
import net.minecraft.item.ItemBow;
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
        bronzeHelm = new SimpleArmor(IDs.bronzeHelmID, mod.armorBronze, mod.rendererBronze, 0, "bronze", "simpleoresfusion", SimpleOres.tabSimpleCombat).setUnlocalizedName("bronzeHelm");
		bronzeChest = new SimpleArmor(IDs.bronzeChestID, mod.armorBronze, mod.rendererBronze, 1, "bronze", "simpleoresfusion", SimpleOres.tabSimpleCombat).setUnlocalizedName("bronzeChest");
		bronzeLegs = new SimpleArmor(IDs.bronzeLegsID, mod.armorBronze, mod.rendererBronze, 2, "bronze", "simpleoresfusion", SimpleOres.tabSimpleCombat).setUnlocalizedName("bronzeLegs");
		bronzeBoots = new SimpleArmor(IDs.bronzeBootsID, mod.armorBronze, mod.rendererBronze, 3, "bronze", "simpleoresfusion", SimpleOres.tabSimpleCombat).setUnlocalizedName("bronzeBoots");
        thyriumHelm = new SimpleArmor(IDs.thyriumHelmID, mod.armorThyrium, mod.rendererThyrium, 0, "thyrium", "simpleoresfusion", SimpleOres.tabSimpleCombat).setUnlocalizedName("thyriumHelm");
		thyriumChest = new SimpleArmor(IDs.thyriumChestID, mod.armorThyrium, mod.rendererThyrium, 1, "thyrium", "simpleoresfusion", SimpleOres.tabSimpleCombat).setUnlocalizedName("thyriumChest");
		thyriumLegs = new SimpleArmor(IDs.thyriumLegsID, mod.armorThyrium, mod.rendererThyrium, 2, "thyrium", "simpleoresfusion", SimpleOres.tabSimpleCombat).setUnlocalizedName("thyriumLegs");
		thyriumBoots = new SimpleArmor(IDs.thyriumBootsID, mod.armorThyrium, mod.rendererThyrium, 3, "thyrium", "simpleoresfusion", SimpleOres.tabSimpleCombat).setUnlocalizedName("thyriumBoots");
        sinisiteHelm = new SimpleArmor(IDs.sinisiteHelmID, mod.armorSinisite, mod.rendererSinisite, 0, "sinisite", "simpleoresfusion", SimpleOres.tabSimpleCombat).setUnlocalizedName("sinisiteHelm");
		sinisiteChest = new SimpleArmor(IDs.sinisiteChestID, mod.armorSinisite, mod.rendererSinisite, 1, "sinisite", "simpleoresfusion", SimpleOres.tabSimpleCombat).setUnlocalizedName("sinisiteChest");
		sinisiteLegs = new SimpleArmor(IDs.sinisiteLegsID, mod.armorSinisite, mod.rendererSinisite, 2, "sinisite", "simpleoresfusion", SimpleOres.tabSimpleCombat).setUnlocalizedName("sinisiteLegs");
		sinisiteBoots = new SimpleArmor(IDs.sinisiteBootsID, mod.armorSinisite, mod.rendererSinisite, 3, "sinisite", "simpleoresfusion", SimpleOres.tabSimpleCombat).setUnlocalizedName("sinisiteBoots");
		
		//Armor Names
		if(Settings.enableOldLocalisation)
		{
			LanguageRegistry.addName(bronzeHelm, Localisation.bronzeHelmName);		
			LanguageRegistry.addName(bronzeChest, Localisation.bronzeChestName);
			LanguageRegistry.addName(bronzeLegs, Localisation.bronzeLegsName);
			LanguageRegistry.addName(bronzeBoots, Localisation.bronzeBootsName);
			LanguageRegistry.addName(thyriumHelm, Localisation.thyriumHelmName);		
			LanguageRegistry.addName(thyriumChest, Localisation.thyriumChestName);
			LanguageRegistry.addName(thyriumLegs, Localisation.thyriumLegsName);
			LanguageRegistry.addName(thyriumBoots, Localisation.thyriumBootsName);
			LanguageRegistry.addName(sinisiteHelm, Localisation.sinisiteHelmName);		
			LanguageRegistry.addName(sinisiteChest, Localisation.sinisiteChestName);
			LanguageRegistry.addName(sinisiteLegs, Localisation.sinisiteLegsName);
			LanguageRegistry.addName(sinisiteBoots, Localisation.sinisiteBootsName);
		}
	}
	
	/**
	 * The method that gives blocks their properties, names etc, harvest levels and registers them. This is called by the main SimpleOres class.
	 */
	public static void doBlocks()
	{
		//Block Properties
		bronzeBlock = new SimpleOre(IDs.bronzeBlockID, Material.iron, "simpleoresfusion", SimpleOres.tabSimpleBlocks).setHardness(7.0F).setResistance(12.0F).setCreativeTab(SimpleOres.tabSimpleBlocks).setUnlocalizedName("bronzeBlock");
		thyriumBlock = new SimpleOre(IDs.thyriumBlockID, Material.iron, "simpleoresfusion", SimpleOres.tabSimpleBlocks).setHardness(7.0F).setResistance(12.0F).setCreativeTab(SimpleOres.tabSimpleBlocks).setUnlocalizedName("thyriumBlock");
		sinisiteBlock = new SimpleOre(IDs.sinisiteBlockID, Material.iron, "simpleoresfusion", SimpleOres.tabSimpleBlocks).setHardness(7.0F).setResistance(12.0F).setCreativeTab(SimpleOres.tabSimpleBlocks).setUnlocalizedName("sinisiteBlock");
		fusionFurnace = new FusionFurnace(IDs.fusionFurnaceID, false).setHardness(3.5F).setResistance(10.0F).setUnlocalizedName("fusionFurnace");
		fusionFurnaceOn = new FusionFurnace(IDs.fusionFurnaceOnID, true).setHardness(3.5F).setLightValue(1.0F).setUnlocalizedName("fusionFurnaceOn");
		
		//Block Naming
		if(Settings.enableOldLocalisation)
		{
			LanguageRegistry.addName(bronzeBlock, Localisation.bronzeBlockName);
			LanguageRegistry.addName(thyriumBlock, Localisation.thyriumBlockName);
			LanguageRegistry.addName(sinisiteBlock, Localisation.sinisiteBlockName);
			LanguageRegistry.addName(fusionFurnace, Localisation.fusionFurnaceName);
			LanguageRegistry.addName(fusionFurnaceOn, Localisation.fusionFurnaceOnName);
		}
		
		//Block Registering
		GameRegistry.registerBlock(bronzeBlock, "bronzeBlock");
		GameRegistry.registerBlock(thyriumBlock, "thyriumBlock");
		GameRegistry.registerBlock(sinisiteBlock, "sinisiteBlock");
		GameRegistry.registerBlock(fusionFurnace, "fusionFurnace");
		GameRegistry.registerBlock(fusionFurnaceOn, "fusionFurnaceOn");
	}	
	
	/**
	 * The method that gives items their properties, names etc, harvest levels and registers them. This is called by the main SimpleOres class.
	 */
	public static void doItems()
	{
		//Item Details
		bronzeIngot = new SimpleIngot(IDs.bronzeIngotID, "simpleoresfusion", SimpleOres.tabSimpleMaterials).setUnlocalizedName("bronzeIngot");
		sinisiteIngot = new SimpleIngot(IDs.sinisiteIngotID, "simpleoresfusion", SimpleOres.tabSimpleMaterials).setUnlocalizedName("sinisiteIngot");
		thyriumIngot = new SimpleIngot(IDs.thyriumIngotID, "simpleoresfusion", SimpleOres.tabSimpleMaterials).setUnlocalizedName("thyriumIngot");
		thyriumRod = new SimpleIngot(IDs.thyriumRodID, "simpleoresfusion", SimpleOres.tabSimpleMaterials).setUnlocalizedName("thyriumRod");
		sinisiteRod = new SimpleIngot(IDs.sinisiteRodID, "simpleoresfusion", SimpleOres.tabSimpleMaterials).setUnlocalizedName("sinisiteRod");	
		smallBronzeChunk = new SimpleIngot(IDs.smallBronzeChunkID, "simpleoresfusion", SimpleOres.tabSimpleMaterials).setUnlocalizedName("smallBronzeChunk");
		mediumBronzeChunk = new SimpleIngot(IDs.mediumBronzeChunkID, "simpleoresfusion", SimpleOres.tabSimpleMaterials).setUnlocalizedName("mediumBronzeChunk");
		largeBronzeChunk = new SimpleIngot(IDs.largeBronzeChunkID, "simpleoresfusion", SimpleOres.tabSimpleMaterials).setUnlocalizedName("largeBronzeChunk");
		smallThyriumChunk = new SimpleIngot(IDs.smallThyriumChunkID, "simpleoresfusion", SimpleOres.tabSimpleMaterials).setUnlocalizedName("smallThyriumChunk");
		mediumThyriumChunk = new SimpleIngot(IDs.mediumThyriumChunkID, "simpleoresfusion", SimpleOres.tabSimpleMaterials).setUnlocalizedName("mediumThyriumChunk");
		largeThyriumChunk = new SimpleIngot(IDs.largeThyriumChunkID, "simpleoresfusion", SimpleOres.tabSimpleMaterials).setUnlocalizedName("largeThyriumChunk");
		smallSinisiteChunk = new SimpleIngot(IDs.smallSinisiteChunkID, "simpleoresfusion", SimpleOres.tabSimpleMaterials).setUnlocalizedName("smallSinisiteChunk");
		mediumSinisiteChunk = new SimpleIngot(IDs.mediumSinisiteChunkID, "simpleoresfusion", SimpleOres.tabSimpleMaterials).setUnlocalizedName("mediumSinisiteChunk");
		largeSinisiteChunk = new SimpleIngot(IDs.largeSinisiteChunkID, "simpleoresfusion", SimpleOres.tabSimpleMaterials).setUnlocalizedName("largeSinisiteChunk");
		
		//Item Naming
		if(Settings.enableOldLocalisation)
		{
			LanguageRegistry.addName(bronzeIngot, Localisation.bronzeIngotName);
			LanguageRegistry.addName(sinisiteIngot, Localisation.sinisiteIngotName);
			LanguageRegistry.addName(thyriumIngot, Localisation.thyriumIngotName);
			LanguageRegistry.addName(thyriumRod, Localisation.thyriumRodName);
			LanguageRegistry.addName(sinisiteRod, Localisation.sinisiteRodName);
			LanguageRegistry.addName(smallBronzeChunk, Localisation.smallBronzeChunkName);
			LanguageRegistry.addName(mediumBronzeChunk, Localisation.mediumBronzeChunkName);
			LanguageRegistry.addName(largeBronzeChunk, Localisation.largeBronzeChunkName);
			LanguageRegistry.addName(smallThyriumChunk, Localisation.smallThyriumChunkName);
			LanguageRegistry.addName(mediumThyriumChunk, Localisation.mediumThyriumChunkName);
			LanguageRegistry.addName(largeThyriumChunk, Localisation.largeThyriumChunkName);
			LanguageRegistry.addName(smallSinisiteChunk, Localisation.smallSinisiteChunkName);
			LanguageRegistry.addName(mediumSinisiteChunk, Localisation.mediumSinisiteChunkName);
			LanguageRegistry.addName(largeSinisiteChunk, Localisation.largeSinisiteChunkName);	
		}
	}
	
	/**
	 * The method that gives the tools their properties and names, as well as registering them as their respective tool type. This is called by the main SimpleOres class.
	 */
	public static void doTools()
	{
		//Tool Details
		bronzePick = new SimplePickaxe(IDs.bronzePickID, mod.toolBronze, "simpleoresfusion", SimpleOres.tabSimpleTools).setUnlocalizedName("bronzePick");
		bronzeAxe = new SimpleAxe(IDs.bronzeAxeID, mod.toolBronze, "simpleoresfusion", SimpleOres.tabSimpleTools).setUnlocalizedName("bronzeAxe");
		bronzeShovel = new SimpleShovel(IDs.bronzeShovelID, mod.toolBronze, "simpleoresfusion", SimpleOres.tabSimpleTools).setUnlocalizedName("bronzeShovel");
		bronzeSword = new SimpleSword(IDs.bronzeSwordID, mod.toolBronze, "simpleoresfusion", SimpleOres.tabSimpleCombat).setUnlocalizedName("bronzeSword");
		bronzeHoe = new SimpleHoe(IDs.bronzeHoeID, mod.toolBronze, "simpleoresfusion", SimpleOres.tabSimpleTools).setUnlocalizedName("bronzeHoe");
		thyriumPick = new SimplePickaxe(IDs.thyriumPickID, mod.toolThyrium, "simpleoresfusion", SimpleOres.tabSimpleTools).setUnlocalizedName("thyriumPick");
		thyriumAxe = new SimpleAxe(IDs.thyriumAxeID, mod.toolThyrium, "simpleoresfusion", SimpleOres.tabSimpleTools).setUnlocalizedName("thyriumAxe");
		thyriumShovel = new SimpleShovel(IDs.thyriumShovelID, mod.toolThyrium, "simpleoresfusion", SimpleOres.tabSimpleTools).setUnlocalizedName("thyriumShovel");
		thyriumSword = new SimpleSword(IDs.thyriumSwordID, mod.toolThyrium, "simpleoresfusion", SimpleOres.tabSimpleCombat).setUnlocalizedName("thyriumSword");
		thyriumHoe = new SimpleHoe(IDs.thyriumHoeID, mod.toolThyrium, "simpleoresfusion", SimpleOres.tabSimpleTools).setUnlocalizedName("thyriumHoe");
		sinisitePick = new SimplePickaxe(IDs.sinisitePickID, mod.toolSinisite, "simpleoresfusion", SimpleOres.tabSimpleTools).setUnlocalizedName("sinisitePick");
		sinisiteAxe = new SimpleAxe(IDs.sinisiteAxeID, mod.toolSinisite, "simpleoresfusion", SimpleOres.tabSimpleTools).setUnlocalizedName("sinisiteAxe");
		sinisiteShovel = new SimpleShovel(IDs.sinisiteShovelID, mod.toolSinisite, "simpleoresfusion", SimpleOres.tabSimpleTools).setUnlocalizedName("sinisiteShovel");
		sinisiteSword = new SimpleSword(IDs.sinisiteSwordID, mod.toolSinisite, "simpleoresfusion", SimpleOres.tabSimpleCombat).setUnlocalizedName("sinisiteSword");
		sinisiteHoe = new SimpleHoe(IDs.sinisiteHoeID, mod.toolSinisite, "simpleoresfusion", SimpleOres.tabSimpleTools).setUnlocalizedName("sinisiteHoe");
		thyriumBow = (ItemBow) new SimpleBow(IDs.thyriumBowID, 900, mod.toolThyrium).setFull3D().setUnlocalizedName("thyriumBow");
		sinisiteBow = (ItemBow) new SimpleBow(IDs.sinisiteBowID, 1200, mod.toolSinisite).setFull3D().setUnlocalizedName("sinisiteBow");
		
		//Tool Names
		if(Settings.enableOldLocalisation)
		{
			LanguageRegistry.addName(bronzePick, Localisation.bronzePickName);
			LanguageRegistry.addName(bronzeAxe, Localisation.bronzeAxeName);
			LanguageRegistry.addName(bronzeShovel, Localisation.bronzeShovelName);
			LanguageRegistry.addName(bronzeSword, Localisation.bronzeSwordName);
			LanguageRegistry.addName(bronzeHoe, Localisation.bronzeHoeName);
			LanguageRegistry.addName(thyriumPick, Localisation.thyriumPickName);
			LanguageRegistry.addName(thyriumAxe, Localisation.thyriumAxeName);
			LanguageRegistry.addName(thyriumShovel, Localisation.thyriumShovelName);
			LanguageRegistry.addName(thyriumSword, Localisation.thyriumSwordName);
			LanguageRegistry.addName(thyriumHoe, Localisation.thyriumHoeName);
			LanguageRegistry.addName(sinisitePick, Localisation.sinisitePickName);
			LanguageRegistry.addName(sinisiteAxe, Localisation.sinisiteAxeName);
			LanguageRegistry.addName(sinisiteShovel, Localisation.sinisiteShovelName);
			LanguageRegistry.addName(sinisiteSword, Localisation.sinisiteSwordName);
			LanguageRegistry.addName(sinisiteHoe, Localisation.sinisiteHoeName);
			LanguageRegistry.addName(thyriumBow, Localisation.thyriumBowName);
			LanguageRegistry.addName(sinisiteBow, Localisation.sinisiteBowName);
		}
		
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
	}
}
