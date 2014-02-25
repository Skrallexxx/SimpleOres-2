package alexndr.SimpleOres.core;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import alexndr.SimpleOres.api.content.SimpleTab;
import alexndr.SimpleOres.api.helpers.LogHelper;
import alexndr.SimpleOres.api.helpers.StatTriggersHelper;
import alexndr.SimpleOres.api.helpers.UpdateCheckerHelper;
import alexndr.SimpleOres.core.content.MythrilFurnaceTileEntity;
import alexndr.SimpleOres.core.content.OnyxFurnaceTileEntity;
import alexndr.SimpleOres.core.helpers.Generator;
import alexndr.SimpleOres.core.helpers.JoinWorldHelper;
import alexndr.SimpleOres.core.helpers.ProxyCommon;

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
@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)

public class SimpleOres 
{
	@SidedProxy(clientSide = "alexndr.SimpleOres.core.helpers.ProxyClient", serverSide = "alexndr.SimpleOres.core.helpers.ProxyCommon")	
	public static ProxyCommon proxy;
	public static SimpleOres INSTANCE = new SimpleOres();
	
	/**
	 * Creating the ToolMaterial Enum's.
	 */
	public static EnumToolMaterial toolCopper;
	public static EnumToolMaterial toolTin;
	public static EnumToolMaterial toolMythril;
	public static EnumToolMaterial toolAdamantium;
  	public static EnumToolMaterial toolOnyx;
     
  	/**
  	 * Creating the ArmorMaterial Enum's
  	 */
  	public static EnumArmorMaterial armorCopper;
  	public static EnumArmorMaterial armorTin;
  	public static EnumArmorMaterial armorMythril;
  	public static EnumArmorMaterial armorAdamantium;
  	public static EnumArmorMaterial armorOnyx;
  
  	/**
  	 * Creating the tabs for Creative Inventory.
  	 */
  	public static SimpleTab tabSimpleBlocks;
  	public static SimpleTab tabSimpleDecorations;
  	public static SimpleTab tabSimpleTools;
  	public static SimpleTab tabSimpleCombat;
  	public static SimpleTab tabSimpleMaterials;
  
  	/**
  	 * Creating the Armor Renderers. This is simply so you can see the armor texture when you wear it.
  	 */
	public static int rendererCopper;
	public static int rendererTin;
	public static int rendererMythril;
	public static int rendererAdamantium;
	public static int rendererOnyx;
	
	/**
	 * Called before the @Init function. Most things go here.
	 */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		proxy.registerClientTickHandler();
		LogHelper.init();
		/**
		 * Calling the various parts of the mod. Moved to different files for neatness. Pretty self explanatory what they all are :P
		 */
		//Configuration
		Settings.doSettings(event);
		Config.doConfig(event);
		doTabs();
  	
		//Content
		setToolAndArmorStats();
		Content.initialize();
		Recipes.preInitialize();	
  		setTabIcons();
	}
  
	public void doTabs()
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
  
	public void setTabIcons()
	{
		/**
		 * Setting the Creative Tab icons.
		 */  	
		if(Settings.enableSeparateTabs)
		{
			tabSimpleBlocks.setIcon(new ItemStack(Content.copperOre));
			
			if(Settings.enableSeparateTabs)
			{
				tabSimpleDecorations.setIcon(new ItemStack(Content.mythrilFurnaceOn));
				tabSimpleTools.setIcon(new ItemStack(Content.onyxPick));
				tabSimpleCombat.setIcon(new ItemStack(Content.adamantiumHelm));
				tabSimpleMaterials.setIcon(new ItemStack(Content.tinIngot));
			}
		}
	}
  
	public void setToolAndArmorStats()
	{
		toolCopper = EnumHelper.addToolMaterial("COPPER", Settings.copperMiningLevel, Settings.copperUsesNum, Settings.copperMiningSpeed, Settings.copperDamageVsEntity, Settings.copperEnchantability);
  		toolTin = EnumHelper.addToolMaterial("TIN", Settings.tinMiningLevel, Settings.tinUsesNum, Settings.tinMiningSpeed, Settings.tinDamageVsEntity, Settings.tinEnchantability);
  		toolMythril = EnumHelper.addToolMaterial("MYTHRIL", Settings.mythrilMiningLevel, Settings.mythrilUsesNum * 2, Settings.mythrilMiningSpeed, Settings.mythrilDamageVsEntity, Settings.mythrilEnchantability);
  		toolAdamantium = EnumHelper.addToolMaterial("ADAMANTIUM", Settings.adamantiumMiningLevel, Settings.adamantiumUsesNum, Settings.adamantiumMiningSpeed, Settings.adamantiumDamageVsEntity, Settings.adamantiumEnchantability);
  		toolOnyx = EnumHelper.addToolMaterial("ONYX", Settings.onyxMiningLevel, Settings.onyxUsesNum, Settings.onyxMiningSpeed, Settings.onyxDamageVsEntity, Settings.onyxEnchantability);
  	
  		armorCopper = EnumHelper.addArmorMaterial("COPPER", Settings.copperArmorDurability, Settings.copperArmorDamageReduction, Settings.copperArmorEnchantability);
  		armorTin = EnumHelper.addArmorMaterial("TIN", Settings.tinArmorDurability, Settings.tinArmorDamageReduction, Settings.tinArmorEnchantability);
  		armorMythril = EnumHelper.addArmorMaterial("MYTHRIL", Settings.mythrilArmorDurability, Settings.mythrilArmorDamageReduction, Settings.mythrilArmorEnchantability);
  		armorAdamantium = EnumHelper.addArmorMaterial("ADAMANTIUM", Settings.adamantiumArmorDurability, Settings.adamantiumArmorDamageReduction, Settings.adamantiumArmorEnchantability);
  		armorOnyx = EnumHelper.addArmorMaterial("ONYX", Settings.onyxArmorDurability, Settings.onyxArmorDamageReduction, Settings.onyxArmorEnchantability);
	}
  
	  @EventHandler
	  public void Init(FMLInitializationEvent event)
	  {	    	
		  NetworkRegistry.instance().registerConnectionHandler(new UpdateCheckerHelper());
		  Recipes.initialize();
		  proxy.addModderCapes();
	  	
		  if(Settings.enableUpdateChecker){UpdateCheckerHelper.checkUpdates(ModInfo.VERSIONURL, ModInfo.ID, ModInfo.VERSION);}
	  	
		  INSTANCE = this;
				
		  /**
		   * Adding localisation files, setting achievement triggers and adding loot to loot chests.
		   * 
		   * Thanks to @zot for the code for loading localisations automatically.
		   */
		  setAchievementTriggers();
		  addLocalisations();
			
		  /**
		   * Registering things such as the world generator, tile entities and GUI's.
		   */
		  NetworkRegistry.instance().registerGuiHandler(INSTANCE, proxy);
		  GameRegistry.registerWorldGenerator(new Generator());
		  GameRegistry.registerTileEntity(MythrilFurnaceTileEntity.class, "mythrilFurnace");
		  GameRegistry.registerTileEntity(OnyxFurnaceTileEntity.class, "onyxFurnace");
		  GameRegistry.registerCraftingHandler(new StatTriggersHelper());
		  GameRegistry.registerPickupHandler(new StatTriggersHelper());
		  MinecraftForge.EVENT_BUS.register(new JoinWorldHelper());
		
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
		  toolCopper.customCraftingMaterial = Content.copperIngot;
		  toolTin.customCraftingMaterial = Content.tinIngot;
		  toolMythril.customCraftingMaterial = Content.mythrilIngot;
		  toolAdamantium.customCraftingMaterial = Content.adamantiumIngot;
		  toolOnyx.customCraftingMaterial = Content.onyxGem;
	
		  armorCopper.customCraftingMaterial = Content.copperIngot;
		  armorTin.customCraftingMaterial = Content.tinIngot;
		  armorMythril.customCraftingMaterial = Content.mythrilIngot;
		  armorAdamantium.customCraftingMaterial = Content.adamantiumIngot;
		  armorOnyx.customCraftingMaterial = Content.onyxGem;
	  }
	  
	  public static void setAchievementTriggers()
	  {
		  //Crafting Triggers
		  StatTriggersHelper.statTriggers().addCraftingTrigger(new ItemStack(Item.pickaxeIron), Content.ironPickAch);
		  StatTriggersHelper.statTriggers().addCraftingTrigger(new ItemStack(Content.adamantiumPick), Content.adamantiumPickAch);
		  StatTriggersHelper.statTriggers().addCraftingTrigger(new ItemStack(Content.onyxPick), Content.onyxPickAch);
		  StatTriggersHelper.statTriggers().addCraftingTrigger(new ItemStack(Content.mythrilBow), Content.mythrilBowAch);
		  StatTriggersHelper.statTriggers().addCraftingTrigger(new ItemStack(Content.onyxBow), Content.onyxBowAch);
	    	
		  //Pickup Triggers
		  StatTriggersHelper.statTriggers().addPickupTrigger(new ItemStack(Content.copperOre), Content.simpleOresAch);
		  StatTriggersHelper.statTriggers().addPickupTrigger(new ItemStack(Content.onyxGem), Content.onyxAch);
		  StatTriggersHelper.statTriggers().addPickupTrigger(new ItemStack(Content.adamantiumOre), Content.adamantiumAch);
	  }	    
	  
	  public void addLocalisations()
	  {
		  int numLocalisations = 0;
		  try 
		  {
			  Pattern p = Pattern.compile("assets/simpleores/langs/(.*)\\.xml");
			  for (ResourceInfo i : ClassPath.from(getClass().getClassLoader()).getResources()) 
			  {
				  Matcher m = p.matcher(i.getResourceName());
				  if (m.matches())
				  {
					  numLocalisations ++;
					  LanguageRegistry.instance().loadLocalization(i.url(), m.group(1), true);
					  LogHelper.verboseInfo("Loaded SimpleOres localisation for: " + m.group(1));
				  }
			  }
		  }
		  
		  catch (IOException e) 
		  {
			  e.printStackTrace();
		  }
		  
		  finally
		  {
			  LogHelper.verboseInfo(numLocalisations + " Localisation(s) loaded successfully.");
		  }
	  }
}
