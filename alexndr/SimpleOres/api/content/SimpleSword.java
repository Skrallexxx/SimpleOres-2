package alexndr.SimpleOres.api.content;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import alexndr.SimpleOres.api.helpers.TabHelper;
import alexndr.SimpleOres.core.SimpleOres;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SimpleSword extends ItemSword
{
	private final ToolMaterial material;
	private String modName = "simpleores";
	private String infoString;
	private CreativeTabs tab = SimpleOres.tabSimpleCombat;
	private boolean infoAdded = false;

	public SimpleSword(ToolMaterial toolmaterial) 
	{
		super(toolmaterial);
		this.material = toolmaterial;
		this.setCreativeTab(TabHelper.getCombatTab(tab));
	}
	
	/**
	 * The modID of the mod adding the item. Used to find textures. Defaults to "simpleores".
	 */
	public SimpleSword modId(String modId)
	{
		this.modName = modId;
		return this;
	}
	
	/**
	 * Sets the creative tab for the item to appear in. Defaults to SimpleOres.tabSimpleTools.
	 */
	public SimpleSword setTab(CreativeTabs creativetab)
	{
		this.tab = creativetab;
		this.setCreativeTab(TabHelper.getCombatTab(tab));
		return this;
	}
	
	/**
	 * Adds a tooltip to the item. Must be unlocalised, so you need to have it somewhere in your lang files.
	 * @param info A String normally in format modId.theItem.info.
	 */
	public SimpleSword addInfo(String info)
	{
		infoString = info;
		infoAdded = true;
		return this;
	}
	
	/**
	 * Registers the item in the GameRegistry, with the name given, and sends the name through to setUnlocalizedName in the super class.
	 */
	public SimpleSword setUnlocalizedName(String unlocalizedName)
	{
		super.setUnlocalizedName(unlocalizedName);
		GameRegistry.registerItem(this, unlocalizedName);
		return this;
	}
	
	/**
	 * Hehe, just a little easter egg for anyone clever enough to find it ;)
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if(par1ItemStack.hasDisplayName() == true)
		{
			if(par1ItemStack.getDisplayName().equals("AleXndrTheGr8st's Flight Stick"))
			{
				par3EntityPlayer.addVelocity(0, 0.4, 0);
			}
		}
		else
		{
			return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
		}
		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
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
