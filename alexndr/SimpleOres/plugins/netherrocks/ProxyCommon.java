package alexndr.SimpleOres.plugins.netherrocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class ProxyCommon implements IGuiHandler
{
	/**
	 * Adds the armor renderer. Overridden by ProxyClient.
	 */
	public int addArmor(String armor)
	{
		return 0;
	}

	/**
	 * Used to determine if the NetherFurnace should display the container or the gui. 
	 * This is important for servers, as only the client needs to display the gui, while the server needs to keep track of the container.
	 */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity machine = world.getTileEntity(x, y, z);
		
        if(machine == null)
        {
        	return null;
        }
            
        if(machine instanceof NetherFurnaceTileEntity)
        {
        	return new NetherFurnaceContainer(player.inventory, (NetherFurnaceTileEntity)machine);
        }
        
        return null;
	}

	/**
	 * Used to determine if the NetherFurnace should display the container or the gui. 
	 * This is important for servers, as only the client needs to display the gui, while the server needs to keep track of the container.
	 */
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity machine = world.getTileEntity(x, y, z);
		
        if(machine == null)
        {
        	return null;
        }
            
        if(machine instanceof NetherFurnaceTileEntity)
        {
        	return new NetherFurnaceGui(player.inventory, (NetherFurnaceTileEntity)machine);
        }
        
        return null;
	}

}
