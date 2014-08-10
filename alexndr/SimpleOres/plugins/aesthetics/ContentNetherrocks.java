package alexndr.SimpleOres.plugins.aesthetics;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alexndr.SimpleOres.api.content.SimpleBlock;
import alexndr.SimpleOres.api.content.SimpleStairs;

public class ContentNetherrocks 
{
	public static void doBlocks()
	{
		fyrite_bricks = new SimpleBlock(Material.iron).modId("aestheticsplugin").setHardness(Settings.fyriteBricksHardness).setResistance(Settings.fyriteBricksResistance).setBlockName("fyrite_bricks");
		malachite_bricks = new SimpleBlock(Material.iron).modId("aestheticsplugin").setHardness(Settings.malachiteBricksHardness).setResistance(Settings.malachiteBricksResistance).setBlockName("malachite_bricks");
		ashstone_bricks = new SimpleBlock(Material.iron).modId("aestheticsplugin").setHardness(Settings.ashstoneBricksHardness).setResistance(Settings.ashstoneBricksResistance).setBlockName("ashstone_bricks");
		illumenite_bricks = new SimpleBlock(Material.iron).modId("aestheticsplugin").setHardness(Settings.illumeniteBricksHardness).setResistance(Settings.illumeniteBricksResistance).setLightLevel(Settings.illumeniteBricksLightValue).setBlockName("illumenite_bricks");
		dragonstone_bricks = new SimpleBlock(Material.iron).modId("aestheticsplugin").setHardness(Settings.dragonstoneBricksHardness).setResistance(Settings.dragonstoneBricksResistance).setBlockName("dragonstone_bricks");
		argonite_bricks = new SimpleBlock(Material.iron).modId("aestheticsplugin").setHardness(Settings.argoniteBricksHardness).setResistance(Settings.argoniteBricksResistance).setBlockName("argonite_bricks");
		fyrite_brick_stairs = new SimpleStairs(fyrite_bricks, 0).setBlockName("fyrite_brick_stairs");
		malachite_brick_stairs = new SimpleStairs(malachite_bricks, 0).setBlockName("malachite_brick_stairs");
		ashstone_brick_stairs = new SimpleStairs(ashstone_bricks, 0).setBlockName("ashstone_brick_stairs");
		illumenite_brick_stairs = new SimpleStairs(illumenite_bricks, 0).setBlockName("illumenite_brick_stairs");
		dragonstone_brick_stairs = new SimpleStairs(dragonstone_bricks, 0).setBlockName("dragonstone_brick_stairs");
		argonite_brick_stairs = new SimpleStairs(argonite_bricks, 0).setBlockName("argonite_brick_stairs");
	}
	
	public static void doItems()
	{
		
	}
	
	public static void doAchievements()
	{
		
	}
	
	//Blocks
	public static Block fyrite_bricks, malachite_bricks, ashstone_bricks, illumenite_bricks, dragonstone_bricks, argonite_bricks;
	public static Block fyrite_brick_stairs, malachite_brick_stairs, ashstone_brick_stairs, illumenite_brick_stairs, dragonstone_brick_stairs, argonite_brick_stairs;
}
