package alexndr.SimpleOres.api;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SimpleTab extends CreativeTabs
{
	private ItemStack icon;
	
	public SimpleTab(String label) 
	{
		super(label);
	}
	
	public SimpleTab setIcon(ItemStack iconToSet)
	{
		this.icon = iconToSet;
		return this;
	}
	
	@Override
	public ItemStack getIconItemStack()
	{
		return icon;
	}

}
