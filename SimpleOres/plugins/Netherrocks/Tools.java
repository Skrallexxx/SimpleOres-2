package SimpleOres.plugins.Netherrocks;

import java.util.ArrayList;

import SimpleOres.core.SimpleOres;
import SimpleOres.core.api.SimpleAxe;
import SimpleOres.core.api.SimpleHoe;
import SimpleOres.core.api.SimplePickaxe;
import SimpleOres.core.api.SimpleShovel;
import SimpleOres.core.api.SimpleSword;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class Tools 
{
	/**
	 * Creating the tool items.
	 */
	public static Item malachitePick;
	public static Item malachiteAxe;
	public static Item malachiteShovel;
	public static Item malachiteSword;
	public static Item malachiteHoe;
	public static Item ashstonePick;
	public static Item ashstoneAxe;
	public static Item ashstoneShovel;
	public static Item ashstoneSword;
	public static Item ashstoneHoe;
	public static Item dragonstonePick;
	public static Item dragonstoneAxe;
	public static Item dragonstoneShovel;
	public static Item dragonstoneSword;
	public static Item dragonstoneHoe;
	public static Item argonitePick;
	public static Item argoniteAxe;
	public static Item argoniteShovel;
	public static Item argoniteSword;
	public static Item argoniteHoe;
	public static Item fyriteSword;
	public static Item illumeniteSword;
	public static Item fyritePick;
	
	/**
	 * Constructor that adds the properties to the tools. This is called by the main Netherrocks class.
	 * Adds ID and tool type.
	 * Also adds a name to the tools, and registers their tool type.
	 */
  	public static void doTools()
	{
		//Tool Details
		malachitePick = new SimplePickaxe(Config.malachitePickID, Netherrocks.toolMalachite, "netherrocks", Netherrocks.tabNetherTools).setUnlocalizedName("malachitePick");
		malachiteAxe = new SimpleAxe(Config.malachiteAxeID, Netherrocks.toolMalachite, "netherrocks", Netherrocks.tabNetherTools).setUnlocalizedName("malachiteAxe");
		malachiteShovel = new SimpleShovel(Config.malachiteShovelID, Netherrocks.toolMalachite, "netherrocks", Netherrocks.tabNetherTools).setUnlocalizedName("malachiteShovel");
		malachiteSword = new SimpleSword(Config.malachiteSwordID, Netherrocks.toolMalachite, "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("malachiteSword");
		malachiteHoe = new SimpleHoe(Config.malachiteHoeID, Netherrocks.toolMalachite, "netherrocks", Netherrocks.tabNetherTools).setUnlocalizedName("malachiteHoe");
		ashstonePick = new SimplePickaxe(Config.ashstonePickID, Netherrocks.toolAshstone, "netherrocks", Netherrocks.tabNetherTools).setUnlocalizedName("ashstonePick");
		ashstoneAxe = new SimpleAxe(Config.ashstoneAxeID, Netherrocks.toolAshstone, "netherrocks", Netherrocks.tabNetherTools).setUnlocalizedName("ashstoneAxe");
		ashstoneShovel = new SimpleShovel(Config.ashstoneShovelID, Netherrocks.toolAshstone, "netherrocks", Netherrocks.tabNetherTools).setUnlocalizedName("ashstoneShovel");
		ashstoneSword = new SimpleSword(Config.ashstoneSwordID, Netherrocks.toolAshstone, "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("ashstoneSword");
		ashstoneHoe = new SimpleHoe(Config.ashstoneHoeID, Netherrocks.toolAshstone, "netherrocks", Netherrocks.tabNetherTools).setUnlocalizedName("ashstoneHoe");
		dragonstonePick = new SimplePickaxe(Config.dragonstonePickID, Netherrocks.toolDragonstone, "netherrocks", Netherrocks.tabNetherTools).setUnlocalizedName("dragonstonePick");
		dragonstoneAxe = new SimpleAxe(Config.dragonstoneAxeID, Netherrocks.toolDragonstone, "netherrocks", Netherrocks.tabNetherTools).setUnlocalizedName("dragonstoneAxe");
		dragonstoneShovel = new SimpleShovel(Config.dragonstoneShovelID, Netherrocks.toolDragonstone, "netherrocks", Netherrocks.tabNetherTools).setUnlocalizedName("dragonstoneShovel");
		dragonstoneSword = new SimpleSword(Config.dragonstoneSwordID, Netherrocks.toolDragonstone, "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("dragonstoneSword");
		dragonstoneHoe = new SimpleHoe(Config.dragonstoneHoeID, Netherrocks.toolDragonstone, "netherrocks", Netherrocks.tabNetherTools).setUnlocalizedName("dragonstoneHoe");
		argonitePick = new SimplePickaxe(Config.argonitePickID, Netherrocks.toolArgonite, "netherrocks", Netherrocks.tabNetherTools).setUnlocalizedName("argonitePick");
		argoniteAxe = new SimpleAxe(Config.argoniteAxeID, Netherrocks.toolArgonite, "netherrocks", Netherrocks.tabNetherTools).setUnlocalizedName("argoniteAxe");
		argoniteShovel = new SimpleShovel(Config.argoniteShovelID, Netherrocks.toolArgonite, "netherrocks", Netherrocks.tabNetherTools).setUnlocalizedName("argoniteShovel");
		argoniteSword = new SimpleSword(Config.argoniteSwordID, Netherrocks.toolArgonite, "netherrocks", Netherrocks.tabNetherCombat).setUnlocalizedName("argoniteSword");
		argoniteHoe = new SimpleHoe(Config.argoniteHoeID, Netherrocks.toolArgonite, "netherrocks", Netherrocks.tabNetherTools).setUnlocalizedName("argoniteHoe");
		fyriteSword = new NetherSword(Config.fyriteSwordID, Netherrocks.toolFyrite).setUnlocalizedName("fyriteSword");
		illumeniteSword = new NetherSword(Config.illumeniteSwordID, Netherrocks.toolIllumenite).setUnlocalizedName("illumeniteSword");
		fyritePick = new FyritePickaxe(Config.fyritePickID, Netherrocks.toolFyrite).setUnlocalizedName("fyritePick");
			
		//Tool Naming
		if(Settings.enableOldLocalisation)
		{
			LanguageRegistry.addName(malachitePick, Localisation.malachitePickName);
			LanguageRegistry.addName(malachiteAxe, Localisation.malachiteAxeName);
			LanguageRegistry.addName(malachiteShovel, Localisation.malachiteShovelName);
			LanguageRegistry.addName(malachiteSword, Localisation.malachiteSwordName);
			LanguageRegistry.addName(malachiteHoe, Localisation.malachiteHoeName);
			LanguageRegistry.addName(ashstonePick, Localisation.ashstonePickName);
			LanguageRegistry.addName(ashstoneAxe, Localisation.ashstoneAxeName);
			LanguageRegistry.addName(ashstoneShovel, Localisation.ashstoneShovelName);
			LanguageRegistry.addName(ashstoneSword, Localisation.ashstoneSwordName);
			LanguageRegistry.addName(ashstoneHoe, Localisation.ashstoneHoeName);
			LanguageRegistry.addName(dragonstonePick, Localisation.dragonstoneHoeName);
			LanguageRegistry.addName(dragonstoneAxe, Localisation.dragonstoneAxeName);
			LanguageRegistry.addName(dragonstoneShovel, Localisation.dragonstoneShovelName);
			LanguageRegistry.addName(dragonstoneSword, Localisation.dragonstoneSwordName);
			LanguageRegistry.addName(dragonstoneHoe, Localisation.dragonstoneHoeName);
			LanguageRegistry.addName(argonitePick, Localisation.argonitePickName);
			LanguageRegistry.addName(argoniteAxe, Localisation.argoniteAxeName);
			LanguageRegistry.addName(argoniteShovel, Localisation.argoniteShovelName);
			LanguageRegistry.addName(argoniteSword, Localisation.argoniteSwordName);
			LanguageRegistry.addName(argoniteHoe, Localisation.argoniteHoeName);
			LanguageRegistry.addName(fyriteSword, Localisation.fyriteSwordName);
			LanguageRegistry.addName(illumeniteSword, Localisation.illumeniteSwordName);
			LanguageRegistry.addName(fyritePick, Localisation.fyritePickName);
		}
		
		//Tool Registering
        MinecraftForge.setToolClass(malachitePick, "pickaxe", 3);
        MinecraftForge.setToolClass(malachiteShovel, "shovel", 3);
        MinecraftForge.setToolClass(malachiteAxe, "axe", 3);
        MinecraftForge.setToolClass(ashstonePick, "pickaxe", 3);
        MinecraftForge.setToolClass(ashstoneShovel, "shovel", 3);
        MinecraftForge.setToolClass(ashstoneAxe, "axe", 3);
        MinecraftForge.setToolClass(dragonstonePick, "pickaxe", 4);
        MinecraftForge.setToolClass(dragonstoneShovel, "shovel", 4);
        MinecraftForge.setToolClass(dragonstoneAxe, "axe", 4);
        MinecraftForge.setToolClass(argonitePick, "pickaxe", 3);
        MinecraftForge.setToolClass(argoniteShovel, "shovel", 3);
        MinecraftForge.setToolClass(argoniteAxe, "axe", 3);
        MinecraftForge.setToolClass(fyritePick, "pickaxe", 3);
	}
}

class FyritePickaxe extends ItemPickaxe
{
	private final EnumToolMaterial toolMaterial;
	public FyritePickaxe(int par1, EnumToolMaterial par2EnumToolMaterial) 
	{
		super(par1, par2EnumToolMaterial);
		this.toolMaterial = par2EnumToolMaterial;
		if(Settings.enableSeparateTabs == true)
		{
			this.setCreativeTab(Netherrocks.tabNetherTools);
		}
		else this.setCreativeTab(SimpleOres.tabSimpleBlocks);
	}
	
	/**
	 * Code that makes the Fyrite Pickaxe drop the smelted item rather than the normal drop.
	 * Only affects the Fyrite Pickaxe.
	 */
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, int i, int j, int k, EntityPlayer player)
	{
		if(itemID == Tools.fyritePick.itemID)
		{
			Boolean flag = false;
			World world = player.worldObj;
			int blockID = world.getBlockId(i, j, k);
			int meta = world.getBlockMetadata(i, j, k);

			NBTTagList ench = itemstack.getEnchantmentTagList();
			int level = 0;
			if(ench != null)
			{
				for (int x = 0; x < ench.tagCount(); x++)
				{
					NBTTagCompound nbt = (NBTTagCompound) ench.tagAt(x);
					int id = nbt.getInteger("id");
					if (id == Enchantment.fortune.effectId)
					{
						level = nbt.getInteger("lvl");
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
					ItemStack smelted = FurnaceRecipes.smelting().getSmeltingResult(item).copy();

					world.playSoundEffect(i + 0.5F, j + 0.5F, k + 0.5F,
							Block.blocksList[blockID].stepSound.getBreakSound(),
							(Block.blocksList[blockID].stepSound.getVolume() + 1.0F) / 2.0F,
							Block.blocksList[blockID].stepSound.getPitch() * 0.8F);

					world.setBlock(i, j, k, 0);
					if(!world.isRemote)
					{
						float var6 = 0.7F;
						double var7 = world.rand.nextFloat() * var6 + 1.0F - var6 * 0.5D;
						double var9 = world.rand.nextFloat() * var6 + 1.0F - var6 * 0.5D;
						double var11 = world.rand.nextFloat() * var6 + 1.0F - var6 * 0.5D;
						EntityItem entityitem = new EntityItem(world, i + 0.5D /*+ var7*/, j + 0.5D /*+ var9*/, k + 0.D /*+ var11*/, smelted);
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
}

class NetherSword extends ItemSword
{
	private final EnumToolMaterial toolMaterial;
	public NetherSword(int par1, EnumToolMaterial par2EnumToolMaterial) 
	{
		super(par1, par2EnumToolMaterial);
		this.toolMaterial = par2EnumToolMaterial;
	    if(Settings.enableSeparateTabs == true)
	    {
	        this.setCreativeTab(Netherrocks.tabNetherCombat);
	    }
	    else this.setCreativeTab(SimpleOres.tabSimpleBlocks);
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
     * Adds special effects to the Fyrite and Illumenite Swords.
     */
    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	if(itemID == Tools.fyriteSword.itemID)
    	{
            par1ItemStack.damageItem(1, par3EntityLivingBase);
            par2EntityLivingBase.setFire(100);
    	}
    	
    	if(itemID == Tools.illumeniteSword.itemID)
    	{
            par1ItemStack.damageItem(1, par3EntityLivingBase);
            par3EntityLivingBase.addPotionEffect(new PotionEffect(Potion.nightVision.id, 3600));
            par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.blindness.id, 60));
            
            if(!(par2EntityLivingBase instanceof EntityPlayer))
            {
            	par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 3));
            }
    	}
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        return true;
    }
	
    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	if(itemID == Tools.fyriteSword.itemID)
    	{
            if (par7 == 0)
            {
                --par5;
            }

            if (par7 == 1)
            {
                ++par5;
            }

            if (par7 == 2)
            {
                --par6;
            }

            if (par7 == 3)
            {
                ++par6;
            }

            if (par7 == 4)
            {
                --par4;
            }

            if (par7 == 5)
            {
                ++par4;
            }

            if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
            {
                return false;
            }
            else
            {
                int var11 = par3World.getBlockId(par4, par5, par6);

                if (var11 == 0)
                {
                    par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                    par3World.setBlock(par4, par5, par6, Block.fire.blockID);
                }

                return true;
            }
    	}
    	return true;  	
    }
}
