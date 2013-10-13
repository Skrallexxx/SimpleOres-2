package SimpleOres.core;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraftforge.common.MinecraftForge;
import SimpleOres.core.content.SimpleShears;
import SimpleOres.core.api.SimpleAxe;
import SimpleOres.core.api.SimpleBow;
import SimpleOres.core.api.SimpleHoe;
import SimpleOres.core.api.SimplePickaxe;
import SimpleOres.core.api.SimpleShovel;
import SimpleOres.core.api.SimpleSword;

public class Tools 
{
	/**
	 * Creating the tool items.
	 */
	public static Item copperPick;
	public static Item copperAxe;
	public static Item copperShovel;
	public static Item copperSword;
	public static Item copperHoe;
	public static Item tinPick;
	public static Item tinAxe;
	public static Item tinShovel;
	public static Item tinSword;
	public static Item tinHoe;
	public static Item mythrilPick;
	public static Item mythrilAxe;
	public static Item mythrilShovel;
	public static Item mythrilSword;
	public static Item mythrilHoe;
	public static Item adamantiumPick;
	public static Item adamantiumAxe;
	public static Item adamantiumShovel;
	public static Item adamantiumSword;
	public static Item adamantiumHoe;
	public static Item onyxPick;
	public static Item onyxAxe;
	public static Item onyxShovel;
	public static Item onyxSword;
	public static Item onyxHoe;
	public static Item mythrilBow;
	public static Item onyxBow;
	public static Item tinShears;
	public static Item adamantiumShears;
	public static Item onyxShears;
	
	/**
	 * The method that gives the tools their properties and names, as well as registering them as their respective tool type. This is called by the main SimpleOres class.
	 */
	public static void doTools()
	{
		//Tool Details
		copperPick = new SimplePickaxe(Config.copperPickID, SimpleOres.toolCopper, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("copperPick");
		copperAxe = new SimpleAxe(Config.copperAxeID, SimpleOres.toolCopper, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("copperAxe");
		copperShovel = new SimpleShovel(Config.copperShovelID, SimpleOres.toolCopper, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("copperShovel");
		copperSword = new SimpleSword(Config.copperSwordID, SimpleOres.toolCopper, "simpleores", SimpleOres.tabSimpleCombat).setUnlocalizedName("copperSword");
		copperHoe = new SimpleHoe(Config.copperHoeID, SimpleOres.toolCopper, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("copperHoe");
		tinPick = new SimplePickaxe(Config.tinPickID, SimpleOres.toolTin, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("tinPick");
		tinAxe = new SimpleAxe(Config.tinAxeID, SimpleOres.toolTin, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("tinAxe");
		tinShovel = new SimpleShovel(Config.tinShovelID, SimpleOres.toolTin, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("tinShovel");
		tinSword = new SimpleSword(Config.tinSwordID, SimpleOres.toolTin, "simpleores", SimpleOres.tabSimpleCombat).setUnlocalizedName("tinSword");
		tinHoe = new SimpleHoe(Config.tinHoeID, SimpleOres.toolTin, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("tinHoe");
		mythrilPick = new SimplePickaxe(Config.mythrilPickID, SimpleOres.toolMythril, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("mythrilPick");
		mythrilAxe = new SimpleAxe(Config.mythrilAxeID, SimpleOres.toolMythril, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("mythrilAxe");
		mythrilShovel = new SimpleShovel(Config.mythrilShovelID, SimpleOres.toolMythril, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("mythrilShovel");
		mythrilSword = new SimpleSword(Config.mythrilSwordID, SimpleOres.toolMythril, "simpleores", SimpleOres.tabSimpleCombat).setUnlocalizedName("mythrilSword");
		mythrilHoe = new SimpleHoe(Config.mythrilHoeID, SimpleOres.toolMythril, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("mythrilHoe");
		adamantiumPick = new SimplePickaxe(Config.adamantiumPickID, SimpleOres.toolAdamantium, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("adamantiumPick");
		adamantiumAxe = new SimpleAxe(Config.adamantiumAxeID, SimpleOres.toolAdamantium, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("adamantiumAxe");
		adamantiumShovel = new SimpleShovel(Config.adamantiumShovelID, SimpleOres.toolAdamantium, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("adamantiumShovel");
		adamantiumSword = new SimpleSword(Config.adamantiumSwordID, SimpleOres.toolAdamantium, "simpleores", SimpleOres.tabSimpleCombat).setUnlocalizedName("adamantiumSword");
		adamantiumHoe = new SimpleHoe(Config.adamantiumHoeID, SimpleOres.toolAdamantium, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("adamantiumHoe");
		onyxPick = new SimplePickaxe(Config.onyxPickID, SimpleOres.toolOnyx, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("onyxPick");
		onyxAxe = new SimpleAxe(Config.onyxAxeID, SimpleOres.toolOnyx, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("onyxAxe");
		onyxShovel = new SimpleShovel(Config.onyxShovelID, SimpleOres.toolOnyx, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("onyxShovel");
		onyxSword = new SimpleSword(Config.onyxSwordID, SimpleOres.toolOnyx, "simpleores", SimpleOres.tabSimpleCombat).setUnlocalizedName("onyxSword");
		onyxHoe = new SimpleHoe(Config.onyxHoeID, SimpleOres.toolOnyx, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("onyxHoe");		
		mythrilBow = (ItemBow) new SimpleBow(Config.mythrilBowID, 750, SimpleOres.toolMythril).setFull3D().setUnlocalizedName("mythrilBow");
		onyxBow = (ItemBow) new SimpleBow(Config.onyxBowID, 1000, SimpleOres.toolOnyx).setFull3D().setUnlocalizedName("onyxBow");
		tinShears = new SimpleShears(Config.tinShearsID, 176).setUnlocalizedName("tinShears");
		adamantiumShears = new SimpleShears(Config.adamantiumShearsID, 1092).setUnlocalizedName("adamantiumShears");
		onyxShears = new SimpleShears(Config.onyxShearsID, 3116).setUnlocalizedName("onyxShears");
		
		//Tool Names
		if(Settings.enableOldLocalisation)
		{
			LanguageRegistry.addName(copperPick, Localisation.copperPickName);
			LanguageRegistry.addName(copperAxe, Localisation.copperAxeName);
			LanguageRegistry.addName(copperShovel, Localisation.copperShovelName);
			LanguageRegistry.addName(copperSword, Localisation.copperSwordName);
			LanguageRegistry.addName(copperHoe, Localisation.copperHoeName);
			LanguageRegistry.addName(tinPick, Localisation.tinPickName);
			LanguageRegistry.addName(tinAxe, Localisation.tinAxeName);
			LanguageRegistry.addName(tinShovel, Localisation.tinShovelName);
			LanguageRegistry.addName(tinSword, Localisation.tinSwordName);
			LanguageRegistry.addName(tinHoe, Localisation.tinHoeName);
			LanguageRegistry.addName(mythrilPick, Localisation.mythrilPickName);
			LanguageRegistry.addName(mythrilAxe, Localisation.mythrilAxeName);
			LanguageRegistry.addName(mythrilShovel, Localisation.mythrilShovelName);
			LanguageRegistry.addName(mythrilSword, Localisation.mythrilSwordName);
			LanguageRegistry.addName(mythrilHoe, Localisation.mythrilHoeName);
			LanguageRegistry.addName(adamantiumPick, Localisation.adamantiumPickName);
			LanguageRegistry.addName(adamantiumAxe, Localisation.adamantiumAxeName);
			LanguageRegistry.addName(adamantiumShovel, Localisation.adamantiumShovelName);
			LanguageRegistry.addName(adamantiumSword, Localisation.adamantiumSwordName);
			LanguageRegistry.addName(adamantiumHoe, Localisation.adamantiumHoeName);	
			LanguageRegistry.addName(onyxPick, Localisation.onyxPickName);
			LanguageRegistry.addName(onyxAxe, Localisation.onyxAxeName);
			LanguageRegistry.addName(onyxShovel, Localisation.onyxShovelName);
			LanguageRegistry.addName(onyxSword, Localisation.onyxSwordName);
			LanguageRegistry.addName(onyxHoe, Localisation.onyxHoeName);
			LanguageRegistry.addName(mythrilBow, Localisation.mythrilBowName);
			LanguageRegistry.addName(onyxBow, Localisation.onyxBowName);
			LanguageRegistry.addName(tinShears, Localisation.tinShearsName);
			LanguageRegistry.addName(adamantiumShears, Localisation.adamantiumShearsName);
			LanguageRegistry.addName(onyxShears, Localisation.onyxShearsName);
		}
		
		//Tool Registering
        MinecraftForge.setToolClass(copperPick, "pickaxe", Settings.copperMiningLevel);
        MinecraftForge.setToolClass(copperShovel, "shovel", Settings.copperMiningLevel);
        MinecraftForge.setToolClass(copperAxe, "axe", Settings.copperMiningLevel);
        MinecraftForge.setToolClass(tinPick, "pickaxe", Settings.tinMiningLevel);
        MinecraftForge.setToolClass(tinShovel, "shovel", Settings.tinMiningLevel);
        MinecraftForge.setToolClass(tinAxe, "axe", Settings.tinMiningLevel);
        MinecraftForge.setToolClass(mythrilPick, "pickaxe", Settings.mythrilMiningLevel);
        MinecraftForge.setToolClass(mythrilShovel, "shovel", Settings.mythrilMiningLevel);
        MinecraftForge.setToolClass(mythrilAxe, "axe", Settings.mythrilMiningLevel);
        MinecraftForge.setToolClass(adamantiumPick, "pickaxe", Settings.adamantiumMiningLevel);
        MinecraftForge.setToolClass(adamantiumShovel, "shovel", Settings.adamantiumMiningLevel);
        MinecraftForge.setToolClass(adamantiumAxe, "axe", Settings.adamantiumMiningLevel);
        MinecraftForge.setToolClass(onyxPick, "pickaxe", Settings.onyxMiningLevel);
        MinecraftForge.setToolClass(onyxShovel, "shovel", Settings.onyxMiningLevel);
        MinecraftForge.setToolClass(onyxAxe, "axe", Settings.onyxMiningLevel);
	}
	
}
