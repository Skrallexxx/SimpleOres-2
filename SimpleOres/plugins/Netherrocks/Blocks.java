package SimpleOres.plugins.Netherrocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import SimpleOres.core.api.SimpleGemOre;
import SimpleOres.core.api.SimpleOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class Blocks 
{
	/**
	 * Creating the blocks. 
	 */
	public static Block fyriteOre;
	public static Block fyriteBlock;
	public static Block malachiteOre;
	public static Block malachiteBlock;
	public static Block ashstoneOre;
	public static Block ashstoneBlock;
	public static Block illumeniteOre;
	public static Block illumeniteBlock;
	public static Block dragonstoneOre;
	public static Block dragonstoneBlock;
	public static Block argoniteOre;
	public static Block argoniteBlock;
	public static Block netherFurnace;
	public static Block netherFurnaceOn;
	
	/**
	 * Adds properties to the blocks. This constructor is called by the main Netherrocks class. 
	 * Sets the ID, the material, the hardness, and the resistance.
	 * Also registers the block, adds a name to it, and sets its harvest level. 
	 */
	public static void doBlocks()
	{
		//Block Details
		fyriteOre = new SimpleOre(Config.fyriteOreID, Material.rock, "netherrocks", Netherrocks.tabNetherBlocks).setHardness(3F).setResistance(10F).setUnlocalizedName("fyriteOre");
		fyriteBlock = new SimpleOre(Config.fyriteBlockID, Material.iron, "netherrocks", Netherrocks.tabNetherBlocks).setHardness(7F).setResistance(12F).setUnlocalizedName("fyriteBlock");
		malachiteOre = new SimpleOre(Config.malachiteOreID, Material.rock, "netherrocks", Netherrocks.tabNetherBlocks).setHardness(3F).setResistance(10F).setUnlocalizedName("malachiteOre");
		malachiteBlock = new SimpleOre(Config.malachiteBlockID, Material.iron, "netherrocks", Netherrocks.tabNetherBlocks).setHardness(7F).setResistance(12F).setUnlocalizedName("malachiteBlock");
		ashstoneOre = new SimpleGemOre(Config.ashstoneOreID, Material.rock, "netherrocks", Config.ashstoneGemID, Netherrocks.tabNetherBlocks).setHardness(3F).setResistance(10F).setUnlocalizedName("ashstoneOre");
		ashstoneBlock = new SimpleOre(Config.ashstoneBlockID, Material.iron, "netherrocks", Netherrocks.tabNetherBlocks).setHardness(7F).setResistance(12F).setUnlocalizedName("ashstoneBlock");
		illumeniteOre = new SimpleOre(Config.illumeniteOreID, Material.glass, "netherrocks", Netherrocks.tabNetherBlocks).setHardness(3F).setStepSound(Block.soundGlassFootstep).setResistance(10F).setLightValue(1F).setUnlocalizedName("illumeniteOre");
		illumeniteBlock = new SimpleOre(Config.illumeniteBlockID, Material.iron, "netherrocks", Netherrocks.tabNetherBlocks).setHardness(7F).setResistance(12F).setLightValue(1F).setUnlocalizedName("illumeniteBlock");
		dragonstoneOre = new SimpleGemOre(Config.dragonstoneOreID, Material.rock, "netherrocks", Config.dragonstoneGemID, Netherrocks.tabNetherBlocks).setHardness(3F).setResistance(10F).setUnlocalizedName("dragonstoneOre");
		dragonstoneBlock = new SimpleOre(Config.dragonstoneBlockID, Material.iron, "netherrocks", Netherrocks.tabNetherBlocks).setHardness(7F).setResistance(12F).setUnlocalizedName("dragonstoneBlock");
		argoniteOre = new SimpleOre(Config.argoniteOreID, Material.rock, "netherrocks", Netherrocks.tabNetherBlocks).setHardness(3F).setResistance(10F).setUnlocalizedName("argoniteOre");
		argoniteBlock = new SimpleOre(Config.argoniteBlockID, Material.iron, "netherrocks", Netherrocks.tabNetherBlocks).setHardness(7F).setResistance(12F).setUnlocalizedName("argoniteBlock");
		netherFurnace = new NetherFurnaceBlock(Config.netherFurnaceID,  false).setHardness(3.5F).setResistance(10F).setUnlocalizedName("netherFurnace");
		netherFurnaceOn = new NetherFurnaceBlock(Config.netherFurnaceOnID,  true).setHardness(3.5F).setLightValue(1F).setResistance(10F).setUnlocalizedName("netherFurnaceOn");
		
		//Block Registering
		GameRegistry.registerBlock(fyriteOre, "fyriteOre");
		GameRegistry.registerBlock(fyriteBlock, "fyriteBlock");
		GameRegistry.registerBlock(malachiteOre, "malachiteOre");
		GameRegistry.registerBlock(malachiteBlock, "malachiteBlock");
		GameRegistry.registerBlock(ashstoneOre, "ashstoneOre");
		GameRegistry.registerBlock(ashstoneBlock, "ashstoneBlock");
		GameRegistry.registerBlock(illumeniteOre, "illumeniteOre");
		GameRegistry.registerBlock(illumeniteBlock, "illumeniteBlock");
		GameRegistry.registerBlock(dragonstoneOre, "dragonstoneOre");
		GameRegistry.registerBlock(dragonstoneBlock, "dragonstoneBlock");
		GameRegistry.registerBlock(argoniteOre, "argoniteOre");
		GameRegistry.registerBlock(argoniteBlock, "argoniteBlock");
		GameRegistry.registerBlock(netherFurnace, "netherFurnace");
		GameRegistry.registerBlock(netherFurnaceOn, "netherFurnaceOn");
		
		//Block Naming
		if(Settings.enableOldLocalisation)
		{
			LanguageRegistry.addName(fyriteOre, Localisation.fyriteOreName);
			LanguageRegistry.addName(fyriteBlock, Localisation.fyriteBlockName);
			LanguageRegistry.addName(malachiteOre, Localisation.malachiteOreName);
			LanguageRegistry.addName(malachiteBlock, Localisation.malachiteBlockName);
			LanguageRegistry.addName(ashstoneOre, Localisation.ashstoneOreName);
			LanguageRegistry.addName(ashstoneBlock, Localisation.ashstoneBlockName);
			LanguageRegistry.addName(illumeniteOre, Localisation.illumeniteOreName);
			LanguageRegistry.addName(illumeniteBlock, Localisation.illumeniteBlockName);
			LanguageRegistry.addName(dragonstoneOre, Localisation.dragonstoneOreName);
			LanguageRegistry.addName(dragonstoneBlock, Localisation.dragonstoneBlockName);
			LanguageRegistry.addName(argoniteOre, Localisation.argoniteOreName);
			LanguageRegistry.addName(argoniteBlock, Localisation.argoniteBlockName);	
			LanguageRegistry.addName(netherFurnace, Localisation.netherFurnaceName);
			LanguageRegistry.addName(netherFurnaceOn, Localisation.netherFurnaceOnName);
		}
		
		//Block Harvest Levels
        MinecraftForge.setBlockHarvestLevel(fyriteOre, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(malachiteOre, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(ashstoneOre, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(illumeniteOre, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(dragonstoneOre, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(argoniteOre, "pickaxe", 2);
	}
}
