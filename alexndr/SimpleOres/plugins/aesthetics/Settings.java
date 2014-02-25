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
			enableFusionContent = settings.get("Toggles", "Enable Fusion Content? (No effect if Fusion not installed)", true).getBoolean(enableFusionContent);
			enableNetherrocksContent = settings.get("Toggles", "Enable Netherrocks Content? (No effect if Netherrocks not installed)", true).getBoolean(enableNetherrocksContent);
    		
    		//Block Stats
    		if(enableBlockStatModification)
    		{
        		copperBricksHardness = (float) settings.get("Block Stats", "Copper Brick Hardness", 15.0).getDouble(copperBricksHardness);
        		copperBricksResistance = (float) settings.get("Block Stats", "Copper Brick Resistance", 20.0).getDouble(copperBricksResistance);
        		tinBricksHardness = (float) settings.get("Block Stats", "Tin Brick Hardness", 15.0).getDouble(tinBricksHardness);
        		tinBricksResistance = (float) settings.get("Block Stats", "Tin Brick Resistance", 20.0).getDouble(tinBricksResistance);
        		mythrilBricksHardness = (float) settings.get("Block Stats", "Mythril Brick Hardness", 15.0).getDouble(mythrilBricksHardness);
        		mythrilBricksResistance = (float) settings.get("Block Stats", "Mythril Brick Resistance", 20.0).getDouble(mythrilBricksResistance);
        		adamantiumBricksHardness = (float) settings.get("Block Stats", "Adamantium Brick Hardness", 15.0).getDouble(adamantiumBricksHardness);
        		adamantiumBricksResistance = (float) settings.get("Block Stats", "Adamantium Brick Resistance", 20.0).getDouble(adamantiumBricksResistance);
        		onyxBricksHardness = (float) settings.get("Block Stats", "Onyx Brick Hardness", 15.0).getDouble(onyxBricksHardness);
        		onyxBricksResistance = (float) settings.get("Block Stats", "Onxy Brick Resistance", 20.0).getDouble(onyxBricksResistance);
        		tinFFurnaceHardness = (float) settings.get("Block Stats", "Tin Fusion Furnace Hardness", 15.0).getDouble(tinFFurnaceHardness);
        		tinFFurnaceResistance = (float) settings.get("Block Stats", "Tin Fusion Furnace Resistance", 15.0).getDouble(tinFFurnaceResistance);
        		tinFFurnaceLightValue = (float) settings.get("Block Stats", "Tin Fusion Furnace Light Value", 1.0).getDouble(tinFFurnaceLightValue);
        		adamantiumFFurnaceHardness = (float) settings.get("Block Stats", "Adamantium Fusion Furnace Hardness", 15.0).getDouble(adamantiumFFurnaceHardness);
        		adamantiumFFurnaceResistance = (float) settings.get("Block Stats", "Adamantium Fusion Furnace Resistance", 15.0).getDouble(adamantiumFFurnaceResistance);
        		adamantiumFFurnaceLightValue = (float) settings.get("Block Stats", "Adamantium Fusion Furnace Light Value", 1.0).getDouble(adamantiumFFurnaceLightValue);
        		
    		}
    		else defaultBlockStats();
    		
    		if(enableFusionContent && enableBlockStatModification)
    		{
    			bronzeBricksHardness = (float) settings.get("Block Stats", "Bronze Brick Hardness", 15.0).getDouble(bronzeBricksHardness);
    			bronzeBricksResistance = (float) settings.get("Block Stats", "Bronze Brick Resistance", 20.0).getDouble(bronzeBricksResistance);
    			thyriumBricksHardness = (float) settings.get("Block Stats", "Thyrium Brick Hardness", 15.0).getDouble(thyriumBricksHardness);
    			thyriumBricksResistance = (float) settings.get("Block Stats", "Thyrium Brick Resistance", 20.0).getDouble(thyriumBricksResistance);
    			sinisiteBricksHardness = (float) settings.get("Block Stats", "Sinisite Brick Hardness", 15.0).getDouble(sinisiteBricksHardness);
    			sinisiteBricksResistance = (float) settings.get("Block Stats", "Sinisite Brick Resistance", 20.0).getDouble(sinisiteBricksResistance);
    		}
    		else if(enableFusionContent){defaultFusionBlockStats();}
    		
    		if(enableNetherrocksContent && enableBlockStatModification)
    		{
    			fyriteBricksHardness = (float) settings.get("Block Stats", "Fyrite Bricks Hardness", 15.0).getDouble(fyriteBricksHardness);
    			fyriteBricksResistance = (float) settings.get("Block Stats", "Fyrite Bricks Resistance", 20.0).getDouble(fyriteBricksResistance);
    			malachiteBricksHardness = (float) settings.get("Block Stats", "Malachite Bricks Hardness", 15.0).getDouble(malachiteBricksHardness);
    			malachiteBricksResistance = (float) settings.get("Block Stats", "Malachite Bricks Resistance", 20.0).getDouble(malachiteBricksResistance);
    			ashstoneBricksHardness = (float) settings.get("Block Stats", "Ashstone Bricks Hardness", 15.0).getDouble(ashstoneBricksHardness);
    			ashstoneBricksResistance = (float) settings.get("Block Stats", "Ashstone Bricks Resistance", 20.0).getDouble(ashstoneBricksResistance);
    			illumeniteBricksHardness = (float) settings.get("Block Stats", "Illumenite Bricks Hardness", 15.0).getDouble(illumeniteBricksHardness);
    			illumeniteBricksResistance = (float) settings.get("Block Stats", "Illumenite Bricks Resistance", 20.0).getDouble(illumeniteBricksResistance);
    			illumeniteBricksLightValue = (float) settings.get("Block Stats", "Illumenite Bricks Light Value", 1.0).getDouble(illumeniteBricksLightValue);
    			dragonstoneBricksHardness = (float) settings.get("Block Stats", "Dragonstone Bricks Hardness", 15.0).getDouble(dragonstoneBricksHardness);
    			dragonstoneBricksResistance = (float) settings.get("Block Stats", "Dragonstone Bricks Resistance", 20.0).getDouble(dragonstoneBricksResistance);
    			argoniteBricksHardness = (float) settings.get("Block Stats", "Argonite Bricks Hardness", 15.0).getDouble(argoniteBricksHardness);
    			argoniteBricksResistance = (float) settings.get("Block Stats", "Argonite Bricks Resistance", 20.0).getDouble(argoniteBricksResistance);
    		}
    		else if(enableNetherrocksContent){defaultNetherrocksBlockStats();}
    		
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
		copperBricksHardness = 15.0F;
		copperBricksResistance = 20.0F;
		tinBricksHardness = 15.0F;
		tinBricksResistance = 20.0F;
		mythrilBricksHardness = 15.0F;
		mythrilBricksResistance = 20.0F;
		adamantiumBricksHardness = 15.0F;
		adamantiumBricksResistance = 20.0F;
		onyxBricksHardness = 15.0F;
		onyxBricksResistance = 20.0F;
		tinFFurnaceHardness = 15.0F;
		tinFFurnaceResistance = 15.0F;
		tinFFurnaceLightValue = 1.0F;
		adamantiumFFurnaceHardness = 15.0F;
		adamantiumFFurnaceResistance = 15.0F;
		adamantiumFFurnaceLightValue = 1.0F;
	}
	
	private static void defaultFusionBlockStats()
	{
		bronzeBricksHardness = 15.0F;
		bronzeBricksResistance = 20.0F;
		thyriumBricksHardness = 15.0F;
		thyriumBricksResistance = 20.0F;
		sinisiteBricksHardness = 15.0F;
		sinisiteBricksResistance = 20.0F;
	}
	
	private static void defaultNetherrocksBlockStats()
	{
		fyriteBricksHardness = 15.0F;
		fyriteBricksResistance = 20.0F;
		malachiteBricksHardness = 15.0F;
		malachiteBricksResistance = 20.0F;
		ashstoneBricksHardness = 15.0F;
		ashstoneBricksResistance = 20.0F;
		illumeniteBricksHardness = 15.0F;
		illumeniteBricksResistance = 20.0F;
		illumeniteBricksLightValue = 1.0F;
		dragonstoneBricksHardness = 15.0F;
		dragonstoneBricksResistance = 20.0F;
		argoniteBricksHardness = 15.0F;
		argoniteBricksResistance = 20.0F;
	}
	
	//Toggles
	public static boolean enableBlockStatModification;
	public static boolean enableFusionContent;
	public static boolean enableNetherrocksContent;
	
	//Block Stats
	public static float copperBricksHardness, tinBricksHardness, mythrilBricksHardness, adamantiumBricksHardness, onyxBricksHardness;
	public static float copperBricksResistance, tinBricksResistance, mythrilBricksResistance, adamantiumBricksResistance, onyxBricksResistance;
	public static float tinFFurnaceHardness, tinFFurnaceResistance, tinFFurnaceLightValue;
	public static float adamantiumFFurnaceHardness, adamantiumFFurnaceResistance, adamantiumFFurnaceLightValue;
	
	//Fusion Block Stats
	public static float bronzeBricksHardness, thyriumBricksHardness, sinisiteBricksHardness;
	public static float bronzeBricksResistance, thyriumBricksResistance, sinisiteBricksResistance;
	
	//Netherrocks Block Stats
	public static float fyriteBricksHardness, malachiteBricksHardness, ashstoneBricksHardness, illumeniteBricksHardness, dragonstoneBricksHardness, argoniteBricksHardness;
	public static float fyriteBricksResistance, malachiteBricksResistance, ashstoneBricksResistance, illumeniteBricksResistance, dragonstoneBricksResistance, argoniteBricksResistance;
	public static float illumeniteBricksLightValue;
}
