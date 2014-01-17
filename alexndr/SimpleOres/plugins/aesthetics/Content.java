package alexndr.SimpleOres.plugins.aesthetics;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alexndr.SimpleOres.api.content.SimpleOre;
import cpw.mods.fml.common.registry.GameRegistry;

public class Content 
{
	static AestheticsPlugin mod;
	
	public static void doBlocks()
	{
		copperBricks = new SimpleOre(Config.copperBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.copperBrickHardness).setResistance(Settings.copperBrickResistance).setUnlocalizedName("copperBricks");
		tinBricks = new SimpleOre(Config.tinBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.tinBrickHardness).setResistance(Settings.tinBrickResistance).setUnlocalizedName("tinBricks");
		mythrilBricks = new SimpleOre(Config.mythrilBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.mythrilBrickHardness).setResistance(Settings.mythrilBrickResistance).setUnlocalizedName("mythrilBricks");
		adamantiumBricks = new SimpleOre(Config.adamantiumBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.adamantiumBrickHardness).setResistance(Settings.adamantiumBrickResistance).setUnlocalizedName("adamantiumBricks");
		onyxBricks = new SimpleOre(Config.onyxBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.onyxBrickHardness).setResistance(Settings.onyxBrickResistance).setUnlocalizedName("onyxBricks");
		tinFFurnace = new FFurnaceTin(Config.tinFFurnaceID, false).setHardness(Settings.tinFFurnaceHardness).setResistance(Settings.tinFFurnaceResistance).setUnlocalizedName("tinFFurnace");
		tinFFurnaceOn = new FFurnaceTin(Config.tinFFurnaceOnID, true).setHardness(Settings.tinFFurnaceHardness).setResistance(Settings.tinFFurnaceResistance).setLightValue(Settings.tinFFurnaceLightValue).setUnlocalizedName("tinFFurnaceOn");
		adamantiumFFurnace = new FFurnaceAdamantium(Config.adamantiumFFurnaceID, false).setHardness(Settings.adamantiumFFurnaceHardness).setResistance(Settings.adamantiumFFurnaceResistance).setUnlocalizedName("adamantiumFFurnace");
		adamantiumFFurnaceOn = new FFurnaceAdamantium(Config.adamantiumFFurnaceOnID, true).setHardness(Settings.adamantiumFFurnaceHardness).setResistance(Settings.adamantiumFFurnaceResistance).setLightValue(Settings.adamantiumFFurnaceLightValue).setUnlocalizedName("adamantiumFFurnaceOn");
		copperBricksStairs = new BlockSimpleStairs(Config.copperBricksStairsID, copperBricks, 0).setUnlocalizedName("copperBricksStairs");
		tinBricksStairs = new BlockSimpleStairs(Config.tinBricksStairsID, tinBricks, 0).setUnlocalizedName("tinBricksStairs");
		mythrilBricksStairs = new BlockSimpleStairs(Config.mythrilBricksStairsID, mythrilBricks, 0).setUnlocalizedName("mythrilBricksStairs");
		adamantiumBricksStairs = new BlockSimpleStairs(Config.adamantiumBricksStairsID, adamantiumBricks, 0).setUnlocalizedName("adamantiumBricksStairs");
		onyxBricksStairs = new BlockSimpleStairs(Config.onyxBricksStairsID, onyxBricks, 0).setUnlocalizedName("onyxBricksStairs");
		
		GameRegistry.registerBlock(tinFFurnace, "tinFFurnace");
		GameRegistry.registerBlock(tinFFurnaceOn, "tinFFurnaceOn");
		GameRegistry.registerBlock(adamantiumFFurnace, "adamantiumFFurnace");
		GameRegistry.registerBlock(adamantiumFFurnaceOn, "adamantiumFFurnaceOn");
		GameRegistry.registerBlock(copperBricksStairs, "copperBricksStairs");
		GameRegistry.registerBlock(tinBricksStairs, "tinBricksStairs");
		GameRegistry.registerBlock(mythrilBricksStairs, "mythrilBricksStairs");
		GameRegistry.registerBlock(adamantiumBricksStairs, "adamantiumBricksStairs");
		GameRegistry.registerBlock(onyxBricksStairs, "onyxBricksStairs");
	}
	
	public static void doItems()
	{
		
	}
	
	public static void doAchievements()
	{
		
	}
	
	//Blocks
	public static Block copperBricks, tinBricks, mythrilBricks, adamantiumBricks, onyxBricks;
	public static Block tinFFurnace, tinFFurnaceOn, adamantiumFFurnace, adamantiumFFurnaceOn;
	public static Block copperBricksStairs, tinBricksStairs, mythrilBricksStairs, adamantiumBricksStairs, onyxBricksStairs;
}
