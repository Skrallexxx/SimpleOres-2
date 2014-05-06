package alexndr.SimpleOres.plugins.netherrocks;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import alexndr.SimpleOres.api.helpers.CoreHelper;
import alexndr.SimpleOres.api.helpers.LogHelper;
import alexndr.SimpleOres.api.helpers.StatTriggersHelper;
import alexndr.SimpleOres.api.helpers.UpdateCheckerHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "required-after:simpleores")
public class Netherrocks 
{
	@SidedProxy(clientSide = "alexndr.SimpleOres.plugins.netherrocks.ProxyClient", serverSide = "alexndr.SimpleOres.plugins.netherrocks.ProxyCommon")
	public static ProxyCommon proxy;
	public static Netherrocks INSTANCE = new Netherrocks();
	
	/**
	 * Creating the ToolMaterial Enum's.
	 */
	public static ToolMaterial toolFyrite, toolMalachite, toolAshstone, toolIllumenite, toolDragonstone, toolArgonite;
	
  	/**
  	 * Creating the ArmorMaterial Enum's
  	 */
  	public static ArmorMaterial armorFyrite, armorMalachite, armorIllumenite, armorDragonstone;
	
    /**
     * Creating the Armor Renderers. This is simply so you can see the armor texture when you wear it.
     */
  	public static int rendererFyrite, rendererMalachite, rendererIllumenite, rendererDragonstone;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new EventHelper());
		
		//Configuration
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
		
		/**
		 * Registering things such as the world generator, tile entities and GUI's. Adds localisations.
		 * Thanks to @zot for the code for loading localisations automatically.
		 */
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, proxy);
		GameRegistry.registerWorldGenerator(new Generator(), 2);
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
        toolMalachite.customCraftingMaterial = Content.malachite_ingot;
        toolAshstone.customCraftingMaterial = Content.ashstone_gem;
        toolDragonstone.customCraftingMaterial = Content.dragonstone_gem;
        toolArgonite.customCraftingMaterial = Content.argonite_ingot;
        toolFyrite.customCraftingMaterial = Content.fyrite_ingot;
        toolIllumenite.customCraftingMaterial = Content.illumenite_ingot;
        
        armorFyrite.customCraftingMaterial = Content.fyrite_ingot;
        armorMalachite.customCraftingMaterial = Content.malachite_ingot;
        armorIllumenite.customCraftingMaterial = Content.illumenite_ingot;
        armorDragonstone.customCraftingMaterial = Content.dragonstone_gem;
		
		LogHelper.info("Plugin Loader: Netherrocks Plugin loaded successfully.");
	}
	
	public static void setAchievementTriggers()
	{
		StatTriggersHelper.statTriggers().addCraftingTrigger(new ItemStack(Content.nether_furnace), Content.netherFurnaceAch);
		StatTriggersHelper.statTriggers().addPickupTrigger(new ItemStack(Content.fyrite_ore), Content.netherRocksAch);
	}
}
