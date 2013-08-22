package SimpleOres.plugins.fusion;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Localisation 
{
	/**
	 * Creating the localisation strings. Fairly obvious.
	 */
//======================================= CREATION ======================================================= 	
	//Block Names
	public static String bronzeBlockName;
	public static String thyriumBlockName;
	public static String sinisiteBlockName;
	public static String fusionFurnaceName;
	public static String fusionFurnaceOnName;
	
	//Item Names
	public static String bronzeIngotName;
	public static String sinisiteIngotName;
	public static String thyriumIngotName;
	public static String thyriumRodName;
	public static String sinisiteRodName;
    public static String smallBronzeChunkName;
    public static String mediumBronzeChunkName;
    public static String largeBronzeChunkName;
    public static String smallThyriumChunkName;
    public static String mediumThyriumChunkName;
    public static String largeThyriumChunkName;
    public static String smallSinisiteChunkName;
    public static String mediumSinisiteChunkName;
    public static String largeSinisiteChunkName;
    
	//Tool Names
    public static String bronzePickName;
	public static String bronzeAxeName;
	public static String bronzeShovelName;
	public static String bronzeSwordName;
	public static String bronzeHoeName;
	public static String thyriumPickName;
	public static String thyriumAxeName;
	public static String thyriumShovelName;
	public static String thyriumSwordName;
	public static String thyriumHoeName;
	public static String sinisitePickName;
	public static String sinisiteAxeName;
	public static String sinisiteShovelName;
	public static String sinisiteSwordName;
	public static String sinisiteHoeName;
	public static String thyriumBowName;
	public static String sinisiteBowName;
	
	//Armor Names
	public static String bronzeHelmName;
	public static String bronzeChestName;
	public static String bronzeLegsName;
	public static String bronzeBootsName;
	public static String thyriumHelmName;
	public static String thyriumChestName;
	public static String thyriumLegsName;
	public static String thyriumBootsName;
	public static String sinisiteHelmName;
	public static String sinisiteChestName;
	public static String sinisiteLegsName;
	public static String sinisiteBootsName;
	
	//Achievements Names
	public static String fusionAchName;
	public static String bronzeAchName;
	
	//Achievement Descriptions
	public static String fusionAchDesc;
	public static String bronzeAchDesc;
	
	/**
	 * The method that loads/creates the localisation file. The names can be changed, and their defaults (English) are shown. This is called by the main SimpleOresFusion class.
	 */
	public static void doLocalisation(FMLPreInitializationEvent event)
	{
		/**
		 * Creating the localisation file. installDir is the 'config' file within .minecraft. configDir add a "SimpleOres Configuration/Plugins" folder within there.
		 */
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres Configuration/Plugins");
		Configuration localisation = new Configuration(new File(configDir, "FusionLocalisation.lang"));
	    
		try 
	    {
	    	localisation.load();
	    	
	    	//Block Names
	    	bronzeBlockName = localisation.get("Block Names", "BronzeBlockName", "Bronze Block").getString();
    		thyriumBlockName = localisation.get("Block Names", "ThyriumBlockName", "Thyrium Block").getString();
    		sinisiteBlockName = localisation.get("Block Names", "SinisiteBlockName", "Sinisite Block").getString();
    		fusionFurnaceName = localisation.get("Block Names", "FusionFurnaceName", "Fusion Furnace").getString();
    		fusionFurnaceOnName = localisation.get("Block Names", "FusionFurnaceOnName", "Fusion Furnace").getString();
    		
	    	//Item Names
    		bronzeIngotName = localisation.get("Item Names", "BronzeIngotName", "Bronze Ingot").getString();
	    	sinisiteIngotName = localisation.get("Item Names", "SinisiteIngotName", "Sinisite Ingot").getString();
	    	thyriumIngotName = localisation.get("Item Names", "ThyriumIngotName", "Thyrium Ingot").getString();
	    	thyriumRodName = localisation.get("Item Names", "ThyriumRodName", "Thyrium Rod").getString();
    		sinisiteRodName = localisation.get("Item Names", "SinisiteRodName", "Sinisite Rod").getString();
    		smallBronzeChunkName = localisation.get("Item Names", "BronzeChunkSmallName", "Small Bronze Chunk").getString();
    		mediumBronzeChunkName = localisation.get("Item Names", "BronzeChunkMediumName", "Medium Bronze Chunk").getString();
    		largeBronzeChunkName = localisation.get("Item Names", "BronzeChunkLargeName", "Large Bronze Chunk").getString();
    		smallThyriumChunkName = localisation.get("Item Names", "ThyriumChunkSmallName", "Small Thyrium Chunk").getString();
    		mediumThyriumChunkName = localisation.get("Item Names", "ThyriumChunkMediumName", "Medium Thyrium Chunk").getString();
    		largeThyriumChunkName = localisation.get("Item Names", "ThyriumChunkLargeName", "Large Thyrium Chunk").getString();
    		smallSinisiteChunkName = localisation.get("Item Names", "SinisiteChunkSmallName", "Small Sinisite Chunk").getString();
    		mediumSinisiteChunkName = localisation.get("Item Names", "SinisiteChunkMediumName", "Medium Sinisite Chunk").getString();
    		largeSinisiteChunkName = localisation.get("Item Names", "SinisiteChunkLargeName", "Large Sinisite Chunk").getString();
    		
	    	//Tool Names
    		bronzePickName = localisation.get("Tool Names", "BronzePickName", "Bronze Pickaxe").getString();
    		bronzeAxeName = localisation.get("Tool Names", "BronzeAxeName", "Bronze Axe").getString();
    		bronzeShovelName = localisation.get("Tool Names", "BronzeShovelName", "Bronze Shovel").getString();
    		bronzeSwordName = localisation.get("Weapon Names", "BronzeSwordName", "Bronze Sword").getString();
    		bronzeHoeName = localisation.get("Tool Names", "BronzeHoeName", "Bronze Hoe").getString();
    		thyriumPickName = localisation.get("Tool Names", "ThyriumPickName", "Thyrium Pickaxe").getString();
    		thyriumAxeName = localisation.get("Tool Names", "ThyriumAxeName", "Thyrium Axe").getString();
    		thyriumShovelName = localisation.get("Tool Names", "ThyriumShovelName", "Thyrium Shovel").getString();
    		thyriumSwordName = localisation.get("Weapon Names", "ThyriumSwordName", "Thyrium Sword").getString();
    		thyriumHoeName = localisation.get("Tool Names", "ThyriumHoeName", "Thyrium Hoe").getString();
    		sinisitePickName = localisation.get("Tool Names", "SinisitePickName", "Sinisite Pickaxe").getString();
    		sinisiteAxeName = localisation.get("Tool Names", "SinisiteAxeName", "Sinisite Axe").getString();
    		sinisiteShovelName = localisation.get("Tool Names", "SinisiteShovelName", "Sinisite Shovel").getString();
    		sinisiteSwordName = localisation.get("Weapon Names", "SinisiteSwordName", "Sinisite Sword").getString();
    		sinisiteHoeName = localisation.get("Tool Names", "SinisiteHoeName", "Sinisite Hoe").getString();
    		thyriumBowName = localisation.get("Weapon Names", "ThyriumBowName", "Thyrium Bow").getString();
    		sinisiteBowName = localisation.get("Weapon Names", "SinisiteBowName", "Sinisite Bow").getString();
    		
	    	//Armor Names
    		bronzeHelmName = localisation.get("Armor Names", "BronzeHelmName", "Bronze Helmet").getString();
    		bronzeChestName = localisation.get("Armor Names", "BronzeChestname", "Bronze Chestplate").getString();
    		bronzeLegsName = localisation.get("Armor Names", "BronzeLegsName", "Bronze Leggings").getString();
    		bronzeBootsName = localisation.get("Armor Names", "BronzeBootsName", "Bronze Boots").getString();
    		thyriumHelmName = localisation.get("Armor Names", "ThyriumHelmName", "Thyrium Helmet").getString();
    		thyriumChestName = localisation.get("Armor Names", "ThyriumChestname", "Thyrium Chestplate").getString();
    		thyriumLegsName = localisation.get("Armor Names", "ThyriumLegsName", "Thyrium Leggings").getString();
    		thyriumBootsName = localisation.get("Armor Names", "ThyriumBootsName", "Thyrium Boots").getString();
    		sinisiteHelmName = localisation.get("Armor Names", "SinisiteHelmName", "Sinisite Helmet").getString();
    		sinisiteChestName = localisation.get("Armor Names", "SinisiteChestname", "Sinisite Chestplate").getString();
    		sinisiteLegsName = localisation.get("Armor Names", "SinisiteLegsName", "Sinisite Leggings").getString();
    		sinisiteBootsName = localisation.get("Armor Names", "SinisiteBootsName", "Sinisite Boots").getString();
    		
    		//Achievement Names
    		fusionAchName = localisation.get("Achievement Names", "FusionFurnaceAchievement", "Coalescence").getString();
    		bronzeAchName = localisation.get("Achievement Names", "BronzeAchievement", "My First Fusion").getString();
    		
    		//Achievement Descriptions
    		fusionAchDesc = localisation.get("Achievement Descriptions", "FusionFurnaceAchievement", "Craft a Fusion Furnace to open up new possibilities.").getString();
    		bronzeAchDesc = localisation.get("Achievement Descriptions", "BronzeAchievement", "Craft you first alloy, a Bronze Ingot.").getString();   	
    		
	    }
		
		catch (Exception e) 
    	{
    		FMLLog.log(Level.SEVERE, e, "[SimpleOres] Error while trying to access the SimpleOres Fusion Plugin localisation file!");
    	}
		
    	finally 
    	{
    		localisation.save();
	    	System.out.println("[SimpleOres] Fusion Plugin localisation loaded."); 
    	}
	}
}
