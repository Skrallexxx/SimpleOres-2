package alexndr.SimpleOres.api.content;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import alexndr.SimpleOres.api.helpers.TabHelper;
import alexndr.SimpleOres.core.SimpleOres;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SimpleOre extends Block
{
	private String modName = "simpleores";
	private ItemStack stackDrop = null;
	private CreativeTabs tab = SimpleOres.tabSimpleBlocks;
	
	/**
	 * Constructor for a basic block.
	 */
	public SimpleOre(int id, Material material) 
	{
		super(id, material);
		this.setCreativeTab(TabHelper.getBlocksTab(tab));
	}
	
	/**
	 * Registers the textures for the blocks.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(modName + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	/**
	 * The modID of the mod adding the block. Used to find textures. Defaults to "simpleores".
	 */
	public SimpleOre modId(String modId)
	{
		modName = modId;
		return this;
	}
	
	/**
	 * Sets the creative tab for the block to appear in. Defaults to SimpleOres.tabSimpleBlocks.
	 */
	public SimpleOre setTab(CreativeTabs creativetab)
	{
		tab = creativetab;
		this.setCreativeTab(TabHelper.getBlocksTab(tab));
		return this;
	}
	
	/**
	 * Sets an itemstack to drop when the block is destroyed. Only used if block drops something other than itself.
	 */
	public SimpleOre setStackToDrop(ItemStack stack)
	{
		this.stackDrop = stack;
		return this;
	}
	
	/**
	 * Registers the block in the GameRegistry, with the name given, and sends the name through to setUnlocalizedName in the super class.
	 */
	public SimpleOre setUnlocalizedName(String unlocalizedName)
	{
		super.setUnlocalizedName(unlocalizedName);
		GameRegistry.registerBlock(this, unlocalizedName);
		return this;
	}
	
	/**
	 * The ID dropped when the block is broken.
	 */
	@Override
	public int idDropped(int i, Random random, int j)
	{
		if(stackDrop != null)
		{
			if(stackDrop.itemID > 255)
			{
				return stackDrop.itemID;
			}
			else return stackDrop.itemID;

		}
		else return this.blockID;
	}
	
	/**
	 * If the item dropped is not the block itself, then spawns a random amount of XP.
	 */
	@Override
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

        if (this.idDropped(par5, par1World.rand, par7) != this.blockID)
        {
        	int var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 16, 33);

            this.dropXpOnBlockBreak(par1World, par2, par3, par4, var8);
        }
    }
	
	/**
	 * Determines how many items are dropped when using a Fortune pickaxe. Only effects blocks that drop items when broken.
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
	
	protected boolean canSilkHarvest()
	{
		return true;
	}
}
