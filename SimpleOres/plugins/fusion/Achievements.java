package SimpleOres.plugins.fusion;

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
	}
}
