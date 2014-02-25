package alexndr.SimpleOres.api;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class HandlerLogger 
{
	private static Logger logger = Logger.getLogger("SimpleOres 2");
	
	public static void init()
	{
		logger.setParent(FMLLog.getLogger());
	}
	
	public static void log(String message)
	{
		logger.log(Level.INFO, message);
	}
	
	public static void logWarning(String message)
	{
		logger.log(Level.WARNING, message);
	}
	
	public static void logSevere(String message)
	{
		logger.log(Level.SEVERE, message);
	}
}
