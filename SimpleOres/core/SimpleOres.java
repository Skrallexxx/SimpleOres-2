package SimpleOres.core;

import java.util.logging.Level;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import SimpleOres.core.api.HandlerLoot;
import SimpleOres.core.conf.IDs;
import SimpleOres.core.conf.Localisation;
import SimpleOres.core.conf.Settings;
import SimpleOres.core.gui.TabBlocks;
import SimpleOres.core.gui.TabCombat;
import SimpleOres.core.gui.TabDecoration;
import SimpleOres.core.gui.TabGeneral;
import SimpleOres.core.gui.TabMaterials;
import SimpleOres.core.gui.TabTools;
import SimpleOres.core.gui.TileEntityMythrilFurnace;
import SimpleOres.core.gui.TileEntityOnyxFurnace;
import SimpleOres.core.handlers.HandlerJoinWorld;
import SimpleOres.core.handlers.ProxyCommon;
import SimpleOres.core.handlers.SimpleOresGenerator;
import SimpleOres.plugins.fusion.TileEntityFusionFurnace;
import SimpleOres.plugins.fusion.api.FusionRecipes;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

//======================================= FORGE STUFF ====================================================
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "simpleores", name = "SimpleOres 2", version = "1.0.2")

public class SimpleOres 
{
	@SidedProxy(clientSide = "SimpleOres.core.handlers.ProxyClient", serverSide = "SimpleOres.core.handlers.ProxyCommon")	
	public static ProxyCommon proxy;
	
	/**
	 * Linking to the classes for easier reference.
	 */
	public static SimpleOres mod;
	public static Achievements achievements;
	public static Armor armor;
	public static Blocks blocks;
	public static IDs config;
	public static Items items;
	public static Localisation local;
	public static Recipes recipes;
	public static Settings settings;
	public static Tools tools;
	
//======================================= CREATION =======================================================	
	/**
	 * EnumToolMaterial. In form ("NAME", mining level, max uses, speed, damage to entity, enchantability)
	 */
    public static EnumToolMaterial toolCopper = EnumHelper.addToolMaterial("COPPER", 1, 185, 4.0F, 1, 8);
    public static EnumToolMaterial toolTin = EnumHelper.addToolMaterial("TIN", 1, 200, 3.5F, 1, 8);
    public static EnumToolMaterial toolMythril = EnumHelper.addToolMaterial("MYTHRIL", 2, 800, 8.0F, 3, 12);
    public static EnumToolMaterial toolAdamantium = EnumHelper.addToolMaterial("ADAMANTIUM", 2, 1150, 14.0F, 3, 3);
    public static EnumToolMaterial toolOnyx = EnumHelper.addToolMaterial("ONYX", 4, 3280, 10.0F, 5, 15);
       
    /**
     * EnumArmorMaterial. In form ("NAME", max damage (like uses, multiply by pieces for their max damage), new int[] {helmet defense, chestplate defense, leggings defense, boots defense}, enchantability)
     */
    public static EnumArmorMaterial armorCopper = EnumHelper.addArmorMaterial("COPPER", 8, new int[] {2, 3, 2, 1}, 8);
    public static EnumArmorMaterial armorTin = EnumHelper.addArmorMaterial("TIN", 8, new int[] {2, 3, 2, 1}, 8);
    public static EnumArmorMaterial armorMythril = EnumHelper.addArmorMaterial("MYTHRIL", 22, new int[] {3, 5, 4, 3}, 12);
    public static EnumArmorMaterial armorAdamantium = EnumHelper.addArmorMaterial("ADAMANTIUM", 28, new int[] {3, 8, 6, 2}, 3);
    public static EnumArmorMaterial armorOnyx = EnumHelper.addArmorMaterial("ONYX", 45, new int[] {5, 8, 6, 5}, 15);
    
    /**
     * Creating the tabs for Creative Inventory.
     */
    public static CreativeTabs tabSimpleBlocks;
    public static CreativeTabs tabSimpleDecoration;
    public static CreativeTabs tabSimpleTools;
    public static CreativeTabs tabSimpleCombat;
    public static CreativeTabs tabSimpleMaterials;

    /**
     * Creating the Armor Renderers. This is simply so you can see the armor texture when you wear it.
     */
	public static int rendererCopper;
	public static int rendererTin;
	public static int rendererMythril;
	public static int rendererAdamantium;
	public static int rendererOnyx;
	
	/**
	 * Called before the @Init function. I had to put most things in here for achievements to work. Probably a better way to do it.
	 */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
    	proxy.registerClientTickHandler();
    	/**
    	 * Calling the various parts of the mod. Moved to different files for neatness. Pretty self explanatory what they all are :P
    	 */
    	//Configuration
    	config.doConfig(event);
    	local.doLocalisation(event);
    	settings.doSettings(event);
    	
    	//Content
    	doTabs();
    	blocks.doBlocks();
    	items.doItems();
    	tools.doTools();
    	armor.doArmor();
    	recipes.doRecipes();	
    	achievements.doAchievements();
    	
    }
    
    public void doTabs()
    {
		/**
		 * This is so that the custom tabs can be toggled. If the boolean returns true, blocks, items, tools etc are seperated into separate tabs.
		 * If the boolean returns false, they will all be placed into a single custom tab.
		 */
    	if(settings.enableSeparateTabs == true)
    	{
    		tabSimpleBlocks = new TabBlocks("tabSimpleBlocks");
    	    tabSimpleDecoration = new TabDecoration("tabSimpleDecoration");
    	    tabSimpleTools = new TabTools("tabSimpleTools");
    	    tabSimpleCombat = new TabCombat("tabSimpleCombat");
    	    tabSimpleMaterials = new TabMaterials("tabSimpleMaterials");
    	}
    	else tabSimpleBlocks = new TabBlocks("tabSimpleBlocks");
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {	    	
		mod = this;
			
		/**
		 * Registering things such as the world generator, tile entities and GUI's.
		 */
		//Registering
		NetworkRegistry.instance().registerGuiHandler(mod, proxy);
		GameRegistry.registerWorldGenerator(new SimpleOresGenerator());
		GameRegistry.registerTileEntity(TileEntityMythrilFurnace.class, "mythrilFurnace");
		GameRegistry.registerTileEntity(TileEntityOnyxFurnace.class, "onyxFurnace");
		MinecraftForge.EVENT_BUS.register(new HandlerJoinWorld());
	
        /**
         * Adds the armor textures when you wear it. Calls a method in the CommonProxy (which is overridden by ClientProxy) called addArmor, and inputs the name of the material.
         * This allows the game to recognise that texture files called copper_1, mythril_2, etc. are corresponding to that armor set.
         */
		//Armor Renderers
        rendererCopper = proxy.addArmor("copper");
        rendererMythril = proxy.addArmor("mythril");
        rendererTin = proxy.addArmor("tin");
        rendererAdamantium = proxy.addArmor("adamantium");
        rendererOnyx = proxy.addArmor("onyx");
        
        /**
         * This sets what item can be used to repair tools/armor of that type. ie. Copper Ingot to repair copper tools and items.
         */     
        //Repair Materials
        toolCopper.customCraftingMaterial = items.copperIngot;
        toolTin.customCraftingMaterial = items.tinIngot;
        toolMythril.customCraftingMaterial = items.mythrilIngot;
        toolAdamantium.customCraftingMaterial = items.adamantiumIngot;
        toolOnyx.customCraftingMaterial = items.onyxGem;

        armorCopper.customCraftingMaterial = items.copperIngot;
        armorTin.customCraftingMaterial = items.tinIngot;
        armorMythril.customCraftingMaterial = items.mythrilIngot;
        armorAdamantium.customCraftingMaterial = items.adamantiumIngot;
        armorOnyx.customCraftingMaterial = items.onyxGem;
       
        /**
         * Adds SimpleOres items to the various dungeon chests.
         */
        //Loot
        HandlerLoot.addLoot();
        
        /**
         * Sets the pop-up text when you hover over the custom Creative Inventory tabs.
         */
		//Custom Tabs
        if(settings.enableSeparateTabs == true)
        {
			LanguageRegistry.instance().addStringLocalization("itemGroup.tabSimpleBlocks", "en_US", "SimpleOres Blocks");
			LanguageRegistry.instance().addStringLocalization("itemGroup.tabSimpleDecoration", "en_US", "SimpleOres Decorations");
			LanguageRegistry.instance().addStringLocalization("itemGroup.tabSimpleTools", "en_US", "SimpleOres Tools");
			LanguageRegistry.instance().addStringLocalization("itemGroup.tabSimpleCombat", "en_US", "SimpleOres Combat");
			LanguageRegistry.instance().addStringLocalization("itemGroup.tabSimpleMaterials", "en_US", "SimpleOres Materials");
        }
        else LanguageRegistry.instance().addStringLocalization("itemGroup.tabSimpleBlocks", "en_US", "SimpleOres");
    }
}
