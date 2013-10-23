package SimpleOres.core.api;

import SimpleOres.core.Settings;
import SimpleOres.core.SimpleOres;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class SimpleArmor extends ItemArmor
{	
	/**
	 * The EnumArmorMaterial for the armor. This is used to set what item can be used to repair it.
	 */
    private final EnumArmorMaterial material;
    private String texturePath;
    private String modName;
	
	/**
	 * Constructor for the armor items. Most things should be fairly straight forward.
	 */
	public SimpleArmor(int ID, EnumArmorMaterial armormaterial, int renderer, int slotNumber, String type, String mod, CreativeTabs tab) 
	{
		super(ID, armormaterial, renderer, slotNumber);
        this.material = armormaterial;
        this.modName = mod;
        
    	if(Settings.enableSeparateTabs == true)
    	{
            this.setCreativeTab(tab);
    	}
    	else this.setCreativeTab(SimpleOres.tabSimpleBlocks);
    	
    	this.setArmorType(mod, type.toLowerCase(), slotNumber);
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

    public void setArmorType(String mod, String type, int slotNumber)
    {
    	switch(slotNumber)
    	{  	
    		case 0:
    		{
    			this.texturePath = mod + ":textures/models/armor/" + type +"_1.png";
    		}
    		break;
    		
    		case 1:
    		{
    			this.texturePath = mod + ":textures/models/armor/" + type +"_1.png";
    		}
    		break;
    		
    		case 2:
    		{
    			this.texturePath = mod + ":textures/models/armor/" + type +"_2.png";
    		}
    		break;
    		
    		case 3:
    		{
    			this.texturePath = mod + ":textures/models/armor/" + type +"_1.png";
    		}
    		break;
    	}
    }
    
    public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, int layer)
    {
    	return this.texturePath;
    }
	
	/**
	 * Determines whether or not the item can be repaired and what item should be used to repair it. In this case, it gets the item associated with the EnumArmorMaterial.
	 * The associated item is set in the main mod class, in the load method.
	 */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return this.material.getArmorCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
}
