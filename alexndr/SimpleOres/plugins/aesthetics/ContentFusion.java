package alexndr.SimpleOres.plugins.aesthetics;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alexndr.SimpleOres.api.content.SimpleOre;
import alexndr.SimpleOres.api.content.SimpleStairs;


public class ContentFusion 
{	
	public static void doBlocks()
	{
		bronze_bricks = new SimpleOre(Material.iron).modId("aestheticsplugin").setHardness(Settings.bronzeBricksHardness).setResistance(Settings.bronzeBricksResistance).setBlockName("bronze_bricks");
		thyrium_bricks = new SimpleOre(Material.iron).modId("aestheticsplugin").setHardness(Settings.thyriumBricksHardness).setResistance(Settings.thyriumBricksResistance).setBlockName("thyrium_bricks");
		sinisite_bricks = new SimpleOre(Material.iron).modId("aestheticsplugin").setHardness(Settings.sinisiteBricksHardness).setResistance(Settings.sinisiteBricksResistance).setBlockName("sinisite_bricks");
		bronze_brick_stairs = new SimpleStairs(bronze_bricks, 0).setBlockName("bronze_brick_stairs");
		thyrium_brick_stairs = new SimpleStairs(thyrium_bricks, 0).setBlockName("thyrium_brick_stairs");
		sinisite_brick_stairs = new SimpleStairs(sinisite_bricks, 0).setBlockName("sinisite_brick_stairs");
	}
	
	public static void doItems()
	{
		
	}
	
	public static void doAchievements()
	{
		
	}
	
	//Blocks
	public static Block bronze_bricks, thyrium_bricks, sinisite_bricks;
	public static Block bronze_brick_stairs, thyrium_brick_stairs, sinisite_brick_stairs;
}
