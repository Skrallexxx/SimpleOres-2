package SimpleOres.plugins.machines;

import SimpleOres.core.SimpleOres;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

//======================================= FORGE STUFF ====================================================
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "simpleoresmachines", name = "SimpleOres 2 Machines Plugin", version = "1.0.0", dependencies = "required-after:simpleores; required-after:simpleoresfusion")

public class Machines 
{
	@SidedProxy(clientSide = "SimpleOres.plugins.machines.ProxyClient", serverSide = "SimpleOres.plugins.machines.ProxyCommon")
	public static ProxyCommon proxy;
	public static SimpleOres simpleores;
	public static Machines INSTANCE = new Machines();
	
	/**
	 * Called before the @Init function.
	 */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
    	
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	
    }
}
