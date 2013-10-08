package SimpleOres.plugins.Netherrocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;

public class Achievements 
{
	/**
	 * Creating the achievements.
	 */
	public static Achievement netherRocksAch;
	public static Achievement netherFurnaceAch;
	
	/**
	 * Method that gives the achievements their properties, such as location on the GUI, what block/item shows up for the icon, prerequisite achievementes, etc.
	 */
	public static void doAchievements()
	{	
		netherRocksAch = new Achievement(Config.netherRocksAchID, "netherRocksAch", 1, 7, Blocks.fyriteOre, AchievementList.portal).registerAchievement();
		netherFurnaceAch = new Achievement(Config.netherFurnaceAchID, "netherFurnaceAch", 1, 6, Blocks.netherFurnaceOn, netherRocksAch).setSpecial().registerAchievement();
		
		GameRegistry.registerPickupHandler(new HandlerPickup());
		GameRegistry.registerCraftingHandler(new HandlerCrafting());
		if(Settings.enableOldLocalisation)
		{
			addAchievementLocalizations();
		}
	}
	
	/**
	 * Adds the name to the achievement. This is added to the LanguageRegistry, so the actual name isn't set here, only the format.
	 */
	private static void addAchievementName(String ach, String name)
    {
            LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", name);
    }
	
	/**
	 * Adds the description to the achievement. This is added to the LanguageRegistry, so the actual description isn't set here, only the format.
	 */
    private static void addAchievementDesc(String ach, String desc)
    {
            LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
    }
	
    /**
     * Adds both names and descriptions to achievements. Both the strings are pulled from the localisation file, so that they can be changed to suit other languages.
     */
    static void addAchievementLocalizations()
    {
        addAchievementName("netherRocksAch", Localisation.netherRocksAchName);
        addAchievementDesc("netherRocksAch", Localisation.netherRocksAchDesc);
        
        addAchievementName("netherFurnaceAch", Localisation.netherFurnaceAchName);
        addAchievementDesc("netherFurnaceAch", Localisation.netherFurnaceAchDesc);
    }
}
