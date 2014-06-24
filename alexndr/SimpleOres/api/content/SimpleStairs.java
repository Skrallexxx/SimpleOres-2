package alexndr.SimpleOres.api.content;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import alexndr.SimpleOres.api.helpers.TabHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class SimpleStairs extends BlockStairs
{
	public SimpleStairs(Block par2Block, int par3) 
	{
		super(par2Block, par3);
		this.setCreativeTab(TabHelper.getBlocksTab());
	}
	
	/**
	 * Registers the block in the GameRegistry, with the name given, and sends the name through to setBlockName in the super class.
	 */
	public SimpleStairs setBlockName(String unlocalizedName)
	{
		super.setBlockName(unlocalizedName);
		GameRegistry.registerBlock(this, unlocalizedName);
		return this;
	}
}
