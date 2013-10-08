package SimpleOres.plugins.Netherrocks;

import SimpleOres.core.api.SimpleArmor;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Armor
{
	/**
	 * Creating the armor items.
	 */
	public static Item fyriteHelm;
	public static Item fyriteChest;
	public static Item fyriteLegs;
	public static Item fyriteBoots;
	public static Item malachiteHelm;
	public static Item malachiteChest;
	public static Item malachiteLegs;
	public static Item malachiteBoots;
	public static Item illumeniteHelm;
	public static Item illumeniteChest;
	public static Item illumeniteLegs;
	public static Item illumeniteBoots;
	public static Item dragonstoneHelm;
	public static Item dragonstoneChest;
	public static Item dragonstoneLegs;
	public static Item dragonstoneBoots;
	
	/**
	 * The constructor that adds the properties to the armor. This is called from the main Netherrocks class.
	 * Adds ID, armor type, render type, armor slot, and the "type". Type is used to determine the texture file name.
	 * Also adds names to the armor pieces.
	 */
	public static void doArmor()
	{
        //Armor Details
		fyriteHelm = new SimpleArmor(Config.fyriteHelmID, Netherrocks.armorFyrite, Netherrocks.rendererFyrite, 0, "fyrite", "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("fyriteHelm");
		fyriteChest = new SimpleArmor(Config.fyriteChestID, Netherrocks.armorFyrite, Netherrocks.rendererFyrite, 1, "fyrite", "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("fyriteChest");
		fyriteLegs = new SimpleArmor(Config.fyriteLegsID, Netherrocks.armorFyrite, Netherrocks.rendererFyrite, 2, "fyrite", "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("fyriteLegs");
		fyriteBoots = new SimpleArmor(Config.fyriteBootsID, Netherrocks.armorFyrite, Netherrocks.rendererFyrite, 3, "fyrite", "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("fyriteBoots");
		malachiteHelm = new SimpleArmor(Config.malachiteHelmID, Netherrocks.armorMalachite, Netherrocks.rendererMalachite, 0, "malachite", "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("malachiteHelm");
		malachiteChest = new SimpleArmor(Config.malachiteChestID, Netherrocks.armorMalachite, Netherrocks.rendererMalachite, 1, "malachite", "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("malachiteChest");
		malachiteLegs = new SimpleArmor(Config.malachiteLegsID, Netherrocks.armorMalachite, Netherrocks.rendererMalachite, 2, "malachite", "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("malachiteLegs");
		malachiteBoots = new SimpleArmor(Config.malachiteBootsID, Netherrocks.armorMalachite, Netherrocks.rendererMalachite, 3, "malachite", "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("malachiteBoots");
		illumeniteHelm = new SimpleArmor(Config.illumeniteHelmID, Netherrocks.armorIllumenite, Netherrocks.rendererIllumenite, 0, "illumenite", "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("illumeniteHelm");
		illumeniteChest = new SimpleArmor(Config.illumeniteChestID, Netherrocks.armorIllumenite, Netherrocks.rendererIllumenite, 1, "illumenite", "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("illumeniteChest");
		illumeniteLegs = new SimpleArmor(Config.illumeniteLegsID, Netherrocks.armorIllumenite, Netherrocks.rendererIllumenite, 2, "illumenite", "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("illumeniteLegs");
		illumeniteBoots = new SimpleArmor(Config.illumeniteBootsID, Netherrocks.armorIllumenite, Netherrocks.rendererIllumenite, 3, "illumenite", "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("illumeniteBoots");
		dragonstoneHelm = new SimpleArmor(Config.dragonstoneHelmID, Netherrocks.armorDragonstone, Netherrocks.rendererDragonstone, 0, "dragonstone", "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("dragonstoneHelm");
		dragonstoneChest = new SimpleArmor(Config.dragonstoneChestID, Netherrocks.armorDragonstone, Netherrocks.rendererDragonstone, 1, "dragonstone", "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("dragonstoneChest");
		dragonstoneLegs = new SimpleArmor(Config.dragonstoneLegsID, Netherrocks.armorDragonstone, Netherrocks.rendererDragonstone, 2, "dragonstone", "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("dragonstoneLegs");
		dragonstoneBoots = new SimpleArmor(Config.dragonstoneBootsID, Netherrocks.armorDragonstone, Netherrocks.rendererDragonstone, 3, "dragonstone", "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("dragonstoneBoots");
		
		//Armor Naming
		if(Settings.enableOldLocalisation)
		{
			LanguageRegistry.addName(fyriteHelm, Localisation.fyriteHelmName);
			LanguageRegistry.addName(fyriteChest, Localisation.fyriteChestName);
			LanguageRegistry.addName(fyriteLegs, Localisation.fyriteLegsName);
			LanguageRegistry.addName(fyriteBoots, Localisation.fyriteBootsName);
			LanguageRegistry.addName(malachiteHelm, Localisation.malachiteHelmName);
			LanguageRegistry.addName(malachiteChest, Localisation.malachiteChestName);
			LanguageRegistry.addName(malachiteLegs, Localisation.malachiteLegsName);
			LanguageRegistry.addName(malachiteBoots, Localisation.malachiteBootsName);
			LanguageRegistry.addName(illumeniteHelm, Localisation.illumeniteHelmName);
			LanguageRegistry.addName(illumeniteChest, Localisation.illumeniteChestName);
			LanguageRegistry.addName(illumeniteLegs, Localisation.illumeniteLegsName);
			LanguageRegistry.addName(illumeniteBoots, Localisation.illumeniteBootsName);
			LanguageRegistry.addName(dragonstoneHelm, Localisation.dragonstoneHelmName);
			LanguageRegistry.addName(dragonstoneChest, Localisation.dragonstoneChestName);
			LanguageRegistry.addName(dragonstoneLegs, Localisation.dragonstoneLegsName);
			LanguageRegistry.addName(dragonstoneBoots, Localisation.dragonstoneBootsName);
		}
	}
}
