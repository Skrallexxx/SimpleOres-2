package SimpleOres.core.api;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import SimpleOres.core.Achievements;
import SimpleOres.core.Armor;
import SimpleOres.core.Blocks;
import SimpleOres.core.Items;
import SimpleOres.core.Recipes;
import SimpleOres.core.SimpleOres;
import SimpleOres.core.Tools;
import SimpleOres.core.conf.IDs;
import SimpleOres.core.conf.Localisation;
import SimpleOres.core.conf.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
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
	public SimpleOre(int par1, Material material, String mod) 
	{
		super(par1, material);
		this.modName = mod;
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
	 * Sets what item or block is dropped when the block is broken.
	 * For all the ores except onyx, they will drop themselves. Onyx will drop the gem item.
	 */
    public int idDropped(int i, Random random, int j)
    {
        if(blockID == Blocks.onyxOre.blockID)
        {
        	return Items.onyxGem.itemID;       	
        }
        
		return blockID;
    }
    
    /**
     * If the block drops something that is not itself (which is the case for onyx), then a random amount of XP is dropped.
     * This random amount is within the range of 16 to 33.
     */
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

        if (this.idDropped(par5, par1World.rand, par7) != this.blockID)
        {
            int var8 = 0;

            if (this.blockID == Blocks.onyxOre.blockID)
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 16, 33);
            }
            this.dropXpOnBlockBreak(par1World, par2, par3, par4, var8);
        }
    }
    
    /**
     * Determines the quantity dropped when you use a Fortune pickaxe. Only applies to blocks that don't drop themselves (onyx ore).
     */
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        if (par1 > 0 && this.blockID != this.idDropped(0, par2Random, par1))
        {
            int var3 = par2Random.nextInt(par1 + 2) - 1;

            if (var3 < 0)
            {
                var3 = 0;
            }

            return this.quantityDropped(par2Random) * (var3 + 1);
        }
        else
        {
            return this.quantityDropped(par2Random);
        }
    }
    
    /**
     * Sets whether or not Silk Touch has an effect on this block. Returns true so that Onyx Ore will drop itself rather than the gem item.
     */
    protected boolean canSilkHarvest()
    {
        return true;
    }
}
