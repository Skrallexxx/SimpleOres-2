package SimpleOres.core.gui;

import SimpleOres.core.Tools;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabTools extends CreativeTabs
{
	/**
	 * Class for the "SimpleOres Tools" Creative Tab.
	 */
	public TabTools(String label) {
		super(label);
	}
	
	/**
	 * Sets the icon for the tab.
	 */
	@Override
	public ItemStack getIconItemStack() 
	{
	    return new ItemStack(Tools.onyxPick);
	}
}
