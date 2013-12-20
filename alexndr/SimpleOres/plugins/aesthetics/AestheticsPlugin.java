package alexndr.SimpleOres.plugins.aesthetics;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import alexndr.SimpleOres.api.HandlerLogger;
import alexndr.SimpleOres.api.HandlerUpdateChecker;
import alexndr.SimpleOres.core.SimpleOres;
import alexndr.SimpleOres.core.conf.Settings;

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
	public static SimpleOres simpleores;
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
		
	  	if(Settings.enableUpdateChecker){HandlerUpdateChecker.checkUpdates(ModInfo.VERSIONURL, ModInfo.ID, ModInfo.VERSION);}
		
		NetworkRegistry.instance().registerGuiHandler(INSTANCE, proxy);
		GameRegistry.registerTileEntity(FFurnaceTileEntityTin.class, "tinFFurnace");
		GameRegistry.registerTileEntity(FFurnaceTileEntityAdamantium.class, "adamantiumFFurnace");
		
		this.addLocalisations();
		
		HandlerLogger.log("Plugin Loader: Aesthetics Plugin loaded successfully.");
	}
	
	public void addLocalisations()
	{
		try 
		{
			Pattern p = Pattern.compile("assets/aestheticsplugin/langs/(.*)\\.xml");
			for (ResourceInfo i : ClassPath.from(getClass().getClassLoader())
					.getResources()) {
				Matcher m = p.matcher(i.getResourceName());
				if (m.matches())
					LanguageRegistry.instance().loadLocalization(i.url(),
							m.group(1), true);
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			HandlerLogger.log("Aesthetics Plugin: Localisations loaded successfully.");
		}
	}
}
