package alexndr.SimpleOres.api;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import alexndr.SimpleOres.core.SimpleOres;
import alexndr.SimpleOres.core.conf.Settings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class SimpleSword extends ItemSword
{
	private final EnumToolMaterial material;
	private String modName = "simpleores";
	private CreativeTabs tab = SimpleOres.tabSimpleTools;

	public SimpleSword(int id, EnumToolMaterial toolmaterial) 
	{
		super(id, toolmaterial);
		this.material = toolmaterial;
		
		if(Settings.enableSeparateTabs == true)
		{
			this.setCreativeTab(tab);
		}
		else this.setCreativeTab(SimpleOres.tabSimpleBlocks);
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
		par3EntityPlayer.setInvisible(true);
		return par1ItemStack;
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
}
