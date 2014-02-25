package alexndr.SimpleOres.api.helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.client.Minecraft;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.StatCollector;
import alexndr.SimpleOres.core.Settings;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UpdateCheckerHelper implements IConnectionHandler
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
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login) 
	{
		if(Settings.enableUpdateChecker)
		{
			try
			{
				if(mods.size() != 0 && isModOutOfDate.size() != 0 && newVersions.size() != 0)
				{
					for(int i = 0; i < mods.size(); i++)
					{
						if(newVersions.get(mods.get(i)) != null)
						{
							if(isModOutOfDate.get(mods.get(i)) == true)
							{
								Minecraft.getMinecraft().thePlayer.addChatMessage(StatCollector.translateToLocal(mods.get(i) + ".updateMessage1") + newVersions.get(mods.get(i)) + StatCollector.translateToLocal(mods.get(i) + ".updateMessage2"));
							}
						}
					}
				}
			}
			
			catch(Exception e)
			{
				LogHelper.warning("Update checking failed for unknown reasons. Enable verbose logging and retry to see a stack-trace.");
				if(Settings.enableVerboseLogging)
				{
					e.printStackTrace();
				}
			}	
		}
	}

	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) {}
	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager) {return null;}
	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager) {}
	public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager){}
	public void connectionClosed(INetworkManager manager) {}
}
