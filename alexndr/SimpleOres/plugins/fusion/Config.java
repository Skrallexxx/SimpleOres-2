package alexndr.SimpleOres.plugins.fusion;

import java.io.File;

import net.minecraftforge.common.Configuration;
import alexndr.SimpleOres.api.helpers.FreeIdHelper;
import alexndr.SimpleOres.api.helpers.LogHelper;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config 
{
	private static FreeIdHelper get;
	
	/**
	 * The method that loads/creates the configuration file. The ID's can be changed, and their defaults are shown. This is called by the main SimpleOresFusion class.
	 */
	public static void doConfig(FMLPreInitializationEvent event)
    {
		/**
		 * Creating the config file. installDir is the 'config' file within .minecraft. configDir adds a "SimpleOres Configuration/Addons" folder within there.
		 */
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres/Plugins");
		File configFile = new File(configDir, "Fusion Config.cfg");
    	Configuration config = new Configuration(configFile);
    	LogHelper.verboseInfo("Fusion Plugin: Loading config file at: '" + configFile.getAbsolutePath() + "'...");
		FreeIdHelper.compileIdList();
    	
    	try 
    	{
    		config.load();
    		
    		//Block ID's
    		bronzeBlockID = config.getBlock("Blocks", "Bronze Block", get.freeBlock()).getInt();
    		thyriumBlockID = config.getBlock("Blocks", "Thyrium Block", get.freeBlock()).getInt();
    		sinisiteBlockID = config.getBlock("Blocks", "Sinisite Block", get.freeBlock()).getInt();
    		fusionFurnaceID = config.getBlock("Blocks", "Fusion Furnace", get.freeBlock()).getInt();
    		fusionFurnaceOnID = config.getBlock("Blocks", "Fusion Furnace On", get.freeBlock()).getInt();
    		
        	//Item ID's
    		bronzeIngotID = config.getItem("Items", "Bronze Ingot", get.freeItem()).getInt();
        	thyriumIngotID = config.getItem("Items", "Thyrium Ingot", get.freeItem()).getInt();
        	sinisiteIngotID = config.getItem("Items", "Sinisite Ingot", get.freeItem()).getInt();
        	thyriumRodID = config.getItem("Items", "Thyrium Rod", get.freeItem()).getInt();
        	sinisiteRodID = config.getItem("Items", "Sinisite Rod", get.freeItem()).getInt();
        	smallBronzeChunkID = config.getItem("Items", "Bronze Chunk Small", get.freeItem()).getInt();
        	mediumBronzeChunkID = config.getItem("Items", "Bronze Chunk Medium ", get.freeItem()).getInt();
        	largeBronzeChunkID = config.getItem("Items", "Bronze Chunk Large ", get.freeItem()).getInt();
        	smallThyriumChunkID = config.getItem("Items", "Thyrium Chunk Small", get.freeItem()).getInt();
        	mediumThyriumChunkID = config.getItem("Items", "Thyrium Chunk Medium ", get.freeItem()).getInt();
        	largeThyriumChunkID = config.getItem("Items", "Thyrium Chunk Large ", get.freeItem()).getInt();
        	smallSinisiteChunkID = config.getItem("Items", "Sinisite Chunk Small", get.freeItem()).getInt();
        	mediumSinisiteChunkID = config.getItem("Items", "Sinisite Chunk Medium ", get.freeItem()).getInt();
        	largeSinisiteChunkID = config.getItem("Items", "Sinisite Chunk Large ", get.freeItem()).getInt();
        	
        	//Tool ID's
        	bronzePickID = config.getItem("Tools", "Bronze Pickaxe", get.freeItem()).getInt();
        	bronzeAxeID = config.getItem("Tools", "Bronze Axe", get.freeItem()).getInt();
        	bronzeShovelID = config.getItem("Tools", "Bronze Shovel", get.freeItem()).getInt();
        	bronzeSwordID = config.getItem("Weapons", "Bronze Sword", get.freeItem()).getInt();
        	bronzeHoeID = config.getItem("Tools", "Bronze Hoe", get.freeItem()).getInt();
        	thyriumPickID = config.getItem("Tools", "Thyrium Pickaxe", get.freeItem()).getInt();
        	thyriumAxeID = config.getItem("Tools", "Thyrium Axe", get.freeItem()).getInt();
        	thyriumShovelID = config.getItem("Tools", "Thyrium Shovel", get.freeItem()).getInt();
        	thyriumSwordID = config.getItem("Weapons", "Thyrium Sword", get.freeItem()).getInt();
        	thyriumHoeID = config.getItem("Tools", "Thyrium Hoe", get.freeItem()).getInt();
        	sinisitePickID = config.getItem("Tools", "Sinisite Pickaxe", get.freeItem()).getInt();
        	sinisiteAxeID = config.getItem("Tools", "Sinisite Axe", get.freeItem()).getInt();
        	sinisiteShovelID = config.getItem("Tools", "Sinsisite Shovel", get.freeItem()).getInt();
        	sinisiteSwordID = config.getItem("Weapons", "Sinisite Sword", get.freeItem()).getInt();
        	sinisiteHoeID = config.getItem("Tools", "Sinisite Hoe", get.freeItem()).getInt();
        	thyriumBowID = config.getItem("Weapons", "Thyrium Bow", get.freeItem()).getInt();
        	sinisiteBowID = config.getItem("Weapons", "Sinisite Bow", get.freeItem()).getInt();
        	
        	//Armor ID's
        	bronzeHelmID = config.getItem("Armor", "Bronze Helmet", get.freeItem()).getInt();
        	bronzeChestID = config.getItem("Armor", "Bronze Chestplate", get.freeItem()).getInt();
        	bronzeLegsID = config.getItem("Armor", "Bronze Leggings", get.freeItem()).getInt();
        	bronzeBootsID = config.getItem("Armor", "Bronze Boots", get.freeItem()).getInt();
        	thyriumHelmID = config.getItem("Armor", "Thyrium Helmet", get.freeItem()).getInt();
        	thyriumChestID = config.getItem("Armor", "Thyrium Chestplate", get.freeItem()).getInt();
        	thyriumLegsID = config.getItem("Armor", "Thyrium Leggings", get.freeItem()).getInt();
        	thyriumBootsID = config.getItem("Armor", "Thyrium Boots", get.freeItem()).getInt();
        	sinisiteHelmID = config.getItem("Armor", "Sinisite Helmet", get.freeItem()).getInt();
        	sinisiteChestID = config.getItem("Armor", "Sinisite Chestplate", get.freeItem()).getInt();
        	sinisiteLegsID = config.getItem("Armor", "Sinisite Leggings", get.freeItem()).getInt();
        	sinisiteBootsID = config.getItem("Armor", "Sinisite Boots", get.freeItem()).getInt();
        	
        	//Achievement ID's
        	fusionAchID = config.get("Achievements", "Fusion Furnace Achievement", 5008).getInt();
    		bronzeAchID = config.get("Achievements", "Bronze Achievement", 5009).getInt(); 
    		
    		LogHelper.verboseInfo("Fusion Plugin: Config file loaded successfully.");
    	}
    	
    	catch (Exception e) 
    	{
    		LogHelper.severe("Fusion Plugin: Failed to load the config.");
    	}
    	
    	finally 
    	{
    		config.save();
    	}
    }
	
	//Block ID's
	public static int bronzeBlockID, thyriumBlockID, sinisiteBlockID;
	public static int fusionFurnaceID, fusionFurnaceOnID;
	
	//Item ID's
	public static int bronzeIngotID, sinisiteIngotID, thyriumIngotID;
    public static int thyriumRodID, sinisiteRodID;
    public static int smallBronzeChunkID, smallThyriumChunkID, smallSinisiteChunkID;
    public static int mediumBronzeChunkID, mediumThyriumChunkID, mediumSinisiteChunkID;
    public static int largeBronzeChunkID, largeThyriumChunkID, largeSinisiteChunkID;
    
	//Tool ID's
    public static int bronzePickID, thyriumPickID, sinisitePickID;
    public static int bronzeAxeID, thyriumAxeID, sinisiteAxeID;
    public static int bronzeShovelID, thyriumShovelID, sinisiteShovelID;
    public static int bronzeSwordID, thyriumSwordID, sinisiteSwordID;
    public static int bronzeHoeID, thyriumHoeID, sinisiteHoeID;
    public static int thyriumBowID, sinisiteBowID;
    
	//Armor ID's
    public static int bronzeHelmID, thyriumHelmID, sinisiteHelmID;
    public static int bronzeChestID, thyriumChestID, sinisiteChestID;
    public static int bronzeLegsID, thyriumLegsID, sinisiteLegsID;
    public static int bronzeBootsID, thyriumBootsID, sinisiteBootsID;
    
	//Achievement ID's
	public static int fusionAchID, bronzeAchID;
}
