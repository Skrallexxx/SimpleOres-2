package SimpleOres.core;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config 
{
	/**
	 * Creating the config int's. Fairly obvious. 
	 */
//======================================= CREATION ======================================================= 	
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
    	
    	try 
    	{
    		config.load();
    		
    		//Block ID's
    		copperOreID = config.getBlock("Blocks", "Copper Ore", 490).getInt();
    		copperBlockID = config.getBlock("Blocks", "Copper Block", 491).getInt();
    		tinOreID = config.getBlock("Blocks", "Tin Ore", 492).getInt();
    		tinBlockID = config.getBlock("Blocks", "Tin Block", 493).getInt();
    		mythrilOreID = config.getBlock("Blocks", "Mythril Ore", 494).getInt();
    		mythrilBlockID = config.getBlock("Blocks", "Mythril Block", 495).getInt();
    		adamantiumOreID = config.getBlock("Blocks", "Adamantium Ore", 496).getInt();
    		adamantiumBlockID = config.getBlock("Blocks", "Adamantium Block", 497).getInt();
    		onyxOreID = config.getBlock("Blocks", "Onyx Ore", 498).getInt();
    		onyxBlockID = config.getBlock("Blocks", "Onyx Block", 499).getInt();
    		mythrilFurnaceID = config.getBlock("Blocks", "Mythril Furnace", 503).getInt();
        	mythrilFurnaceOnID = config.getBlock("Blocks", "Mythril Furnace On", 504).getInt();
        	onyxFurnaceID = config.getBlock("Blocks", "Onyx Furnace", 505).getInt();
        	onyxFurnaceOnID = config.getBlock("Blocks", "Onyx Furnace On", 506).getInt(); 		
    		copperDoorID = config.getBlock("Blocks", "Copper Door", 509).getInt();
    		onyxDoorID = config.getBlock("Blocks", "Onyx Door", 510).getInt();
    		copperBarsID = config.getBlock("Blocks", "Copper Bars", 511).getInt();
    		tinBarsID = config.getBlock("Blocks", "Tin Bars", 512).getInt();
    		mythrilBarsID = config.getBlock("Blocks", "Mythril Bars", 513).getInt();
    		adamantiumBarsID = config.getBlock("Blocks", "Adamantium Bars", 514).getInt();
    		onyxBarsID = config.getBlock("Blocks", "Onyx Bars", 515).getInt();
    		
        	//Item ID's
    		copperIngotID = config.getItem("Items", "Copper Ingot", 5000).getInt();
    		tinIngotID = config.getItem("Items", "Tin Ingot", 5001).getInt();
    		mythrilIngotID = config.getItem("Items", "Mythril Ingot", 5002).getInt();
    		adamantiumIngotID = config.getItem("Items", "Adamantium Ingot", 5003).getInt();
    		onyxGemID = config.getItem("Items", "Onyx Gem", 5004).getInt();
        	copperBucketID = config.getItem("Items", "Copper Bucket", 5008).getInt();
        	copperBucketWaterID = config.getItem("Items", "Copper Bucket Water", 5009).getInt();
        	mythrilRodID = config.getItem("Items", "Mythril Rod", 5010).getInt();
        	onyxRodID = config.getItem("Items", "Onyx Rod", 5011).getInt();
        	copperDoorItemID = config.getItem("Items", "Copper Door Item", 5023).getInt();
        	onyxDoorItemID = config.getItem("Items", "Onyx Door Item", 5024).getInt();
    		
        	//Tool ID's
        	copperPickID = config.getItem("Tools", "Copper Pickaxe", 5100).getInt();
        	copperAxeID = config.getItem("Tools", "Copper Axe", 5101).getInt();
        	copperShovelID = config.getItem("Tools", "Copper Shovel", 5102).getInt();
        	copperSwordID = config.getItem("Weapons", "Copper Sword", 5103).getInt();
        	copperHoeID = config.getItem("Tools", "Copper Hoe", 5104).getInt();
        	tinPickID = config.getItem("Tools", "Tin Pickaxe", 5105).getInt();
        	tinAxeID = config.getItem("Tools", "Tin Axe", 5106).getInt();
        	tinShovelID = config.getItem("Tools", "Tin Shovel", 5107).getInt();
        	tinSwordID = config.getItem("Weapons", "Tin Sword", 5108).getInt();
        	tinHoeID = config.getItem("Tools", "Tin Hoe", 5109).getInt();
        	mythrilPickID = config.getItem("Tools", "Mythril Pickaxe", 5110).getInt();
        	mythrilAxeID = config.getItem("Tools", "Mythril Axe", 5111).getInt();
        	mythrilShovelID = config.getItem("Tools", "Mythril Shovel", 5112).getInt();
        	mythrilSwordID = config.getItem("Weapons", "Mythril Sword", 5113).getInt();
        	mythrilHoeID = config.getItem("Tools", "Mythril Hoe", 5114).getInt();
        	adamantiumPickID = config.getItem("Tools", "Adamantium Pickaxe", 5115).getInt();
        	adamantiumAxeID = config.getItem("Tools", "Adamantium Axe", 5116).getInt();
        	adamantiumShovelID = config.getItem("Tools", "Adamantium Shovel", 5117).getInt();
        	adamantiumSwordID = config.getItem("Weapons", "Adamantium Sword", 5118).getInt();
        	adamantiumHoeID = config.getItem("Tools", "Adamantium Hoe", 5119).getInt();
        	onyxPickID = config.getItem("Tools", "Onyx Pickaxe", 5120).getInt();
        	onyxAxeID = config.getItem("Tools", "Onyx Axe", 5121).getInt();
        	onyxShovelID = config.getItem("Tools", "Onyx Shovel", 5122).getInt();
        	onyxSwordID = config.getItem("Weapons", "Onyx Sword", 5123).getInt();
        	onyxHoeID = config.getItem("Tools", "Onyx Hoe", 5124).getInt();
        	mythrilBowID = config.getItem("Weapons", "Mythril Bow", 5140).getInt();
        	onyxBowID = config.getItem("Weapons", "Onyx Bow", 5141).getInt();
        	tinShearsID = config.getItem("Tools", "Tin Shears", 5144).getInt();
        	adamantiumShearsID = config.getItem("Tools", "Adamantium Shears", 5145).getInt();
        	onyxShearsID = config.getItem("Tools", "Onyx Shears", 5146).getInt();
    		
        	//Armor ID's
        	copperHelmID = config.getItem("Armor", "Copper Helmet", 5200).getInt();
        	copperChestID = config.getItem("Armor", "Copper Chestplate", 5201).getInt();
        	copperLegsID = config.getItem("Armor", "Copper Leggings", 5202).getInt();
        	copperBootsID = config.getItem("Armor", "Copper Boots", 5203).getInt();
        	tinHelmID = config.getItem("Armor", "Tin Helmet", 5204).getInt();
        	tinChestID = config.getItem("Armor", "Tin Chestplate", 5205).getInt();
        	tinLegsID = config.getItem("Armor", "Tin Leggings", 5206).getInt();
        	tinBootsID = config.getItem("Armor", "Tin Boots", 5207).getInt();
        	mythrilHelmID = config.getItem("Armor", "Mythril Helmet", 5208).getInt();
        	mythrilChestID = config.getItem("Armor", "Mythril Chestplate", 5209).getInt();
        	mythrilLegsID = config.getItem("Armor", "Mythril Leggings", 5210).getInt();
        	mythrilBootsID = config.getItem("Armor", "Mythril Boots", 5211).getInt();
        	adamantiumHelmID = config.getItem("Armor", "Adamantium Helmet", 5212).getInt();
        	adamantiumChestID = config.getItem("Armor", "Adamantium Chestplate", 5213).getInt();
        	adamantiumLegsID = config.getItem("Armor", "Adamantium Leggings", 5214).getInt();
        	adamantiumBootsID = config.getItem("Armor", "Adamantium Boots", 5215).getInt();
        	onyxHelmID = config.getItem("Armor", "Onyx Helmet", 5216).getInt();
        	onyxChestID = config.getItem("Armor", "Onyx Chestplate", 5217).getInt();
        	onyxLegsID = config.getItem("Armor", "Onyx Leggings", 5218).getInt();
        	onyxBootsID = config.getItem("Armor", "Onyx Boots", 5219).getInt();
    		
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
    		FMLLog.log(Level.SEVERE, e, "[SimpleOres] Error while trying to access the SimpleOres config file!");
    	}
    	
    	finally 
    	{
    		config.save();
    		System.out.println("[SimpleOres] Config loaded.");
    	}
    }
}
