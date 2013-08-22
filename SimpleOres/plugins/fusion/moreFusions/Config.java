package SimpleOres.plugins.fusion.moreFusions;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config 
{
	public static int steelBlockID;
	
	public static int steelChunkSmallID;
	public static int steelChunkMediumID;
	public static int steelChunkLargeID;
	public static int steelIngotID;
	public static int steelPickID;
	public static int steelAxeID;
	public static int steelShovelID;
	public static int steelSwordID;
	public static int steelHoeID;
	public static int steelHelmID;
	public static int steelChestID;
	public static int steelLegsID;
	public static int steelBootsID;
	
	public static void doConfig(FMLPreInitializationEvent event)
	{
		/**
		 * Creating the config file. installDir is the 'config' file within .minecraft. configDir adds a "SimpleOres Configuration/Plugins" folder within there.
		 */
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres Configuration/Plugins");
    	Configuration config = new Configuration(new File(configDir, "MoreFusions.cfg"));
    	
    	try 
    	{
    		config.load();
    		//ID's
    		steelBlockID = config.getBlock("Blocks", "Steel Block", 520).getInt();
    		steelChunkSmallID = config.getItem("Items", "Small Steel Chunk", 5400).getInt();
    		steelChunkMediumID = config.getItem("Items", "Medium Steel Chunk", 5401).getInt();
    		steelChunkLargeID = config.getItem("Items", "Large Steel Chunk", 5402).getInt();
    		steelIngotID = config.getItem("Items", "Steel Ingot", 5403).getInt();
    		steelPickID = config.getItem("Items", "Steel Pickaxe", 5404).getInt();
    		steelAxeID = config.getItem("Items", "Steel Axe", 5405).getInt();
    		steelShovelID = config.getItem("Items", "Steel Shovel", 5406).getInt();
    		steelSwordID = config.getItem("Items", "Steel Sword", 5407).getInt();
    		steelHoeID = config.getItem("Items", "Steel Hoe", 5408).getInt();
    		steelHelmID = config.getItem("Items", "Steel Helmet", 5409).getInt();
    		steelChestID = config.getItem("Items", "Steel Chestplate", 5410).getInt();
    		steelLegsID = config.getItem("Items", "Steel Leggings", 5411).getInt();
    		steelBootsID = config.getItem("Items", "Steel Boots", 5412).getInt();
    	}
    	
    	catch (Exception e) 
    	{
    		FMLLog.log(Level.SEVERE, e, "[SimpleOres] Error while trying to access the SimpleOres More Fusions Plugin config file!");
    	}
    	
    	finally 
    	{
    		config.save();
    		System.out.println("[SimpleOres] More Fusions Plugin config loaded.");
    	}
	}
}
