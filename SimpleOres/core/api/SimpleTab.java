package SimpleOres.core.api;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SimpleTab extends CreativeTabs
{
	ItemStack icon;
	public SimpleTab(String label)
	{
		super(label);
	}
	
	public SimpleTab setIcon(ItemStack iconToSet)
	{
		this.icon = iconToSet;
		return this;
	}
	
	/**
	 * Sets the icon for the tab.
	 */
	@Override
	public ItemStack getIconItemStack() 
	{
	    return icon;
	}
}
