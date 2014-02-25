package alexndr.SimpleOres.api.content;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import alexndr.SimpleOres.api.helpers.TabHelper;
import alexndr.SimpleOres.core.Settings;
import alexndr.SimpleOres.core.SimpleOres;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SimpleIngot extends Item
{
	private String modName = "simpleores";
	private CreativeTabs tab = SimpleOres.tabSimpleMaterials;
	private String infoString;
	private boolean infoAdded = false;
	private boolean unlocalized = true;
	
	public SimpleIngot(int id) 
	{
		super(id);
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
	 * Adds info to an item, shows up in the tooltip. Is always unlocalized.
	 */
	public SimpleIngot addInfo(String info)
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
	public SimpleIngot addInfo(String info, boolean isUnlocalized)
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
	public SimpleIngot setUnlocalizedName(String unlocalizedName)
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
