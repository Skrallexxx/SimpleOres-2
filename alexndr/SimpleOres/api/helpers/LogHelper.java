package alexndr.SimpleOres.api.helpers;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import alexndr.SimpleOres.core.Settings;

public class LogHelper 
{
	private static Logger logger = LogManager.getLogger("SimpleOres");
	
    public static void info(String message)
    {
    	logger.log(Level.INFO, message);
    }
    
    public static void warning(String message)
	{
		logger.log(Level.WARN, message);
	}
	
	public static void severe(String message)
	{
		logger.log(Level.ERROR, message);
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
			logger.log(Level.WARN, message);
		}
	}
}
