package alexndr.SimpleOres.plugins.netherrocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import alexndr.SimpleOres.api.helpers.TabHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NetherSword extends ItemSword
{
	private final ToolMaterial toolMaterial;
	
	public NetherSword(ToolMaterial par2EnumToolMaterial) 
	{
		super(par2EnumToolMaterial);
		this.toolMaterial = par2EnumToolMaterial;
		this.setCreativeTab(TabHelper.getCombatTab());
	}
	
    /**
     * Sets the icon for the item. 
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) 
    {
    	 this.itemIcon = iconRegister.registerIcon("netherrocks:" + (this.getUnlocalizedName().substring(5)));
    }
    
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return this.toolMaterial.customCraftingMaterial == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
    
    /**	
     * Adds special effects to the Fyrite and Illumenite Swords.
     */
    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	if(this == Content.fyrite_sword)
    	{
            par2EntityLivingBase.setFire(100);
    	}
    	
    	if(this == Content.illumenite_sword)
    	{
            par3EntityLivingBase.addPotionEffect(new PotionEffect(Potion.nightVision.id, Settings.illumeniteSwordNVLength));
            par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.blindness.id, Settings.illumeniteSwordBlindnessLength));
            
            if(!(par2EntityLivingBase instanceof EntityPlayer))
            {
            	par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, Settings.illumeniteSwordSlowLength, Settings.illumeniteSwordSlowAmplifier));
            }
    	}
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        return true;
    }
	
    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	if(this == Content.fyrite_sword)
    	{
            if (par7 == 0)
            {
                --par5;
            }

            if (par7 == 1)
            {
                ++par5;
            }

            if (par7 == 2)
            {
                --par6;
            }

            if (par7 == 3)
            {
                ++par6;
            }

            if (par7 == 4)
            {
                --par4;
            }

            if (par7 == 5)
            {
                ++par4;
            }

            if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
            {
                return false;
            }
            else
            {
                Block var11 = par3World.getBlock(par4, par5, par6);

                if (var11 == Blocks.air)
                {
                    par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                    par3World.setBlock(par4, par5, par6, Blocks.fire);
                    par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() + 1);
                }

                return true;
            }
    	}
    	return false;  	
    }
	
	/**
	 * Registers the item in the GameRegistry, with the name given, and sends the name through to setUnlocalizedName in the super class.
	 */
	public NetherSword setUnlocalizedName(String unlocalizedName)
	{
		super.setUnlocalizedName(unlocalizedName);
		GameRegistry.registerItem(this, unlocalizedName);
		return this;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if(this == Content.fyrite_sword)
		{
			par3List.add(StatCollector.translateToLocal("netherrocks.fyrite_sword.info"));
		}
		if(this == Content.illumenite_sword)
		{
			par3List.add(StatCollector.translateToLocal("netherrocks.illumenite_sword.info"));
		}
	}
}
