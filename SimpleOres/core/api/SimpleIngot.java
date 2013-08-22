package SimpleOres.core.api;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import SimpleOres.core.SimpleOres;
import SimpleOres.core.conf.Settings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SimpleIngot extends Item
{	
	private String modName;
	
	public SimpleIngot(int i, String mod) 
	{
		super(i);
		modName = mod;
		
    	if(Settings.enableSeparateTabs == true)
    	{
            this.setCreativeTab(SimpleOres.tabSimpleMaterials);
    	}
    	else this.setCreativeTab(SimpleOres.tabSimpleBlocks);    

	}
	
    /**
     * Sets the icon for the item. 
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) 
    {
    	 this.itemIcon = iconRegister.registerIcon(modName + ":" + (this.getUnlocalizedName().substring(5)));
    }
}
