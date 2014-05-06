package alexndr.SimpleOres.api.content;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import alexndr.SimpleOres.api.helpers.TabHelper;

public class SimpleStairs extends BlockStairs
{
	protected SimpleStairs(Block par2Block, int par3) 
	{
		super(par2Block, par3);
		this.setCreativeTab(TabHelper.getBlocksTab());
	}
}
