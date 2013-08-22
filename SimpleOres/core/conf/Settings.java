package SimpleOres.core.conf;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import SimpleOres.core.Achievements;
import SimpleOres.core.Armor;
import SimpleOres.core.Blocks;
import SimpleOres.core.Items;
import SimpleOres.core.Recipes;
import SimpleOres.core.SimpleOres;
import SimpleOres.core.Tools;

public class Settings 
{
	/**
	 * Linking to the classes for easier reference.
	 */
	public static SimpleOres mod;
	public static Achievements achievements;
	public static Armor armor;
	public static Blocks blocks;
	public static IDs config;
	public static Items items;
	public static Localisation local;
	public static Recipes recipes;
	public static Tools tools;
	
	/**
	 * Creating toggles. For example, whether or not separate custom tabs are enabled. Basically another config.
	 */	
//======================================= CREATION ======================================================= 	
	//Toggles
	public static boolean enableSeparateTabs;
	
	//Ore Spawn Rates
	public static int copperSpawnRate;
	public static int tinSpawnRate;
	public static int mythrilSpawnRate;
	public static int adamantiumSpawnRate;
	public static int onyxSpawnRate;
	
	//Ore Vein Sizes
	public static int copperVeinSize;
	public static int tinVeinSize;
	public static int mythrilVeinSize;
	public static int adamantiumVeinSize;
	public static int onyxVeinSize;
	
	//Ore Spawn Heights
	public static int copperSpawnHeight;
	public static int tinSpawnHeight;
	public static int mythrilSpawnHeight;
	public static int adamantiumSpawnHeight;
	public static int onyxSpawnHeight;
	
	//Custom Furnaces
	public static int mythrilFurnaceMultiplier;
	public static int onyxFurnaceMultiplier;
	public static int onyxFurnaceMultiChance;
	
	//Bow Modifiers
	public static int mythrilBowDamageModifier;
	public static int onyxBowDamageModifier;
	
	/**
	 * The method that loads/creates the settings file. Values can be changed from true to false depending on user preference, and certain other values can be set. This is called by the main SimpleOres class.
	 */
	public static void doSettings(FMLPreInitializationEvent event)
    {
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres Configuration");
		Configuration settings = new Configuration(new File(configDir, "SimpleOresSettings.cfg"));
		
		try 
	    {
			settings.load();
	    	
	    	//Toggles
	    	enableSeparateTabs = settings.get("Toggles", "Use Separate Creative Tabs?", true).getBoolean(enableSeparateTabs);
	    	
        	//Adjustable Ore Spawn Rates 
        	copperSpawnRate = settings.get("Spawn Rates", "Copper Spawn Rate", 45).getInt();
        	tinSpawnRate = settings.get("Spawn Rates", "Tin Spawn Rate", 30).getInt();
        	mythrilSpawnRate = settings.get("Spawn Rates", "Mythril Spawn Rate", 8).getInt();
        	adamantiumSpawnRate = settings.get("Spawn Rates", "Adamantium Spawn Rate", 4).getInt();
        	onyxSpawnRate = settings.get("Spawn Rates", "Onyx Spawn Rate", 5).getInt();
    		
        	//Adjustable Ore Vein Sizes
        	copperVeinSize = settings.get("Vein Sizes", "Copper Vein Size", 7).getInt();
        	tinVeinSize = settings.get("Vein Sizes", "Tin Vein Size", 7).getInt();
        	mythrilVeinSize = settings.get("Vein Sizes", "Mythril Vein Size", 4).getInt();
        	adamantiumVeinSize = settings.get("Vein Sizes", "Adamantium Vein Size", 4).getInt();
        	onyxVeinSize = settings.get("Vein Sizes", "Onyx Vein Size", 7).getInt();
    		
        	//Adjustable Ore Spawn Heights
        	copperSpawnHeight = settings.get("Spawn Heights", "Copper Spawn Height", 90).getInt();
        	tinSpawnHeight = settings.get("Spawn Heights", "Tin Spawn Height", 90).getInt();
        	mythrilSpawnHeight = settings.get("Spawn Heights", "Mythril Spawn Height", 35).getInt();
        	adamantiumSpawnHeight = settings.get("Spawn Heights", "Adamantium Spawn Height", 20).getInt();
        	onyxSpawnHeight = settings.get("Spawn Heights", "Onyx Spawn Height", 256).getInt();
    		
        	//Custom Furnace Multipliers
        	mythrilFurnaceMultiplier = settings.get("Custom Furnaces", "Mythril Furnace Fuel Length Multiplier", 2).getInt();
        	onyxFurnaceMultiplier = settings.get("Custom Furnaces", "Onyx Furnace Extra Yield Amount", 1).getInt();
        	onyxFurnaceMultiChance = settings.get("Custom Furnaces", "Onyx Furnace Multi Yield Chance (From 1 to 100)", 33).getInt();
	    	
        	//Bow Modifiers
        	mythrilBowDamageModifier = settings.get("Bow Modifiers", "Mythril Bow Damage Modifier", 2).getInt();
        	onyxBowDamageModifier = settings.get("Bow Modifiers", "Onyx Bow Damage Modifier", 5).getInt();
	    }
		
    	catch (Exception e) 
    	{
    		FMLLog.log(Level.SEVERE, e, "[SimpleOres] Error while trying to access the SimpleOres settings file!");
    	}
		
    	finally 
    	{
    		settings.save();
    		System.out.println("[SimpleOres] Settings loaded.");
    	}
    }
}
