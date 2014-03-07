package alexndr.SimpleOres.plugins.netherrocks;

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
		OreDictionary.registerOre("oreFyrite", new ItemStack(Content.fyriteOre));
		OreDictionary.registerOre("oreMalachite", new ItemStack(Content.malachiteOre));
		OreDictionary.registerOre("oreAshstone", new ItemStack(Content.ashstoneOre));
		OreDictionary.registerOre("oreIllumenite", new ItemStack(Content.illumeniteOre));
		OreDictionary.registerOre("oreDragonstone", new ItemStack(Content.dragonstoneOre));
		OreDictionary.registerOre("oreArgonite", new ItemStack(Content.argoniteOre));
		OreDictionary.registerOre("ingotFyrite", new ItemStack(Content.fyriteIngot));
		OreDictionary.registerOre("ingotMalachite", new ItemStack(Content.malachiteIngot));
		OreDictionary.registerOre("gemAshstone", new ItemStack(Content.ashstoneGem));
		OreDictionary.registerOre("ingotIllumenite", new ItemStack(Content.illumeniteIngot));
		OreDictionary.registerOre("gemDragonstone", new ItemStack(Content.dragonstoneGem));
		OreDictionary.registerOre("ingotArgonite", new ItemStack(Content.argoniteIngot));
	}
	
	public static void doRecipes()
	{
		//Block Recipes
		GameRegistry.addRecipe(new ItemStack(Content.fyriteBlock, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Content.fyriteIngot});
		GameRegistry.addRecipe(new ItemStack(Content.malachiteBlock, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Content.malachiteIngot});
		GameRegistry.addRecipe(new ItemStack(Content.ashstoneBlock, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Content.ashstoneGem});
		GameRegistry.addRecipe(new ItemStack(Content.illumeniteBlock, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Content.illumeniteIngot});
		GameRegistry.addRecipe(new ItemStack(Content.dragonstoneBlock, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Content.dragonstoneGem});		
		GameRegistry.addRecipe(new ItemStack(Content.argoniteBlock, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Content.argoniteIngot});		
		GameRegistry.addRecipe(new ItemStack(Content.netherFurnace, 1), new Object [] {
			"XXX", "XYX", "XXX", Character.valueOf('X'), Block.netherrack, Character.valueOf('Y'), Item.flintAndSteel});
				
		//Item Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Content.fyriteIngot, 9), new Object[] { 
			Content.fyriteBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(Content.malachiteIngot, 9), new Object[] { 
			Content.malachiteBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(Content.ashstoneGem, 9), new Object[] { 
			Content.ashstoneBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(Content.illumeniteIngot, 9), new Object[] { 
			Content.illumeniteBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(Content.dragonstoneGem, 9), new Object[] { 
			Content.dragonstoneBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(Content.argoniteIngot, 9), new Object[] { 
			Content.argoniteBlock});
					
		//Tool Recipes
			//Malachite Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.malachitePick, true, new Object[]{
				"XXX", " Y ", " Y ", Character.valueOf('X'), Content.malachiteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.malachiteAxe, true, new Object [] {
				"XX ", "XY ", " Y ", Character.valueOf('X'), Content.malachiteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.malachiteShovel, true, new Object [] {
				"X", "Y", "Y", Character.valueOf('X'), Content.malachiteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.malachiteSword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Content.malachiteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.malachiteHoe, true, new Object [] {
				"XX ", " Y ", " Y ", Character.valueOf('X'), Content.malachiteIngot, Character.valueOf('Y'), "stickWood"}));
					
			//Ashstone Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.ashstonePick, true, new Object [] {
				"XXX", " Y ", " Y ", Character.valueOf('X'), Content.ashstoneGem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.ashstoneAxe, true, new Object [] {
				"XX ", "XY ", " Y ", Character.valueOf('X'), Content.ashstoneGem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.ashstoneShovel, true, new Object [] {
				"X", "Y", "Y", Character.valueOf('X'), Content.ashstoneGem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.ashstoneSword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Content.ashstoneGem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.ashstoneHoe, true, new Object [] {
				"XX ", " Y ", " Y ", Character.valueOf('X'), Content.ashstoneGem, Character.valueOf('Y'), "stickWood"}));
					
			//Dragonstone Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.dragonstonePick, true, new Object [] {
				"XXX", " Y ", " Y ", Character.valueOf('X'), Content.dragonstoneGem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.dragonstoneAxe, true, new Object [] {
				"XX ", "XY ", " Y ", Character.valueOf('X'), Content.dragonstoneGem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.dragonstoneShovel, true, new Object [] {
				"X", "Y", "Y", Character.valueOf('X'), Content.dragonstoneGem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.dragonstoneSword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Content.dragonstoneGem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.dragonstoneHoe, true, new Object [] {
				"XX ", " Y ", " Y ", Character.valueOf('X'), Content.dragonstoneGem, Character.valueOf('Y'), "stickWood"}));
					
			//Argonite Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.argonitePick, true, new Object [] {
				"XXX", " Y ", " Y ", Character.valueOf('X'), Content.argoniteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.argoniteAxe, true, new Object [] {
				"XX ", "XY ", " Y ", Character.valueOf('X'), Content.argoniteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.argoniteShovel, true, new Object [] {
				"X", "Y", "Y", Character.valueOf('X'), Content.argoniteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.argoniteSword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Content.argoniteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.argoniteHoe, true, new Object [] {
				"XX ", " Y ", " Y ", Character.valueOf('X'), Content.argoniteIngot, Character.valueOf('Y'), "stickWood"}));
					
			//Special Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.fyriteSword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Content.fyriteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.illumeniteSword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Content.illumeniteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.fyritePick, true, new Object [] {
				"XXX", " Y ", " Y ", Character.valueOf('X'), Content.fyriteIngot, Character.valueOf('Y'), "stickWood"}));
					
		//Armor Recipes
			//Fyrite Armor Recipes
			GameRegistry.addRecipe(new ItemStack(Content.fyriteHelm, 1), new Object [] {
				"XXX", "X X", Character.valueOf('X'), Content.fyriteIngot});
			GameRegistry.addRecipe(new ItemStack(Content.fyriteChest, 1), new Object [] {
				"X X", "XXX", "XXX", Character.valueOf('X'), Content.fyriteIngot});
			GameRegistry.addRecipe(new ItemStack(Content.fyriteLegs, 1), new Object [] {
				"XXX", "X X", "X X", Character.valueOf('X'), Content.fyriteIngot});
			GameRegistry.addRecipe(new ItemStack(Content.fyriteBoots, 1), new Object [] {
				"X X", "X X", Character.valueOf('X'), Content.fyriteIngot});
					
			//Malachite Armor Recipes
			GameRegistry.addRecipe(new ItemStack(Content.malachiteHelm, 1), new Object [] {
				"XXX", "X X", Character.valueOf('X'), Content.malachiteIngot});
			GameRegistry.addRecipe(new ItemStack(Content.malachiteChest, 1), new Object [] {
				"X X", "XXX", "XXX", Character.valueOf('X'), Content.malachiteIngot});
			GameRegistry.addRecipe(new ItemStack(Content.malachiteLegs, 1), new Object [] {
				"XXX", "X X", "X X", Character.valueOf('X'), Content.malachiteIngot});
			GameRegistry.addRecipe(new ItemStack(Content.malachiteBoots, 1), new Object [] {
				"X X", "X X", Character.valueOf('X'), Content.malachiteIngot});
					
			//Illumenite Armor Recipes
			GameRegistry.addRecipe(new ItemStack(Content.illumeniteHelm, 1), new Object [] {
				"XXX", "X X", Character.valueOf('X'), Content.illumeniteIngot});
			GameRegistry.addRecipe(new ItemStack(Content.illumeniteChest, 1), new Object [] {
				"X X", "XXX", "XXX", Character.valueOf('X'), Content.illumeniteIngot});
			GameRegistry.addRecipe(new ItemStack(Content.illumeniteLegs, 1), new Object [] {
				"XXX", "X X", "X X", Character.valueOf('X'), Content.illumeniteIngot});
			GameRegistry.addRecipe(new ItemStack(Content.illumeniteBoots, 1), new Object [] {
				"X X", "X X", Character.valueOf('X'), Content.illumeniteIngot});
					
			//Dragonstone Armor Recipes
			GameRegistry.addRecipe(new ItemStack(Content.dragonstoneHelm, 1), new Object [] {
				"XXX", "X X", Character.valueOf('X'), Content.dragonstoneGem});
			GameRegistry.addRecipe(new ItemStack(Content.dragonstoneChest, 1), new Object [] {
				"X X", "XXX", "XXX", Character.valueOf('X'), Content.dragonstoneGem});
			GameRegistry.addRecipe(new ItemStack(Content.dragonstoneLegs, 1), new Object [] {
				"XXX", "X X", "X X", Character.valueOf('X'), Content.dragonstoneGem});
			GameRegistry.addRecipe(new ItemStack(Content.dragonstoneBoots, 1), new Object [] {
				"X X", "X X", Character.valueOf('X'), Content.dragonstoneGem});
					
		//Furnace Recipes
		GameRegistry.addSmelting(Content.fyriteOre.blockID, new ItemStack(Content.fyriteIngot, 1, 0), 0.8F);
		GameRegistry.addSmelting(Content.malachiteOre.blockID, new ItemStack(Content.malachiteIngot, 1, 0), 0.5F);
		GameRegistry.addSmelting(Content.ashstoneOre.blockID, new ItemStack(Content.ashstoneGem, 1, 0), 0.8F);
		GameRegistry.addSmelting(Content.illumeniteOre.blockID, new ItemStack(Content.illumeniteIngot, 1, 0), 0.8F);
		GameRegistry.addSmelting(Content.argoniteOre.blockID, new ItemStack(Content.argoniteIngot, 1, 0), 0.7F);
		GameRegistry.addSmelting(Content.dragonstoneOre.blockID, new ItemStack(Content.dragonstoneGem, 1, 0), 1.0F);
	}
}
