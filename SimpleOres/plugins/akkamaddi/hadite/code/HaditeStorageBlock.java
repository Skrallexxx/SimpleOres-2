package SimpleOres.plugins.akkamaddi.hadite.code;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import SimpleOres.plugins.akkamaddi.hadite.code.HaditeCoalCore;

public class HaditeStorageBlock extends Block {
	

	private String modName;
	/**
	 * The main constructor for the blocks. 
	 * 
	 * @param par1 = ID of the block.
	 * @param material = The material of the block. This sets what tools are effective against it, the sounds it makes, etc.
	 */
	public HaditeStorageBlock(int par1, Material material, String mod) 
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

	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{		
		if (HaditeCoalCore.MakeBlockFlame == true){
		float f1 = (float)x - 0.5F;
		float f2 = (float)y - 0.5F;
		float f3 = (float)z - 0.5F;
		float f4 = random.nextFloat() * 2.0f;
		float f5 = random.nextFloat() * 2.0f;
		float f6 = random.nextFloat() * 2.0f;
		

		world.spawnParticle("flame", (double)(f1+f4), (double)(f2+f5) , (double)(f3+f6), 0.0D, 0.0D, 0.0D);
		}
		else return;
	}
	
	

}
