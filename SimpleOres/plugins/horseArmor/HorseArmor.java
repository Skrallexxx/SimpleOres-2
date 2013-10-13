package SimpleOres.plugins.horseArmor;

import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "simpleoreshorses", name = "SimpleOres 2 Horse Armor Plugin", version = "1.0.0", dependencies = "required-after:simpleores")

public class HorseArmor 
{	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
    	System.out.println("[SimpleOres] Loading SimpleOres 2 Horse Armor Plugin...");
    	
    	//Configurationg
    	Config.doConfig(event);
    	
    	//Content
    	Content.doContent();
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	System.out.println("[SimpleOres] SimpleOres 2 Horse Armor Plugin loaded all content successfully.");
    }
}
