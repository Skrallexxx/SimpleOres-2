package alexndr.SimpleOres.plugins.fusion;

import java.io.File;
import java.util.logging.Level;

import alexndr.SimpleOres.api.HandlerLogger;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Settings 
{
	/**
	 * The method that loads/creates the settings file. Values can be changed from true to false depending on user preference, and certain other values can be set. This is called by the main SimpleOresFusion class.
	 */
	public static void doSettings(FMLPreInitializationEvent event)
    {
		/**
		 * Creating the settings file. installDir is the 'config' folder within .minecraft. configDir add a "SimpleOres Configuration/Plugins" folder within there.
		 */
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres Configuration/Plugins");
		Configuration settings = new Configuration(new File(configDir, "FusionSettings.cfg"));
		
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
        		thyriumArmorDamageReduction = settings.get("Armor Stats", "Thyrium Armor Damage Reduction Array", new int[] { 4, 8, 7, 4}).getIntList();
        		thyriumArmorEnchantability = settings.get("Armor Stats", "Thyrium Armor Enchantability", 28).getInt();
        		sinisiteArmorDurability = settings.get("Armor Stats", "Sinisite Armor Durability", 56).getInt();
        		sinisiteArmorDamageReduction = settings.get("Armor Stats", "Sinisite Armor Damage Reduction Array", new int[] {6, 8, 8, 7}).getIntList();
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
	    		settings.addCustomCategoryComment("Custom Fusion Recipes", "Instructions: 1. Every list must have the same number of values in it. 2. Metadata supports the string 'WILDCARD_VALUE' to denote ANY metadata value. 3. ID's are ints only, so no colon (ie. 101:10). Metadata goes in the metadata list.");
	    		input1Id = settings.get("Custom Fusion Recipes", "Input 1 ID List", new int[] {}).getIntList();
	    		input1Meta = settings.get("Custom Fusion Recipes", "Input 1 Metadata List", new String[] {}).getStringList();
	    		input1Size = settings.get("Custom Fusion Recipes", "Input 1 Stack Size List", new int[] {}).getIntList();
	    		input2Id = settings.get("Custom Fusion Recipes", "Input 2 ID List", new int[] {}).getIntList();
	    		input2Meta = settings.get("Custom Fusion Recipes", "Input 2 Metadata List", new String[] {}).getStringList();
	    		input2Size = settings.get("Custom Fusion Recipes", "Input 2 Stack Size List", new int[] {}).getIntList();
	    		catalystId = settings.get("Custom Fusion Recipes", "Catalyst ID List", new int[] {}).getIntList();
	    		catalystMeta = settings.get("Custom Fusion Recipes", "Catalyst Metadata List", new String[] {}).getStringList();
	    		catalystSize = settings.get("Custom Fusion Recipes", "Catalyst Stack Size List", new int[] {}).getIntList();
	    		outputId = settings.get("Custom Fusion Recipes", "Output ID List", new int[] {}).getIntList();
	    		outputMeta = settings.get("Custom Fusion Recipes", "Output Metadata List", new String[] {}).getStringList();
	    		outputSize = settings.get("Custom Fusion Recipes", "Output Stack Size List", new int[] {}).getIntList();
	    		expAmount = settings.get("Custom Fusion Recipes", "Experience Amount List", new double[] {}).getDoubleList();
	    	}
	    }
		
    	catch (Exception e) 
    	{
    		HandlerLogger.log("Fusion Plugin: Failed to load the Settings file.");
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
	public static int thyriumBowDamageModifier;
	public static int thyriumBowZoomModifier;
	public static int sinisiteBowDamageModifier;
	public static int sinisiteBowKnockbackModifier;
	
	//Toggles
	public static boolean enableToolStatModification;
	public static boolean enableArmorStatModification;
	public static boolean enableBlockStatModification;
	public static boolean enableCustomFusionRecipes;
	public static boolean enableExtraChunkRecipes;
	
	//Tool Stats
	public static int bronzeMiningLevel;
	public static int bronzeUsesNum;
	public static float bronzeMiningSpeed;
	public static int bronzeDamageVsEntity;
	public static int bronzeEnchantability;
	public static int thyriumMiningLevel;
	public static int thyriumUsesNum;
	public static float thyriumMiningSpeed;
	public static int thyriumDamageVsEntity;
	public static int thyriumEnchantability;
	public static int sinisiteMiningLevel;
	public static int sinisiteUsesNum;
	public static float sinisiteMiningSpeed;
	public static int sinisiteDamageVsEntity;
	public static int sinisiteEnchantability;
	
	//Armor Stats
	public static int bronzeArmorDurability;
	public static int[] bronzeArmorDamageReduction;
	public static int bronzeArmorEnchantability;
	public static int thyriumArmorDurability;
	public static int[] thyriumArmorDamageReduction;
	public static int thyriumArmorEnchantability;
	public static int sinisiteArmorDurability;
	public static int[] sinisiteArmorDamageReduction;
	public static int sinisiteArmorEnchantability;
	
	//Block Stats
	public static float bronzeBlockHardness;
	public static float bronzeBlockResistance;
	public static float thyriumBlockHardness;
	public static float thyriumBlockResistance;
	public static float sinisiteBlockHardness;
	public static float sinisiteBlockResistance;
	public static float fusionFurnaceHardness;
	public static float fusionFurnaceResistance;
	public static float fusionFurnaceLightValue;
	
	//Custom Fusion Recipes
	public static int[] input1Id;
	public static String[] input1Meta;
	public static int[] input1Size;
	public static int[] input2Id;
	public static String[] input2Meta;
	public static int[] input2Size;
	public static int[] catalystId;
	public static String[] catalystMeta;
	public static int[] catalystSize;
	public static int[] outputId;
	public static String[] outputMeta;
	public static int[] outputSize;
	public static double[] expAmount;
}
