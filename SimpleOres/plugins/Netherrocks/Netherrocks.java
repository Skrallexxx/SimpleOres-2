package SimpleOres.plugins.Netherrocks;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ResourceInfo;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import SimpleOres.core.SimpleOres;
import SimpleOres.core.api.SimpleTab;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

//======================================= FORGE STUFF ====================================================
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "netherrocks", name = "SimpleOres 2 Netherrocks Plugin", version = "1.1.0", dependencies = "required-after:simpleores")

public class Netherrocks 
{
	@SidedProxy(clientSide = "SimpleOres.plugins.Netherrocks.ProxyClient", serverSide = "SimpleOres.plugins.Netherrocks.ProxyCommon")
	public static ProxyCommon proxy;
	public static SimpleOres simpleores;
	public static Netherrocks INSTANCE = new Netherrocks();
	
//======================================= CREATION =======================================================	
	/**
	 * EnumToolMaterial. In form ("NAME", mining level, max uses, speed, damage to entity, enchantability)
	 */
	public static EnumToolMaterial toolMalachite = EnumHelper.addToolMaterial("MALACHITE", 3, 700, 9F, 3, 39);
	public static EnumToolMaterial toolAshstone = EnumHelper.addToolMaterial("ASHSTONE", 3, 900, 16F, 2, 7);
	public static EnumToolMaterial toolDragonstone = EnumHelper.addToolMaterial("DRAGONSTONE", 4, 4000, 10F, 8, 27);
	public static EnumToolMaterial toolArgonite = EnumHelper.addToolMaterial("ARGONITE", 3, 1300, 8F, 3, 18);
	public static EnumToolMaterial toolFyrite = EnumHelper.addToolMaterial("FYRITE", 3, 150, 8F, 4, 7);
	public static EnumToolMaterial toolIllumenite = EnumHelper.addToolMaterial("ILLUMENITE", 3, 700, 8F, 4, 7);
	
    /**
     * EnumArmorMaterial. In form ("NAME", max damage (like uses, multiply by pieces for their max damage), new int[] {helmet defense, chestplate defense, leggings defense, boots defense}, enchantability)
     */
	public static EnumArmorMaterial armorFyrite = EnumHelper.addArmorMaterial("FYRITE", 5, new int[] {3, 5, 4, 3}, 7);
	public static EnumArmorMaterial armorMalachite = EnumHelper.addArmorMaterial("MALACHITE", 16, new int[] {2, 4, 4, 2}, 39);
	public static EnumArmorMaterial armorIllumenite = EnumHelper.addArmorMaterial("ILLUMENITE", 12, new int[] {4, 5, 5, 3}, 15);
	public static EnumArmorMaterial armorDragonstone = EnumHelper.addArmorMaterial("DRAGONSTONE", 30, new int[] {3, 9, 7, 3}, 27);
	
    /**
     * Creating the Armor Renderers. This is simply so you can see the armor texture when you wear it.
     */
	public static int rendererFyrite;
	public static int rendererMalachite;
	public static int rendererIllumenite;
	public static int rendererDragonstone;
	
    /**
     * Creating the tabs for Creative Inventory.
     */
    public static SimpleTab tabNetherBlocks = new SimpleTab("tabNetherBlocks");
    public static SimpleTab tabNetherDecorations = new SimpleTab("tabNetherDecorations");
    public static SimpleTab tabNetherTools = new SimpleTab("tabNetherTools");
    public static SimpleTab tabNetherCombat = new SimpleTab("tabNetherCombat");
    public static SimpleTab tabNetherMaterials = new SimpleTab("tabNetherMaterials");
    
	/**
	 * Called before the @Init function.
	 */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	System.out.println("[SimpleOres] Loading Netherrocks Plugin...");
    	MinecraftForge.EVENT_BUS.register(new HandlerEvent());
    	
    	/**
    	 * Calling the various parts of the mod. Moved to different files for neatness. Pretty self explanatory what they all are :P
    	 */
    	//Configuration
    	Config.doConfig(event);
    	Localisation.doLocalisation(event);
    	Settings.doSettings(event);
    	
    	//Content
    	Blocks.doBlocks();
    	Items.doItems();
    	Tools.doTools();
    	Armor.doArmor();
    	Recipes.doRecipes();
    	Achievements.doAchievements();
    	setTabIcons();
    }
    
    public void setTabIcons()
    {
    	/**
    	 * Creating the custom tabs using the API class "SimpleTab" and setting their icon.
    	 */
		tabNetherBlocks.setIcon(new ItemStack(Blocks.fyriteOre));
	    tabNetherDecorations.setIcon(new ItemStack(Blocks.netherFurnaceOn));
	    tabNetherTools.setIcon(new ItemStack(Tools.argonitePick));
	    tabNetherCombat.setIcon(new ItemStack(Armor.dragonstoneHelm));
	    tabNetherMaterials.setIcon(new ItemStack(Items.malachiteIngot));
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	INSTANCE = this;
    	
		/**
		 * Adding localisation files.
		 * 
		 * Thanks to @zot for the code for loading localisations automatically.
		 */
    	addLocalisations();
    	
		/**
		 * Registering things such as the world generator, tile entities and GUI's.
		 */
		NetworkRegistry.instance().registerGuiHandler(INSTANCE, proxy);
		GameRegistry.registerWorldGenerator(new Generator());
		GameRegistry.registerTileEntity(NetherFurnaceTileEntity.class, "NetherrocksNetherFurnace");

        /**
         * Adds the armor textures when you wear it. Calls a method in the CommonProxy (which is overridden by ClientProxy) called addArmor, and inputs the name of the material.
         * This allows the game to recognise that texture files called fyrite_1, illumenite_2, etc. are corresponding to that armor set.
         */
        rendererFyrite = proxy.addArmor("fyrite");
        rendererMalachite = proxy.addArmor("malachite");
        rendererIllumenite = proxy.addArmor("illumenite");
        rendererDragonstone = proxy.addArmor("dragonstone");
        
        /**
         * This sets what item can be used to repair tools/armor of that type. ie. Copper Ingot to repair copper tools and items.
         */   
        toolMalachite.customCraftingMaterial = Items.malachiteIngot;
        toolAshstone.customCraftingMaterial = Items.ashstoneGem;
        toolDragonstone.customCraftingMaterial = Items.dragonstoneGem;
        toolArgonite.customCraftingMaterial = Items.argoniteIngot;
        toolFyrite.customCraftingMaterial = Items.fyriteIngot;
        toolIllumenite.customCraftingMaterial = Items.illumeniteIngot;
        
        armorFyrite.customCraftingMaterial = Items.fyriteIngot;
        armorMalachite.customCraftingMaterial = Items.malachiteIngot;
        armorIllumenite.customCraftingMaterial = Items.illumeniteIngot;
        armorDragonstone.customCraftingMaterial = Items.dragonstoneGem;
        
    	System.out.println("[SimpleOres] Netherrocks Plugin loaded all content successfully.");
    }
    
    public void addLocalisations()
    {
    	try 
		{
			Pattern p = Pattern.compile("assets/netherrocks/langs/(.*)\\.xml");
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
    }
}
