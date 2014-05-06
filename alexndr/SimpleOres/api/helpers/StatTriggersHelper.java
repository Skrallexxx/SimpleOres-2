package alexndr.SimpleOres.api.helpers;

import java.util.ArrayList;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

import com.google.common.collect.Lists;

public class StatTriggersHelper
{
	private static final StatTriggersHelper statTriggers = new StatTriggersHelper();
	
	private ArrayList<ItemStack> craftingItems = Lists.newArrayList();
	private ArrayList<Achievement> craftingAchievs = Lists.newArrayList();
	private ArrayList<ItemStack> smeltingItems = Lists.newArrayList();
	private ArrayList<Achievement> smeltingAchievs = Lists.newArrayList();
	private ArrayList<ItemStack> pickupItems = Lists.newArrayList();
	private ArrayList<Achievement> pickupAchievs = Lists.newArrayList();
	
	public static final StatTriggersHelper statTriggers()
	{
		return statTriggers;
	}
	
	/**
	 * Add a Crafting Grid trigger for an Achievement.
	 * 
	 * @param itemTakenFromCrafting The ItemStack that you want to trigger the Achievement when it is taken from the Crafting Grid output slot.
	 * @param achievementToTrigger The Achievement that you want to trigger.
	 */
	public void addCraftingTrigger(ItemStack itemstackTakenFromCrafting, Achievement achievementToTrigger)
	{
		this.craftingItems.add(itemstackTakenFromCrafting);
		this.craftingAchievs.add(achievementToTrigger);
	}
	
	/**
	 * Add a Furnace trigger for an Achievement.
	 * 
	 * @param itemTakenFromSmelting The ItemStack that you want to trigger the Achievement when it is taken from the Furnace output slot.
	 * @param achievementToTrigger The Achievement that you want to trigger.
	 */
	public void addSmeltingTrigger(ItemStack itemstackTakenFromSmelting, Achievement achievementToTrigger)
	{
		this.smeltingItems.add(itemstackTakenFromSmelting);
		this.smeltingAchievs.add(achievementToTrigger);
	}
	
	/**
	 * Add an item pickup trigger for an Achievement.
	 * 
	 * @param itemstackPickedUp The ItemStack that you want to trigger the Achievement when it is picked up.
	 * @param achievementToTrigger The Achievement that you want to trigger.
	 */
	public void addPickupTrigger(ItemStack itemstackPickedUp, Achievement achievementToTrigger)
	{
		this.pickupItems.add(itemstackPickedUp);
		this.pickupAchievs.add(achievementToTrigger);
	}

	public void notifyCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) 
	{
		if(craftingItems.size() == craftingAchievs.size() && craftingItems.size() != 0)
		{
			for(int i = 0; i < craftingItems.size(); i ++)
			{
				if(item.getItem() == craftingItems.get(i).getItem())
				{
					player.addStat(craftingAchievs.get(i), 1);
				}
			}
		}
	}

	public void notifySmelting(EntityPlayer player, ItemStack item) 
	{
		if(smeltingItems.size() == smeltingAchievs.size() && smeltingItems.size() != 0)
		{
			for(int i = 0; i < smeltingItems.size(); i ++)
			{
				if(item.getItem() == smeltingItems.get(i).getItem())
				{
					player.addStat(smeltingAchievs.get(i), 1);
				}
			}
		}
	}

	public void notifyPickup(EntityItem item, EntityPlayer player) 
	{
		if(pickupItems.size() == pickupAchievs.size() && pickupItems.size() != 0)
		{
			for(int i = 0; i < pickupItems.size(); i++)
			{
				if(item.getEntityItem().getItem() == pickupItems.get(i).getItem())
				{
					player.addStat(pickupAchievs.get(i), 1);
				}
			}
		}
	}
}
