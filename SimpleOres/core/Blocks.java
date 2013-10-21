package SimpleOres.core;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import SimpleOres.core.api.SimpleGemOre;
import SimpleOres.core.api.SimpleOre;
import SimpleOres.core.content.MythrilFurnace;
import SimpleOres.core.content.OnyxFurnace;
import SimpleOres.core.content.SimpleBars;
import SimpleOres.core.content.SimpleDoor;
import SimpleOres.plugins.fusion.FusionFurnace;

public class Blocks
{
	/**
	 * Linking to the classes for easier reference.
	 */
	public static SimpleOres mod;
	public static Achievements achievements;
	public static Armor armor;
	public static Blocks blocks;
	public static Config config;
	public static Items items;
	public static Localisation local;
	public static Recipes recipes;
	public static Settings toggles;
	public static Tools tools;
	
	/**
	 * Creating the blocks. Fairly obvious.
	 */
//======================================= CREATION ======================================================= 		
	public static Block copperOre;
	public static Block copperBlock;
	public static Block tinOre;
	public static Block tinBlock;
	public static Block mythrilOre;
	public static Block mythrilBlock;
	public static Block adamantiumOre;
	public static Block adamantiumBlock;
	public static Block onyxOre;
	public static Block onyxBlock;
	public static Block mythrilFurnace;
	public static Block mythrilFurnaceOn;
	public static Block onyxFurnace;
	public static Block onyxFurnaceOn;
	public static Block copperDoor;
	public static Block onyxDoor;
	public static Block copperBars;
	public static Block tinBars;
	public static Block mythrilBars;
	public static Block adamantiumBars;
	public static Block onyxBars;
	
	/**
	 * The method that gives blocks their properties, names etc, harvest levels and registers them. This is called by the main SimpleOres class.
	 */
	public static void doBlocks()
	{
		//Block Properties
		copperOre = new SimpleOre(config.copperOreID, Material.rock, "simpleores", SimpleOres.tabSimpleBlocks).setHardness(Settings.copperOreHardness).setResistance(Settings.copperOreResistance).setUnlocalizedName("copperOre");
		copperBlock = new SimpleOre(config.copperBlockID, Material.iron, "simpleores", SimpleOres.tabSimpleBlocks).setHardness(Settings.copperBlockHardness).setResistance(Settings.copperBlockResistance).setUnlocalizedName("copperBlock"); 
		tinOre = new SimpleOre(config.tinOreID, Material.rock, "simpleores", SimpleOres.tabSimpleBlocks).setHardness(Settings.tinOreHardness).setResistance(Settings.tinOreResistance).setUnlocalizedName("tinOre");
		tinBlock = new SimpleOre(config.tinBlockID, Material.iron, "simpleores", SimpleOres.tabSimpleBlocks).setHardness(Settings.tinBlockHardness).setResistance(Settings.tinBlockResistance).setUnlocalizedName("tinBlock"); 
		mythrilOre = new SimpleOre(config.mythrilOreID, Material.rock, "simpleores", SimpleOres.tabSimpleBlocks).setHardness(Settings.mythrilOreHardness).setResistance(Settings.mythrilOreResistance).setUnlocalizedName("mythrilOre");
		mythrilBlock = new SimpleOre(config.mythrilBlockID, Material.iron, "simpleores", SimpleOres.tabSimpleBlocks).setHardness(Settings.mythrilBlockHardness).setResistance(Settings.mythrilBlockResistance).setUnlocalizedName("mythrilBlock");
		adamantiumOre = new SimpleOre(config.adamantiumOreID, Material.rock, "simpleores", SimpleOres.tabSimpleBlocks).setHardness(Settings.adamantiumOreHardness).setResistance(Settings.adamantiumOreResistance).setUnlocalizedName("adamantiumOre");
		adamantiumBlock = new SimpleOre(config.adamantiumBlockID, Material.iron, "simpleores", SimpleOres.tabSimpleBlocks).setHardness(Settings.adamantiumBlockHardness).setResistance(Settings.adamantiumBlockResistance).setUnlocalizedName("adamantiumBlock");
		onyxOre = new SimpleGemOre(config.onyxOreID, Material.rock, "simpleores", config.onyxGemID, SimpleOres.tabSimpleBlocks).setHardness(Settings.onyxOreHardness).setResistance(Settings.onyxOreResistance).setUnlocalizedName("onyxOre");
		onyxBlock = new SimpleOre(config.onyxBlockID, Material.iron, "simpleores", SimpleOres.tabSimpleBlocks).setHardness(Settings.onyxBlockHardness).setResistance(Settings.onyxBlockResistance).setUnlocalizedName("onyxBlock");
		mythrilFurnace = new MythrilFurnace(config.mythrilFurnaceID, false).setHardness(Settings.mythrilFurnaceHardness).setResistance(Settings.mythrilFurnaceResistance).setUnlocalizedName("mythrilFurnace");
		mythrilFurnaceOn = new MythrilFurnace(config.mythrilFurnaceOnID, true).setHardness(Settings.mythrilFurnaceHardness).setLightValue(Settings.mythrilFurnaceLightValue).setResistance(Settings.mythrilFurnaceResistance).setUnlocalizedName("mythrilFurnaceOn");
		onyxFurnace = new OnyxFurnace(config.onyxFurnaceID, false).setHardness(Settings.onyxFurnaceHardness).setResistance(Settings.onyxFurnaceResistance).setUnlocalizedName("onyxFurnace");
		onyxFurnaceOn = new OnyxFurnace(config.onyxFurnaceOnID, true).setHardness(Settings.onyxFurnaceHardness).setResistance(Settings.onyxFurnaceResistance).setLightValue(Settings.onyxFurnaceLightValue).setUnlocalizedName("onyxFurnaceOn");
		copperDoor = new SimpleDoor(config.copperDoorID, "copper").setHardness(Settings.copperDoorHardness).setResistance(Settings.copperDoorResistance).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("copperDoor");
		onyxDoor = new SimpleDoor(config.onyxDoorID, "onyx").setHardness(Settings.onyxDoorHardness).setResistance(Settings.onyxDoorResistance).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("onyxDoor");
		copperBars = new SimpleBars(config.copperBarsID, "simpleores:" + "copperBars", "simpleores:" + "copperBars", Material.iron, true).setHardness(Settings.copperBarsHardness).setResistance(Settings.copperBarsResistance).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("copperBars");
		tinBars = new SimpleBars(config.tinBarsID, "simpleores:" + "tinBars", "simpleores:" + "tinBars", Material.iron, true).setHardness(Settings.tinBarsHardness).setResistance(Settings.tinBarsResistance).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("tinBars");
		mythrilBars = new SimpleBars(config.mythrilBarsID, "simpleores:" + "mythrilBars", "simpleores:" + "mythrilBars", Material.iron, true).setHardness(Settings.mythrilBarsHardness).setResistance(Settings.mythrilBarsResistance).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("mythrilBars");
		adamantiumBars = new SimpleBars(config.adamantiumBarsID, "simpleores:" + "adamantiumBars", "simpleores:" + "adamantiumBars", Material.iron, true).setHardness(Settings.adamantiumBarsHardness).setResistance(Settings.adamantiumBarsResistance).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("adamantiumBars");
	    onyxBars = new SimpleBars(config.onyxBarsID, "simpleores:" + "onyxBars", "simpleores:" + "onyxBars", Material.iron, true).setHardness(Settings.onyxBarsHardness).setResistance(Settings.onyxBarsResistance).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("onyxBars");
	    
		//Block Naming
	    if(Settings.enableOldLocalisation)
	    {
			LanguageRegistry.addName(copperOre, local.copperOreName);
			LanguageRegistry.addName(copperBlock, local.copperBlockName);
			LanguageRegistry.addName(tinOre, local.tinOreName);
			LanguageRegistry.addName(tinBlock, local.tinBlockName);
			LanguageRegistry.addName(mythrilOre, local.mythrilOreName);
			LanguageRegistry.addName(mythrilBlock, local.mythrilBlockName);
			LanguageRegistry.addName(adamantiumOre, local.adamantiumOreName);
			LanguageRegistry.addName(adamantiumBlock, local.adamantiumBlockName);
			LanguageRegistry.addName(onyxOre, local.onyxOreName);
			LanguageRegistry.addName(onyxBlock, local.onyxBlockName);	
			LanguageRegistry.addName(mythrilFurnace, local.mythrilFurnaceName);
			LanguageRegistry.addName(mythrilFurnaceOn, local.mythrilFurnaceOnName);
			LanguageRegistry.addName(onyxFurnace, local.onyxFurnaceName);
			LanguageRegistry.addName(onyxFurnaceOn, local.onyxFurnaceOnName);	
			LanguageRegistry.addName(copperDoor, local.copperDoorName);
			LanguageRegistry.addName(onyxDoor, local.onyxDoorName);
			LanguageRegistry.addName(copperBars, local.copperBarsName);
			LanguageRegistry.addName(tinBars, local.tinBarsName);
			LanguageRegistry.addName(mythrilBars, local.mythrilBarsName);
			LanguageRegistry.addName(adamantiumBars, local.adamantiumBarsName);
			LanguageRegistry.addName(onyxBars, local.onyxBarsName);
	    }
		
		//Block Harvest Levels
        MinecraftForge.setBlockHarvestLevel(copperOre, "pickaxe", Settings.copperOreHarvestLevel);
        MinecraftForge.setBlockHarvestLevel(tinOre, "pickaxe", Settings.tinOreHarvestLevel);
        MinecraftForge.setBlockHarvestLevel(mythrilOre, "pickaxe", Settings.mythrilOreHarvestLevel);
        MinecraftForge.setBlockHarvestLevel(adamantiumOre, "pickaxe", Settings.adamantiumOreHarvestLevel);
        MinecraftForge.setBlockHarvestLevel(onyxOre, "pickaxe", Settings.onyxOreHarvestLevel);
        
		//Block Registering
		GameRegistry.registerBlock(copperOre, "copperOre");
		GameRegistry.registerBlock(copperBlock, "copperBlock");
		GameRegistry.registerBlock(tinOre, "tinOre");
		GameRegistry.registerBlock(tinBlock, "tinBlock");	
		GameRegistry.registerBlock(mythrilOre, "mythrilOre");
		GameRegistry.registerBlock(mythrilBlock, "mythrilBlock");
		GameRegistry.registerBlock(adamantiumOre, "adamantiumOre");
		GameRegistry.registerBlock(adamantiumBlock, "adamantiumBlock");
		GameRegistry.registerBlock(onyxOre, "onyxOre");
		GameRegistry.registerBlock(onyxBlock, "onyxBlock");	
		GameRegistry.registerBlock(mythrilFurnace, "mythrilFurnace");
		GameRegistry.registerBlock(mythrilFurnaceOn, "mythrilFurnaceOn");
		GameRegistry.registerBlock(onyxFurnace, "onyxFurnace");
		GameRegistry.registerBlock(onyxFurnaceOn, "onyxFurnaceOn");		
		GameRegistry.registerBlock(copperDoor, "copperDoor");
		GameRegistry.registerBlock(copperBars, "copperBars");
		GameRegistry.registerBlock(tinBars, "tinBars");
		GameRegistry.registerBlock(mythrilBars, "mythrilBars");
		GameRegistry.registerBlock(adamantiumBars, "adamantiumBars");
		GameRegistry.registerBlock(onyxBars, "onyxBars");
	}
}
