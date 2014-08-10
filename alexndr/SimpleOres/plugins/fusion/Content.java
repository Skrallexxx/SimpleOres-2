package alexndr.SimpleOres.plugins.fusion;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import alexndr.SimpleOres.api.content.SimpleArmor;
import alexndr.SimpleOres.api.content.SimpleAxe;
import alexndr.SimpleOres.api.content.SimpleHoe;
import alexndr.SimpleOres.api.content.SimpleIngot;
import alexndr.SimpleOres.api.content.SimpleBlock;
import alexndr.SimpleOres.api.content.SimplePickaxe;
import alexndr.SimpleOres.api.content.SimpleShovel;
import alexndr.SimpleOres.api.content.SimpleSword;
import alexndr.SimpleOres.api.helpers.CoreHelper;
import alexndr.SimpleOres.api.helpers.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class Content 
{
	public static void initialize()
	{
		try{doItems(); LogHelper.verboseInfo("Fusion Plugin: All items were added successfully.");}
		catch(Exception e){LogHelper.severe("Fusion Plugin: Items were not added successfully. This is a serious problem!"); e.printStackTrace();}
		try{doBlocks(); LogHelper.verboseInfo("Fusion Plugin: All blocks were added successfully.");}
		catch(Exception e){LogHelper.severe("Fusion Plugin: Blocks were not added successfully. This is a serious problem!"); e.printStackTrace();}
		try{doTools(); LogHelper.verboseInfo("Fusion Plugin: All tools were added successfully.");}
		catch(Exception e){LogHelper.severe("Fusion Plugin: Tools were not added successfully. This is a serious problem!"); e.printStackTrace();}
		try{doArmor(); LogHelper.verboseInfo("Fusion Plugin: All armor was added successfully.");}
		catch(Exception e){LogHelper.severe("Fusion Plugin: Armor was not added successfully. This is a serious problem!"); e.printStackTrace();}
		try{doAchievements(); LogHelper.verboseInfo("Fusion Plugin: All achievements were added successfully.");}
		catch(Exception e){LogHelper.severe("Fusion Plugin: Achievements were not added successfully. This is a serious problem!"); e.printStackTrace();}
	}
	
	/**
	 * The method that gives the armor items their properties and names. This is called by the main SimpleOres class.
	 */
	public static void doArmor()
	{
        //Armour Details
        bronze_helmet = new SimpleArmor(FusionPlugin.armorBronze, FusionPlugin.rendererBronze, 0).modId("simpleoresfusion").setType("bronze").setUnlocalizedName("bronze_helmet");
		bronze_chestplate = new SimpleArmor(FusionPlugin.armorBronze, FusionPlugin.rendererBronze, 1).modId("simpleoresfusion").setType("bronze").setUnlocalizedName("bronze_chestplate");
		bronze_leggings = new SimpleArmor(FusionPlugin.armorBronze, FusionPlugin.rendererBronze, 2).modId("simpleoresfusion").setType("bronze").setUnlocalizedName("bronze_leggings");
		bronze_boots = new SimpleArmor(FusionPlugin.armorBronze, FusionPlugin.rendererBronze, 3).modId("simpleoresfusion").setType("bronze").setUnlocalizedName("bronze_boots");
        thyrium_helmet = new SimpleArmor(FusionPlugin.armorThyrium, FusionPlugin.rendererThyrium, 0).modId("simpleoresfusion").setType("thyrium").setUnlocalizedName("thyrium_helmet");
		thyrium_chestplate = new SimpleArmor(FusionPlugin.armorThyrium, FusionPlugin.rendererThyrium, 1).modId("simpleoresfusion").setType("thyrium").setUnlocalizedName("thyrium_chestplate");
		thyrium_leggings = new SimpleArmor(FusionPlugin.armorThyrium, FusionPlugin.rendererThyrium, 2).modId("simpleoresfusion").setType("thyrium").setUnlocalizedName("thyrium_leggings");
		thyrium_boots = new SimpleArmor(FusionPlugin.armorThyrium, FusionPlugin.rendererThyrium, 3).modId("simpleoresfusion").setType("thyrium").setUnlocalizedName("thyrium_boots");
        sinisite_helmet = new SimpleArmor(FusionPlugin.armorSinisite, FusionPlugin.rendererSinisite, 0).modId("simpleoresfusion").setType("sinisite").setUnlocalizedName("sinisite_helmet");
		sinisite_chestplate = new SimpleArmor(FusionPlugin.armorSinisite, FusionPlugin.rendererSinisite, 1).modId("simpleoresfusion").setType("sinisite").setUnlocalizedName("sinisite_chestplate");
		sinisite_leggings = new SimpleArmor(FusionPlugin.armorSinisite, FusionPlugin.rendererSinisite, 2).modId("simpleoresfusion").setType("sinisite").setUnlocalizedName("sinisite_leggings");
		sinisite_boots = new SimpleArmor(FusionPlugin.armorSinisite, FusionPlugin.rendererSinisite, 3).modId("simpleoresfusion").setType("sinisite").setUnlocalizedName("sinisite_boots");
	}
	
	/**
	 * The method that gives blocks their properties, names etc, harvest levels and registers them. This is called by the main SimpleOres class.
	 */
	public static void doBlocks()
	{
		//Block Properties
		bronze_block = new SimpleBlock(Material.iron).setAsBeaconBase(true).modId("simpleoresfusion").setHardness(Settings.bronzeBlockHardness).setResistance(Settings.bronzeBlockResistance).setBlockName("bronze_block");
		thyrium_block = new SimpleBlock(Material.iron).setAsBeaconBase(true).modId("simpleoresfusion").setHardness(Settings.thyriumBlockHardness).setResistance(Settings.thyriumBlockResistance).setBlockName("thyrium_block");
		sinisite_block = new SimpleBlock(Material.iron).setAsBeaconBase(true).modId("simpleoresfusion").setHardness(Settings.sinisiteBlockHardness).setResistance(Settings.sinisiteBlockResistance).setBlockName("sinisite_block");
		fusion_furnace = new FusionFurnace(false).setHardness(Settings.fusionFurnaceHardness).setResistance(Settings.fusionFurnaceResistance).setBlockName("fusion_furnace");
		fusion_furnace_lit = new FusionFurnace(true).setHardness(Settings.fusionFurnaceHardness).setResistance(Settings.fusionFurnaceResistance).setLightLevel(Settings.fusionFurnaceLightValue).setBlockName("fusion_furnace_lit");
		
		//Block Registering
		GameRegistry.registerBlock(fusion_furnace, "fusion_furnace");
		GameRegistry.registerBlock(fusion_furnace_lit, "fusion_furnace_lit");
	}	
	
	/**
	 * The method that gives items their properties, names etc, harvest levels and registers them. This is called by the main SimpleOres class.
	 */
	public static void doItems()
	{
		//Item Details
		bronze_ingot = new SimpleIngot().modId("simpleoresfusion").setUnlocalizedName("bronze_ingot");
		sinisite_ingot = new SimpleIngot().modId("simpleoresfusion").setUnlocalizedName("sinisite_ingot");
		thyrium_ingot = new SimpleIngot().modId("simpleoresfusion").setUnlocalizedName("thyrium_ingot");
		thyrium_rod = new SimpleIngot().modId("simpleoresfusion").setUnlocalizedName("thyrium_rod");
		sinisite_rod = new SimpleIngot().modId("simpleoresfusion").setUnlocalizedName("sinisite_rod");	
		small_bronze_chunk = new SimpleIngot().modId("simpleoresfusion").setUnlocalizedName("small_bronze_chunk");
		medium_bronze_chunk = new SimpleIngot().modId("simpleoresfusion").setUnlocalizedName("medium_bronze_chunk");
		large_bronze_chunk = new SimpleIngot().modId("simpleoresfusion").setUnlocalizedName("large_bronze_chunk");
		small_thyrium_chunk = new SimpleIngot().modId("simpleoresfusion").setUnlocalizedName("small_thyrium_chunk");
		medium_thyrium_chunk = new SimpleIngot().modId("simpleoresfusion").setUnlocalizedName("medium_thyrium_chunk");
		large_thyrium_chunk = new SimpleIngot().modId("simpleoresfusion").setUnlocalizedName("large_thyrium_chunk");
		small_sinisite_chunk = new SimpleIngot().modId("simpleoresfusion").setUnlocalizedName("small_sinisite_chunk");
		medium_sinisite_chunk = new SimpleIngot().modId("simpleoresfusion").setUnlocalizedName("medium_sinisite_chunk");
		large_sinisite_chunk = new SimpleIngot().modId("simpleoresfusion").setUnlocalizedName("large_sinisite_chunk");
	}
	
	/**
	 * The method that gives the tools their properties and names, as well as registering them as their respective tool type. This is called by the main SimpleOres class.
	 */
	public static void doTools()
	{
		//Tool Details
		bronze_pickaxe = new SimplePickaxe(FusionPlugin.toolBronze).modId("simpleoresfusion").setUnlocalizedName("bronze_pickaxe");
		bronze_axe = new SimpleAxe(FusionPlugin.toolBronze).modId("simpleoresfusion").setUnlocalizedName("bronze_axe");
		bronze_shovel = new SimpleShovel(FusionPlugin.toolBronze).modId("simpleoresfusion").setUnlocalizedName("bronze_shovel");
		bronze_sword = new SimpleSword(FusionPlugin.toolBronze).modId("simpleoresfusion").setUnlocalizedName("bronze_sword");
		bronze_hoe = new SimpleHoe(FusionPlugin.toolBronze).modId("simpleoresfusion").setUnlocalizedName("bronze_hoe");
		thyrium_pickaxe = new SimplePickaxe(FusionPlugin.toolThyrium).modId("simpleoresfusion").setUnlocalizedName("thyrium_pickaxe");
		thyrium_axe = new SimpleAxe(FusionPlugin.toolThyrium).modId("simpleoresfusion").setUnlocalizedName("thyrium_axe");
		thyrium_shovel = new SimpleShovel(FusionPlugin.toolThyrium).modId("simpleoresfusion").setUnlocalizedName("thyrium_shovel");
		thyrium_sword = new SimpleSword(FusionPlugin.toolThyrium).modId("simpleoresfusion").setUnlocalizedName("thyrium_sword");
		thyrium_hoe = new SimpleHoe(FusionPlugin.toolThyrium).modId("simpleoresfusion").setUnlocalizedName("thyrium_hoe");
		sinisite_pickaxe = new SimplePickaxe(FusionPlugin.toolSinisite).modId("simpleoresfusion").setUnlocalizedName("sinisite_pickaxe");
		sinisite_axe = new SimpleAxe(FusionPlugin.toolSinisite).modId("simpleoresfusion").setUnlocalizedName("sinisite_axe");
		sinisite_shovel = new SimpleShovel(FusionPlugin.toolSinisite).modId("simpleoresfusion").setUnlocalizedName("sinisite_shovel");
		sinisite_sword = new SimpleSword(FusionPlugin.toolSinisite).modId("simpleoresfusion").setUnlocalizedName("sinisite_sword");
		sinisite_hoe = new SimpleHoe(FusionPlugin.toolSinisite).modId("simpleoresfusion").setUnlocalizedName("sinisite_hoe");
		thyrium_bow = new SimpleBow(900, FusionPlugin.toolThyrium).setFull3D().setUnlocalizedName("thyrium_bow");
		sinisite_bow = new SimpleBow(1200, FusionPlugin.toolSinisite).setFull3D().setUnlocalizedName("sinisite_bow");
        
        //Register Items
        GameRegistry.registerItem(thyrium_bow, "thyrium_bow");
        GameRegistry.registerItem(sinisite_bow, "sinisite_bow");
	}
	
	public static void doAchievements()
	{
		fusionAch = new Achievement("achievement.fusionAch", "fusionAch", 6, 6, Content.fusion_furnace, CoreHelper.coreContent.simpleOresAch).registerStat();
		bronzeAch = new Achievement("achievement.bronzeAch", "bronzeAch", 8, 6, Content.bronze_ingot, fusionAch).registerStat();
		
	}
	
	//Blocks
	public static Block bronze_block, thyrium_block, sinisite_block;
	public static Block fusion_furnace, fusion_furnace_lit;
	
	//Items
	public static Item bronze_ingot, sinisite_ingot, thyrium_ingot, thyrium_rod, sinisite_rod;
	public static Item small_bronze_chunk, small_thyrium_chunk, small_sinisite_chunk;
	public static Item medium_bronze_chunk, medium_thyrium_chunk, medium_sinisite_chunk;
	public static Item large_bronze_chunk, large_thyrium_chunk, large_sinisite_chunk;
	
	//Tools
	public static Item bronze_pickaxe, thyrium_pickaxe, sinisite_pickaxe;
	public static Item bronze_axe, thyrium_axe, sinisite_axe;
	public static Item bronze_shovel, thyrium_shovel, sinisite_shovel;
	public static Item bronze_sword, thyrium_sword, sinisite_sword;
	public static Item bronze_hoe, thyrium_hoe, sinisite_hoe;
	public static Item thyrium_bow, sinisite_bow;
	
	//Armor
	public static Item bronze_helmet, thyrium_helmet, sinisite_helmet;
	public static Item bronze_chestplate, thyrium_chestplate, sinisite_chestplate;
	public static Item bronze_leggings, thyrium_leggings, sinisite_leggings;
	public static Item bronze_boots, thyrium_boots, sinisite_boots;
	
	//Achievements
	public static Achievement fusionAch, bronzeAch;
}
