package SimpleOres.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes
{	
	/**
	 * The constructor for the recipes. This is called by the main mod class.
	 * This is where all the recipes are created, from tools and armor to block and smelting recipes.
	 * 
	 * Forge OreDictionary results are set here.
	 */
	public static void doRecipes()
	{
		//Forge OreDictionary
		OreDictionary.registerOre("oreCopper", new ItemStack(Blocks.copperOre));
		OreDictionary.registerOre("oreTin", new ItemStack(Blocks.tinOre));
		OreDictionary.registerOre("oreMythril", new ItemStack(Blocks.mythrilOre));
		OreDictionary.registerOre("oreAdamantium", new ItemStack(Blocks.adamantiumOre));
		OreDictionary.registerOre("oreOnyx", new ItemStack(Blocks.onyxOre));
		OreDictionary.registerOre("ingotCopper", new ItemStack(Items.copperIngot));
		OreDictionary.registerOre("ingotTin", new ItemStack(Items.tinIngot));
		OreDictionary.registerOre("ingotMythril", new ItemStack(Items.mythrilIngot));
		OreDictionary.registerOre("ingotAdamantium", new ItemStack(Items.adamantiumIngot));
		OreDictionary.registerOre("gemOnyx", new ItemStack(Items.onyxGem));
		
		//Block Recipes
			//Storage Blocks
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Blocks.copperBlock, true, new Object[]{
					"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotCopper"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Blocks.tinBlock, true, new Object[]{
					"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotTin"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Blocks.mythrilBlock, true, new Object[]{
					"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotMythril"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Blocks.adamantiumBlock, true, new Object[]{
					"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotAdamantium"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Blocks.onyxBlock, true, new Object[]{
					"XXX", "XXX", "XXX", Character.valueOf('X'), "gemOnyx"}));
			
			//Special Furnace Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Blocks.mythrilFurnace, true, new Object[]{
						"XXX", "XYX", "XXX", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), Block.furnaceIdle}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Blocks.onyxFurnace, true, new Object[]{
						"XXX", "XYX", "XXX", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), Block.furnaceIdle}));
				
			//Bar Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.copperBars, 16), true, new Object[]{
						"XXX", "XXX", Character.valueOf('X'), "ingotCopper"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.tinBars, 16), true, new Object[]{
						"XXX", "XXX", Character.valueOf('X'), "ingotTin"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.mythrilBars, 16), true, new Object[]{
						"XXX", "XXX", Character.valueOf('X'), "ingotMythril"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.adamantiumBars, 16), true, new Object[]{
						"XXX", "XXX", Character.valueOf('X'), "ingotAdamantium"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.onyxBars, 16), true, new Object[]{
						"XXX", "XXX", Character.valueOf('X'), "gemOnyx"}));
	
		//Item Recipes
			//Ingot Recipes
				GameRegistry.addShapelessRecipe(new ItemStack(Items.copperIngot, 9), new Object[] { 
					Blocks.copperBlock });
				GameRegistry.addShapelessRecipe(new ItemStack(Items.tinIngot, 9), new Object[] { 
					Blocks.tinBlock });
				GameRegistry.addShapelessRecipe(new ItemStack(Items.mythrilIngot, 9), new Object[] { 
					Blocks.mythrilBlock });
				GameRegistry.addShapelessRecipe(new ItemStack(Items.adamantiumIngot, 9), new Object[] { 
					Blocks.adamantiumBlock });
				GameRegistry.addShapelessRecipe(new ItemStack(Items.onyxGem, 9), new Object[] { 
					Blocks.onyxBlock });
			
			//Bucket
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Items.copperBucket, true, new Object[]{
						"X X", " X ", Character.valueOf('X'), "ingotCopper"}));
			
			//Rods
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Items.mythrilRod, true, new Object[]{
						"X", "X", Character.valueOf('X'), "ingotMythril"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Items.onyxRod, true, new Object[]{
						"X", "X", Character.valueOf('X'), "gemOnyx"}));
				
			//Doors
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Items.copperDoorItem, true, new Object[]{
						"XX", "XX", "XX", Character.valueOf('X'), "ingotCopper"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Items.onyxDoorItem, true, new Object[]{
						"XX", "XX", "XX", Character.valueOf('X'), "gemOnyx"}));
			
		//Tool Recipes
			//Copper Tool Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.copperPick, true, new Object[]{
						"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.copperAxe, true, new Object[]{
						"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.copperShovel, true, new Object[]{
						"X", "Y", "Y", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.copperSword, true, new Object[]{
						"X", "X", "Y", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.copperHoe, true, new Object[]{
						"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), "stickWood"}));
				
			//Tin Tool Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.tinPick, true, new Object[]{
						"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.tinAxe, true, new Object[]{
						"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.tinShovel, true, new Object[]{
						"X", "Y", "Y", Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.tinSword, true, new Object[]{
						"X", "X", "Y", Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.tinHoe, true, new Object[]{
						"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), "stickWood"}));
				
			//Mythril Tool Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.mythrilPick, true, new Object[]{
						"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.mythrilAxe, true, new Object[]{
						"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.mythrilShovel, true, new Object[]{
						"X", "Y", "Y", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.mythrilSword, true, new Object[]{
						"X", "X", "Y", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.mythrilHoe, true, new Object[]{
						"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), "stickWood"}));
				
			//Adamantium Tool Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.adamantiumPick, true, new Object[]{
						"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.adamantiumAxe, true, new Object[]{
						"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.adamantiumShovel, true, new Object[]{
						"X", "Y", "Y", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.adamantiumSword, true, new Object[]{
						"X", "X", "Y", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.adamantiumHoe, true, new Object[]{
						"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), "stickWood"}));
				
			//Onyx Tool Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.onyxPick, true, new Object[]{
						"XXX", " Y ", " Y ", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.onyxAxe, true, new Object[]{
						"XX ", "XY ", " Y ", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.onyxShovel, true, new Object[]{
						"X", "Y", "Y", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.onyxSword, true, new Object[]{
						"X", "X", "Y", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.onyxHoe, true, new Object[]{
						"XX ", " Y ", " Y ", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood"}));
				
			//Bow Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.mythrilBow, true, new Object[]{
						" XY", "Z Y", " XY", Character.valueOf('X'), Items.mythrilRod, Character.valueOf('Y'), Item.silk, Character.valueOf('Z'), Item.ingotIron}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.onyxBow, true, new Object[]{
						" XY", "ZWY", " XY", Character.valueOf('X'), Items.onyxRod, Character.valueOf('Y'), Item.silk, Character.valueOf('Z'), Item.diamond, Character.valueOf('W'), Item.flintAndSteel}));
				
			//Shears Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.tinShears, true, new Object[]{
						"X ", " X", Character.valueOf('X'), "ingotTin"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.adamantiumShears, true, new Object[]{
						"X ", " X", Character.valueOf('X'), "ingotAdamantium"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.onyxShears, true, new Object[]{
						"X ", " X", Character.valueOf('X'), "gemOnyx"}));
				
		//Armour Recipes
			//Copper Armour Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.copperHelm, true, new Object[]{
						"XXX", "X X", Character.valueOf('X'), "ingotCopper"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.copperChest, true, new Object[]{
						"X X", "XXX", "XXX", Character.valueOf('X'), "ingotCopper"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.copperLegs, true, new Object[]{
						"XXX", "X X", "X X", Character.valueOf('X'), "ingotCopper"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.copperBoots, true, new Object[]{
						"X X", "X X", Character.valueOf('X'), "ingotCopper"}));
				
			//Tin Armour Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.tinHelm, true, new Object[]{
						"XXX", "X X", Character.valueOf('X'), "ingotTin"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.tinChest, true, new Object[]{
						"X X", "XXX", "XXX", Character.valueOf('X'), "ingotTin"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.tinLegs, true, new Object[]{
						"XXX", "X X", "X X", Character.valueOf('X'), "ingotTin"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.tinBoots, true, new Object[]{
						"X X", "X X", Character.valueOf('X'), "ingotTin"}));
				
			//Mythril Armour Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.mythrilHelm, true, new Object[]{
						"XXX", "X X", Character.valueOf('X'), "ingotMythril"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.mythrilChest, true, new Object[]{
						"X X", "XXX", "XXX", Character.valueOf('X'), "ingotMythril"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.mythrilLegs, true, new Object[]{
						"XXX", "X X", "X X", Character.valueOf('X'), "ingotMythril"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.mythrilBoots, true, new Object[]{
						"X X", "X X", Character.valueOf('X'), "ingotMythril"}));
				
			//Adamantium Armour Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.adamantiumHelm, true, new Object[]{
						"XXX", "X X", Character.valueOf('X'), "ingotAdamantium"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.adamantiumChest, true, new Object[]{
						"X X", "XXX", "XXX", Character.valueOf('X'), "ingotAdamantium"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.adamantiumLegs, true, new Object[]{
						"XXX", "X X", "X X", Character.valueOf('X'), "ingotAdamantium"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.adamantiumBoots, true, new Object[]{
						"X X", "X X", Character.valueOf('X'), "ingotAdamantium"}));
				
			//Onyx Armour Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.onyxHelm, true, new Object[]{
						"XXX", "X X", Character.valueOf('X'), "gemOnyx"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.onyxChest, true, new Object[]{
						"X X", "XXX", "XXX", Character.valueOf('X'), "gemOnyx"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.onyxLegs, true, new Object[]{
						"XXX", "X X", "X X", Character.valueOf('X'), "gemOnyx"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Armor.onyxBoots, true, new Object[]{
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
