package SimpleOres.plugins.Netherrocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes 
{
	/**
	 * Adds all the Netherrocks recipes to the game.
	 * There are no OreDictionary entries because it is unlikely that they would need to be used in other mods.
	 * I may add OreDictionary entries at some stage.
	 */
	public static void doRecipes()
	{
		//Block Recipes
		GameRegistry.addRecipe(new ItemStack(Blocks.fyriteBlock, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Items.fyriteIngot});
		GameRegistry.addRecipe(new ItemStack(Blocks.malachiteBlock, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Items.malachiteIngot});
		GameRegistry.addRecipe(new ItemStack(Blocks.ashstoneBlock, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Items.ashstoneGem});
		GameRegistry.addRecipe(new ItemStack(Blocks.illumeniteBlock, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Items.illumeniteIngot});
		GameRegistry.addRecipe(new ItemStack(Blocks.dragonstoneBlock, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Items.dragonstoneGem});		
		GameRegistry.addRecipe(new ItemStack(Blocks.argoniteBlock, 1), new Object [] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), Items.argoniteIngot});		
		GameRegistry.addRecipe(new ItemStack(Blocks.netherFurnace, 1), new Object [] {
			"XXX", "XYX", "XXX", Character.valueOf('X'), Block.netherrack, Character.valueOf('Y'), Item.flintAndSteel});
		
		//Item Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Items.fyriteIngot, 9), new Object[] { 
			Blocks.fyriteBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.malachiteIngot, 9), new Object[] { 
			Blocks.malachiteBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.ashstoneGem, 9), new Object[] { 
			Blocks.ashstoneBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.illumeniteIngot, 9), new Object[] { 
			Blocks.illumeniteBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dragonstoneGem, 9), new Object[] { 
			Blocks.dragonstoneBlock});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.argoniteIngot, 9), new Object[] { 
			Blocks.argoniteBlock});
			
		//Tool Recipes
			//Malachite Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.malachitePick, true, new Object[]{
				"XXX", " Y ", " Y ", Character.valueOf('X'), Items.malachiteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.malachiteAxe, true, new Object [] {
				"XX ", "XY ", " Y ", Character.valueOf('X'), Items.malachiteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.malachiteShovel, true, new Object [] {
				"X", "Y", "Y", Character.valueOf('X'), Items.malachiteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.malachiteSword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Items.malachiteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.malachiteHoe, true, new Object [] {
				"XX ", " Y ", " Y ", Character.valueOf('X'), Items.malachiteIngot, Character.valueOf('Y'), "stickWood"}));
			
			//Ashstone Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.ashstonePick, true, new Object [] {
				"XXX", " Y ", " Y ", Character.valueOf('X'), Items.ashstoneGem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.ashstoneAxe, true, new Object [] {
				"XX ", "XY ", " Y ", Character.valueOf('X'), Items.ashstoneGem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.ashstoneShovel, true, new Object [] {
				"X", "Y", "Y", Character.valueOf('X'), Items.ashstoneGem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.ashstoneSword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Items.ashstoneGem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.ashstoneHoe, true, new Object [] {
				"XX ", " Y ", " Y ", Character.valueOf('X'), Items.ashstoneGem, Character.valueOf('Y'), "stickWood"}));
			
			//Dragonstone Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.dragonstonePick, true, new Object [] {
				"XXX", " Y ", " Y ", Character.valueOf('X'), Items.dragonstoneGem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.dragonstoneAxe, true, new Object [] {
				"XX ", "XY ", " Y ", Character.valueOf('X'), Items.dragonstoneGem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.dragonstoneShovel, true, new Object [] {
				"X", "Y", "Y", Character.valueOf('X'), Items.dragonstoneGem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.dragonstoneSword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Items.dragonstoneGem, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.dragonstoneHoe, true, new Object [] {
				"XX ", " Y ", " Y ", Character.valueOf('X'), Items.dragonstoneGem, Character.valueOf('Y'), "stickWood"}));
			
			//Argonite Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.argonitePick, true, new Object [] {
				"XXX", " Y ", " Y ", Character.valueOf('X'), Items.argoniteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.argoniteAxe, true, new Object [] {
				"XX ", "XY ", " Y ", Character.valueOf('X'), Items.argoniteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.argoniteShovel, true, new Object [] {
				"X", "Y", "Y", Character.valueOf('X'), Items.argoniteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.argoniteSword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Items.argoniteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.argoniteHoe, true, new Object [] {
				"XX ", " Y ", " Y ", Character.valueOf('X'), Items.argoniteIngot, Character.valueOf('Y'), "stickWood"}));
			
			//Special Sword Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.fyriteSword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Items.fyriteIngot, Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Tools.illumeniteSword, true, new Object [] {
				"X", "X", "Y", Character.valueOf('X'), Items.illumeniteIngot, Character.valueOf('Y'), "stickWood"}));
			
		//Armor Recipes
			//Fyrite Armor Recipes
			GameRegistry.addRecipe(new ItemStack(Armor.fyriteHelm, 1), new Object [] {
				"XXX", "X X", Character.valueOf('X'), Items.fyriteIngot});
			GameRegistry.addRecipe(new ItemStack(Armor.fyriteChest, 1), new Object [] {
				"X X", "XXX", "XXX", Character.valueOf('X'), Items.fyriteIngot});
			GameRegistry.addRecipe(new ItemStack(Armor.fyriteLegs, 1), new Object [] {
				"XXX", "X X", "X X", Character.valueOf('X'), Items.fyriteIngot});
			GameRegistry.addRecipe(new ItemStack(Armor.fyriteBoots, 1), new Object [] {
				"X X", "X X", Character.valueOf('X'), Items.fyriteIngot});
			
			//Malachite Armor Recipes
			GameRegistry.addRecipe(new ItemStack(Armor.malachiteHelm, 1), new Object [] {
				"XXX", "X X", Character.valueOf('X'), Items.malachiteIngot});
			GameRegistry.addRecipe(new ItemStack(Armor.malachiteChest, 1), new Object [] {
				"X X", "XXX", "XXX", Character.valueOf('X'), Items.malachiteIngot});
			GameRegistry.addRecipe(new ItemStack(Armor.malachiteLegs, 1), new Object [] {
				"XXX", "X X", "X X", Character.valueOf('X'), Items.malachiteIngot});
			GameRegistry.addRecipe(new ItemStack(Armor.malachiteBoots, 1), new Object [] {
				"X X", "X X", Character.valueOf('X'), Items.malachiteIngot});
			
			//Illumenite Armor Recipes
			GameRegistry.addRecipe(new ItemStack(Armor.illumeniteHelm, 1), new Object [] {
				"XXX", "X X", Character.valueOf('X'), Items.illumeniteIngot});
			GameRegistry.addRecipe(new ItemStack(Armor.illumeniteChest, 1), new Object [] {
				"X X", "XXX", "XXX", Character.valueOf('X'), Items.illumeniteIngot});
			GameRegistry.addRecipe(new ItemStack(Armor.illumeniteLegs, 1), new Object [] {
				"XXX", "X X", "X X", Character.valueOf('X'), Items.illumeniteIngot});
			GameRegistry.addRecipe(new ItemStack(Armor.illumeniteBoots, 1), new Object [] {
				"X X", "X X", Character.valueOf('X'), Items.illumeniteIngot});
			
			//Dragonstone Armor Recipes
			GameRegistry.addRecipe(new ItemStack(Armor.dragonstoneHelm, 1), new Object [] {
				"XXX", "X X", Character.valueOf('X'), Items.dragonstoneGem});
			GameRegistry.addRecipe(new ItemStack(Armor.dragonstoneChest, 1), new Object [] {
				"X X", "XXX", "XXX", Character.valueOf('X'), Items.dragonstoneGem});
			GameRegistry.addRecipe(new ItemStack(Armor.dragonstoneLegs, 1), new Object [] {
				"XXX", "X X", "X X", Character.valueOf('X'), Items.dragonstoneGem});
			GameRegistry.addRecipe(new ItemStack(Armor.dragonstoneBoots, 1), new Object [] {
				"X X", "X X", Character.valueOf('X'), Items.dragonstoneGem});
			
		//Furnace Recipes
		GameRegistry.addSmelting(Blocks.fyriteOre.blockID, new ItemStack(Items.fyriteIngot, 1, 0), 0.8F);
		GameRegistry.addSmelting(Blocks.malachiteOre.blockID, new ItemStack(Items.malachiteIngot, 1, 0), 0.5F);
		GameRegistry.addSmelting(Blocks.illumeniteOre.blockID, new ItemStack(Items.illumeniteIngot, 1, 0), 0.8F);
		GameRegistry.addSmelting(Blocks.argoniteOre.blockID, new ItemStack(Items.argoniteIngot, 1, 0), 0.7F);
	}
}
