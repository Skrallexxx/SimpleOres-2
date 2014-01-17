package alexndr.SimpleOres.core.conf;

import java.io.File;

import net.minecraftforge.common.Configuration;
import alexndr.SimpleOres.api.helpers.FreeIdHelper;
import alexndr.SimpleOres.api.helpers.LogHelper;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config 
{	
	private static FreeIdHelper get;
	
	/**
	 * The method that loads/creates the configuration file. The ID's can be changed, and their defaults are shown. This is called by the main SimpleOres class.
	 */
	public static void doConfig(FMLPreInitializationEvent event)
    {
		/**
		 * Creating the config file. installDir is the 'config' file within .minecraft. configDir add a "SimpleOres Configuration" folder within there.
		 */
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres");
		File configFile = new File(configDir, "SimpleOres Config.cfg");
    	Configuration config = new Configuration(configFile);
		LogHelper.verboseInfo("Loading config file at '" + configFile.getAbsolutePath() + "'...");
		FreeIdHelper.compileIdList();
    	
    	try 
    	{
    		config.load();
    		
    		//Block ID's
    		copperOreID = config.getBlock("Blocks", "Copper Ore", get.freeBlock()).getInt();
    		copperBlockID = config.getBlock("Blocks", "Copper Block", get.freeBlock()).getInt();
    		tinOreID = config.getBlock("Blocks", "Tin Ore", get.freeBlock()).getInt();
    		tinBlockID = config.getBlock("Blocks", "Tin Block", get.freeBlock()).getInt();
    		mythrilOreID = config.getBlock("Blocks", "Mythril Ore", get.freeBlock()).getInt();
    		mythrilBlockID = config.getBlock("Blocks", "Mythril Block", get.freeBlock()).getInt();
    		adamantiumOreID = config.getBlock("Blocks", "Adamantium Ore", get.freeBlock()).getInt();
    		adamantiumBlockID = config.getBlock("Blocks", "Adamantium Block", get.freeBlock()).getInt();
    		onyxOreID = config.getBlock("Blocks", "Onyx Ore", get.freeBlock()).getInt();
    		onyxBlockID = config.getBlock("Blocks", "Onyx Block", get.freeBlock()).getInt();
    		mythrilFurnaceID = config.getBlock("Blocks", "Mythril Furnace", get.freeBlock()).getInt();
        	mythrilFurnaceOnID = config.getBlock("Blocks", "Mythril Furnace On", get.freeBlock()).getInt();
        	onyxFurnaceID = config.getBlock("Blocks", "Onyx Furnace", get.freeBlock()).getInt();
        	onyxFurnaceOnID = config.getBlock("Blocks", "Onyx Furnace On", get.freeBlock()).getInt(); 		
    		copperDoorID = config.getBlock("Blocks", "Copper Door", get.freeBlock()).getInt();
    		onyxDoorID = config.getBlock("Blocks", "Onyx Door", get.freeBlock()).getInt();
    		copperBarsID = config.getBlock("Blocks", "Copper Bars", get.freeBlock()).getInt();
    		tinBarsID = config.getBlock("Blocks", "Tin Bars", get.freeBlock()).getInt();
    		mythrilBarsID = config.getBlock("Blocks", "Mythril Bars", get.freeBlock()).getInt();
    		adamantiumBarsID = config.getBlock("Blocks", "Adamantium Bars", get.freeBlock()).getInt();
    		onyxBarsID = config.getBlock("Blocks", "Onyx Bars", get.freeBlock()).getInt();
    		
        	//Item ID's
    		copperIngotID = config.getItem("Items", "Copper Ingot", get.freeItem()).getInt();
    		tinIngotID = config.getItem("Items", "Tin Ingot", get.freeItem()).getInt();
    		mythrilIngotID = config.getItem("Items", "Mythril Ingot", get.freeItem()).getInt();
    		adamantiumIngotID = config.getItem("Items", "Adamantium Ingot", get.freeItem()).getInt();
    		onyxGemID = config.getItem("Items", "Onyx Gem", get.freeItem()).getInt();
        	copperBucketID = config.getItem("Items", "Copper Bucket", get.freeItem()).getInt();
        	copperBucketWaterID = config.getItem("Items", "Copper Bucket Water", get.freeItem()).getInt();
        	mythrilRodID = config.getItem("Items", "Mythril Rod", get.freeItem()).getInt();
        	onyxRodID = config.getItem("Items", "Onyx Rod", get.freeItem()).getInt();
        	copperDoorItemID = config.getItem("Items", "Copper Door Item", get.freeItem()).getInt();
        	onyxDoorItemID = config.getItem("Items", "Onyx Door Item", get.freeItem()).getInt();
    		
        	//Tool ID's
        	copperPickID = config.getItem("Tools", "Copper Pickaxe", get.freeItem()).getInt();
        	copperAxeID = config.getItem("Tools", "Copper Axe", get.freeItem()).getInt();
        	copperShovelID = config.getItem("Tools", "Copper Shovel", get.freeItem()).getInt();
        	copperSwordID = config.getItem("Weapons", "Copper Sword", get.freeItem()).getInt();
        	copperHoeID = config.getItem("Tools", "Copper Hoe", get.freeItem()).getInt();
        	tinPickID = config.getItem("Tools", "Tin Pickaxe", get.freeItem()).getInt();
        	tinAxeID = config.getItem("Tools", "Tin Axe", get.freeItem()).getInt();
        	tinShovelID = config.getItem("Tools", "Tin Shovel", get.freeItem()).getInt();
        	tinSwordID = config.getItem("Weapons", "Tin Sword", get.freeItem()).getInt();
        	tinHoeID = config.getItem("Tools", "Tin Hoe", get.freeItem()).getInt();
        	mythrilPickID = config.getItem("Tools", "Mythril Pickaxe", get.freeItem()).getInt();
        	mythrilAxeID = config.getItem("Tools", "Mythril Axe", get.freeItem()).getInt();
        	mythrilShovelID = config.getItem("Tools", "Mythril Shovel", get.freeItem()).getInt();
        	mythrilSwordID = config.getItem("Weapons", "Mythril Sword", get.freeItem()).getInt();
        	mythrilHoeID = config.getItem("Tools", "Mythril Hoe", get.freeItem()).getInt();
        	adamantiumPickID = config.getItem("Tools", "Adamantium Pickaxe", get.freeItem()).getInt();
        	adamantiumAxeID = config.getItem("Tools", "Adamantium Axe", get.freeItem()).getInt();
        	adamantiumShovelID = config.getItem("Tools", "Adamantium Shovel", get.freeItem()).getInt();
        	adamantiumSwordID = config.getItem("Weapons", "Adamantium Sword", get.freeItem()).getInt();
        	adamantiumHoeID = config.getItem("Tools", "Adamantium Hoe", get.freeItem()).getInt();
        	onyxPickID = config.getItem("Tools", "Onyx Pickaxe", get.freeItem()).getInt();
        	onyxAxeID = config.getItem("Tools", "Onyx Axe", get.freeItem()).getInt();
        	onyxShovelID = config.getItem("Tools", "Onyx Shovel", get.freeItem()).getInt();
        	onyxSwordID = config.getItem("Weapons", "Onyx Sword", get.freeItem()).getInt();
        	onyxHoeID = config.getItem("Tools", "Onyx Hoe", get.freeItem()).getInt();
        	mythrilBowID = config.getItem("Weapons", "Mythril Bow", get.freeItem()).getInt();
        	onyxBowID = config.getItem("Weapons", "Onyx Bow", get.freeItem()).getInt();
        	tinShearsID = config.getItem("Tools", "Tin Shears", get.freeItem()).getInt();
        	adamantiumShearsID = config.getItem("Tools", "Adamantium Shears", get.freeItem()).getInt();
        	onyxShearsID = config.getItem("Tools", "Onyx Shears", get.freeItem()).getInt();
    		
        	//Armor ID's
        	copperHelmID = config.getItem("Armor", "Copper Helmet", get.freeItem()).getInt();
        	copperChestID = config.getItem("Armor", "Copper Chestplate", get.freeItem()).getInt();
        	copperLegsID = config.getItem("Armor", "Copper Leggings", get.freeItem()).getInt();
        	copperBootsID = config.getItem("Armor", "Copper Boots", get.freeItem()).getInt();
        	tinHelmID = config.getItem("Armor", "Tin Helmet", get.freeItem()).getInt();
        	tinChestID = config.getItem("Armor", "Tin Chestplate", get.freeItem()).getInt();
        	tinLegsID = config.getItem("Armor", "Tin Leggings", get.freeItem()).getInt();
        	tinBootsID = config.getItem("Armor", "Tin Boots", get.freeItem()).getInt();
        	mythrilHelmID = config.getItem("Armor", "Mythril Helmet", get.freeItem()).getInt();
        	mythrilChestID = config.getItem("Armor", "Mythril Chestplate", get.freeItem()).getInt();
        	mythrilLegsID = config.getItem("Armor", "Mythril Leggings", get.freeItem()).getInt();
        	mythrilBootsID = config.getItem("Armor", "Mythril Boots", get.freeItem()).getInt();
        	adamantiumHelmID = config.getItem("Armor", "Adamantium Helmet", get.freeItem()).getInt();
        	adamantiumChestID = config.getItem("Armor", "Adamantium Chestplate", get.freeItem()).getInt();
        	adamantiumLegsID = config.getItem("Armor", "Adamantium Leggings", get.freeItem()).getInt();
        	adamantiumBootsID = config.getItem("Armor", "Adamantium Boots", get.freeItem()).getInt();
        	onyxHelmID = config.getItem("Armor", "Onyx Helmet", get.freeItem()).getInt();
        	onyxChestID = config.getItem("Armor", "Onyx Chestplate", get.freeItem()).getInt();
        	onyxLegsID = config.getItem("Armor", "Onyx Leggings", get.freeItem()).getInt();
        	onyxBootsID = config.getItem("Armor", "Onyx Boots", get.freeItem()).getInt();
    		
        	//Achievement ID's
    		simpleOresAchID = config.get("Achievements", "SimpleOres Achievement", 5000).getInt();
    		adamantiumAchID = config.get("Achievements", "Adamantium Achievement", 5001).getInt();
    		onyxAchID = config.get("Achievements", "Onyx Achievement", 5002).getInt();
    		ironPickAchID = config.get("Achievements", "Iron Pick Achievement", 5003).getInt();
    		adamantiumPickAchID = config.get("Achievements", "Adamantium Pick Achievement", 5004).getInt();
    		onyxPickAchID = config.get("Achievements", "Onyx Pick Achievement", 5005).getInt();
    		mythrilBowAchID = config.get("Achievements", "Mythril Bow Achievement", 5006).getInt();
    		onyxBowAchID = config.get("Achievements", "Onyx Bow Achievement", 5007).getInt();
    		
    		LogHelper.verboseInfo("Config file loaded successfully.");
    	}
    	
    	catch (Exception e) 
    	{
    		LogHelper.severe("Failed to load the config.");
    	}
    	
    	finally 
    	{
    		config.save();
    	}
    }
	
	//Block ID's
	public static int copperOreID, tinOreID, mythrilOreID, adamantiumOreID, onyxOreID;
	public static int copperBlockID, tinBlockID, mythrilBlockID, adamantiumBlockID, onyxBlockID;
	public static int mythrilFurnaceID, mythrilFurnaceOnID, onyxFurnaceID, onyxFurnaceOnID;
	public static int copperBarsID, tinBarsID, mythrilBarsID, adamantiumBarsID, onyxBarsID;
	public static int copperDoorID, onyxDoorID;
	
	//Item ID's
	public static int copperIngotID, tinIngotID, mythrilIngotID, adamantiumIngotID, onyxGemID;
    public static int copperBucketID, copperBucketWaterID;
    public static int mythrilRodID, onyxRodID;    
    public static int copperDoorItemID, onyxDoorItemID;
	
	//Tool ID's
    public static int copperPickID, tinPickID, mythrilPickID, adamantiumPickID, onyxPickID;
    public static int copperAxeID, tinAxeID, mythrilAxeID, adamantiumAxeID, onyxAxeID;
    public static int copperShovelID, tinShovelID, mythrilShovelID, adamantiumShovelID, onyxShovelID;
    public static int copperSwordID, tinSwordID, mythrilSwordID, adamantiumSwordID, onyxSwordID;
    public static int copperHoeID, tinHoeID, mythrilHoeID, adamantiumHoeID, onyxHoeID;
    public static int mythrilBowID, onyxBowID;
    public static int tinShearsID, adamantiumShearsID, onyxShearsID;
	
	//Armor ID's
    public static int copperHelmID, tinHelmID, mythrilHelmID, adamantiumHelmID, onyxHelmID;
    public static int copperChestID, tinChestID, mythrilChestID, adamantiumChestID, onyxChestID;
    public static int copperLegsID, tinLegsID, mythrilLegsID, adamantiumLegsID, onyxLegsID;
    public static int copperBootsID, tinBootsID, mythrilBootsID, adamantiumBootsID, onyxBootsID;
	
	//Achievement ID's
	public static int simpleOresAchID, adamantiumAchID, onyxAchID;
	public static int ironPickAchID, adamantiumPickAchID, onyxPickAchID;
	public static int mythrilBowAchID, onyxBowAchID;
}
