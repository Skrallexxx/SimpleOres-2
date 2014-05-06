package alexndr.SimpleOres.plugins.fusion;

import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import alexndr.SimpleOres.api.helpers.CoreHelper;
import alexndr.SimpleOres.api.helpers.LogHelper;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes 
{
	private static final int WILDCARD_VALUE = OreDictionary.WILDCARD_VALUE;
	
	public static void preInitialize()
	{
		try{doOreDictRecipes(); LogHelper.verboseInfo("Fusion Plugin: All OreDictionary entries were added successfully.");}
		catch(Exception e){LogHelper.severe("Fusion Plugin: OreDictionary entries were not added successfully. This is a serious problem!"); e.printStackTrace();}
	}
	
	public static void initialize()
	{
		try{doRecipes(); LogHelper.verboseInfo("Fusion Plugin: All recipes were added successfully.");}
		catch(Exception e){LogHelper.severe("Fusion Plugin: Recipes were not added successfully. This is a serious problem!"); e.printStackTrace();}
	}
	
	public static void postInitialize()
	{
		if(Settings.enableCustomFusionRecipes)
		{
			try{addCustomFusionRecipes(); LogHelper.verboseInfo("Fusion Plugin: All custom Fusion Furnace recipes (if any) were added successfully.");}
			catch(Exception e){LogHelper.severe("Fusion Plugin: Custom Fusion Furnace recipes (if any) were not added successfully. This is a serious problem!"); e.printStackTrace();}
		}
	}

	public static void doOreDictRecipes()
	{
		//Forge OreDictionary
		OreDictionary.registerOre("ingotBronze", new ItemStack(Content.bronze_ingot));
		OreDictionary.registerOre("ingotThyrium", new ItemStack(Content.thyrium_ingot));
		OreDictionary.registerOre("ingotSinisite", new ItemStack(Content.sinisite_ingot));
		OreDictionary.registerOre("blockBronze", new ItemStack(Content.bronze_block));
		OreDictionary.registerOre("blockThyrium", new ItemStack(Content.thyrium_block));
		OreDictionary.registerOre("blockSinisite", new ItemStack(Content.sinisite_block));
	}
	
	public static void doRecipes()
	{	
		//Block Recipes
			//Storage Content
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.bronze_block, true, new Object[]{
				"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotBronze"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.thyrium_block, true, new Object[]{
				"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotThyrium"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sinisite_block, true, new Object[]{
				"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotSinisite"}));
		
			//Special Furnace Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.fusion_furnace, true, new Object[]{
				"XWX", "ZYZ", "XWX", Character.valueOf('X'), Blocks.brick_block, Character.valueOf('Y'), Blocks.furnace, Character.valueOf('W'), Items.coal, Character.valueOf('Z'), Items.iron_ingot}));
			
		//Item Recipes
			//Ingot Recipes
			GameRegistry.addShapelessRecipe(new ItemStack(Content.bronze_ingot, 9), new Object[] { 
				Content.bronze_block });
			GameRegistry.addShapelessRecipe(new ItemStack(Content.thyrium_ingot, 9), new Object[] { 
				Content.thyrium_block });
			GameRegistry.addShapelessRecipe(new ItemStack(Content.sinisite_ingot, 9), new Object[] { 
				Content.sinisite_block });
			
			//Bronze Ingot
			GameRegistry.addShapelessRecipe(new ItemStack(Content.large_bronze_chunk, 1), new Object[] { 
				Content.small_bronze_chunk, Content.small_bronze_chunk, Content.small_bronze_chunk, Content.small_bronze_chunk, Content.small_bronze_chunk });
			GameRegistry.addShapelessRecipe(new ItemStack(Content.large_bronze_chunk, 1), new Object[] { 
				Content.medium_bronze_chunk, Content.medium_bronze_chunk, Content.medium_bronze_chunk });
			
			//Thyrium Ingot
			GameRegistry.addShapelessRecipe(new ItemStack(Content.large_thyrium_chunk, 1), new Object[] { 
				Content.small_thyrium_chunk, Content.small_thyrium_chunk, Content.small_thyrium_chunk, Content.small_thyrium_chunk, Content.small_thyrium_chunk });
			GameRegistry.addShapelessRecipe(new ItemStack(Content.large_thyrium_chunk, 1), new Object[] { 
				Content.medium_thyrium_chunk, Content.medium_thyrium_chunk, Content.medium_thyrium_chunk });
			
			//Sinisite Ingot
			GameRegistry.addShapelessRecipe(new ItemStack(Content.large_sinisite_chunk, 1), new Object[] { 
				Content.small_sinisite_chunk, Content.small_sinisite_chunk, Content.small_sinisite_chunk, Content.small_sinisite_chunk, Content.small_sinisite_chunk });
			GameRegistry.addShapelessRecipe(new ItemStack(Content.large_sinisite_chunk, 1), new Object[] { 
				Content.medium_sinisite_chunk, Content.medium_sinisite_chunk, Content.medium_sinisite_chunk });
			
			//Extra Chunk Recipes
			if(Settings.enableExtraChunkRecipes)
			{
				GameRegistry.addShapelessRecipe(new ItemStack(Content.large_bronze_chunk, 1), new Object[] { 
					Content.small_bronze_chunk, Content.small_bronze_chunk, Content.medium_bronze_chunk, Content.medium_bronze_chunk });
				GameRegistry.addShapelessRecipe(new ItemStack(Content.medium_bronze_chunk, 1), new Object[] { 
					Content.small_bronze_chunk, Content.small_bronze_chunk, Content.small_bronze_chunk});
				GameRegistry.addShapelessRecipe(new ItemStack(Content.medium_bronze_chunk, 2), new Object[] { 
					Content.large_bronze_chunk});
				GameRegistry.addShapelessRecipe(new ItemStack(Content.small_bronze_chunk, 2), new Object[] { 
					Content.medium_bronze_chunk});
				
				GameRegistry.addShapelessRecipe(new ItemStack(Content.large_thyrium_chunk, 1), new Object[] { 
					Content.small_thyrium_chunk, Content.small_thyrium_chunk, Content.medium_thyrium_chunk, Content.medium_thyrium_chunk });
				GameRegistry.addShapelessRecipe(new ItemStack(Content.medium_thyrium_chunk, 1), new Object[] { 
					Content.small_thyrium_chunk, Content.small_thyrium_chunk, Content.small_thyrium_chunk});
				GameRegistry.addShapelessRecipe(new ItemStack(Content.medium_thyrium_chunk, 2), new Object[] { 
					Content.large_thyrium_chunk});
				GameRegistry.addShapelessRecipe(new ItemStack(Content.small_thyrium_chunk, 2), new Object[] { 
					Content.medium_thyrium_chunk});
				
				GameRegistry.addShapelessRecipe(new ItemStack(Content.large_sinisite_chunk, 1), new Object[] { 
					Content.small_sinisite_chunk, Content.small_sinisite_chunk, Content.medium_sinisite_chunk, Content.medium_sinisite_chunk });
				GameRegistry.addShapelessRecipe(new ItemStack(Content.medium_sinisite_chunk, 1), new Object[] { 
					Content.small_sinisite_chunk, Content.small_sinisite_chunk, Content.small_sinisite_chunk});
				GameRegistry.addShapelessRecipe(new ItemStack(Content.medium_sinisite_chunk, 2), new Object[] { 
					Content.large_sinisite_chunk});
				GameRegistry.addShapelessRecipe(new ItemStack(Content.small_sinisite_chunk, 2), new Object[] { 
					Content.medium_sinisite_chunk});
			}
			
			//Rods
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.thyrium_rod, true, new Object[]{
				"X", "X", Character.valueOf('X'), "ingotThyrium"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sinisite_rod, true, new Object[]{
				"X", "X", Character.valueOf('X'), "ingotSinisite"}));
			
		//Tool Recipes
			//Bronze Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.bronze_pickaxe, true, new Object[]{
				"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.bronze_axe, true, new Object[]{
				"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.bronze_shovel, true, new Object[]{
				"X", "Y", "Y", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.bronze_sword, true, new Object[]{
				"X", "X", "Y", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.bronze_hoe, true, new Object[]{
				"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), "stickWood"}));
			
			//Thyrium Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.thyrium_pickaxe, true, new Object[]{
				"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotThyrium", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.thyrium_axe, true, new Object[]{
				"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotThyrium", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.thyrium_shovel, true, new Object[]{
				"X", "Y", "Y", Character.valueOf('X'), "ingotThyrium", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.thyrium_sword, true, new Object[]{
				"X", "X", "Y", Character.valueOf('X'), "ingotThyrium", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.thyrium_hoe, true, new Object[]{
				"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotThyrium", Character.valueOf('Y'), "stickWood"}));
			
			//Sinisite Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sinisite_pickaxe, true, new Object[]{
				"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotSinisite", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sinisite_axe, true, new Object[]{
				"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotSinisite", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sinisite_shovel, true, new Object[]{
				"X", "Y", "Y", Character.valueOf('X'), "ingotSinisite", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sinisite_sword, true, new Object[]{
				"X", "X", "Y", Character.valueOf('X'), "ingotSinisite", Character.valueOf('Y'), "stickWood"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sinisite_hoe, true, new Object[]{
				"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotSinisite", Character.valueOf('Y'), "stickWood"}));
			
			//Bow Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.thyrium_bow, true, new Object[]{
				" XY", "Z Y", " XY", Character.valueOf('X'), Content.thyrium_rod, Character.valueOf('Y'), Items.string, Character.valueOf('Z'), Items.gold_ingot}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sinisite_bow, true, new Object[]{
				" XY", "Z Y", " XY", Character.valueOf('X'), Content.sinisite_rod, Character.valueOf('Y'), Items.string, Character.valueOf('Z'), "gemOnyx"}));
			
		//Armour Recipes
			//Bronze Armour Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.bronze_helmet, true, new Object[]{
				"XXX", "X X", Character.valueOf('X'), "ingotBronze"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.bronze_chestplate, true, new Object[]{
				"X X", "XXX", "XXX", Character.valueOf('X'), "ingotBronze"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.bronze_leggings, true, new Object[]{
				"XXX", "X X", "X X", Character.valueOf('X'), "ingotBronze"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.bronze_boots, true, new Object[]{
				"X X", "X X", Character.valueOf('X'), "ingotBronze"}));
			
			//Thyrium Armour Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.thyrium_helmet, true, new Object[]{
				"XXX", "X X", Character.valueOf('X'), "ingotThyrium"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.thyrium_chestplate, true, new Object[]{
				"X X", "XXX", "XXX", Character.valueOf('X'), "ingotThyrium"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.thyrium_leggings, true, new Object[]{
				"XXX", "X X", "X X", Character.valueOf('X'), "ingotThyrium"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.thyrium_boots, true, new Object[]{
				"X X", "X X", Character.valueOf('X'), "ingotThyrium"}));
			
			//Sinisite Armour Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sinisite_helmet, true, new Object[]{
				"XXX", "X X", Character.valueOf('X'), "ingotSinisite"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sinisite_chestplate, true, new Object[]{
				"X X", "XXX", "XXX", Character.valueOf('X'), "ingotSinisite"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sinisite_leggings, true, new Object[]{
				"XXX", "X X", "X X", Character.valueOf('X'), "ingotSinisite"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.sinisite_boots, true, new Object[]{
				"X X", "X X", Character.valueOf('X'), "ingotSinisite"}));
			
		//Smelting Recipes
			//Fusion Furnace
				//Bronze
		    	FusionRecipes.addSmelting(new ItemStack(CoreHelper.coreContent.copper_ingot), new ItemStack(CoreHelper.coreContent.tin_ingot), new ItemStack(Items.dye, 1, 15), new ItemStack(Content.small_bronze_chunk), 2.0F);
		    	FusionRecipes.addSmelting(new ItemStack(CoreHelper.coreContent.copper_ingot), new ItemStack(CoreHelper.coreContent.tin_ingot), new ItemStack(Items.gunpowder), new ItemStack(Content.medium_bronze_chunk), 3.0F);
		    	FusionRecipes.addSmelting(new ItemStack(CoreHelper.coreContent.copper_ingot), new ItemStack(CoreHelper.coreContent.tin_ingot), new ItemStack(Items.redstone), new ItemStack(Content.large_bronze_chunk), 10.0F);
		    	
		    	//_thyrium
		    	FusionRecipes.addSmelting(new ItemStack(CoreHelper.coreContent.mythril_ingot), new ItemStack(CoreHelper.coreContent.adamantium_ingot), new ItemStack(Items.redstone), new ItemStack(Content.small_thyrium_chunk), 6.0F);
		    	FusionRecipes.addSmelting(new ItemStack(CoreHelper.coreContent.mythril_ingot), new ItemStack(CoreHelper.coreContent.adamantium_ingot), new ItemStack(Items.dye, 1, 4), new ItemStack(Content.medium_thyrium_chunk), 10.0F);
		    	FusionRecipes.addSmelting(new ItemStack(CoreHelper.coreContent.mythril_ingot), new ItemStack(CoreHelper.coreContent.adamantium_ingot), new ItemStack(Items.glowstone_dust), new ItemStack(Content.large_thyrium_chunk), 30.0F);
		    	
		    	//_sinisite				    	
		    	FusionRecipes.addSmelting(new ItemStack(CoreHelper.coreContent.onyx_gem), new ItemStack(CoreHelper.coreContent.mythril_ingot), new ItemStack(Items.glowstone_dust), new ItemStack(Content.small_sinisite_chunk), 12.0F);
		    	FusionRecipes.addSmelting(new ItemStack(CoreHelper.coreContent.onyx_gem), new ItemStack(CoreHelper.coreContent.mythril_ingot), new ItemStack(Items.blaze_powder), new ItemStack(Content.medium_sinisite_chunk), 20.0F);
		    	FusionRecipes.addSmelting(new ItemStack(CoreHelper.coreContent.onyx_gem), new ItemStack(CoreHelper.coreContent.mythril_ingot), new ItemStack(Items.ghast_tear), new ItemStack(Content.large_sinisite_chunk), 60.0F);
		    	
		    //Regular Furnace
				GameRegistry.addSmelting(Content.large_bronze_chunk, new ItemStack(Content.bronze_ingot, 1, 0), 0.3F);
				GameRegistry.addSmelting(Content.large_thyrium_chunk, new ItemStack(Content.thyrium_ingot, 1, 0), 0.6F);
				GameRegistry.addSmelting(Content.large_sinisite_chunk, new ItemStack(Content.sinisite_ingot, 1, 0), 1.0F);
	}
	
	public static void addCustomFusionRecipes()
	{	
		int recipeNum = Settings.recipeNum;
		
		if(recipeNum > 0)
		{
			for(int i = 0; i < recipeNum; i++)
			{
				String recipe = Settings.settings.get("Custom Fusion Recipes", "Custom Recipe #" + (i+1), new String()).getString();
				
				if(recipe != null)
				{
					List recipeParts = Lists.newArrayList(Splitter.on(',').trimResults().split(recipe));

					Item input1 = (Item) Item.itemRegistry.getObject(Lists.newArrayList(Splitter.on('@').split(recipeParts.get(0).toString())).get(0).toString());
					String meta1String = Lists.newArrayList(Splitter.on('#').split(Lists.newArrayList(Splitter.on('@').split(recipeParts.get(0).toString())).get(1).toString())).get(0).toString();
					int meta1 = meta1String.equals("ALL") ? WILDCARD_VALUE : Integer.parseInt(meta1String);
					int size1 = Integer.parseInt(Lists.newArrayList(Splitter.on('#').split(Lists.newArrayList(Splitter.on('@').split(recipeParts.get(0).toString())).get(1).toString())).get(1).toString());
					
					Item input2 = (Item) Item.itemRegistry.getObject(Lists.newArrayList(Splitter.on('@').split(recipeParts.get(1).toString())).get(0).toString());
					String meta2String = Lists.newArrayList(Splitter.on('#').split(Lists.newArrayList(Splitter.on('@').split(recipeParts.get(1).toString())).get(1).toString())).get(0).toString();
					int meta2 = meta2String.equals("ALL") ? WILDCARD_VALUE : Integer.parseInt(meta2String);
					int size2 = Integer.parseInt(Lists.newArrayList(Splitter.on('#').split(Lists.newArrayList(Splitter.on('@').split(recipeParts.get(1).toString())).get(1).toString())).get(1).toString());
					
					Item catalyst = (Item) Item.itemRegistry.getObject(Lists.newArrayList(Splitter.on('@').split(recipeParts.get(2).toString())).get(0).toString());
					String catalystMetaString = Lists.newArrayList(Splitter.on('#').split(Lists.newArrayList(Splitter.on('@').split(recipeParts.get(2).toString())).get(1).toString())).get(0).toString();
					int catalystMeta = catalystMetaString.equals("ALL") ? WILDCARD_VALUE : Integer.parseInt(catalystMetaString);
					int catalystSize = Integer.parseInt(Lists.newArrayList(Splitter.on('#').split(Lists.newArrayList(Splitter.on('@').split(recipeParts.get(2).toString())).get(1).toString())).get(1).toString());
					
					Item output = (Item) Item.itemRegistry.getObject(Lists.newArrayList(Splitter.on('@').split(recipeParts.get(3).toString())).get(0).toString());
					String outputMetaString = Lists.newArrayList(Splitter.on('#').split(Lists.newArrayList(Splitter.on('@').split(recipeParts.get(3).toString())).get(1).toString())).get(0).toString();
					int outputMeta = outputMetaString.equals("ALL") ? WILDCARD_VALUE : Integer.parseInt(outputMetaString);
					int outputSize = Integer.parseInt(Lists.newArrayList(Splitter.on('#').split(Lists.newArrayList(Splitter.on('@').split(recipeParts.get(3).toString())).get(1).toString())).get(1).toString());
					
					Float experience = (float) Double.parseDouble(recipeParts.get(4).toString());
					
					FusionRecipes.addSmelting(new ItemStack(input1, size1, meta1), new ItemStack(input2, size2, meta2), new ItemStack(catalyst, catalystSize, catalystMeta), new ItemStack(output, outputSize, outputMeta), experience);
				}
			}
		}
	}
}