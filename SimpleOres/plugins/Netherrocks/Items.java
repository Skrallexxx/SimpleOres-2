package SimpleOres.plugins.Netherrocks;

import SimpleOres.core.api.SimpleIngot;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;

public class Items 
{
	/**
	 * Creating the items.
	 */
	public static Item fyriteIngot;
	public static Item malachiteIngot;
	public static Item ashstoneGem;
	public static Item illumeniteIngot;
	public static Item dragonstoneGem;
	public static Item argoniteIngot;
	
	/**
	 * Constructor that adds the properties to the items. This is called by the main Netherrocks class file.
	 * Sets the ID, and also gives the item a name in game.
	 */
	public static void doItems()
	{
		//Item Details
		fyriteIngot = new SimpleIngot(Config.fyriteIngotID, "netherrocks", Netherrocks.tabNetherMaterials).setUnlocalizedName("fyriteIngot");
		malachiteIngot = new SimpleIngot(Config.malachiteIngotID, "netherrocks", Netherrocks.tabNetherMaterials).setUnlocalizedName("malachiteIngot");
		ashstoneGem = new SimpleIngot(Config.ashstoneGemID, "netherrocks", Netherrocks.tabNetherMaterials).setUnlocalizedName("ashstoneGem");
		illumeniteIngot = new SimpleIngot(Config.illumeniteIngotID, "netherrocks", Netherrocks.tabNetherMaterials).setUnlocalizedName("illumeniteIngot");
		dragonstoneGem = new SimpleIngot(Config.dragonstoneGemID, "netherrocks", Netherrocks.tabNetherMaterials).setUnlocalizedName("dragonstoneGem");
		argoniteIngot = new SimpleIngot(Config.argoniteIngotID, "netherrocks", Netherrocks.tabNetherMaterials).setUnlocalizedName("argoniteIngot");
		
		//Item Naming
		if(Settings.enableOldLocalisation)
		{
			LanguageRegistry.addName(fyriteIngot, Localisation.fyriteIngotName);
			LanguageRegistry.addName(malachiteIngot, Localisation.malachiteIngotName);
			LanguageRegistry.addName(ashstoneGem, Localisation.ashstoneGemName);
			LanguageRegistry.addName(illumeniteIngot, Localisation.illumeniteIngotName);
			LanguageRegistry.addName(dragonstoneGem, Localisation.dragonstoneGemName);
			LanguageRegistry.addName(argoniteIngot, Localisation.argoniteIngotName);
		}
	}
}
