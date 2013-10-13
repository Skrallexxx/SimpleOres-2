package SimpleOres.core.gui;

import SimpleOres.core.Blocks;
import SimpleOres.core.conf.Settings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabDecoration extends CreativeTabs
{
	/**
	 * Class for the "SimpleOres Decoration" Creative Tab.
	 */
	public TabDecoration(String label) {
		super(label);
	}
	
	/**
	 * Sets the icon for the tab.
	 */
	@Override
	public ItemStack getIconItemStack() 
	{
	    return new ItemStack(Blocks.mythrilFurnace);
	}
}
