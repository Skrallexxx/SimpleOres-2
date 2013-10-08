package SimpleOres.core;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraftforge.common.MinecraftForge;
import SimpleOres.core.content.SimpleBow;
import SimpleOres.core.content.SimpleShears;
import SimpleOres.core.api.SimpleAxe;
import SimpleOres.core.api.SimpleHoe;
import SimpleOres.core.api.SimplePickaxe;
import SimpleOres.core.api.SimpleShovel;
import SimpleOres.core.api.SimpleSword;

public class Tools 
{
	/**
	 * Linking to the classes for easier reference.
	 */
	public static SimpleOres mod;
	public static Achievements achievements;
	public static Armor armor;
	public static Blocks blocks;
	public static Config config;
	public static Items items;
	public static Localisation local;
	public static Recipes recipes;
	public static Tools tools;
	
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
		copperPick = new SimplePickaxe(config.copperPickID, mod.toolCopper, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("copperPick");
		copperAxe = new SimpleAxe(config.copperAxeID, mod.toolCopper, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("copperAxe");
		copperShovel = new SimpleShovel(config.copperShovelID, mod.toolCopper, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("copperShovel");
		copperSword = new SimpleSword(config.copperSwordID, mod.toolCopper, "simpleores", SimpleOres.tabSimpleCombat).setUnlocalizedName("copperSword");
		copperHoe = new SimpleHoe(config.copperHoeID, mod.toolCopper, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("copperHoe");
		tinPick = new SimplePickaxe(config.tinPickID, mod.toolTin, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("tinPick");
		tinAxe = new SimpleAxe(config.tinAxeID, mod.toolTin, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("tinAxe");
		tinShovel = new SimpleShovel(config.tinShovelID, mod.toolTin, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("tinShovel");
		tinSword = new SimpleSword(config.tinSwordID, mod.toolTin, "simpleores", SimpleOres.tabSimpleCombat).setUnlocalizedName("tinSword");
		tinHoe = new SimpleHoe(config.tinHoeID, mod.toolTin, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("tinHoe");
		mythrilPick = new SimplePickaxe(config.mythrilPickID, mod.toolMythril, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("mythrilPick");
		mythrilAxe = new SimpleAxe(config.mythrilAxeID, mod.toolMythril, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("mythrilAxe");
		mythrilShovel = new SimpleShovel(config.mythrilShovelID, mod.toolMythril, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("mythrilShovel");
		mythrilSword = new SimpleSword(config.mythrilSwordID, mod.toolMythril, "simpleores", SimpleOres.tabSimpleCombat).setUnlocalizedName("mythrilSword");
		mythrilHoe = new SimpleHoe(config.mythrilHoeID, mod.toolMythril, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("mythrilHoe");
		adamantiumPick = new SimplePickaxe(config.adamantiumPickID, mod.toolAdamantium, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("adamantiumPick");
		adamantiumAxe = new SimpleAxe(config.adamantiumAxeID, mod.toolAdamantium, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("adamantiumAxe");
		adamantiumShovel = new SimpleShovel(config.adamantiumShovelID, mod.toolAdamantium, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("adamantiumShovel");
		adamantiumSword = new SimpleSword(config.adamantiumSwordID, mod.toolAdamantium, "simpleores", SimpleOres.tabSimpleCombat).setUnlocalizedName("adamantiumSword");
		adamantiumHoe = new SimpleHoe(config.adamantiumHoeID, mod.toolAdamantium, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("adamantiumHoe");
		onyxPick = new SimplePickaxe(config.onyxPickID, mod.toolOnyx, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("onyxPick");
		onyxAxe = new SimpleAxe(config.onyxAxeID, mod.toolOnyx, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("onyxAxe");
		onyxShovel = new SimpleShovel(config.onyxShovelID, mod.toolOnyx, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("onyxShovel");
		onyxSword = new SimpleSword(config.onyxSwordID, mod.toolOnyx, "simpleores", SimpleOres.tabSimpleCombat).setUnlocalizedName("onyxSword");
		onyxHoe = new SimpleHoe(config.onyxHoeID, mod.toolOnyx, "simpleores", SimpleOres.tabSimpleTools).setUnlocalizedName("onyxHoe");		
		mythrilBow = (ItemBow) new SimpleBow(config.mythrilBowID, 750, mod.toolMythril).setFull3D().setUnlocalizedName("mythrilBow");
		onyxBow = (ItemBow) new SimpleBow(config.onyxBowID, 1000, mod.toolOnyx).setFull3D().setUnlocalizedName("onyxBow");
		tinShears = new SimpleShears(config.tinShearsID, 176).setUnlocalizedName("tinShears");
		adamantiumShears = new SimpleShears(config.adamantiumShearsID, 1092).setUnlocalizedName("adamantiumShears");
		onyxShears = new SimpleShears(config.onyxShearsID, 3116).setUnlocalizedName("onyxShears");
		
		//Tool Names
		if(Settings.enableOldLocalisation)
		{
			LanguageRegistry.addName(copperPick, local.copperPickName);
			LanguageRegistry.addName(copperAxe, local.copperAxeName);
			LanguageRegistry.addName(copperShovel, local.copperShovelName);
			LanguageRegistry.addName(copperSword, local.copperSwordName);
			LanguageRegistry.addName(copperHoe, local.copperHoeName);
			LanguageRegistry.addName(tinPick, local.tinPickName);
			LanguageRegistry.addName(tinAxe, local.tinAxeName);
			LanguageRegistry.addName(tinShovel, local.tinShovelName);
			LanguageRegistry.addName(tinSword, local.tinSwordName);
			LanguageRegistry.addName(tinHoe, local.tinHoeName);
			LanguageRegistry.addName(mythrilPick, local.mythrilPickName);
			LanguageRegistry.addName(mythrilAxe, local.mythrilAxeName);
			LanguageRegistry.addName(mythrilShovel, local.mythrilShovelName);
			LanguageRegistry.addName(mythrilSword, local.mythrilSwordName);
			LanguageRegistry.addName(mythrilHoe, local.mythrilHoeName);
			LanguageRegistry.addName(adamantiumPick, local.adamantiumPickName);
			LanguageRegistry.addName(adamantiumAxe, local.adamantiumAxeName);
			LanguageRegistry.addName(adamantiumShovel, local.adamantiumShovelName);
			LanguageRegistry.addName(adamantiumSword, local.adamantiumSwordName);
			LanguageRegistry.addName(adamantiumHoe, local.adamantiumHoeName);	
			LanguageRegistry.addName(onyxPick, local.onyxPickName);
			LanguageRegistry.addName(onyxAxe, local.onyxAxeName);
			LanguageRegistry.addName(onyxShovel, local.onyxShovelName);
			LanguageRegistry.addName(onyxSword, local.onyxSwordName);
			LanguageRegistry.addName(onyxHoe, local.onyxHoeName);
			LanguageRegistry.addName(mythrilBow, local.mythrilBowName);
			LanguageRegistry.addName(onyxBow, local.onyxBowName);
			LanguageRegistry.addName(tinShears, local.tinShearsName);
			LanguageRegistry.addName(adamantiumShears, local.adamantiumShearsName);
			LanguageRegistry.addName(onyxShears, local.onyxShearsName);
		}
		
		//Tool Registering
        MinecraftForge.setToolClass(copperPick, "pickaxe", 1);
        MinecraftForge.setToolClass(copperShovel, "shovel", 1);
        MinecraftForge.setToolClass(copperAxe, "axe", 1);
        MinecraftForge.setToolClass(tinPick, "pickaxe", 1);
        MinecraftForge.setToolClass(tinShovel, "shovel", 1);
        MinecraftForge.setToolClass(tinAxe, "axe", 1);
        MinecraftForge.setToolClass(mythrilPick, "pickaxe", 2);
        MinecraftForge.setToolClass(mythrilShovel, "shovel", 2);
        MinecraftForge.setToolClass(mythrilAxe, "axe", 2);
        MinecraftForge.setToolClass(adamantiumPick, "pickaxe", 2);
        MinecraftForge.setToolClass(adamantiumShovel, "shovel", 2);
        MinecraftForge.setToolClass(adamantiumAxe, "axe", 2);
        MinecraftForge.setToolClass(onyxPick, "pickaxe", 4);
        MinecraftForge.setToolClass(onyxShovel, "shovel", 4);
        MinecraftForge.setToolClass(onyxAxe, "axe", 4);
	}
	
}
