package SimpleOres.plugins.fusion.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import SimpleOres.core.Achievements;
import SimpleOres.core.Armor;
import SimpleOres.core.Blocks;
import SimpleOres.core.Items;
import SimpleOres.core.Recipes;
import SimpleOres.core.SimpleOres;
import SimpleOres.core.Tools;
import SimpleOres.core.conf.IDs;
import SimpleOres.core.conf.Localisation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class FusionRecipes
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
    public static Tools tools;
    
    public static FurnaceRecipes furnaceRecipes;
    public static int size;
    
    private static final FusionRecipes smeltingBase = new FusionRecipes();

    /** The list of smelting and experience results. */
    private Map<String, ItemStack> recipeList = new HashMap<String, ItemStack>();
    private HashMap<List<Integer>, Float> experienceList = new HashMap<List<Integer>, Float>();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static FusionRecipes smelting()
    {
        return smeltingBase;
    }

    /**
     * Where recipes would normally be added to. Instead, recipes can be added from outside the class using FusionRecipes.smelting().addSmelting.
     * Recipes will be in format: this.addSmelting(input1.itemID, input2.itemID, catalyst.itemID, new ItemStack(output));
     * 
     * Only one recipe is needed for the two inputs, as input1 + input2 + catalyst = input2 + input1 + catalyst. 
     */
    private FusionRecipes()
    {

    }

    private String ingredientsToKey(ItemStack input1, ItemStack input2, ItemStack catalyst)
    {
        StringBuilder ingredients = new StringBuilder(32);

        String strInput1;
        String strInput2;
        String strInput3;

        if( input1!=null && input1.getItem()!=null ) {
            int oreId1 = OreDictionary.getOreID(input1);
            if( oreId1 > 0 )
                strInput1 = "d:" + oreId1;
            else
                strInput1 = "" + input1.getItem().itemID;
        }
        else {
            strInput1 = "null";
        }

        if( input2!=null && input2.getItem()!=null ) {
            int oreId2 = OreDictionary.getOreID(input2);
            if( oreId2 > 0 )
                strInput2 = "d:" + oreId2;
            else
                strInput2 = "" + input2.getItem().itemID;
        }
        else {
            strInput2 = "null";
        }

        if( catalyst!=null && catalyst.getItem()!=null ) {
            int oreId3 = OreDictionary.getOreID(catalyst);
            if( oreId3 > 0 )
                strInput3 = "d:" + oreId3;
            else
                strInput3 = "" + catalyst.getItem().itemID;
        }
        else {
            strInput3 = "null";
        }

        return ingredients
                .append(strInput1).append("%")
                .append(strInput2).append("%")
                .append(strInput3).toString();
    }
    
    /**
     * Adds the smelting recipes. It converts input1, input2 and catalyst into the form id1_id2_id3.
     * 
     * For example, if input1 = stone, input2 = grass, and input 3 = redstone
     * The converted key would be 1_2_331. 
     * 
     * This unique key is then added to the recipe list, and associated with the output ID.
     */
    public void addSmelting(ItemStack input1, ItemStack input2, ItemStack catalyst, ItemStack output, float experience)
    {
        String ingredients1 = this.ingredientsToKey(input1, input2, catalyst);
        String ingredients2 = this.ingredientsToKey(input2, input1, catalyst);

        recipeList.put(ingredients1, output);
        recipeList.put(ingredients2, output);
        
        experienceList.put(Arrays.asList(output.itemID, output.getItemDamage()), experience);
        
        size = recipeList.size();
    }
    
    /**
     * Called by the TileEntityFusionFurnace in the canSmelt and smeltItem methods. The items in the furnace slots are given to this method, which converts them into a unique key
     * in the same format as above. The output associated with that key is then given back to TileEntityFusionFurnace to become the output of the furnace.
     */
    public ItemStack getSmeltingResult(ItemStack input1, ItemStack input2, ItemStack catalyst)
    {
        String key = this.ingredientsToKey(input1, input2, catalyst);

        return recipeList.get(key);
    }
    
    /**
     * Grabs the amount of base experience for this item to give when pulled from the furnace slot.
     */
    public float getExperience(ItemStack item)
    {
        if (item == null || item.getItem() == null)
        {
            return 0;
        }
        
        float ret = item.getItem().getSmeltingExperience(item);
        
        if (ret < 0 && experienceList.containsKey(Arrays.asList(item.itemID, item.getItemDamage())))
        {
            ret = experienceList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        }
        
        if (ret < 0 && experienceList.containsKey(item.itemID))
        {
            ret = ((Float)experienceList.get(item.itemID)).floatValue();
        }
        return (ret < 0 ? 0 : ret);
    }
    
    public Map getRecipeList()
    {
        return recipeList;
    }
       
}