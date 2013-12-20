package alexndr.SimpleOres.plugins.aesthetics;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

import alexndr.SimpleOres.api.HandlerGetFreeIds;
import alexndr.SimpleOres.api.HandlerLogger;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;

public class Config 
{
	private static HandlerGetFreeIds get;
	
	public static void doIDs(FMLPreInitializationEvent event)
	{
		HandlerGetFreeIds.compileIdList();
		
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "SimpleOres Configuration/Plugins");
    	Configuration config = new Configuration(new File(configDir, "AestheticsIDs.cfg"));
    	
    	try
    	{
    		config.load();
    		
    		//Block IDs
    		copperBricksID = config.getBlock("Blocks", "Copper Bricks", get.freeBlock()).getInt();
    		tinBricksID = config.getBlock("Blocks", "Tin Bricks", get.freeBlock()).getInt();
    		mythrilBricksID = config.getBlock("Blocks", "Mythril Bricks", get.freeBlock()).getInt();
    		adamantiumBricksID = config.getBlock("Blocks", "Adamantium Bricks", get.freeBlock()).getInt();
    		onyxBricksID = config.getBlock("Blocks", "Onyx Bricks", get.freeBlock()).getInt();
    		tinFFurnaceID = config.getBlock("Blocks", "Tin Fusion Furnace", get.freeBlock()).getInt();
    		tinFFurnaceOnID = config.getBlock("Blocks", "Tin Fusion Furnace On", get.freeBlock()).getInt();
    		adamantiumFFurnaceID = config.getBlock("Blocks", "Adamantium Fusion Furnace", get.freeBlock()).getInt();
    		adamantiumFFurnaceOnID = config.getBlock("Blocks", "Adamantium Fusion Furnace On", get.freeBlock()).getInt();
    		copperBricksStairsID = config.getBlock("Blocks", "Copper Bricks Stairs", get.freeBlock()).getInt();
    		tinBricksStairsID = config.getBlock("Blocks", "Tin Bricks Stairs", get.freeBlock()).getInt();
    		mythrilBricksStairsID = config.getBlock("Blocks", "Mythril Bricks Stairs", get.freeBlock()).getInt();
    		adamantiumBricksStairsID = config.getBlock("Blocks", "Adamantium Bricks Stairs", get.freeBlock()).getInt();
    		onyxBricksStairsID = config.getBlock("Blocks", "Onyx Bricks Stairs", get.freeBlock()).getInt();		
    	}
    	catch(Exception e)
    	{
    		HandlerLogger.logSevere("Aesthetics Plugin: Failed to load the config.");
    	}
    	finally
    	{
    		config.save();
    	}
	}
	
	//Block IDs
	public static int copperBricksID;
	public static int tinBricksID;
	public static int mythrilBricksID;
	public static int adamantiumBricksID;
	public static int onyxBricksID;
	public static int tinFFurnaceID;
	public static int tinFFurnaceOnID;
	public static int adamantiumFFurnaceID;
	public static int adamantiumFFurnaceOnID;
	public static int copperBricksStairsID;
	public static int tinBricksStairsID;
	public static int mythrilBricksStairsID;
	public static int adamantiumBricksStairsID;
	public static int onyxBricksStairsID;
}
