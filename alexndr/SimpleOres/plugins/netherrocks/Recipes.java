package alexndr.SimpleOres.plugins.netherrocks;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
		try{doOreDictRecipes(); LogHelper.verboseInfo("Netherrocks Plugin: All OreDictionary entries were added successfully.");}
		catch(Exception e){LogHelper.severe("Netherrocks Plugin: OreDictionary entries were not added successfully. This is a serious problem!"); e.printStackTrace();}
	}
	
	public static void initialize()
	{
		try{doRecipes(); LogHelper.verboseInfo("Netherrocks Plugin: All recipes were added successfully.");}
		catch(Exception e){LogHelper.severe("Netherrocks Plugin: Recipes were not added successfully. This is a serious problem!"); e.printStackTrace();}
	}
	
	public static void doOreDictRecipes()
	{
		OreDictionary.registerOre("oreFyrite", new ItemStack(Content.fyrite_ore));
		OreDictionary.registerOre("oreMalachite", new ItemStack(Content.malachite_ore));
		OreDictionary.registerOre("oreAshstone", new ItemStack(Content.ashstone_ore));
		OreDictionary.registerOre("oreIllumenite", new ItemStack(Content.illumenite_ore));
		OreDictionary.registerOre("oreDragonstone", new ItemStack(Content.dragonstone_ore));
		OreDictionary.registerOre("oreArgonite", new ItemStack(Content.argonite_ore));
		OreDictionary.registerOre("blockFyrite", new ItemStack(Content.fyrite_block));
		OreDictionary.registerOre("blockMalachite", new ItemStack(Content.malachite_block));
		OreDictionary.registerOre("blockAshstone", new ItemStack(Content.ashstone_block));
		OreDictionary.registerOre("blockIllumenite", new ItemStack(Content.illumenite_block));
		OreDictionary.registerOre("blockDragonstone", new ItemStack(Content.dragonstone_block));
		OreDictionary.registerOre("blockArgonite", new ItemStack(Content.argonite_block));
		OreDictionary.registerOre("ingotFyrite", new ItemStack(Content.fyrite_ingot));
		OreDictionary.registerOre("ingotMalachite", new ItemStack(Content.malachite_ingot));
		OreDictionary.registerOre("gemAshstone", new ItemStack(Content.ashstone_gem));
		OreDictionary.registerOre("ingotIllumenite", new ItemStack(Content.illumenite_ingot));
		OreDictionary.registerOre("gemDragonstone", new ItemStack(Content.dragonstone_gem));
		OreDictionary.registerOre("ingotArgonite", new ItemStack(Content.argonite_ingot));
	}
	
	public static void doRecipes()
	{
		//Block Recipes
		GameRegistry.addRecipe(new ItemStack(Content.fyrite_block, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Content.fyrite_ingot});
		GameRegistry.addRecipe(new ItemStack(Content.malachite_block, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Content.malachite_ingot});
		GameRegistry.addRecipe(new ItemStack(Content.ashstone_block, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Content.ashstone_gem});
		GameRegistry.addRecipe(new ItemStack(Content.illumenite_block, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Content.illumenite_ingot});
		GameRegistry.addRecipe(new ItemStack(Content.dragonstone_block, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Content.dragonstone_gem});		
		GameRegistry.addRecipe(new ItemStack(Content.argonite_block, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Content.argonite_ingot});		
		GameRegistry.addRecipe(new ItemStack(Content.nether_furnace, 1), new Object [] {
			"XXX", "XYX", "XXX", Character.valueOf('X'), Blocks.netherrack, Character.valueOf('Y'), Items.flint_and_steel});
				
		//Item Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Content.fyrite_ingot, 9), new Object[] { 
			Content.fyrite_block});
		GameRegistry.addShapelessRecipe(new ItemStack(Content.malachite_ingot, 9), new Object[] { 
			Content.malachite_block});
		GameRegistry.addShapelessRecipe(new ItemStack(Content.ashstone_gem, 9), new Object[] { 
			Content.ashstone_block});
		GameRegistry.addShapelessRecipe(new ItemStack(Content.illumenite_ingot, 9), new Object[] { 
			Content.illumenite_block});
		GameRegistry.addShapelessRecipe(new ItemStack(Content.dragonstone_gem, 9), new Object[] { 
			Content.dragonstone_block});
		GameRegistry.addShapelessRecipe(new ItemStack(Content.argonite_ingot, 9), new Object[] { 
			Content.argonite_block});
					
		//Tool Recipes
			//Malachite Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.malachite_pickaxe, true, new Object[]{
				"XXX", " Y ", " Y ", Character.valueOf('X'), Content.malachite_ingot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.malachite_axe, true, new Object [] {
				"XX ", "XY ", " Y ", Character.valueOf('X'), Content.malachite_ingot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.malachite_shovel, true, new Object [] {
				"X", "Y", "Y", Character.valueOf('X'), Content.malachite_ingot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.malachite_sword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Content.malachite_ingot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.malachite_hoe, true, new Object [] {
				"XX ", " Y ", " Y ", Character.valueOf('X'), Content.malachite_ingot, Character.valueOf('Y'), "stickWood"}));
					
			//Ashstone Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.ashstone_pickaxe, true, new Object [] {
				"XXX", " Y ", " Y ", Character.valueOf('X'), Content.ashstone_gem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.ashstone_axe, true, new Object [] {
				"XX ", "XY ", " Y ", Character.valueOf('X'), Content.ashstone_gem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.ashstone_shovel, true, new Object [] {
				"X", "Y", "Y", Character.valueOf('X'), Content.ashstone_gem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.ashstone_sword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Content.ashstone_gem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.ashstone_hoe, true, new Object [] {
				"XX ", " Y ", " Y ", Character.valueOf('X'), Content.ashstone_gem, Character.valueOf('Y'), "stickWood"}));
					
			//Dragonstone Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.dragonstone_pickaxe, true, new Object [] {
				"XXX", " Y ", " Y ", Character.valueOf('X'), Content.dragonstone_gem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.dragonstone_axe, true, new Object [] {
				"XX ", "XY ", " Y ", Character.valueOf('X'), Content.dragonstone_gem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.dragonstone_shovel, true, new Object [] {
				"X", "Y", "Y", Character.valueOf('X'), Content.dragonstone_gem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.dragonstone_sword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Content.dragonstone_gem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.dragonstone_hoe, true, new Object [] {
				"XX ", " Y ", " Y ", Character.valueOf('X'), Content.dragonstone_gem, Character.valueOf('Y'), "stickWood"}));
					
			//Argonite Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.argonite_pickaxe, true, new Object [] {
				"XXX", " Y ", " Y ", Character.valueOf('X'), Content.argonite_ingot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.argonite_axe, true, new Object [] {
				"XX ", "XY ", " Y ", Character.valueOf('X'), Content.argonite_ingot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.argonite_shovel, true, new Object [] {
				"X", "Y", "Y", Character.valueOf('X'), Content.argonite_ingot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.argonite_sword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Content.argonite_ingot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.argonite_hoe, true, new Object [] {
				"XX ", " Y ", " Y ", Character.valueOf('X'), Content.argonite_ingot, Character.valueOf('Y'), "stickWood"}));
					
			//Special Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.fyrite_sword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Content.fyrite_ingot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.illumenite_sword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Content.illumenite_ingot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.fyrite_pickaxe, true, new Object [] {
				"XXX", " Y ", " Y ", Character.valueOf('X'), Content.fyrite_ingot, Character.valueOf('Y'), "stickWood"}));
					
		//Armor Recipes
			//Fyrite Armor Recipes
			GameRegistry.addRecipe(new ItemStack(Content.fyrite_helmet, 1), new Object [] {
				"XXX", "X X", Character.valueOf('X'), Content.fyrite_ingot});
			GameRegistry.addRecipe(new ItemStack(Content.fyrite_chestplate, 1), new Object [] {
				"X X", "XXX", "XXX", Character.valueOf('X'), Content.fyrite_ingot});
			GameRegistry.addRecipe(new ItemStack(Content.fyrite_leggings, 1), new Object [] {
				"XXX", "X X", "X X", Character.valueOf('X'), Content.fyrite_ingot});
			GameRegistry.addRecipe(new ItemStack(Content.fyrite_boots, 1), new Object [] {
				"X X", "X X", Character.valueOf('X'), Content.fyrite_ingot});
					
			//Malachite Armor Recipes
			GameRegistry.addRecipe(new ItemStack(Content.malachite_helmet, 1), new Object [] {
				"XXX", "X X", Character.valueOf('X'), Content.malachite_ingot});
			GameRegistry.addRecipe(new ItemStack(Content.malachite_chestplate, 1), new Object [] {
				"X X", "XXX", "XXX", Character.valueOf('X'), Content.malachite_ingot});
			GameRegistry.addRecipe(new ItemStack(Content.malachite_leggings, 1), new Object [] {
				"XXX", "X X", "X X", Character.valueOf('X'), Content.malachite_ingot});
			GameRegistry.addRecipe(new ItemStack(Content.malachite_boots, 1), new Object [] {
				"X X", "X X", Character.valueOf('X'), Content.malachite_ingot});
					
			//Illumenite Armor Recipes
			GameRegistry.addRecipe(new ItemStack(Content.illumenite_helmet, 1), new Object [] {
				"XXX", "X X", Character.valueOf('X'), Content.illumenite_ingot});
			GameRegistry.addRecipe(new ItemStack(Content.illumenite_chestplate, 1), new Object [] {
				"X X", "XXX", "XXX", Character.valueOf('X'), Content.illumenite_ingot});
			GameRegistry.addRecipe(new ItemStack(Content.illumenite_leggings, 1), new Object [] {
				"XXX", "X X", "X X", Character.valueOf('X'), Content.illumenite_ingot});
			GameRegistry.addRecipe(new ItemStack(Content.illumenite_boots, 1), new Object [] {
				"X X", "X X", Character.valueOf('X'), Content.illumenite_ingot});
					
			//Dragonstone Armor Recipes
			GameRegistry.addRecipe(new ItemStack(Content.dragonstone_helmet, 1), new Object [] {
				"XXX", "X X", Character.valueOf('X'), Content.dragonstone_gem});
			GameRegistry.addRecipe(new ItemStack(Content.dragonstone_chestplate, 1), new Object [] {
				"X X", "XXX", "XXX", Character.valueOf('X'), Content.dragonstone_gem});
			GameRegistry.addRecipe(new ItemStack(Content.dragonstone_leggings, 1), new Object [] {
				"XXX", "X X", "X X", Character.valueOf('X'), Content.dragonstone_gem});
			GameRegistry.addRecipe(new ItemStack(Content.dragonstone_boots, 1), new Object [] {
				"X X", "X X", Character.valueOf('X'), Content.dragonstone_gem});
					
		//Furnace Recipes
		GameRegistry.addSmelting(Content.fyrite_ore, new ItemStack(Content.fyrite_ingot, 1, 0), 0.8F);
		GameRegistry.addSmelting(Content.malachite_ore, new ItemStack(Content.malachite_ingot, 1, 0), 0.5F);
		GameRegistry.addSmelting(Content.ashstone_ore, new ItemStack(Content.ashstone_gem, 1, 0), 0.8F);
		GameRegistry.addSmelting(Content.illumenite_ore, new ItemStack(Content.illumenite_ingot, 1, 0), 0.8F);
		GameRegistry.addSmelting(Content.argonite_ore, new ItemStack(Content.argonite_ingot, 1, 0), 0.7F);
		GameRegistry.addSmelting(Content.dragonstone_ore, new ItemStack(Content.dragonstone_gem, 1, 0), 1.0F);
	}
}
