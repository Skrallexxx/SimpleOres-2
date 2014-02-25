package alexndr.SimpleOres.core;

import alexndr.SimpleOres.api.StatTriggers;
import alexndr.SimpleOres.core.conf.Config;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;

public class Achievements 
{
	private static StatTriggers triggers;
	
	public static Achievement simpleOresAch;
	public static Achievement adamantiumAch;
	public static Achievement onyxAch;
	public static Achievement ironPickAch;
	public static Achievement adamantiumPickAch;
	public static Achievement onyxPickAch;
	public static Achievement mythrilBowAch;
	public static Achievement onyxBowAch;
	
	public static void doAchievements()
	{
		/**
		 * Sets the properties of the Achievements, such as their ID, location in the GUI, image, prerequisites etc.
		 */
		simpleOresAch = new Achievement(Config.simpleOresAchID, "simpleOresAch", 5, 4, Blocks.copperOre, AchievementList.buildPickaxe).registerAchievement();
		adamantiumAch = new Achievement(Config.adamantiumAchID, "adamantiumAch", 7, 4, Blocks.adamantiumOre, simpleOresAch).registerAchievement();
		onyxAch = new Achievement(Config.onyxAchID, "onyxAch", 9, 4, Blocks.onyxOre, adamantiumAch).setSpecial().registerAchievement();
		ironPickAch = new Achievement(Config.ironPickAchID, "ironPickAch", 8, 2, Item.pickaxeIron, AchievementList.buildBetterPickaxe).registerAchievement();
		adamantiumPickAch = new Achievement(Config.adamantiumPickAchID, "adamantiumPickAch", 10, 2, Tools.adamantiumPick, ironPickAch).registerAchievement();
		onyxPickAch = new Achievement(Config.onyxPickAchID, "onyxPickAch", 12, 2, Tools.onyxPick, adamantiumPickAch).setSpecial().registerAchievement();
		mythrilBowAch = new Achievement(Config.mythrilBowAchID, "mythrilBowAch", 4, 5, Tools.mythrilBow, simpleOresAch).registerAchievement();
		onyxBowAch = new Achievement(Config.onyxBowAchID, "onyxBowAch", 4, 7, Tools.onyxBow, simpleOresAch).setSpecial().registerAchievement();
	}
    
    public static void setTriggers()
    {
    	//Crafting Triggers
    	triggers.statTriggers().addCraftingTrigger(new ItemStack(Item.pickaxeIron), ironPickAch);
    	triggers.statTriggers().addCraftingTrigger(new ItemStack(Tools.adamantiumPick), adamantiumPickAch);
    	triggers.statTriggers().addCraftingTrigger(new ItemStack(Tools.onyxPick), onyxPickAch);
    	triggers.statTriggers().addCraftingTrigger(new ItemStack(Tools.mythrilBow), mythrilBowAch);
    	triggers.statTriggers().addCraftingTrigger(new ItemStack(Tools.onyxBow), onyxBowAch);
    	
    	//Pickup Triggers
    	triggers.statTriggers().addPickupTrigger(new ItemStack(Blocks.copperOre), simpleOresAch);
    	triggers.statTriggers().addPickupTrigger(new ItemStack(Items.onyxGem), onyxAch);
    	triggers.statTriggers().addPickupTrigger(new ItemStack(Blocks.adamantiumOre), adamantiumAch);
    }
}
