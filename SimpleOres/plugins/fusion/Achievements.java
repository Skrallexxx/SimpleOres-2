package SimpleOres.plugins.fusion;

import SimpleOres.core.handlers.HandlerCrafting;
import SimpleOres.core.handlers.HandlerPickup;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.stats.Achievement;

public class Achievements 
{
	/**
	 * Creating the Achevements.
	 */
	public static Achievement fusionAch;
	public static Achievement bronzeAch;
	
	public static void doAchievements()
	{
		/**
		 * Sets the properties of the Achievements, such as their ID, location in the GUI, image, prerequisites etc.
		 */
		fusionAch = new Achievement(IDs.fusionAchID, "fusionAch", 6, 6, Content.fusionFurnace, SimpleOres.core.Achievements.simpleOresAch).registerAchievement();
		bronzeAch = new Achievement(IDs.bronzeAchID, "bronzeAch", 8, 6, Content.bronzeIngot, fusionAch).registerAchievement();
		
		GameRegistry.registerCraftingHandler(new HandlerCrafting());
		GameRegistry.registerPickupHandler(new HandlerPickup());
		addAchievementLocalizations();
	}
		
	private static void addAchievementName(String ach, String name)
	{
		LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", name);
	}
		
	private static void addAchievementDesc(String ach, String desc)
	{
		LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
	}
	    
	/**
	 * Sets the names and descriptions of the achievements. This is what shows up when you hover over the achievement in the GUI.
	 */
	static void addAchievementLocalizations()
	{
		addAchievementName("fusionAch", Localisation.fusionAchName);
	    addAchievementDesc("fusionAch", Localisation.fusionAchDesc);
	        
	    addAchievementName("bronzeAch", Localisation.bronzeAchName);
	    addAchievementDesc("bronzeACh", Localisation.bronzeAchDesc);
	}
}
