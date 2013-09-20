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
    private Map<FusionRecipeInput, ItemStack> recipeList = new HashMap<FusionRecipeInput, ItemStack>();
    private HashMap<List<Integer>, Float> experienceList = new HashMap<List<Integer>, Float>();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static FusionRecipes smelting()
    {
        return smeltingBase;
    }

    public Map<FusionRecipeInput, ItemStack> getRecipes()
    {
        return this.recipeList;
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
        FusionRecipeInput fri = new FusionRecipeInput(input1, input2, catalyst);

        recipeList.put(fri, output);
        experienceList.put(Arrays.asList(output.itemID, output.getItemDamage()), experience);
        
        size = recipeList.size();
    }
    
    /**
     * Called by the TileEntityFusionFurnace in the canSmelt and smeltItem methods. The items in the furnace slots are given to this method, which converts them into a unique key
     * in the same format as above. The output associated with that key is then given back to TileEntityFusionFurnace to become the output of the furnace.
     */
    public ItemStack getSmeltingResult(ItemStack input1, ItemStack input2, ItemStack catalyst)
    {
        FusionRecipeInput fri = new FusionRecipeInput(input1, input2, catalyst);

        return recipeList.get(fri);
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

    public static class FusionRecipeInput extends Object {
        public ItemStack leftInput;
        public ItemStack rightInput;
        public ItemStack catalyst;

        public FusionRecipeInput(ItemStack left, ItemStack right, ItemStack catalyst) {
            this.leftInput = (left);
            this.rightInput = (right);
            this.catalyst = (catalyst);
        }

        public boolean utilizes(ItemStack is) {
            boolean matches = false;
            matches = OreDictionary.itemMatches(is, leftInput, false);
            if( matches )
                return true;

            matches = OreDictionary.itemMatches(is, rightInput, false);
            if( matches )
                return true;

            matches = OreDictionary.itemMatches(is, catalyst, false);
            return matches;
        }

        @Override
        public boolean equals(Object o) {
            if( ! (o instanceof FusionRecipeInput) )
                return false;
            return this.hashCode()==o.hashCode();
        }

        @Override
        public int hashCode() {
            int hash = 1;
            int l = OreDictionary.getOreID(this.leftInput);
            int r = OreDictionary.getOreID(this.rightInput);
            int c = OreDictionary.getOreID(this.catalyst);

            if( l > 0 )
                hash = hash + 18 * l;
            else if( leftInput!=null )
                hash = hash + 18*(leftInput.getItem().itemID + leftInput.getItemDamage());

            if( r > 0 )
                hash = hash + 18 * r;
            else if( rightInput!=null )
                hash = hash + 18*(rightInput.getItem().itemID + rightInput.getItemDamage());

            if( c > 0 )
                hash = hash * 43*(catalyst.getItem().itemID + 13*catalyst.getItemDamage());
            else if( catalyst!=null )
                hash = hash * 43*(catalyst.getItem().itemID + 13*catalyst.getItemDamage());

            return hash;
        }

        @Override
        public String toString() {
            return "fri-" + hashCode();
        }
    }
       
}