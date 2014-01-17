package alexndr.SimpleOres.plugins.aesthetics;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import alexndr.SimpleOres.api.helpers.CoreHelper;
import alexndr.SimpleOres.api.helpers.LogHelper;
import alexndr.SimpleOres.api.helpers.UpdateCheckerHelper;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ResourceInfo;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "required-after:simpleores; required-after:simpleoresfusion")

public class AestheticsPlugin 
{
	@SidedProxy(clientSide = "alexndr.SimpleOres.plugins.aesthetics.ProxyClient", serverSide = "alexndr.SimpleOres.plugins.aesthetics.ProxyCommon")
	public static ProxyCommon proxy;
	public static AestheticsPlugin INSTANCE = new AestheticsPlugin();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Config.doIDs(event);
		Settings.doSettings(event);
		
		Content.doBlocks();
		Content.doItems();
		Content.doAchievements();
		Recipes.doRecipes();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		INSTANCE = this;
		
	  	if(CoreHelper.coreSettings.enableUpdateChecker){UpdateCheckerHelper.checkUpdates(ModInfo.VERSIONURL, ModInfo.ID, ModInfo.VERSION);}
		
		NetworkRegistry.instance().registerGuiHandler(INSTANCE, proxy);
		GameRegistry.registerTileEntity(FFurnaceTileEntityTin.class, "tinFFurnace");
		GameRegistry.registerTileEntity(FFurnaceTileEntityAdamantium.class, "adamantiumFFurnace");
		
		this.addLocalisations();
		
		LogHelper.info("Plugin Loader: Aesthetics Plugin loaded successfully.");
	}
	
	public void addLocalisations()
	{
		int numLocalisations = 0;
		try 
		{
			Pattern p = Pattern.compile("assets/aestheticsplugin/langs/(.*)\\.xml");
			for (ResourceInfo i : ClassPath.from(getClass().getClassLoader()).getResources()) 
			{
				Matcher m = p.matcher(i.getResourceName());
				if (m.matches())
				{
					numLocalisations ++;
					LanguageRegistry.instance().loadLocalization(i.url(), m.group(1), true);
					LogHelper.verboseInfo("Aesthetics Plugin: Loaded Aesthetics localisation for: " + m.group(1));
				}
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			LogHelper.info("Aesthetics Plugin: " + numLocalisations + " Localisation(s) loaded successfully.");
		}
	}
}
