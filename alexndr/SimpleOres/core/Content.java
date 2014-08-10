package alexndr.SimpleOres.core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import alexndr.SimpleOres.api.content.SimpleArmor;
import alexndr.SimpleOres.api.content.SimpleAxe;
import alexndr.SimpleOres.api.content.SimpleHoe;
import alexndr.SimpleOres.api.content.SimpleIngot;
import alexndr.SimpleOres.api.content.SimpleBlock;
import alexndr.SimpleOres.api.content.SimplePickaxe;
import alexndr.SimpleOres.api.content.SimpleShovel;
import alexndr.SimpleOres.api.content.SimpleSword;
import alexndr.SimpleOres.api.helpers.LogHelper;
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
		copper_ore = new SimpleBlock(Material.rock).setHardness(Settings.copperOreHardness).setResistance(Settings.copperOreResistance).setBlockName("copper_ore");
		copper_block = new SimpleBlock(Material.iron).setAsBeaconBase(true).setHardness(Settings.copperBlockHardness).setResistance(Settings.copperBlockResistance).setBlockName("copper_block"); 
		tin_ore = new SimpleBlock(Material.rock).setHardness(Settings.tinOreHardness).setResistance(Settings.tinOreResistance).setBlockName("tin_ore");
		tin_block = new SimpleBlock(Material.iron).setAsBeaconBase(true).setHardness(Settings.tinBlockHardness).setResistance(Settings.tinBlockResistance).setBlockName("tin_block"); 
		mythril_ore = new SimpleBlock(Material.rock).setHardness(Settings.mythrilOreHardness).setResistance(Settings.mythrilOreResistance).setBlockName("mythril_ore");
		mythril_block = new SimpleBlock(Material.iron).setAsBeaconBase(true).setHardness(Settings.mythrilBlockHardness).setResistance(Settings.mythrilBlockResistance).setBlockName("mythril_block");
		adamantium_ore = new SimpleBlock(Material.rock).setHardness(Settings.adamantiumOreHardness).setResistance(Settings.adamantiumOreResistance).setBlockName("adamantium_ore");
		adamantium_block = new SimpleBlock(Material.iron).setAsBeaconBase(true).setHardness(Settings.adamantiumBlockHardness).setResistance(Settings.adamantiumBlockResistance).setBlockName("adamantium_block");
		onyx_ore = new SimpleBlock(Material.rock).setStackToDrop(new ItemStack(onyx_gem)).setHardness(Settings.onyxOreHardness).setResistance(Settings.onyxOreResistance).setBlockName("onyx_ore");
		onyx_block = new SimpleBlock(Material.iron).setAsBeaconBase(true).setHardness(Settings.onyxBlockHardness).setResistance(Settings.onyxBlockResistance).setBlockName("onyx_block");
		mythril_furnace = new MythrilFurnace(false).setHardness(Settings.mythrilFurnaceHardness).setResistance(Settings.mythrilFurnaceResistance).setBlockName("mythril_furnace");
		mythril_furnace_lit = new MythrilFurnace(true).setHardness(Settings.mythrilFurnaceHardness).setLightLevel(Settings.mythrilFurnaceLightValue).setResistance(Settings.mythrilFurnaceResistance).setBlockName("mythril_furnace_lit");
		onyx_furnace = new OnyxFurnace(false).setHardness(Settings.onyxFurnaceHardness).setResistance(Settings.onyxFurnaceResistance).setBlockName("onyx_furnace");
		onyx_furnace_lit = new OnyxFurnace(true).setHardness(Settings.onyxFurnaceHardness).setResistance(Settings.onyxFurnaceResistance).setLightLevel(Settings.onyxFurnaceLightValue).setBlockName("onyx_furnace_lit");
		copper_door_block = new SimpleDoor("copper").setHardness(Settings.copperDoorHardness).setResistance(Settings.copperDoorResistance).setStepSound(Block.soundTypeMetal).setBlockName("copper_door_block");
		onyx_door_block = new SimpleDoor("onyx").setHardness(Settings.onyxDoorHardness).setResistance(Settings.onyxDoorResistance).setStepSound(Block.soundTypeMetal).setBlockName("onyx_door_block");
		copper_bars = new SimpleBars("simpleores:" + "copper_bars", "simpleores:" + "copper_bars", Material.iron, true).setHardness(Settings.copperBarsHardness).setResistance(Settings.copperBarsResistance).setStepSound(Block.soundTypeMetal).setBlockName("copper_bars");
		tin_bars = new SimpleBars("simpleores:" + "tin_bars", "simpleores:" + "tin_bars", Material.iron, true).setHardness(Settings.tinBarsHardness).setResistance(Settings.tinBarsResistance).setStepSound(Block.soundTypeMetal).setBlockName("tin_bars");
		mythril_bars = new SimpleBars("simpleores:" + "mythril_bars", "simpleores:" + "mythril_bars", Material.iron, true).setHardness(Settings.mythrilBarsHardness).setResistance(Settings.mythrilBarsResistance).setStepSound(Block.soundTypeMetal).setBlockName("mythril_bars");
		adamantium_bars = new SimpleBars("simpleores:" + "adamantium_bars", "simpleores:" + "adamantium_bars", Material.iron, true).setHardness(Settings.adamantiumBarsHardness).setResistance(Settings.adamantiumBarsResistance).setStepSound(Block.soundTypeMetal).setBlockName("adamantium_bars");
	    onyx_bars = new SimpleBars("simpleores:" + "onyx_bars", "simpleores:" + "onyx_bars", Material.iron, true).setHardness(Settings.onyxBarsHardness).setResistance(Settings.onyxBarsResistance).setStepSound(Block.soundTypeMetal).setBlockName("onyx_bars");
		
		//Block Registering
		GameRegistry.registerBlock(mythril_furnace, "mythril_furnace");
		GameRegistry.registerBlock(mythril_furnace_lit, "mythril_furnace_lit");
		GameRegistry.registerBlock(onyx_furnace, "onyx_furnace");
		GameRegistry.registerBlock(onyx_furnace_lit, "onyx_furnace_lit");
		GameRegistry.registerBlock(copper_door_block, "copper_door_block");
		GameRegistry.registerBlock(onyx_door_block, "onyx_door_block");
		GameRegistry.registerBlock(copper_bars, "copper_bars");
		GameRegistry.registerBlock(tin_bars, "tin_bars");
		GameRegistry.registerBlock(mythril_bars, "mythril_bars");
		GameRegistry.registerBlock(adamantium_bars, "adamantium_bars");
		GameRegistry.registerBlock(onyx_bars, "onyx_bars");
	    
		//Block Harvest Levels
		copper_ore.setHarvestLevel("pickaxe", Settings.copperOreHarvestLevel);
		tin_ore.setHarvestLevel("pickaxe", Settings.tinOreHarvestLevel);
		mythril_ore.setHarvestLevel("pickaxe", Settings.mythrilOreHarvestLevel);
		adamantium_ore.setHarvestLevel("pickaxe", Settings.adamantiumOreHarvestLevel);
		onyx_ore.setHarvestLevel("pickaxe", Settings.onyxOreHarvestLevel);
	}
	
	public static void doItems()
	{
		//Item Details
        copper_ingot = new SimpleIngot().setUnlocalizedName("copper_ingot");
		tin_ingot = new SimpleIngot().setUnlocalizedName("tin_ingot");
		mythril_ingot = new SimpleIngot().setUnlocalizedName("mythril_ingot");
		adamantium_ingot = new SimpleIngot().setUnlocalizedName("adamantium_ingot");
		onyx_gem = new SimpleIngot().setUnlocalizedName("onyx_gem");
		copper_bucket = new SimpleBucket(Blocks.air).setUnlocalizedName("copper_bucket").setMaxStackSize(16);
		copper_bucket_water = new SimpleBucket(Blocks.flowing_water).setContainerItem(copper_bucket).setUnlocalizedName("copper_bucket_water");
		mythril_rod = new SimpleIngot().setUnlocalizedName("mythril_rod");
		onyx_rod = new SimpleIngot().setUnlocalizedName("onyx_rod");
		copper_door = new SimpleDoorItem("copper").setUnlocalizedName("copper_door");
		onyx_door = new SimpleDoorItem("onyx").setUnlocalizedName("onyx_door");
		
		//Register Items
		GameRegistry.registerItem(copper_bucket, "copper_bucket");
		GameRegistry.registerItem(copper_bucket_water, "copper_bucket_water");
		GameRegistry.registerItem(copper_door, "copper_door");
		GameRegistry.registerItem(onyx_door, "onyx_door");
	}
	
	public static void doTools()
	{
		//Tool Details
		copper_pickaxe = new SimplePickaxe(SimpleOres.toolCopper).setUnlocalizedName("copper_pickaxe");
		copper_axe = new SimpleAxe(SimpleOres.toolCopper).setUnlocalizedName("copper_axe");
		copper_shovel = new SimpleShovel(SimpleOres.toolCopper).setUnlocalizedName("copper_shovel");
		copper_sword = new SimpleSword(SimpleOres.toolCopper).setUnlocalizedName("copper_sword");
		copper_hoe = new SimpleHoe(SimpleOres.toolCopper).setUnlocalizedName("copper_hoe");
		tin_pickaxe = new SimplePickaxe(SimpleOres.toolTin).setUnlocalizedName("tin_pickaxe");
		tin_axe = new SimpleAxe(SimpleOres.toolTin).setUnlocalizedName("tin_axe");
		tin_shovel = new SimpleShovel(SimpleOres.toolTin).setUnlocalizedName("tin_shovel");
		tin_sword = new SimpleSword(SimpleOres.toolTin).setUnlocalizedName("tin_sword");
		tin_hoe = new SimpleHoe(SimpleOres.toolTin).setUnlocalizedName("tin_hoe");
		mythril_pickaxe = new SimplePickaxe(SimpleOres.toolMythril).setUnlocalizedName("mythril_pickaxe");
		mythril_axe = new SimpleAxe(SimpleOres.toolMythril).setUnlocalizedName("mythril_axe");
		mythril_shovel = new SimpleShovel(SimpleOres.toolMythril).setUnlocalizedName("mythril_shovel");
		mythril_sword = new SimpleSword(SimpleOres.toolMythril).setUnlocalizedName("mythril_sword");
		mythril_hoe = new SimpleHoe(SimpleOres.toolMythril).setUnlocalizedName("mythril_hoe");
		adamantium_pickaxe = new SimplePickaxe(SimpleOres.toolAdamantium).setUnlocalizedName("adamantium_pickaxe");
		adamantium_axe = new SimpleAxe(SimpleOres.toolAdamantium).setUnlocalizedName("adamantium_axe");
		adamantium_shovel = new SimpleShovel(SimpleOres.toolAdamantium).setUnlocalizedName("adamantium_shovel");
		adamantium_sword = new SimpleSword(SimpleOres.toolAdamantium).setUnlocalizedName("adamantium_sword");
		adamantium_hoe = new SimpleHoe(SimpleOres.toolAdamantium).setUnlocalizedName("adamantium_hoe");
		onyx_pickaxe = new SimplePickaxe(SimpleOres.toolOnyx).setUnlocalizedName("onyx_pickaxe");
		onyx_axe = new SimpleAxe(SimpleOres.toolOnyx).setUnlocalizedName("onyx_axe");
		onyx_shovel = new SimpleShovel(SimpleOres.toolOnyx).setUnlocalizedName("onyx_shovel");
		onyx_sword = new SimpleSword(SimpleOres.toolOnyx).setUnlocalizedName("onyx_sword");
		onyx_hoe = new SimpleHoe(SimpleOres.toolOnyx).setUnlocalizedName("onyx_hoe");		
		mythril_bow = new SimpleBow(750, SimpleOres.toolMythril).setFull3D().setUnlocalizedName("mythril_bow");
		onyx_bow = new SimpleBow(1000, SimpleOres.toolOnyx).setFull3D().setUnlocalizedName("onyx_bow");
		tin_shears = new SimpleShears(176).setUnlocalizedName("tin_shears");
		adamantium_shears = new SimpleShears(1092).setUnlocalizedName("adamantium_shears");
		onyx_shears = new SimpleShears(3116).setUnlocalizedName("onyx_shears");
		
        //Item Registering
        GameRegistry.registerItem(mythril_bow, "mythril_bow");
        GameRegistry.registerItem(onyx_bow, "onyx_bow");
        GameRegistry.registerItem(tin_shears, "tin_shears");
        GameRegistry.registerItem(adamantium_shears, "adamantium_shears");
        GameRegistry.registerItem(onyx_shears, "onyx_shears");
	}
	
	public static void doArmor()
	{
        //Armour Details
        copper_helmet = new SimpleArmor(SimpleOres.armorCopper, SimpleOres.rendererCopper, 0).setType("copper").setUnlocalizedName("copper_helmet");
		copper_chestplate = new SimpleArmor(SimpleOres.armorCopper, SimpleOres.rendererCopper, 1).setType("copper").setUnlocalizedName("copper_chestplate");
		copper_leggings = new SimpleArmor(SimpleOres.armorCopper, SimpleOres.rendererCopper, 2).setType("copper").setUnlocalizedName("copper_leggings");
		copper_boots = new SimpleArmor(SimpleOres.armorCopper, SimpleOres.rendererCopper, 3).setType("copper").setUnlocalizedName("copper_boots");
        tin_helmet = new SimpleArmor(SimpleOres.armorTin, SimpleOres.rendererTin, 0).setType("tin").setUnlocalizedName("tin_helmet");
		tin_chestplate = new SimpleArmor(SimpleOres.armorTin, SimpleOres.rendererTin, 1).setType("tin").setUnlocalizedName("tin_chestplate");
		tin_leggings = new SimpleArmor(SimpleOres.armorTin, SimpleOres.rendererTin, 2).setType("tin").setUnlocalizedName("tin_leggings");
		tin_boots = new SimpleArmor(SimpleOres.armorTin, SimpleOres.rendererTin, 3).setType("tin").setUnlocalizedName("tin_boots");
		mythril_helmet = new SimpleArmor(SimpleOres.armorMythril, SimpleOres.rendererMythril, 0).setType("mythril").setUnlocalizedName("mythril_helmet");
		mythril_chestplate = new SimpleArmor(SimpleOres.armorMythril, SimpleOres.rendererMythril, 1).setType("mythril").setUnlocalizedName("mythril_chestplate");
		mythril_leggings = new SimpleArmor(SimpleOres.armorMythril, SimpleOres.rendererMythril, 2).setType("mythril").setUnlocalizedName("mythril_leggings");
		mythril_boots = new SimpleArmor(SimpleOres.armorMythril, SimpleOres.rendererMythril, 3).setType("mythril").setUnlocalizedName("mythril_boots");
		adamantium_helmet = new SimpleArmor(SimpleOres.armorAdamantium, SimpleOres.rendererAdamantium, 0).setType("adamantium").setUnlocalizedName("adamantium_helmet");
		adamantium_chestplate = new SimpleArmor(SimpleOres.armorAdamantium, SimpleOres.rendererAdamantium, 1).setType("adamantium").setUnlocalizedName("adamantium_chestplate");
		adamantium_leggings = new SimpleArmor(SimpleOres.armorAdamantium, SimpleOres.rendererAdamantium, 2).setType("adamantium").setUnlocalizedName("adamantium_leggings");
		adamantium_boots = new SimpleArmor(SimpleOres.armorAdamantium, SimpleOres.rendererAdamantium, 3).setType("adamantium").setUnlocalizedName("adamantium_boots");
		onyx_helmet = new SimpleArmor(SimpleOres.armorOnyx, SimpleOres.rendererOnyx, 0).setType("onyx").setUnlocalizedName("onyx_helmet");
		onyx_chestplate = new SimpleArmor(SimpleOres.armorOnyx, SimpleOres.rendererOnyx, 1).setType("onyx").setUnlocalizedName("onyx_chestplate");
		onyx_leggings = new SimpleArmor(SimpleOres.armorOnyx, SimpleOres.rendererOnyx, 2).setType("onyx").setUnlocalizedName("onyx_leggings");
		onyx_boots = new SimpleArmor(SimpleOres.armorOnyx, SimpleOres.rendererOnyx, 3).setType("onyx").setUnlocalizedName("onyx_boots");
	}
	
	public static void doAchievements()
	{
		simpleOresAch = new Achievement("achievement.simpleOresAch", "simpleOresAch", 5, 4, copper_ore, AchievementList.buildPickaxe).registerStat();
		adamantiumAch = new Achievement("achievement.adamantiumAch", "adamantiumAch", 7, 4, adamantium_ore, simpleOresAch).registerStat();
		onyxAch = new Achievement("achievement.onyxAch", "onyxAch", 9, 4, onyx_ore, adamantiumAch).setSpecial().registerStat();
		ironPickAch = new Achievement("achievement.ironPickAch", "ironPickAch", 8, 2, Items.iron_pickaxe, AchievementList.buildBetterPickaxe).registerStat();
		adamantiumPickAch = new Achievement("achievement.adamantiumPickAch", "adamantiumPickAch", 10, 2, adamantium_pickaxe, ironPickAch).registerStat();
		onyxPickAch = new Achievement("achievement.onyxPickAch", "onyxPickAch", 12, 2, onyx_pickaxe, adamantiumPickAch).setSpecial().registerStat();
		mythrilBowAch = new Achievement("achievement.mythrilBowAch", "mythrilBowAch", 4, 5, mythril_bow, simpleOresAch).registerStat();
		onyxBowAch = new Achievement("achievement.onyxBowAch", "onyxBowAch", 4, 7, onyx_bow, simpleOresAch).setSpecial().registerStat();
	}
	
	//Blocks
	public static Block copper_ore, tin_ore, mythril_ore, adamantium_ore, onyx_ore;
	public static Block copper_block, tin_block, mythril_block, adamantium_block, onyx_block;
	public static Block mythril_furnace, mythril_furnace_lit, onyx_furnace, onyx_furnace_lit;
	public static Block copper_door_block, onyx_door_block;
	public static Block copper_bars, tin_bars, mythril_bars, adamantium_bars, onyx_bars;
	
	//Items
	public static Item copper_ingot, tin_ingot, mythril_ingot, adamantium_ingot, onyx_gem;
	public static Item copper_bucket, copper_bucket_water;
	public static Item mythril_rod, onyx_rod;
	public static Item copper_door, onyx_door;
	
	//Tools
	public static Item copper_pickaxe, tin_pickaxe, mythril_pickaxe, adamantium_pickaxe, onyx_pickaxe;
	public static Item copper_axe, tin_axe, mythril_axe, adamantium_axe, onyx_axe;
	public static Item copper_shovel, tin_shovel, mythril_shovel, adamantium_shovel, onyx_shovel;
	public static Item copper_sword, tin_sword, mythril_sword, adamantium_sword, onyx_sword;
	public static Item copper_hoe, tin_hoe, mythril_hoe, adamantium_hoe, onyx_hoe;
	public static Item mythril_bow, onyx_bow;
	public static Item tin_shears, adamantium_shears, onyx_shears;
	
	//Armor
	public static Item copper_helmet, tin_helmet, mythril_helmet, adamantium_helmet, onyx_helmet;
	public static Item copper_chestplate, tin_chestplate, mythril_chestplate, adamantium_chestplate, onyx_chestplate;
	public static Item copper_leggings, tin_leggings, mythril_leggings, adamantium_leggings, onyx_leggings;
	public static Item copper_boots, tin_boots, mythril_boots, adamantium_boots, onyx_boots;
	
	//Achievements
	public static Achievement simpleOresAch, adamantiumAch, onyxAch, ironPickAch;
	public static Achievement adamantiumPickAch, onyxPickAch, mythrilBowAch, onyxBowAch;
}
