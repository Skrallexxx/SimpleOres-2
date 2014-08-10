package alexndr.SimpleOres.plugins.aesthetics;

import alexndr.SimpleOres.api.helpers.CoreHelper;
import alexndr.SimpleOres.api.helpers.LogHelper;
import alexndr.SimpleOres.api.helpers.UpdateCheckerHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "required-after:simpleores;")

public class AestheticsPlugin 
{
	@SidedProxy(clientSide = "alexndr.SimpleOres.plugins.aesthetics.ProxyClient", serverSide = "alexndr.SimpleOres.plugins.aesthetics.ProxyCommon")
	public static ProxyCommon proxy;
	public static AestheticsPlugin INSTANCE = new AestheticsPlugin();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		if(CoreHelper.coreSettings.enableAestheticsPlugin)
		{
			Settings.doSettings(event);
			Content.initialize();
		}
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		if(CoreHelper.coreSettings.enableAestheticsPlugin)
		{
			Recipes.initialize();
			INSTANCE = this;
			
		  	if(CoreHelper.coreSettings.enableUpdateChecker){UpdateCheckerHelper.checkUpdates(ModInfo.VERSIONURL, ModInfo.ID, ModInfo.VERSION, ModInfo.UPDATEURL);}
		}
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		if(CoreHelper.coreSettings.enableAestheticsPlugin)
		{
			LogHelper.info("Plugin Loader: Aesthetics Plugin loaded successfully.");
		}
	}
}
