package alexndr.SimpleOres.plugins.fusion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.google.common.collect.Lists;

public class FusionRecipes
{
	private static final ArrayList<Entry> recipeList = Lists.newArrayList();
	private static final HashMap<ItemStack, Float> experienceMap = new HashMap<ItemStack, Float>();
	public static final int WILDCARD_VALUE = OreDictionary.WILDCARD_VALUE;
	
	public static void addSmelting(Material input1, Material input2, Material catalyst, ItemStack output, float experience)
	{
		recipeList.add(new BasicEntry(input1, input2, catalyst, output));
		setExperience(output.copy(), experience);
	}
	
	public static void addSmelting(ItemStack input1, ItemStack input2, ItemStack catalyst, ItemStack output, float experience)
	{
		recipeList.add(new BasicEntry(input1, input2, catalyst, output));
		setExperience(output.copy(), experience);
	}
	
	public static ItemStack getSmeltingResult(ItemStack input1, ItemStack input2, ItemStack catalyst)
	{
		for(Entry e : recipeList)
		{
			if(e.matches(input1, input2, catalyst))
			{
				return e.getOutput(input1, input2, catalyst);
			}
		}
		return null;
	}
	
	public static void setExperience(ItemStack output, float experience)
	{
		if (!experienceMap.containsKey(output))
		{
			experienceMap.put(output.copy(), experience);
		}
	}
	
	public static ItemStack applyFusion(ItemStack input1, ItemStack input2, ItemStack catalyst)
	{
		for(Entry e : recipeList)
		{
			if(e.matches(input1, input2, catalyst))
			{
				return e.applyFusion(input1, input2, catalyst);
			}
		}
		return null;
	}
	
	public static float getExperience(ItemStack item)
	{
		Float exp = experienceMap.get(item);
		return exp == null ? 0 : exp;
	}
	
	public static boolean isItemCatalyst(ItemStack item)
	{
		for(Entry e : recipeList)
		{
			if(e.isItemCatalyst(item))
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean isItemInput(ItemStack item)
	{
		for(Entry e : recipeList)
		{
			if(e.isItemInput(item))
			{
				return true;
			}
		}
		return false;
	}
	
	public static List<Entry> getRecipeList()
	{
		return recipeList;
	}
	
	public static Map<ItemStack, Float> getExperienceList()
	{
		return experienceMap;
	}
	
	public static int size()
	{
		return recipeList.size();
	}
	
	public static boolean matches(ItemStack target, ItemStack stack)
	{
		if(target.getItem() == stack.getItem() && (target.getItemDamage() == stack.getItemDamage() || target.getItemDamage() == WILDCARD_VALUE))
		{
			return true;
		}
		
		return false;
	}
	
	public static interface Entry
	{
		public boolean matches(ItemStack input1, ItemStack input2, ItemStack catalyst);
		public ItemStack getOutput(ItemStack input1, ItemStack input2, ItemStack catalyst);
		
		public ItemStack applyFusion(ItemStack input1, ItemStack input2, ItemStack catalyst);
		public boolean isItemInput(ItemStack item);
		public boolean isItemCatalyst(ItemStack item);
		
		public EntryInfo getInfo();
	}
	
	public static class BasicEntry implements Entry
	{
		public final Material input1;
		public final Material input2;
		public final Material catalyst;
		private final ItemStack output;
	
		public BasicEntry(Material input1, Material input2, Material catalyst, ItemStack output)
		{
			this.input1 = input1;
			this.input2 = input2;
			this.catalyst = catalyst;
			this.output = output.copy();
		}
		
		public BasicEntry(ItemStack input1, ItemStack input2, ItemStack catalyst, ItemStack output)
		{
			this.input1 = Material.of(input1);
			this.input2 = Material.of(input2);
			this.catalyst = Material.of(catalyst);
			this.output = output.copy();
		}
		
		public ItemStack getOutput()
		{
			return output.copy();
		}
		
		@Override
		public boolean matches(ItemStack input1, ItemStack input2, ItemStack catalyst)
		{
			return this.catalyst.matches(catalyst) 
					&& ((this.input1.matches(input1) && this.input2.matches(input2)) 
							|| (this.input1.matches(input2) && this.input2.matches(input1)));
		}
		
		@Override
		public ItemStack getOutput(ItemStack input1, ItemStack input2, ItemStack catalyst)
		{
			return output.copy();
		}
		
		@Override
		public ItemStack applyFusion(ItemStack input1, ItemStack input2, ItemStack catalyst)
		{
			if(this.input1.matches(input1) && this.input2.matches(input2))
			{
				this.input1.decrStackSize(input1);
				this.input2.decrStackSize(input2);
			}
			else
			{
				this.input1.decrStackSize(input2);
				this.input2.decrStackSize(input1);
			}
			this.catalyst.decrStackSize(catalyst);
			return output.copy();
		}
		
		@Override
		public boolean isItemInput(ItemStack item)
		{
			return input1.matches(item) || input2.matches(item);
		}
		
		@Override
		public boolean isItemCatalyst(ItemStack item)
		{
			return catalyst.matches(item);
		}
		
		@Override public EntryInfo getInfo()
		{
			return new EntryInfo(input1, input2, catalyst, Material.of(output));
		}
	}
	
	public static class EntryInfo
	{
		public final Material input1;
		public final Material input2;
		public final Material catalyst;
		public final Material output;
		
		public EntryInfo(Material input1, Material input2,  Material catalyst, Material output)
		{
			this.input1 = input1;
			this.input2 = input2;
			this.catalyst = catalyst;
			this.output = output;
		}
	}
	
	public static abstract class Material
	{
		public static Material of(){
			return new NullMaterial();
		}
		
		public static Material of(String ore, int amount){
			return new OreMaterial(ore, amount);
		}
		
		public static Material of(ItemStack stack){
			return new StackMaterial(stack);
		}
		
		public static Material of(Item item, int amount, int meta){return of(new ItemStack(item, amount, meta));}		
		public static Material of(Item item, int amount){return of(item, amount, 0);}		
		public static Material of(Item item){return of(item, 1, 0);}	
		public static Material of(Block block, int amount, int meta){return of(new ItemStack(block, amount, meta));}		
		public static Material of(Block block, int amount){return of(block, amount, 0);}
		public static Material of(Block block){return of(block, 1, 0);}		
		public static Material of(String ore){return of(ore, 1);}
		
		public abstract boolean matches(ItemStack item);
		public abstract void decrStackSize(ItemStack item);
		public abstract List<ItemStack> items();
	}
	
	public static class NullMaterial extends Material
	{
		private NullMaterial(){}
		@Override
		public boolean matches(ItemStack item) {
			return item == null;
		}

		@Override
		public void decrStackSize(ItemStack item) {}

		@Override
		public List<ItemStack> items() {
			return Lists.newArrayList();
		}
	}
	
	public static class OreMaterial extends Material
	{
		public final String ore;
		public final int amount;
		
		private OreMaterial(String ore, int amount)
		{
			if(amount < 0)
			{
				throw new IllegalArgumentException(Integer.valueOf(amount).toString());
			}
			
			this.ore = ore;
			this.amount = amount;
		}
		
		@Override
		public boolean matches(ItemStack item) 
		{
			if(item == null || item.stackSize < amount)
			{
				return false;
			}
			
			for(ItemStack stack : OreDictionary.getOres(ore))
			{
				if(FusionRecipes.matches(stack, item))
				{
					return true;
				}
			}
			
			return false;
		}

		@Override
		public void decrStackSize(ItemStack item) {
			item.stackSize -= amount;
		}

		@Override
		public List<ItemStack> items() {
			return OreDictionary.getOres(ore);
		}
		
	}
	
	public static class StackMaterial extends Material
	{
		private final ItemStack stack;
		
		public ItemStack getStack(){
			return stack.copy();
		}
		
		private StackMaterial(ItemStack stack)
		{
			if(stack.stackSize < 0)
			{
				throw new IllegalArgumentException(stack.toString());
			}
			this.stack = stack.copy();
		}	
		
		@Override
		public boolean matches(ItemStack item) 
		{
			if(item == null || item.stackSize < stack.stackSize)
			{
				return false;
			}
			
			return FusionRecipes.matches(stack, item);
		}

		@Override
		public void decrStackSize(ItemStack item) {
			item.stackSize -= stack.stackSize;
		}

		@Override
		public List<ItemStack> items() {
			return Lists.newArrayList(stack.copy());
		}	
	}
}