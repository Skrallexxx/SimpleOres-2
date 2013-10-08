package SimpleOres.plugins.Netherrocks;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Settings 
{
	/**
	 * Creating toggles, multipliers, etc. For example, whether or not separate custom tabs are enabled. Basically another config.
	 */		
	//Toggles
	public static boolean enableSeparateTabs;
	public static boolean enableOldLocalisation;

	// Furnace Multipliers
	public static int netherFurnaceSpeedMultiplier;
	public static int netherrackBurnTime;
	public static int fyriteIngotBurnTime;

	// Ore Spawn Rates
	public static int fyriteSpawnRate;
	public static int malachiteSpawnRate;
	public static int ashstoneSpawnRate;
	public static int illumeniteSpawnRate;
	public static int dragonstoneSpawnRate;
	public static int argoniteSpawnRate;

	// Ore Vein Sizes
	public static int fyriteVeinSize;
	public static int malachiteVeinSize;
	public static int ashstoneVeinSize;
	public static int illumeniteVeinSize;
	public static int dragonstoneVeinSize;
	public static int argoniteVeinSize;
	
	/**
	 * The method that loads/creates the settings file. Values can be changed from true to false depending on user preference, and certain other values can be set. This is called by the main Netherrocks class.
	 */
	public static void doSettings(FMLPreInitializationEvent event)
    {
		/**
		 * Creating the config file. installDir is the 'config' file within .minecraft. configDir add a "SimpleOres Configuration/Plugins" folder within there.
		 */
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres Configuration/Plugins");
    	Configuration settings = new Configuration(new File(configDir, "Netherrocks Settings.cfg"));
		
		try 
	    {
			settings.load();
			
	    	//Toggles
	    	enableSeparateTabs = settings.get("Toggles", "Use Separate Creative Tabs?", true).getBoolean(enableSeparateTabs);
	    	enableOldLocalisation = settings.get("Toggles", "Use the old (configurable) Localisation?", false).getBoolean(enableOldLocalisation);
			
        	//Furnace Multiplier
        	netherFurnaceSpeedMultiplier = settings.get("Custom Furnaces", "Nether Furnace Speed Multiplier", 2).getInt();
        	netherrackBurnTime = settings.get("Custom Furnaces", "Netherrack Burn Time", 100).getInt();
        	fyriteIngotBurnTime = settings.get("Custom Furnace", "Fyrite Ingot Burn Time", 8000).getInt();
        	
    		//Ore Spawn Rates
        	fyriteSpawnRate = settings.get("Spawn Rates", "Fyrite Spawn Rate", 10).getInt();
        	malachiteSpawnRate = settings.get("Spawn Rates", "Malachite Spawn Rate", 10).getInt();
        	ashstoneSpawnRate = settings.get("Spawn Rates", "Ashstone Spawn Rate", 10).getInt();
        	illumeniteSpawnRate = settings.get("Spawn Rates", "Illumenite Spawn Rate", 350).getInt();
        	dragonstoneSpawnRate = settings.get("Spawn Rates", "Dragonstone Spawn Rate", 6).getInt();
        	argoniteSpawnRate = settings.get("Spawn Rates", "Argonite Spawn Rate", 10).getInt();
        	
    		//Ore Vein Sizes
        	fyriteVeinSize = settings.get("Vein Sizes", "Fyrite Vein Sizes", 6).getInt();
        	malachiteVeinSize = settings.get("Vein Sizes", "Malachite Vein Sizes", 7).getInt();
        	ashstoneVeinSize = settings.get("Vein Sizes", "Ashstone Vein Sizes", 5).getInt();
        	illumeniteVeinSize = settings.get("Vein Sizes", "Illumenite Vein Sizes", 15).getInt();
        	dragonstoneVeinSize = settings.get("Vein Sizes", "Dragonstone Vein Sizes", 5).getInt();
        	argoniteVeinSize = settings.get("Vein Sizes", "Argonite Vein Sizes", 6).getInt();
	    }
		
    	catch (Exception e) 
    	{
    		FMLLog.log(Level.SEVERE, e, "[Netherrocks] Error while trying to access the Netherrocks settings file!");
    	}
		
    	finally 
    	{
    		settings.save();
    		System.out.println("[Netherrocks] Settings loaded.");
    	}
    }
}
