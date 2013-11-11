package SimpleOres.plugins.fusion;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class ProxyCommon implements IGuiHandler
{
	
	/**
	 * The methods used to add a zoom feature to the custom bows. The code is messy as it is mostly copy/paste. Obviously overriden by ProxyClient, so look there
	 * if you are curious to see the code.
	 */
	 public void onBowUse(ItemStack stack, EntityPlayer player) 
	 {

	 }
	 
	 public void resetSavedFOV() 
	 {
		 
	 }
	 
	 public void registerClientTickHandler()
	 {

	 }
	
	 /**
	  * Determines whether to return the Container or GUI for certain 'machines' (ie. furnaces, in this case), depending upon if this is being 
	  * called by the server or client. Server will call the Containers, while Client will call the GUI (so the player can actually see them).
	  */
	@Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
		TileEntity machine = world.getBlockTileEntity(x, y, z);
		
        if(machine == null)
        {
        	return null;
        }
            
        if(machine instanceof FusionFurnaceTileEntity)
        {
        	return new FusionFurnaceContainer(player.inventory, (FusionFurnaceTileEntity)machine);
        }
            
        return null;
    }
	
	 /**
	  * Determines whether to return the Container or GUI for certain 'machines' (ie. furnaces, in this case), depending upon if this is being 
	  * called by the server or client. Server will call the Containers, while Client will call the GUI (so the player can actually see them).
	  */
	@Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
		TileEntity machine = world.getBlockTileEntity(x, y, z);
		
        if(machine == null)
        {
        	return null;
        }
            
        if(machine instanceof FusionFurnaceTileEntity)
        {
        	return new FusionFurnaceGUI(player.inventory, (FusionFurnaceTileEntity)machine);
        }
		
        return null;
    }
}
