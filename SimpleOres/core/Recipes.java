package SimpleOres.core;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import SimpleOres.core.conf.IDs;
import SimpleOres.core.conf.Localisation;
import SimpleOres.core.conf.Settings;
import cpw.mods.fml.common.registry.GameRegistry;

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
	public static final String STICK = "stickWood";
	
	public static final String COPPER = "ingotCopper";
	public static final String TIN = "ingotTin";
	public static final String MYTHRIL = "ingotMythril";
	public static final String ADAMANTIUM = "ingotAdamantium";
	public static final String ONYX = "gemOnyx";
	
	public static void doRecipes()
	{
		//Forge OreDictionary
		OreDictionary.registerOre("oreCopper", new ItemStack(blocks.copperOre));
		OreDictionary.registerOre("oreTin", new ItemStack(blocks.tinOre));
		OreDictionary.registerOre("oreMythril", new ItemStack(blocks.mythrilOre));
		OreDictionary.registerOre("oreAdamantium", new ItemStack(blocks.adamantiumOre));
		OreDictionary.registerOre("oreOnyx", new ItemStack(blocks.onyxOre));
		
		OreDictionary.registerOre(COPPER, new ItemStack(items.copperIngot));
		OreDictionary.registerOre(TIN, new ItemStack(items.tinIngot));
		OreDictionary.registerOre(MYTHRIL, new ItemStack(items.mythrilIngot));
		OreDictionary.registerOre(ADAMANTIUM, new ItemStack(items.adamantiumIngot));
		OreDictionary.registerOre(ONYX, new ItemStack(items.onyxGem));
		
		//Block Recipes
			//Storage Blocks
			GameRegistry.addRecipe(new ShapedOreRecipe(blocks.copperBlock,
					"XXX", "XXX", "XXX", 'X', COPPER));
			GameRegistry.addRecipe(new ShapedOreRecipe(blocks.tinBlock,
					"XXX", "XXX", "XXX", 'X', TIN));
			GameRegistry.addRecipe(new ShapedOreRecipe(blocks.mythrilBlock,
					"XXX", "XXX", "XXX", 'X', MYTHRIL));
			GameRegistry.addRecipe(new ShapedOreRecipe(blocks.adamantiumBlock,
					"XXX", "XXX", "XXX", 'X', ADAMANTIUM));
			GameRegistry.addRecipe(new ShapedOreRecipe(blocks.onyxBlock,
					"XXX", "XXX", "XXX", 'X', ONYX));
			
			//Special Furnace Recipes
				GameRegistry.addRecipe(new ShapedOreRecipe(blocks.mythrilFurnace,
						"XXX", "XYX", "XXX", 'X', MYTHRIL, 'Y', Block.furnaceIdle));
				GameRegistry.addRecipe(new ShapedOreRecipe(blocks.onyxFurnace,
						"XXX", "XYX", "XXX", 'X', ONYX, 'Y', Block.furnaceIdle));
				
			//Bar Recipes
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blocks.copperBars, 16),
						"XXX", "XXX", 'X', COPPER));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blocks.tinBars, 16),
						"XXX", "XXX", 'X', TIN));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blocks.mythrilBars, 16),
						"XXX", "XXX", 'X', MYTHRIL));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blocks.adamantiumBars, 16),
						"XXX", "XXX", 'X', ADAMANTIUM));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blocks.onyxBars, 16),
						"XXX", "XXX", 'X', ONYX));
	
		//Item Recipes
			//Ingot Recipes
				GameRegistry.addShapelessRecipe(new ItemStack(items.copperIngot, 9), 
						blocks.copperBlock);
				GameRegistry.addShapelessRecipe(new ItemStack(items.tinIngot, 9), 
					blocks.tinBlock);
				GameRegistry.addShapelessRecipe(new ItemStack(items.mythrilIngot, 9),
					blocks.mythrilBlock);
				GameRegistry.addShapelessRecipe(new ItemStack(items.adamantiumIngot, 9),
					blocks.adamantiumBlock);
				GameRegistry.addShapelessRecipe(new ItemStack(items.onyxGem, 9),
					blocks.onyxBlock);
			
			//Bucket
				GameRegistry.addRecipe(new ShapedOreRecipe(items.copperBucket,
						"X X", " X ", 'X', COPPER));
			
			//Rods
				GameRegistry.addRecipe(new ShapedOreRecipe(items.mythrilRod,
						"X", "X", 'X', MYTHRIL));
				GameRegistry.addRecipe(new ShapedOreRecipe(items.onyxRod,
						"X", "X", 'X', ONYX));
				
			//Doors
				GameRegistry.addRecipe(new ShapedOreRecipe(items.copperDoorItem,
						"XX", "XX", "XX", 'X', COPPER));
				GameRegistry.addRecipe(new ShapedOreRecipe(items.onyxDoorItem,
						"XX", "XX", "XX", 'X', ONYX));
			
		//Tool Recipes
			//Copper Tool Recipes
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.copperPick,
						"XXX", " Y ", " Y ", 'X', COPPER, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.copperAxe,
						"XX ", "XY ", " Y ", 'X', COPPER, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.copperShovel,
						"X", "Y", "Y", 'X', COPPER, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.copperSword,
						"X", "X", "Y", 'X', COPPER, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.copperHoe,
						"XX ", " Y ", " Y ", 'X', COPPER, 'Y', STICK));
				
			//Tin Tool Recipes
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.tinPick,
						"XXX", " Y ", " Y ", 'X', TIN, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.tinAxe,
						"XX ", "XY ", " Y ", 'X', TIN, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.tinShovel,
						"X", "Y", "Y", 'X', TIN, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.tinSword,
						"X", "X", "Y", 'X', TIN, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.tinHoe,
						"XX ", " Y ", " Y ", 'X', TIN, 'Y', STICK));
				
			//Mythril Tool Recipes
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.mythrilPick,
						"XXX", " Y ", " Y ", 'X', MYTHRIL, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.mythrilAxe,
						"XX ", "XY ", " Y ", 'X', MYTHRIL, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.mythrilShovel,
						"X", "Y", "Y", 'X', MYTHRIL, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.mythrilSword,
						"X", "X", "Y", 'X', MYTHRIL, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.mythrilHoe,
						"XX ", " Y ", " Y ", 'X', MYTHRIL, 'Y', STICK));
				
			//Adamantium Tool Recipes
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.adamantiumPick,
						"XXX", " Y ", " Y ", 'X', ADAMANTIUM, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.adamantiumAxe,
						"XX ", "XY ", " Y ", 'X', ADAMANTIUM, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.adamantiumShovel,
						"X", "Y", "Y", 'X', ADAMANTIUM, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.adamantiumSword,
						"X", "X", "Y", 'X', ADAMANTIUM, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.adamantiumHoe,
						"XX ", " Y ", " Y ", 'X', ADAMANTIUM, 'Y', STICK));
				
			//Onyx Tool Recipes
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.onyxPick,
						"XXX", " Y ", " Y ", 'X', ONYX, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.onyxAxe,
						"XX ", "XY ", " Y ", 'X', ONYX, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.onyxShovel,
						"X", "Y", "Y", 'X', ONYX, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.onyxSword,
						"X", "X", "Y", 'X', ONYX, 'Y', STICK));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.onyxHoe,
						"XX ", " Y ", " Y ", 'X', ONYX, 'Y', STICK));
				
			//Bow Recipes
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.mythrilBow,
						" XY", "Z Y", " XY", 'X', items.mythrilRod, 'Y', Item.silk, 'Z', Item.ingotIron));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.onyxBow,
						" XY", "ZWY", " XY", 'X', items.onyxRod, 'Y', Item.silk, 'Z', Item.diamond, 'W', Item.flintAndSteel));
				
			//Shears Recipes
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.tinShears,
						"X ", " X", 'X', TIN));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.adamantiumShears,
						"X ", " X", 'X', ADAMANTIUM));
				GameRegistry.addRecipe(new ShapedOreRecipe(tools.onyxShears,
						"X ", " X", 'X', ONYX));
				
		//Armour Recipes
			//Copper Armour Recipes
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.copperHelm,
						"XXX", "X X", 'X', COPPER));
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.copperChest,
						"X X", "XXX", "XXX", 'X', COPPER));
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.copperLegs,
						"XXX", "X X", "X X", 'X', COPPER));
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.copperBoots,
						"X X", "X X", 'X', COPPER));
				
			//Tin Armour Recipes
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.tinHelm,
						"XXX", "X X", 'X', TIN));
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.tinChest,
						"X X", "XXX", "XXX", 'X', TIN));
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.tinLegs,
						"XXX", "X X", "X X", 'X', TIN));
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.tinBoots,
						"X X", "X X", 'X', TIN));
				
			//Mythril Armour Recipes
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.mythrilHelm,
						"XXX", "X X", 'X', MYTHRIL));
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.mythrilChest,
						"X X", "XXX", "XXX", 'X', MYTHRIL));
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.mythrilLegs,
						"XXX", "X X", "X X", 'X', MYTHRIL));
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.mythrilBoots,
						"X X", "X X", 'X', MYTHRIL));
				
			//Adamantium Armour Recipes
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.adamantiumHelm,
						"XXX", "X X", 'X', ADAMANTIUM));
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.adamantiumChest,
						"X X", "XXX", "XXX", 'X', ADAMANTIUM));
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.adamantiumLegs,
						"XXX", "X X", "X X", 'X', ADAMANTIUM));
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.adamantiumBoots,
						"X X", "X X", 'X', ADAMANTIUM));
				
			//Onyx Armour Recipes
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.onyxHelm,
						"XXX", "X X", 'X', ONYX));
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.onyxChest,
						"X X", "XXX", "XXX", 'X', ONYX));
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.onyxLegs,
						"XXX", "X X", "X X", 'X', ONYX));
				GameRegistry.addRecipe(new ShapedOreRecipe(armor.onyxBoots,
						"X X", "X X", 'X', ONYX));
				
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
