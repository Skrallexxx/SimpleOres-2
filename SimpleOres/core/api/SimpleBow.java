 package SimpleOres.core.api;

import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import SimpleOres.core.Achievements;
import SimpleOres.core.Armor;
import SimpleOres.core.Blocks;
import SimpleOres.core.Config;
import SimpleOres.core.Items;
import SimpleOres.core.Localisation;
import SimpleOres.core.Recipes;
import SimpleOres.core.Settings;
import SimpleOres.core.SimpleOres;
import SimpleOres.core.Tools;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
 
public class SimpleBow extends ItemBow
{	
	/**
	 * The EnumToolMaterial for the tool. This is used to set what item can be used to repair it.
	 */
    private final EnumToolMaterial material;
	
    /**
     * Creating the icons for the bows. As you draw the bows back, the icon changes, which is why there are 4 icons for each bow here.
     */ 
	public static Icon mythrilBow;
	public static Icon mythrilBow1;
	public static Icon mythrilBow2;
	public static Icon mythrilBow3;	
	public static Icon onyxBow;
	public static Icon onyxBow1;
	public static Icon onyxBow2;
	public static Icon onyxBow3;
		
	/**
	 * Constructor for the bows. Worth noting are the following:
	 * 
	 * "this.maxStackSize = 1;" This basically just sets it so that you can only have one per stack.
	 * "this.bFull3D = true;" This allows it to be rendered in proper 3D when held in your hand. Tools are rendered like this, while items such as sugar are not. 
	 */
	public SimpleBow(int par1, int dam, EnumToolMaterial enumtoolmaterial)
	{
		super(par1);
		this.maxStackSize = 1;	
		material = enumtoolmaterial;
		this.canRepair = true;
		
    	if(Settings.enableSeparateTabs == true)
    	{
            this.setCreativeTab(SimpleOres.tabSimpleCombat);
    	}
    	else this.setCreativeTab(SimpleOres.tabSimpleBlocks);
    	
	    this.bFull3D = true;
	    this.setMaxDamage(dam);
	}
	
	/**
	 * Registers the icons for the bows. All icons are registered, and the default icons (when you haven't drawn it back at all) are set.
	 * 
	 * The default image for the mythril bow is set as mythrilBow.
	 * The default image for the onyx bow is set as onyxBow.
	 * The default image for the thyrium bow is set as thyriumBow.
	 * The default image for the sinisite bow is set as sinisiteBow.
	 */
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{		
		if(itemID == Tools.mythrilBow.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("simpleores:" + "mythrilBow");
		}
		
		if(itemID == Tools.onyxBow.itemID)
		{
			this.itemIcon = iconRegister.registerIcon("simpleores:" + "onyxBow");
		}	
		
		mythrilBow = iconRegister.registerIcon("simpleores:" + "mythrilBow");
		mythrilBow1 = iconRegister.registerIcon("simpleores:" + "mythrilBow1");
		mythrilBow2 = iconRegister.registerIcon("simpleores:" + "mythrilBow2");
		mythrilBow3 = iconRegister.registerIcon("simpleores:" + "mythrilBow3");		
		onyxBow = iconRegister.registerIcon("simpleores:" + "onyxBow");
		onyxBow1 = iconRegister.registerIcon("simpleores:" + "onyxBow1");
		onyxBow2 = iconRegister.registerIcon("simpleores:" + "onyxBow2");
		onyxBow3 = iconRegister.registerIcon("simpleores:" + "onyxBow3");
	}
	
	/**
	 * Gets the icon based on draw back time. As you draw back for longer, the image changes. 
	 * 
	 * The GL11.glTranslate/Rotate sets how the item is held in third person, so it is held like a bow rather than a tool
	 * (ie. hand on the grip in the middle, not at the bottom.
	 */
	public Icon getIcon(ItemStack itemStack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) 
	{	
		if(Minecraft.getMinecraft().gameSettings.thirdPersonView != 0)
		{
            GL11.glTranslatef(0.0F, -0.6F, -0.025F);
	        GL11.glRotatef(-17.0F, 0.0F, 0.0F, 1.0F);
	        GL11.glRotatef(14.0F, 1.0F, 0.0F, 0.0F);
	        GL11.glRotatef(4.5F, 0.0F, 1.0F, 0.0F);
		}
		
		if (player.getItemInUse() == null) return this.itemIcon;
		int var8 = itemStack.getMaxItemUseDuration() - useRemaining;
		if (var8 >= 18)
		{		
			if(itemID == Tools.mythrilBow.itemID)
			{
				return mythrilBow3;
			}
			
			if(itemID == Tools.onyxBow.itemID)
			{
				return onyxBow3;
			}
		}
		if (var8 > 13)
		{
			if(itemID == Tools.mythrilBow.itemID)
			{
				return mythrilBow2;
			}
			
			if(itemID == Tools.onyxBow.itemID)
			{
				return onyxBow2;
			}
		}		
		if (var8 > 0)
		{
			if(itemID == Tools.mythrilBow.itemID)
			{
				return mythrilBow1;
			}
			
			if(itemID == Tools.onyxBow.itemID)
			{
				return onyxBow1;
			}
		}
		return this.itemIcon;
	}
	
	/**
	 * Sets the rarity of the item. This gives it a different coloured name (like with the golden apple).
	 * This is not in use though, it is simply here for reference so I can remember how to do it if I choose to do so later.
	 */
	/*
	public EnumRarity getRarity(ItemStack itemstack) 
	{
		if(itemID == SimpleOres.silverBow.itemID)
		{
			return EnumRarity.uncommon;
		}
		
		if(itemID == SimpleOres.mythrilBow.itemID)
		{
			return EnumRarity.rare;
		}
		
		if(itemID == SimpleOres.onyxBow.itemID)
		{
			return EnumRarity.epic;
		}
		
		else return EnumRarity.common;				
	}
	*/
	
	/**
	 * Adds info to the tool tip when you hover over the item. This is just to show the special effects of the bows.
	 */
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if(itemID == Tools.mythrilBow.itemID)
		{
			if(Settings.enableOldLocalisation)
			{
				par3List.add(Localisation.damageTooltip);
				par3List.add(Localisation.efficiencyTooltip);
			}
			else
			{
				par3List.add(StatCollector.translateToLocal("tips.damageTooltip"));
				par3List.add(StatCollector.translateToLocal("tips.efficiencyTooltip"));
			}
		}
		
		if(itemID == Tools.onyxBow.itemID)
		{
			if(Settings.enableOldLocalisation)
			{
				par3List.add(Localisation.damageTooltip);
				par3List.add(Localisation.flameTooltip);
			}
			else
			{
				par3List.add(StatCollector.translateToLocal("tips.damageTooltip"));
				par3List.add(StatCollector.translateToLocal("tips.flameTooltip"));
			}
		}
	}
		
	/**
	 * Determines what happens when you let go of the right mouse button, usually firing an arrow.
	 * Sets the arrows speed etc. depending on drawback time.
	 * 
	 * This is also where the special effects are determined, such as flame, damage and knockback. The Mythril Bows chance to not consume an arrow is determined here too.
	 */
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) 
	{
		int var6 = getMaxItemUseDuration(par1ItemStack) - par4;
		ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, var6);
		MinecraftForge.EVENT_BUS.post(event);
		
		if (event.isCanceled()) 
		{
			return;
		}
		
		var6 = event.charge;
		boolean flag = (par3EntityPlayer.capabilities.isCreativeMode) || (EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0);
		
		if ((flag) || (par3EntityPlayer.inventory.hasItem(Item.arrow.itemID))) 
		{
			int i = getMaxItemUseDuration(par1ItemStack) - par4;
			float f = i / 20.0F;
			f = (f * f + f * 2.0F) / 3.0F;
			
			if (f < 0.1D) 
			{
				return;
			}
			
			if (f > 1.0F) 
			{
				f = 1.0F;
			}
			
			EntityArrow var8 = new EntityArrow(par2World, par3EntityPlayer, f * 2.0F);
			
			if (f == 1.0F) 
			{
				var8.setIsCritical(true);
			}
			
			if (f == 1.0F && itemID == Tools.onyxBow.itemID) 
			{
				var8.setIsCritical(true);
				var8.setFire(100);
			}
			
			int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);			
			
			if (j > 0) 
			{
				var8.setDamage(var8.getDamage() + j * 0.5D + 0.5D);
			}
			
			int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);			
			
			if (k > 0) 
			{
				var8.setKnockbackStrength(k);
			}
			
			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0) 
			{
				var8.setFire(100);
			}
			
			par1ItemStack.damageItem(1, par3EntityPlayer);
			par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
			
            Random generator = new Random();
            
        	int z;
        	int r = generator.nextInt(100);
        	
        	if(r <= 50)
        	{
        		z = 1;
        	}
        	
           	else
        	{
        		z = 0;
        	}
			
			if (!flag) 
			{
            	if(z == 1 && itemID == Tools.mythrilBow.itemID)
            	{
            		var8.canBePickedUp = 0;
            	}
            	
               	else 
            	{
            		par3EntityPlayer.inventory.consumeInventoryItem(Item.arrow.itemID);
            	}
			}
						
			else 
			{
				var8.canBePickedUp = 2;
			}
			
			if (!par2World.isRemote) 
			{
				par2World.spawnEntityInWorld(var8);
				
				if(itemID == Tools.mythrilBow.itemID)
				{
					var8.setDamage(var8.getDamage() + Settings.mythrilBowDamageModifier * 0.5D + 0.5D);
				}
				
				if(itemID == Tools.onyxBow.itemID)
				{
					var8.setDamage(var8.getDamage() + Settings.onyxBowDamageModifier * 0.5D + 0.5D);
				}
			}
		}
	}

	public ItemStack onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) 
	{ 
		return par1ItemStack; 		
	}
 
	/**
	 * Determines how long you can use the item for. Not sure if it actually has any effect.
	 */
	public int getMaxItemUseDuration(ItemStack par1ItemStack) 
	{
		return 72000;
	}
	
	/**
	 * Gets the action for holding right click, in this case the bow action.
	 */
	public EnumAction getItemUseAction(ItemStack par1ItemStack) 
	{
		return EnumAction.bow;
	}
	
	/**
	 * 
	 */
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) 
	{
		if ((par3EntityPlayer.capabilities.isCreativeMode) || (par3EntityPlayer.inventory.hasItem(Item.arrow.itemID))) 
		{
			par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
		}

		return par1ItemStack;
	}
	
	/**
	 * Gets the items enchtantability.
	 */
	public int getItemEnchantability() 
	{
		return 1;
	}
	
	/**
	 * Determines if the tool is repairable, and gets the item which can be used to repair it depending on the material of the tool.
	 * 
	 * For example, a mythril bow can be repaired with a mythril ingot, an onyx bow with an onyx gem.
	 */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return this.material.getToolCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
}