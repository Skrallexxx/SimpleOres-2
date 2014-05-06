package alexndr.SimpleOres.plugins.netherrocks;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import alexndr.SimpleOres.api.helpers.LogHelper;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Settings 
{
	public static Configuration settings;
	
	public static void loadSettings(FMLPreInitializationEvent event)
	{
		/**
		 * Creating the config file. installDir is the 'config' file within .minecraft. configDir add a "SimpleOres Configuration/Plugins" folder within there.
		 */
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres/Plugins");
		File settingsFile = new File(configDir, "Netherrocks Settings.cfg");
    	settings = new Configuration(settingsFile);
    	LogHelper.verboseInfo("Netherrocks Plugin: Loading settings file at: '" + settingsFile.getAbsolutePath() + "'...");
    	
    	try
    	{
    		settings.load();
    		
    		//Toggles
    		enableArmorEffects = settings.get("Toggles", "Enable Special Armor Effects?", true).getBoolean(enableArmorEffects);
    		enableSpecialToolEffects = settings.get("Toggles", "Enable Special Tool Effects?", true).getBoolean(enableSpecialToolEffects);
    		enableColoredGuis = settings.get("Toggles", "Enable Colored Gui's?", true).getBoolean(enableColoredGuis);
    		enableToolStatModification = settings.get("Toggles", "Enable Tool Stat Modification? (Advanced)", false).getBoolean(enableToolStatModification);
    		enableArmorStatModification = settings.get("Toggles", "Enable Armor Stat Modification? (Advanced)", false).getBoolean(enableArmorStatModification);
    		enableBlockStatModification = settings.get("Toggles", "Enable Block Stat Modification? (Advanced)", false).getBoolean(enableBlockStatModification);
    		
    		//Special Tool/Armor Effects
    		malachiteArmorJumpBoostAmount = settings.get("Special Tool/Armor Effects", "Malachite Armor Jump Boost Amount", 0.15).getDouble(malachiteArmorJumpBoostAmount);
    		malachiteArmorMinFallHeight = (float) settings.get("Special Tool/Armor Effects", "Malachite Armor Fall Damage Height", 4.0).getDouble(malachiteArmorMinFallHeight);
    		illumeniteSwordNVLength = settings.get("Special Tool/Armor Effects", "Illumenite Sword Night Vision Length (ticks)", 3600).getInt();
    		illumeniteSwordBlindnessLength = settings.get("Special Tool/Armor Effects", "Illumenite Sword Blindness Length (ticks)", 60).getInt();
    		illumeniteSwordSlowLength = settings.get("Special Tool/Armor Effects", "Illumenite Sword Slowdown Length (ticks)", 200).getInt();
    		illumeniteSwordSlowAmplifier = settings.get("Special Tool/Armor Effects", "Illumenite Sword Slowdown Amplifier (level)", 3).getInt();
    		
    		//Furnace Stats
    		netherFurnaceSpeed = settings.get("Furnace Stats", "Nether Furnace Smelting Time (ticks)", 100).getInt();
    		netherrackBurnTime = settings.get("Furnace Stats", "Netherrack Burn Time (ticks)", 200).getInt();
    		fyriteIngotBurnTime = settings.get("Furnace Stats", "Fyrite Ingot Burn Time (ticks)", 8000).getInt();
    		blazeRodBurnTime = settings.get("Furnace Stats", "Blaze Rod Burn Time (ticks)", 2400).getInt();
    		
    		//Ore Spawn Rates
        	fyriteSpawnRate = settings.get("Spawn Rates", "Fyrite Spawn Rate", 10).getInt();
        	malachiteSpawnRate = settings.get("Spawn Rates", "Malachite Spawn Rate", 10).getInt();
        	ashstoneSpawnRate = settings.get("Spawn Rates", "Ashstone Spawn Rate", 10).getInt();
        	illumeniteSpawnRate = settings.get("Spawn Rates", "Illumenite Spawn Rate", 350).getInt();
        	dragonstoneSpawnRate = settings.get("Spawn Rates", "Dragonstone Spawn Rate", 6).getInt();
        	argoniteSpawnRate = settings.get("Spawn Rates", "Argonite Spawn Rate", 10).getInt();
        	
    		//Ore Vein Sizes
        	fyriteVeinSize = settings.get("Vein Sizes", "Fyrite Vein Sizes", 6).getInt();
        	malachiteVeinSize = settings.get("Vein Sizes", "Malachite Vein Sizes", 7).getInt();
        	ashstoneVeinSize = settings.get("Vein Sizes", "Ashstone Vein Sizes", 5).getInt();
        	illumeniteVeinSize = settings.get("Vein Sizes", "Illumenite Vein Sizes", 15).getInt();
        	dragonstoneVeinSize = settings.get("Vein Sizes", "Dragonstone Vein Sizes", 5).getInt();
        	argoniteVeinSize = settings.get("Vein Sizes", "Argonite Vein Sizes", 6).getInt();
        	
    		//Ore Spawn Heights
    		fyriteSpawnHeightMax = settings.get("Spawn Heights", "Fyrite Ore Spawn Height Max", 256).getInt();
    		malachiteSpawnHeightMax = settings.get("Spawn Heights", "Malachite Ore Spawn Height Max", 256).getInt();
    		ashstoneSpawnHeightMax = settings.get("Spawn Heights", "Ashstone Ore Spawn Height Max", 256).getInt();
    		illumeniteSpawnHeightMax = settings.get("Spawn Heights", "Illumenite Ore Spawn Height Max", 256).getInt();
    		dragonstoneSpawnHeightMax = settings.get("Spawn Heights", "Dragonstone Ore Spawn Height Max", 256).getInt();
    		argoniteSpawnHeightMax = settings.get("Spawn Heights", "Argonite Ore Spawn Height Max", 256).getInt();
    		fyriteSpawnHeightMin = settings.get("Spawn Heights", "Fyrite Ore Spawn Height Min", 0).getInt();
    		malachiteSpawnHeightMin = settings.get("Spawn Heights", "Malachite Ore Spawn Height Min", 0).getInt();
    		ashstoneSpawnHeightMin = settings.get("Spawn Heights", "Ashstone Ore Spawn Height Min", 0).getInt();
    		illumeniteSpawnHeightMin = settings.get("Spawn Heights", "Illumenite Ore Spawn Height Min", 0).getInt();
    		dragonstoneSpawnHeightMin = settings.get("Spawn Heights", "Dragonstone Ore Spawn Height Min", 0).getInt();
    		argoniteSpawnHeightMin = settings.get("Spawn Heights", "Argonite Ore Spawn Height Min", 0).getInt();
        	
    		//Tool Stat Modifiers
    		if(enableToolStatModification)
    		{
    			fyriteMiningLevel = settings.get("Tool Stats", "Fyrite Mining Level", 3).getInt();
    			fyriteUsesNum = settings.get("Tool Stats", "Fyrite Uses Number", 150).getInt();
    			fyriteMiningSpeed = (float) settings.get("Tool Stats", "Fyrite Mining Speed", 8.0).getDouble(fyriteMiningSpeed);
    			fyriteDamageVsEntity = settings.get("Tool Stats", "Fyrite Damage Vs. Entity", 4).getInt();
    			fyriteEnchantability = settings.get("Tool Stats", "Fyrite Enchantability", 7).getInt();
    			malachiteMiningLevel = settings.get("Tool Stats", "Malachite Mining Level", 3).getInt();
    			malachiteUsesNum = settings.get("Tool Stats", "Malachite Uses Number", 700).getInt();
    			malachiteMiningSpeed = (float) settings.get("Tool Stats", "Malachite Mining Speed", 9.0).getDouble(malachiteMiningSpeed);
    			malachiteDamageVsEntity = settings.get("Tool Stats", "Malachite Damage Vs. Entity", 3).getInt();
    			malachiteEnchantability = settings.get("Tool Stats", "Malachite Enchantability", 39).getInt();
    			ashstoneMiningLevel = settings.get("Tool Stats", "Ashstone Mining Level", 3).getInt();
    			ashstoneUsesNum = settings.get("Tool Stats", "Ashstone Uses Number", 900).getInt();
    			ashstoneMiningSpeed = (float) settings.get("Tool Stats", "Ashstone Mining Speed", 16.0).getDouble(ashstoneMiningSpeed);
    			ashstoneDamageVsEntity = settings.get("Tool Stats", "Ashstone Damage Vs. Entity", 2).getInt();
    			ashstoneEnchantability = settings.get("Tool Stats", "Ashstone Enchantability", 7).getInt();
    			illumeniteMiningLevel = settings.get("Tool Stats", "Illumenite Mining Level", 3).getInt();
    			illumeniteUsesNum = settings.get("Tool Stats", "Illumenite Uses Number", 700).getInt();
    			illumeniteMiningSpeed = (float) settings.get("Tool Stats", "Illumenite Mining Speed", 8.0F).getDouble(illumeniteMiningSpeed);
    			illumeniteDamageVsEntity = settings.get("Tool Stats", "Illumenite Damage Vs. Entity", 4).getInt();
    			illumeniteEnchantability = settings.get("Tool Stats", "Illumenite Enchantability", 7).getInt();
    			dragonstoneMiningLevel = settings.get("Tool Stats", "Dragonstone Mining Level", 4).getInt();
    			dragonstoneUsesNum = settings.get("Tool Stats", "Dragonstone Uses Number", 4000).getInt();
    			dragonstoneMiningSpeed = (float) settings.get("Tool Stats", "Dragonstone Mining Speed", 10.0).getDouble(dragonstoneMiningSpeed);
    			dragonstoneDamageVsEntity = settings.get("Tool Stats", "Dragonstone Damage Vs. Entity", 8).getInt();
    			dragonstoneEnchantability = settings.get("Tool Stats", "Dragonstone Enchantability", 27).getInt();
    			argoniteMiningLevel = settings.get("Tool Stats", "Argonite Mining Level", 3).getInt();
    			argoniteUsesNum = settings.get("Tool Stats", "Argonite Uses Number", 1300).getInt();
    			argoniteMiningSpeed = (float) settings.get("Tool Stats", "Argonite Mining Speed", 8.0).getDouble(argoniteMiningSpeed);
    			argoniteDamageVsEntity = settings.get("Tool Stats", "Argonite Damage Vs. Entity", 3).getInt();
    			argoniteEnchantability = settings.get("Tool Stats", "Argonite Enchantability", 18).getInt();
    		}
    		else toolStatDefaults();
    		
    		if(enableArmorStatModification)
    		{
    			fyriteArmorDurability = settings.get("Armor Stats", "Fyrite Armor Durability", 5).getInt();
    			fyriteArmorDamageReduction = settings.get("Armor Stats", "Fyrite Armor Damage Reduction Array", new int[] {3, 5, 4, 3}).getIntList();
    			fyriteArmorEnchantability = settings.get("Armor Stats", "Fyrite Armor Enchantability", 7).getInt();
    			malachiteArmorDurability = settings.get("Armor Stats", "Malachite Armor Durability", 16).getInt();
    			malachiteArmorDamageReduction = settings.get("Armor Stats", "Malachite Armor Damage Reduction Array", new int[] {2, 4, 4, 2}).getIntList();
    			malachiteArmorEnchantability = settings.get("Armor Stats", "Malachite Armor Enchantability", 39).getInt();
    			illumeniteArmorDurability = settings.get("Armor Stats", "Illumenite Armor Durability", 12).getInt();
    			illumeniteArmorDamageReduction = settings.get("Armor Stats", "Illumenite Armor Damage Reduction Array", new int[] {4, 5, 5, 3}).getIntList();
    			illumeniteArmorEnchantability = settings.get("Armor Stats", "Illumenite Armor Enchantability", 15).getInt();
    			dragonstoneArmorDurability = settings.get("Armor Stats", "Dragonstone Armor Durabilitiy", 48).getInt();
    			dragonstoneArmorDamageReduction = settings.get("Armor Stats", "Dragonstone Armor Damage Reduction Array", new int[] {3, 9, 7, 3}).getIntList();
    			dragonstoneArmorEnchantability = settings.get("Armor Stats", "Dragonstone Armor Enchantability", 27).getInt();
    		}
    		else armorStatDefaults();
    		
    		if(enableBlockStatModification)
    		{
    			fyriteOreHarvestLevel = settings.get("Block Stats", "Fyrite Ore Harvest Level", 2).getInt();
    			fyriteOreHardness = (float) settings.get("Block Stats", "Fyrite Ore Hardness", 3.0).getDouble(fyriteOreHardness);
    			fyriteOreResistance = (float) settings.get("Block Stats", "Fyrite Ore Resistance", 10.0).getDouble(fyriteOreResistance);
    			fyriteBlockHardness = (float) settings.get("Block Stats", "Fyrite Block Hardness", 7.0).getDouble(fyriteBlockHardness);
    			fyriteBlockResistance = (float) settings.get("Block Stats", "Fyrite Block Resistance", 12.0).getDouble(fyriteBlockResistance);
    			malachiteOreHarvestLevel = settings.get("Block Stats", "Malachite Ore Harvest Level", 2).getInt();
    			malachiteOreHardness = (float) settings.get("Block Stats", "Malachite Ore Hardness", 3.0).getDouble(malachiteOreHardness);
    			malachiteOreResistance = (float) settings.get("Block Stats", "Malachite Ore Resistance", 10.0).getDouble(malachiteOreResistance);
    			malachiteBlockHardness = (float) settings.get("Block Stats", "Malachite Block Hardness", 7.0).getDouble(malachiteBlockHardness);
    			malachiteBlockResistance = (float) settings.get("Block Stats", "Malachite Block Resistance", 12.0).getDouble(malachiteBlockResistance);
    			ashstoneOreHarvestLevel = settings.get("Block Stats", "Ashstone Ore Harvest Level", 3).getInt();
    			ashstoneOreHardness = (float) settings.get("Block Stats", "Ashstone Ore Hardness", 3.0).getDouble(ashstoneOreHardness);
    			ashstoneOreResistance = (float) settings.get("Block Stats", "Ashstone Ore Resistance", 10.0).getDouble(ashstoneOreResistance);
    			ashstoneBlockHardness = (float) settings.get("Block Stats", "Ashstone Block Hardness", 7.0).getDouble(ashstoneBlockHardness);
    			ashstoneBlockResistance = (float) settings.get("Block Stats", "Ashstone Block Resistance", 12.0).getDouble(ashstoneBlockResistance);
    			illumeniteOreHarvestLevel = settings.get("Block Stats", "Illumenite Ore Harvest Level", 2).getInt();
    			illumeniteOreHardness = (float) settings.get("Block Stats", "Illumenite Ore Hardness", 3.0).getDouble(illumeniteOreHardness);
    			illumeniteOreResistance = (float) settings.get("Block Stats", "Illumenite Ore Resistance", 10.0).getDouble(illumeniteOreResistance);
    			illumeniteBlockHardness = (float) settings.get("Block Stats", "Illumenite Block Hardness", 7.0).getDouble(illumeniteBlockHardness);
    			illumeniteBlockResistance = (float) settings.get("Block Stats", "Illumenite Block Resistance", 12.0).getDouble(illumeniteBlockResistance);
    			dragonstoneOreHarvestLevel = settings.get("Block Stats", "Dragonstone Ore Harvest Level", 3).getInt();
    			dragonstoneOreHardness = (float) settings.get("Block Stats", "Dragonstone Ore Hardness", 3.0).getDouble(dragonstoneOreHardness);
    			dragonstoneOreResistance = (float) settings.get("Block Stats", "Dragonstone Ore Resistance", 10.0).getDouble(dragonstoneOreResistance);
    			dragonstoneBlockHardness = (float) settings.get("Block Stats", "Dragonstone Block Hardness", 7.0).getDouble(dragonstoneBlockHardness);
    			dragonstoneBlockResistance = (float) settings.get("Block Stats", "Dragonstone Block Resistance", 12.0).getDouble(dragonstoneBlockResistance);
    			argoniteOreHarvestLevel = settings.get("Block Stats", "Argonite Ore Harvest Level", 3).getInt();
    			argoniteOreHardness = (float) settings.get("Block Stats", "Argonite Ore Hardness", 3.0).getDouble(argoniteOreHardness);
    			argoniteOreResistance = (float) settings.get("Block Stats", "Argonite Ore Resistance", 10.0).getDouble(argoniteOreResistance);
    			argoniteBlockHardness = (float) settings.get("Block Stats", "Argonite Block Hardness", 7.0).getDouble(argoniteBlockHardness);
    			argoniteBlockResistance = (float) settings.get("Block Stats", "Argonite Block Resistance", 12.0).getDouble(argoniteBlockResistance);
    			netherFurnaceHardness = (float) settings.get("Block Stats", "Nether Furnace Hardness", 3.5).getDouble(netherFurnaceHardness);
    			netherFurnaceResistance = (float) settings.get("Block Stats", "Nether Furnace Resistance", 12.0).getDouble(netherFurnaceResistance);
    			netherFurnaceLightValue = (float) settings.get("Block Stats", "Nether Furnace Light Value", 1.0).getDouble(netherFurnaceLightValue);
    			
    		}
    		else blockStatDefaults();	
    		
        	LogHelper.verboseInfo("Netherrocks Plugin: Settings loaded successfully.");
    	}
    	
    	catch(Exception e)
    	{
    		LogHelper.warning("Netherrocks Plugin: Failed to load the settings!");
    	}
    	
    	finally
    	{
    		settings.save();
    	}
	}
	
	public static void toolStatDefaults()
	{
		fyriteMiningLevel = 3;
		fyriteUsesNum = 150;
		fyriteMiningSpeed = 8.0F;
		fyriteDamageVsEntity = 4;
		fyriteEnchantability = 7;
		malachiteMiningLevel = 3;
		malachiteUsesNum = 700;
		malachiteMiningSpeed = 9.0F;
		malachiteDamageVsEntity = 3;
		malachiteEnchantability = 39;
		ashstoneMiningLevel = 3;
		ashstoneUsesNum = 900;
		ashstoneMiningSpeed = 16.0F;
		ashstoneDamageVsEntity = 2;
		ashstoneEnchantability = 7;
		illumeniteMiningLevel = 3;
		illumeniteUsesNum = 700;
		illumeniteMiningSpeed = 8.0F;
		illumeniteDamageVsEntity = 4;
		illumeniteEnchantability = 7;
		dragonstoneMiningLevel = 4;
		dragonstoneUsesNum = 4000;
		dragonstoneMiningSpeed = 10.0F;
		dragonstoneDamageVsEntity = 8;
		dragonstoneEnchantability = 27;
		argoniteMiningLevel = 3;
		argoniteUsesNum = 1300;
		argoniteMiningSpeed = 8.0F;
		argoniteDamageVsEntity = 3;
		argoniteEnchantability = 18;
	}
	
	public static void armorStatDefaults()
	{
		fyriteArmorDurability = 5;
		fyriteArmorDamageReduction = new int[] {3, 5, 4, 3};
		fyriteArmorEnchantability = 7;
		malachiteArmorDurability = 16;
		malachiteArmorDamageReduction = new int[] {2, 4, 4, 2};
		malachiteArmorEnchantability = 39;
		illumeniteArmorDurability = 12;
		illumeniteArmorDamageReduction = new int[] {4, 5, 5, 3};
		illumeniteArmorEnchantability = 15;
		dragonstoneArmorDurability = 48;
		dragonstoneArmorDamageReduction = new int[] {3, 9, 7, 3};
		dragonstoneArmorEnchantability = 27;
	}

	public static void blockStatDefaults()
	{
		fyriteOreHarvestLevel = 2;
		fyriteOreHardness = 3.0F;
		fyriteOreResistance = 10.0F;
		fyriteBlockHardness = 7.0F;
		fyriteBlockResistance = 12.0F;
		malachiteOreHarvestLevel = 2;
		malachiteOreHardness = 3.0F;
		malachiteOreResistance = 10.0F;
		malachiteBlockHardness = 7.0F;
		malachiteBlockResistance = 12.0F;
		ashstoneOreHarvestLevel = 3;
		ashstoneOreHardness = 3.0F;
		ashstoneOreResistance = 10.0F;
		ashstoneBlockHardness = 7.0F;
		ashstoneBlockResistance = 12.0F;
		illumeniteOreHarvestLevel = 2;
		illumeniteOreHardness = 3.0F;
		illumeniteOreResistance = 10.0F;
		illumeniteOreLightValue = 1.0F;
		illumeniteBlockHardness = 7.0F;
		illumeniteBlockResistance = 12.0F;
		illumeniteBlockLightValue = 1.0F;
		dragonstoneOreHarvestLevel = 3;
		dragonstoneOreHardness = 3.0F;
		dragonstoneOreResistance = 10.0F;
		dragonstoneBlockHardness = 7.0F;
		dragonstoneBlockResistance = 12.0F;
		argoniteOreHarvestLevel = 3;
		argoniteOreHardness = 3.0F;
		argoniteOreResistance = 10.0F;
		argoniteBlockHardness = 7.0F;
		argoniteBlockResistance = 12.0F;
		netherFurnaceHardness = 3.5F;
		netherFurnaceResistance = 12.0F;
		netherFurnaceLightValue = 1.0F;
	}
	
	//Toggles
	public static boolean enableArmorEffects, enableSpecialToolEffects, enableColoredGuis;
	public static boolean enableToolStatModification, enableArmorStatModification, enableBlockStatModification;

	//Special Tool/Armor Effects
	public static double malachiteArmorJumpBoostAmount;
	public static float malachiteArmorMinFallHeight;
	public static int illumeniteSwordNVLength, illumeniteSwordBlindnessLength, illumeniteSwordSlowLength, illumeniteSwordSlowAmplifier;
	
	//Furnace Multipliers
	public static int netherFurnaceSpeed, netherrackBurnTime, fyriteIngotBurnTime, blazeRodBurnTime;

	//Ore Spawn Rates
	public static int fyriteSpawnRate, malachiteSpawnRate, ashstoneSpawnRate, illumeniteSpawnRate, dragonstoneSpawnRate, argoniteSpawnRate;

	//Ore Vein Sizes
	public static int fyriteVeinSize, malachiteVeinSize, ashstoneVeinSize, illumeniteVeinSize, dragonstoneVeinSize, argoniteVeinSize;
	
	//Ore Spawn Heights
	public static int fyriteSpawnHeightMax, malachiteSpawnHeightMax, ashstoneSpawnHeightMax, illumeniteSpawnHeightMax, dragonstoneSpawnHeightMax, argoniteSpawnHeightMax;
	public static int fyriteSpawnHeightMin, malachiteSpawnHeightMin, ashstoneSpawnHeightMin, illumeniteSpawnHeightMin, dragonstoneSpawnHeightMin, argoniteSpawnHeightMin;
	
	//Tool Stats
	public static int fyriteMiningLevel, malachiteMiningLevel, ashstoneMiningLevel, illumeniteMiningLevel, dragonstoneMiningLevel, argoniteMiningLevel;
	public static int fyriteUsesNum, malachiteUsesNum, ashstoneUsesNum, illumeniteUsesNum, dragonstoneUsesNum, argoniteUsesNum;
	public static float fyriteMiningSpeed, malachiteMiningSpeed, ashstoneMiningSpeed, illumeniteMiningSpeed, dragonstoneMiningSpeed, argoniteMiningSpeed;
	public static int fyriteDamageVsEntity, malachiteDamageVsEntity, ashstoneDamageVsEntity, illumeniteDamageVsEntity, dragonstoneDamageVsEntity, argoniteDamageVsEntity;
	public static int fyriteEnchantability, malachiteEnchantability, ashstoneEnchantability, illumeniteEnchantability, dragonstoneEnchantability, argoniteEnchantability;
	
	//Armor Stats
	public static int fyriteArmorDurability, malachiteArmorDurability, illumeniteArmorDurability, dragonstoneArmorDurability;
	public static int[] fyriteArmorDamageReduction, malachiteArmorDamageReduction, illumeniteArmorDamageReduction, dragonstoneArmorDamageReduction;
	public static int fyriteArmorEnchantability, malachiteArmorEnchantability, illumeniteArmorEnchantability, dragonstoneArmorEnchantability;
	
	//Block Stats
	public static int fyriteOreHarvestLevel, malachiteOreHarvestLevel, ashstoneOreHarvestLevel, illumeniteOreHarvestLevel, dragonstoneOreHarvestLevel, argoniteOreHarvestLevel;
	public static float fyriteOreHardness, malachiteOreHardness, ashstoneOreHardness, illumeniteOreHardness, dragonstoneOreHardness, argoniteOreHardness;
	public static float fyriteOreResistance, malachiteOreResistance, ashstoneOreResistance, illumeniteOreResistance, dragonstoneOreResistance, argoniteOreResistance;
	public static float fyriteBlockHardness, malachiteBlockHardness, ashstoneBlockHardness, illumeniteBlockHardness, dragonstoneBlockHardness, argoniteBlockHardness;
	public static float fyriteBlockResistance, malachiteBlockResistance, ashstoneBlockResistance, illumeniteBlockResistance, dragonstoneBlockResistance, argoniteBlockResistance;
	public static float netherFurnaceHardness, netherFurnaceResistance, netherFurnaceLightValue, illumeniteOreLightValue, illumeniteBlockLightValue;
}
