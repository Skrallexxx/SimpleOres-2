package SimpleOres.plugins.fusion;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ResourceInfo;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.EnumHelper;
import SimpleOres.core.SimpleOres;
import SimpleOres.core.api.HandlerLoot;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

//======================================= FORGE STUFF ====================================================
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "simpleoresfusion", name = "SimpleOres 2 Fusion Plugin", version = "1.2.0", dependencies = "required-after:simpleores")

public class FusionPlugin 
{
	@SidedProxy(clientSide = "SimpleOres.plugins.fusion.ProxyClient", serverSide = "SimpleOres.plugins.fusion.ProxyCommon")	
	public static ProxyCommon proxy;
	public static SimpleOres simpleores;
	public static FusionPlugin INSTANCE = new FusionPlugin();
	
//======================================= CREATION =======================================================	
	/**
	 * EnumToolMaterial. In form ("NAME", mining level, max uses, speed, damage to entity, enchantability)
	 */
    public static EnumToolMaterial toolBronze;
    public static EnumToolMaterial toolThyrium;
    public static EnumToolMaterial toolSinisite;
    
    /**
     * EnumArmorMaterial. In form ("NAME", max damage (like uses, multiply by pieces for their max damage), new int[] {helmet defense, chestplate defense, leggings defense, boots defense}, enchantability)
     */
    public static EnumArmorMaterial armorBronze;
    public static EnumArmorMaterial armorThyrium;
    public static EnumArmorMaterial armorSinisite;
    
    /**
     * Creating the Armor Renderers. This is simply so you can see the armor texture when you wear it.
     */
	public static int rendererBronze;
	public static int rendererThyrium;
	public static int rendererSinisite;
	
	/**
	 * Called before the @Init function. I had to put most things in here for achievements to work. Probably a better way to do it.
	 */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
    	System.out.println("[SimpleOres] Loading Fusion Plugin...");
    	proxy.registerClientTickHandler();
    	/**
    	 * Calling the various parts of the mod. Moved to different files for neatness. Pretty self explanatory what they all are :P
    	 */
    	//Configuration
    	IDs.doConfig(event);
    	Localisation.doLocalisation(event);
    	Settings.doSettings(event);
    	
    	//Content
    	setToolsAndArmorStats();
    	Content.doArmor();
    	Content.doBlocks();
    	Content.doItems();
    	Content.doTools();
    	Achievements.doAchievements();
    	Recipes.doRecipes();
    	Recipes.addCustomFusionRecipes();
    	
    	//Loot
    	HandlerLoot.lootHandler().addLoot("villageBlacksmith", Content.thyriumSword, 1, 1, 10);
    	HandlerLoot.lootHandler().addLoot("mineshaftCorridor", Content.sinisiteAxe, 1, 1, 4);
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
		GameRegistry.registerTileEntity(FusionFurnaceTileEntity.class, "fusionFurnace");
		
        /**
         * Adds the armor textures when you wear it. Calls a method in the CommonProxy (which is overridden by ClientProxy) called addArmor, and inputs the name of the material.
         * This allows the game to recognise that texture files called bronze_1, sinisite_2, etc. are corresponding to that armor set.
         */
        rendererBronze = simpleores.proxy.addArmor("bronze");
        rendererThyrium = simpleores.proxy.addArmor("thyrium");
        rendererSinisite = simpleores.proxy.addArmor("sinisite");
        
        /**
         * This sets what item can be used to repair tools/armor of that type. ie. Copper Ingot to repair copper tools and items.
         */     
        toolBronze.customCraftingMaterial = Content.bronzeIngot;
        toolThyrium.customCraftingMaterial = Content.thyriumIngot;
        toolSinisite.customCraftingMaterial = Content.sinisiteIngot;
        
        armorBronze.customCraftingMaterial = Content.bronzeIngot;
        armorThyrium.customCraftingMaterial = Content.thyriumIngot;
        armorSinisite.customCraftingMaterial = Content.sinisiteIngot;
        
        /**
         * Simply prints to console the number of Fusion Furnace recipes that were loaded, then prints that all content was loaded successfully.
         */
		System.out.println("[SimpleOres] " + FusionRecipes.size / 2 + " Fusion Furnace recipes were loaded.");
    	System.out.println("[SimpleOres] Fusion Plugin loaded all content successfully.");
    }
    
    public void addLocalisations()
    {
		try 
		{
			Pattern p = Pattern.compile("assets/simpleoresfusion/langs/(.*)\\.xml");
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
