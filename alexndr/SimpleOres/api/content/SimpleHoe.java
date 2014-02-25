package alexndr.SimpleOres.api.content;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import alexndr.SimpleOres.api.helpers.TabHelper;
import alexndr.SimpleOres.core.Settings;
import alexndr.SimpleOres.core.SimpleOres;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SimpleHoe extends ItemHoe
{
	private final EnumToolMaterial material;
	private String modName = "simpleores";
	private CreativeTabs tab = SimpleOres.tabSimpleTools;
	private String infoString;
	private boolean infoAdded = false;
	private boolean unlocalized = true;

	public SimpleHoe(int id, EnumToolMaterial toolmaterial) 
	{
		super(id, toolmaterial);
		this.material = toolmaterial;
		this.setCreativeTab(TabHelper.getToolsTab(tab));
	}
	
	/**
	 * The modID of the mod adding the item. Used to find textures. Defaults to "simpleores".
	 */
	public SimpleHoe modId(String modId)
	{
		this.modName = modId;
		return this;
	}
	
	/**
	 * Sets the creative tab for the item to appear in. Defaults to SimpleOres.tabSimpleTools.
	 */
	public SimpleHoe setTab(CreativeTabs creativetab)
	{
		this.tab = creativetab;
		this.setCreativeTab(TabHelper.getToolsTab(tab));
		return this;
	}
	
	/**
	 * Adds info to an item, shows up in the tooltip. Is always unlocalized.
	 */
	public SimpleHoe addInfo(String info)
	{
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		ItemStack stack = new ItemStack(this);
		List list = Lists.newArrayList();
		Boolean bool = true;
		infoString = info;
		infoAdded = true;
		unlocalized = true;
		
		addInformation(stack, player, list, bool);
		return this;
	}
	
	/**
	 * Adds info to an item, shows up in the tooltip. Supports an unlocalized 'info' which can be translated for localisations.
	 */
	public SimpleHoe addInfo(String info, boolean isUnlocalized)
	{
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		ItemStack stack = new ItemStack(this);
		List list = Lists.newArrayList();
		Boolean bool = true;
		infoString = info;
		infoAdded = true;
		unlocalized = isUnlocalized;
		
		addInformation(stack, player, list, bool);
		return this;
	}
	
	/**
	 * Registers the item in the GameRegistry, with the name given, and sends the name through to setUnlocalizedName in the super class.
	 */
	public SimpleHoe setUnlocalizedName(String unlocalizedName)
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
	public void registerIcons(IconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(modName + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	/**
	 * Determines if the tool is repairable and gets the item which can be used to repair it. 
	 */
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return this.material.getToolCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if(infoAdded)
		{
			if(unlocalized)
			{
				par3List.add(StatCollector.translateToLocal(infoString));
			}
			if(!unlocalized)
			{
				par3List.add(infoString);
			}
		}
	}
}
