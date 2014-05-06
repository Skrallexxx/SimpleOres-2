package alexndr.SimpleOres.plugins.fusion;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import alexndr.SimpleOres.api.helpers.LogHelper;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Settings 
{
	public static Configuration settings;
	/**
	 * The method that loads/creates the settings file. Values can be changed from true to false depending on user preference, and certain other values can be set. This is called by the main SimpleOresFusion class.
	 */
	public static void doSettings(FMLPreInitializationEvent event)
    {
		/**
		 * Creating the settings file. installDir is the 'config' folder within .minecraft. configDir add a "SimpleOres Configuration/Plugins" folder within there.
		 */
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres/Plugins");
		File settingsFile = new File(configDir, "Fusion Settings.cfg");
		settings = new Configuration(settingsFile);
		LogHelper.verboseInfo("Fusion Plugin: Loading settings file at: '" + settingsFile.getAbsolutePath() + "'...");
		
		try 
	    {
			settings.load();
			
			//Toggles
			enableToolStatModification = settings.get("Toggles", "Enable Tool Stat Modification? (Advanced)", false).getBoolean(enableToolStatModification);
			enableArmorStatModification = settings.get("Toggles", "Enable Armor Stat Modification? (Advanced)", false).getBoolean(enableArmorStatModification);
			enableBlockStatModification = settings.get("Toggles", "Enable Block Stat Modification? (Advanced)", false).getBoolean(enableBlockStatModification);
	    	enableCustomFusionRecipes = settings.get("Toggles", "Enable Custom Fusion Furnace Recipes? (Advanced)", false).getBoolean(enableCustomFusionRecipes);
	    	enableExtraChunkRecipes = settings.get("Toggles", "Enable Extra Chunk Recipes?", false).getBoolean(enableExtraChunkRecipes);
			
        	//Bow Modifiers
        	thyriumBowDamageModifier = settings.get("Bow Modifiers", "Thyrium Bow Damage Modifier", 5).getInt();
        	thyriumBowZoomModifier = settings.get("Bow Modifiers", "Thyrium Bow Zoom Modifier", 35).getInt();
        	sinisiteBowDamageModifier = settings.get("Bow Modifiers", "Sinisite Bow Damage Modifier", 6).getInt();
        	sinisiteBowKnockbackModifier = settings.get("Bow Modifiers", "Sinisite Bow Knockback Modifier", 2).getInt();
        	
        	//Tool Stats
        	if(enableToolStatModification)
        	{
        		bronzeMiningLevel = settings.get("Tool Stats", "Bronze Mining Level", 2).getInt();
        		bronzeUsesNum = settings.get("Tool Stats", "Bronze Uses Number", 600).getInt();
        		bronzeMiningSpeed = (float) settings.get("Tool Stats", "Bronze Mining Speed", 9.0).getDouble(bronzeMiningSpeed);
        		bronzeDamageVsEntity = settings.get("Tool Stats", "Bronze Damage Vs Entity", 2).getInt();
        		bronzeEnchantability = settings.get("Tool Stats", "Bronze Enchantability", 7).getInt();
        		thyriumMiningLevel = settings.get("Tool Stats", "Thyrium Mining Level", 3).getInt();
        		thyriumUsesNum = settings.get("Tool Stats", "Thyrium Uses Number", 2000).getInt();
        		thyriumMiningSpeed = (float) settings.get("Tool Stats", "Thyrium Mining Speed", 22.0).getDouble(thyriumMiningSpeed);
        		thyriumDamageVsEntity = settings.get("Tool Stats", "Thyrium Damage Vs Entity", 6).getInt();
        		thyriumEnchantability = settings.get("Tool Stats", "Thyrium Enchantability", 28).getInt();
        		sinisiteMiningLevel = settings.get("Tool Stats", "Sinisite Mining Level", 5).getInt();
        		sinisiteUsesNum = settings.get("Tool Stats", "Sinisite Uses Number", 4100).getInt();
        		sinisiteMiningSpeed = (float) settings.get("Tool Stats", "Sinisite Mining Speed", 18.0).getDouble(sinisiteMiningSpeed);
        		sinisiteDamageVsEntity = settings.get("Tool Stats", "Sinisite Damage Vs Entity", 8).getInt();
        		sinisiteEnchantability = settings.get("Tool Stats", "Sinisite Enchantability", 11).getInt();
        	}
        	else
        		defaultToolStats();
        	
        	//Armor Stats
        	if(enableArmorStatModification)
        	{
        		bronzeArmorDurability = settings.get("Armor Stats", "Bronze Armor Durability", 16).getInt();
        		bronzeArmorDamageReduction = settings.get("Armor Stats", "Bronze Armor Damage Reduction Array", new int[] {3, 5, 3, 1}).getIntList();
        		bronzeArmorEnchantability = settings.get("Armor Stats", "Bronze Armor Enchantability", 7).getInt();
        		thyriumArmorDurability = settings.get("Armor Stats", "Thyrium Armor Durability", 39).getInt();
        		thyriumArmorDamageReduction = settings.get("Armor Stats", "Thyrium Armor Damage Reduction Array", new int[] {4, 7, 6, 3}).getIntList();
        		thyriumArmorEnchantability = settings.get("Armor Stats", "Thyrium Armor Enchantability", 28).getInt();
        		sinisiteArmorDurability = settings.get("Armor Stats", "Sinisite Armor Durability", 56).getInt();
        		sinisiteArmorDamageReduction = settings.get("Armor Stats", "Sinisite Armor Damage Reduction Array", new int[] {5, 8, 6, 5}).getIntList();
        		sinisiteArmorEnchantability = settings.get("Armor Stats", "Sinisite Armor Enchantability", 11).getInt();
        	}
        	else
        		defaultArmorStats();
        	
        	//Block Stats
        	if(enableBlockStatModification)
        	{
        		bronzeBlockHardness = (float) settings.get("Block Stats", "Bronze Block Hardness", 7.0).getDouble(bronzeBlockHardness);
        		bronzeBlockResistance = (float) settings.get("Block Stats", "Bronze Block Resistance", 12.0).getDouble(bronzeBlockResistance);
        		thyriumBlockHardness = (float) settings.get("Block Stats", "Thyrium Block Hardness", 7.0).getDouble(thyriumBlockHardness);
        		thyriumBlockResistance = (float) settings.get("Block Stats", "Thyrium Block Resistance", 12.0).getDouble(thyriumBlockResistance);
        		sinisiteBlockHardness = (float) settings.get("Block Stats", "Sinisite Block Hardness", 7.0).getDouble(sinisiteBlockHardness);
        		sinisiteBlockResistance = (float) settings.get("Block Stats", "Sinisite Block Resistance", 12.0).getDouble(sinisiteBlockResistance);
        		fusionFurnaceHardness = (float) settings.get("Block Stats", "Fusion Furnace Hardness", 3.5).getDouble(fusionFurnaceHardness);
        		fusionFurnaceResistance = (float) settings.get("Block Stats", "Fusion Furnace Resistance", 10.0).getDouble(fusionFurnaceResistance);
        		fusionFurnaceLightValue = (float) settings.get("Block Stats", "Fusion Furnace Light Value", 1.0).getDouble(fusionFurnaceLightValue);
        	}
        	else
        		defaultBlockStats();
        	
        	//Custom Fusion Furnace Recipes
	    	if(enableCustomFusionRecipes)
	    	{
	    		String example = "simpleores:copper_ore@0#2, minecraft:dye@15#1, minecraft:dye@ALL#3, simpleores:adamantium_helmet@0#2, 5.80";
	    		
	    		settings.addCustomCategoryComment("Custom Fusion Recipes", "Instructions: Change 'Number of Custom Recipes' to how many recipes you want. "
	    				+ "Restart game. Fill each 'Recipe #X' with your custom recipe. Format: input1, input2, catalyst, output, experience. "
	    				+ "Each item is in format: modid:item@metadata. Experience is a double, so 1.00, 10.76, etc. are all accepted. "
	    				+ "For metadata, type ALL if you want any subtype of that item to be usable (AKA Wildcard Value). See the example." );
	    		
	    		recipeNum = settings.get("Custom Fusion Recipes", "Number of Custom Recipes", 0).getInt();
	    		exampleRecipe = settings.get("Custom Fusion Recipes", "Example Recipe (isn't actually loaded)", example).getString();
	    		
	    		if(recipeNum > 0)
	    		{
	    			for(int i = 0; i < recipeNum; i++)
	    			{
	    				settings.get("Custom Fusion Recipes", "Custom Recipe #" + (i+1), new String()).getString();
	    			}
	    		}
	    	}
	    	
	    	LogHelper.verboseInfo("Fusion Plugin: Settings file loaded successfully.");
	    }
		
    	catch (Exception e) 
    	{
    		LogHelper.info("Fusion Plugin: Failed to load the Settings file.");
    	}
		
    	finally 
    	{
    		settings.save();
    	}
    }
	
	public static void defaultToolStats()
	{
		bronzeMiningLevel = 2;
		bronzeUsesNum = 600;
		bronzeMiningSpeed = 9.0F;
		bronzeDamageVsEntity = 2;
		bronzeEnchantability = 7;
		thyriumMiningLevel = 3;
		thyriumUsesNum = 2000;
		thyriumMiningSpeed = 22.0F;
		thyriumDamageVsEntity = 6;
		thyriumEnchantability = 28;
		sinisiteMiningLevel = 5;
		sinisiteUsesNum = 4100;
		sinisiteMiningSpeed = 18.0F;
		sinisiteDamageVsEntity = 8;
		sinisiteEnchantability = 11;
	}
	
	public static void defaultArmorStats()
	{
		bronzeArmorDurability = 16;
		bronzeArmorDamageReduction = new int[] {3, 5, 3, 1};
		bronzeArmorEnchantability = 7;
		thyriumArmorDurability = 39;
		thyriumArmorDamageReduction = new int[] {4, 8, 7, 4};
		thyriumArmorEnchantability = 28;
		sinisiteArmorDurability = 56;
		sinisiteArmorDamageReduction = new int[] {6, 8, 8, 7};
		sinisiteArmorEnchantability = 11;
	}
	
	public static void defaultBlockStats()
	{
		bronzeBlockHardness = 7.0F;
		bronzeBlockResistance = 12.0F;
		thyriumBlockHardness = 7.0F;
		thyriumBlockResistance = 12.0F;
		sinisiteBlockHardness = 7.0F;
		sinisiteBlockResistance = 12.0F;
		fusionFurnaceHardness = 3.5F;
		fusionFurnaceResistance = 10.0F;
		fusionFurnaceLightValue = 1.0F;
	}
	
	//Bow Modifiers
	public static int thyriumBowDamageModifier, thyriumBowZoomModifier, sinisiteBowDamageModifier, sinisiteBowKnockbackModifier;
	
	//Toggles
	public static boolean enableToolStatModification, enableArmorStatModification, enableBlockStatModification;
	public static boolean enableCustomFusionRecipes, enableExtraChunkRecipes;
	
	//Tool Stats
	public static int bronzeMiningLevel, thyriumMiningLevel, sinisiteMiningLevel;
	public static int bronzeUsesNum, thyriumUsesNum, sinisiteUsesNum;
	public static float bronzeMiningSpeed, thyriumMiningSpeed, sinisiteMiningSpeed;
	public static int bronzeDamageVsEntity, thyriumDamageVsEntity, sinisiteDamageVsEntity;
	public static int bronzeEnchantability, thyriumEnchantability, sinisiteEnchantability;
	
	//Armor Stats
	public static int bronzeArmorDurability, thyriumArmorDurability, sinisiteArmorDurability;
	public static int[] bronzeArmorDamageReduction, thyriumArmorDamageReduction, sinisiteArmorDamageReduction;
	public static int bronzeArmorEnchantability, thyriumArmorEnchantability, sinisiteArmorEnchantability;
	
	//Block Stats
	public static float bronzeBlockHardness, thyriumBlockHardness, sinisiteBlockHardness;
	public static float bronzeBlockResistance, thyriumBlockResistance, sinisiteBlockResistance;
	public static float fusionFurnaceHardness, fusionFurnaceResistance, fusionFurnaceLightValue;
	
	//Custom Fusion Recipes
	public static int recipeNum;
	public static String exampleRecipe;
}
