package SimpleOres.core.gui;

import SimpleOres.core.Blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabGeneral extends CreativeTabs
{
	/**
	 * Class for the "SimpleOres" Creative Tab. This tab only shows up if the useSeparateTabs boolean is set to false in the toggles file.
	 * If the toggle is set to false, all the SimpleOres content will be in this tab.
	 */
	public TabGeneral(String label) {
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
