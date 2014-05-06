package alexndr.SimpleOres.api.helpers;

import net.minecraft.creativetab.CreativeTabs;

@SuppressWarnings("static-access")
public class TabHelper 
{
	private static boolean tabs = CoreHelper.coreSettings.enableSimpleOresTabs;
	private static boolean separateTabs = CoreHelper.coreSettings.enableSeparateTabs;
	
	/**
	 * Determines which CreativeTab the item should be placed in depending on certain config options.
	 * Supports plugin tabs.
	 */
	public static CreativeTabs getBlocksTab(CreativeTabs tab)
	{
		if(tabs)
		{
			if(tab != CoreHelper.simpleores.tabSimpleBlocks)
			{
				return tab;
			}
			else return CoreHelper.simpleores.tabSimpleBlocks;
		}
		else return CreativeTabs.tabBlock;
	}
	
	/**
	 * Determines which CreativeTab the item should be placed in depending on certain config options.
	 * Doesn't support plugin tabs.
	 */
	public static CreativeTabs getBlocksTab()
	{
		if(tabs)
		{
			return CoreHelper.simpleores.tabSimpleBlocks;
		}
		else return CreativeTabs.tabBlock;
	}
	
	/**
	 * Determines which CreativeTab the item should be placed in depending on certain config options.
	 * Supports plugin tabs.
	 */
	public static CreativeTabs getDecorationsTab(CreativeTabs tab)
	{
		if(tabs)
		{
			if(separateTabs)
			{
				if(tab != CoreHelper.simpleores.tabSimpleDecorations)
				{
					return tab;
				}
				else return CoreHelper.simpleores.tabSimpleDecorations;
			}
			else return CoreHelper.simpleores.tabSimpleBlocks;
		}
		else return CreativeTabs.tabDecorations;
	}
	
	/**
	 * Determines which CreativeTab the item should be placed in depending on certain config options.
	 * Doesn't support plugin tabs.
	 */
	public static CreativeTabs getDecorationsTab()
	{
		if(tabs)
		{
			if(separateTabs)
			{
				return CoreHelper.simpleores.tabSimpleDecorations;
			}
			else return CoreHelper.simpleores.tabSimpleBlocks;
		}
		else return CreativeTabs.tabDecorations;
	}
	
	/**
	 * Determines which CreativeTab the item should be placed in depending on certain config options.
	 * Supports plugin tabs.
	 */
	public static CreativeTabs getToolsTab(CreativeTabs tab)
	{
		if(tabs)
		{
			if(separateTabs)
			{
				if(tab != CoreHelper.simpleores.tabSimpleTools)
				{
					return tab;
				}
				else return CoreHelper.simpleores.tabSimpleTools;
			}
			else return CoreHelper.simpleores.tabSimpleBlocks;
		}
		else return CreativeTabs.tabTools;
	}
	
	/**
	 * Determines which CreativeTab the item should be placed in depending on certain config options.
	 * Doesn't support plugin tabs.
	 */
	public static CreativeTabs getToolsTab()
	{
		if(tabs)
		{
			if(separateTabs)
			{
				return CoreHelper.simpleores.tabSimpleTools;
			}
			else return CoreHelper.simpleores.tabSimpleBlocks;
		}
		else return CreativeTabs.tabTools;
	}
	
	/**
	 * Determines which CreativeTab the item should be placed in depending on certain config options.
	 * Supports plugin tabs.
	 */
	public static CreativeTabs getCombatTab(CreativeTabs tab)
	{
		if(tabs)
		{
			if(separateTabs)
			{
				if(tab != CoreHelper.simpleores.tabSimpleCombat)
				{
					return tab;
				}
				else return CoreHelper.simpleores.tabSimpleCombat;	
			}
			else return CoreHelper.simpleores.tabSimpleBlocks;
		}
		else return CreativeTabs.tabCombat;
	}
	
	/**
	 * Determines which CreativeTab the item should be placed in depending on certain config options.
	 * Doesn't support plugin tabs.
	 */
	public static CreativeTabs getCombatTab()
	{
		if(tabs)
		{
			if(separateTabs)
			{
				return CoreHelper.simpleores.tabSimpleCombat;	
			}
			else return CoreHelper.simpleores.tabSimpleBlocks;
		}
		else return CreativeTabs.tabCombat;
	}
	
	/**
	 * Determines which CreativeTab the item should be placed in depending on certain config options.
	 * Supports plugin tabs.
	 */
	public static CreativeTabs getMaterialsTab(CreativeTabs tab)
	{
		if(tabs)
		{
			if(separateTabs)
			{
				if(tab != CoreHelper.simpleores.tabSimpleMaterials)
				{
					return tab;
				}
				else return CoreHelper.simpleores.tabSimpleMaterials;
			}
			else return CoreHelper.simpleores.tabSimpleBlocks;
		}
		else return CreativeTabs.tabMaterials;
	}
	
	/**
	 * Determines which CreativeTab the item should be placed in depending on certain config options.
	 * Doesn't support plugin tabs.
	 */
	public static CreativeTabs getMaterialsTab()
	{
		if(tabs)
		{
			if(separateTabs)
			{
				return CoreHelper.simpleores.tabSimpleMaterials;
			}
			else return CoreHelper.simpleores.tabSimpleBlocks;
		}
		else return CreativeTabs.tabMaterials;
	}
}
