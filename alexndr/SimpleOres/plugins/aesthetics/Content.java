package alexndr.SimpleOres.plugins.aesthetics;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alexndr.SimpleOres.api.content.SimpleOre;
import alexndr.SimpleOres.api.helpers.LogHelper;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

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
		copperBricks = new SimpleOre(Config.copperBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.copperBricksHardness).setResistance(Settings.copperBricksResistance).setUnlocalizedName("copperBricks");
		tinBricks = new SimpleOre(Config.tinBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.tinBricksHardness).setResistance(Settings.tinBricksResistance).setUnlocalizedName("tinBricks");
		mythrilBricks = new SimpleOre(Config.mythrilBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.mythrilBricksHardness).setResistance(Settings.mythrilBricksResistance).setUnlocalizedName("mythrilBricks");
		adamantiumBricks = new SimpleOre(Config.adamantiumBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.adamantiumBricksHardness).setResistance(Settings.adamantiumBricksResistance).setUnlocalizedName("adamantiumBricks");
		onyxBricks = new SimpleOre(Config.onyxBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.onyxBricksHardness).setResistance(Settings.onyxBricksResistance).setUnlocalizedName("onyxBricks");
		copperBrickStairs = new BlockSimpleStairs(Config.copperBrickStairsID, copperBricks, 0).setUnlocalizedName("copperBrickStairs");
		tinBrickStairs = new BlockSimpleStairs(Config.tinBrickStairsID, tinBricks, 0).setUnlocalizedName("tinBrickStairs");
		mythrilBrickStairs = new BlockSimpleStairs(Config.mythrilBrickStairsID, mythrilBricks, 0).setUnlocalizedName("mythrilBrickStairs");
		adamantiumBrickStairs = new BlockSimpleStairs(Config.adamantiumBrickStairsID, adamantiumBricks, 0).setUnlocalizedName("adamantiumBrickStairs");
		onyxBrickStairs = new BlockSimpleStairs(Config.onyxBrickStairsID, onyxBricks, 0).setUnlocalizedName("onyxBrickStairs");
		
		GameRegistry.registerBlock(copperBrickStairs, "copperBrickStairs");
		GameRegistry.registerBlock(tinBrickStairs, "tinBrickStairs");
		GameRegistry.registerBlock(mythrilBrickStairs, "mythrilBrickStairs");
		GameRegistry.registerBlock(adamantiumBrickStairs, "adamantiumBrickStairs");
		GameRegistry.registerBlock(onyxBrickStairs, "onyxBrickStairs");
		
		if(Loader.isModLoaded("simpleoresfusion") && Settings.enableFusionContent)
		{
			ContentFusion.doBlocks();
		}
		
		if(Loader.isModLoaded("netherrocks") && Settings.enableNetherrocksContent)
		{
			ContentNetherrocks.doBlocks();
		}
	}
	
	public static void doItems()
	{
		
	}
	
	public static void doAchievements()
	{
		
	}
	
	//Blocks
	public static Block copperBricks, tinBricks, mythrilBricks, adamantiumBricks, onyxBricks;
	public static Block copperBrickStairs, tinBrickStairs, mythrilBrickStairs, adamantiumBrickStairs, onyxBrickStairs;
}
