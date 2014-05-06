package alexndr.SimpleOres.api.content;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import alexndr.SimpleOres.api.helpers.TabHelper;
import alexndr.SimpleOres.core.SimpleOres;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SimpleIngot extends Item
{
	private String modName = "simpleores";
	private String infoString;
	private CreativeTabs tab = SimpleOres.tabSimpleMaterials;
	private boolean infoAdded = false;
	
	public SimpleIngot() 
	{
		super();
		this.setCreativeTab(TabHelper.getMaterialsTab(tab));
	}
	
	/**
	 * The modID of the mod adding the item. Used to find textures. Defaults to "simpleores".
	 */
	public SimpleIngot modId(String modId)
	{
		this.modName = modId;
		
		return this;
	}
	
	/**
	 * Sets the creative tab for the item to appear in. Defaults to SimpleOres.tabSimpleMaterials.
	 */
	public SimpleIngot setTab(CreativeTabs creativetab)
	{
		tab = creativetab;
		this.setCreativeTab(TabHelper.getMaterialsTab(tab));
		return this;
	}
	
	/**
	 * Adds a tooltip to the item. Must be unlocalised, so you need to have it somewhere in your lang files.
	 * @param info A String normally in format modId.theItem.info.
	 */
	public SimpleIngot addInfo(String info)
	{
		infoString = info;
		infoAdded = true;
		return this;
	}
	
	/**
	 * Registers the item in the GameRegistry, with the name given, and sends the name through to setUnlocalizedName in the super class.
	 */
	public SimpleIngot setUnlocalizedName(String unlocalizedName)
	{
		super.setUnlocalizedName(unlocalizedName);
		GameRegistry.registerItem(this, unlocalizedName);
		return this;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(modName + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if(infoAdded)
		{
			par3List.add(StatCollector.translateToLocal(infoString));
		}
	}
}
