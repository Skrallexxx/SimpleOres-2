package alexndr.SimpleOres.core.conf;

import java.io.File;

import alexndr.SimpleOres.api.HandlerGetFreeIds;
import alexndr.SimpleOres.api.HandlerLogger;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config 
{	
	private static HandlerGetFreeIds get;
	
	/**
	 * The method that loads/creates the configuration file. The ID's can be changed, and their defaults are shown. This is called by the main SimpleOres class.
	 */
	public static void doConfig(FMLPreInitializationEvent event)
    {
		/**
		 * Creating the config file. installDir is the 'config' file within .minecraft. configDir add a "SimpleOres Configuration" folder within there.
		 */
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres Configuration");
    	Configuration config = new Configuration(new File(configDir, "SimpleOresIDs.cfg"));
    	
		HandlerGetFreeIds.compileIdList();
    	
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
    	}
    	
    	catch (Exception e) 
    	{
    		HandlerLogger.logSevere("Failed to load the config.");
    	}
    	
    	finally 
    	{
    		config.save();
    	}
    }
	
	//Block ID's
	public static int copperOreID;
	public static int copperBlockID;
	public static int tinOreID;
	public static int tinBlockID;
	public static int mythrilOreID;
	public static int mythrilBlockID;
	public static int adamantiumOreID;
	public static int adamantiumBlockID;
	public static int onyxOreID;
	public static int onyxBlockID;
	public static int mythrilFurnaceID;
	public static int mythrilFurnaceOnID;
	public static int onyxFurnaceID;
	public static int onyxFurnaceOnID;	
	public static int copperDoorID;
	public static int onyxDoorID;
	public static int copperBarsID;
	public static int tinBarsID;
	public static int mythrilBarsID;
	public static int adamantiumBarsID;
	public static int onyxBarsID;
	
	//Item ID's
	public static int copperIngotID;
	public static int tinIngotID;
	public static int mythrilIngotID;
	public static int adamantiumIngotID;
	public static int onyxGemID;
    public static int copperBucketID;
    public static int copperBucketWaterID;
    public static int mythrilRodID;
    public static int onyxRodID;    
    public static int copperDoorItemID;
    public static int onyxDoorItemID;
	
	//Tool ID's
    public static int copperPickID;
    public static int copperAxeID;
    public static int copperShovelID;
    public static int copperSwordID;
    public static int copperHoeID;
    public static int tinPickID;
    public static int tinAxeID;
    public static int tinShovelID;
    public static int tinSwordID;
    public static int tinHoeID;
    public static int mythrilPickID;
    public static int mythrilAxeID;
    public static int mythrilShovelID;
    public static int mythrilSwordID;
    public static int mythrilHoeID;
    public static int adamantiumPickID;
    public static int adamantiumAxeID;
    public static int adamantiumShovelID;
    public static int adamantiumSwordID;
    public static int adamantiumHoeID;
    public static int onyxPickID;
    public static int onyxAxeID;
    public static int onyxShovelID;
    public static int onyxSwordID;
    public static int onyxHoeID;
    public static int tinBowID;
    public static int mythrilBowID;
    public static int onyxBowID;
    public static int tinShearsID;
    public static int adamantiumShearsID;
    public static int onyxShearsID;
	
	//Armor ID's
    public static int copperHelmID;
    public static int copperChestID;
    public static int copperLegsID;
    public static int copperBootsID;
    public static int tinHelmID;
    public static int tinChestID;
    public static int tinLegsID;
    public static int tinBootsID;
    public static int mythrilHelmID;
    public static int mythrilChestID;
    public static int mythrilLegsID;
    public static int mythrilBootsID;
    public static int adamantiumHelmID;
    public static int adamantiumChestID;
    public static int adamantiumLegsID;
    public static int adamantiumBootsID;
    public static int onyxHelmID;
    public static int onyxChestID;
    public static int onyxLegsID;
    public static int onyxBootsID;
	
	//Achievement ID's
	public static int simpleOresAchID;
	public static int adamantiumAchID;
	public static int onyxAchID;
	public static int ironPickAchID;
	public static int adamantiumPickAchID;
	public static int onyxPickAchID;
	public static int mythrilBowAchID;
	public static int onyxBowAchID;
}
