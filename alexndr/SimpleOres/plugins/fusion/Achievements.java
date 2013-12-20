package alexndr.SimpleOres.plugins.fusion;

import alexndr.SimpleOres.api.StatTriggers;
import alexndr.SimpleOres.core.SimpleOres;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class Achievements 
{
	private static StatTriggers triggers;

	public static Achievement fusionAch;
	public static Achievement bronzeAch;
	
	public static void doAchievements()
	{
		/**
		 * Sets the properties of the Achievements, such as their ID, location in the GUI, image, prerequisites etc.
		 */
		fusionAch = new Achievement(Config.fusionAchID, "fusionAch", 6, 6, Content.fusionFurnace, alexndr.SimpleOres.core.Achievements.simpleOresAch).registerAchievement();
		bronzeAch = new Achievement(Config.bronzeAchID, "bronzeAch", 8, 6, Content.bronzeIngot, fusionAch).registerAchievement();
		
	}
	
	public static void setTriggers()
	{
		//Crafting Triggers
		triggers.statTriggers().addCraftingTrigger(new ItemStack(Content.fusionFurnace), fusionAch);
		
		//Smelting Triggers
		triggers.statTriggers().addSmeltingTrigger(new ItemStack(Content.bronzeIngot), bronzeAch);
	}
}
