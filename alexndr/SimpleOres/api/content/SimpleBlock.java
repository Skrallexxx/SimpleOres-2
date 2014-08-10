package alexndr.SimpleOres.api.content;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import alexndr.SimpleOres.api.helpers.TabHelper;
import alexndr.SimpleOres.core.SimpleOres;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SimpleBlock extends Block
{
	private String modName = "simpleores";
	private boolean isBeaconBase = false;
	private ItemStack stackDrop = null;
	private CreativeTabs tab = SimpleOres.tabSimpleBlocks;
	
	/**
	 * Constructor for a basic block.
	 */
	public SimpleBlock(Material material) 
	{
		super(material);
		this.setCreativeTab(TabHelper.getBlocksTab(tab));
	}
	
	/**
	 * Registers the textures for the blocks.
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(modName + ":" + (this.getUnlocalizedName().substring(5)));
	}
	
	/**
	 * The modID of the mod adding the block. Used to find textures. Defaults to "simpleores".
	 */
	public SimpleBlock modId(String modId)
	{
		modName = modId;
		return this;
	}
	
	/**
	 * Sets the creative tab for the block to appear in. Defaults to SimpleOres.tabSimpleBlocks.
	 */
	public SimpleBlock setTab(CreativeTabs creativetab)
	{
		tab = creativetab;
		this.setCreativeTab(TabHelper.getBlocksTab(tab));
		return this;
	}
	
	/**
	 * Sets an itemstack to drop when the block is destroyed. Only used if block drops something other than itself.
	 */
	public SimpleBlock setStackToDrop(ItemStack stack)
	{
		this.stackDrop = stack;
		return this;
	}
	
	/**
	 * Registers the block in the GameRegistry, with the name given, and sends the name through to setUnlocalizedName in the super class.
	 */
	public SimpleBlock setBlockName(String unlocalizedName)
	{
		super.setBlockName(unlocalizedName);
		GameRegistry.registerBlock(this, unlocalizedName);
		return this;
	}
	
	/**
	 * Registers the block as a suitable block to be used for the base of a beacon.
	 * @return
	 */
	public SimpleBlock setAsBeaconBase(boolean setAsBase)
	{
		this.isBeaconBase = setAsBase;
		return this;
	}
	
	/**
	 * The ID dropped when the block is broken.
	 */
	@Override
	public Item getItemDropped(int i, Random random, int j)
	{
		if(stackDrop != null)
		{
			return stackDrop.getItem();
		}
		else return Item.getItemFromBlock(this);
	}
	
	/**
	 * If the item dropped is not the block itself, then spawns a random amount of XP.
	 */
	@Override
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

        if (this.getItemDropped(par5, par1World.rand, par7) != Item.getItemFromBlock(this))
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
        if (par1 > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, par2Random, par1))
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
    
    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
    {
    	return isBeaconBase;
    }
	
	protected boolean canSilkHarvest()
	{
		return true;
	}
}
