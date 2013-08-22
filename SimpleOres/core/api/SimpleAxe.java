package SimpleOres.core.api;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import SimpleOres.core.SimpleOres;
import SimpleOres.core.conf.Settings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class SimpleAxe extends ItemAxe
{
	/**
	 * The EnumToolMaterial for the tool. This is used to set what item can be used to repair it.
	 */
    private final EnumToolMaterial material;
    private String modName;
    
    /**
     * Main constructor for the axes added by SimpleOres.
     * 
     * @param i = the items ID
     * @param enumtoolmaterial = the material of the tool. Determines speed, number of uses, etc.
     */
	public SimpleAxe(int i, EnumToolMaterial enumtoolmaterial, String mod) 
	{
		super(i, enumtoolmaterial);
		material = enumtoolmaterial;
		modName = mod;
		
    	if(Settings.enableSeparateTabs == true)
    	{
            this.setCreativeTab(SimpleOres.tabSimpleTools);
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
	
	/**
	 * Determines if the tool is repairable, and gets the item which can be used to repair it depending on the material of the tool.
	 * 
	 * For example, a copper axe can be repaired with a copper ingot, a mythril axe with a mythril ingot.
	 */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return this.material.getToolCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
}
