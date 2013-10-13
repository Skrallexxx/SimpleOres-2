package SimpleOres.plugins.moreFusions;

import SimpleOres.core.SimpleOres;
import SimpleOres.plugins.fusion.FusionRecipes;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

//======================================= FORGE STUFF ====================================================
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "morefusions", name = "SimpleOres 2 More Fusions Plugin", version = "1.0.0", dependencies = "required-after:simpleores; required-after:simpleoresfusion")

public class MoreFusions 
{
	public static SimpleOres simpleores;
//======================================= CREATION =======================================================	
	/**
	 * EnumToolMaterial. In form ("NAME", mining level, max uses, speed, damage to entity, enchantability)
	 */
	public static EnumToolMaterial toolSteel = EnumHelper.addToolMaterial("STEEL", 2, 800, 8.0F, 3, 12);
	
    /**
     * EnumArmorMaterial. In form ("NAME", max damage (like uses, multiply by pieces for their max damage), new int[] {helmet defense, chestplate defense, leggings defense, boots defense}, enchantability)
     */
	public static EnumArmorMaterial armorSteel = EnumHelper.addArmorMaterial("STEEL", 22, new int[] {3, 5, 4, 3}, 12);
	
    /**
     * Creating the Armor Renderers. This is simply so you can see the armor texture when you wear it.
     */
	public static int rendererSteel;
	
	/**
	 * Called before the @Init function. I had to put most things in here for achievements to work. Probably a better way to do it.
	 */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
    	System.out.println("[SimpleOres] Loading SimpleOres 2 More Fusions Plugin...");
    	
    	/**
    	 * Calling the various parts of the mod. Moved to different files for neatness. Pretty self explanatory what they all are :P
    	 */
    	//Configuration
    	Config.doConfig(event);
    	
    	//Content
    	Content.doContent();
    	doRecipes();
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
        /**
         * Adds the armor textures when you wear it. Calls a method in the CommonProxy (which is overridden by ClientProxy) called addArmor, and inputs the name of the material.
         * This allows the game to recognise that texture files called copper_1, mythril_2, etc. are corresponding to that armor set.
         */
    	rendererSteel = simpleores.proxy.addArmor("steel");
    	
        /**
         * Adds the armor textures when you wear it. Calls a method in the CommonProxy (which is overridden by ClientProxy) called addArmor, and inputs the name of the material.
         * This allows the game to recognise that texture files called copper_1, mythril_2, etc. are corresponding to that armor set.
         */
    	toolSteel.customCraftingMaterial = Content.steelIngot;
    	armorSteel.customCraftingMaterial = Content.steelIngot;
    	
        /**
         * Simply prints to console the number of Fusion Furnace recipes that were loaded, then prints that all content was loaded successfully.
         */
    	System.out.println("[SimpleOres] SimpleOres 2 More Fusions Plugin loaded all content successfully.");
    }
    
    public void doRecipes()
    {
    	/**
    	 * Forge OreDictionary results are set here.
    	 */
		//Forge OreDictionary
    	OreDictionary.registerOre("ingotSteel", new ItemStack(Content.steelIngot));
    	
		//Block Recipes
			//Storage Blocks
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.steelBlock, true, new Object[]{
				"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotSteel"}));
			
		//Item Recipes
			//Ingot Recipes
			GameRegistry.addShapelessRecipe(new ItemStack(Content.steelIngot, 9), new Object[] { 
				Content.steelBlock });
			
			//Steel Ingot
			GameRegistry.addShapelessRecipe(new ItemStack(Content.steelChunkLarge, 1), new Object[] { 
				Content.steelChunkSmall, Content.steelChunkSmall, Content.steelChunkSmall, Content.steelChunkSmall, Content.steelChunkSmall });
			GameRegistry.addShapelessRecipe(new ItemStack(Content.steelChunkLarge, 1), new Object[] { 
				Content.steelChunkMedium, Content.steelChunkMedium, Content.steelChunkMedium });
			
		//Tool Recipes
			//Steel Tool Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.steelPick, true, new Object[]{
				"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotSteel", Character.valueOf('Y'), Item.stick}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.steelAxe, true, new Object[]{
				"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotSteel", Character.valueOf('Y'), Item.stick}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.steelShovel, true, new Object[]{
				"X", "Y", "Y", Character.valueOf('X'), "ingotSteel", Character.valueOf('Y'), Item.stick}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.steelSword, true, new Object[]{
				"X", "X", "Y", Character.valueOf('X'), "ingotSteel", Character.valueOf('Y'), Item.stick}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.steelHoe, true, new Object[]{
				"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotSteel", Character.valueOf('Y'), Item.stick}));
			
		//Armor Recipes
			//Steel Armor Recipes
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.steelHelm, true, new Object[]{
				"XXX", "X X", Character.valueOf('X'), "ingotSteel"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.steelChest, true, new Object[]{
				"X X", "XXX", "XXX", Character.valueOf('X'), "ingotSteel"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.steelLegs, true, new Object[]{
				"XXX", "X X", "X X", Character.valueOf('X'), "ingotSteel"}));
			CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Content.steelBoots, true, new Object[]{
				"X X", "X X", Character.valueOf('X'), "ingotSteel"}));
			
		//Smelting Recipes
			//Fusion Furnace
				//Steel
				FusionRecipes.smelting().addSmelting(new ItemStack(Item.ingotIron), new ItemStack(Item.coal), new ItemStack(Item.gunpowder), new ItemStack(Content.steelChunkSmall), 4.0F);
				FusionRecipes.smelting().addSmelting(new ItemStack(Item.ingotIron), new ItemStack(Item.coal), new ItemStack(Item.redstone), new ItemStack(Content.steelChunkMedium), 6.67F);
				FusionRecipes.smelting().addSmelting(new ItemStack(Item.ingotIron), new ItemStack(Item.coal), new ItemStack(Item.glowstone), new ItemStack(Content.steelChunkLarge), 20.0F);
				
			//Regular Furnace
				GameRegistry.addSmelting(Content.steelChunkLarge.itemID, new ItemStack(Content.steelIngot, 1, 0), 0.8F);
    }
}
