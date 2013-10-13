package SimpleOres.core.api;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import SimpleOres.core.Achievements;
import SimpleOres.core.Armor;
import SimpleOres.core.Blocks;
import SimpleOres.core.Config;
import SimpleOres.core.Items;
import SimpleOres.core.Localisation;
import SimpleOres.core.Recipes;
import SimpleOres.core.Settings;
import SimpleOres.core.SimpleOres;
import SimpleOres.core.Tools;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class SimpleOre extends Block
{
	private String modName;
	/**
	 * The main constructor for the blocks. 
	 * 
	 * @param par1 = ID of the block.
	 * @param material = The material of the block. This sets what tools are effective against it, the sounds it makes, etc.
	 */
	public SimpleOre(int par1, Material material, String mod, CreativeTabs tab) 
	{
		super(par1, material);
		this.modName = mod;
		
    	if(Settings.enableSeparateTabs == true)
    	{
            this.setCreativeTab(tab);
    	}
    	else this.setCreativeTab(SimpleOres.tabSimpleBlocks);
	}
	
	/**
	 * Sets the texture for the block.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) 
	{
		 this.blockIcon = iconRegister.registerIcon(modName + ":" + (this.getUnlocalizedName().substring(5)));
	}
    
    /**
     * Sets whether or not Silk Touch has an effect on this block. Returns true so that Onyx Ore will drop itself rather than the gem item.
     */
    protected boolean canSilkHarvest()
    {
        return true;
    }
}
