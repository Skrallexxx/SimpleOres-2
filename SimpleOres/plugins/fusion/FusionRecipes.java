package SimpleOres.plugins.fusion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;

public class FusionRecipes {
	/**
	 * A constant referring the current wildcard value of the metadata. @author zot
	 */
	public static final int WILDCARD_VALUE = OreDictionary.WILDCARD_VALUE;
	
	
	
	/**
	 * An abstract class to integrate ItemStack and OreDictionary entries. @author zot
	 */
	public static abstract class Material {
		/**
		 * Use this to represent empty slots. @author zot
		 */
		public static Material of() {
			return new NullMaterial();
		}
		
		/**
		 * Use this to represent OreDictionary entries. @author zot
		 */
		public static Material of(String ore, int amount) {
			return new OreMaterial(ore, amount);
		}
		
		public static Material of(String ore) {
			return of(ore, 1);
		}
		
		/**
		 * Use this to represent exact items.
		 * The metadata must be explicitly set as wildcard value in order to represent a wildcard.
		 * @author zot
		 */
		public static Material of(ItemStack stack) {
			return new StackMaterial(stack);
		}
		
		/**
		 * Some constructors resembling the ItemStack syntax, with a default stack size of 1 and a default metadata of 0.
		 * @author zot
		 */
		public static Material of(int itemID, int amount, int metadata) {
			return of(new ItemStack(itemID, amount, metadata));
		}
		public static Material of(Item item) {
			return of(item.itemID, 1, 0);
		}
		public static Material of(Item item, int amount) {
			return of(item.itemID, amount, 0);
		}
		public static Material of(Item item, int amount, int metadata) {
			return of(item.itemID, amount, metadata);
		}
		public static Material of(Block block) {
			return of(block, 1);
		}
		public static Material of(Block block, int amount) {
			return of(block.blockID, amount, 0);
		}
		public static Material of(Block block, int amount, int metadata) {
			return of(block.blockID, amount, metadata);
		}
		
		public abstract boolean matches(ItemStack item);
		
		protected abstract void reduceStackSize(ItemStack item);
		
		/**
		 * Give a list of the representing items for display. @author zot
		 */
		public abstract List<ItemStack> getItems();
	}
	
	/**
	 * The actual class that represents an empty slot. @author zot
	 */
	public static class NullMaterial extends Material {
		private NullMaterial() {}
		@Override public boolean matches(ItemStack item) {
			return item == null;
		}
		
		@Override protected void reduceStackSize(ItemStack item) {}
		
		@Override public List<ItemStack> getItems() {
			return Lists.newArrayList();
		}
	}
	
	/**
	 * The actual class that represents an OreDictionary entry. @author zot
	 */
	public static class OreMaterial extends Material {
		public final String ore;
		public final int amount;
		private OreMaterial(String ore, int amount) {
			if (amount < 0)
				throw new IllegalArgumentException(Integer.valueOf(amount).toString());
			this.ore = ore;
			this.amount = amount;
		}
		@Override public boolean matches(ItemStack item) {
			if (item == null || item.stackSize < amount)
				return false;
			for (ItemStack i : OreDictionary.getOres(ore))
				if (FusionRecipes.matches(i, item))
					return true;
			return false;
		}
		
		@Override protected void reduceStackSize(ItemStack item) {
			item.stackSize -= amount;
		}
		
		@Override public List<ItemStack> getItems() {
			return OreDictionary.getOres(ore);
		}
	}
	
	/**
	 * The actual class that represents an ItemStack. @author zot
	 */
	public static class StackMaterial extends Material {
		private final ItemStack stack;
		private StackMaterial(ItemStack stack) {
			if (stack.stackSize < 0)
				throw new IllegalArgumentException(stack.toString());
			this.stack = stack.copy();
		}
		public ItemStack getStack() {
			return stack.copy();
		}
		@Override public boolean matches(ItemStack item) {
			if (item == null || item.stackSize < stack.stackSize)
				return false;
			return FusionRecipes.matches(stack, item);
		}
		
		@Override protected void reduceStackSize(ItemStack item) {
			item.stackSize -= stack.stackSize;
		}
		
		@Override public List<ItemStack> getItems() {
			return Lists.newArrayList(stack.copy());
		}
	}
	
	public static boolean matches(ItemStack target, ItemStack item) {
		return target.itemID == item.itemID
				&& (target.getItemDamage() == WILDCARD_VALUE || target.getItemDamage() == item.getItemDamage())
				&& (target.stackTagCompound == null || target.stackTagCompound.equals(item.stackTagCompound));
	}
	
	
	
	/**
	 * An interface to represent entries of fusion recipe. @author zot
	 */
	public static interface Entry {
		public boolean matches(ItemStack input1, ItemStack input2, ItemStack catalyst);
		public ItemStack getOutput(ItemStack input1, ItemStack input2, ItemStack catalyst);
		
		/**
		 * Being called after matching. No need to check items. @author zot
		 */
		public ItemStack applyFusion(ItemStack input1, ItemStack input2, ItemStack catalyst);
		
		public boolean isItemIput(ItemStack item);
		public boolean isItemCatalyst(ItemStack item);
		
		/**
		 * A method to give an EntryInfo for recipe displaying. @author zot
		 */
		public EntryInfo getInfo();
	}
	
	public static class BasicEntry implements Entry {
		public final Material input1;
		public final Material input2;
		public final Material catalyst;
		private final ItemStack output;
		public BasicEntry(Material input1, Material input2, Material catalyst, ItemStack output) {
			this.input1 = input1;
			this.input2 = input2;
			this.catalyst = catalyst;
			this.output = output.copy();
		}
		public BasicEntry(ItemStack input1, ItemStack input2, ItemStack catalyst, ItemStack output) {
			this.input1 = Material.of(input1);
			this.input2 = Material.of(input2);
			this.catalyst = Material.of(catalyst);
			this.output = output.copy();
		}
		public ItemStack getOutput() {
			return output.copy();
		}
		
		@Override public boolean matches(ItemStack input1, ItemStack input2, ItemStack catalyst) {
			return this.catalyst.matches(catalyst)
					&& (this.input1.matches(input1) && this.input2.matches(input2)
							|| this.input1.matches(input2) && this.input2.matches(input1));
		}
		@Override public ItemStack getOutput(ItemStack input1, ItemStack input2, ItemStack catalyst) {
			return output.copy();
		}

		/**
		 * Being called after matching. No need to check items. @author zot
		 */
		@Override public ItemStack applyFusion(ItemStack input1, ItemStack input2, ItemStack catalyst) {
			if (this.input1.matches(input1) && this.input2.matches(input2)) {
				this.input1.reduceStackSize(input1);
				this.input2.reduceStackSize(input2);
			}
			else {
				this.input1.reduceStackSize(input2);
				this.input2.reduceStackSize(input1);
			}
			this.catalyst.reduceStackSize(catalyst);
			return output.copy();
		}
		
		@Override public boolean isItemIput(ItemStack item) {
			return input1.matches(item) || input2.matches(item);
		}
		@Override public boolean isItemCatalyst(ItemStack item) {
			return catalyst.matches(item);
		}
		
		@Override public EntryInfo getInfo() {
			return new EntryInfo(input1, input2, catalyst, Material.of(output));
		}
	}
	
	
	
	/**
	 * Use for recipe display. @author zot
	 */
	public static class EntryInfo {
		public final Material input1;
		public final Material input2;
		public final Material catalyst;
		public final Material output;
		public EntryInfo(Material input1, Material input2, Material catalyst, Material output) {
			this.input1 = input1;
			this.input2 = input2;
			this.catalyst = catalyst;
			this.output = output;
		}
	}
	
	
	
	/**
	 * A hack to identify between ItemStack's. TagCompound aware and stack size unaware. @author zot
	 */
	public static final Ordering<ItemStack> stackOrder =
			Ordering.natural().onResultOf(new Function<ItemStack, Integer>() {
				@Override public Integer apply(ItemStack input) { return input.itemID; }
			}).compound(
					Ordering.natural().onResultOf(new Function<ItemStack, Integer>() {
						@Override public Integer apply(ItemStack input) { return input.getItemDamage(); }
					})).compound(
							Ordering.natural().onResultOf(new Function<ItemStack, Integer>() {
								@Override public Integer apply(ItemStack input) {
									return input.stackTagCompound == null ? 0 : input.stackTagCompound.hashCode();
								}
							})).compound(
									new Ordering<ItemStack>() {
										@Override public int compare(ItemStack left, ItemStack right) {
											if (left.stackTagCompound == right.stackTagCompound
													|| left.stackTagCompound.equals(right.stackTagCompound))
												return 0;
											return 1;
										}
									});
	
	/** 
	 * Lists of fusion recipes and experience results. @author zot
	 */
	private static final ArrayList<Entry> recipeList = Lists.newArrayList();
	private static final TreeMap<ItemStack, Float> experienceList = Maps.newTreeMap(stackOrder);
	
	/**
	 * Total number of the fusion recipes. @author zot
	 */
	public static int size() {
		return recipeList.size();
	}
	
	/**
	 * A method remained for code compatibility. 'addSmelting' can be called without this. @author zot
	 */
	@Deprecated public static FusionRecipes smelting() {
		return new FusionRecipes();
	}
	
	/**
	 * The standard method to add a fusion recipe. Use 'Material.of' to obtain required materials. @author zot
	 */
	public static void addSmelting(Material input1, Material input2, Material catalyst, ItemStack output, float experience) {
		recipeList.add(new BasicEntry(input1, input2, catalyst, output));
		setExperience(output.copy(), experience);
	}
	
	/**
	 * The ItemStack-only method to add a fusion recipe. @author zot 
	 */
	public static void addSmelting(ItemStack input1, ItemStack input2, ItemStack catalyst, ItemStack output, float experience) {
		recipeList.add(new BasicEntry(input1, input2, catalyst, output));
		setExperience(output.copy(), experience);
	}
	
	public static void setExperience(ItemStack output, float experience) {
		if (!experienceList.containsKey(output))
			experienceList.put(output.copy(), experience);
	}
	
	public static ItemStack getSmeltingResult(ItemStack input1, ItemStack input2, ItemStack catalyst) {
		for (Entry e : recipeList)
			if (e.matches(input1, input2, catalyst))
				return e.getOutput(input1, input2, catalyst);
		return null;
	}
	
	/**
	 * Reduce stack size of the stacks in the arguments and return the result. @author zot
	 */
	public static ItemStack applyFusion(ItemStack input1, ItemStack input2, ItemStack catalyst) {
		for (Entry e : recipeList)
			if (e.matches(input1, input2, catalyst))
				return e.applyFusion(input1, input2, catalyst);
		return null;
	}
	
	/**
	 * Grabs the amount of base experience for this item to give when pulled from the furnace slot.
	 */
	public static float getExperience(ItemStack item) {
		Float exp = experienceList.get(item);
		return exp == null ? 0 : exp;
	}
	
	/**
	 * A method to determine which slot should be put in on shift-clicks. @author zot
	 */
	public static boolean isItemCatalyst(ItemStack item) {
		for (Entry e : recipeList)
			if (e.isItemCatalyst(item))
				return true;
		return false;
	}
	
	/**
	 * A method to determine which slot should be put in on shift-clicks. @author zot
	 */
	public static boolean isItemInput(ItemStack item) {
		for (Entry e : recipeList)
			if (e.isItemIput(item))
				return true;
		return false;
	}
	
	public static List<Entry> getRecipeList() {
		return recipeList;
	}
	
	public static Map<ItemStack, Float> getExperienceList() {
		return experienceList;
	}
	
}
