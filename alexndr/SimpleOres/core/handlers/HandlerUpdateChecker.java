package alexndr.SimpleOres.core.handlers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import alexndr.SimpleOres.api.HandlerLogger;
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
	static Boolean isOutOfDate = false;
	
	public static void checkUpdates()
	{
		try
		{
			URL url = new URL("http://dl.dropboxusercontent.com/u/66466201/SimpleOres%202%20Version.txt");
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
				
				int versionInt = Integer.parseInt(ModInfo.VERSION.replace(".", ""));
				int newVersionInt = Integer.parseInt(newVersion.toString().replace(".", ""));
				
				if(newVersionInt > versionInt)
				{
					isOutOfDate = true;
				}
			}
		}
		
		catch(Exception e)
		{
			HandlerLogger.logWarning("Update checker could not reach server. The connection probably Timed Out.");
		}
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login) 
	{
		if(Settings.enableUpdateChecker)
		{
			if(isOutOfDate)
			{
				Minecraft.getMinecraft().thePlayer.addChatMessage(StatCollector.translateToLocal("simpleores.updateMessage1") + newVersion + StatCollector.translateToLocal("simpleores.updateMessage2"));
			}
		}
	}

	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) {}
	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager) {return null;}
	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager) {}
	public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager){}
	public void connectionClosed(INetworkManager manager) {}
}
