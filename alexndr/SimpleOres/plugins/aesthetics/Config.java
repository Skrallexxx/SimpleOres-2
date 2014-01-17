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
    		tinFFurnaceID = config.getBlock("Blocks", "Tin Fusion Furnace", get.freeBlock()).getInt();
    		tinFFurnaceOnID = config.getBlock("Blocks", "Tin Fusion Furnace On", get.freeBlock()).getInt();
    		adamantiumFFurnaceID = config.getBlock("Blocks", "Adamantium Fusion Furnace", get.freeBlock()).getInt();
    		adamantiumFFurnaceOnID = config.getBlock("Blocks", "Adamantium Fusion Furnace On", get.freeBlock()).getInt();
    		copperBricksStairsID = config.getBlock("Blocks", "Copper Bricks Stairs", get.freeBlock()).getInt();
    		tinBricksStairsID = config.getBlock("Blocks", "Tin Bricks Stairs", get.freeBlock()).getInt();
    		mythrilBricksStairsID = config.getBlock("Blocks", "Mythril Bricks Stairs", get.freeBlock()).getInt();
    		adamantiumBricksStairsID = config.getBlock("Blocks", "Adamantium Bricks Stairs", get.freeBlock()).getInt();
    		onyxBricksStairsID = config.getBlock("Blocks", "Onyx Bricks Stairs", get.freeBlock()).getInt();
    		
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
	public static int copperBricksStairsID, tinBricksStairsID, mythrilBricksStairsID, adamantiumBricksStairsID, onyxBricksStairsID;
}
