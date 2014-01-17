package alexndr.SimpleOres.plugins.aesthetics;

import alexndr.SimpleOres.api.helpers.TabHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockSimpleStairs extends BlockStairs
{
	protected BlockSimpleStairs(int par1, Block par2Block, int par3) 
	{
		super(par1, par2Block, par3);
		this.setCreativeTab(TabHelper.getBlocksTab());
	}
}
