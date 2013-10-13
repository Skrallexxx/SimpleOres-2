package SimpleOres.core.gui;

import SimpleOres.core.Tools;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabCombat extends CreativeTabs
{
	/**
	 * Class for "SimpleOres Tools" Creative Tab.
	 */
	public TabCombat(String label) {
		super(label);
	}
	
	/**
	 * Sets the icon for the tab.
	 */
	@Override
	public ItemStack getIconItemStack() 
	{
	    return new ItemStack(Tools.copperSword);
	}
}
