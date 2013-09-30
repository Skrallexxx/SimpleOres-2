package SimpleOres.plugins.fusion;

import static SimpleOres.core.Recipes.ADAMANTIUM;
import static SimpleOres.core.Recipes.COPPER;
import static SimpleOres.core.Recipes.MYTHRIL;
import static SimpleOres.core.Recipes.ONYX;
import static SimpleOres.core.Recipes.STICK;
import static SimpleOres.core.Recipes.TIN;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import SimpleOres.plugins.fusion.FusionRecipes.Material;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes 
{
	/**
	 * The constructor for the recipes. This is called by the main mod class.
	 * This is where all the recipes are created, from tools and armor to block and smelting recipes.
	 * 
	 * Forge OreDictionary results are set here.
	 */
	public static final String BRONZE = "ingotBronze";
	public static final String THYRIUM = "ingotThyrium";
	public static final String SINISITE = "ingotSinisite";
	
	public static void doRecipes()
	{
		//Forge OreDictionary
		OreDictionary.registerOre(BRONZE, new ItemStack(Content.bronzeIngot));
		OreDictionary.registerOre(THYRIUM, new ItemStack(Content.thyriumIngot));
		OreDictionary.registerOre(SINISITE, new ItemStack(Content.sinisiteIngot));
		
		//Block Recipes
			//Storage Content
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.bronzeBlock,
				"XXX", "XXX", "XXX", 'X', BRONZE));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.thyriumBlock,
				"XXX", "XXX", "XXX", 'X', THYRIUM));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.sinisiteBlock,
				"XXX", "XXX", "XXX", 'X', SINISITE));
		
			//Special Furnace Recipes
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.fusionFurnace,
				"XWX", "ZYZ", "XWX", 'X', Block.brick, 'Y', Block.furnaceIdle, 'W', Item.coal, 'Z', Item.ingotIron));
			
		//Item Recipes
			//Ingot Recipes
			GameRegistry.addShapelessRecipe(new ItemStack(Content.bronzeIngot, 9),
				Content.bronzeBlock);
			GameRegistry.addShapelessRecipe(new ItemStack(Content.thyriumIngot, 9),
				Content.thyriumBlock);
			GameRegistry.addShapelessRecipe(new ItemStack(Content.sinisiteIngot, 9),
				Content.sinisiteBlock);
			
			//Bronze Ingot
			GameRegistry.addShapelessRecipe(new ItemStack(Content.largeBronzeChunk, 1), 
				Content.smallBronzeChunk, Content.smallBronzeChunk, Content.smallBronzeChunk, Content.smallBronzeChunk, Content.smallBronzeChunk);
			GameRegistry.addShapelessRecipe(new ItemStack(Content.largeBronzeChunk, 1), 
				Content.mediumBronzeChunk, Content.mediumBronzeChunk, Content.mediumBronzeChunk);
			
			//Thyrium Ingot
			GameRegistry.addShapelessRecipe(new ItemStack(Content.largeThyriumChunk, 1), 
				Content.smallThyriumChunk, Content.smallThyriumChunk, Content.smallThyriumChunk, Content.smallThyriumChunk, Content.smallThyriumChunk);
			GameRegistry.addShapelessRecipe(new ItemStack(Content.largeThyriumChunk, 1), 
				Content.mediumThyriumChunk, Content.mediumThyriumChunk, Content.mediumThyriumChunk);
			
			//Sinisite Ingot
			GameRegistry.addShapelessRecipe(new ItemStack(Content.largeSinisiteChunk, 1), 
				Content.smallSinisiteChunk, Content.smallSinisiteChunk, Content.smallSinisiteChunk, Content.smallSinisiteChunk, Content.smallSinisiteChunk);
			GameRegistry.addShapelessRecipe(new ItemStack(Content.largeSinisiteChunk, 1), 
				Content.mediumSinisiteChunk, Content.mediumSinisiteChunk, Content.mediumSinisiteChunk);
			
			//Rods
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.thyriumRod,
				"X", "X", 'X', THYRIUM));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.sinisiteRod,
				"X", "X", 'X', SINISITE));
			
		//Tool Recipes
			//Bronze Tool Recipes
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.bronzePick,
				"XXX", " Y ", " Y ", 'X', BRONZE, 'Y', STICK));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.bronzeAxe,
				"XX ", "XY ", " Y ", 'X', BRONZE, 'Y', STICK));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.bronzeShovel,
				"X", "Y", "Y", 'X', BRONZE, 'Y', STICK));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.bronzeSword,
				"X", "X", "Y", 'X', BRONZE, 'Y', STICK));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.bronzeHoe,
				"XX ", " Y ", " Y ", 'X', BRONZE, 'Y', STICK));
			
			//Thyrium Tool Recipes
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.thyriumPick,
				"XXX", " Y ", " Y ", 'X', THYRIUM, 'Y', STICK));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.thyriumAxe,
				"XX ", "XY ", " Y ", 'X', THYRIUM, 'Y', STICK));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.thyriumShovel,
				"X", "Y", "Y", 'X', THYRIUM, 'Y', STICK));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.thyriumSword,
				"X", "X", "Y", 'X', THYRIUM, 'Y', STICK));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.thyriumHoe,
				"XX ", " Y ", " Y ", 'X', THYRIUM, 'Y', STICK));
			
			//Sinisite Tool Recipes
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.sinisitePick,
				"XXX", " Y ", " Y ", 'X', SINISITE, 'Y', STICK));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.sinisiteAxe,
				"XX ", "XY ", " Y ", 'X', SINISITE, 'Y', STICK));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.sinisiteShovel,
				"X", "Y", "Y", 'X', SINISITE, 'Y', STICK));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.sinisiteSword,
				"X", "X", "Y", 'X', SINISITE, 'Y', STICK));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.sinisiteHoe,
				"XX ", " Y ", " Y ", 'X', SINISITE, 'Y', STICK));
			
			//Bow Recipes
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.thyriumBow,
				" XY", "Z Y", " XY", 'X', Content.thyriumRod, 'Y', Item.silk, 'Z', Item.ingotGold));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.sinisiteBow,
				" XY", "Z Y", " XY", 'X', Content.sinisiteRod, 'Y', Item.silk, 'Z', "gemOnyx"));
			
		//Armour Recipes
			//Bronze Armour Recipes
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.bronzeHelm,
				"XXX", "X X", 'X', BRONZE));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.bronzeChest,
				"X X", "XXX", "XXX", 'X', BRONZE));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.bronzeLegs,
				"XXX", "X X", "X X", 'X', BRONZE));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.bronzeBoots,
				"X X", "X X", 'X', BRONZE));
			
			//Thyrium Armour Recipes
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.thyriumHelm,
				"XXX", "X X", 'X', THYRIUM));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.thyriumChest,
				"X X", "XXX", "XXX", 'X', THYRIUM));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.thyriumLegs,
				"XXX", "X X", "X X", 'X', THYRIUM));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.thyriumBoots,
				"X X", "X X", 'X', THYRIUM));
			
			//Sinisite Armour Recipes
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.sinisiteHelm,
				"XXX", "X X", 'X', SINISITE));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.sinisiteChest,
				"X X", "XXX", "XXX", 'X', SINISITE));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.sinisiteLegs,
				"XXX", "X X", "X X", 'X', SINISITE));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.sinisiteBoots,
				"X X", "X X", 'X', SINISITE));
			
		//Smelting Recipes
			//Fusion Furnace
				//Bronze
		    	FusionRecipes.addSmelting(Material.of(COPPER), Material.of(TIN), Material.of(Item.dyePowder, 1, 15), new ItemStack(Content.smallBronzeChunk), 2.0F);
		    	FusionRecipes.addSmelting(Material.of(COPPER), Material.of(TIN), Material.of(Item.gunpowder), new ItemStack(Content.mediumBronzeChunk), 3.0F);
		    	FusionRecipes.addSmelting(Material.of(COPPER), Material.of(TIN), Material.of(Item.redstone), new ItemStack(Content.largeBronzeChunk), 10.0F);
		    	
		    	//Thyrium
		    	FusionRecipes.addSmelting(Material.of(MYTHRIL), Material.of(ADAMANTIUM), Material.of(Item.redstone), new ItemStack(Content.smallThyriumChunk), 6.0F);
		    	FusionRecipes.addSmelting(Material.of(MYTHRIL), Material.of(ADAMANTIUM), Material.of(Item.dyePowder, 1, 4), new ItemStack(Content.mediumThyriumChunk), 10.0F);
		    	FusionRecipes.addSmelting(Material.of(MYTHRIL), Material.of(ADAMANTIUM), Material.of(Item.glowstone), new ItemStack(Content.largeThyriumChunk), 30.0F);
		    	
		    	//Sinisite				    	
		    	FusionRecipes.addSmelting(Material.of(ONYX), Material.of(MYTHRIL), Material.of(Item.glowstone), new ItemStack(Content.smallSinisiteChunk), 12.0F);
		    	FusionRecipes.addSmelting(Material.of(ONYX), Material.of(MYTHRIL), Material.of(Item.blazePowder), new ItemStack(Content.mediumSinisiteChunk), 20.0F);
		    	FusionRecipes.addSmelting(Material.of(ONYX), Material.of(MYTHRIL), Material.of(Item.ghastTear), new ItemStack(Content.largeSinisiteChunk), 60.0F);
		    	
		    //Regular Furnace
				GameRegistry.addSmelting(Content.largeBronzeChunk.itemID, new ItemStack(Content.bronzeIngot, 1, 0), 0.3F);
				GameRegistry.addSmelting(Content.largeThyriumChunk.itemID, new ItemStack(Content.thyriumIngot, 1, 0), 0.6F);
				GameRegistry.addSmelting(Content.largeSinisiteChunk.itemID, new ItemStack(Content.sinisiteIngot, 1, 0), 1.0F);
	}
}
