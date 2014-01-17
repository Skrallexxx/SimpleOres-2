package alexndr.SimpleOres.api.content;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import alexndr.SimpleOres.api.helpers.TabHelper;
import alexndr.SimpleOres.core.SimpleOres;
import alexndr.SimpleOres.core.conf.Settings;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SimpleArmor extends ItemArmor
{
	private final EnumArmorMaterial material;
	private String texturePath;
	private String type = "";
	private String modName = "simpleores";
	private int slotnumber;
	private CreativeTabs tab = SimpleOres.tabSimpleCombat;

	/**
	 * Constructor for armor items.
	 */
	public SimpleArmor(int id, EnumArmorMaterial armormaterial, int renderer, int slotnumber) 
	{
		super(id, armormaterial, renderer, slotnumber);
		this.material = armormaterial;
		this.slotnumber = slotnumber;
		this.setCreativeTab(TabHelper.getCombatTab(tab));
	}	
	
	/**
	 * Sets the type of armor, ie. "copper", "mythril", etc. Needs to match the names of the image files. ie. copper_1.png.
	 */
	public SimpleArmor setType(String armorType)
	{
		type = armorType;
		this.setArmorTexturePath(modName, type, slotnumber);
		return this;
	}
	
	/**
	 * The modID of the mod adding the armor item. Used to find textures. Defaults to "simpleores".
	 * *MUST* be put BEFORE setType or else setType will default to using "simpleores" as the modName.
	 */
	public SimpleArmor modId(String modId)
	{
		modName = modId;
		return this;
	}
	
	/**
	 * Sets the creative tab for the armor to appear in. Defaults to SimpleOres.tabSimpleCombat.
	 */
	public SimpleArmor setTab(CreativeTabs creativetabs)
	{
		tab = creativetabs;
		this.setCreativeTab(TabHelper.getCombatTab(tab));
		return this;
	}
	
	/**
	 * Registers the item in the GameRegistry, with the name given, and sends the name through to setUnlocalizedName in the super class.
	 */
	public SimpleArmor setUnlocalizedName(String unlocalizedName)
	{
		super.setUnlocalizedName(unlocalizedName);
		GameRegistry.registerItem(this, unlocalizedName);
		return this;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(modName + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	public void setArmorTexturePath(String mod, String type, int slotNumber)
	{
		switch(slotNumber)
		{
			case 0:
			{
				this.texturePath = mod + ":textures/models/armor/" + type + "_1.png";
			}
			break;
			
			case 1:
			{
				this.texturePath = mod + ":textures/models/armor/" + type + "_1.png";
			}
			break;
			
			case 2:
			{
				this.texturePath = mod + ":textures/models/armor/" + type + "_2.png";
			}
			break;
			
			case 3:
			{
				this.texturePath = mod + ":textures/models/armor/" + type + "_1.png";
			}
			break;
		}
	}
	
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, int layer)
	{
		return this.texturePath;
	}
	
	public boolean getIsRepairable(ItemStack itemstack, ItemStack itemstack1)
	{
		return this.material.getArmorCraftingMaterial() == itemstack1.itemID ? true : super.getIsRepairable(itemstack, itemstack1);
	}
}
