package alexndr.SimpleOres.core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.MinecraftForge;
import alexndr.SimpleOres.api.content.SimpleArmor;
import alexndr.SimpleOres.api.content.SimpleAxe;
import alexndr.SimpleOres.api.content.SimpleHoe;
import alexndr.SimpleOres.api.content.SimpleIngot;
import alexndr.SimpleOres.api.content.SimpleOre;
import alexndr.SimpleOres.api.content.SimplePickaxe;
import alexndr.SimpleOres.api.content.SimpleShovel;
import alexndr.SimpleOres.api.content.SimpleSword;
import alexndr.SimpleOres.api.helpers.LogHelper;
import alexndr.SimpleOres.core.conf.Config;
import alexndr.SimpleOres.core.conf.Settings;
import alexndr.SimpleOres.core.content.MythrilFurnace;
import alexndr.SimpleOres.core.content.OnyxFurnace;
import alexndr.SimpleOres.core.content.SimpleBars;
import alexndr.SimpleOres.core.content.SimpleBow;
import alexndr.SimpleOres.core.content.SimpleBucket;
import alexndr.SimpleOres.core.content.SimpleDoor;
import alexndr.SimpleOres.core.content.SimpleDoorItem;
import alexndr.SimpleOres.core.content.SimpleShears;
import cpw.mods.fml.common.registry.GameRegistry;

public class Content 
{
	public static void initialize()
	{
		try{doItems(); LogHelper.verboseInfo("All items were added successfully.");}
		catch(Exception e){LogHelper.severe("Items were not added successfully. This is a serious problem!"); e.printStackTrace();}
		try{doBlocks(); LogHelper.verboseInfo("All blocks were added successfully.");}
		catch(Exception e){LogHelper.severe("Blocks were not added successfully. This is a serious problem!"); e.printStackTrace();}
		try{doTools(); LogHelper.verboseInfo("All tools were added successfully.");}
		catch(Exception e){LogHelper.severe("Tools were not added successfully. This is a serious problem!"); e.printStackTrace();}
		try{doArmor(); LogHelper.verboseInfo("All armor was added successfully.");}
		catch(Exception e){LogHelper.severe("Armor was not added successfully. This is a serious problem!"); e.printStackTrace();}
		try{doAchievements(); LogHelper.verboseInfo("All achievements were added successfully.");}
		catch(Exception e){LogHelper.severe("Achievements were not added successfully. This is a serious problem!"); e.printStackTrace();}
	}
	
	public static void doBlocks()
	{
		//Block Properties
		copperOre = new SimpleOre(Config.copperOreID, Material.rock).setHardness(Settings.copperOreHardness).setResistance(Settings.copperOreResistance).setUnlocalizedName("copperOre");
		copperBlock = new SimpleOre(Config.copperBlockID, Material.iron).setHardness(Settings.copperBlockHardness).setResistance(Settings.copperBlockResistance).setUnlocalizedName("copperBlock"); 
		tinOre = new SimpleOre(Config.tinOreID, Material.rock).setHardness(Settings.tinOreHardness).setResistance(Settings.tinOreResistance).setUnlocalizedName("tinOre");
		tinBlock = new SimpleOre(Config.tinBlockID, Material.iron).setHardness(Settings.tinBlockHardness).setResistance(Settings.tinBlockResistance).setUnlocalizedName("tinBlock"); 
		mythrilOre = new SimpleOre(Config.mythrilOreID, Material.rock).setHardness(Settings.mythrilOreHardness).setResistance(Settings.mythrilOreResistance).setUnlocalizedName("mythrilOre");
		mythrilBlock = new SimpleOre(Config.mythrilBlockID, Material.iron).setHardness(Settings.mythrilBlockHardness).setResistance(Settings.mythrilBlockResistance).setUnlocalizedName("mythrilBlock");
		adamantiumOre = new SimpleOre(Config.adamantiumOreID, Material.rock).setHardness(Settings.adamantiumOreHardness).setResistance(Settings.adamantiumOreResistance).setUnlocalizedName("adamantiumOre");
		adamantiumBlock = new SimpleOre(Config.adamantiumBlockID, Material.iron).setHardness(Settings.adamantiumBlockHardness).setResistance(Settings.adamantiumBlockResistance).setUnlocalizedName("adamantiumBlock");
		onyxOre = new SimpleOre(Config.onyxOreID, Material.rock).setStackToDrop(new ItemStack(onyxGem)).setHardness(Settings.onyxOreHardness).setResistance(Settings.onyxOreResistance).setUnlocalizedName("onyxOre");
		onyxBlock = new SimpleOre(Config.onyxBlockID, Material.iron).setHardness(Settings.onyxBlockHardness).setResistance(Settings.onyxBlockResistance).setUnlocalizedName("onyxBlock");
		mythrilFurnace = new MythrilFurnace(Config.mythrilFurnaceID, false).setHardness(Settings.mythrilFurnaceHardness).setResistance(Settings.mythrilFurnaceResistance).setUnlocalizedName("mythrilFurnace");
		mythrilFurnaceOn = new MythrilFurnace(Config.mythrilFurnaceOnID, true).setHardness(Settings.mythrilFurnaceHardness).setLightValue(Settings.mythrilFurnaceLightValue).setResistance(Settings.mythrilFurnaceResistance).setUnlocalizedName("mythrilFurnaceOn");
		onyxFurnace = new OnyxFurnace(Config.onyxFurnaceID, false).setHardness(Settings.onyxFurnaceHardness).setResistance(Settings.onyxFurnaceResistance).setUnlocalizedName("onyxFurnace");
		onyxFurnaceOn = new OnyxFurnace(Config.onyxFurnaceOnID, true).setHardness(Settings.onyxFurnaceHardness).setResistance(Settings.onyxFurnaceResistance).setLightValue(Settings.onyxFurnaceLightValue).setUnlocalizedName("onyxFurnaceOn");
		copperDoor = new SimpleDoor(Config.copperDoorID, "copper").setHardness(Settings.copperDoorHardness).setResistance(Settings.copperDoorResistance).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("copperDoor");
		onyxDoor = new SimpleDoor(Config.onyxDoorID, "onyx").setHardness(Settings.onyxDoorHardness).setResistance(Settings.onyxDoorResistance).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("onyxDoor");
		copperBars = new SimpleBars(Config.copperBarsID, "simpleores:" + "copperBars", "simpleores:" + "copperBars", Material.iron, true).setHardness(Settings.copperBarsHardness).setResistance(Settings.copperBarsResistance).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("copperBars");
		tinBars = new SimpleBars(Config.tinBarsID, "simpleores:" + "tinBars", "simpleores:" + "tinBars", Material.iron, true).setHardness(Settings.tinBarsHardness).setResistance(Settings.tinBarsResistance).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("tinBars");
		mythrilBars = new SimpleBars(Config.mythrilBarsID, "simpleores:" + "mythrilBars", "simpleores:" + "mythrilBars", Material.iron, true).setHardness(Settings.mythrilBarsHardness).setResistance(Settings.mythrilBarsResistance).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("mythrilBars");
		adamantiumBars = new SimpleBars(Config.adamantiumBarsID, "simpleores:" + "adamantiumBars", "simpleores:" + "adamantiumBars", Material.iron, true).setHardness(Settings.adamantiumBarsHardness).setResistance(Settings.adamantiumBarsResistance).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("adamantiumBars");
	    onyxBars = new SimpleBars(Config.onyxBarsID, "simpleores:" + "onyxBars", "simpleores:" + "onyxBars", Material.iron, true).setHardness(Settings.onyxBarsHardness).setResistance(Settings.onyxBarsResistance).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("onyxBars");
		
		//Block Registering
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
	    
		//Block Harvest Levels
        MinecraftForge.setBlockHarvestLevel(copperOre, "pickaxe", Settings.copperOreHarvestLevel);
        MinecraftForge.setBlockHarvestLevel(tinOre, "pickaxe", Settings.tinOreHarvestLevel);
        MinecraftForge.setBlockHarvestLevel(mythrilOre, "pickaxe", Settings.mythrilOreHarvestLevel);
        MinecraftForge.setBlockHarvestLevel(adamantiumOre, "pickaxe", Settings.adamantiumOreHarvestLevel);
        MinecraftForge.setBlockHarvestLevel(onyxOre, "pickaxe", Settings.onyxOreHarvestLevel);
	}
	
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
	
	public static void doTools()
	{
		//Tool Details
		copperPick = new SimplePickaxe(Config.copperPickID, SimpleOres.toolCopper).setUnlocalizedName("copperPick");
		copperAxe = new SimpleAxe(Config.copperAxeID, SimpleOres.toolCopper).setUnlocalizedName("copperAxe");
		copperShovel = new SimpleShovel(Config.copperShovelID, SimpleOres.toolCopper).setUnlocalizedName("copperShovel");
		copperSword = new SimpleSword(Config.copperSwordID, SimpleOres.toolCopper).setUnlocalizedName("copperSword");
		copperHoe = new SimpleHoe(Config.copperHoeID, SimpleOres.toolCopper).setUnlocalizedName("copperHoe");
		tinPick = new SimplePickaxe(Config.tinPickID, SimpleOres.toolTin).setUnlocalizedName("tinPick");
		tinAxe = new SimpleAxe(Config.tinAxeID, SimpleOres.toolTin).setUnlocalizedName("tinAxe");
		tinShovel = new SimpleShovel(Config.tinShovelID, SimpleOres.toolTin).setUnlocalizedName("tinShovel");
		tinSword = new SimpleSword(Config.tinSwordID, SimpleOres.toolTin).setUnlocalizedName("tinSword");
		tinHoe = new SimpleHoe(Config.tinHoeID, SimpleOres.toolTin).setUnlocalizedName("tinHoe");
		mythrilPick = new SimplePickaxe(Config.mythrilPickID, SimpleOres.toolMythril).setUnlocalizedName("mythrilPick");
		mythrilAxe = new SimpleAxe(Config.mythrilAxeID, SimpleOres.toolMythril).setUnlocalizedName("mythrilAxe");
		mythrilShovel = new SimpleShovel(Config.mythrilShovelID, SimpleOres.toolMythril).setUnlocalizedName("mythrilShovel");
		mythrilSword = new SimpleSword(Config.mythrilSwordID, SimpleOres.toolMythril).setUnlocalizedName("mythrilSword");
		mythrilHoe = new SimpleHoe(Config.mythrilHoeID, SimpleOres.toolMythril).setUnlocalizedName("mythrilHoe");
		adamantiumPick = new SimplePickaxe(Config.adamantiumPickID, SimpleOres.toolAdamantium).setUnlocalizedName("adamantiumPick");
		adamantiumAxe = new SimpleAxe(Config.adamantiumAxeID, SimpleOres.toolAdamantium).setUnlocalizedName("adamantiumAxe");
		adamantiumShovel = new SimpleShovel(Config.adamantiumShovelID, SimpleOres.toolAdamantium).setUnlocalizedName("adamantiumShovel");
		adamantiumSword = new SimpleSword(Config.adamantiumSwordID, SimpleOres.toolAdamantium).setUnlocalizedName("adamantiumSword");
		adamantiumHoe = new SimpleHoe(Config.adamantiumHoeID, SimpleOres.toolAdamantium).setUnlocalizedName("adamantiumHoe");
		onyxPick = new SimplePickaxe(Config.onyxPickID, SimpleOres.toolOnyx).setUnlocalizedName("onyxPick");
		onyxAxe = new SimpleAxe(Config.onyxAxeID, SimpleOres.toolOnyx).setUnlocalizedName("onyxAxe");
		onyxShovel = new SimpleShovel(Config.onyxShovelID, SimpleOres.toolOnyx).setUnlocalizedName("onyxShovel");
		onyxSword = new SimpleSword(Config.onyxSwordID, SimpleOres.toolOnyx).setUnlocalizedName("onyxSword");
		onyxHoe = new SimpleHoe(Config.onyxHoeID, SimpleOres.toolOnyx).setUnlocalizedName("onyxHoe");		
		mythrilBow = new SimpleBow(Config.mythrilBowID, 750, SimpleOres.toolMythril).setFull3D().setUnlocalizedName("mythrilBow");
		onyxBow = new SimpleBow(Config.onyxBowID, 1000, SimpleOres.toolOnyx).setFull3D().setUnlocalizedName("onyxBow");
		tinShears = new SimpleShears(Config.tinShearsID, 176).setUnlocalizedName("tinShears");
		adamantiumShears = new SimpleShears(Config.adamantiumShearsID, 1092).setUnlocalizedName("adamantiumShears");
		onyxShears = new SimpleShears(Config.onyxShearsID, 3116).setUnlocalizedName("onyxShears");
		
        //Item Registering
        GameRegistry.registerItem(mythrilBow, "mythrilBow");
        GameRegistry.registerItem(onyxBow, "onyxBow");
        GameRegistry.registerItem(tinShears, "tinShears");
        GameRegistry.registerItem(adamantiumShears, "adamantiumShears");
        GameRegistry.registerItem(onyxShears, "onyxShears");
		
		//Tool Registering
        MinecraftForge.setToolClass(copperPick, "pickaxe", Settings.copperMiningLevel);
        MinecraftForge.setToolClass(copperShovel, "shovel", Settings.copperMiningLevel);
        MinecraftForge.setToolClass(copperAxe, "axe", Settings.copperMiningLevel);
        MinecraftForge.setToolClass(tinPick, "pickaxe", Settings.tinMiningLevel);
        MinecraftForge.setToolClass(tinShovel, "shovel", Settings.tinMiningLevel);
        MinecraftForge.setToolClass(tinAxe, "axe", Settings.tinMiningLevel);
        MinecraftForge.setToolClass(mythrilPick, "pickaxe", Settings.mythrilMiningLevel);
        MinecraftForge.setToolClass(mythrilShovel, "shovel", Settings.mythrilMiningLevel);
        MinecraftForge.setToolClass(mythrilAxe, "axe", Settings.mythrilMiningLevel);
        MinecraftForge.setToolClass(adamantiumPick, "pickaxe", Settings.adamantiumMiningLevel);
        MinecraftForge.setToolClass(adamantiumShovel, "shovel", Settings.adamantiumMiningLevel);
        MinecraftForge.setToolClass(adamantiumAxe, "axe", Settings.adamantiumMiningLevel);
        MinecraftForge.setToolClass(onyxPick, "pickaxe", Settings.onyxMiningLevel);
        MinecraftForge.setToolClass(onyxShovel, "shovel", Settings.onyxMiningLevel);
        MinecraftForge.setToolClass(onyxAxe, "axe", Settings.onyxMiningLevel);
	}
	
	public static void doArmor()
	{
        //Armour Details
        copperHelm = new SimpleArmor(Config.copperHelmID, SimpleOres.armorCopper, SimpleOres.rendererCopper, 0).setType("copper").setUnlocalizedName("copperHelm");
		copperChest = new SimpleArmor(Config.copperChestID, SimpleOres.armorCopper, SimpleOres.rendererCopper, 1).setType("copper").setUnlocalizedName("copperChest");
		copperLegs = new SimpleArmor(Config.copperLegsID, SimpleOres.armorCopper, SimpleOres.rendererCopper, 2).setType("copper").setUnlocalizedName("copperLegs");
		copperBoots = new SimpleArmor(Config.copperBootsID, SimpleOres.armorCopper, SimpleOres.rendererCopper, 3).setType("copper").setUnlocalizedName("copperBoots");
        tinHelm = new SimpleArmor(Config.tinHelmID, SimpleOres.armorTin, SimpleOres.rendererTin, 0).setType("tin").setUnlocalizedName("tinHelm");
		tinChest = new SimpleArmor(Config.tinChestID, SimpleOres.armorTin, SimpleOres.rendererTin, 1).setType("tin").setUnlocalizedName("tinChest");
		tinLegs = new SimpleArmor(Config.tinLegsID, SimpleOres.armorTin, SimpleOres.rendererTin, 2).setType("tin").setUnlocalizedName("tinLegs");
		tinBoots = new SimpleArmor(Config.tinBootsID, SimpleOres.armorTin, SimpleOres.rendererTin, 3).setType("tin").setUnlocalizedName("tinBoots");
		mythrilHelm = new SimpleArmor(Config.mythrilHelmID, SimpleOres.armorMythril, SimpleOres.rendererMythril, 0).setType("mythril").setUnlocalizedName("mythrilHelm");
		mythrilChest = new SimpleArmor(Config.mythrilChestID, SimpleOres.armorMythril, SimpleOres.rendererMythril, 1).setType("mythril").setUnlocalizedName("mythrilChest");
		mythrilLegs = new SimpleArmor(Config.mythrilLegsID, SimpleOres.armorMythril, SimpleOres.rendererMythril, 2).setType("mythril").setUnlocalizedName("mythrilLegs");
		mythrilBoots = new SimpleArmor(Config.mythrilBootsID, SimpleOres.armorMythril, SimpleOres.rendererMythril, 3).setType("mythril").setUnlocalizedName("mythrilBoots");
		adamantiumHelm = new SimpleArmor(Config.adamantiumHelmID, SimpleOres.armorAdamantium, SimpleOres.rendererAdamantium, 0).setType("adamantium").setUnlocalizedName("adamantiumHelm");
		adamantiumChest = new SimpleArmor(Config.adamantiumChestID, SimpleOres.armorAdamantium, SimpleOres.rendererAdamantium, 1).setType("adamantium").setUnlocalizedName("adamantiumChest");
		adamantiumLegs = new SimpleArmor(Config.adamantiumLegsID, SimpleOres.armorAdamantium, SimpleOres.rendererAdamantium, 2).setType("adamantium").setUnlocalizedName("adamantiumLegs");
		adamantiumBoots = new SimpleArmor(Config.adamantiumBootsID, SimpleOres.armorAdamantium, SimpleOres.rendererAdamantium, 3).setType("adamantium").setUnlocalizedName("adamantiumBoots");
		onyxHelm = new SimpleArmor(Config.onyxHelmID, SimpleOres.armorOnyx, SimpleOres.rendererOnyx, 0).setType("onyx").setUnlocalizedName("onyxHelm");
		onyxChest = new SimpleArmor(Config.onyxChestID, SimpleOres.armorOnyx, SimpleOres.rendererOnyx, 1).setType("onyx").setUnlocalizedName("onyxChest");
		onyxLegs = new SimpleArmor(Config.onyxLegsID, SimpleOres.armorOnyx, SimpleOres.rendererOnyx, 2).setType("onyx").setUnlocalizedName("onyxLegs");
		onyxBoots = new SimpleArmor(Config.onyxBootsID, SimpleOres.armorOnyx, SimpleOres.rendererOnyx, 3).setType("onyx").setUnlocalizedName("onyxBoots");
	}
	
	public static void doAchievements()
	{
		simpleOresAch = new Achievement(Config.simpleOresAchID, "simpleOresAch", 5, 4, copperOre, AchievementList.buildPickaxe).registerAchievement();
		adamantiumAch = new Achievement(Config.adamantiumAchID, "adamantiumAch", 7, 4, adamantiumOre, simpleOresAch).registerAchievement();
		onyxAch = new Achievement(Config.onyxAchID, "onyxAch", 9, 4, onyxOre, adamantiumAch).setSpecial().registerAchievement();
		ironPickAch = new Achievement(Config.ironPickAchID, "ironPickAch", 8, 2, Item.pickaxeIron, AchievementList.buildBetterPickaxe).registerAchievement();
		adamantiumPickAch = new Achievement(Config.adamantiumPickAchID, "adamantiumPickAch", 10, 2, adamantiumPick, ironPickAch).registerAchievement();
		onyxPickAch = new Achievement(Config.onyxPickAchID, "onyxPickAch", 12, 2, onyxPick, adamantiumPickAch).setSpecial().registerAchievement();
		mythrilBowAch = new Achievement(Config.mythrilBowAchID, "mythrilBowAch", 4, 5, mythrilBow, simpleOresAch).registerAchievement();
		onyxBowAch = new Achievement(Config.onyxBowAchID, "onyxBowAch", 4, 7, onyxBow, simpleOresAch).setSpecial().registerAchievement();
	}
	
	//Blocks
	public static Block copperOre, tinOre, mythrilOre, adamantiumOre, onyxOre;
	public static Block copperBlock, tinBlock, mythrilBlock, adamantiumBlock, onyxBlock;
	public static Block mythrilFurnace, mythrilFurnaceOn, onyxFurnace, onyxFurnaceOn;
	public static Block copperDoor, onyxDoor;
	public static Block copperBars, tinBars, mythrilBars, adamantiumBars, onyxBars;
	
	//Items
	public static Item copperIngot, tinIngot, mythrilIngot, adamantiumIngot, onyxGem;
	public static Item copperBucket, copperBucketWater;
	public static Item mythrilRod, onyxRod;
	public static Item copperDoorItem, onyxDoorItem;
	
	//Tools
	public static Item copperPick, tinPick, mythrilPick, adamantiumPick, onyxPick;
	public static Item copperAxe, tinAxe, mythrilAxe, adamantiumAxe, onyxAxe;
	public static Item copperShovel, tinShovel, mythrilShovel, adamantiumShovel, onyxShovel;
	public static Item copperSword, tinSword, mythrilSword, adamantiumSword, onyxSword;
	public static Item copperHoe, tinHoe, mythrilHoe, adamantiumHoe, onyxHoe;
	public static Item mythrilBow, onyxBow;
	public static Item tinShears, adamantiumShears, onyxShears;
	
	//Armor
	public static Item copperHelm, tinHelm, mythrilHelm, adamantiumHelm, onyxHelm;
	public static Item copperChest, tinChest, mythrilChest, adamantiumChest, onyxChest;
	public static Item copperLegs, tinLegs, mythrilLegs, adamantiumLegs, onyxLegs;
	public static Item copperBoots, tinBoots, mythrilBoots, adamantiumBoots, onyxBoots;
	
	//Achievements
	public static Achievement simpleOresAch, adamantiumAch, onyxAch, ironPickAch;
	public static Achievement adamantiumPickAch, onyxPickAch, mythrilBowAch, onyxBowAch;
}
