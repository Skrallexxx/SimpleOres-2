package alexndr.SimpleOres.plugins.fusion;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import alexndr.SimpleOres.api.helpers.CoreHelper;
import alexndr.SimpleOres.api.helpers.LogHelper;
import alexndr.SimpleOres.api.helpers.StatTriggersHelper;
import alexndr.SimpleOres.api.helpers.UpdateCheckerHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "required-after:simpleores")
public class FusionPlugin 
{
	@SidedProxy(clientSide = "alexndr.SimpleOres.plugins.fusion.ProxyClient", serverSide = "alexndr.SimpleOres.plugins.fusion.ProxyCommon")	
	public static ProxyCommon proxy;
	public static FusionPlugin INSTANCE = new FusionPlugin();

    public static ToolMaterial toolBronze, toolThyrium, toolSinisite;
    public static ArmorMaterial armorBronze, armorThyrium, armorSinisite;
	public static int rendererBronze, rendererThyrium, rendererSinisite;
	
	/**
	 * Called before the @Init function. I had to put most things in here for achievements to work. Probably a better way to do it.
	 */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
		if(CoreHelper.coreSettings.enableFusionPlugin)
		{
	    	//Configuration
	    	Settings.doSettings(event);
	    	
	    	//Content
	    	setToolsAndArmorStats();
	    	Content.initialize();
	    	Recipes.preInitialize();
		}
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
		if(CoreHelper.coreSettings.enableFusionPlugin)
		{
			INSTANCE = this;
	    	proxy.registerClientTickHandler();
	    	proxy.setZoomAmounts();
	    	Recipes.initialize();
	    	setAchievementTriggers();
	    	if(CoreHelper.coreSettings.enableUpdateChecker){UpdateCheckerHelper.checkUpdates(ModInfo.VERSIONURL, ModInfo.ID, ModInfo.VERSION, ModInfo.UPDATEURL);}
			
			GameRegistry.registerTileEntity(FusionFurnaceTileEntity.class, "fusionFurnace");
			NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, proxy);
			
	        rendererBronze = CoreHelper.simpleores.proxy.addArmor("bronze");
	        rendererThyrium = CoreHelper.simpleores.proxy.addArmor("thyrium");
	        rendererSinisite = CoreHelper.simpleores.proxy.addArmor("sinisite");
	        
	        toolBronze.customCraftingMaterial = Content.bronze_ingot;
	        toolThyrium.customCraftingMaterial = Content.thyrium_ingot;
	        toolSinisite.customCraftingMaterial = Content.sinisite_ingot;
	        
	        armorBronze.customCraftingMaterial = Content.bronze_ingot;
	        armorThyrium.customCraftingMaterial = Content.thyrium_ingot;
	        armorSinisite.customCraftingMaterial = Content.sinisite_ingot;
			
	    	LogHelper.info("Fusion Plugin: " + FusionRecipes.size() + " Fusion Furnace recipes were loaded.");
		}
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
		if(CoreHelper.coreSettings.enableFusionPlugin)
		{
	    	Recipes.postInitialize();
			LogHelper.info("Plugin Loader: Fusion Plugin loaded successfully.");
		}
    }
    
    public static void setToolsAndArmorStats()
    {
    	toolBronze = EnumHelper.addToolMaterial("BRONZE", Settings.bronzeMiningLevel, Settings.bronzeUsesNum, Settings.bronzeMiningSpeed, Settings.bronzeDamageVsEntity, Settings.bronzeEnchantability);
    	toolThyrium = EnumHelper.addToolMaterial("THYRIUM", Settings.thyriumMiningLevel, Settings.thyriumUsesNum, Settings.thyriumMiningSpeed, Settings.thyriumDamageVsEntity, Settings.thyriumEnchantability);
    	toolSinisite = EnumHelper.addToolMaterial("SINISITE", Settings.sinisiteMiningLevel, Settings.sinisiteUsesNum, Settings.sinisiteMiningSpeed, Settings.sinisiteDamageVsEntity, Settings.sinisiteEnchantability);
    	
    	armorBronze = EnumHelper.addArmorMaterial("BRONZE", Settings.bronzeArmorDurability, Settings.bronzeArmorDamageReduction, Settings.bronzeArmorEnchantability);
    	armorThyrium = EnumHelper.addArmorMaterial("THYRIUM", Settings.thyriumArmorDurability, Settings.thyriumArmorDamageReduction, Settings.thyriumArmorEnchantability);
    	armorSinisite = EnumHelper.addArmorMaterial("SINISITE", Settings.sinisiteArmorDurability, Settings.sinisiteArmorDamageReduction, Settings.sinisiteArmorEnchantability);
    }
    
	public static void setAchievementTriggers()
	{
		//Crafting Triggers
		StatTriggersHelper.statTriggers().addCraftingTrigger(new ItemStack(Content.fusion_furnace), Content.fusionAch);
		
		//Smelting Triggers
		StatTriggersHelper.statTriggers().addSmeltingTrigger(new ItemStack(Content.bronze_ingot), Content.bronzeAch);
	}
}
