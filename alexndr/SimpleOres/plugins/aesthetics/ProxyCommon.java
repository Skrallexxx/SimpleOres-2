package alexndr.SimpleOres.plugins.aesthetics;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class ProxyCommon implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity machine = world.getBlockTileEntity(x, y, z);
		
		if(machine == null)
		{
			return null;
		}
		
		if(machine instanceof FFurnaceTileEntityTin)
		{
			return new FFurnaceContainerTin(player.inventory, (FFurnaceTileEntityTin)machine);
		}
		
		if(machine instanceof FFurnaceTileEntityAdamantium)
		{
			return new FFurnaceContainerAdamantium(player.inventory, (FFurnaceTileEntityAdamantium)machine);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity machine = world.getBlockTileEntity(x, y, z);
        
		if(machine == null)
		{
			return null;
		}
		
		if(machine instanceof FFurnaceTileEntityTin)
		{
			return new FFurnaceGuiTin(player.inventory, (FFurnaceTileEntityTin)machine);
		}
		
		if(machine instanceof FFurnaceTileEntityAdamantium)
		{
			return new FFurnaceGuiAdamantium(player.inventory, (FFurnaceTileEntityAdamantium)machine);
		}
		
		return null;
	}

}
