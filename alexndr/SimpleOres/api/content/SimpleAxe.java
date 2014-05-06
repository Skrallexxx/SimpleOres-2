package alexndr.SimpleOres.api.content;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import alexndr.SimpleOres.api.helpers.TabHelper;
import alexndr.SimpleOres.core.SimpleOres;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SimpleAxe extends ItemAxe
{
	private final ToolMaterial material;
	private String modName = "simpleores";
	private String infoString;
	private CreativeTabs tab = SimpleOres.tabSimpleTools;
	private boolean infoAdded = false;

	public SimpleAxe(ToolMaterial toolmaterial) 
	{
		super(toolmaterial);
		this.material = toolmaterial;
		this.setCreativeTab(TabHelper.getToolsTab(tab));
		this.setHarvestLevel("axe", material.getHarvestLevel());
	}
	
	/**
	 * The modID of the mod adding the item. Used to find textures. Defaults to "simpleores".
	 */
	public SimpleAxe modId(String modId)
	{
		this.modName = modId;
		return this;
	}
	
	/**
	 * Sets the creative tab for the item to appear in. Defaults to SimpleOres.tabSimpleTools.
	 */
	public SimpleAxe setTab(CreativeTabs creativetab)
	{
		this.tab = creativetab;
		this.setCreativeTab(TabHelper.getToolsTab(tab));
		return this;
	}
	
	/**
	 * Adds a tooltip to the item. Must be unlocalised, so you need to have it somewhere in your lang files.
	 * @param info A String normally in format modId.theItem.info.
	 */
	public SimpleAxe addInfo(String info)
	{
		infoString = info;
		infoAdded = true;
		return this;
	}
	
	/**
	 * Registers the item in the GameRegistry, with the name given, and sends the name through to setUnlocalizedName in the super class.
	 */
	public SimpleAxe setUnlocalizedName(String unlocalizedName)
	{
		super.setUnlocalizedName(unlocalizedName);
		GameRegistry.registerItem(this, unlocalizedName);
		return this;
	}
	
	/**
	 * Registers the textures for the items.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(modName + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	/**
	 * Determines if the tool is repairable and gets the item which can be used to repair it. 
	 */
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return this.material.customCraftingMaterial == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
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
