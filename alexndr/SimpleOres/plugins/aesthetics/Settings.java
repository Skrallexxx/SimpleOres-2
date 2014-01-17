package alexndr.SimpleOres.plugins.aesthetics;

import java.io.File;

import net.minecraftforge.common.Configuration;
import alexndr.SimpleOres.api.helpers.LogHelper;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Settings 
{
	public static void doSettings(FMLPreInitializationEvent event)
	{
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres/Plugins");
		File settingsFile = new File(configDir, "Aesthetics Settings.cfg");
		Configuration settings = new Configuration(settingsFile);
		LogHelper.verboseInfo("Aesthetics Plugin: Loading settings file at: '" + settingsFile.getAbsolutePath() + "'...");
    	
    	try
    	{
    		settings.load();
    		
    		//Toggles
			enableBlockStatModification = settings.get("Toggles", "Enable Block Stat Modification? (Advanced)", false).getBoolean(enableBlockStatModification);
    		
    		//Block Stats
    		if(enableBlockStatModification)
    		{
        		copperBrickHardness = (float) settings.get("Block Stats", "Copper Brick Hardness", 15.0).getDouble(copperBrickHardness);
        		copperBrickResistance = (float) settings.get("Block Stats", "Copper Brick Resistance", 20.0).getDouble(copperBrickResistance);
        		tinBrickHardness = (float) settings.get("Block Stats", "Tin Brick Hardness", 15.0).getDouble(tinBrickHardness);
        		tinBrickResistance = (float) settings.get("Block Stats", "Tin Brick Resistance", 20.0).getDouble(tinBrickResistance);
        		mythrilBrickHardness = (float) settings.get("Block Stats", "Mythril Brick Hardness", 15.0).getDouble(mythrilBrickHardness);
        		mythrilBrickResistance = (float) settings.get("Block Stats", "Mythril Brick Resistance", 20.0).getDouble(mythrilBrickResistance);
        		adamantiumBrickHardness = (float) settings.get("Block Stats", "Adamantium Brick Hardness", 15.0).getDouble(adamantiumBrickHardness);
        		adamantiumBrickResistance = (float) settings.get("Block Stats", "Adamantium Brick Resistance", 20.0).getDouble(adamantiumBrickResistance);
        		onyxBrickHardness = (float) settings.get("Block Stats", "Onyx Brick Hardness", 15.0).getDouble(onyxBrickHardness);
        		onyxBrickResistance = (float) settings.get("Block Stats", "Onxy Brick Resistance", 20.0).getDouble(onyxBrickResistance);
        		tinFFurnaceHardness = (float) settings.get("Block Stats", "Tin Fusion Furnace Hardness", 15.0).getDouble(tinFFurnaceHardness);
        		tinFFurnaceResistance = (float) settings.get("Block Stats", "Tin Fusion Furnace Resistance", 15.0).getDouble(tinFFurnaceResistance);
        		tinFFurnaceLightValue = (float) settings.get("Block Stats", "Tin Fusion Furnace Light Value", 1.0).getDouble(tinFFurnaceLightValue);
        		adamantiumFFurnaceHardness = (float) settings.get("Block Stats", "Adamantium Fusion Furnace Hardness", 15.0).getDouble(adamantiumFFurnaceHardness);
        		adamantiumFFurnaceResistance = (float) settings.get("Block Stats", "Adamantium Fusion Furnace Resistance", 15.0).getDouble(adamantiumFFurnaceResistance);
        		adamantiumFFurnaceLightValue = (float) settings.get("Block Stats", "Adamantium Fusion Furnace Light Value", 1.0).getDouble(adamantiumFFurnaceLightValue);
        		
    		}
    		else defaultBlockStats();
    		
    		LogHelper.verboseInfo("Aesthetics Plugin: Settings loaded successfully.");
    	}
    	catch(Exception e)
    	{
    		LogHelper.severe("Aesthetics Plugin: Failed to load the Settings file.");
    	}
    	finally
    	{
    		settings.save();
    	}
	}
	
	private static void defaultBlockStats()
	{
		copperBrickHardness = 15.0F;
		copperBrickResistance = 20.0F;
		tinBrickHardness = 15.0F;
		tinBrickResistance = 20.0F;
		mythrilBrickHardness = 15.0F;
		mythrilBrickResistance = 20.0F;
		adamantiumBrickHardness = 15.0F;
		adamantiumBrickResistance = 20.0F;
		onyxBrickHardness = 15.0F;
		onyxBrickResistance = 20.0F;
		tinFFurnaceHardness = 15.0F;
		tinFFurnaceResistance = 15.0F;
		tinFFurnaceLightValue = 1.0F;
		adamantiumFFurnaceHardness = 15.0F;
		adamantiumFFurnaceResistance = 15.0F;
		adamantiumFFurnaceLightValue = 1.0F;
	}
	
	//Toggles
	public static boolean enableBlockStatModification;
	
	//Block Stats
	public static float copperBrickHardness, tinBrickHardness, mythrilBrickHardness, adamantiumBrickHardness, onyxBrickHardness;
	public static float copperBrickResistance, tinBrickResistance, mythrilBrickResistance, adamantiumBrickResistance, onyxBrickResistance;
	public static float tinFFurnaceHardness, tinFFurnaceResistance, tinFFurnaceLightValue;
	public static float adamantiumFFurnaceHardness, adamantiumFFurnaceResistance, adamantiumFFurnaceLightValue;
}
