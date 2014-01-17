package alexndr.SimpleOres.plugins.netherrocks;

import java.io.File;

import net.minecraftforge.common.Configuration;
import alexndr.SimpleOres.api.helpers.FreeIdHelper;
import alexndr.SimpleOres.api.helpers.LogHelper;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config 
{
	private static FreeIdHelper get;
	
	public static void loadConfig(FMLPreInitializationEvent event)
	{
		/**
		 * Creating the config file. installDir is the 'config' file within .minecraft. configDir add a "SimpleOres Configuration/Plugins" folder within there.
		 */
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres/Plugins");
		File configFile = new File(configDir, "Netherrocks Config.cfg");
    	Configuration config = new Configuration(configFile);
    	LogHelper.verboseInfo("Netherrocks Plugin: Loading config file at: '" + configFile.getAbsolutePath() + "'..."); 	
		FreeIdHelper.compileIdList();
    	
    	try
    	{
    		config.load();
    		
    		//Block ID's
    		fyriteOreID = config.getBlock("Blocks", "Fyrite Ore", get.freeBlock()).getInt();
    		fyriteBlockID = config.getBlock("Blocks", "Fyrite Block", get.freeBlock()).getInt();
    		malachiteOreID = config.getBlock("Blocks", "Malachite Ore", get.freeBlock()).getInt();
    		malachiteBlockID = config.getBlock("Blocks", "Malachite Block", get.freeBlock()).getInt();
    		ashstoneOreID = config.getBlock("Blocks", "Ashstone Ore", get.freeBlock()).getInt();
    		ashstoneBlockID = config.getBlock("Blocks", "Ashstone Block", get.freeBlock()).getInt();
    		illumeniteOreID = config.getBlock("Blocks", "Illumenite Ore", get.freeBlock()).getInt();
    		illumeniteBlockID = config.getBlock("Blocks", "Illumenite Block", get.freeBlock()).getInt();
    		dragonstoneOreID = config.getBlock("Blocks", "Dragonstone Ore", get.freeBlock()).getInt();
    		dragonstoneBlockID = config.getBlock("Blocks", "Dragonstone Block", get.freeBlock()).getInt();
    		argoniteOreID = config.getBlock("Blocks", "Argonite Ore", get.freeBlock()).getInt();
    		argoniteBlockID = config.getBlock("Blocks", "Argonite Block", get.freeBlock()).getInt();
    		netherFurnaceID = config.getBlock("Blocks", "Nether Furnace", get.freeBlock()).getInt();
    		netherFurnaceOnID = config.getBlock("Blocks", "Nether Furnace-On", get.freeBlock()).getInt();
    		
        	//Item ID's
    		fyriteIngotID = config.getItem("Items", "Fyrite Ingot", get.freeItem()).getInt();
    		malachiteIngotID = config.getItem("Items", "Malachite Ingot", get.freeItem()).getInt();
    		ashstoneGemID = config.getItem("Items", "Ashstone Ingot", get.freeItem()).getInt();
        	illumeniteIngotID = config.getItem("Items", "Illumenite Ingot", get.freeItem()).getInt();
        	dragonstoneGemID = config.getItem("Items", "Dragonstone Ingot", get.freeItem()).getInt();
        	argoniteIngotID = config.getItem("Items", "Argonite Ingot", get.freeItem()).getInt();
        	
        	//Tool ID's
        	malachitePickID = config.getItem("Tools", "Malachite Pickaxe", get.freeItem()).getInt();
        	malachiteAxeID = config.getItem("Tools", "Malachite Axe", get.freeItem()).getInt();
        	malachiteShovelID = config.getItem("Tools", "Malachite Shovel", get.freeItem()).getInt();
        	malachiteSwordID = config.getItem("Tools", "Malachite Sword", get.freeItem()).getInt();
        	malachiteHoeID = config.getItem("Tools", "Malachite Hoe", get.freeItem()).getInt();
        	ashstonePickID = config.getItem("Tools", "Ashstone Pickaxe", get.freeItem()).getInt();
        	ashstoneAxeID = config.getItem("Tools", "Ashstone Axe", get.freeItem()).getInt();
        	ashstoneShovelID = config.getItem("Tools", "Ashstone Shovel", get.freeItem()).getInt();
        	ashstoneSwordID = config.getItem("Tools", "Ashstone Sword", get.freeItem()).getInt();
        	ashstoneHoeID = config.getItem("Tools", "Ashstone Hoe", get.freeItem()).getInt();
        	dragonstonePickID = config.getItem("Tools", "Dragonstone Pickaxe", get.freeItem()).getInt();
        	dragonstoneAxeID = config.getItem("Tools", "Dragonstone Axe", get.freeItem()).getInt();
        	dragonstoneShovelID = config.getItem("Tools", "Dragonstone Shovel", get.freeItem()).getInt();
        	dragonstoneSwordID = config.getItem("Tools", "Dragonstone Sword", get.freeItem()).getInt();
        	dragonstoneHoeID = config.getItem("Tools", "Dragonstone Hoe", get.freeItem()).getInt();
        	argonitePickID = config.getItem("Tools", "Argonite Pickaxe", get.freeItem()).getInt();
        	argoniteAxeID = config.getItem("Tools", "Argonite Axe", get.freeItem()).getInt();
        	argoniteShovelID = config.getItem("Tools", "Argonite Shovel", get.freeItem()).getInt();
        	argoniteSwordID = config.getItem("Tools", "Argonite Sword", get.freeItem()).getInt();
        	argoniteHoeID = config.getItem("Tools", "Argonite Hoe", get.freeItem()).getInt();
        	fyriteSwordID = config.getItem("Tools", "Fyrite Sword", get.freeItem()).getInt();
        	illumeniteSwordID = config.getItem("Tools", "Illumenite Sword", get.freeItem()).getInt();
        	fyritePickID = config.getItem("Tools", "Fyrite Pickaxe", get.freeItem()).getInt();
        	
    		//Armor ID's
        	fyriteHelmID = config.getItem("Armor", "Fyrite Helm", get.freeItem()).getInt();
        	fyriteChestID = config.getItem("Armor", "Fyrite Chest", get.freeItem()).getInt();
        	fyriteLegsID = config.getItem("Armor", "Fyrite Legs", get.freeItem()).getInt();
        	fyriteBootsID = config.getItem("Armor", "Fyrite Boots", get.freeItem()).getInt();
        	malachiteHelmID = config.getItem("Armor", "Malachite Helm", get.freeItem()).getInt();
        	malachiteChestID = config.getItem("Armor", "Malachite Chest", get.freeItem()).getInt();
        	malachiteLegsID = config.getItem("Armor", "Malachite Legs", get.freeItem()).getInt();
        	malachiteBootsID = config.getItem("Armor", "Malachite Boots", get.freeItem()).getInt();
        	illumeniteHelmID = config.getItem("Armor", "Illumenite Helm", get.freeItem()).getInt();
        	illumeniteChestID = config.getItem("Armor", "Illumenite Chest", get.freeItem()).getInt();
        	illumeniteLegsID = config.getItem("Armor", "Illumenite Legs", get.freeItem()).getInt();
        	illumeniteBootsID = config.getItem("Armor", "Illumenite Boots", get.freeItem()).getInt();
        	dragonstoneHelmID = config.getItem("Armor", "Dragonstone Helm", get.freeItem()).getInt();
        	dragonstoneChestID = config.getItem("Armor", "Dragonstone Chest", get.freeItem()).getInt();
        	dragonstoneLegsID = config.getItem("Armor", "Dragonstone Legs", get.freeItem()).getInt();
        	dragonstoneBootsID = config.getItem("Armor", "Dragonstone Boots", get.freeItem()).getInt();
        	
    		//Achievement ID's
        	netherRocksAchID = config.get("Achievements", "Netherrocks Achievement", 6000).getInt();
        	netherFurnaceAchID = config.get("Achievements", "NetherFurnace Achievement", 6001).getInt(); 
        	
        	LogHelper.verboseInfo("Netherrocks Plugin: Config file loaded successfully.");
    	}
    	
    	catch(Exception e)
    	{
    		LogHelper.warning("Netherrocks Plugin: Failed to load the config!");
    	}
    	
    	finally
    	{
    		config.save();
    	}
	}
	
	//Blocks
  	public static int fyriteOreID, malachiteOreID, ashstoneOreID, illumeniteOreID, dragonstoneOreID, argoniteOreID;
  	public static int fyriteBlockID, malachiteBlockID, ashstoneBlockID, illumeniteBlockID, dragonstoneBlockID, argoniteBlockID;
  	public static int netherFurnaceID, netherFurnaceOnID;
  	
  	//Items
  	public static int fyriteIngotID, malachiteIngotID, ashstoneGemID, illumeniteIngotID, dragonstoneGemID, argoniteIngotID;
  	
  	//Tools
  	public static int malachitePickID, ashstonePickID, dragonstonePickID, argonitePickID, fyritePickID;
  	public static int malachiteAxeID, ashstoneAxeID, dragonstoneAxeID, argoniteAxeID;
  	public static int malachiteShovelID, ashstoneShovelID, dragonstoneShovelID, argoniteShovelID;
  	public static int malachiteSwordID, ashstoneSwordID, dragonstoneSwordID, argoniteSwordID, fyriteSwordID, illumeniteSwordID;
  	public static int malachiteHoeID, ashstoneHoeID, dragonstoneHoeID, argoniteHoeID;
  	
  	//Armor
  	public static int fyriteHelmID, malachiteHelmID, illumeniteHelmID, dragonstoneHelmID;
  	public static int fyriteChestID, malachiteChestID, illumeniteChestID, dragonstoneChestID;
  	public static int fyriteLegsID, malachiteLegsID, illumeniteLegsID, dragonstoneLegsID;
  	public static int fyriteBootsID, malachiteBootsID, illumeniteBootsID, dragonstoneBootsID;
  	
  	//Achievements
  	public static int netherRocksAchID, netherFurnaceAchID;
}
