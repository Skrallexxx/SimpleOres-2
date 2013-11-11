package SimpleOres.plugins.machines;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import SimpleOres.core.Settings;
import SimpleOres.core.SimpleOres;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ToolDeconstructor extends BlockContainer
{
	public static SimpleOres simpleores;
	private final Random blockRand = new Random();
	private static boolean keepBlockInventory = false;
	@SideOnly(Side.CLIENT)
	private Icon blockIconTop;
	@SideOnly(Side.CLIENT)
	private Icon blockIconFront;
	
	public ToolDeconstructor(int par1) 
	{
		super(par1, Material.iron);

		if(Settings.enableSeparateTabs)
		{
			this.setCreativeTab(simpleores.tabSimpleDecorations);
		}
	}
	
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
	}
	
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
	}
	
	private void setDefaultDirection(World world, int i, int j, int k)
	{
		if(!world.isRemote)
		{
            int l = world.getBlockId(i, j, k - 1);
            int i1 = world.getBlockId(i, j, k + 1);
            int j1 = world.getBlockId(i - 1, j, k);
            int k1 = world.getBlockId(i + 1, j, k);
            byte b0 = 3;
            
            if(Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
            {
            	b0 = 3;
            }
            
            if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
            {
                b0 = 2;
            }

            if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
            {
                b0 = 5;
            }

            if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
            {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(i, j, k, b0, 2);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world) 
	{
		return null;
	}
}
