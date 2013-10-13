package SimpleOres.plugins.Netherrocks;

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
		//Block Names
		public static String fyriteOreName;
		public static String fyriteBlockName;
		public static String malachiteOreName;
		public static String malachiteBlockName;
		public static String ashstoneOreName;
		public static String ashstoneBlockName;
		public static String illumeniteOreName;
		public static String illumeniteBlockName;
		public static String dragonstoneOreName;
		public static String dragonstoneBlockName;
		public static String argoniteOreName;
		public static String argoniteBlockName;
		public static String netherFurnaceName;
		public static String netherFurnaceOnName;
		
		//Item Names
		public static String fyriteIngotName;
		public static String malachiteIngotName;
		public static String ashstoneGemName;
		public static String illumeniteIngotName;
		public static String dragonstoneGemName;
		public static String argoniteIngotName;
		
		//Tool Names
		public static String malachitePickName;
		public static String malachiteAxeName;
		public static String malachiteShovelName;
		public static String malachiteSwordName;
		public static String malachiteHoeName;
		public static String ashstonePickName;
		public static String ashstoneAxeName;
		public static String ashstoneShovelName;
		public static String ashstoneSwordName;
		public static String ashstoneHoeName;
		public static String dragonstonePickName;
		public static String dragonstoneAxeName;
		public static String dragonstoneShovelName;
		public static String dragonstoneSwordName;
		public static String dragonstoneHoeName;
		public static String argonitePickName;
		public static String argoniteAxeName;
		public static String argoniteShovelName;
		public static String argoniteSwordName;
		public static String argoniteHoeName;
		public static String fyriteSwordName;
		public static String illumeniteSwordName;
		public static String fyritePickName;
		
		//Armor Names
		public static String fyriteHelmName;
		public static String fyriteChestName;
		public static String fyriteLegsName;
		public static String fyriteBootsName;
		public static String malachiteHelmName;
		public static String malachiteChestName;
		public static String malachiteLegsName;
		public static String malachiteBootsName;
		public static String illumeniteHelmName;
		public static String illumeniteChestName;
		public static String illumeniteLegsName;
		public static String illumeniteBootsName;
		public static String dragonstoneHelmName;
		public static String dragonstoneChestName;
		public static String dragonstoneLegsName;
		public static String dragonstoneBootsName;
		
		//Achievement Names
		public static String netherRocksAchName;
		public static String netherFurnaceAchName;
		
		//Achievement Descriptions
		public static String netherRocksAchDesc;
		public static String netherFurnaceAchDesc;
		
		/**
		 * The method that loads/creates the localisation file. The names can be changed, and their defaults (English) are shown. This is called by the main Netherrocks class.
		 */
		public static void doLocalisation(FMLPreInitializationEvent event)
		{
			/**
			 * Creating the localisation file. installDir is the 'config' file within .minecraft. configDir add a "SimpleOres Configuration/Plugins" folder within there.
			 */
			File installDir = event.getModConfigurationDirectory();
			File configDir = new File(installDir, "SimpleOres Configuration/Plugins");
	    	Configuration localisation = new Configuration(new File(configDir, "Netherrocks Localisation.lang"));
	    	
	    	try 
		    {
		    	localisation.load();
		    	
		    	//Block Names
		    	fyriteOreName = localisation.get("Block Names", "FyriteOreName", "Fyrite Ore").getString();
		    	fyriteBlockName = localisation.get("Block Names", "FyriteBlockName", "Fyrite Block").getString();
		    	malachiteOreName = localisation.get("Block Names", "MalachiteOreName", "Malachite Ore").getString();
		    	malachiteBlockName = localisation.get("Block Names", "MalachiteBlockName", "Malachite Block").getString();
		    	ashstoneOreName = localisation.get("Block Names", "AshstoneOreName", "Ashstone Ore").getString();
		    	ashstoneBlockName = localisation.get("Block Names", "AshstoneBlockName", "Ashstone Block").getString();
		    	illumeniteOreName = localisation.get("Block Names", "IllumeniteOreName", "Illumenite Ore").getString();
		    	illumeniteBlockName = localisation.get("Block Names", "IllumeniteBlockName", "Illumenite Block").getString();
		    	dragonstoneOreName = localisation.get("Block Names", "DragonstoneOreName", "Dragonstone Ore").getString();
		    	dragonstoneBlockName = localisation.get("Block Names", "DragonstoneBlockName", "Dragonstone Block").getString();
		    	argoniteOreName = localisation.get("Block Names", "ArgoniteOreName", "Argonite Ore").getString();
		    	argoniteBlockName = localisation.get("Block Names", "ArgontieBlockName", "Argonite Block").getString();
		    	netherFurnaceName = localisation.get("Block Names", "NetherFurnaceName", "Nether Furnace").getString();
		    	netherFurnaceOnName = localisation.get("Block Names", "NetherFurnaceOnName", "Nether Furnace").getString();
		    	
		    	//Item Names
		    	fyriteIngotName = localisation.get("Item Names", "FyriteIngotName", "Fyrite Ingot").getString();
		    	malachiteIngotName = localisation.get("Item Names", "MalachiteIngotName", "Malachite Ingot").getString();
		    	ashstoneGemName = localisation.get("Item Names", "AshstoneGemName", "Ashstone").getString();
		    	illumeniteIngotName = localisation.get("Item Names", "IllumeniteIngotName", "Illumenite Ingot").getString();
		    	dragonstoneGemName = localisation.get("Item Names", "DragonstoneGemName", "Dragonstone").getString();
		    	argoniteIngotName = localisation.get("Item Names", "ArgoniteIngotName", "Argonite Ingot").getString();
		    	
		    	//Tools
		    	malachitePickName = localisation.get("Tool Names", "MalachitePickName", "Malachite Pickaxe").getString();
		    	malachiteAxeName = localisation.get("Tool Names", "MalachiteAxeName", "Malachite Axe").getString();
		    	malachiteShovelName = localisation.get("Tool Names", "MalachiteShovelName", "Malachite Shovel").getString();
		    	malachiteSwordName = localisation.get("Tool Names", "MalachiteSwordName", "Malachite Sword").getString();
		    	malachiteHoeName = localisation.get("Tool Names", "MalachiteHoeName", "Malachite Hoe").getString();
		    	ashstonePickName = localisation.get("Tool Names", "AshstonePickName", "Ashstone Pickaxe").getString();
		    	ashstoneAxeName = localisation.get("Tool Names", "AshstoneAxeName", "Ashstone Axe").getString();
		    	ashstoneShovelName = localisation.get("Tool Names", "AshstoneShovelName", "Ashstone Shovel").getString();
		    	ashstoneSwordName = localisation.get("Tool Names", "AshstoneSwordName", "Ashstone Sword").getString();
		    	ashstoneHoeName = localisation.get("Tool Names", "AshstoneHoeName", "Ashstone Hoe").getString();
		    	dragonstonePickName = localisation.get("Tool Names", "DragonstonePickName", "Dragonstone Pickaxe").getString();
		    	dragonstoneAxeName = localisation.get("Tool Names", "DragonstoneAxeName", "Dragonstone Axe").getString();
		    	dragonstoneShovelName = localisation.get("Tool Names", "DragonstoneShovelName", "Dragonstone Shovel").getString();
		    	dragonstoneSwordName = localisation.get("Tool Names", "DragonstoneSwordName", "Dragonstone Sword").getString();
		    	dragonstoneHoeName = localisation.get("Tool Names", "DragonstoneHoeName", "Dragonstone Hoe").getString();
		    	argonitePickName = localisation.get("Tool Names", "ArgonitePickName", "Argonite Pickaxe").getString();
		    	argoniteAxeName = localisation.get("Tool Names", "ArgoniteAxeName", "Argonite Axe").getString();
		    	argoniteShovelName = localisation.get("Tool Names", "ArgoniteShovelName", "Argonite Shovel").getString();
		    	argoniteSwordName = localisation.get("Tool Names", "ArgoniteSwordName", "Argonite Sword").getString();
		    	argoniteHoeName = localisation.get("Tool Names", "ArgoniteHoeName", "Argonite Hoe").getString();
		    	fyriteSwordName = localisation.get("Tool Names", "FyriteSwordName", "Fyrite Sword").getString();
		    	illumeniteSwordName = localisation.get("Tool Names", "IllumeniteSwordName", "Illumenite Sword").getString();
		    	fyritePickName = localisation.get("Tool Names", "FyritePickName", "Fyrite Pickaxe").getString();
		    	
		    	//Armor Names
		    	fyriteHelmName = localisation.get("Armor Names", "FyriteHelmName", "Fyrite Helmet").getString();
		    	fyriteChestName = localisation.get("Armor Names", "FyriteChestName", "Fyrite Chestplate").getString();
		    	fyriteLegsName = localisation.get("Armor Names", "FyriteLegsName", "Fyrite Leggings").getString();
		    	fyriteBootsName = localisation.get("Armor Names", "FyriteBootsName", "Fyrite Boots").getString();
		    	malachiteHelmName = localisation.get("Armor Names", "MalachiteHelmName", "Malachite Helmet").getString();
		    	malachiteChestName = localisation.get("Armor Names", "MalachiteChestName", "Malachite Chestplate").getString();
		    	malachiteLegsName = localisation.get("Armor Names", "MalachiteLegsName", "Malachite Leggings").getString();
		    	malachiteBootsName = localisation.get("Armor Names", "MalachiteBootsName", "Malachite Boots").getString();
		    	illumeniteHelmName = localisation.get("Armor Names", "IllumeniteHelmName", "Illumenite Helmet").getString();
		    	illumeniteChestName = localisation.get("Armor Names", "IllumeniteChestName", "Illumenite Chestplate").getString();
		    	illumeniteLegsName = localisation.get("Armor Names", "IllumeniteLegsName", "Illumenite Leggings").getString();
		    	illumeniteBootsName = localisation.get("Armor Names", "IllumeniteBootsName", "Illumenite Boots").getString();
		    	dragonstoneHelmName = localisation.get("Armor Names", "DragonstoneHelmName", "Dragonstone Helmet").getString();
		    	dragonstoneChestName = localisation.get("Armor Names", "DragonstoneChestName", "Dragonstone Chestplate").getString();
		    	dragonstoneLegsName = localisation.get("Armor Names", "DragonstoneLegsName", "Dragonstone Leggings").getString();
		    	dragonstoneBootsName = localisation.get("Armor Names", "DragonstoneBootsName", "Dragonstone Boots").getString();
		    	
		    	//Achivement Names
		    	netherRocksAchName = localisation.get("Achievement Names", "NetherRocksAchievement", "Welcome to Netherrocks!").getString();
		    	netherFurnaceAchName  = localisation.get("Achievement Names", "NetherFurnaceAchievement", "Super Furnace").getString();
		    	
		    	//Achievement Descriptions
		    	netherRocksAchDesc = localisation.get("Achievement Names", "NetherRocksAchievement", "Collect some Malachite Ore in the Nether.").getString();
		    	netherFurnaceAchDesc = localisation.get("Achievement Names", "NetherFurnaceAchievement", "Construct a Nether Furnace!").getString();   	
		    }
			
	    	catch (Exception e) 
	    	{
	    		FMLLog.log(Level.SEVERE, e, "[Netherrocks] Error while trying to access the Netherrocks localisation file!");
	    	}
			
	    	finally 
	    	{
	    		localisation.save();
		    	System.out.println("[Netherrocks] Localisation loaded."); 
	    	}
		}
}
