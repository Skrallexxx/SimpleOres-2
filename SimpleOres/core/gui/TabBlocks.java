package SimpleOres.core.gui;

import SimpleOres.core.Blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabBlocks extends CreativeTabs
{
	/**
	 * Class for the "SimpleOres Blocks" Creative Tab.
	 */
	public TabBlocks(String label) {
		super(label);
	}
	
	/**
	 * Sets the icon for the tab.
	 */
	@Override
	public ItemStack getIconItemStack() 
	{
	    return new ItemStack(Blocks.copperOre);
	}
}
