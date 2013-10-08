package SimpleOres.core;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Localisation
{
	/**
	 * Linking to the classes for easier reference.
	 */
	public static SimpleOres mod;
	public static Achievements achievements;
	public static Armor armor;
	public static Blocks blocks;
	public static Config config;
	public static Items items;
	public static Localisation local;
	public static Recipes recipes;
	public static Tools tools;
	
	/**
	 * Creating the localisation strings. Fairly obvious.
	 */
//======================================= CREATION ======================================================= 	
	//Block Names
	public static String copperOreName;
	public static String copperBlockName;
	public static String tinOreName;
	public static String tinBlockName;
	public static String mythrilOreName;
	public static String mythrilBlockName;
	public static String adamantiumOreName;
	public static String adamantiumBlockName;
	public static String onyxOreName;
	public static String onyxBlockName;
	public static String mythrilFurnaceName;
	public static String mythrilFurnaceOnName;
	public static String onyxFurnaceName;
	public static String onyxFurnaceOnName;	
	public static String copperDoorName;
	public static String onyxDoorName;
	public static String copperBarsName;
	public static String tinBarsName;
	public static String mythrilBarsName;
	public static String adamantiumBarsName;
	public static String onyxBarsName;
	
	//Item Names
	public static String copperIngotName;
	public static String tinIngotName;
	public static String mythrilIngotName;
	public static String adamantiumIngotName;
	public static String onyxGemName;
	public static String copperBucketName;
	public static String copperBucketWaterName;
	public static String mythrilRodName;
	public static String onyxRodName;
	public static String thyriumRodName;
	public static String sinisiteRodName;
    public static String copperDoorItemName;
    public static String onyxDoorItemName;
	
	//Tool Names
	public static String copperPickName;
	public static String copperAxeName;
	public static String copperShovelName;
	public static String copperSwordName;
	public static String copperHoeName;
	public static String tinPickName;
	public static String tinAxeName;
	public static String tinShovelName;
	public static String tinSwordName;
	public static String tinHoeName;
	public static String mythrilPickName;
	public static String mythrilAxeName;
	public static String mythrilShovelName;
	public static String mythrilSwordName;
	public static String mythrilHoeName;
	public static String adamantiumPickName;
	public static String adamantiumAxeName;
	public static String adamantiumShovelName;
	public static String adamantiumSwordName;
	public static String adamantiumHoeName;
	public static String onyxPickName;
	public static String onyxAxeName;
	public static String onyxShovelName;
	public static String onyxSwordName;
	public static String onyxHoeName;
	public static String mythrilBowName;
	public static String onyxBowName;
	public static String tinShearsName;
	public static String adamantiumShearsName;
	public static String onyxShearsName;
	
	//Armor Names
	public static String copperHelmName;
	public static String copperChestName;
	public static String copperLegsName;
	public static String copperBootsName;
	public static String tinHelmName;
	public static String tinChestName;
	public static String tinLegsName;
	public static String tinBootsName;
	public static String mythrilHelmName;
	public static String mythrilChestName;
	public static String mythrilLegsName;
	public static String mythrilBootsName;
	public static String adamantiumHelmName;
	public static String adamantiumChestName;
	public static String adamantiumLegsName;
	public static String adamantiumBootsName;
	public static String onyxHelmName;
	public static String onyxChestName;
	public static String onyxLegsName;
	public static String onyxBootsName;
	
	//Bow Tooltips
	public static String damageTooltip;
	public static String flameTooltip;
	public static String knockbackTooltip;
	public static String zoomTooltip;
	public static String efficiencyTooltip;
	
	//Achievements Names
	public static String simpleOresAchName;
	public static String adamantiumAchName;
	public static String onyxAchName;
	public static String ironPickAchName;
	public static String adamantiumPickAchName;
	public static String onyxPickAchName;
	public static String mythrilBowAchName;
	public static String onyxBowAchName;
	
	//Achievement Descriptions
	public static String simpleOresAchDesc;
	public static String adamantiumAchDesc;
	public static String onyxAchDesc;
	public static String ironPickAchDesc;
	public static String adamantiumPickAchDesc;
	public static String onyxPickAchDesc;
	public static String mythrilBowAchDesc;
	public static String onyxBowAchDesc;
	
	/**
	 * The method that loads/creates the localisation file. The names can be changed, and their defaults (English) are shown. This is called by the main SimpleOres class.
	 */
	public static void doLocalisation(FMLPreInitializationEvent event)
	{
		/**
		 * Creating the localisation file. installDir is the 'config' file within .minecraft. configDir add a "SimpleOres Configuration" folder within there.
		 */
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres Configuration");
		Configuration localisation = new Configuration(new File(configDir, "SimpleOresLocalisation.lang"));
	    
		try 
	    {
	    	localisation.load();
	    	
	    	//Block Names
	    	copperOreName = localisation.get("Block Names", "CopperOreName", "Copper Ore").getString();
	    	copperBlockName = localisation.get("Block Names", "CopperBlockName", "Copper Block").getString();
	    	tinOreName = localisation.get("Block Names", "TinOreName", "Tin Ore").getString();
	    	tinBlockName = localisation.get("Block Names", "TinBlockName", "Tin Block").getString();
	    	mythrilOreName = localisation.get("Block Names", "MythrilOreName", "Mythril Ore").getString();
    		mythrilBlockName = localisation.get("Block Names", "MythrilBlockName", "Mythril Block").getString();
    		adamantiumOreName = localisation.get("Block Names", "AdamantiumOreName", "Adamantium Ore").getString();
    		adamantiumBlockName = localisation.get("Block Names", "AdamantiumBlockName", "Adamantium Block").getString();
    		onyxOreName = localisation.get("Block Names", "OnyxOreName", "Onyx Ore").getString();
    		onyxBlockName = localisation.get("Block Names", "OnyxBlockName", "Onyx Block").getString();
    		mythrilFurnaceName = localisation.get("Block Names", "MythrilFurnaceName", "Mythril Furnace").getString();
    		mythrilFurnaceOnName = localisation.get("Block Names", "MythrilFurnaceOnName", "Mythril Furnace").getString();
    		onyxFurnaceName = localisation.get("Block Names", "OnyxFurnaceName", "Onyx Furnace").getString();
    		onyxFurnaceOnName = localisation.get("Block Names", "OnyxFurnaceOnName", "Onyx Furnace").getString();   		
    		copperDoorName = localisation.get("Block Names", "CopperDoorName", "Copper Door").getString();
    		onyxDoorName = localisation.get("Block Names", "OnyxDoorName", "Onyx Door").getString();
    		copperBarsName = localisation.get("Block Names", "CopperBarsName", "Copper Bars").getString();
    		tinBarsName = localisation.get("Block Names", "TinBarsName", "Tin Bars").getString();
    		mythrilBarsName = localisation.get("Block Names", "MythrilBarsName", "Mythril Bars").getString();
    		adamantiumBarsName = localisation.get("Block Names", "AdamantiumBarsName", "Adamantium Bars").getString();
    		onyxBarsName = localisation.get("Block Names", "OnyxBarsName", "Onyx Bars").getString();
    		
	    	//Item Names
	    	copperIngotName = localisation.get("Item Names", "CopperIngotName", "Copper Ingot").getString();
	    	tinIngotName = localisation.get("Item Names", "TinIngotName", "Tin Ingot").getString();
	    	mythrilIngotName = localisation.get("Item Names", "MythrilIngotName", "Mythril Ingot").getString();
	    	adamantiumIngotName = localisation.get("Item Names", "AdamantiumIngotName", "Adamantium Ingot").getString();
	    	onyxGemName = localisation.get("Item Names", "OnyxGemName", "Onyx").getString();
    		copperBucketName = localisation.get("Item Names", "CopperBucketName", "Copper Bucket").getString();
    		copperBucketWaterName = localisation.get("Item Names", "CopperBucketWaterName", "Copper Bucket of Water").getString();
    		mythrilRodName = localisation.get("Item Names", "MythrilRodName", "Mythril Rod").getString();
    		onyxRodName = localisation.get("Item Names", "OnyxRodName", "Onyx Rod").getString();
    		thyriumRodName = localisation.get("Item Names", "ThyriumRodName", "Thyrium Rod").getString();
    		sinisiteRodName = localisation.get("Item Names", "SinisiteRodName", "Sinisite Rod").getString();
    		copperDoorItemName = localisation.get("Item Names", "CopperDoorName", "Copper Door").getString();
    		onyxDoorItemName = localisation.get("Item Names", "OnyxDoorName", "Onyx Door").getString();
    		
	    	//Tool Names
    		copperPickName = localisation.get("Tool Names", "CopperPickName", "Copper Pickaxe").getString();
    		copperAxeName = localisation.get("Tool Names", "CopperAxeName", "Copper Axe").getString();
    		copperShovelName = localisation.get("Tool Names", "CopperShovelName", "Copper Shovel").getString();
    		copperSwordName = localisation.get("Weapon Names", "CopperSwordName", "Copper Sword").getString();
    		copperHoeName = localisation.get("Tool Names", "CopperHoeName", "Copper Hoe").getString();
    		tinPickName = localisation.get("Tool Names", "TinPickName", "Tin Pickaxe").getString();
    		tinAxeName = localisation.get("Tool Names", "TinAxeName", "Tin Axe").getString();
    		tinShovelName = localisation.get("Tool Names", "TinShovelName", "Tin Shovel").getString();
    		tinSwordName = localisation.get("Weapon Names", "TinSwordName", "Tin Sword").getString();
    		tinHoeName = localisation.get("Tool Names", "TinHoeName", "Tin Hoe").getString();
    		mythrilPickName = localisation.get("Tool Names", "MythrilPickName", "Mythril Pickaxe").getString();
    		mythrilAxeName = localisation.get("Tool Names", "MythrilAxeName", "Mythril Axe").getString();
    		mythrilShovelName = localisation.get("Tool Names", "MythrilShovelName", "Mythril Shovel").getString();
    		mythrilSwordName = localisation.get("Weapon Names", "MythrilSwordName", "Mythril Sword").getString();
    		mythrilHoeName = localisation.get("Tool Names", "MythrilHoeName", "Mythril Hoe").getString();
    		adamantiumPickName = localisation.get("Tool Names", "AdamantiumPickName", "Adamantium Pickaxe").getString();
    		adamantiumAxeName = localisation.get("Tool Names", "AdamantiumAxeName", "Adamantium Axe").getString();
    		adamantiumShovelName = localisation.get("Tool Names", "AdamantiumShovelName", "Adamantium Shovel").getString();
    		adamantiumSwordName = localisation.get("Weapon Names", "AdamantiumSwordName", "Adamantium Sword").getString();
    		adamantiumHoeName = localisation.get("Tool Names", "AdamantiumHoeName", "Adamantium Hoe").getString();
    		onyxPickName = localisation.get("Tool Names", "OnyxPickName", "Onyx Pickaxe").getString();
    		onyxAxeName = localisation.get("Tool Names", "OnyxAxeName", "Onyx Axe").getString();
    		onyxShovelName = localisation.get("Tool Names", "OnyxShovelName", "Onyx Shovel").getString();
    		onyxSwordName = localisation.get("Weapon Names", "OnyxSwordName", "Onyx Sword").getString();
    		onyxHoeName = localisation.get("Tool Names", "OnyxHoeName", "Onyx Hoe").getString();
    		mythrilBowName = localisation.get("Weapon Names", "MythrilBowName", "Mythril Bow").getString();
    		onyxBowName = localisation.get("Weapon Names", "OnyxBowName", "Onyx Bow").getString();
    		tinShearsName = localisation.get("Tool Names", "TinShearsName", "Tin Shears").getString();
    		adamantiumShearsName = localisation.get("Tool Names", "AdamantiumShearsName", "Adamantium Shears").getString();
    		onyxShearsName = localisation.get("Tool Names", "OnyxShearsName", "Onyx Shears").getString();
	    	
	    	//Armor Names
    		copperHelmName = localisation.get("Armor Names", "CopperHelmName", "Copper Helmet").getString();
    		copperChestName = localisation.get("Armor Names", "CopperChestname", "Copper Chestplate").getString();
    		copperLegsName = localisation.get("Armor Names", "CopperLegsName", "Copper Leggings").getString();
    		copperBootsName = localisation.get("Armor Names", "CopperBootsName", "Copper Boots").getString();
    		tinHelmName = localisation.get("Armor Names", "TinHelmName", "Tin Helmet").getString();
    		tinChestName = localisation.get("Armor Names", "TinChestname", "Tin Chestplate").getString();
    		tinLegsName = localisation.get("Armor Names", "TinLegsName", "Tin Leggings").getString();
    		tinBootsName = localisation.get("Armor Names", "TinBootsName", "Tin Boots").getString();
    		mythrilHelmName = localisation.get("Armor Names", "MythrilHelmName", "Mythril Helmet").getString();
    		mythrilChestName = localisation.get("Armor Names", "MythrilChestName", "Mythril Chestplate").getString();
    		mythrilLegsName = localisation.get("Armor Names", "MythrilLegsName", "Mythril Leggings").getString();
    		mythrilBootsName = localisation.get("Armor Names", "MythrilBootsName", "Mythril Boots").getString();
    		adamantiumHelmName = localisation.get("Armor Names", "AdamantiumHelmName", "Adamantium Helmet").getString();
    		adamantiumChestName = localisation.get("Armor Names", "AdamantiumChestName", "Adamantium Chestplate").getString();
    		adamantiumLegsName = localisation.get("Armor Names", "AdamantiumLegsName", "Adamantium Leggings").getString();
    		adamantiumBootsName = localisation.get("Armor Names", "AdamantiumBootsName", "Adamantium Boots").getString();
    		onyxHelmName = localisation.get("Armor Names", "OnyxHelmName", "Onyx Helmet").getString();
    		onyxChestName = localisation.get("Armor Names", "OnyxChestName", "Onyx Chestplate").getString();
    		onyxLegsName = localisation.get("Armor Names", "OnyxLegsName", "Onyx Leggings").getString();
    		onyxBootsName = localisation.get("Armor Names", "OnyxBootsName", "Onyx Boots").getString();
	    	
    		//Bow Tooltips
    		damageTooltip = localisation.get("Bow Tooltips", "DamageTooltip", "+Damage").getString();
    		flameTooltip = localisation.get("Bow Tooltips", "FlameTooltip", "+Flame").getString();
    		knockbackTooltip = localisation.get("Bow Tooltips", "KnockbackTooltip", "+Knockback").getString();
    		zoomTooltip = localisation.get("Bow Tooltips", "ZoomTooltip", "+Zoom").getString();
    		efficiencyTooltip = localisation.get("Bow Tooltips", "EfficiencyTooltip", "+Efficiency").getString();
    		
    		//Achievement Names
    		simpleOresAchName = localisation.get("Achievement Names", "SimpleOresAchievement", "Welcome to SimpleOres!").getString();
    		adamantiumAchName = localisation.get("Achievement Names", "AdamantiumAchievement", "The Green One").getString();
    		onyxAchName = localisation.get("Achievement Names", "OnyxAchievement", "The Camouflaged Ore").getString();
    		ironPickAchName = localisation.get("Achievement Names", "IronPickAchievement", "Upgrade MK II").getString();
    		adamantiumPickAchName = localisation.get("Achievement Names", "AdamantiumPickAchievement", "Lighting Fast!").getString();
    		onyxPickAchName = localisation.get("Achievement Names", "OnyxPickAchievement", "The Unbreakable").getString();
    		mythrilBowAchName = localisation.get("Achievement Names", "MythrilBowAchievement", "Mystical Bow").getString();
    		onyxBowAchName = localisation.get("Achievement Names", "OnyxBowAchievement", "Firebug").getString();
    		
    		//Achievement Descriptions
    		simpleOresAchDesc = localisation.get("Achievement Descriptions", "SimpleOresAchievement", "Begin your SimpleOres adventure by collection some Copper.").getString();
    		adamantiumAchDesc = localisation.get("Achievement Descriptions", "AdamantiumAchievement", "Dig deep to find some Adamantium.").getString();
    		onyxAchDesc = localisation.get("Achievement Descriptions", "OnyxAchievement", "Good luck finding some.").getString();
    		ironPickAchDesc = localisation.get("Achievement Descriptions", "IronPickAchievement", "Construct an Iron Pickaxe.").getString();
    		adamantiumPickAchDesc = localisation.get("Achievement Descriptions", "AdamantiumPickAchievement", "Make an Adamantium Pickaxe to dig faster than ever.").getString();
    		onyxPickAchDesc = localisation.get("Achievement Descriptions", "OnyxPickAchievement", "There's a good chance it will out-live you.").getString();
    		mythrilBowAchDesc = localisation.get("Achievement Descriptions", "MythrilBowAchievement", "Forge a new bow with magical properties.").getString();
    		onyxBowAchDesc = localisation.get("Achievement Descriptions", "OnyxBowAchievement", "Scorch your enemies with this bow from the Hells.").getString();		
	    }
		
    	catch (Exception e) 
    	{
    		FMLLog.log(Level.SEVERE, e, "[SimpleOres] Error while trying to access the SimpleOres localisation file!");
    	}
		
    	finally 
    	{
    		localisation.save();
	    	System.out.println("[SimpleOres] Localisation loaded."); 
    	}
	}
}
