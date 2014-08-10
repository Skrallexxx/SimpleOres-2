package alexndr.SimpleOres.plugins.netherrocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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
import cpw.mods.fml.common.registry.GameRegistry;

public class Content 
{
	public static void initialize()
	{
		try{doItems(); LogHelper.verboseInfo("Netherrocks Plugin: All items were added successfully.");}
		catch(Exception e){LogHelper.severe("Netherrocks Plugin: Items were not added successfully. This is a serious problem!"); e.printStackTrace();}
		try{doBlocks(); LogHelper.verboseInfo("Netherrocks Plugin: All blocks were added successfully.");}
		catch(Exception e){LogHelper.severe("Netherrocks Plugin: Blocks were not added successfully. This is a serious problem!"); e.printStackTrace();}
		try{doTools(); LogHelper.verboseInfo("Netherrocks Plugin: All tools were added successfully.");}
		catch(Exception e){LogHelper.severe("Netherrocks Plugin: Tools were not added successfully. This is a serious problem!"); e.printStackTrace();}
		try{doArmor(); LogHelper.verboseInfo("Netherrocks Plugin: All armor was added successfully.");}
		catch(Exception e){LogHelper.severe("Netherrocks Plugin: Armor was not added successfully. This is a serious problem!"); e.printStackTrace();}
		try{doAchievements(); LogHelper.verboseInfo("Netherrocks Plugin: All achievements were added successfully.");}
		catch(Exception e){LogHelper.severe("Netherrocks Plugin: Achievements were not added successfully. This is a serious problem!"); e.printStackTrace();}
	}
	public static void doBlocks()
	{
		//Block Details
		fyrite_ore = new SimpleBlock(Material.rock).modId("netherrocks").setHardness(Settings.fyriteOreHardness).setResistance(Settings.fyriteOreResistance).setBlockName("fyrite_ore");
		fyrite_block = new SimpleBlock(Material.iron).setAsBeaconBase(true).modId("netherrocks").setHardness(Settings.fyriteBlockHardness).setResistance(Settings.fyriteBlockResistance).setBlockName("fyrite_block");
		malachite_ore = new SimpleBlock(Material.rock).modId("netherrocks").setHardness(Settings.malachiteOreHardness).setResistance(Settings.malachiteOreResistance).setBlockName("malachite_ore");
		malachite_block = new SimpleBlock(Material.iron).setAsBeaconBase(true).modId("netherrocks").setHardness(Settings.malachiteBlockHardness).setResistance(Settings.malachiteBlockResistance).setBlockName("malachite_block");
		ashstone_ore = new SimpleBlock(Material.rock).modId("netherrocks").setStackToDrop(new ItemStack(Content.ashstone_gem)).setHardness(Settings.ashstoneOreHardness).setResistance(Settings.ashstoneOreResistance).setBlockName("ashstone_ore");
		ashstone_block = new SimpleBlock(Material.iron).setAsBeaconBase(true).modId("netherrocks").setHardness(Settings.ashstoneBlockHardness).setResistance(Settings.ashstoneBlockResistance).setBlockName("ashstone_block");
		illumenite_ore = new SimpleBlock(Material.rock).modId("netherrocks").setHardness(Settings.illumeniteOreHardness).setResistance(Settings.illumeniteOreResistance).setLightLevel(Settings.illumeniteOreLightValue).setBlockName("illumenite_ore");
		illumenite_block = new SimpleBlock(Material.iron).setAsBeaconBase(true).modId("netherrocks").setHardness(Settings.illumeniteBlockHardness).setResistance(Settings.illumeniteBlockResistance).setLightLevel(Settings.illumeniteBlockLightValue).setBlockName("illumenite_block");
		dragonstone_ore = new SimpleBlock(Material.rock).modId("netherrocks").setStackToDrop(new ItemStack(Content.dragonstone_gem)).setHardness(Settings.dragonstoneOreHardness).setResistance(Settings.dragonstoneOreResistance).setBlockName("dragonstone_ore");
		dragonstone_block = new SimpleBlock(Material.iron).setAsBeaconBase(true).modId("netherrocks").setHardness(Settings.dragonstoneBlockHardness).setResistance(Settings.dragonstoneBlockResistance).setBlockName("dragonstone_block");
		argonite_ore = new SimpleBlock(Material.rock).modId("netherrocks").setHardness(Settings.argoniteOreHardness).setResistance(Settings.argoniteOreResistance).setBlockName("argonite_ore");
		argonite_block = new SimpleBlock(Material.iron).setAsBeaconBase(true).modId("netherrocks").setHardness(Settings.argoniteBlockHardness).setResistance(Settings.argoniteBlockResistance).setBlockName("argonite_block");
		nether_furnace = new NetherFurnace(false).setHardness(Settings.netherFurnaceHardness).setResistance(Settings.netherFurnaceResistance).setBlockName("nether_furnace");
		nether_furnace_lit = new NetherFurnace(true).setHardness(Settings.netherFurnaceHardness).setResistance(Settings.netherFurnaceResistance).setLightLevel(Settings.netherFurnaceLightValue).setBlockName("nether_furnace_lit");
		
		//Block Registering
		GameRegistry.registerBlock(nether_furnace, "nether_furnace");
		GameRegistry.registerBlock(nether_furnace_lit, "nether_furnace_lit");
		
		//Block Harvest Levels
		fyrite_ore.setHarvestLevel("pickaxe", Settings.fyriteOreHarvestLevel);
		malachite_ore.setHarvestLevel("pickaxe", Settings.malachiteOreHarvestLevel);
		ashstone_ore.setHarvestLevel("pickaxe", Settings.ashstoneOreHarvestLevel);
		illumenite_ore.setHarvestLevel("pickaxe", Settings.illumeniteOreHarvestLevel);
		dragonstone_ore.setHarvestLevel("pickaxe", Settings.dragonstoneOreHarvestLevel);
		argonite_ore.setHarvestLevel("pickaxe", Settings.argoniteOreHarvestLevel);
	}
	
	public static void doItems()
	{
		//Item Details
		fyrite_ingot = new SimpleIngot().modId("netherrocks").setUnlocalizedName("fyrite_ingot");
		malachite_ingot = new SimpleIngot().modId("netherrocks").setUnlocalizedName("malachite_ingot");
		ashstone_gem = new SimpleIngot().modId("netherrocks").setUnlocalizedName("ashstone_gem");
		illumenite_ingot = new SimpleIngot().modId("netherrocks").setUnlocalizedName("illumenite_ingot");
		dragonstone_gem = new SimpleIngot().modId("netherrocks").setUnlocalizedName("dragonstone_gem");
		argonite_ingot = new SimpleIngot().modId("netherrocks").setUnlocalizedName("argonite_ingot");
	}
	
	public static void doTools()
	{
		//Tool Details
		malachite_pickaxe = new SimplePickaxe(Netherrocks.toolMalachite).modId("netherrocks").setUnlocalizedName("malachite_pickaxe");
		malachite_axe = new SimpleAxe(Netherrocks.toolMalachite).modId("netherrocks").setUnlocalizedName("malachite_axe");
		malachite_shovel = new SimpleShovel(Netherrocks.toolMalachite).modId("netherrocks").setUnlocalizedName("malachite_shovel");
		malachite_hoe = new SimpleHoe(Netherrocks.toolMalachite).modId("netherrocks").setUnlocalizedName("malachite_hoe");
		malachite_sword = new SimpleSword(Netherrocks.toolMalachite).modId("netherrocks").setUnlocalizedName("malachite_sword");
		ashstone_pickaxe = new SimplePickaxe(Netherrocks.toolAshstone).modId("netherrocks").setUnlocalizedName("ashstone_pickaxe");
		ashstone_axe = new SimpleAxe(Netherrocks.toolAshstone).modId("netherrocks").setUnlocalizedName("ashstone_axe");
		ashstone_shovel = new SimpleShovel(Netherrocks.toolAshstone).modId("netherrocks").setUnlocalizedName("ashstone_shovel");
		ashstone_hoe = new SimpleHoe(Netherrocks.toolAshstone).modId("netherrocks").setUnlocalizedName("ashstone_hoe");
		ashstone_sword = new SimpleSword(Netherrocks.toolAshstone).modId("netherrocks").setUnlocalizedName("ashstone_sword");
		dragonstone_pickaxe = new SimplePickaxe(Netherrocks.toolDragonstone).modId("netherrocks").setUnlocalizedName("dragonstone_pickaxe");
		dragonstone_axe = new SimpleAxe(Netherrocks.toolDragonstone).modId("netherrocks").setUnlocalizedName("dragonstone_axe");
		dragonstone_shovel = new SimpleShovel(Netherrocks.toolDragonstone).modId("netherrocks").setUnlocalizedName("dragonstone_shovel");
		dragonstone_hoe = new SimpleHoe(Netherrocks.toolDragonstone).modId("netherrocks").setUnlocalizedName("dragonstone_hoe");
		dragonstone_sword = new SimpleSword(Netherrocks.toolDragonstone).modId("netherrocks").setUnlocalizedName("dragonstone_sword");
		argonite_pickaxe = new SimplePickaxe(Netherrocks.toolArgonite).modId("netherrocks").setUnlocalizedName("argonite_pickaxe");
		argonite_axe = new SimpleAxe(Netherrocks.toolArgonite).modId("netherrocks").setUnlocalizedName("argonite_axe");
		argonite_shovel = new SimpleShovel(Netherrocks.toolArgonite).modId("netherrocks").setUnlocalizedName("argonite_shovel");
		argonite_hoe = new SimpleHoe(Netherrocks.toolArgonite).modId("netherrocks").setUnlocalizedName("argonite_hoe");
		argonite_sword = new SimpleSword(Netherrocks.toolArgonite).modId("netherrocks").setUnlocalizedName("argonite_sword");
		fyrite_sword = new NetherSword(Netherrocks.toolFyrite).setUnlocalizedName("fyrite_sword");
		illumenite_sword = new NetherSword(Netherrocks.toolIllumenite).setUnlocalizedName("illumenite_sword");
		fyrite_pickaxe = new NetherPickaxe(Netherrocks.toolFyrite).setUnlocalizedName("fyrite_pickaxe");
	}
	
	public static void doArmor()
	{
		fyrite_helmet = new SimpleArmor(Netherrocks.armorFyrite, Netherrocks.rendererFyrite, 0).modId("netherrocks").setType("fyrite").addInfo("netherrocks.fyriteArmor.info").setUnlocalizedName("fyrite_helmet");
		fyrite_chestplate = new SimpleArmor(Netherrocks.armorFyrite, Netherrocks.rendererFyrite, 1).modId("netherrocks").setType("fyrite").addInfo("netherrocks.fyriteArmor.info").setUnlocalizedName("fyrite_chestplate");
		fyrite_leggings = new SimpleArmor(Netherrocks.armorFyrite, Netherrocks.rendererFyrite, 2).modId("netherrocks").setType("fyrite").addInfo("netherrocks.fyriteArmor.info").setUnlocalizedName("fyrite_leggings");
		fyrite_boots = new SimpleArmor(Netherrocks.armorFyrite, Netherrocks.rendererFyrite, 3).modId("netherrocks").setType("fyrite").addInfo("netherrocks.fyriteArmor.info").setUnlocalizedName("fyrite_boots");
		malachite_helmet = new SimpleArmor(Netherrocks.armorMalachite, Netherrocks.rendererMalachite, 0).modId("netherrocks").setType("malachite").addInfo("netherrocks.malachiteArmor.info").setUnlocalizedName("malachite_helmet");
		malachite_chestplate = new SimpleArmor(Netherrocks.armorMalachite, Netherrocks.rendererMalachite, 1).modId("netherrocks").setType("malachite").addInfo("netherrocks.malachiteArmor.info").setUnlocalizedName("malachite_chestplate");
		malachite_leggings = new SimpleArmor(Netherrocks.armorMalachite, Netherrocks.rendererMalachite, 2).modId("netherrocks").setType("malachite").addInfo("netherrocks.malachiteArmor.info").setUnlocalizedName("malachite_leggings");
		malachite_boots = new SimpleArmor(Netherrocks.armorMalachite, Netherrocks.rendererMalachite, 3).modId("netherrocks").setType("malachite").addInfo("netherrocks.malachiteArmor.info").setUnlocalizedName("malachite_boots");
		illumenite_helmet = new SimpleArmor(Netherrocks.armorIllumenite, Netherrocks.rendererIllumenite, 0).modId("netherrocks").setType("illumenite").addInfo("netherrocks.illumeniteArmor.info").setUnlocalizedName("illumenite_helmet");
		illumenite_chestplate = new SimpleArmor(Netherrocks.armorIllumenite, Netherrocks.rendererIllumenite, 1).modId("netherrocks").setType("illumenite").addInfo("netherrocks.illumeniteArmor.info").setUnlocalizedName("illumenite_chestplate");
		illumenite_leggings = new SimpleArmor(Netherrocks.armorIllumenite, Netherrocks.rendererIllumenite, 2).modId("netherrocks").setType("illumenite").addInfo("netherrocks.illumeniteArmor.info").setUnlocalizedName("illumenite_leggings");
		illumenite_boots = new SimpleArmor(Netherrocks.armorIllumenite, Netherrocks.rendererIllumenite, 3).modId("netherrocks").setType("illumenite").addInfo("netherrocks.illumeniteArmor.info").setUnlocalizedName("illumenite_boots");
		dragonstone_helmet = new SimpleArmor(Netherrocks.armorDragonstone, Netherrocks.rendererDragonstone, 0).modId("netherrocks").setType("dragonstone").setUnlocalizedName("dragonstone_helmet");
		dragonstone_chestplate = new SimpleArmor(Netherrocks.armorDragonstone, Netherrocks.rendererDragonstone, 1).modId("netherrocks").setType("dragonstone").setUnlocalizedName("dragonstone_chestplate");
		dragonstone_leggings = new SimpleArmor(Netherrocks.armorDragonstone, Netherrocks.rendererDragonstone, 2).modId("netherrocks").setType("dragonstone").setUnlocalizedName("dragonstone_leggings");
		dragonstone_boots = new SimpleArmor(Netherrocks.armorDragonstone, Netherrocks.rendererDragonstone, 3).modId("netherrocks").setType("dragonstone").setUnlocalizedName("dragonstone_boots");
	}
	
	public static void doAchievements()
	{
		netherRocksAch = new Achievement("achievement.netherRocksAch", "netherRocksAch", 1, 7, Content.fyrite_ore, AchievementList.portal).registerStat();
		netherFurnaceAch = new Achievement("achievement.netherFurnaceAch", "netherFurnaceAch", 1, 6, Content.nether_furnace_lit, netherRocksAch).setSpecial().registerStat();
	}
	
	//Blocks
	public static Block fyrite_ore, malachite_ore, ashstone_ore, illumenite_ore, dragonstone_ore, argonite_ore;
	public static Block fyrite_block, malachite_block, ashstone_block, illumenite_block, dragonstone_block, argonite_block;
	public static Block nether_furnace, nether_furnace_lit;
	
	//Items
	public static Item fyrite_ingot, malachite_ingot, ashstone_gem, illumenite_ingot, dragonstone_gem, argonite_ingot;
	
	//Tools
	public static Item malachite_pickaxe, ashstone_pickaxe, dragonstone_pickaxe, argonite_pickaxe, fyrite_pickaxe;
	public static Item malachite_axe, ashstone_axe, dragonstone_axe, argonite_axe;
	public static Item malachite_shovel, ashstone_shovel, dragonstone_shovel, argonite_shovel;
	public static Item malachite_sword, ashstone_sword, dragonstone_sword, argonite_sword, fyrite_sword, illumenite_sword;
	public static Item malachite_hoe, ashstone_hoe, dragonstone_hoe, argonite_hoe;
	
	//Armor
	public static Item fyrite_helmet, malachite_helmet, illumenite_helmet, dragonstone_helmet;
	public static Item fyrite_chestplate, malachite_chestplate, illumenite_chestplate, dragonstone_chestplate;
	public static Item fyrite_leggings, malachite_leggings, illumenite_leggings, dragonstone_leggings;
	public static Item fyrite_boots, malachite_boots, illumenite_boots, dragonstone_boots;
	
	//Achievements
	public static Achievement netherRocksAch, netherFurnaceAch;
}
