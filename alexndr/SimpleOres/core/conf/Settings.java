package alexndr.SimpleOres.core.conf;

import java.io.File;

import alexndr.SimpleOres.api.HandlerLogger;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Settings 
{
	public static Configuration settings;

	/**
	 * The method that loads/creates the settings file. Values can be changed from true to false depending on user preference, and certain other values can be set. This is called by the main SimpleOres class.
	 */
	public static void doSettings(FMLPreInitializationEvent event)
    {
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres Configuration");
		settings = new Configuration(new File(configDir, "SimpleOresSettings.cfg"));
		
		try 
	    {
			settings.load();
	    	
	    	//Toggles
	    	enableSeparateTabs = settings.get("Toggles", "Use Separate Creative Tabs?", true).getBoolean(enableSeparateTabs);
	    	enableUpdateChecker = settings.get("Toggles", "Enable Update Checker?", true).getBoolean(enableUpdateChecker);
	    	enableToolStatModification = settings.get("Toggles", "Enable Tool Stat Modification? (Advanced)", false).getBoolean(enableToolStatModification);
	    	enableArmorStatModification = settings.get("Toggles", "Enable Armor Stat Modification? (Advanced)", false).getBoolean(enableArmorStatModification);
	    	enableBlockStatModification = settings.get("Toggles", "Enable Block Stat Modification? (Advanced)", false).getBoolean(enableBlockStatModification);
	    	enableHigherDimensionGen = settings.get("Toggles", "Enable Higher Dimension Generation? (Advanced)", false).getBoolean(enableHigherDimensionGen);
	    	enableColoredGuis = settings.get("Toggles", "Enable Colored Gui's?", true).getBoolean(enableColoredGuis);
	    	
        	//Adjustable Ore Spawn Rates 
        	copperSpawnRate = settings.get("Spawn Rates", "Copper Spawn Rate", 35).getInt();
        	tinSpawnRate = settings.get("Spawn Rates", "Tin Spawn Rate", 30).getInt();
        	mythrilSpawnRate = settings.get("Spawn Rates", "Mythril Spawn Rate", 8).getInt();
        	adamantiumSpawnRate = settings.get("Spawn Rates", "Adamantium Spawn Rate", 4).getInt();
        	onyxSpawnRate = settings.get("Spawn Rates", "Onyx Spawn Rate", 5).getInt();
    		
        	//Adjustable Ore Vein Sizes
        	copperVeinSize = settings.get("Vein Sizes", "Copper Vein Size", 7).getInt();
        	tinVeinSize = settings.get("Vein Sizes", "Tin Vein Size", 7).getInt();
        	mythrilVeinSize = settings.get("Vein Sizes", "Mythril Vein Size", 4).getInt();
        	adamantiumVeinSize = settings.get("Vein Sizes", "Adamantium Vein Size", 4).getInt();
        	onyxVeinSize = settings.get("Vein Sizes", "Onyx Vein Size", 7).getInt();
    		
        	//Adjustable Ore Spawn Heights
        	copperMaxHeight = settings.get("Spawn Heights", "Copper Max Spawn Height", 90).getInt();
        	copperMinHeight = settings.get("Spawn Heights", "Copper Min Spawn Height", 0).getInt();
        	tinMaxHeight = settings.get("Spawn Heights", "Tin Max Spawn Height", 90).getInt();
        	tinMinHeight = settings.get("Spawn Heights", "Tin Min Spawn Height", 0).getInt();
        	mythrilMaxHeight = settings.get("Spawn Heights", "Mythril Max Spawn Height", 35).getInt();
        	mythrilMinHeight = settings.get("Spawn Heights", "Mythril Min Spawn Height", 0).getInt();
        	adamantiumMaxHeight = settings.get("Spawn Heights", "Adamantium Max Spawn Height", 20).getInt();
        	adamantiumMinHeight = settings.get("Spawn Heights", "Adamantium Min Spawn Height", 0).getInt();
        	onyxMaxHeight = settings.get("Spawn Heights", "Onyx Max Spawn Height", 256).getInt();
        	onyxMinHeight = settings.get("Spawn Heights", "Onyx Min Spawn Height", 0).getInt();
    		
        	//Custom Furnace Multipliers
        	mythrilFurnaceMultiplier = settings.get("Custom Furnaces", "Mythril Furnace Fuel Length Multiplier", 2).getInt();
        	onyxFurnaceMultiplier = settings.get("Custom Furnaces", "Onyx Furnace Extra Yield Amount", 1).getInt();
        	onyxFurnaceMultiChance = settings.get("Custom Furnaces", "Onyx Furnace Multi Yield Chance (From 1 to 100)", 33).getInt();
	    	
        	//Bow Modifiers
        	mythrilBowDamageModifier = settings.get("Bow Modifiers", "Mythril Bow Damage Modifier", 2).getInt();
        	onyxBowDamageModifier = settings.get("Bow Modifiers", "Onyx Bow Damage Modifier", 5).getInt();
        	
        	//Higher Dimensions
        	if(enableHigherDimensionGen)
        	{
        		settings.addCustomCategoryComment("Higher Dimensions", "Instructions: Add each dimension ID to a new line between the '<' and '>'.");
        		dimensionIDsArray = settings.get("Higher Dimensions", "Higher Dimensions ID List", new int[]{}).getIntList();
        		System.out.println("Number of dimension ID's in the array = " + dimensionIDsArray.length);
    			try
    			{
            		for(int i = 0; i < dimensionIDsArray.length; i++)
            		{
            			settings.get("Higher Dimension ID: " + dimensionIDsArray[i], "Copper Spawn Rate", 35).getInt();
            			settings.get("Higher Dimension ID: " + dimensionIDsArray[i], "Tin Spawn Rate", 30).getInt();
            			settings.get("Higher Dimension ID: " + dimensionIDsArray[i], "Mythril Spawn Rate", 8).getInt();
            			settings.get("Higher Dimension ID: " + dimensionIDsArray[i], "Adamantium Spawn Rate", 4).getInt();
            			settings.get("Higher Dimension ID: " + dimensionIDsArray[i], "Copper Max Spawn Height", 90).getInt();
            			settings.get("Higher Dimension ID: " + dimensionIDsArray[i], "Copper Min Spawn Height", 0).getInt();
            			settings.get("Higher Dimension ID: " + dimensionIDsArray[i], "Tin Max Spawn Height", 90).getInt();
            			settings.get("Higher Dimension ID: " + dimensionIDsArray[i], "Tin Min Spawn Height", 0).getInt();
            			settings.get("Higher Dimension ID: " + dimensionIDsArray[i], "Mythril Max Spawn Height", 35).getInt();
            			settings.get("Higher Dimension ID: " + dimensionIDsArray[i], "Mythril Min Spawn Height", 0).getInt();
            			settings.get("Higher Dimension ID: " + dimensionIDsArray[i], "Adamantium Max Spawn Height", 20).getInt();
            			settings.get("Higher Dimension ID: " + dimensionIDsArray[i], "Adamantium Min Spawn Height", 0).getInt();
            			settings.get("Higher Dimension ID: " + dimensionIDsArray[i], "Copper Vein Size", 7).getInt();
            			settings.get("Higher Dimension ID: " + dimensionIDsArray[i], "Tin Vein Size", 7).getInt();
            			settings.get("Higher Dimension ID: " + dimensionIDsArray[i], "Mythril Vein Size", 4).getInt();
            			settings.get("Higher Dimension ID: " + dimensionIDsArray[i], "Adamantium Vein Size", 4).getInt();
            		}
    			}
    			catch(Exception e)
    			{
    				
    			}
        	}
        	else
        		dimensionIDsArray = new int[]{};
        	
        	//Tool Stat Modifiers
	    	if(enableToolStatModification)
	    	{
	    		copperMiningLevel = settings.get("Tool Stats", "Copper Mining Level", 1).getInt();
	    		copperUsesNum = settings.get("Tool Stats", "Copper Uses Number", 185).getInt();
	    		copperMiningSpeed = (float) settings.get("Tool Stats", "Copper Mining Speed", 4.0).getDouble(copperMiningSpeed);
	    		copperDamageVsEntity = settings.get("Tool Stats", "Copper Damage Vs Entity", 1).getInt();
	    		copperEnchantability = settings.get("Tool Stats", "Copper Enchantability", 8).getInt();
	    		tinMiningLevel = settings.get("Tool Stats", "Tin Mining Level", 1).getInt();
	    		tinUsesNum = settings.get("Tool Stats", "Tin Uses Number", 220).getInt();
	    		tinMiningSpeed = (float) settings.get("Tool Stats", "Tin Mining Speed", 3.5).getDouble(tinMiningSpeed);
	    		tinDamageVsEntity = settings.get("Tool Stats", "Tin Damage Vs Entity", 1).getInt();
	    		tinEnchantability = settings.get("Tool Stats", "Tin Enchantability", 8).getInt();
	    		mythrilMiningLevel = settings.get("Tool Stats", "Mythril Mining Level", 2).getInt();
	    		mythrilUsesNum = settings.get("Tool Stats", "Mythril Uses Number", 800).getInt();
	    		mythrilMiningSpeed = (float) settings.get("Tool Stats", "Mythril Mining Speed", 8.0).getDouble(mythrilMiningSpeed);
	    		mythrilDamageVsEntity = settings.get("Tool Stats", "Mythril Damage Vs Entity", 3).getInt();
	    		mythrilEnchantability = settings.get("Tool Stats", "Mythril Enchantability", 12).getInt();
	    		adamantiumMiningLevel = settings.get("Tool Stats", "Adamantium Mining Level", 2).getInt();
	    		adamantiumUsesNum = settings.get("Tool Stats", "Adamantium Uses Number", 1150).getInt();
	    		adamantiumMiningSpeed = (float) settings.get("Tool Stats", "Adamantium Mining Speed", 14.0).getDouble(adamantiumMiningSpeed);
	    		adamantiumDamageVsEntity = settings.get("Tool Stats", "Adamantium Damage Vs Entity", 3).getInt();
	    		adamantiumEnchantability = settings.get("Tool Stats", "Adamantium Enchantability", 3).getInt();
	    		onyxMiningLevel = settings.get("Tool Stats", "Onyx Mining Level", 4).getInt();
	    		onyxUsesNum = settings.get("Tool Stats", "Onyx Uses Number", 3280).getInt();
	    		onyxMiningSpeed = (float) settings.get("Tool Stats", "Onyx Mining Speed", 10.0).getDouble(onyxMiningSpeed);
	    		onyxDamageVsEntity = settings.get("Tool Stats", "Onyx Damage Vs Entity", 5).getInt();
	    		onyxEnchantability = settings.get("Tool Stats", "Onyx Enchantability", 15).getInt();
	    	}    	
	    	else
	    		toolStatDefaults();
	    	
	    	//Armor Stat Modifiers
	    	if(enableArmorStatModification)
	    	{
	    		copperArmorDurability = settings.get("Armor Stats", "Copper Armor Durability", 8).getInt();
	    		copperArmorDamageReduction = settings.get("Armor Stats", "Copper Armor Damage Reduction Array", new int[] {2, 3, 2, 1}).getIntList();
	    		copperArmorEnchantability = settings.get("Armor Stats", "Copper Armor Enchantability", 8).getInt();
	    		
	    		tinArmorDurability = settings.get("Armor Stats", "Tin Armor Durability", 8).getInt();
	    		tinArmorDamageReduction = settings.get("Armor Stats", "Tin Armor Damage Reduction Array", new int[] {2, 3, 2, 1}).getIntList();
	    		tinArmorEnchantability = settings.get("Armor Stats", "Tin Armor Enchantability", 8).getInt();
	    		
	    		mythrilArmorDurability = settings.get("Armor Stats", "Mythril Armor Durability", 22).getInt();
	    		mythrilArmorDamageReduction = settings.get("Armor Stats", "Mythril Armor Damage Reduction Array", new int[] {3, 5, 4, 3}).getIntList();
	    		mythrilArmorEnchantability = settings.get("Armor Stats", "Mythril Armor Enchantability", 12).getInt();
	    		
	    		adamantiumArmorDurability = settings.get("Armor Stats", "Adamantium Armor Durability", 28).getInt();
	    		adamantiumArmorDamageReduction = settings.get("Armor Stats", "Adamantium Armor Damage Reduction Array", new int[] {3, 8, 6, 2}).getIntList();
	    		adamantiumArmorEnchantability = settings.get("Armor Stats", "Adamantium Armor Enchantability", 3).getInt();
	    		
	    		onyxArmorDurability = settings.get("Armor Stats", "Onyx Armor Durability", 45).getInt();
	    		onyxArmorDamageReduction = settings.get("Armor Stats", "Onyx Armor Damage Reduction Array", new int[] {5, 8, 6, 5}).getIntList();
	    		onyxArmorEnchantability = settings.get("Armor Stats", "Onyx Armor Enchantability", 15).getInt();   		
	    	}
	    	else
	    		armorStatDefaults();
	    	
	    	//Block Stat Modifiers
	    	if(enableBlockStatModification)
	    	{
	    		copperOreHarvestLevel = settings.get("Block Stats", "Copper Ore Harvest Level", 1).getInt();
	    		copperOreHardness = (float) settings.get("Block Stats", "Copper Ore Hardness", 1.7).getDouble(copperOreHardness);
	    		copperOreResistance = (float) settings.get("Block Stats", "Copper Ore Resistance", 5.0).getDouble(copperOreResistance);
	    		copperBlockHardness = (float) settings.get("Block Stats", "Copper Block Hardness", 7.0).getDouble(copperBlockHardness);
	    		copperBlockResistance = (float) settings.get("Block Stats", "Copper Block Resistance", 12.0).getDouble(copperBlockResistance);
	    		copperDoorHardness = (float) settings.get("Block Stats", "Copper Door Hardness", 7.0).getDouble(copperDoorHardness);
	    		copperDoorResistance = (float) settings.get("Block Stats", "Copper Door Resistance", 12.0).getDouble(copperDoorResistance);
	    		copperBarsHardness = (float) settings.get("Block Stats", "Copper Bars Hardness", 3.0).getDouble(copperBarsHardness);
	    		copperBarsResistance = (float) settings.get("Block Stats", "Copper Bars Resistance", 10.0).getDouble(copperBarsResistance);
	    		
	    		tinOreHarvestLevel = settings.get("Block Stats", "Tin Ore Harvest Level", 1).getInt();
	    		tinOreHardness = (float) settings.get("Block Stats", "Tin Ore Hardness", 3.0).getDouble(tinOreHardness);
	    		tinOreResistance = (float) settings.get("Block Stats", "Tin Ore Resistance", 5.0).getDouble(tinOreResistance);
	    		tinBlockHardness = (float) settings.get("Block Stats", "Tin Block Hardness", 7.0).getDouble(tinBlockHardness);
	    		tinBlockResistance = (float) settings.get("Block Stats", "Tin Block Resistance", 12.0).getDouble(tinBlockResistance);
	    		tinBarsHardness = (float) settings.get("Block Stats", "Tin Bars Hardness", 3.0).getDouble(tinBarsHardness);
	    		tinBarsResistance = (float) settings.get("Block Stats", "Tin Bars Resistance", 10.0).getDouble(tinBarsResistance);
	    		
	    		mythrilOreHarvestLevel = settings.get("Block Stats", "Mythril Ore Harvest Level", 2).getInt();
	    		mythrilOreHardness = (float) settings.get("Block Stats", "Mythril Ore Hardness", 4.0).getDouble(mythrilOreHardness);
	    		mythrilOreResistance = (float) settings.get("Block Stats", "Mythril Ore Resistance", 5.0).getDouble(mythrilOreResistance);
	    		mythrilBlockHardness = (float) settings.get("Block Stats", "Mythril Block Hardness", 7.0).getDouble(mythrilBlockHardness);
	    		mythrilBlockResistance = (float) settings.get("Block Stats", "Mythril Block Resistance", 12.0).getDouble(mythrilBlockResistance);
	    		mythrilFurnaceHardness = (float) settings.get("Block Stats", "Mythril Furnace Hardness", 3.5).getDouble(mythrilFurnaceHardness);
	    		mythrilFurnaceResistance = (float) settings.get("Block Stats", "Mythril Furnace Resistance", 10.0).getDouble(mythrilFurnaceResistance);
	    		mythrilFurnaceLightValue = (float) settings.get("Block Stats", "Mythril Furnace Light Value", 1.0).getDouble(mythrilFurnaceLightValue);
	    		mythrilBarsHardness = (float) settings.get("Block Stats", "Mythril Bars Hardness", 6.0).getDouble(mythrilBarsHardness);
	    		mythrilBarsResistance = (float) settings.get("Block Stats", "Mythril Bars Hardness", 20.0).getDouble(mythrilBarsResistance);
	    		
	    		adamantiumOreHarvestLevel = settings.get("Block Stats", "Adamantium Ore Harvest Level", 2).getInt();
	    		adamantiumOreHardness = (float) settings.get("Block Stats", "Adamantium Ore Hardness", 5.0).getDouble(adamantiumOreHardness);
	    		adamantiumOreResistance = (float) settings.get("Block Stats", "Adamantium Ore Resistance", 5.0).getDouble(adamantiumOreResistance);
	    		adamantiumBlockHardness = (float) settings.get("Block Stats", "Adamantium Block Hardness", 7.0).getDouble(adamantiumBlockHardness);
	    		adamantiumBlockResistance = (float) settings.get("Block Stats", "Adamantium Block Resistance", 12.0).getDouble(adamantiumBlockResistance);
	    		adamantiumBarsHardness = (float) settings.get("Block Stats", "Adamantium Bars Hardness", 8.0).getDouble(adamantiumBarsHardness);
	    		adamantiumBarsResistance = (float) settings.get("Block Stats", "Adamantium Bars Resistance", 30.0).getDouble(adamantiumBarsResistance);
	    		
	    		onyxOreHarvestLevel = settings.get("Block Stats", "Onyx Ore Harvest Level", 3).getInt();
	    		onyxOreHardness = (float) settings.get("Block Stats", "Onyx Ore Hardness", 7.0).getDouble(onyxOreHardness);
	    		onyxOreResistance = (float) settings.get("Block Stats", "Onyx Ore Resistance", 5.0).getDouble(onyxOreResistance);
	    		onyxBlockHardness = (float) settings.get("Block Stats", "Onyx Block Hardness", 25.0).getDouble(onyxBlockHardness);
	    		onyxBlockResistance = (float) settings.get("Block Stats", "Onyx Block Resistance", 40.0).getDouble(onyxBlockResistance);
	    		onyxFurnaceHardness = (float) settings.get("Block Stats", "Onyx Furnace Hardness", 20.0).getDouble(onyxFurnaceHardness);
	    		onyxFurnaceResistance = (float) settings.get("Block Stats", "Onyx Furnace Resistance", 40.0).getDouble(onyxFurnaceResistance);
	    		onyxFurnaceLightValue = (float) settings.get("Block Stats", "Onyx Furnace Light Value", 1.0).getDouble(onyxFurnaceLightValue);
	    		onyxDoorHardness = (float) settings.get("Block Stats", "Onyx Door Hardness", 25.0).getDouble(onyxDoorHardness);
	    		onyxDoorResistance = (float) settings.get("Block Stats", "Onyx Door Resistance", 40.0).getDouble(onyxDoorResistance);
	    		onyxBarsHardness = (float) settings.get("Block Stats", "Onyx Bars Hardness", 10.0).getDouble(onyxBarsHardness);
	    		onyxBarsResistance = (float) settings.get("Block Stats", "Onyx Bars Resistance", 40.0).getDouble(onyxBarsResistance);
	    	}
	    	else
	    		blockStatDefaults();
	    }
		
    	catch (Exception e) 
    	{
    		HandlerLogger.logSevere("SimpleOres 2 failed to load it's Settings file.");
    	}
		
    	finally 
    	{
    		settings.save();
    	}
    }
	
	public static void toolStatDefaults()
	{
		copperMiningLevel = 1;
		copperUsesNum = 185;
		copperMiningSpeed = 4.0F;
		copperDamageVsEntity = 1;
		copperEnchantability = 8;
		tinMiningLevel = 1;
		tinUsesNum = 220;
		tinMiningSpeed = 3.5F;
		tinDamageVsEntity = 1;
		tinEnchantability = 8;
		mythrilMiningLevel = 2;
		mythrilUsesNum = 800;
		mythrilMiningSpeed = 8.0F;
		mythrilDamageVsEntity = 3;
		mythrilEnchantability = 12;
		adamantiumMiningLevel = 2;
		adamantiumUsesNum = 1150;
		adamantiumMiningSpeed = 14.0F;
		adamantiumDamageVsEntity = 3;
		adamantiumEnchantability = 3;
		onyxMiningLevel = 4;
		onyxUsesNum = 3280;
		onyxMiningSpeed = 10.0F;
		onyxDamageVsEntity = 5;
		onyxEnchantability = 15;
	}
	
	public static void armorStatDefaults()
	{
		copperArmorDurability = 8;
		copperArmorDamageReduction = new int[] {2, 3, 2, 1};
		copperArmorEnchantability = 8;
		tinArmorDurability = 8;
		tinArmorDamageReduction = new int[] {2, 3, 2, 1};
		tinArmorEnchantability = 8;
		mythrilArmorDurability = 22;
		mythrilArmorDamageReduction = new int[] {3, 5, 4, 3};
		mythrilArmorEnchantability = 12;
		adamantiumArmorDurability = 28;
		adamantiumArmorDamageReduction = new int[] {3, 8, 6, 2};
		adamantiumArmorEnchantability = 3;
		onyxArmorDurability = 45;
		onyxArmorDamageReduction = new int[] {5, 8, 6, 5};
		onyxArmorEnchantability = 15;
	}
	
	public static void blockStatDefaults()
	{
		copperOreHarvestLevel = 1;
		copperOreHardness = 1.7F;
		copperOreResistance = 5.0F;
		copperBlockHardness = 7.0F;
		copperBlockResistance = 12.0F;
		copperDoorHardness = 7.0F;
		copperDoorResistance = 12.0F;
		copperBarsHardness = 3.0F;
		copperBarsResistance = 10.0F;
		
		tinOreHarvestLevel = 1;
		tinOreHardness = 3.0F;
		tinOreResistance = 5.0F;
		tinBlockHardness = 7.0F;
		tinBlockResistance = 12.0F;
		tinBarsHardness = 3.0F;
		tinBarsResistance = 10.0F;
		
		mythrilOreHarvestLevel = 2;
		mythrilOreHardness = 4.0F;
		mythrilOreResistance = 5.0F;
		mythrilBlockHardness = 7.0F;
		mythrilBlockResistance = 12.0F;
		mythrilFurnaceHardness = 3.5F;
		mythrilFurnaceResistance = 10.0F;
		mythrilFurnaceLightValue = 1.0F;
		mythrilBarsHardness = 6.0F;
		mythrilBarsResistance = 20.0F;
		
		adamantiumOreHarvestLevel = 2;
		adamantiumOreHardness = 5.0F;
		adamantiumOreResistance = 5.0F;
		adamantiumBlockHardness = 7.0F;
		adamantiumBlockResistance = 12.0F;
		adamantiumBarsHardness = 8.0F;
		adamantiumBarsResistance = 30.0F;
		
		onyxOreHarvestLevel = 3;
		onyxOreHardness = 7.0F;
		onyxOreResistance = 5.0F;
		onyxBlockHardness = 25.0F;
		onyxBlockResistance = 40.0F;
		onyxFurnaceHardness = 20.0F;
		onyxFurnaceResistance = 40.0F;
		onyxFurnaceLightValue = 1.0F;
		onyxDoorHardness = 25.0F;
		onyxDoorResistance = 40.0F;
		onyxBarsHardness = 10.0F;
		onyxBarsResistance = 40.0F;
	}
	
	//Toggles
		public static boolean enableSeparateTabs;
		public static boolean enableUpdateChecker;
		public static boolean enableToolStatModification;
		public static boolean enableArmorStatModification;
		public static boolean enableBlockStatModification;
		public static boolean enableHigherDimensionGen;
		public static boolean enableColoredGuis;
		
		//Ore Spawn Rates
		public static int copperSpawnRate;
		public static int tinSpawnRate;
		public static int mythrilSpawnRate;
		public static int adamantiumSpawnRate;
		public static int onyxSpawnRate;
		
		//Ore Vein Sizes
		public static int copperVeinSize;
		public static int tinVeinSize;
		public static int mythrilVeinSize;
		public static int adamantiumVeinSize;
		public static int onyxVeinSize;
		
		//Ore Spawn Heights
		public static int copperMaxHeight;
		public static int copperMinHeight;
		public static int tinMaxHeight;
		public static int tinMinHeight;
		public static int mythrilMaxHeight;
		public static int mythrilMinHeight;
		public static int adamantiumMaxHeight;
		public static int adamantiumMinHeight;
		public static int onyxMaxHeight;
		public static int onyxMinHeight;
		
		//Custom Furnaces
		public static int mythrilFurnaceMultiplier;
		public static int onyxFurnaceMultiplier;
		public static int onyxFurnaceMultiChance;
		
		//Bow Modifiers
		public static int mythrilBowDamageModifier;
		public static int onyxBowDamageModifier;
		
		//Higher Dimensions
		public static int[] dimensionIDsArray;
		
		//Tool Stats
		public static int copperMiningLevel;
		public static int copperUsesNum;
		public static float copperMiningSpeed;
		public static int copperDamageVsEntity;
		public static int copperEnchantability;
		public static int tinMiningLevel;
		public static int tinUsesNum;
		public static float tinMiningSpeed;
		public static int tinDamageVsEntity;
		public static int tinEnchantability;
		public static int mythrilMiningLevel;
		public static int mythrilUsesNum;
		public static float mythrilMiningSpeed;
		public static int mythrilDamageVsEntity;
		public static int mythrilEnchantability;
		public static int adamantiumMiningLevel;
		public static int adamantiumUsesNum;
		public static float adamantiumMiningSpeed;
		public static int adamantiumDamageVsEntity;
		public static int adamantiumEnchantability;
		public static int onyxMiningLevel;
		public static int onyxUsesNum;
		public static float onyxMiningSpeed;
		public static int onyxDamageVsEntity;
		public static int onyxEnchantability;
		
		//Armor Stats
		public static int copperArmorDurability;
		public static int[] copperArmorDamageReduction;
		public static int copperArmorEnchantability;
		public static int tinArmorDurability;
		public static int[] tinArmorDamageReduction;
		public static int tinArmorEnchantability;
		public static int mythrilArmorDurability;
		public static int[] mythrilArmorDamageReduction;
		public static int mythrilArmorEnchantability;
		public static int adamantiumArmorDurability;
		public static int[] adamantiumArmorDamageReduction;
		public static int adamantiumArmorEnchantability;
		public static int onyxArmorDurability;
		public static int[] onyxArmorDamageReduction;
		public static int onyxArmorEnchantability;
		
		//Block Stats
			//Copper
			public static int copperOreHarvestLevel;
			public static float copperOreHardness;
			public static float copperOreResistance;
			public static float copperBlockHardness;
			public static float copperBlockResistance;
			public static float copperDoorHardness;
			public static float copperDoorResistance;
			public static float copperBarsHardness;
			public static float copperBarsResistance;
			
			//Tin
			public static int tinOreHarvestLevel;
			public static float tinOreHardness;
			public static float tinOreResistance;
			public static float tinBlockHardness;
			public static float tinBlockResistance;
			public static float tinBarsHardness;
			public static float tinBarsResistance;
			
			//Mythril
			public static int mythrilOreHarvestLevel;
			public static float mythrilOreHardness;
			public static float mythrilOreResistance;
			public static float mythrilBlockHardness;
			public static float mythrilBlockResistance;
			public static float mythrilFurnaceHardness;
			public static float mythrilFurnaceResistance;
			public static float mythrilFurnaceLightValue;
			public static float mythrilBarsHardness;
			public static float mythrilBarsResistance;
			
			//Adamantium
			public static int adamantiumOreHarvestLevel;
			public static float adamantiumOreHardness;
			public static float adamantiumOreResistance;
			public static float adamantiumBlockHardness;
			public static float adamantiumBlockResistance;
			public static float adamantiumBarsHardness;
			public static float adamantiumBarsResistance;
			
			//Onyx
			public static int onyxOreHarvestLevel;
			public static float onyxOreHardness;
			public static float onyxOreResistance;
			public static float onyxBlockHardness;
			public static float onyxBlockResistance;
			public static float onyxFurnaceHardness;
			public static float onyxFurnaceResistance;
			public static float onyxFurnaceLightValue;
			public static float onyxDoorHardness;
			public static float onyxDoorResistance;
			public static float onyxBarsHardness;
			public static float onyxBarsResistance;
}
