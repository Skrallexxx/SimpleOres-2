package alexndr.SimpleOres.plugins.aesthetics;

import java.io.File;

import net.minecraftforge.common.Configuration;
import alexndr.SimpleOres.api.helpers.FreeIdHelper;
import alexndr.SimpleOres.api.helpers.LogHelper;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config 
{
	private static FreeIdHelper get;
	
	public static void doIDs(FMLPreInitializationEvent event)
	{	
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres/Plugins");
		File configFile = new File(configDir, "Aesthetics Config.cfg");
    	Configuration config = new Configuration(configFile);
		LogHelper.verboseInfo("Aesthetics Plugin: Loading config file at: '" + configFile.getAbsolutePath() + "'...");
    	FreeIdHelper.compileIdList();
    	
    	try
    	{
    		config.load();
    		
    		//Block IDs
    		copperBricksID = config.getBlock("Blocks", "Copper Bricks", get.freeBlock()).getInt();
    		tinBricksID = config.getBlock("Blocks", "Tin Bricks", get.freeBlock()).getInt();
    		mythrilBricksID = config.getBlock("Blocks", "Mythril Bricks", get.freeBlock()).getInt();
    		adamantiumBricksID = config.getBlock("Blocks", "Adamantium Bricks", get.freeBlock()).getInt();
    		onyxBricksID = config.getBlock("Blocks", "Onyx Bricks", get.freeBlock()).getInt();
    		copperBrickStairsID = config.getBlock("Blocks", "Copper Brick Stairs", get.freeBlock()).getInt();
    		tinBrickStairsID = config.getBlock("Blocks", "Tin Brick Stairs", get.freeBlock()).getInt();
    		mythrilBrickStairsID = config.getBlock("Blocks", "Mythril Brick Stairs", get.freeBlock()).getInt();
    		adamantiumBrickStairsID = config.getBlock("Blocks", "Adamantium Brick Stairs", get.freeBlock()).getInt();
    		onyxBrickStairsID = config.getBlock("Blocks", "Onyx Brick Stairs", get.freeBlock()).getInt();
    		
    		if(Settings.enableFusionContent)
    		{
    			bronzeBricksID = config.getBlock("Blocks", "Bronze Bricks", get.freeBlock()).getInt();
    			thyriumBricksID = config.getBlock("Blocks", "Thyrium Bricks", get.freeBlock()).getInt();
    			sinisiteBricksID = config.getBlock("Blocks", "Sinisite Bricks", get.freeBlock()).getInt();
    			bronzeBrickStairsID = config.getBlock("Blocks", "Bronze Brick Stairs", get.freeBlock()).getInt();
    			thyriumBrickStairsID = config.getBlock("Blocks", "Thyrium Brick Stairs", get.freeBlock()).getInt();
    			sinisiteBrickStairsID = config.getBlock("Blocks", "Sinisite Brick Stairs", get.freeBlock()).getInt();
        		tinFFurnaceID = config.getBlock("Blocks", "Tin Fusion Furnace", get.freeBlock()).getInt();
        		tinFFurnaceOnID = config.getBlock("Blocks", "Tin Fusion Furnace On", get.freeBlock()).getInt();
        		adamantiumFFurnaceID = config.getBlock("Blocks", "Adamantium Fusion Furnace", get.freeBlock()).getInt();
        		adamantiumFFurnaceOnID = config.getBlock("Blocks", "Adamantium Fusion Furnace On", get.freeBlock()).getInt();
    		}
    		
    		if(Settings.enableNetherrocksContent)
    		{
    			fyriteBricksID = config.getBlock("Blocks", "Fyrite Bricks", get.freeBlock()).getInt();
    			malachiteBricksID = config.getBlock("Blocks", "Malachite Bricks", get.freeBlock()).getInt();
    			ashstoneBricksID = config.getBlock("Blocks", "Ashstone Bricks", get.freeBlock()).getInt();
    			illumeniteBricksID = config.getBlock("Blocks", "Illumenite Bricks", get.freeBlock()).getInt();
    			dragonstoneBricksID = config.getBlock("Blocks", "Dragonstone Bricks", get.freeBlock()).getInt();
    			argoniteBricksID = config.getBlock("Blocks", "Argonite Bricks", get.freeBlock()).getInt();
    			fyriteBrickStairsID = config.getBlock("Blocks", "Fyrite Brick Stairs", get.freeBlock()).getInt();
    			malachiteBrickStairsID = config.getBlock("Blocks", "Malachite Brick Stairs", get.freeBlock()).getInt();
    			ashstoneBrickStairsID = config.getBlock("Blocks", "Ashstone Brick Stairs", get.freeBlock()).getInt();
    			illumeniteBrickStairsID = config.getBlock("Blocks", "Illumenite Brick Stairs", get.freeBlock()).getInt();
    			dragonstoneBrickStairsID = config.getBlock("Blocks", "Dragonstone Brick Stairs", get.freeBlock()).getInt();
    			argoniteBrickStairsID = config.getBlock("Blocks", "Argonite Brick Stairs", get.freeBlock()).getInt();
    		}
    		
    		LogHelper.verboseInfo("Aesthetics Plugin: Config loaded successfully.");
    	}
    	catch(Exception e)
    	{
    		LogHelper.severe("Aesthetics Plugin: Failed to load the config.");
    	}
    	finally
    	{
    		config.save();
    	}
	}
	
	//Block IDs
	public static int copperBricksID, tinBricksID, mythrilBricksID, adamantiumBricksID, onyxBricksID;
	public static int tinFFurnaceID, tinFFurnaceOnID, adamantiumFFurnaceID, adamantiumFFurnaceOnID;
	public static int copperBrickStairsID, tinBrickStairsID, mythrilBrickStairsID, adamantiumBrickStairsID, onyxBrickStairsID;
	
	//Fusion Block IDs
	public static int bronzeBricksID, thyriumBricksID, sinisiteBricksID;
	public static int bronzeBrickStairsID, thyriumBrickStairsID, sinisiteBrickStairsID;
	
	//Netherrocks Block IDs
	public static int fyriteBricksID, malachiteBricksID, ashstoneBricksID, illumeniteBricksID, dragonstoneBricksID, argoniteBricksID;
	public static int fyriteBrickStairsID, malachiteBrickStairsID, ashstoneBrickStairsID, illumeniteBrickStairsID, dragonstoneBrickStairsID, argoniteBrickStairsID;
}
