package alexndr.SimpleOres.plugins.netherrocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import alexndr.SimpleOres.api.helpers.TabHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NetherPickaxe extends ItemPickaxe
{
	private final EnumToolMaterial toolMaterial;
	private int toolLevel = 0;
	
	public NetherPickaxe(int par1, EnumToolMaterial par2EnumToolMaterial) 
	{
		super(par1, par2EnumToolMaterial);
		this.toolMaterial = par2EnumToolMaterial;
		this.setCreativeTab(TabHelper.getToolsTab());
	}
	
	/**
	 * Code that makes the Fyrite Pickaxe drop the smelted item rather than the normal drop.
	 * Only affects the Fyrite Pickaxe.
	 */
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, int i, int j, int k, EntityPlayer player)
	{
		Random random = new Random();
		if(itemID == Content.fyritePick.itemID && !player.capabilities.isCreativeMode)
		{
			Boolean flag = false;
			World world = player.worldObj;
			int blockID = world.getBlockId(i, j, k);
			int meta = world.getBlockMetadata(i, j, k);

			NBTTagList ench = itemstack.getEnchantmentTagList();
			short level = 0;
			if(ench != null)
			{
				for (int x = 0; x < ench.tagCount(); x++)
				{
					NBTTagCompound nbt = (NBTTagCompound) ench.tagAt(x);
					short id = nbt.getShort("id");
					if (id == Enchantment.fortune.effectId)
					{
						level = nbt.getShort("lvl");
					}
				}
			}
			ArrayList<ItemStack> items = Block.blocksList[blockID].getBlockDropped(world, i, j, k, meta, level);
			if(items == null || items.size() == 0)
			{
				return false;
			}
			if(Block.blocksList[blockID] != null && getStrVsBlock(itemstack, Block.blocksList[blockID], meta) > 1.0F)
			{
				for (ItemStack item : items)
				{
					if (FurnaceRecipes.smelting().getSmeltingResult(item) == null)
					{
						return false;
					}
					
		            int var3 = random.nextInt(level + 2) - 1;

		            if (var3 < 0)
		            {
		                var3 = 0;
		            }
		            
		            int quantity = Block.blocksList[blockID].quantityDropped(random) * (var3 + 1);
					
					ItemStack drop = new ItemStack(FurnaceRecipes.smelting().getSmeltingResult(item).copy().itemID, quantity, meta);
					world.playSoundEffect(i + 0.5F, j + 0.5F, k + 0.5F,
							Block.blocksList[blockID].stepSound.getBreakSound(),
							(Block.blocksList[blockID].stepSound.getVolume() + 1.0F) / 2.0F,
							Block.blocksList[blockID].stepSound.getPitch() * 0.8F);

					world.setBlock(i, j, k, 0);
					if(!world.isRemote)
					{		
						EntityItem entityitem = new EntityItem(world, i + 0.5, j + 0.5, k + 0.5, drop);
						world.spawnEntityInWorld(entityitem);
					}
					itemstack.damageItem(1, player);
					
					flag = true;
				}
			}

			return flag;
		}
		else return false;
	}
	
    /**
     * Sets the icon for the item. 
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) 
    {
    	 this.itemIcon = iconRegister.registerIcon("netherrocks:" + (this.getUnlocalizedName().substring(5)));
    }
    
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return this.toolMaterial.getToolCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
    
	/**
	 * Sets the harvest level of the tool. Defaults to 0 (wood).
	 */
	public NetherPickaxe setToolLevel(int level)
	{
		this.toolLevel = level;
		MinecraftForge.setToolClass(this, "pickaxe", this.toolLevel);
		return this;
	}
	
	/**
	 * Registers the item in the GameRegistry, with the name given, and sends the name through to setUnlocalizedName in the super class.
	 */
	public NetherPickaxe setUnlocalizedName(String unlocalizedName)
	{
		super.setUnlocalizedName(unlocalizedName);
		GameRegistry.registerItem(this, unlocalizedName);
		return this;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if(this.itemID == Content.fyritePick.itemID)
		{
			par3List.add(StatCollector.translateToLocal("netherrocks.fyritePick.info"));
		}
	}
}
