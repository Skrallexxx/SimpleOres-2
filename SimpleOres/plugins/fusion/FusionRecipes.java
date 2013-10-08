package SimpleOres.plugins.fusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class FusionRecipes
{
	private static final int WILDCARD_VALUE = OreDictionary.WILDCARD_VALUE;
	private static final FusionRecipes smeltingBase = new FusionRecipes();
	public static int size;
	
	private HashMap<HashMap<ArrayList<String>, ArrayList<Integer>>, ItemStack> recipeMap = new HashMap<HashMap<ArrayList<String>, ArrayList<Integer>>, ItemStack>();
	private HashMap<ArrayList<String>, ItemStack> dictionaryRecipeMap = new HashMap<ArrayList<String>, ItemStack>();
	private HashMap<ArrayList<String>, ArrayList<Integer>> damageMap = new HashMap<ArrayList<String>, ArrayList<Integer>>();
	private HashMap<HashMap<ArrayList<String>, ArrayList<Integer>>, ArrayList<Integer>> stackSizeMap = new HashMap<HashMap<ArrayList<String>, ArrayList<Integer>>, ArrayList<Integer>>();
	private HashMap<List<Integer>, Float> experienceMap = new HashMap<List<Integer>, Float>();
	
	private static ArrayList<Item> inputList = Lists.newArrayList();
    private static ArrayList<Item> catalystList = Lists.newArrayList();
    
    private ArrayList<Item> input1Variants, input2Variants, catalystVariants = Lists.newArrayList();
    private boolean isStackBigEnough = false;
    private int input1NumToDecreaseBy, input2NumToDecreaseBy, catalystNumToDecreaseBy = 1;
	
	public static final FusionRecipes smelting()
	{
		return smeltingBase;
	}
	
	public void addSmelting(ItemStack input1, ItemStack input2, ItemStack catalyst, ItemStack output, float experience)
	{
		ArrayList<String> itemList = getItemList(input1, input2, catalyst);
		ArrayList<String> itemListAlt = getItemList(input2, input1, catalyst);
		ArrayList<String> dictionaryList = getDictionaryList(input1, input2, catalyst);
		ArrayList<String> dictionaryListAlt = getDictionaryList(input2, input1, catalyst);
		ArrayList<Integer> damageList = getDamageList(input1, input2, catalyst);
		ArrayList<Integer> damageListAlt = getDamageList(input2, input1, catalyst);
		ArrayList<Integer> stackSizeList = getStackSizeList(input1, input2, catalyst);
		ArrayList<Integer> stackSizeListAlt = getStackSizeList(input2, input1, catalyst);
		
		HashMap<ArrayList<String>, ArrayList<Integer>> itemMap = new HashMap<ArrayList<String>, ArrayList<Integer>>();
		HashMap<ArrayList<String>, ArrayList<Integer>> itemMapAlt = new HashMap<ArrayList<String>, ArrayList<Integer>>();
		HashMap<ArrayList<String>, ArrayList<Integer>> dictMap = new HashMap<ArrayList<String>, ArrayList<Integer>>();
		HashMap<ArrayList<String>, ArrayList<Integer>> dictMapAlt = new HashMap<ArrayList<String>, ArrayList<Integer>>();
	
		itemMap.put(itemList, damageList);
		itemMapAlt.put(itemListAlt, damageListAlt);
		dictMap.put(dictionaryList, damageList);
		dictMapAlt.put(dictionaryListAlt, damageListAlt);
		
		recipeMap.put(itemMap, output);
		recipeMap.put(itemMapAlt, output);
		dictionaryRecipeMap.put(dictionaryList, output);
		dictionaryRecipeMap.put(dictionaryListAlt, output);
		
		stackSizeMap.put(itemMap, stackSizeList);
		stackSizeMap.put(itemMapAlt, stackSizeListAlt);
		stackSizeMap.put(dictMap, stackSizeList);
		stackSizeMap.put(dictMapAlt, stackSizeListAlt);
		
		damageMap.put(itemList, damageList);
		damageMap.put(itemListAlt, damageListAlt);
		damageMap.put(dictionaryList, damageList);
		damageMap.put(dictionaryListAlt, damageListAlt);
		
		inputList.add(input1.getItem());
	    inputList.add(input2.getItem());
	    catalystList.add(catalyst.getItem());
	    
	    experienceMap.put(Arrays.asList(output.itemID, output.getItemDamage()), experience);
	    size = recipeMap.size();
	}
	
	public ItemStack getSmeltingResult(ItemStack input1, ItemStack input2, ItemStack catalyst)
	{
		ArrayList<String> itemList = getItemList(input1, input2, catalyst);
		ArrayList<String> dictionaryList = getDictionaryList(input1, input2, catalyst);
		ArrayList<Integer> stackSizeList = getStackSizeList(input1, input2, catalyst);
		ArrayList<Integer> recipeDamages = damageMap.get(itemList);
		
		HashMap<ArrayList<String>, ArrayList<Integer>> itemMap = new HashMap<ArrayList<String>, ArrayList<Integer>>();
		HashMap<ArrayList<String>, ArrayList<Integer>> itemMap1 = new HashMap<ArrayList<String>, ArrayList<Integer>>();
		itemMap1.put(itemList, recipeDamages);
		
		if(recipeMap.containsKey(itemMap1))
		{
			ArrayList<Integer> damageList = new ArrayList<Integer>();
			if(recipeDamages.get(0) == WILDCARD_VALUE)
			{
				damageList.add(WILDCARD_VALUE);
			}
			else
				damageList.add(input1.getItemDamage());
			if(recipeDamages.get(1) == WILDCARD_VALUE)
			{
				damageList.add(WILDCARD_VALUE);
			}
			else
				damageList.add(input2.getItemDamage());
			if(recipeDamages.get(2) == WILDCARD_VALUE)
			{
				damageList.add(WILDCARD_VALUE);
			}
			else 
				damageList.add(catalyst.getItemDamage());
			
			itemMap.put(itemList, damageList);
			ArrayList<Integer> stackSizeNeeded = stackSizeMap.get(itemMap);
			
			if(stackSizeList.get(0) >= stackSizeNeeded.get(0))
			{
				if(stackSizeList.get(1) >= stackSizeNeeded.get(1))
				{
					if(stackSizeList.get(2) >= stackSizeNeeded.get(2))
					{
						isStackBigEnough = true;
						input1NumToDecreaseBy = stackSizeNeeded.get(0);
						input2NumToDecreaseBy = stackSizeNeeded.get(1);
						catalystNumToDecreaseBy = stackSizeNeeded.get(2);
						
						return (ItemStack) recipeMap.get(itemMap);
					}
				}
			}
		}
		
		else if(!recipeMap.containsKey(itemMap1))
		{
			HashMap<ArrayList<String>, ArrayList<Integer>> dictMap = new HashMap<ArrayList<String>, ArrayList<Integer>>();
			ArrayList<Integer> damageList = new ArrayList<Integer>();
			ArrayList<Integer> damages = damageMap.get(dictionaryList);
			int i1 = damages.get(0);
			int i2 = damages.get(1);
			int i3 = damages.get(2);
			
			damageList.add(i1);
			damageList.add(i2);
			damageList.add(i3);
			
			dictMap.put(dictionaryList, damageList);
			ArrayList<Integer> stackSizeNeeded = stackSizeMap.get(dictMap);	
			
			if(stackSizeList.get(0) >= stackSizeNeeded.get(0))
			{
				if(stackSizeList.get(1) >= stackSizeNeeded.get(1))
				{
					if(stackSizeList.get(2) >= stackSizeNeeded.get(2))
					{
						isStackBigEnough = true;
						input1NumToDecreaseBy = stackSizeNeeded.get(0);
						input2NumToDecreaseBy = stackSizeNeeded.get(1);
						catalystNumToDecreaseBy = stackSizeNeeded.get(2);
						
						return (ItemStack) dictionaryRecipeMap.get(dictionaryList);
					}
				}
			}
		}
		return null;
	}
	
	public ArrayList<String> getItemList(ItemStack input1, ItemStack input2, ItemStack catalyst)
	{
		ArrayList<String> itemList = Lists.newArrayList();
		itemList.add(input1.getItem().itemID + "");
		itemList.add(input2.getItem().itemID + "");
		itemList.add(catalyst.getItem().itemID + "");
		return itemList;
	}
	
	public ArrayList<String> getDictionaryList(ItemStack input1, ItemStack input2, ItemStack catalyst)
	{
		ArrayList<String> dictionaryList = Lists.newArrayList();
		getOreDictVariants(input1, input2, catalyst);
		dictionaryList.add(input1Variants.toString());
		dictionaryList.add(input2Variants.toString());
		dictionaryList.add(catalystVariants.toString());
		return dictionaryList;
	}
	
	public ArrayList<Integer> getDamageList(ItemStack input1, ItemStack input2, ItemStack catalyst)
	{
		ArrayList<Integer> damageList = Lists.newArrayList();
		damageList.add(input1.getItemDamage());
		damageList.add(input2.getItemDamage());
		damageList.add(catalyst.getItemDamage());
		return damageList;
	}
	
	public ArrayList<Integer> getStackSizeList(ItemStack input1, ItemStack input2, ItemStack catalyst)
	{
		ArrayList<Integer> stackSizeList = Lists.newArrayList();
		stackSizeList.add(input1.stackSize);
		stackSizeList.add(input2.stackSize);
		stackSizeList.add(catalyst.stackSize);
		return stackSizeList;
	}
	
	public void getOreDictVariants(ItemStack input1, ItemStack input2, ItemStack catalyst)
	{
		input1Variants = Lists.newArrayList();
		input2Variants = Lists.newArrayList();
		catalystVariants = Lists.newArrayList();
		
		if(input1 != null && input1.getItem() != null)
		{
			int oreId1 = OreDictionary.getOreID(input1);
			if(oreId1 > 0)
			{
				ArrayList<ItemStack> ores = OreDictionary.getOres(oreId1);
				if(ores != null && ores.size() != 0)
				{
					for(int i = 0; i < ores.size(); i++)
					{
						input1Variants.add(ores.get(i).getItem());
					}
				}
				else
					input1Variants.add(input1.getItem());
			}
			else
				input1Variants.add(input1.getItem());
		}
		
		if(input2 != null && input2.getItem() != null)
		{
			int oreId2 = OreDictionary.getOreID(input2);
			if(oreId2 > 0)
			{
				ArrayList<ItemStack> ores = OreDictionary.getOres(oreId2);
				if(ores != null && ores.size() != 0)
				{
					for(int i = 0; i < ores.size(); i++)
					{
						input2Variants.add(ores.get(i).getItem());
					}
				}
				else
					input2Variants.add(input2.getItem());
			}
			else
				input2Variants.add(input2.getItem());
		}
		
		if(catalyst != null && catalyst.getItem() != null)
		{
			int oreId3 = OreDictionary.getOreID(catalyst);
			if(oreId3 > 0)
			{
				ArrayList<ItemStack> ores = OreDictionary.getOres(oreId3);
				if(ores != null && ores.size() != 0)
				{
					for(int i = 0; i < ores.size(); i++)
					{
						catalystVariants.add(ores.get(i).getItem());
					}
				}
				else
					catalystVariants.add(catalyst.getItem());
			}
			else
				catalystVariants.add(catalyst.getItem());
		}
	}
	
	public float getExperience(ItemStack item)
	{
		if (item == null || item.getItem() == null)
        {
            return 0;
        }
        
        float ret = item.getItem().getSmeltingExperience(item);
        
        if (ret < 0 && experienceMap.containsKey(Arrays.asList(item.itemID, item.getItemDamage())))
        {
            ret = experienceMap.get(Arrays.asList(item.itemID, item.getItemDamage()));
        }
        
        if (ret < 0 && experienceMap.containsKey(item.itemID))
        {
            ret = ((Float)experienceMap.get(item.itemID)).floatValue();
        }
        return (ret < 0 ? 0 : ret);
	}
	
	public boolean isStackBigEnough()
	{
		boolean bool = false;
		bool = isStackBigEnough;
		return bool;
	}
	
	public Integer decreaseStackBy(int index)
	{
		if(index == 0)
		{
			return input1NumToDecreaseBy;
		}
		else if(index == 1)
		{
			return input2NumToDecreaseBy;
		}
		else if(index == 2)
		{
			return catalystNumToDecreaseBy;
		}
		return null;
	}
	
	public static boolean isItemInput(ItemStack item)
	{
		if (inputList.contains(item.getItem())) 
		{
			return true;
		} 
		else return false;
	}
	
	public static boolean isItemCatalyst(ItemStack item)
	{
		if (catalystList.contains(item.getItem())) 
		{
			return true;
		} 
		else return false;
	}
}