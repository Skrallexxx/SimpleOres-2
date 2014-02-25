package alexndr.SimpleOres.api.helpers;

import java.util.logging.Level;
import java.util.logging.Logger;

import alexndr.SimpleOres.core.Settings;
import cpw.mods.fml.common.FMLLog;

public class LogHelper 
{
	private static Logger logger = Logger.getLogger("SimpleOres 2");
	
	public static void init()
	{
		logger.setParent(FMLLog.getLogger());
	}
	
	public static void info(String message)
	{
		logger.log(Level.INFO, message);
	}
	
	public static void warning(String message)
	{
		logger.log(Level.WARNING, message);
	}
	
	public static void severe(String message)
	{
		logger.log(Level.SEVERE, message);
	}
	
	public static void verboseInfo(String message)
	{
		if(Settings.enableVerboseLogging)
		{
			logger.log(Level.INFO, message);
		}
	}
	
	public static void verboseWarning(String message)
	{
		if(Settings.enableVerboseLogging)
		{
			logger.log(Level.WARNING, message);
		}
	}
}
