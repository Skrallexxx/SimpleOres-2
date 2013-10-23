package SimpleOres.core;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import SimpleOres.core.handlers.HandlerCrafting;
import SimpleOres.core.handlers.HandlerPickup;

public class Achievements
{
	/**
	 * Linking to the classes for easier reference.
	 */
	public static Blocks blocks;
	public static Config config;
	public static Items items;
	public static Tools tools;
	
	/**
	 * Creating the Achevements.
	 */
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
		simpleOresAch = new Achievement(config.simpleOresAchID, "simpleOresAch", 5, 4, blocks.copperOre, AchievementList.buildPickaxe).registerAchievement();
		adamantiumAch = new Achievement(config.adamantiumAchID, "adamantiumAch", 7, 4, blocks.adamantiumOre, simpleOresAch).registerAchievement();
		onyxAch = new Achievement(config.onyxAchID, "onyxAch", 9, 4, blocks.onyxOre, adamantiumAch).setSpecial().registerAchievement();
		ironPickAch = new Achievement(config.ironPickAchID, "ironPickAch", 8, 2, Item.pickaxeIron, AchievementList.buildBetterPickaxe).registerAchievement();
		adamantiumPickAch = new Achievement(config.adamantiumPickAchID, "adamantiumPickAch", 10, 2, tools.adamantiumPick, ironPickAch).registerAchievement();
		onyxPickAch = new Achievement(config.onyxPickAchID, "onyxPickAch", 12, 2, tools.onyxPick, adamantiumPickAch).setSpecial().registerAchievement();
		mythrilBowAch = new Achievement(config.mythrilBowAchID, "mythrilBowAch", 4, 5, tools.mythrilBow, simpleOresAch).registerAchievement();
		onyxBowAch = new Achievement(config.onyxBowAchID, "onyxBowAch", 4, 7, tools.onyxBow, simpleOresAch).setSpecial().registerAchievement();
		
		GameRegistry.registerCraftingHandler(new HandlerCrafting());
		GameRegistry.registerPickupHandler(new HandlerPickup());
	}
	
	private static void addAchievementName(String ach, String name)
	{
		LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", name);
	}
	
    private static void addAchievementDesc(String ach, String desc)
    {
            LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
    }
}
