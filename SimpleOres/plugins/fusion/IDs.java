package SimpleOres.plugins.fusion;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class IDs 
{
	/**
	 * Creating the config int's. Fairly obvious. 
	 */
//======================================= CREATION ======================================================= 	
	//Block ID's
	public static int bronzeBlockID;
	public static int thyriumBlockID;
	public static int sinisiteBlockID;
	public static int fusionFurnaceID;
	public static int fusionFurnaceOnID;	
	
	//Item ID's
	public static int bronzeIngotID;
    public static int sinisiteIngotID;
    public static int thyriumIngotID;
    public static int thyriumRodID;
    public static int sinisiteRodID;
    public static int smallBronzeChunkID;
    public static int mediumBronzeChunkID;
    public static int largeBronzeChunkID;
    public static int smallThyriumChunkID;
    public static int mediumThyriumChunkID;
    public static int largeThyriumChunkID;
    public static int smallSinisiteChunkID;
    public static int mediumSinisiteChunkID;
    public static int largeSinisiteChunkID;
    
	//Tool ID's
    public static int bronzePickID;
    public static int bronzeAxeID;
    public static int bronzeShovelID;
    public static int bronzeSwordID;
    public static int bronzeHoeID;
    public static int thyriumPickID;
    public static int thyriumAxeID;
    public static int thyriumShovelID;
    public static int thyriumSwordID;
    public static int thyriumHoeID;
    public static int sinisitePickID;
    public static int sinisiteAxeID;
    public static int sinisiteShovelID;
    public static int sinisiteSwordID;
    public static int sinisiteHoeID;
    public static int thyriumBowID;
    public static int sinisiteBowID;
    
	//Armor ID's
    public static int bronzeHelmID;
    public static int bronzeChestID;
    public static int bronzeLegsID;
    public static int bronzeBootsID;
    public static int thyriumHelmID;
    public static int thyriumChestID;
    public static int thyriumLegsID;
    public static int thyriumBootsID;
    public static int sinisiteHelmID;
    public static int sinisiteChestID;
    public static int sinisiteLegsID;
    public static int sinisiteBootsID;
    
	//Achievement ID's
	public static int fusionAchID;
	public static int bronzeAchID;
	
	/**
	 * The method that loads/creates the configuration file. The ID's can be changed, and their defaults are shown. This is called by the main SimpleOresFusion class.
	 */
	public static void doConfig(FMLPreInitializationEvent event)
    {
		/**
		 * Creating the config file. installDir is the 'config' file within .minecraft. configDir adds a "SimpleOres Configuration/Addons" folder within there.
		 */
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres Configuration/Plugins");
    	Configuration config = new Configuration(new File(configDir, "FusionIDs.cfg"));
    	
    	try 
    	{
    		config.load();
    		
    		//Block ID's
    		bronzeBlockID = config.getBlock("Blocks", "Bronze Block", 500).getInt();
    		thyriumBlockID = config.getBlock("Blocks", "Thyrium Block", 501).getInt();
    		sinisiteBlockID = config.getBlock("Blocks", "Sinisite Block", 502).getInt();
    		fusionFurnaceID = config.getBlock("Blocks", "Fusion Furnace", 507).getInt();
    		fusionFurnaceOnID = config.getBlock("Blocks", "Fusion Furnace On", 508).getInt();
    		
        	//Item ID's
    		bronzeIngotID = config.getItem("Items", "Bronze Ingot", 5005).getInt();
        	thyriumIngotID = config.getItem("Items", "Thyrium Ingot", 5006).getInt();
        	sinisiteIngotID = config.getItem("Items", "Sinisite Ingot", 5007).getInt();
        	thyriumRodID = config.getItem("Items", "Thyrium Rod", 5012).getInt();
        	sinisiteRodID = config.getItem("Items", "Sinisite Rod", 5013).getInt();
        	smallBronzeChunkID = config.getItem("Items", "Bronze Chunk Small", 5014).getInt();
        	mediumBronzeChunkID = config.getItem("Items", "Bronze Chunk Medium ", 5015).getInt();
        	largeBronzeChunkID = config.getItem("Items", "Bronze Chunk Large ", 5016).getInt();
        	smallThyriumChunkID = config.getItem("Items", "Thyrium Chunk Small", 5017).getInt();
        	mediumThyriumChunkID = config.getItem("Items", "Thyrium Chunk Medium ", 5018).getInt();
        	largeThyriumChunkID = config.getItem("Items", "Thyrium Chunk Large ", 5019).getInt();
        	smallSinisiteChunkID = config.getItem("Items", "Sinisite Chunk Small", 5020).getInt();
        	mediumSinisiteChunkID = config.getItem("Items", "Sinisite Chunk Medium ", 5021).getInt();
        	largeSinisiteChunkID = config.getItem("Items", "Sinisite Chunk Large ", 5022).getInt();
        	
        	//Tool ID's
        	bronzePickID = config.getItem("Tools", "Bronze Pickaxe", 5125).getInt();
        	bronzeAxeID = config.getItem("Tools", "Bronze Axe", 5126).getInt();
        	bronzeShovelID = config.getItem("Tools", "Bronze Shovel", 5127).getInt();
        	bronzeSwordID = config.getItem("Weapons", "Bronze Sword", 5128).getInt();
        	bronzeHoeID = config.getItem("Tools", "Bronze Hoe", 5129).getInt();
        	thyriumPickID = config.getItem("Tools", "Thyrium Pickaxe", 5130).getInt();
        	thyriumAxeID = config.getItem("Tools", "Thyrium Axe", 5131).getInt();
        	thyriumShovelID = config.getItem("Tools", "Thyrium Shovel", 5132).getInt();
        	thyriumSwordID = config.getItem("Weapons", "Thyrium Sword", 5133).getInt();
        	thyriumHoeID = config.getItem("Tools", "Thyrium Hoe", 5134).getInt();
        	sinisitePickID = config.getItem("Tools", "Sinisite Pickaxe", 5135).getInt();
        	sinisiteAxeID = config.getItem("Tools", "Sinisite Axe", 5136).getInt();
        	sinisiteShovelID = config.getItem("Tools", "Sinsisite Shovel", 5137).getInt();
        	sinisiteSwordID = config.getItem("Weapons", "Sinisite Sword", 5138).getInt();
        	sinisiteHoeID = config.getItem("Tools", "Sinisite Hoe", 5139).getInt();
        	thyriumBowID = config.getItem("Weapons", "Thyrium Bow", 5142).getInt();
        	sinisiteBowID = config.getItem("Weapons", "Sinisite Bow", 5143).getInt();
        	
        	//Armor ID's
        	bronzeHelmID = config.getItem("Armor", "Bronze Helmet", 5220).getInt();
        	bronzeChestID = config.getItem("Armor", "Bronze Chestplate", 5221).getInt();
        	bronzeLegsID = config.getItem("Armor", "Bronze Leggings", 5222).getInt();
        	bronzeBootsID = config.getItem("Armor", "Bronze Boots", 5223).getInt();
        	thyriumHelmID = config.getItem("Armor", "Thyrium Helmet", 5224).getInt();
        	thyriumChestID = config.getItem("Armor", "Thyrium Chestplate", 5225).getInt();
        	thyriumLegsID = config.getItem("Armor", "Thyrium Leggings", 5226).getInt();
        	thyriumBootsID = config.getItem("Armor", "Thyrium Boots", 5227).getInt();
        	sinisiteHelmID = config.getItem("Armor", "Sinisite Helmet", 5228).getInt();
        	sinisiteChestID = config.getItem("Armor", "Sinisite Chestplate", 5229).getInt();
        	sinisiteLegsID = config.getItem("Armor", "Sinisite Leggings", 5230).getInt();
        	sinisiteBootsID = config.getItem("Armor", "Sinisite Boots", 5231).getInt();
        	
        	//Achievement ID's
        	fusionAchID = config.get("Achievements", "Fusion Furnace Achievement", 5008).getInt();
    		bronzeAchID = config.get("Achievements", "Bronze Achievement", 5009).getInt();        	
    	}
    	
    	catch (Exception e) 
    	{
    		FMLLog.log(Level.SEVERE, e, "[SimpleOres] Error while trying to access the SimpleOres Fusion Plugin config file!");
    	}
    	
    	finally 
    	{
    		config.save();
    		System.out.println("[SimpleOres] Fusion Plugin config loaded.");
    	}
    }
}
