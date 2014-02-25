package alexndr.SimpleOres.plugins.netherrocks;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import alexndr.SimpleOres.api.helpers.CoreHelper;
import alexndr.SimpleOres.api.helpers.LogHelper;
import alexndr.SimpleOres.api.helpers.StatTriggersHelper;
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
@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "required-after:simpleores")
public class Netherrocks 
{
	@SidedProxy(clientSide = "alexndr.SimpleOres.plugins.netherrocks.ProxyClient", serverSide = "alexndr.SimpleOres.plugins.netherrocks.ProxyCommon")
	public static ProxyCommon proxy;
	public static Netherrocks INSTANCE = new Netherrocks();
	
	/**
	 * Creating the ToolMaterial Enum's.
	 */
	public static EnumToolMaterial toolFyrite;
	public static EnumToolMaterial toolMalachite;
	public static EnumToolMaterial toolAshstone;
	public static EnumToolMaterial toolIllumenite;
	public static EnumToolMaterial toolDragonstone;
	public static EnumToolMaterial toolArgonite;
	
  	/**
  	 * Creating the ArmorMaterial Enum's
  	 */
  	public static EnumArmorMaterial armorFyrite;
  	public static EnumArmorMaterial armorMalachite;
	public static EnumArmorMaterial armorIllumenite;
  	public static EnumArmorMaterial armorDragonstone;
	
    /**
     * Creating the Armor Renderers. This is simply so you can see the armor texture when you wear it.
     */
  	public static int rendererFyrite;
  	public static int rendererMalachite;
  	public static int rendererIllumenite;
  	public static int rendererDragonstone;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new EventHelper());
		
		//Configuration
		Config.loadConfig(event);
		Settings.loadSettings(event);
		
		//Content
		setToolAndArmorStats();
		Content.initialize();
		Recipes.preInitialize();
	}
	
	public void setToolAndArmorStats()
	{
		toolFyrite = EnumHelper.addToolMaterial("FYRITE", Settings.fyriteMiningLevel, Settings.fyriteUsesNum, Settings.fyriteMiningSpeed, Settings.fyriteDamageVsEntity, Settings.fyriteEnchantability);
		toolMalachite = EnumHelper.addToolMaterial("MALACHITE", Settings.malachiteMiningLevel, Settings.malachiteUsesNum, Settings.malachiteMiningSpeed, Settings.malachiteDamageVsEntity, Settings.malachiteEnchantability);
		toolAshstone = EnumHelper.addToolMaterial("ASHSTONE", Settings.ashstoneMiningLevel, Settings.ashstoneUsesNum, Settings.ashstoneMiningSpeed, Settings.ashstoneDamageVsEntity, Settings.ashstoneEnchantability);
		toolIllumenite = EnumHelper.addToolMaterial("ILLUMENITE", Settings.illumeniteMiningLevel, Settings.illumeniteUsesNum, Settings.illumeniteMiningSpeed, Settings.illumeniteDamageVsEntity, Settings.illumeniteEnchantability);
		toolDragonstone = EnumHelper.addToolMaterial("DRAGONSTONE", Settings.dragonstoneMiningLevel, Settings.dragonstoneUsesNum, Settings.dragonstoneMiningSpeed, Settings.dragonstoneDamageVsEntity, Settings.dragonstoneEnchantability);
		toolArgonite = EnumHelper.addToolMaterial("ARGONITE", Settings.argoniteMiningLevel, Settings.argoniteUsesNum, Settings.argoniteMiningSpeed, Settings.argoniteDamageVsEntity, Settings.argoniteEnchantability);
	
		armorFyrite = EnumHelper.addArmorMaterial("FYRITE", Settings.fyriteArmorDurability, Settings.fyriteArmorDamageReduction, Settings.fyriteArmorEnchantability);
		armorMalachite = EnumHelper.addArmorMaterial("MALACHITE", Settings.malachiteArmorDurability, Settings.malachiteArmorDamageReduction, Settings.malachiteArmorEnchantability);
		armorIllumenite = EnumHelper.addArmorMaterial("ILLUMENITE", Settings.illumeniteArmorDurability, Settings.illumeniteArmorDamageReduction, Settings.illumeniteArmorEnchantability);
		armorDragonstone = EnumHelper.addArmorMaterial("DRAGONSTONE", Settings.dragonstoneArmorDurability, Settings.dragonstoneArmorDamageReduction, Settings.dragonstoneArmorEnchantability);
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		Recipes.initialize();
		INSTANCE = this;
		if(CoreHelper.coreSettings.enableUpdateChecker){UpdateCheckerHelper.checkUpdates(ModInfo.VERSIONURL, ModInfo.ID, ModInfo.VERSION);}
		
		setAchievementTriggers();
		addLocalisations();
		
		/**
		 * Registering things such as the world generator, tile entities and GUI's. Adds localisations.
		 * Thanks to @zot for the code for loading localisations automatically.
		 */
		NetworkRegistry.instance().registerGuiHandler(INSTANCE, proxy);
		GameRegistry.registerWorldGenerator(new Generator());
		GameRegistry.registerTileEntity(NetherFurnaceTileEntity.class, "NetherrocksNetherFurnace");
		
        /**
         * Adds the textures for the worn armor models.
         */
        rendererFyrite = proxy.addArmor("fyrite");
        rendererMalachite = proxy.addArmor("malachite");
        rendererIllumenite = proxy.addArmor("illumenite");
        rendererDragonstone = proxy.addArmor("dragonstone");
        
        /**
         * Sets what item can be used to repair tools/armor of that type. ie. Copper Ingot to repair copper tools and items.
         */   
        toolMalachite.customCraftingMaterial = Content.malachiteIngot;
        toolAshstone.customCraftingMaterial = Content.ashstoneGem;
        toolDragonstone.customCraftingMaterial = Content.dragonstoneGem;
        toolArgonite.customCraftingMaterial = Content.argoniteIngot;
        toolFyrite.customCraftingMaterial = Content.fyriteIngot;
        toolIllumenite.customCraftingMaterial = Content.illumeniteIngot;
        
        armorFyrite.customCraftingMaterial = Content.fyriteIngot;
        armorMalachite.customCraftingMaterial = Content.malachiteIngot;
        armorIllumenite.customCraftingMaterial = Content.illumeniteIngot;
        armorDragonstone.customCraftingMaterial = Content.dragonstoneGem;
		
		LogHelper.info("Plugin Loader: Netherrocks Plugin loaded successfully.");
	}
	
	public static void setAchievementTriggers()
	{
		StatTriggersHelper.statTriggers().addCraftingTrigger(new ItemStack(Content.netherFurnace), Content.netherFurnaceAch);
		StatTriggersHelper.statTriggers().addPickupTrigger(new ItemStack(Content.fyriteOre), Content.netherRocksAch);
	}
	
	public void addLocalisations()
	{
		int numLocalisations = 0;
		try 
		{
			Pattern p = Pattern.compile("assets/netherrocks/langs/(.*)\\.xml");
			for (ResourceInfo i : ClassPath.from(getClass().getClassLoader()).getResources()) 
			{
				Matcher m = p.matcher(i.getResourceName());
				if (m.matches())
				{
					numLocalisations ++;
					LanguageRegistry.instance().loadLocalization(i.url(), m.group(1), true);
					LogHelper.verboseInfo("Netherrocks Plugin: Loaded Netherrocks localisation for: " + m.group(1));
				}
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			LogHelper.verboseInfo("Netherrocks Plugin: " + numLocalisations + " Localisation(s) loaded successfully.");
		}
	}
}
