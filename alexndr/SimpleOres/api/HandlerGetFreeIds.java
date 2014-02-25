package alexndr.SimpleOres.api;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.google.common.collect.Lists;

public class HandlerGetFreeIds 
{
	static ArrayList<Integer> blockIds = Lists.newArrayList();
	static ArrayList<Integer> itemIds = Lists.newArrayList();
	
	/**
	 * Compiles a list of free Ids. Call this once in your config.
	 */
	public static void compileIdList()
	{
		for(int i = 500; i < Block.blocksList.length; i++)
		{
			if(Block.blocksList[i] == null)
			{
				blockIds.add(i);
			}
		}
		
		for(int i = 5000; i <Item.itemsList.length; i++)
		{
			if(Item.itemsList[i] == null)
			{
				itemIds.add(i);
			}
		}
	}
	
	/**
	 * Returns a free block Id. Call this for each Id you need.
	 */
	public static int freeBlock()
	{
		for(int i = 0; i < blockIds.size(); i++)
		{
			if((Block.blocksList[blockIds.get(i)] == null))
			{
				int ret = blockIds.get(i);
				blockIds.remove(i);
				return ret;
			}
		}
		return 0;
	}
	
	/**
	 * Returns a free item Id. Call this for each Id you need. Auto-shifts the Id by -256.
	 */
	public static int freeItem()
	{
		for(int i = 0; i < itemIds.size(); i++)
		{
			if((Item.itemsList[itemIds.get(i)] == null))
			{
				int ret = itemIds.get(i);
				itemIds.remove(i);
				return ret - 256;
			}
		}
		return 0;
	}
}
