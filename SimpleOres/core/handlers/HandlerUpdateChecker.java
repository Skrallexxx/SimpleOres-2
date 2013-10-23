package SimpleOres.core.handlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.StatCollector;

import SimpleOres.core.ModInfo;
import SimpleOres.core.Settings;

import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

public class HandlerUpdateChecker implements IConnectionHandler
{
	static String link = "http://dl.dropboxusercontent.com/u/66466201/SimpleOres%202%20Version.txt";
	static String line = null;
	
	static BufferedReader reader;
	static StringBuffer newVersion = new StringBuffer();
	
	static int versionInt;
	static int newVersionInt;
	
	static boolean isOutOfDate = false;
	
	/**
	 * Checks if there is a higher version of SimpleOres available. It grabs a version string from a text file on my dropbox, then compares it to the current version of the mod.
	 * 
	 * If the current version is lower, it tells the player there is a new version available, what version is available, and gives them a link to it.
	 */
	public static void checkUpdates()
	{
		
	}
	
	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) {}
	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager) {return null;}
	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager) {}
	public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager) {}
	public void connectionClosed(INetworkManager manager) {}

	@Override
	public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login) 
	{
		if(Settings.enableUpdateChecker)
		{		
			try 
			{
				URL url = new URL(link);
				reader = new BufferedReader(new InputStreamReader(url.openStream()));
							
				while((line = reader.readLine()) != null)
				{
					newVersion.append(line);
				}
				
				String versionNum = ModInfo.VERSION.replace(".", "");
				String newVersionNum = newVersion.toString().replace(".", "");
				
				versionInt = Integer.parseInt(versionNum);
				newVersionInt = Integer.parseInt(newVersionNum);
				
				if(newVersionInt > versionInt)
				{
					isOutOfDate = true;
				}
			} 
			
			catch (Exception e) 
			{
				System.out.println("[SimpleOres 2] Update checker could not reach server (Connection Timed Out). If you're offline or behind a proxy, this is fine. If not, let me know, there may be something wrong on my end.");
			}
			
			if(isOutOfDate)
			{
				Minecraft.getMinecraft().thePlayer.addChatMessage(StatCollector.translateToLocal("simpleores.updateMessage1") + newVersion + StatCollector.translateToLocal("simpleores.updateMessage2"));
			}
		}
	}
}
