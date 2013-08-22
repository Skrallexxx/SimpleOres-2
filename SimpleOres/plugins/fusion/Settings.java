package SimpleOres.plugins.fusion;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Settings 
{
	/**
	 * Creating toggles. For example, whether or not separate custom tabs are enabled. Basically another config.
	 */	
//======================================= CREATION ======================================================= 	
	//Bow Modifiers
	public static int thyriumBowDamageModifier;
	public static int thyriumBowZoomModifier;
	public static int sinisiteBowDamageModifier;
	public static int sinisiteBowKnockbackModifier;
	
	/**
	 * The method that loads/creates the settings file. Values can be changed from true to false depending on user preference, and certain other values can be set. This is called by the main SimpleOresFusion class.
	 */
	public static void doSettings(FMLPreInitializationEvent event)
    {
		/**
		 * Creating the settings file. installDir is the 'config' folder within .minecraft. configDir add a "SimpleOres Configuration/Plugins" folder within there.
		 */
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres Configuration/Plugins");
		Configuration settings = new Configuration(new File(configDir, "FusionSettings.cfg"));
		
		try 
	    {
			settings.load();
			
        	//Bow Modifiers
        	thyriumBowDamageModifier = settings.get("Bow Modifiers", "Thyrium Bow Damage Modifier", 5).getInt();
        	thyriumBowZoomModifier = settings.get("Bow Modifiers", "Thyrium Bow Zoom Modifier", 35).getInt();
        	sinisiteBowDamageModifier = settings.get("Bow Modifiers", "Sinisite Bow Damage Modifier", 6).getInt();
        	sinisiteBowKnockbackModifier = settings.get("Bow Modifiers", "Sinisite Bow Knockback Modifier", 2).getInt();
	    }
		
    	catch (Exception e) 
    	{
    		FMLLog.log(Level.SEVERE, e, "[SimpleOres] Error while trying to access the SimpleOres Fusion Plugin settings file!");
    	}
		
    	finally 
    	{
    		settings.save();
    		System.out.println("[SimpleOres] Fusion Plugin settings loaded.");
    	}
    }
}
