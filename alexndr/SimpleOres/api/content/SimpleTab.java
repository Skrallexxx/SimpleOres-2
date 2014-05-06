package alexndr.SimpleOres.api.content;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SimpleTab extends CreativeTabs
{
	private Item icon;
	
	public SimpleTab(String label) 
	{
		super(label);
	}
	
	public SimpleTab setIcon(ItemStack iconToSet)
	{
		this.icon = iconToSet.getItem();
		return this;
	}

	@Override
	public Item getTabIconItem() 
	{
		return icon;
	}

}
