package alexndr.SimpleOres.core.helpers;

import java.util.List;

import net.minecraft.util.ChatComponentText;
import alexndr.SimpleOres.api.helpers.LogHelper;
import alexndr.SimpleOres.api.helpers.StatTriggersHelper;
import alexndr.SimpleOres.api.helpers.UpdateCheckerHelper;
import alexndr.SimpleOres.core.Settings;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class EventHelper 
{
	public static float zoomAmount;
	
	@SubscribeEvent
	public void bowZoom(PlayerTickEvent event)
	{
	  
	}
	
	@SubscribeEvent
	public void onItemPickup(ItemPickupEvent event)
	{
		StatTriggersHelper.statTriggers().notifyPickup(event.pickedUp, event.player);
	}
	
	@SubscribeEvent
	public void onItemCrafted(ItemCraftedEvent event)
	{
		StatTriggersHelper.statTriggers().notifyCrafting(event.player, event.crafting, event.craftMatrix);
	}
	
	@SubscribeEvent
	public void onItemSmelted(ItemSmeltedEvent event)
	{
		StatTriggersHelper.statTriggers().notifySmelting(event.player, event.smelting);
	}
	
	@SubscribeEvent
	public void clientLoggedIn(PlayerLoggedInEvent event)
	{
		List<String> messages = UpdateCheckerHelper.getMessages();
		if(messages != null && messages.size() > 0)
		{
			try
			{
				for(int i = 0; i < messages.size(); i++)
				{
					event.player.addChatMessage(new ChatComponentText(messages.get(i)));
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
}
