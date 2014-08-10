package alexndr.SimpleOres.core.helpers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import alexndr.SimpleOres.core.content.MythrilFurnaceContainer;
import alexndr.SimpleOres.core.content.MythrilFurnaceGUI;
import alexndr.SimpleOres.core.content.MythrilFurnaceTileEntity;
import alexndr.SimpleOres.core.content.OnyxFurnaceContainer;
import alexndr.SimpleOres.core.content.OnyxFurnaceGUI;
import alexndr.SimpleOres.core.content.OnyxFurnaceTileEntity;
import cpw.mods.fml.common.network.IGuiHandler;

public class ProxyCommon implements IGuiHandler
{
	/**
	 * Server side method for adding armor renderers. Overridden by ProxyClient.
	 */
	public int addArmor(String armor)
	{
		return 0;
	}

	/**
	 * Gets machine GUI's for the server.
	 */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity machine = world.getTileEntity(x, y, z);
		
        if(machine == null)
        {
        	return null;
        }
            
        if(machine instanceof MythrilFurnaceTileEntity)
        {
        	return new MythrilFurnaceContainer(player.inventory, (MythrilFurnaceTileEntity)machine);
        }
        
        else if(machine instanceof OnyxFurnaceTileEntity)
        {
        	return new OnyxFurnaceContainer(player.inventory, (OnyxFurnaceTileEntity)machine);
        }
            
        return null;
	}

	/**
	 * Gets machine GUI's for the client.
	 */
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity machine = world.getTileEntity(x, y, z);
		
        if(machine == null)
        {
        	return null;
        }
            
        if(machine instanceof MythrilFurnaceTileEntity)
        {
        	return new MythrilFurnaceGUI(player.inventory, (MythrilFurnaceTileEntity)machine);
        }
        
        else if(machine instanceof OnyxFurnaceTileEntity)
        {
        	return new OnyxFurnaceGUI(player.inventory, (OnyxFurnaceTileEntity)machine);
        }
		
        return null;
	}
	
	public void registerClientTickHandler()
	{
		
	}
	
	/**
	 * Sets the zoom amounts for bows. Overridden by ProxyClient.
	 */
	public void setZoomAmounts()
	{
		
	}
}
