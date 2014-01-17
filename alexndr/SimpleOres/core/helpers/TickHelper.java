package alexndr.SimpleOres.core.helpers;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import alexndr.SimpleOres.core.Content;
import alexndr.SimpleOres.core.SimpleOres;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class TickHelper implements ITickHandler
{
	public static float zoomAmount;

	/**
	 * Checks each tick to see if the player is using (right click) the specified items. If returns true (player IS using the item),
	 * it calls a certain method. If it returns false, it calls a seperate method.
	 * 
	 * In the case of the bows, if it returns true, it calls the zoom method (onBowUse) in ProxyCommon (which is overridden by ProxyClient).
	 * If it returns false, it calls the reset zoom method (resetSavedFOV) in ProxyCommon (which is also overridden by ProxyClient).
	 */
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		EntityPlayer player = Minecraft.getMinecraft().thePlayer; 
		
		if(type.equals(EnumSet.of(TickType.RENDER))) 
		{
			if(player != null && player.isUsingItem())
			{
				int itemID = player.getItemInUse().itemID;
				if(itemID == Content.mythrilBow.itemID || itemID == Content.onyxBow.itemID)
				{
					SimpleOres.proxy.onBowUse(player.getItemInUse(), player);
					this.zoomAmount = 0.25F;
				}
			}
			
			else 
			{
				SimpleOres.proxy.resetSavedFOV();
			}
		}  
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) 
	{
		
	}

	@Override
	public EnumSet<TickType> ticks() 
	{
		return EnumSet.of(TickType.RENDER);
	}

	@Override
	public String getLabel() 
	{
		return null;
	}
	
}
