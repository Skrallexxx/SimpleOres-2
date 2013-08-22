package SimpleOres.core.gui;

import SimpleOres.core.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabMaterials extends CreativeTabs
{
	/**
	 * Class for the "SimpleOres Materials" Creative Tab.
	 */
	public TabMaterials(String label) {
		super(label);
	}
	
	/**
	 * Sets the icon for the tab.
	 */
	@Override
	public ItemStack getIconItemStack() 
	{
	    return new ItemStack(Items.adamantiumIngot);
	}	
}
