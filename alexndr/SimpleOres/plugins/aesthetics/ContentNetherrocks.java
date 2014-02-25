package alexndr.SimpleOres.plugins.aesthetics;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alexndr.SimpleOres.api.content.SimpleOre;

public class ContentNetherrocks 
{
	public static void doBlocks()
	{
		fyriteBricks = new SimpleOre(Config.fyriteBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.fyriteBricksHardness).setResistance(Settings.fyriteBricksResistance).setUnlocalizedName("fyriteBricks");
		malachiteBricks = new SimpleOre(Config.malachiteBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.malachiteBricksHardness).setResistance(Settings.malachiteBricksResistance).setUnlocalizedName("malachiteBricks");
		ashstoneBricks = new SimpleOre(Config.ashstoneBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.ashstoneBricksHardness).setResistance(Settings.ashstoneBricksResistance).setUnlocalizedName("ashstoneBricks");
		illumeniteBricks = new SimpleOre(Config.illumeniteBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.illumeniteBricksHardness).setResistance(Settings.illumeniteBricksResistance).setLightValue(Settings.illumeniteBricksLightValue).setUnlocalizedName("illumeniteBricks");
		dragonstoneBricks = new SimpleOre(Config.dragonstoneBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.dragonstoneBricksHardness).setResistance(Settings.dragonstoneBricksResistance).setUnlocalizedName("dragonstoneBricks");
		argoniteBricks = new SimpleOre(Config.argoniteBricksID, Material.iron).modId("aestheticsplugin").setHardness(Settings.argoniteBricksHardness).setResistance(Settings.argoniteBricksResistance).setUnlocalizedName("argoniteBricks");
		fyriteBrickStairs = new BlockSimpleStairs(Config.fyriteBrickStairsID, fyriteBricks, 0).setUnlocalizedName("fyriteBrickStairs");
		malachiteBrickStairs = new BlockSimpleStairs(Config.malachiteBrickStairsID, malachiteBricks, 0).setUnlocalizedName("malachiteBrickStairs");
		ashstoneBrickStairs = new BlockSimpleStairs(Config.ashstoneBrickStairsID, ashstoneBricks, 0).setUnlocalizedName("ashstoneBrickStairs");
		illumeniteBrickStairs = new BlockSimpleStairs(Config.illumeniteBrickStairsID, illumeniteBricks, 0).setUnlocalizedName("illumeniteBrickStairs");
		dragonstoneBrickStairs = new BlockSimpleStairs(Config.dragonstoneBrickStairsID, dragonstoneBricks, 0).setUnlocalizedName("dragonstoneBrickStairs");
		argoniteBrickStairs = new BlockSimpleStairs(Config.argoniteBrickStairsID, argoniteBricks, 0).setUnlocalizedName("argoniteBrickStairs");
		
		GameRegistry.registerBlock(fyriteBrickStairs, "fyriteBrickStairs");
		GameRegistry.registerBlock(malachiteBrickStairs, "malachiteBrickStairs");
		GameRegistry.registerBlock(ashstoneBrickStairs, "ashstoneBrickStairs");
		GameRegistry.registerBlock(illumeniteBrickStairs, "illumeniteBrickStairs");
		GameRegistry.registerBlock(dragonstoneBrickStairs, "dragonstoneBrickStairs");
		GameRegistry.registerBlock(argoniteBrickStairs, "argoniteBrickStairs");
	}
	
	public static void doItems()
	{
		
	}
	
	public static void doAchievements()
	{
		
	}
	
	//Blocks
	public static Block fyriteBricks, malachiteBricks, ashstoneBricks, illumeniteBricks, dragonstoneBricks, argoniteBricks;
	public static Block fyriteBrickStairs, malachiteBrickStairs, ashstoneBrickStairs, illumeniteBrickStairs, dragonstoneBrickStairs, argoniteBrickStairs;
}
