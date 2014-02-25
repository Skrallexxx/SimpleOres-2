package alexndr.SimpleOres.core;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import alexndr.SimpleOres.api.helpers.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes 
{
	public static void preInitialize()
	{
		try{doOreDictRecipes(); LogHelper.verboseInfo("All OreDictionary entries were added successfully.");}
		catch(Exception e){LogHelper.severe("OreDictionary entries were not added successfully. This is a serious problem!"); e.printStackTrace();}
	}
	
	public static void initialize()
	{
		try{doRecipes(); LogHelper.verboseInfo("All recipes were added successfully.");}
		catch(Exception e){LogHelper.severe("Recipes were not added successfully. This is a serious problem!"); e.printStackTrace();}
	}
	
	public static void doOreDictRecipes()
	{
		//Forge OreDictionary
		OreDictionary.registerOre("oreCopper", new ItemStack(Content.copperOre));
		OreDictionary.registerOre("oreTin", new ItemStack(Content.tinOre));
		OreDictionary.registerOre("oreMythril", new ItemStack(Content.mythrilOre));
		OreDictionary.registerOre("oreMithril", new ItemStack(Content.mythrilOre));
		OreDictionary.registerOre("oreAdamantium", new ItemStack(Content.adamantiumOre));
		OreDictionary.registerOre("oreAdamantite", new ItemStack(Content.adamantiumOre));
		OreDictionary.registerOre("oreAdamantine", new ItemStack(Content.adamantiumOre));
		OreDictionary.registerOre("oreOnyx", new ItemStack(Content.onyxOre));
		OreDictionary.registerOre("ingotCopper", new ItemStack(Content.copperIngot));
		OreDictionary.registerOre("ingotTin", new ItemStack(Content.tinIngot));
		OreDictionary.registerOre("ingotMythril", new ItemStack(Content.mythrilIngot));
		OreDictionary.registerOre("ingotMithril", new ItemStack(Content.mythrilIngot));
		OreDictionary.registerOre("ingotAdamantium", new ItemStack(Content.adamantiumIngot));
		OreDictionary.registerOre("ingotAdamantite", new ItemStack(Content.adamantiumIngot));
		OreDictionary.registerOre("ingotAdamantine", new ItemStack(Content.adamantiumIngot));
		OreDictionary.registerOre("gemOnyx", new ItemStack(Content.onyxGem));
	}
	
	public static void doRecipes()
	{
		//Block Recipes
			//Storage Content
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.copperBlock, true, new Object[]{
				"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotCopper"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.tinBlock, true, new Object[]{
				"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotTin"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.mythrilBlock, true, new Object[]{
				"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotMythril"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.adamantiumBlock, true, new Object[]{
				"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotAdamantium"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.onyxBlock, true, new Object[]{
				"XXX", "XXX", "XXX", Character.valueOf('X'), "gemOnyx"}));
		
			//Special Furnace Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.mythrilFurnace, true, new Object[]{
				"XXX", "XYX", "XXX", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), Block.furnaceIdle}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.onyxFurnace, true, new Object[]{
				"XXX", "XYX", "XXX", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), Block.furnaceIdle}));
			
			//Bar Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Content.copperBars, 16), true, new Object[]{
				"XXX", "XXX", Character.valueOf('X'), "ingotCopper"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Content.tinBars, 16), true, new Object[]{
				"XXX", "XXX", Character.valueOf('X'), "ingotTin"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Content.mythrilBars, 16), true, new Object[]{
				"XXX", "XXX", Character.valueOf('X'), "ingotMythril"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Content.adamantiumBars, 16), true, new Object[]{
				"XXX", "XXX", Character.valueOf('X'), "ingotAdamantium"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Content.onyxBars, 16), true, new Object[]{
				"XXX", "XXX", Character.valueOf('X'), "gemOnyx"}));

		//Item Recipes
			//Ingot Recipes
			GameRegistry.addShapelessRecipe(new ItemStack(Content.copperIngot, 9), new Object[] { 
				Content.copperBlock });
			GameRegistry.addShapelessRecipe(new ItemStack(Content.tinIngot, 9), new Object[] { 
				Content.tinBlock });
			GameRegistry.addShapelessRecipe(new ItemStack(Content.mythrilIngot, 9), new Object[] { 
				Content.mythrilBlock });
			GameRegistry.addShapelessRecipe(new ItemStack(Content.adamantiumIngot, 9), new Object[] { 
				Content.adamantiumBlock });
			GameRegistry.addShapelessRecipe(new ItemStack(Content.onyxGem, 9), new Object[] { 
				Content.onyxBlock });
		
			//Bucket
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.copperBucket, true, new Object[]{
				"X X", " X ", Character.valueOf('X'), "ingotCopper"}));
		
			//Rods
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.mythrilRod, true, new Object[]{
				"X", "X", Character.valueOf('X'), "ingotMythril"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.onyxRod, true, new Object[]{
				"X", "X", Character.valueOf('X'), "gemOnyx"}));
			
			//Doors
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.copperDoorItem, true, new Object[]{
				"XX", "XX", "XX", Character.valueOf('X'), "ingotCopper"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.onyxDoorItem, true, new Object[]{
				"XX", "XX", "XX", Character.valueOf('X'), "gemOnyx"}));
		
		//Tool Recipes
			//Copper Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.copperPick, true, new Object[]{
				"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.copperAxe, true, new Object[]{
				"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.copperShovel, true, new Object[]{
				"X", "Y", "Y", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.copperSword, true, new Object[]{
				"X", "X", "Y", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.copperHoe, true, new Object[]{
				"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), "stickWood"}));
			
			//Tin Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.tinPick, true, new Object[]{
				"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.tinAxe, true, new Object[]{
				"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.tinShovel, true, new Object[]{
				"X", "Y", "Y", Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.tinSword, true, new Object[]{
				"X", "X", "Y", Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.tinHoe, true, new Object[]{
				"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), "stickWood"}));
			
			//Mythril Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.mythrilPick, true, new Object[]{
				"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.mythrilAxe, true, new Object[]{
				"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.mythrilShovel, true, new Object[]{
				"X", "Y", "Y", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.mythrilSword, true, new Object[]{
				"X", "X", "Y", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.mythrilHoe, true, new Object[]{
				"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), "stickWood"}));
			
			//Adamantium Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.adamantiumPick, true, new Object[]{
				"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.adamantiumAxe, true, new Object[]{
				"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.adamantiumShovel, true, new Object[]{
				"X", "Y", "Y", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.adamantiumSword, true, new Object[]{
				"X", "X", "Y", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.adamantiumHoe, true, new Object[]{
				"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), "stickWood"}));
			
			//Onyx Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.onyxPick, true, new Object[]{
				"XXX", " Y ", " Y ", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.onyxAxe, true, new Object[]{
				"XX ", "XY ", " Y ", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.onyxShovel, true, new Object[]{
				"X", "Y", "Y", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.onyxSword, true, new Object[]{
				"X", "X", "Y", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.onyxHoe, true, new Object[]{
				"XX ", " Y ", " Y ", Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood"}));
			
			//Bow Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.mythrilBow, true, new Object[]{
				" XY", "Z Y", " XY", Character.valueOf('X'), Content.mythrilRod, Character.valueOf('Y'), Item.silk, Character.valueOf('Z'), Item.ingotIron}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.onyxBow, true, new Object[]{
				" XY", "ZWY", " XY", Character.valueOf('X'), Content.onyxRod, Character.valueOf('Y'), Item.silk, Character.valueOf('Z'), Item.diamond, Character.valueOf('W'), Item.flintAndSteel}));
			
			//Shears Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.tinShears, true, new Object[]{
				"X ", " X", Character.valueOf('X'), "ingotTin"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.adamantiumShears, true, new Object[]{
				"X ", " X", Character.valueOf('X'), "ingotAdamantium"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.onyxShears, true, new Object[]{
				"X ", " X", Character.valueOf('X'), "gemOnyx"}));
			
		//Armour Recipes
			//Copper Armour Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.copperHelm, true, new Object[]{
				"XXX", "X X", Character.valueOf('X'), "ingotCopper"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.copperChest, true, new Object[]{
				"X X", "XXX", "XXX", Character.valueOf('X'), "ingotCopper"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.copperLegs, true, new Object[]{
				"XXX", "X X", "X X", Character.valueOf('X'), "ingotCopper"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.copperBoots, true, new Object[]{
				"X X", "X X", Character.valueOf('X'), "ingotCopper"}));
			
			//Tin Armour Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.tinHelm, true, new Object[]{
				"XXX", "X X", Character.valueOf('X'), "ingotTin"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.tinChest, true, new Object[]{
				"X X", "XXX", "XXX", Character.valueOf('X'), "ingotTin"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.tinLegs, true, new Object[]{
				"XXX", "X X", "X X", Character.valueOf('X'), "ingotTin"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.tinBoots, true, new Object[]{
				"X X", "X X", Character.valueOf('X'), "ingotTin"}));
			
			//Mythril Armour Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.mythrilHelm, true, new Object[]{
				"XXX", "X X", Character.valueOf('X'), "ingotMythril"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.mythrilChest, true, new Object[]{
				"X X", "XXX", "XXX", Character.valueOf('X'), "ingotMythril"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.mythrilLegs, true, new Object[]{
				"XXX", "X X", "X X", Character.valueOf('X'), "ingotMythril"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.mythrilBoots, true, new Object[]{
				"X X", "X X", Character.valueOf('X'), "ingotMythril"}));
			
			//Adamantium Armour Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.adamantiumHelm, true, new Object[]{
				"XXX", "X X", Character.valueOf('X'), "ingotAdamantium"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.adamantiumChest, true, new Object[]{
				"X X", "XXX", "XXX", Character.valueOf('X'), "ingotAdamantium"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.adamantiumLegs, true, new Object[]{
				"XXX", "X X", "X X", Character.valueOf('X'), "ingotAdamantium"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.adamantiumBoots, true, new Object[]{
				"X X", "X X", Character.valueOf('X'), "ingotAdamantium"}));
			
			//Onyx Armour Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.onyxHelm, true, new Object[]{
				"XXX", "X X", Character.valueOf('X'), "gemOnyx"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.onyxChest, true, new Object[]{
				"X X", "XXX", "XXX", Character.valueOf('X'), "gemOnyx"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.onyxLegs, true, new Object[]{
				"XXX", "X X", "X X", Character.valueOf('X'), "gemOnyx"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.onyxBoots, true, new Object[]{
				"X X", "X X", Character.valueOf('X'), "gemOnyx"}));
			
		//Smelting Recipes
			//Regular Furnace				
			GameRegistry.addSmelting(Content.copperBucket.itemID, new ItemStack(Content.copperIngot, 3, 0), 0.0F);
			GameRegistry.addSmelting(Content.copperOre.blockID, new ItemStack(Content.copperIngot, 1, 0), 0.7F);
			GameRegistry.addSmelting(Content.tinOre.blockID, new ItemStack(Content.tinIngot, 1, 0), 0.7F);
			GameRegistry.addSmelting(Content.mythrilOre.blockID, new ItemStack(Content.mythrilIngot, 1, 0), 0.9F);
			GameRegistry.addSmelting(Content.adamantiumOre.blockID, new ItemStack(Content.adamantiumIngot, 1, 0), 1.0F);
			GameRegistry.addSmelting(Content.onyxOre.blockID, new ItemStack(Content.onyxGem, 1, 0), 1.0F);	
	}
}
