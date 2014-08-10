package alexndr.SimpleOres.plugins.aesthetics;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alexndr.SimpleOres.api.content.SimpleBlock;
import alexndr.SimpleOres.api.content.SimpleStairs;
import alexndr.SimpleOres.api.helpers.LogHelper;
import cpw.mods.fml.common.Loader;

public class Content 
{
	public static void initialize()
	{
		//try{doItems(); LogHelper.verboseInfo("Aesthetics Plugin: All items were added successfully.");}
		//catch(Exception e){LogHelper.severe("Aesthetics Plugin: Items were not added successfully. This is a serious problem!"); e.printStackTrace();}
		try{doBlocks(); LogHelper.verboseInfo("Aesthetics Plugin: All blocks were added successfully.");}
		catch(Exception e){LogHelper.severe("Aesthetics Plugin: Blocks were not added successfully. This is a serious problem!"); e.printStackTrace();}
		//try{doAchievements(); LogHelper.verboseInfo("All achievements were added successfully.");}
		//catch(Exception e){LogHelper.severe("Aesthetics Plugin: Achievements were not added successfully. This is a serious problem!"); e.printStackTrace();}
	}
	
	public static void doBlocks()
	{
		if(Loader.isModLoaded("simpleores") && Settings.enableSimpleOresContent)
		{
			copper_bricks = new SimpleBlock(Material.iron).modId("aestheticsplugin").setHardness(Settings.copperBricksHardness).setResistance(Settings.copperBricksResistance).setBlockName("coppe_bricks");
			tin_bricks = new SimpleBlock(Material.iron).modId("aestheticsplugin").setHardness(Settings.tinBricksHardness).setResistance(Settings.tinBricksResistance).setBlockName("tin_bricks");
			mythril_bricks = new SimpleBlock(Material.iron).modId("aestheticsplugin").setHardness(Settings.mythrilBricksHardness).setResistance(Settings.mythrilBricksResistance).setBlockName("mythril_bricks");
			adamantium_bricks = new SimpleBlock(Material.iron).modId("aestheticsplugin").setHardness(Settings.adamantiumBricksHardness).setResistance(Settings.adamantiumBricksResistance).setBlockName("adamantium_bricks");
			onyx_bricks = new SimpleBlock(Material.iron).modId("aestheticsplugin").setHardness(Settings.onyxBricksHardness).setResistance(Settings.onyxBricksResistance).setBlockName("onyx_bricks");
			copper_brick_stairs = new SimpleStairs(copper_bricks, 0).setBlockName("copper_brick_stairs");
			tin_brick_stairs = new SimpleStairs(tin_bricks, 0).setBlockName("tin_brick_stairs");
			mythril_brick_stairs = new SimpleStairs(mythril_bricks, 0).setBlockName("mythril_brick_stairs");
			adamantium_brick_stairs = new SimpleStairs(adamantium_bricks, 0).setBlockName("adamantium_brick_stairs");
			onyx_brick_stairs = new SimpleStairs(onyx_bricks, 0).setBlockName("onyx_brick_stairs");
			
			LogHelper.verboseInfo("Aesthetics Plugin: Loaded Aesthetics content for SimpleOres Core.");
		}
		
		if(Loader.isModLoaded("fusionplugin") && Settings.enableFusionContent)
		{
			ContentFusion.doBlocks();
			LogHelper.verboseInfo("Aesthetics Plugin: Loaded Aesthetics content for SimpleOres Fusion.");
		}
		
		if(Loader.isModLoaded("netherrocks") && Settings.enableNetherrocksContent)
		{
			ContentNetherrocks.doBlocks();
			LogHelper.verboseInfo("Aesthetics Plugin: Loaded Aesthetics content for Netherrocks.");
		}
	}
	
	public static void doItems()
	{
		
	}
	
	public static void doAchievements()
	{
		
	}
	
	//Blocks
	public static Block copper_bricks, tin_bricks, mythril_bricks, adamantium_bricks, onyx_bricks;
	public static Block copper_brick_stairs, tin_brick_stairs, mythril_brick_stairs, adamantium_brick_stairs, onyx_brick_stairs;
}
