package alexndr.SimpleOres.core;

import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import alexndr.SimpleOres.api.content.SimpleTab;
import alexndr.SimpleOres.api.helpers.StatTriggersHelper;
import alexndr.SimpleOres.api.helpers.UpdateCheckerHelper;
import alexndr.SimpleOres.core.content.MythrilFurnaceTileEntity;
import alexndr.SimpleOres.core.content.OnyxFurnaceTileEntity;
import alexndr.SimpleOres.core.helpers.EventHelper;
import alexndr.SimpleOres.core.helpers.Generator;
import alexndr.SimpleOres.core.helpers.ProxyCommon;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class SimpleOres 
{
	@SidedProxy(clientSide = "alexndr.SimpleOres.core.helpers.ProxyClient", serverSide = "alexndr.SimpleOres.core.helpers.ProxyCommon")
	public static ProxyCommon proxy;
	public static SimpleOres INSTANCE = new SimpleOres();
	
	/**
	 * Tool Materials.
	 */
	public static ToolMaterial toolCopper, toolTin, toolMythril, toolAdamantium, toolOnyx;
  	
  	/**
  	 * Armor Materials.
  	 */
  	public static ArmorMaterial armorCopper, armorTin, armorMythril, armorAdamantium, armorOnyx;
	public static int rendererCopper, rendererTin, rendererMythril, rendererAdamantium, rendererOnyx;
  	
  	/**
  	 * Creative Inventory tabs.
  	 */
  	public static SimpleTab tabSimpleBlocks, tabSimpleDecorations, tabSimpleTools, tabSimpleCombat, tabSimpleMaterials;
  	
  	@EventHandler
  	public void preInit(FMLPreInitializationEvent event)
  	{
  		//Event Busses
  		MinecraftForge.EVENT_BUS.register(new EventHelper());
  		FMLCommonHandler.instance().bus().register(new EventHelper());
  		
  		//Configuration
  		Settings.doSettings(event);
  		tabPreInit();
  		
  		//Content
  		setToolAndArmorStats();
  		Content.initialize();
  		Recipes.preInitialize();
  	}
  	
  	@EventHandler
  	public void Init(FMLInitializationEvent event)
  	{
		INSTANCE = this;
  		proxy.addModderCapes();
  		Recipes.initialize();
  		tabInit();
  		setAchievementTriggers();
  		if(Settings.enableUpdateChecker){UpdateCheckerHelper.checkUpdates(ModInfo.VERSIONURL, ModInfo.ID, ModInfo.VERSION);}
  		
		/**
		 * Registering things such as the world generator, tile entities and GUI's.
		 */
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, proxy);
		GameRegistry.registerWorldGenerator(new Generator(), 1);
		GameRegistry.registerTileEntity(MythrilFurnaceTileEntity.class, "mythrilFurnace");
		GameRegistry.registerTileEntity(OnyxFurnaceTileEntity.class, "onyxFurnace");
		
		/**
		 * Adds the armor textures when you wear it. Calls a method in the CommonProxy (which is overridden by ClientProxy) called addArmor, and inputs the name of the material.
		 * This allows the game to recognise that texture files called copper_1, mythril_2, etc. are corresponding to that armor set.
		 */
		rendererCopper = proxy.addArmor("copper");
		rendererMythril = proxy.addArmor("mythril");
		rendererTin = proxy.addArmor("tin");
		rendererAdamantium = proxy.addArmor("adamantium");
		rendererOnyx = proxy.addArmor("onyx");
		
		/**
		 * This sets what item can be used to repair tools/armor of that type. ie. Copper Ingot to repair copper tools and items.
		 */     
		toolCopper.customCraftingMaterial = Content.copper_ingot;
		toolTin.customCraftingMaterial = Content.tin_ingot;
		toolMythril.customCraftingMaterial = Content.mythril_ingot;
		toolAdamantium.customCraftingMaterial = Content.adamantium_ingot;
		toolOnyx.customCraftingMaterial = Content.onyx_gem;
	
		armorCopper.customCraftingMaterial = Content.copper_ingot;
		armorTin.customCraftingMaterial = Content.tin_ingot;
		armorMythril.customCraftingMaterial = Content.mythril_ingot;
		armorAdamantium.customCraftingMaterial = Content.adamantium_ingot;
		armorOnyx.customCraftingMaterial = Content.onyx_gem;
  	}
  	
  	@EventHandler
  	public void postInit(FMLPostInitializationEvent event)
  	{
  		
  	}
  	
  	public void tabPreInit()
  	{
		/**
		 * Creating the custom tabs using the API class "SimpleTab".
		 */  	
		if(Settings.enableSimpleOresTabs)
		{
			tabSimpleBlocks = new SimpleTab("tabSimpleBlocks");   	
		  	 
			if(Settings.enableSeparateTabs)
			{
				tabSimpleDecorations = new SimpleTab("tabSimpleDecorations");
				tabSimpleTools = new SimpleTab("tabSimpleTools");
				tabSimpleCombat = new SimpleTab("tabSimpleCombat");
				tabSimpleMaterials = new SimpleTab("tabSimpleMaterials");
			}
		}
  	}
  	
  	public void tabInit()
  	{
		/**
		 * Setting the Creative Tab icons.
		 */  	
		if(Settings.enableSeparateTabs)
		{
			tabSimpleBlocks.setIcon(new ItemStack(Content.copper_ore));
			
			if(Settings.enableSeparateTabs)
			{
				tabSimpleDecorations.setIcon(new ItemStack(Content.mythril_furnace_lit));
				tabSimpleTools.setIcon(new ItemStack(Content.onyx_pickaxe));
				tabSimpleCombat.setIcon(new ItemStack(Content.adamantium_helmet));
				tabSimpleMaterials.setIcon(new ItemStack(Content.tin_ingot));
			}
		}
  	}
  	
  	public void setToolAndArmorStats()
  	{
		toolCopper = EnumHelper.addToolMaterial("COPPER", Settings.copperMiningLevel, Settings.copperUsesNum, Settings.copperMiningSpeed, Settings.copperDamageVsEntity, Settings.copperEnchantability);
  		toolTin = EnumHelper.addToolMaterial("TIN", Settings.tinMiningLevel, Settings.tinUsesNum, Settings.tinMiningSpeed, Settings.tinDamageVsEntity, Settings.tinEnchantability);
  		toolMythril = EnumHelper.addToolMaterial("MYTHRIL", Settings.mythrilMiningLevel, Settings.mythrilUsesNum, Settings.mythrilMiningSpeed, Settings.mythrilDamageVsEntity, Settings.mythrilEnchantability);
  		toolAdamantium = EnumHelper.addToolMaterial("ADAMANTIUM", Settings.adamantiumMiningLevel, Settings.adamantiumUsesNum, Settings.adamantiumMiningSpeed, Settings.adamantiumDamageVsEntity, Settings.adamantiumEnchantability);
  		toolOnyx = EnumHelper.addToolMaterial("ONYX", Settings.onyxMiningLevel, Settings.onyxUsesNum, Settings.onyxMiningSpeed, Settings.onyxDamageVsEntity, Settings.onyxEnchantability);
  	
  		armorCopper = EnumHelper.addArmorMaterial("COPPER", Settings.copperArmorDurability, Settings.copperArmorDamageReduction, Settings.copperArmorEnchantability);
  		armorTin = EnumHelper.addArmorMaterial("TIN", Settings.tinArmorDurability, Settings.tinArmorDamageReduction, Settings.tinArmorEnchantability);
  		armorMythril = EnumHelper.addArmorMaterial("MYTHRIL", Settings.mythrilArmorDurability, Settings.mythrilArmorDamageReduction, Settings.mythrilArmorEnchantability);
  		armorAdamantium = EnumHelper.addArmorMaterial("ADAMANTIUM", Settings.adamantiumArmorDurability, Settings.adamantiumArmorDamageReduction, Settings.adamantiumArmorEnchantability);
  		armorOnyx = EnumHelper.addArmorMaterial("ONYX", Settings.onyxArmorDurability, Settings.onyxArmorDamageReduction, Settings.onyxArmorEnchantability);
  	}
  	
  	public static void setAchievementTriggers()
  	{
		//Crafting Triggers
		StatTriggersHelper.statTriggers().addCraftingTrigger(new ItemStack(Items.iron_pickaxe), Content.ironPickAch);
		StatTriggersHelper.statTriggers().addCraftingTrigger(new ItemStack(Content.adamantium_pickaxe), Content.adamantiumPickAch);
		StatTriggersHelper.statTriggers().addCraftingTrigger(new ItemStack(Content.onyx_pickaxe), Content.onyxPickAch);
		StatTriggersHelper.statTriggers().addCraftingTrigger(new ItemStack(Content.mythril_bow), Content.mythrilBowAch);
		StatTriggersHelper.statTriggers().addCraftingTrigger(new ItemStack(Content.onyx_bow), Content.onyxBowAch);
	    	
		//Pickup Triggers
		StatTriggersHelper.statTriggers().addPickupTrigger(new ItemStack(Content.copper_ore), Content.simpleOresAch);
		StatTriggersHelper.statTriggers().addPickupTrigger(new ItemStack(Content.onyx_gem), Content.onyxAch);
		StatTriggersHelper.statTriggers().addPickupTrigger(new ItemStack(Content.adamantium_ore), Content.adamantiumAch);
		
		//Smelting Triggers
		StatTriggersHelper.statTriggers().addSmeltingTrigger(new ItemStack(Content.onyx_gem), Content.onyxAch);
  	}
  	
  	
}
