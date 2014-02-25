package alexndr.SimpleOres.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.common.collect.Lists;

import alexndr.SimpleOres.core.ModInfo;
import alexndr.SimpleOres.core.conf.Settings;
import net.minecraft.client.Minecraft;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HandlerUpdateChecker implements IConnectionHandler
{
	static StringBuffer newVersion = new StringBuffer();
	static ArrayList<String> mods = Lists.newArrayList();
	static HashMap<String, Boolean> isModOutOfDate = new HashMap<String, Boolean>();
	static HashMap<String, String> newVersions = new HashMap<String, String>();
	static String VERSION = "1.0.0";
	
	public static void checkUpdates(String linkToVersionFile, String modId, String modInfoClassVersion)
	{
		try
		{
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
				}
			}
		}
		
		catch(Exception e)
		{
			HandlerLogger.logWarning("Update checker(s) could not reach server. The connection probably Timed Out.");
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
			if(mods.size() != 0 && isModOutOfDate.size() != 0 && newVersions.size() != 0)
			{
				for(int i = 0; i < mods.size(); i++)
				{
					if(isModOutOfDate.get(mods.get(i)) == true)
					{
						Minecraft.getMinecraft().thePlayer.addChatMessage(StatCollector.translateToLocal(mods.get(i) + ".updateMessage1") + newVersions.get(mods.get(i)) + StatCollector.translateToLocal(mods.get(i) + ".updateMessage2"));
					}
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
