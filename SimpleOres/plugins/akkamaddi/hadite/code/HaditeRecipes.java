package SimpleOres.plugins.akkamaddi.hadite.code;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;
import SimpleOres.plugins.akkamaddi.hadite.code.HaditeCoalCore;
import SimpleOres.plugins.fusion.FusionRecipes;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import SimpleOres.core.Armor;
import SimpleOres.core.Tools;
import SimpleOres.core.Items;


public class HaditeRecipes {

	// variables
    public static SimpleOres.core.Blocks soBlocks;
    public static SimpleOres.core.Tools soTools;
    public static SimpleOres.core.Armor soArmor;
    public static SimpleOres.core.Items soItems;

	public static void doHaditeRecipes(){
		

		// Ore Dictionary registry
		OreDictionary.registerOre("ingotHaditeCoal", new ItemStack(HaditeCoalCore.haditeCoalIngot));

	    // wildcard
	    final int WILDCARD_VALUE = OreDictionary.WILDCARD_VALUE;
	    
		// Crafting recipes
		//Storage Block
        GameRegistry.addRecipe(new ItemStack(HaditeCoalCore.blockHaditeCoalBlock, 1), new Object[] {"AAA", "AAA", "AAA", 'A', HaditeCoalCore.haditeCoalIngot});

	    //Item Recipe
		
		//Ingot Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(HaditeCoalCore.haditeCoalIngot, 9), new Object[] { 
			HaditeCoalCore.blockHaditeCoalBlock });		
		
		// Fusion Furnace recipes
		FusionRecipes.smelting().addSmelting(new ItemStack(Item.flint), new ItemStack(HaditeCoalCore.haditeCoalIngot), new ItemStack(Item.coal, 1, WILDCARD_VALUE), new ItemStack(Item.gunpowder), 6.0F);
		//FusionRecipes.smelting().addSmelting(new ItemStack(Item.flint), new ItemStack(HaditeCoalCore.haditeCoalIngot), new ItemStack(Item.coal, 1, 0), new ItemStack(Item.gunpowder), 6.0F);
	    
		// torches
		
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Block.torchWood, 64), true, new Object[]{
			"YYY", "YXY", "YYY", Character.valueOf('X'), "ingotHaditeCoal", Character.valueOf('Y'), "stickWood"}));
		
		// Supplemental recycling
        // recycle your Onyx
        FusionRecipes.smelting().addSmelting(new ItemStack(soArmor.onyxHelm, 1, WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(HaditeCoalCore.haditeCoalIngot), new ItemStack(soItems.onyxGem), 20.0F);
        FusionRecipes.smelting().addSmelting(new ItemStack(soArmor.onyxChest, 1, WILDCARD_VALUE),new ItemStack(Block.netherrack, 2, 0), new ItemStack(HaditeCoalCore.haditeCoalIngot, 2, 0), new ItemStack(soItems.onyxGem, 2, 0), 40.0F);
        FusionRecipes.smelting().addSmelting(new ItemStack(soArmor.onyxLegs, 1, WILDCARD_VALUE), new ItemStack(Block.netherrack, 2, 0), new ItemStack(HaditeCoalCore.haditeCoalIngot, 2, 0), new ItemStack(soItems.onyxGem, 2, 0), 40.0F);
        FusionRecipes.smelting().addSmelting(new ItemStack(soArmor.onyxBoots, 1, WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(HaditeCoalCore.haditeCoalIngot), new ItemStack(soItems.onyxGem), 20.0F);
        FusionRecipes.smelting().addSmelting(new ItemStack(soTools.onyxSword, 1, WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(HaditeCoalCore.haditeCoalIngot), new ItemStack(soItems.onyxGem), 20.0F);
        FusionRecipes.smelting().addSmelting(new ItemStack(soTools.onyxShovel, 1, WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(HaditeCoalCore.haditeCoalIngot), new ItemStack(soItems.onyxGem), 20.0F);
        FusionRecipes.smelting().addSmelting(new ItemStack(soTools.onyxPick, 1, WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(HaditeCoalCore.haditeCoalIngot), new ItemStack(soItems.onyxGem), 20.0F);
        FusionRecipes.smelting().addSmelting(new ItemStack(soTools.onyxAxe, 1, WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(HaditeCoalCore.haditeCoalIngot), new ItemStack(soItems.onyxGem), 20.0F);
        FusionRecipes.smelting().addSmelting(new ItemStack(soTools.onyxHoe, 1, WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(HaditeCoalCore.haditeCoalIngot), new ItemStack(soItems.onyxGem), 20.0F);
        FusionRecipes.smelting().addSmelting(new ItemStack(soTools.onyxBow, 1, WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(HaditeCoalCore.haditeCoalIngot), new ItemStack(soItems.onyxGem), 20.0F);
        
        // extra Onyx recycling
        FusionRecipes.smelting().addSmelting(new ItemStack(soItems.onyxDoorItem, 1, WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(HaditeCoalCore.haditeCoalIngot), new ItemStack(soItems.onyxGem), 20.0F);
        FusionRecipes.smelting().addSmelting(new ItemStack(soItems.onyxRod, 1, WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(HaditeCoalCore.haditeCoalIngot), new ItemStack(soItems.onyxGem), 20.0F);
        FusionRecipes.smelting().addSmelting(new ItemStack(soTools.onyxShears, 1, WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(HaditeCoalCore.haditeCoalIngot), new ItemStack(soItems.onyxGem), 20.0F);
        FusionRecipes.smelting().addSmelting(new ItemStack(soBlocks.onyxFurnace, 1, WILDCARD_VALUE), new ItemStack(Block.netherrack), new ItemStack(HaditeCoalCore.haditeCoalIngot), new ItemStack(soItems.onyxGem, 2, 0), 40.0F);

		
	}

}
