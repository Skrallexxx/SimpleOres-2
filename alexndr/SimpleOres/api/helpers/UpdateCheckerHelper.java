package alexndr.SimpleOres.api.helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.util.StatCollector;

import com.google.common.collect.Lists;

public class UpdateCheckerHelper
{
	static String modChecking = new String();
	static StringBuffer newVersion = new StringBuffer();
	static ArrayList<String> mods = Lists.newArrayList();
	static HashMap<String, Boolean> isModOutOfDate = new HashMap<String, Boolean>();
	static HashMap<String, String> newVersions = new HashMap<String, String>();
	static String VERSION = "";
	static boolean hasChecked = false;
	
	/**
	 * Easily way to have a mod check for updates. Requires an online text file containing the new version, a modId, and a current version.
	 * Supports localisations. Add two entries to your localisation called modId.updateMessage1 and modId.updateMessage2.
	 * 
	 * @param linkToVersionFile The url for the text file that contains the newest version number. Must NOT be https:
	 * @param modId The modId of the mod you want to check for. 
	 * @param modInfoClassVersion The current version of the mod, such as the version number put in the @Mod line.
	 */
	public static void checkUpdates(String linkToVersionFile, String modId, String modInfoClassVersion)
	{	
		try
		{
			modChecking = modId;
			mods.add(modId);
			VERSION = modInfoClassVersion;
			
			URL url = new URL(linkToVersionFile);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(999);
			connection.setReadTimeout(999);
			connection.setRequestMethod("HEAD");
			int responseCode = connection.getResponseCode();
			
			if(responseCode == 200)
			{
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				String line = null;
				
				while((line = reader.readLine()) != null)
				{
					newVersion.append(line);
				}
				
				int versionInt = Integer.parseInt(VERSION.replace(".", ""));
				int newVersionInt = Integer.parseInt(newVersion.toString().replace(".", ""));
				
				if(newVersionInt > versionInt)
				{
					isModOutOfDate.put(modId, true);
					newVersions.put(modId, newVersion.toString());
				}
				else
				{
					isModOutOfDate.put(modId, false);
					newVersions.put(modId, newVersion.toString());
				}
			}
			
			LogHelper.verboseInfo("Total mods that UpdateCheckerHelper is checking for = " + mods.size());
			
			for(int i = 0; i < mods.size(); i++)
			{
				LogHelper.verboseInfo("Checking for updates for modId: " + mods.get(i) + ". Newest version is " + newVersions.get(mods.get(i)));
			}
		}
		
		catch(Exception e)
		{
			if(!hasChecked)
			{
				LogHelper.warning("Update checker(s) could not reach server when checking for mod " + modChecking + ". The connection probably Timed Out.");
				hasChecked = true;
			}
		}
		
		finally
		{
			newVersion.setLength(0);
		}
	}
	
	/**
	 * Called by the EventHandler when a player logs in. Return the constructed message to be displayed to player. 
	 * @return List of messages.
	 */
	public static List<String> getMessages()
	{
		List<String> messages = Lists.newArrayList();
		if(mods.size()  != 0 && isModOutOfDate.size() != 0 && newVersions.size() != 0)
		{
			for(int i = 0; i < mods.size(); i++)
			{
				if(newVersions.get(mods.get(i)) != null)
				{
					if(isModOutOfDate.get(mods.get(i)) == true)
					{
						String message = StatCollector.translateToLocal(mods.get(i) + ".updateMessage1") + newVersions.get(mods.get(i)) + StatCollector.translateToLocal(mods.get(i) + ".updateMessage2");
						messages.add(message);
					}
				}
			}
			return messages;
		}
		return null;
	}
}
