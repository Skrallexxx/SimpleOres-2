package SimpleOres.plugins.fusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import SimpleOres.core.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * The main file for Fusion Furnace recipes. This is where all the work is done.
 * 
 * Thanks to @zot and @sadris for all their help with Shift Clicking and Ore Dictionary support.
 * 
 * @author Alex
 *
 */
public class FusionRecipes
{
	public static final int WILDCARD_VALUE = OreDictionary.WILDCARD_VALUE;
	public static int size;
	
    private static final FusionRecipes smeltingBase = new FusionRecipes();

    /** The list of smelting and experience results. */
    private Map recipeList = new HashMap();
    private Map recipeListMeta = new HashMap();
    private static List<Item> inputList = new ArrayList<Item>();
    private static List<Item> catalystList = new ArrayList<Item>();
    private HashMap<List<Integer>, Float> experienceList = new HashMap<List<Integer>, Float>();
    
    int input1ID, input2ID, catalystID;
    
    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final FusionRecipes smelting()
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

    public void addSmelting(ItemStack input1, ItemStack input2, ItemStack catalyst, ItemStack output, float experience)
    {
    	getOreDictID(input1, input2, catalyst);
    	
    	boolean is1damaged = input1.getItemDamage() > 0 ? true : false;
    	boolean is2damaged = input2.getItemDamage() > 0 ? true : false;
    	boolean iscatdamaged = catalyst.getItemDamage() > 0 ? true : false;
    	
    	StringBuffer noMetaList = new StringBuffer(32);
    	StringBuffer noMetaListAlt = new StringBuffer(32);
    	
    	noMetaList
    	.append(input1ID).append("_")
    	.append(input2ID).append("_")
    	.append(catalystID);
    	
    	noMetaListAlt
    	.append(input2ID).append("_")
    	.append(input1ID).append("_")
    	.append(catalystID);
    	
    	recipeList.put(noMetaList.toString(), output);
    	recipeList.put(noMetaListAlt.toString(), output);      	
    	inputList.add(input1.getItem());
    	inputList.add(input2.getItem());
    	catalystList.add(catalyst.getItem());
    	experienceList.put(Arrays.asList(output.itemID, output.getItemDamage()), experience);
    	   	
    	if(is1damaged || is2damaged || iscatdamaged)
    	{	
        	StringBuffer metaList = new StringBuffer(32);
        	StringBuffer metaListAlt = new StringBuffer(32);
        	StringBuffer catOnlyList = new StringBuffer(32);
        	StringBuffer catOnlyListAlt = new StringBuffer(32);
        	
        	metaList
        	.append(input1ID).append(is1damaged ? (":") : ("_")).append(is1damaged ? input1.getItemDamage() : null)
        	.append(input2ID).append(is2damaged ? (":") : ("_")).append(is2damaged ? input2.getItemDamage() : null)
        	.append(catalystID).append(iscatdamaged ? (":") : ("_")).append(iscatdamaged ? catalyst.getItemDamage() : null);
        	
        	metaListAlt
        	.append(input2ID).append(is2damaged ? (":") : ("_")).append(is2damaged ? input2.getItemDamage() : null)
        	.append(input1ID).append(is1damaged ? (":") : ("_")).append(is1damaged ? input1.getItemDamage() : null)
        	.append(catalystID).append(iscatdamaged ? (":") : ("_")).append(iscatdamaged ? catalyst.getItemDamage() : null);
        	
        	catOnlyList
        	.append(input1ID).append("_")
        	.append(input2ID).append("_")
        	.append(catalystID).append(":").append(catalyst.getItemDamage());
        	
        	catOnlyListAlt
        	.append(input2ID).append("_")
        	.append(input1ID).append("_")
        	.append(catalystID).append(":").append(catalyst.getItemDamage());
        	
        	recipeListMeta.put(metaList.toString(), output);
        	recipeListMeta.put(metaListAlt.toString(), output);
        	if(!is1damaged && !is2damaged)
        	{
            	recipeListMeta.put(catOnlyList.toString(), output);
            	recipeListMeta.put(catOnlyListAlt.toString(), output);
        	}
        	experienceList.put(Arrays.asList(output.itemID, output.getItemDamage()), experience);  
    	}
    	
    	size = recipeList.size();
    }
    
    public ItemStack getSmeltingResult(ItemStack input1, ItemStack input2, ItemStack catalyst)
    {
    	getOreDictID(input1, input2, catalyst);
    	
    	boolean is1damaged = input1.getItemDamage() > 0 ? true : false;
    	boolean is2damaged = input2.getItemDamage() > 0 ? true : false;
    	boolean iscatdamaged = catalyst.getItemDamage() > 0 ? true : false;
    	
    	StringBuffer noMetaReturnList = new StringBuffer(32);
    	
    	noMetaReturnList
    	.append(input1ID).append("_")
    	.append(input2ID).append("_")
    	.append(catalystID); 
        	
    	if(is1damaged || is2damaged || iscatdamaged)
        {
            StringBuffer metaReturnList = new StringBuffer(32);
            StringBuffer catOnlyReturnList = new StringBuffer(32);
            	
            metaReturnList
            .append(input1ID).append(is1damaged ? (":") : ("_")).append(is1damaged ? input1.getItemDamage() : null)
            .append(input2ID).append(is2damaged ? (":") : ("_")).append(is2damaged ? input2.getItemDamage() : null)
            .append(catalystID).append(iscatdamaged ? (":") : ("_")).append(iscatdamaged ? catalyst.getItemDamage() : null);
                 
            catOnlyReturnList
            .append(input1ID).append("_")
            .append(input2ID).append("_")
            .append(catalystID).append(":").append(catalyst.getItemDamage());
            
            ItemStack catOnlyResult = (ItemStack)recipeListMeta.get(catOnlyReturnList.toString());
            
            if(catOnlyResult != null)
            {
            	return (ItemStack) recipeListMeta.get(catOnlyReturnList.toString());
            }
            
            else return (ItemStack) recipeListMeta.get(metaReturnList.toString());
        }
    	
    	else return (ItemStack) recipeList.get(noMetaReturnList.toString());
    }
    
    private void getOreDictID(ItemStack input1, ItemStack input2, ItemStack catalyst)
    {
    	int input1Dict, input2Dict, catalystDict;
    	
    	if(input1 != null && input1.getItem() != null)
    	{
    		int oreID1 = OreDictionary.getOreID(input1);
			if(oreID1 > 0)
			{
				input1Dict = oreID1;
			}
			else
			{
				input1Dict = input1.getItem().itemID;
				
			}
    	}
    	else input1Dict = 0;
    	
    	if(input2 != null && input2.getItem() != null)
    	{
    		int oreID2 = OreDictionary.getOreID(input2);
    		if(oreID2 > 0)
    		{
    			input2Dict = oreID2;
    		}
    		else input2Dict = input2.getItem().itemID;
    	}
    	else input2Dict = 0;
    	
    	if(catalyst != null && catalyst.getItem() != null)
    	{
    		int oreID3 = OreDictionary.getOreID(catalyst);
    		if(oreID3 > 0)
    		{
    			catalystDict = oreID3;
    		}
    		else catalystDict = catalyst.getItem().itemID;
    	}
    	else catalystDict = 0;
    	
    	input1ID = input1Dict;
    	input2ID = input2Dict;
    	catalystID = catalystDict;
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
    
    public static boolean isItemInput(ItemStack item)
    {
    	if(inputList.contains(item.getItem()))
    	{
    		return true;
    	}
    	else return false;
    }
    
    public static boolean isItemCatalyst(ItemStack item)
    {
    	if(catalystList.contains(item.getItem()))
    	{
    		return true;
    	}
    	else return false;
    }
    
    public Map getRecipeList()
    {
        return recipeList;
    }
    
    public Map getMetaRecipeList()
    {
    	return recipeListMeta;
    }
       
}