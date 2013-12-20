package alexndr.SimpleOres.core;

import net.minecraft.item.Item;
import alexndr.SimpleOres.api.SimpleArmor;
import alexndr.SimpleOres.core.conf.Config;
import alexndr.SimpleOres.core.handlers.ProxyCommon;

public class Armor 
{
	public static ProxyCommon proxy;
	public static SimpleOres mod;
	
	public static Item copperHelm;
	public static Item copperChest;
	public static Item copperLegs;
	public static Item copperBoots;
	public static Item tinHelm;
	public static Item tinChest;
	public static Item tinLegs;
	public static Item tinBoots;
	public static Item mythrilHelm;
	public static Item mythrilChest;
	public static Item mythrilLegs;
	public static Item mythrilBoots;
	public static Item adamantiumHelm;
	public static Item adamantiumChest;
	public static Item adamantiumLegs;
	public static Item adamantiumBoots;
	public static Item onyxHelm;
	public static Item onyxChest;
	public static Item onyxLegs;
	public static Item onyxBoots;
	
	/**
	 * The method that gives the armor items their properties and names. This is called by the main SimpleOres class.
	 */
	public static void doArmor()
	{
        //Armour Details
        copperHelm = new SimpleArmor(Config.copperHelmID, mod.armorCopper, mod.rendererCopper, 0).setType("copper").setUnlocalizedName("copperHelm");
		copperChest = new SimpleArmor(Config.copperChestID, mod.armorCopper, mod.rendererCopper, 1).setType("copper").setUnlocalizedName("copperChest");
		copperLegs = new SimpleArmor(Config.copperLegsID, mod.armorCopper, mod.rendererCopper, 2).setType("copper").setUnlocalizedName("copperLegs");
		copperBoots = new SimpleArmor(Config.copperBootsID, mod.armorCopper, mod.rendererCopper, 3).setType("copper").setUnlocalizedName("copperBoots");
        tinHelm = new SimpleArmor(Config.tinHelmID, mod.armorTin, mod.rendererTin, 0).setType("tin").setUnlocalizedName("tinHelm");
		tinChest = new SimpleArmor(Config.tinChestID, mod.armorTin, mod.rendererTin, 1).setType("tin").setUnlocalizedName("tinChest");
		tinLegs = new SimpleArmor(Config.tinLegsID, mod.armorTin, mod.rendererTin, 2).setType("tin").setUnlocalizedName("tinLegs");
		tinBoots = new SimpleArmor(Config.tinBootsID, mod.armorTin, mod.rendererTin, 3).setType("tin").setUnlocalizedName("tinBoots");
		mythrilHelm = new SimpleArmor(Config.mythrilHelmID, mod.armorMythril, mod.rendererMythril, 0).setType("mythril").setUnlocalizedName("mythrilHelm");
		mythrilChest = new SimpleArmor(Config.mythrilChestID, mod.armorMythril, mod.rendererMythril, 1).setType("mythril").setUnlocalizedName("mythrilChest");
		mythrilLegs = new SimpleArmor(Config.mythrilLegsID, mod.armorMythril, mod.rendererMythril, 2).setType("mythril").setUnlocalizedName("mythrilLegs");
		mythrilBoots = new SimpleArmor(Config.mythrilBootsID, mod.armorMythril, mod.rendererMythril, 3).setType("mythril").setUnlocalizedName("mythrilBoots");
		adamantiumHelm = new SimpleArmor(Config.adamantiumHelmID, mod.armorAdamantium, mod.rendererAdamantium, 0).setType("adamantium").setUnlocalizedName("adamantiumHelm");
		adamantiumChest = new SimpleArmor(Config.adamantiumChestID, mod.armorAdamantium, mod.rendererAdamantium, 1).setType("adamantium").setUnlocalizedName("adamantiumChest");
		adamantiumLegs = new SimpleArmor(Config.adamantiumLegsID, mod.armorAdamantium, mod.rendererAdamantium, 2).setType("adamantium").setUnlocalizedName("adamantiumLegs");
		adamantiumBoots = new SimpleArmor(Config.adamantiumBootsID, mod.armorAdamantium, mod.rendererAdamantium, 3).setType("adamantium").setUnlocalizedName("adamantiumBoots");
		onyxHelm = new SimpleArmor(Config.onyxHelmID, mod.armorOnyx, mod.rendererOnyx, 0).setType("onyx").setUnlocalizedName("onyxHelm");
		onyxChest = new SimpleArmor(Config.onyxChestID, mod.armorOnyx, mod.rendererOnyx, 1).setType("onyx").setUnlocalizedName("onyxChest");
		onyxLegs = new SimpleArmor(Config.onyxLegsID, mod.armorOnyx, mod.rendererOnyx, 2).setType("onyx").setUnlocalizedName("onyxLegs");
		onyxBoots = new SimpleArmor(Config.onyxBootsID, mod.armorOnyx, mod.rendererOnyx, 3).setType("onyx").setUnlocalizedName("onyxBoots");
	}
}
