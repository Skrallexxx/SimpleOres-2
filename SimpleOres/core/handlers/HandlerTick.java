package SimpleOres.core.handlers;

import java.util.EnumSet;

import SimpleOres.core.Achievements;
import SimpleOres.core.Armor;
import SimpleOres.core.Blocks;
import SimpleOres.core.Config;
import SimpleOres.core.Items;
import SimpleOres.core.Localisation;
import SimpleOres.core.Recipes;
import SimpleOres.core.Settings;
import SimpleOres.core.SimpleOres;
import SimpleOres.core.Tools;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class HandlerTick implements ITickHandler 
{
	/**
	 * Linking to the classes for easier reference.
	 */
	public static SimpleOres mod;
	public static Achievements achievements;
	public static Armor armor;
	public static Blocks blocks;
	public static Config config;
	public static Items items;
	public static Localisation local;
	public static Recipes recipes;
	public static Settings settings;
	public static Tools tools;
	
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
				if(itemID == tools.mythrilBow.itemID || itemID == tools.onyxBow.itemID)
				{
					mod.proxy.onBowUse(player.getItemInUse(), player);
					this.zoomAmount = 0.25F;
				}
			}
			
			else 
			{
				mod.proxy.resetSavedFOV();
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