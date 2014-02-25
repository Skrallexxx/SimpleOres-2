package alexndr.SimpleOres.plugins.aesthetics;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alexndr.SimpleOres.api.content.SimpleOre;
import cpw.mods.fml.common.registry.GameRegistry;


public class ContentFusion 
{	
	public static void doBlocks()
	{
		bronzeBricks = new SimpleOre(Config.bronzeBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.bronzeBricksHardness).setResistance(Settings.bronzeBricksResistance).setUnlocalizedName("bronzeBricks");
		thyriumBricks = new SimpleOre(Config.thyriumBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.thyriumBricksHardness).setResistance(Settings.thyriumBricksResistance).setUnlocalizedName("thyriumBricks");
		sinisiteBricks = new SimpleOre(Config.sinisiteBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.sinisiteBricksHardness).setResistance(Settings.sinisiteBricksResistance).setUnlocalizedName("sinisiteBricks");
		bronzeBrickStairs = new BlockSimpleStairs(Config.bronzeBrickStairsID, bronzeBricks, 0).setUnlocalizedName("bronzeBrickStairs");
		thyriumBrickStairs = new BlockSimpleStairs(Config.thyriumBrickStairsID, thyriumBricks, 0).setUnlocalizedName("thyriumBrickStairs");
		sinisiteBrickStairs = new BlockSimpleStairs(Config.sinisiteBrickStairsID, sinisiteBricks, 0).setUnlocalizedName("sinisiteBrickStairs");
		tinFFurnace = new FFurnaceTin(Config.tinFFurnaceID, false).setHardness(Settings.tinFFurnaceHardness).setResistance(Settings.tinFFurnaceResistance).setUnlocalizedName("tinFFurnace");
		tinFFurnaceOn = new FFurnaceTin(Config.tinFFurnaceOnID, true).setHardness(Settings.tinFFurnaceHardness).setResistance(Settings.tinFFurnaceResistance).setLightValue(Settings.tinFFurnaceLightValue).setUnlocalizedName("tinFFurnaceOn");
		adamantiumFFurnace = new FFurnaceAdamantium(Config.adamantiumFFurnaceID, false).setHardness(Settings.adamantiumFFurnaceHardness).setResistance(Settings.adamantiumFFurnaceResistance).setUnlocalizedName("adamantiumFFurnace");
		adamantiumFFurnaceOn = new FFurnaceAdamantium(Config.adamantiumFFurnaceOnID, true).setHardness(Settings.adamantiumFFurnaceHardness).setResistance(Settings.adamantiumFFurnaceResistance).setLightValue(Settings.adamantiumFFurnaceLightValue).setUnlocalizedName("adamantiumFFurnaceOn");
		
		GameRegistry.registerBlock(bronzeBrickStairs, "bronzeBrickStairs");
		GameRegistry.registerBlock(thyriumBrickStairs, "thyriumBrickStairs");
		GameRegistry.registerBlock(sinisiteBrickStairs, "sinisiteBrickStairs");
		GameRegistry.registerBlock(tinFFurnace, "tinFFurnace");
		GameRegistry.registerBlock(tinFFurnaceOn, "tinFFurnaceOn");
		GameRegistry.registerBlock(adamantiumFFurnace, "adamantiumFFurnace");
		GameRegistry.registerBlock(adamantiumFFurnaceOn, "adamantiumFFurnaceOn");
	}
	
	public static void doItems()
	{
		
	}
	
	public static void doAchievements()
	{
		
	}
	
	//Blocks
	public static Block bronzeBricks, thyriumBricks, sinisiteBricks;
	public static Block bronzeBrickStairs, thyriumBrickStairs, sinisiteBrickStairs;
	public static Block tinFFurnace, tinFFurnaceOn, adamantiumFFurnace, adamantiumFFurnaceOn;
}
