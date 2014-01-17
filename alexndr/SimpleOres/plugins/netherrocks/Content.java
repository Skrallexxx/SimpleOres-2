package alexndr.SimpleOres.plugins.netherrocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.MinecraftForge;
import alexndr.SimpleOres.api.content.SimpleArmor;
import alexndr.SimpleOres.api.content.SimpleAxe;
import alexndr.SimpleOres.api.content.SimpleHoe;
import alexndr.SimpleOres.api.content.SimpleIngot;
import alexndr.SimpleOres.api.content.SimpleOre;
import alexndr.SimpleOres.api.content.SimplePickaxe;
import alexndr.SimpleOres.api.content.SimpleShovel;
import alexndr.SimpleOres.api.content.SimpleSword;
import alexndr.SimpleOres.api.helpers.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class Content 
{
	public static void initialize()
	{
		try{doBlocks(); LogHelper.verboseInfo("Netherrocks Plugin: All blocks were added successfully.");}
		catch(Exception e){LogHelper.severe("Netherrocks Plugin: Blocks were not added successfully. This is a serious problem!"); e.printStackTrace();}
		try{doItems(); LogHelper.verboseInfo("Netherrocks Plugin: All items were added successfully.");}
		catch(Exception e){LogHelper.severe("Netherrocks Plugin: Items were not added successfully. This is a serious problem!"); e.printStackTrace();}
		try{doTools(); LogHelper.verboseInfo("Netherrocks Plugin: All tools were added successfully.");}
		catch(Exception e){LogHelper.severe("Netherrocks Plugin: Tools were not added successfully. This is a serious problem!"); e.printStackTrace();}
		try{doArmor(); LogHelper.verboseInfo("Netherrocks Plugin: All armor was added successfully.");}
		catch(Exception e){LogHelper.severe("Netherrocks Plugin: Armor was not added successfully. This is a serious problem!"); e.printStackTrace();}
		try{doAchievements(); LogHelper.verboseInfo("Netherrocks Plugin: All achievements were added successfully.");}
		catch(Exception e){LogHelper.severe("Netherrocks Plugin: Achievements were not added successfully. This is a serious problem!"); e.printStackTrace();}
	}
	public static void doBlocks()
	{
		//Block Details
		fyriteOre = new SimpleOre(Config.fyriteOreID, Material.rock).modId("netherrocks").setHardness(Settings.fyriteOreHardness).setResistance(Settings.fyriteOreResistance).setUnlocalizedName("fyriteOre");
		fyriteBlock = new SimpleOre(Config.fyriteBlockID, Material.iron).modId("netherrocks").setHardness(Settings.fyriteBlockHardness).setResistance(Settings.fyriteBlockResistance).setUnlocalizedName("fyriteBlock");
		malachiteOre = new SimpleOre(Config.malachiteOreID, Material.rock).modId("netherrocks").setHardness(Settings.malachiteOreHardness).setResistance(Settings.malachiteOreResistance).setUnlocalizedName("malachiteOre");
		malachiteBlock = new SimpleOre(Config.malachiteBlockID, Material.iron).modId("netherrocks").setHardness(Settings.malachiteBlockHardness).setResistance(Settings.malachiteBlockResistance).setUnlocalizedName("malachiteBlock");
		ashstoneOre = new SimpleOre(Config.ashstoneOreID, Material.rock).modId("netherrocks").setHardness(Settings.ashstoneOreHardness).setResistance(Settings.ashstoneOreResistance).setUnlocalizedName("ashstoneOre");
		ashstoneBlock = new SimpleOre(Config.ashstoneBlockID, Material.iron).modId("netherrocks").setHardness(Settings.ashstoneBlockHardness).setResistance(Settings.ashstoneBlockResistance).setUnlocalizedName("ashstoneBlock");
		illumeniteOre = new SimpleOre(Config.illumeniteOreID, Material.rock).modId("netherrocks").setHardness(Settings.illumeniteOreHardness).setResistance(Settings.illumeniteOreResistance).setUnlocalizedName("illumeniteOre");
		illumeniteBlock = new SimpleOre(Config.illumeniteBlockID, Material.iron).modId("netherrocks").setHardness(Settings.illumeniteBlockHardness).setResistance(Settings.illumeniteBlockResistance).setUnlocalizedName("illumeniteBlock");
		dragonstoneOre = new SimpleOre(Config.dragonstoneOreID, Material.rock).modId("netherrocks").setHardness(Settings.dragonstoneOreHardness).setResistance(Settings.dragonstoneOreResistance).setUnlocalizedName("dragonstoneOre");
		dragonstoneBlock = new SimpleOre(Config.dragonstoneBlockID, Material.iron).modId("netherrocks").setHardness(Settings.dragonstoneBlockHardness).setResistance(Settings.dragonstoneBlockResistance).setUnlocalizedName("dragonstoneBlock");
		argoniteOre = new SimpleOre(Config.argoniteOreID, Material.rock).modId("netherrocks").setHardness(Settings.argoniteOreHardness).setResistance(Settings.argoniteOreResistance).setUnlocalizedName("argoniteOre");
		argoniteBlock = new SimpleOre(Config.argoniteBlockID, Material.iron).modId("netherrocks").setHardness(Settings.argoniteBlockHardness).setResistance(Settings.argoniteBlockResistance).setUnlocalizedName("argoniteBlock");
		netherFurnace = new NetherFurnace(Config.netherFurnaceID, false).setHardness(Settings.netherFurnaceHardness).setResistance(Settings.netherFurnaceResistance).setUnlocalizedName("netherFurnace");
		netherFurnaceOn = new NetherFurnace(Config.netherFurnaceOnID, true).setHardness(Settings.netherFurnaceHardness).setResistance(Settings.netherFurnaceResistance).setLightValue(Settings.netherFurnaceLightValue).setUnlocalizedName("netherFurnaceOn");
		
		//Block Registering
		GameRegistry.registerBlock(netherFurnace, "netherFurnace");
		GameRegistry.registerBlock(netherFurnaceOn, "netherFurnaceOn");
		
		//Block Harvest Levels
		MinecraftForge.setBlockHarvestLevel(fyriteOre, "pickaxe", Settings.fyriteOreHarvestLevel);
		MinecraftForge.setBlockHarvestLevel(malachiteOre, "pickaxe", Settings.malachiteOreHarvestLevel);
		MinecraftForge.setBlockHarvestLevel(ashstoneOre, "pickaxe", Settings.ashstoneOreHarvestLevel);
		MinecraftForge.setBlockHarvestLevel(illumeniteOre, "pickaxe", Settings.illumeniteOreHarvestLevel);
		MinecraftForge.setBlockHarvestLevel(dragonstoneOre, "pickaxe", Settings.dragonstoneOreHarvestLevel);
		MinecraftForge.setBlockHarvestLevel(argoniteOre, "pickaxe", Settings.argoniteOreHarvestLevel);
	}
	
	public static void doItems()
	{
		//Item Details
		fyriteIngot = new SimpleIngot(Config.fyriteIngotID).modId("netherrocks").setUnlocalizedName("fyriteIngot");
		malachiteIngot = new SimpleIngot(Config.malachiteIngotID).modId("netherrocks").setUnlocalizedName("malachiteIngot");
		ashstoneGem = new SimpleIngot(Config.ashstoneGemID).modId("netherrocks").setUnlocalizedName("ashstoneGem");
		illumeniteIngot = new SimpleIngot(Config.illumeniteIngotID).modId("netherrocks").setUnlocalizedName("illumeniteIngot");
		dragonstoneGem = new SimpleIngot(Config.dragonstoneGemID).modId("netherrocks").setUnlocalizedName("dragonstoneGem");
		argoniteIngot = new SimpleIngot(Config.argoniteIngotID).modId("netherrocks").setUnlocalizedName("argoniteIngot");
	}
	
	public static void doTools()
	{
		//Tool Details
		malachitePick = new SimplePickaxe(Config.malachitePickID, Netherrocks.toolMalachite).modId("netherrocks").setToolLevel(3).setUnlocalizedName("malachitePick");
		malachiteAxe = new SimpleAxe(Config.malachiteAxeID, Netherrocks.toolMalachite).modId("netherrocks").setToolLevel(3).setUnlocalizedName("malachiteAxe");
		malachiteShovel = new SimpleShovel(Config.malachiteShovelID, Netherrocks.toolMalachite).modId("netherrocks").setToolLevel(3).setUnlocalizedName("malachiteShovel");
		malachiteHoe = new SimpleHoe(Config.malachiteHoeID, Netherrocks.toolMalachite).modId("netherrocks").setUnlocalizedName("malachiteHoe");
		malachiteSword = new SimpleSword(Config.malachiteSwordID, Netherrocks.toolMalachite).modId("netherrocks").setUnlocalizedName("malachiteSword");
		ashstonePick = new SimplePickaxe(Config.ashstonePickID, Netherrocks.toolAshstone).modId("netherrocks").setToolLevel(3).setUnlocalizedName("ashstonePick");
		ashstoneAxe = new SimpleAxe(Config.ashstoneAxeID, Netherrocks.toolAshstone).modId("netherrocks").setToolLevel(3).setUnlocalizedName("ashstoneAxe");
		ashstoneShovel = new SimpleShovel(Config.ashstoneShovelID, Netherrocks.toolAshstone).modId("netherrocks").setToolLevel(3).setUnlocalizedName("ashstoneShovel");
		ashstoneHoe = new SimpleHoe(Config.ashstoneHoeID, Netherrocks.toolAshstone).modId("netherrocks").setUnlocalizedName("ashstoneHoe");
		ashstoneSword = new SimpleSword(Config.ashstoneSwordID, Netherrocks.toolAshstone).modId("netherrocks").setUnlocalizedName("ashstoneSword");
		dragonstonePick = new SimplePickaxe(Config.dragonstonePickID, Netherrocks.toolDragonstone).modId("netherrocks").setToolLevel(4).setUnlocalizedName("dragonstonePick");
		dragonstoneAxe = new SimpleAxe(Config.dragonstoneAxeID, Netherrocks.toolDragonstone).modId("netherrocks").setToolLevel(4).setUnlocalizedName("dragonstoneAxe");
		dragonstoneShovel = new SimpleShovel(Config.dragonstoneShovelID, Netherrocks.toolDragonstone).modId("netherrocks").setToolLevel(4).setUnlocalizedName("dragonstoneShovel");
		dragonstoneHoe = new SimpleHoe(Config.dragonstoneHoeID, Netherrocks.toolDragonstone).modId("netherrocks").setUnlocalizedName("dragonstoneHoe");
		dragonstoneSword = new SimpleSword(Config.dragonstoneSwordID, Netherrocks.toolDragonstone).modId("netherrocks").setUnlocalizedName("dragonstoneSword");
		argonitePick = new SimplePickaxe(Config.argonitePickID, Netherrocks.toolArgonite).modId("netherrocks").setToolLevel(3).setUnlocalizedName("argonitePick");
		argoniteAxe = new SimpleAxe(Config.argoniteAxeID, Netherrocks.toolArgonite).modId("netherrocks").setToolLevel(3).setUnlocalizedName("argoniteAxe");
		argoniteShovel = new SimpleShovel(Config.argoniteShovelID, Netherrocks.toolArgonite).modId("netherrocks").setToolLevel(3).setUnlocalizedName("argoniteShovel");
		argoniteHoe = new SimpleHoe(Config.argoniteHoeID, Netherrocks.toolArgonite).modId("netherrocks").setUnlocalizedName("argoniteHoe");
		argoniteSword = new SimpleSword(Config.argoniteSwordID, Netherrocks.toolArgonite).modId("netherrocks").setUnlocalizedName("argoniteSword");
		fyriteSword = new NetherSword(Config.fyriteSwordID, Netherrocks.toolFyrite).setUnlocalizedName("fyriteSword");
		illumeniteSword = new NetherSword(Config.illumeniteSwordID, Netherrocks.toolIllumenite).setUnlocalizedName("illumeniteSword");
		fyritePick = new NetherPickaxe(Config.fyritePickID, Netherrocks.toolFyrite).setToolLevel(3).setUnlocalizedName("fyritePick");
	}
	
	public static void doArmor()
	{
		fyriteHelm = new SimpleArmor(Config.fyriteHelmID, Netherrocks.armorFyrite, Netherrocks.rendererFyrite, 0).modId("netherrocks").setType("fyrite").setUnlocalizedName("fyriteHelm");
		fyriteChest = new SimpleArmor(Config.fyriteChestID, Netherrocks.armorFyrite, Netherrocks.rendererFyrite, 1).modId("netherrocks").setType("fyrite").setUnlocalizedName("fyriteChest");
		fyriteLegs = new SimpleArmor(Config.fyriteLegsID, Netherrocks.armorFyrite, Netherrocks.rendererFyrite, 2).modId("netherrocks").setType("fyrite").setUnlocalizedName("fyriteLegs");
		fyriteBoots = new SimpleArmor(Config.fyriteBootsID, Netherrocks.armorFyrite, Netherrocks.rendererFyrite, 3).modId("netherrocks").setType("fyrite").setUnlocalizedName("fyriteBoots");
		malachiteHelm = new SimpleArmor(Config.malachiteHelmID, Netherrocks.armorMalachite, Netherrocks.rendererMalachite, 0).modId("netherrocks").setType("malachite").setUnlocalizedName("malachiteHelm");
		malachiteChest = new SimpleArmor(Config.malachiteChestID, Netherrocks.armorMalachite, Netherrocks.rendererMalachite, 1).modId("netherrocks").setType("malachite").setUnlocalizedName("malachiteChest");
		malachiteLegs = new SimpleArmor(Config.malachiteLegsID, Netherrocks.armorMalachite, Netherrocks.rendererMalachite, 2).modId("netherrocks").setType("malachite").setUnlocalizedName("malachiteLegs");
		malachiteBoots = new SimpleArmor(Config.malachiteBootsID, Netherrocks.armorMalachite, Netherrocks.rendererMalachite, 3).modId("netherrocks").setType("malachite").setUnlocalizedName("malachiteBoots");
		illumeniteHelm = new SimpleArmor(Config.illumeniteHelmID, Netherrocks.armorIllumenite, Netherrocks.rendererIllumenite, 0).modId("netherrocks").setType("illumenite").setUnlocalizedName("illumeniteHelm");
		illumeniteChest = new SimpleArmor(Config.illumeniteChestID, Netherrocks.armorIllumenite, Netherrocks.rendererIllumenite, 1).modId("netherrocks").setType("illumenite").setUnlocalizedName("illumeniteChest");
		illumeniteLegs = new SimpleArmor(Config.illumeniteLegsID, Netherrocks.armorIllumenite, Netherrocks.rendererIllumenite, 2).modId("netherrocks").setType("illumenite").setUnlocalizedName("illumeniteLegs");
		illumeniteBoots = new SimpleArmor(Config.illumeniteBootsID, Netherrocks.armorIllumenite, Netherrocks.rendererIllumenite, 3).modId("netherrocks").setType("illumenite").setUnlocalizedName("illumeniteBoots");
		dragonstoneHelm = new SimpleArmor(Config.dragonstoneHelmID, Netherrocks.armorDragonstone, Netherrocks.rendererDragonstone, 0).modId("netherrocks").setType("dragonstone").setUnlocalizedName("dragonstoneHelm");
		dragonstoneChest = new SimpleArmor(Config.dragonstoneChestID, Netherrocks.armorDragonstone, Netherrocks.rendererDragonstone, 1).modId("netherrocks").setType("dragonstone").setUnlocalizedName("dragonstoneChest");
		dragonstoneLegs = new SimpleArmor(Config.dragonstoneLegsID, Netherrocks.armorDragonstone, Netherrocks.rendererDragonstone, 2).modId("netherrocks").setType("dragonstone").setUnlocalizedName("dragonstoneLegs");
		dragonstoneBoots = new SimpleArmor(Config.dragonstoneBootsID, Netherrocks.armorDragonstone, Netherrocks.rendererDragonstone, 3).modId("netherrocks").setType("dragonstone").setUnlocalizedName("dragonstoneBoots");
	}
	
	public static void doAchievements()
	{
		netherRocksAch = new Achievement(Config.netherRocksAchID, "netherRocksAch", 1, 7, Content.fyriteOre, AchievementList.portal).registerAchievement();
		netherFurnaceAch = new Achievement(Config.netherFurnaceAchID, "netherFurnaceAch", 1, 6, Content.netherFurnaceOn, netherRocksAch).setSpecial().registerAchievement();
	}
	
	//Blocks
	public static Block fyriteOre, malachiteOre, ashstoneOre, illumeniteOre, dragonstoneOre, argoniteOre;
	public static Block fyriteBlock, malachiteBlock, ashstoneBlock, illumeniteBlock, dragonstoneBlock, argoniteBlock;
	public static Block netherFurnace, netherFurnaceOn;
	
	//Items
	public static Item fyriteIngot, malachiteIngot, ashstoneGem, illumeniteIngot, dragonstoneGem, argoniteIngot;
	
	//Tools
	public static Item malachitePick, ashstonePick, dragonstonePick, argonitePick, fyritePick;
	public static Item malachiteAxe, ashstoneAxe, dragonstoneAxe, argoniteAxe;
	public static Item malachiteShovel, ashstoneShovel, dragonstoneShovel, argoniteShovel;
	public static Item malachiteSword, ashstoneSword, dragonstoneSword, argoniteSword, fyriteSword, illumeniteSword;
	public static Item malachiteHoe, ashstoneHoe, dragonstoneHoe, argoniteHoe;
	
	//Armor
	public static Item fyriteHelm, malachiteHelm, illumeniteHelm, dragonstoneHelm;
	public static Item fyriteChest, malachiteChest, illumeniteChest, dragonstoneChest;
	public static Item fyriteLegs, malachiteLegs, illumeniteLegs, dragonstoneLegs;
	public static Item fyriteBoots, malachiteBoots, illumeniteBoots, dragonstoneBoots;
	
	//Achievements
	public static Achievement netherRocksAch, netherFurnaceAch;
}
