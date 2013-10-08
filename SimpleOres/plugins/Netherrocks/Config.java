package SimpleOres.plugins.Netherrocks;

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
	//Blocks
  	public static int fyriteOreID;
  	public static int fyriteBlockID;
  	public static int malachiteOreID;
  	public static int malachiteBlockID;
  	public static int ashstoneOreID;
  	public static int ashstoneBlockID;
  	public static int illumeniteOreID;
  	public static int illumeniteBlockID;
  	public static int dragonstoneOreID;
  	public static int dragonstoneBlockID;
  	public static int argoniteOreID;
  	public static int argoniteBlockID;
  	public static int netherFurnaceID;
  	public static int netherFurnaceOnID;
  	
  	//Items
  	public static int fyriteIngotID;
  	public static int malachiteIngotID;
  	public static int ashstoneGemID;
  	public static int illumeniteIngotID;
  	public static int dragonstoneGemID;
  	public static int argoniteIngotID;
  	
  	//Tools
  	public static int malachitePickID;
  	public static int malachiteAxeID;
  	public static int malachiteShovelID;
  	public static int malachiteSwordID;
  	public static int malachiteHoeID;
  	public static int ashstonePickID;
  	public static int ashstoneAxeID;
  	public static int ashstoneShovelID;
  	public static int ashstoneSwordID;
  	public static int ashstoneHoeID;
  	public static int dragonstonePickID;
  	public static int dragonstoneAxeID;
  	public static int dragonstoneShovelID;
  	public static int dragonstoneSwordID;
  	public static int dragonstoneHoeID;
  	public static int argonitePickID;
  	public static int argoniteAxeID;
  	public static int argoniteShovelID;
  	public static int argoniteSwordID;
  	public static int argoniteHoeID;
  	public static int fyriteSwordID;
  	public static int illumeniteSwordID;
  	public static int fyritePickID;
  	
  	//Armor
  	public static int fyriteHelmID;
  	public static int fyriteChestID;
  	public static int fyriteLegsID;
  	public static int fyriteBootsID;
  	public static int malachiteHelmID;
  	public static int malachiteChestID;
  	public static int malachiteLegsID;
  	public static int malachiteBootsID;
  	public static int illumeniteHelmID;
  	public static int illumeniteChestID;
  	public static int illumeniteLegsID;
  	public static int illumeniteBootsID;
  	public static int dragonstoneHelmID;
  	public static int dragonstoneChestID;
  	public static int dragonstoneLegsID;
  	public static int dragonstoneBootsID;
  	
  	//Achievements
  	public static int netherRocksAchID;
  	public static int netherFurnaceAchID;
  	
	/**
	 * The method that loads/creates the configuration file. The ID's can be changed, and their defaults are shown. This is called by the main Netherrocks class.
	 */
	public static void doConfig(FMLPreInitializationEvent event)
  	{
		/**
		 * Creating the config file. installDir is the 'config' file within .minecraft. configDir add a "SimpleOres Configuration/Plugins" folder within there.
		 */
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres Configuration/Plugins");
    	Configuration config = new Configuration(new File(configDir, "Netherrocks Config.cfg"));
    	
    	try 
    	{
    		config.load();
    		
    		//Block ID's
    		fyriteOreID = config.getBlock("Blocks", "Fyrite Ore", 560).getInt();
    		fyriteBlockID = config.getBlock("Blocks", "Fyrite Block", 561).getInt();
    		malachiteOreID = config.getBlock("Blocks", "Malachite Ore", 562).getInt();
    		malachiteBlockID = config.getBlock("Blocks", "Malachite Block", 563).getInt();
    		ashstoneOreID = config.getBlock("Blocks", "Ashstone Ore", 564).getInt();
    		ashstoneBlockID = config.getBlock("Blocks", "Ashstone Block", 565).getInt();
    		illumeniteOreID = config.getBlock("Blocks", "Illumenite Ore", 566).getInt();
    		illumeniteBlockID = config.getBlock("Blocks", "Illumenite Block", 567).getInt();
    		dragonstoneOreID = config.getBlock("Blocks", "Dragonstone Ore", 568).getInt();
    		dragonstoneBlockID = config.getBlock("Blocks", "Dragonstone Block", 569).getInt();
    		argoniteOreID = config.getBlock("Blocks", "Argonite Ore", 570).getInt();
    		argoniteBlockID = config.getBlock("Blocks", "Argonite Block", 571).getInt();
    		netherFurnaceID = config.getBlock("Blocks", "Nether Furnace", 572).getInt();
    		netherFurnaceOnID = config.getBlock("Blocks", "Nether Furnace-On", 573).getInt();
    		
        	//Item ID's
    		fyriteIngotID = config.getItem("Items", "Fyrite Ingot", 6000).getInt();
    		malachiteIngotID = config.getItem("Items", "Malachite Ingot", 6001).getInt();
    		ashstoneGemID = config.getItem("Items", "Ashstone Ingot", 6002).getInt();
        	illumeniteIngotID = config.getItem("Items", "Illumenite Ingot", 6003).getInt();
        	dragonstoneGemID = config.getItem("Items", "Dragonstone Ingot", 6004).getInt();
        	argoniteIngotID = config.getItem("Items", "Argonite Ingot", 6005).getInt();
        	
        	//Tool ID's
        	malachitePickID = config.getItem("Tools", "Malachite Pickaxe", 6020).getInt();
        	malachiteAxeID = config.getItem("Tools", "Malachite Axe", 6021).getInt();
        	malachiteShovelID = config.getItem("Tools", "Malachite Shovel", 6022).getInt();
        	malachiteSwordID = config.getItem("Tools", "Malachite Sword", 6023).getInt();
        	malachiteHoeID = config.getItem("Tools", "Malachite Hoe", 6024).getInt();
        	ashstonePickID = config.getItem("Tools", "Ashstone Pickaxe", 6025).getInt();
        	ashstoneAxeID = config.getItem("Tools", "Ashstone Axe", 6026).getInt();
        	ashstoneShovelID = config.getItem("Tools", "Ashstone Shovel", 6027).getInt();
        	ashstoneSwordID = config.getItem("Tools", "Ashstone Sword", 6028).getInt();
        	ashstoneHoeID = config.getItem("Tools", "Ashstone Hoe", 6029).getInt();
        	dragonstonePickID = config.getItem("Tools", "Dragonstone Pickaxe", 6030).getInt();
        	dragonstoneAxeID = config.getItem("Tools", "Dragonstone Axe", 6031).getInt();
        	dragonstoneShovelID = config.getItem("Tools", "Dragonstone Shovel", 6032).getInt();
        	dragonstoneSwordID = config.getItem("Tools", "Dragonstone Sword", 6033).getInt();
        	dragonstoneHoeID = config.getItem("Tools", "Dragonstone Hoe", 6034).getInt();
        	argonitePickID = config.getItem("Tools", "Argonite Pickaxe", 6035).getInt();
        	argoniteAxeID = config.getItem("Tools", "Argonite Axe", 6036).getInt();
        	argoniteShovelID = config.getItem("Tools", "Argonite Shovel", 6037).getInt();
        	argoniteSwordID = config.getItem("Tools", "Argonite Sword", 6038).getInt();
        	argoniteHoeID = config.getItem("Tools", "Argonite Hoe", 6039).getInt();
        	fyriteSwordID = config.getItem("Tools", "Fyrite Sword", 6040).getInt();
        	illumeniteSwordID = config.getItem("Tools", "Illumenite Sword", 6041).getInt();
        	fyritePickID = config.getItem("Tools", "Fyrite Pickaxe", 6042).getInt();
        	
    		//Armor ID's
        	fyriteHelmID = config.getItem("Armor", "Fyrite Helm", 6050).getInt();
        	fyriteChestID = config.getItem("Armor", "Fyrite Chest", 6051).getInt();
        	fyriteLegsID = config.getItem("Armor", "Fyrite Legs", 6052).getInt();
        	fyriteBootsID = config.getItem("Armor", "Fyrite Boots", 6053).getInt();
        	malachiteHelmID = config.getItem("Armor", "Malachite Helm", 6054).getInt();
        	malachiteChestID = config.getItem("Armor", "Malachite Chest", 6055).getInt();
        	malachiteLegsID = config.getItem("Armor", "Malachite Legs", 6056).getInt();
        	malachiteBootsID = config.getItem("Armor", "Malachite Boots", 6057).getInt();
        	illumeniteHelmID = config.getItem("Armor", "Illumenite Helm", 6058).getInt();
        	illumeniteChestID = config.getItem("Armor", "Illumenite Chest", 6059).getInt();
        	illumeniteLegsID = config.getItem("Armor", "Illumenite Legs", 6060).getInt();
        	illumeniteBootsID = config.getItem("Armor", "Illumenite Boots", 6061).getInt();
        	dragonstoneHelmID = config.getItem("Armor", "Dragonstone Helm", 6062).getInt();
        	dragonstoneChestID = config.getItem("Armor", "Dragonstone Chest", 6063).getInt();
        	dragonstoneLegsID = config.getItem("Armor", "Dragonstone Legs", 6064).getInt();
        	dragonstoneBootsID = config.getItem("Armor", "Dragonstone Boots", 6065).getInt();
        	
    		//Achievement ID's
        	netherRocksAchID = config.get("Achievements", "Netherrocks Achievement", 6000).getInt();
        	netherFurnaceAchID = config.get("Achievements", "NetherFurnace Achievement", 6001).getInt();          	
    	}
    	
    	catch (Exception e) 
    	{
    		FMLLog.log(Level.SEVERE, e, "[SimpleOres] Netherrocks Plugin has a problem loading it's configuration");
    	}
    	
    	finally 
    	{
    		config.save();
    		System.out.println("[SimpleOres] Netherrocks Plugin Config loaded.");
    	}  
  	}
}
