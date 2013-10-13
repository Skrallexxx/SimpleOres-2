package SimpleOres.plugins.horseArmor;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config 
{
	public static int copperHorseArmorID;
	public static String copperHorseArmorName;
	
	public static void doConfig(FMLPreInitializationEvent event)
	{
		/**
		 * Creating the config file. installDir is the 'config' file within .minecraft. configDir adds a "SimpleOres Configuration/Plugins" folder within there.
		 */
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres Configuration/Plugins");
    	Configuration config = new Configuration(new File(configDir, "HorseArmor.cfg"));
    	
    	try 
    	{
    		config.load();
    		
    		copperHorseArmorID = config.getItem("ID's", "Copper Horse Armor", 5500).getInt();
    		copperHorseArmorName = config.get("Names", "CopperHorseArmorName", "Copper Horse Armor").getString();
    	}
    	
    	catch (Exception e) 
    	{
    		FMLLog.log(Level.SEVERE, e, "[SimpleOres] Error while trying to access the SimpleOres 2 Horse Armor Plugin config file!");
    	}
    	
    	finally 
    	{
    		config.save();
    		System.out.println("[SimpleOres] SimpleOres 2 Horse Armor Plugin config loaded.");
    	}
	}
}
