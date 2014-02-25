package alexndr.SimpleOres.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import alexndr.SimpleOres.api.SimpleAxe;
import alexndr.SimpleOres.api.SimpleHoe;
import alexndr.SimpleOres.api.SimplePickaxe;
import alexndr.SimpleOres.api.SimpleShovel;
import alexndr.SimpleOres.api.SimpleSword;
import alexndr.SimpleOres.core.conf.Config;
import alexndr.SimpleOres.core.conf.Settings;
import alexndr.SimpleOres.core.content.SimpleBow;
import alexndr.SimpleOres.core.content.SimpleShears;

public class Tools 
{
	/**
	 * The method that gives the tools their properties and names, as well as registering them as their respective tool type. This is called by the main SimpleOres class.
	 */
	public static void doTools()
	{
		//Tool Details
		copperPick = new SimplePickaxe(Config.copperPickID, SimpleOres.toolCopper).setUnlocalizedName("copperPick");
		copperAxe = new SimpleAxe(Config.copperAxeID, SimpleOres.toolCopper).setUnlocalizedName("copperAxe");
		copperShovel = new SimpleShovel(Config.copperShovelID, SimpleOres.toolCopper).setUnlocalizedName("copperShovel");
		copperSword = new SimpleSword(Config.copperSwordID, SimpleOres.toolCopper).setUnlocalizedName("copperSword");
		copperHoe = new SimpleHoe(Config.copperHoeID, SimpleOres.toolCopper).setUnlocalizedName("copperHoe");
		tinPick = new SimplePickaxe(Config.tinPickID, SimpleOres.toolTin).setUnlocalizedName("tinPick");
		tinAxe = new SimpleAxe(Config.tinAxeID, SimpleOres.toolTin).setUnlocalizedName("tinAxe");
		tinShovel = new SimpleShovel(Config.tinShovelID, SimpleOres.toolTin).setUnlocalizedName("tinShovel");
		tinSword = new SimpleSword(Config.tinSwordID, SimpleOres.toolTin).setUnlocalizedName("tinSword");
		tinHoe = new SimpleHoe(Config.tinHoeID, SimpleOres.toolTin).setUnlocalizedName("tinHoe");
		mythrilPick = new SimplePickaxe(Config.mythrilPickID, SimpleOres.toolMythril).setUnlocalizedName("mythrilPick");
		mythrilAxe = new SimpleAxe(Config.mythrilAxeID, SimpleOres.toolMythril).setUnlocalizedName("mythrilAxe");
		mythrilShovel = new SimpleShovel(Config.mythrilShovelID, SimpleOres.toolMythril).setUnlocalizedName("mythrilShovel");
		mythrilSword = new SimpleSword(Config.mythrilSwordID, SimpleOres.toolMythril).setUnlocalizedName("mythrilSword");
		mythrilHoe = new SimpleHoe(Config.mythrilHoeID, SimpleOres.toolMythril).setUnlocalizedName("mythrilHoe");
		adamantiumPick = new SimplePickaxe(Config.adamantiumPickID, SimpleOres.toolAdamantium).setUnlocalizedName("adamantiumPick");
		adamantiumAxe = new SimpleAxe(Config.adamantiumAxeID, SimpleOres.toolAdamantium).setUnlocalizedName("adamantiumAxe");
		adamantiumShovel = new SimpleShovel(Config.adamantiumShovelID, SimpleOres.toolAdamantium).setUnlocalizedName("adamantiumShovel");
		adamantiumSword = new SimpleSword(Config.adamantiumSwordID, SimpleOres.toolAdamantium).setUnlocalizedName("adamantiumSword");
		adamantiumHoe = new SimpleHoe(Config.adamantiumHoeID, SimpleOres.toolAdamantium).setUnlocalizedName("adamantiumHoe");
		onyxPick = new SimplePickaxe(Config.onyxPickID, SimpleOres.toolOnyx).setUnlocalizedName("onyxPick");
		onyxAxe = new SimpleAxe(Config.onyxAxeID, SimpleOres.toolOnyx).setUnlocalizedName("onyxAxe");
		onyxShovel = new SimpleShovel(Config.onyxShovelID, SimpleOres.toolOnyx).setUnlocalizedName("onyxShovel");
		onyxSword = new SimpleSword(Config.onyxSwordID, SimpleOres.toolOnyx).setUnlocalizedName("onyxSword");
		onyxHoe = new SimpleHoe(Config.onyxHoeID, SimpleOres.toolOnyx).setUnlocalizedName("onyxHoe");		
		mythrilBow = new SimpleBow(Config.mythrilBowID, 750, SimpleOres.toolMythril).setFull3D().setUnlocalizedName("mythrilBow");
		onyxBow = new SimpleBow(Config.onyxBowID, 1000, SimpleOres.toolOnyx).setFull3D().setUnlocalizedName("onyxBow");
		tinShears = new SimpleShears(Config.tinShearsID, 176).setUnlocalizedName("tinShears");
		adamantiumShears = new SimpleShears(Config.adamantiumShearsID, 1092).setUnlocalizedName("adamantiumShears");
		onyxShears = new SimpleShears(Config.onyxShearsID, 3116).setUnlocalizedName("onyxShears");
		
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
        
        //Item Registering
        GameRegistry.registerItem(mythrilBow, "mythrilBow");
        GameRegistry.registerItem(onyxBow, "onyxBow");
        GameRegistry.registerItem(tinShears, "tinShears");
        GameRegistry.registerItem(adamantiumShears, "adamantiumShears");
        GameRegistry.registerItem(onyxShears, "onyxShears");
	}
	
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
}
