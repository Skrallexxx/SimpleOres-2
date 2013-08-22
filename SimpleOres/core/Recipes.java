package SimpleOres.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import SimpleOres.core.conf.IDs;
import SimpleOres.core.conf.Localisation;
import SimpleOres.core.conf.Settings;
import SimpleOres.plugins.fusion.api.FusionRecipes;

public class Recipes
{
	/**
	 * Linking to the classes for easier reference.
	 */
	public static SimpleOres mod;
	public static Achievements achievements;
	public static Armor armor;
	public static Blocks blocks;
	public static IDs config;
	public static Items items;
	public static Localisation local;
	public static Recipes recipes;
	public static Settings toggles;
	public static Tools tools;
	
	/**
	 * The constructor for the recipes. This is called by the main mod class.
	 * This is where all the recipes are created, from tools and armor to block and smelting recipes.
	 * 
	 * Forge OreDictionary results are set here.
	 */
	public static void doRecipes()
	{
		//Forge OreDictionary
		OreDictionary.registerOre("oreCopper", new ItemStack(blocks.copperOre));
		OreDictionary.registerOre("oreTin", new ItemStack(blocks.tinOre));
		OreDictionary.registerOre("oreMythril", new ItemStack(blocks.mythrilOre));
		OreDictionary.registerOre("oreAdamantium", new ItemStack(blocks.adamantiumOre));
		OreDictionary.registerOre("oreOnyx", new ItemStack(blocks.onyxOre));
		OreDictionary.registerOre("ingotCopper", new ItemStack(items.copperIngot));
		OreDictionary.registerOre("ingotTin", new ItemStack(items.tinIngot));
		OreDictionary.registerOre("ingotMythril", new ItemStack(items.mythrilIngot));
		OreDictionary.registerOre("ingotAdamantium", new ItemStack(items.adamantiumIngot));
		OreDictionary.registerOre("gemOnyx", new ItemStack(items.onyxGem));
		
		//Block Recipes
			//Storage Blocks
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(blocks.copperBlock, true, new Object[]{
					"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotCopper"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(blocks.tinBlock, true, new Object[]{
					"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotTin"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(blocks.mythrilBlock, true, new Object[]{
					"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotMythril"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(blocks.adamantiumBlock, true, new Object[]{
					"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotAdamantium"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(blocks.onyxBlock, true, new Object[]{
					"XXX", "XXX", "XXX", Character.valueOf('X'), "gemOnyx"}));
			
			//Special Furnace Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(blocks.mythrilFurnace, true, new Object[]{
						"XXX", "XYX", "XXX", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), Block.furnaceIdle}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(blocks.onyxFurnace, true, new Object[]{
						"XXX", "XYX", "XXX", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), Block.furnaceIdle}));
				
			//Bar Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blocks.copperBars, 16), true, new Object[]{
						"XXX", "XXX", Character.valueOf('X'), "ingotCopper"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blocks.tinBars, 16), true, new Object[]{
						"XXX", "XXX", Character.valueOf('X'), "ingotTin"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blocks.mythrilBars, 16), true, new Object[]{
						"XXX", "XXX", Character.valueOf('X'), "ingotMythril"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blocks.adamantiumBars, 16), true, new Object[]{
						"XXX", "XXX", Character.valueOf('X'), "ingotAdamantium"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blocks.onyxBars, 16), true, new Object[]{
						"XXX", "XXX", Character.valueOf('X'), "gemOnyx"}));
	
		//Item Recipes
			//Ingot Recipes
				GameRegistry.addShapelessRecipe(new ItemStack(items.copperIngot, 9), new Object[] { 
						blocks.copperBlock });
				GameRegistry.addShapelessRecipe(new ItemStack(items.tinIngot, 9), new Object[] { 
					blocks.tinBlock });
				GameRegistry.addShapelessRecipe(new ItemStack(items.mythrilIngot, 9), new Object[] { 
					blocks.mythrilBlock });
				GameRegistry.addShapelessRecipe(new ItemStack(items.adamantiumIngot, 9), new Object[] { 
					blocks.adamantiumBlock });
				GameRegistry.addShapelessRecipe(new ItemStack(items.onyxGem, 9), new Object[] { 
					blocks.onyxBlock });
			
			//Bucket
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(items.copperBucket, true, new Object[]{
						"X X", " X ", Character.valueOf('X'), "ingotCopper"}));
			
			//Rods
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(items.mythrilRod, true, new Object[]{
						"X", "X", Character.valueOf('X'), "ingotMythril"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(items.onyxRod, true, new Object[]{
						"X", "X", Character.valueOf('X'), "gemOnyx"}));
				
			//Doors
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(items.copperDoorItem, true, new Object[]{
						"XX", "XX", "XX", Character.valueOf('X'), "ingotCopper"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(items.onyxDoorItem, true, new Object[]{
						"XX", "XX", "XX", Character.valueOf('X'), "gemOnyx"}));
			
		//Tool Recipes
			//Copper Tool Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.copperPick, true, new Object[]{
						"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.copperAxe, true, new Object[]{
						"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.copperShovel, true, new Object[]{
						"X", "Y", "Y", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.copperSword, true, new Object[]{
						"X", "X", "Y", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.copperHoe, true, new Object[]{
						"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), Item.stick}));
				
			//Tin Tool Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.tinPick, true, new Object[]{
						"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.tinAxe, true, new Object[]{
						"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.tinShovel, true, new Object[]{
						"X", "Y", "Y", Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.tinSword, true, new Object[]{
						"X", "X", "Y", Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.tinHoe, true, new Object[]{
						"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), Item.stick}));
				
			//Mythril Tool Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.mythrilPick, true, new Object[]{
						"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.mythrilAxe, true, new Object[]{
						"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.mythrilShovel, true, new Object[]{
						"X", "Y", "Y", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.mythrilSword, true, new Object[]{
						"X", "X", "Y", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.mythrilHoe, true, new Object[]{
						"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), Item.stick}));
				
			//Adamantium Tool Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.adamantiumPick, true, new Object[]{
						"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.adamantiumAxe, true, new Object[]{
						"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.adamantiumShovel, true, new Object[]{
						"X", "Y", "Y", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.adamantiumSword, true, new Object[]{
						"X", "X", "Y", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.adamantiumHoe, true, new Object[]{
						"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), Item.stick}));
				
			//Onyx Tool Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.onyxPick, true, new Object[]{
						"XXX", " Y ", " Y ", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.onyxAxe, true, new Object[]{
						"XX ", "XY ", " Y ", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.onyxShovel, true, new Object[]{
						"X", "Y", "Y", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.onyxSword, true, new Object[]{
						"X", "X", "Y", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), Item.stick}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.onyxHoe, true, new Object[]{
						"XX ", " Y ", " Y ", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), Item.stick}));
				
			//Bow Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.mythrilBow, true, new Object[]{
						" XY", "Z Y", " XY", Character.valueOf('X'), items.mythrilRod, Character.valueOf('Y'), Item.silk, Character.valueOf('Z'), Item.ingotIron}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.onyxBow, true, new Object[]{
						" XY", "ZWY", " XY", Character.valueOf('X'), items.onyxRod, Character.valueOf('Y'), Item.silk, Character.valueOf('Z'), Item.diamond, Character.valueOf('W'), Item.flintAndSteel}));
				
			//Shears Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.tinShears, true, new Object[]{
						"X ", " X", Character.valueOf('X'), "ingotTin"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.adamantiumShears, true, new Object[]{
						"X ", " X", Character.valueOf('X'), "ingotAdamantium"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(tools.onyxShears, true, new Object[]{
						"X ", " X", Character.valueOf('X'), "gemOnyx"}));
				
		//Armour Recipes
			//Copper Armour Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.copperHelm, true, new Object[]{
						"XXX", "X X", Character.valueOf('X'), "ingotCopper"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.copperChest, true, new Object[]{
						"X X", "XXX", "XXX", Character.valueOf('X'), "ingotCopper"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.copperLegs, true, new Object[]{
						"XXX", "X X", "X X", Character.valueOf('X'), "ingotCopper"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.copperBoots, true, new Object[]{
						"X X", "X X", Character.valueOf('X'), "ingotCopper"}));
				
			//Tin Armour Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.tinHelm, true, new Object[]{
						"XXX", "X X", Character.valueOf('X'), "ingotTin"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.tinChest, true, new Object[]{
						"X X", "XXX", "XXX", Character.valueOf('X'), "ingotTin"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.tinLegs, true, new Object[]{
						"XXX", "X X", "X X", Character.valueOf('X'), "ingotTin"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.tinBoots, true, new Object[]{
						"X X", "X X", Character.valueOf('X'), "ingotTin"}));
				
			//Mythril Armour Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.mythrilHelm, true, new Object[]{
						"XXX", "X X", Character.valueOf('X'), "ingotMythril"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.mythrilChest, true, new Object[]{
						"X X", "XXX", "XXX", Character.valueOf('X'), "ingotMythril"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.mythrilLegs, true, new Object[]{
						"XXX", "X X", "X X", Character.valueOf('X'), "ingotMythril"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.mythrilBoots, true, new Object[]{
						"X X", "X X", Character.valueOf('X'), "ingotMythril"}));
				
			//Adamantium Armour Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.adamantiumHelm, true, new Object[]{
						"XXX", "X X", Character.valueOf('X'), "ingotAdamantium"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.adamantiumChest, true, new Object[]{
						"X X", "XXX", "XXX", Character.valueOf('X'), "ingotAdamantium"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.adamantiumLegs, true, new Object[]{
						"XXX", "X X", "X X", Character.valueOf('X'), "ingotAdamantium"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.adamantiumBoots, true, new Object[]{
						"X X", "X X", Character.valueOf('X'), "ingotAdamantium"}));
				
			//Onyx Armour Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.onyxHelm, true, new Object[]{
						"XXX", "X X", Character.valueOf('X'), "gemOnyx"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.onyxChest, true, new Object[]{
						"X X", "XXX", "XXX", Character.valueOf('X'), "gemOnyx"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.onyxLegs, true, new Object[]{
						"XXX", "X X", "X X", Character.valueOf('X'), "gemOnyx"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(armor.onyxBoots, true, new Object[]{
						"X X", "X X", Character.valueOf('X'), "gemOnyx"}));
				
		//Smelting Recipes
			//Regular Furnace				
				GameRegistry.addSmelting(Items.copperBucket.itemID, new ItemStack(Items.copperIngot, 3, 0), 0.0F);
				GameRegistry.addSmelting(Blocks.copperOre.blockID, new ItemStack(Items.copperIngot, 1, 0), 0.7F);
				GameRegistry.addSmelting(Blocks.tinOre.blockID, new ItemStack(Items.tinIngot, 1, 0), 0.7F);
				GameRegistry.addSmelting(Blocks.mythrilOre.blockID, new ItemStack(Items.mythrilIngot, 1, 0), 0.9F);
				GameRegistry.addSmelting(Blocks.adamantiumOre.blockID, new ItemStack(Items.adamantiumIngot, 1, 0), 1.0F);
				GameRegistry.addSmelting(Blocks.onyxOre.blockID, new ItemStack(Items.onyxGem, 1, 0), 1.0F);	
	}
}
