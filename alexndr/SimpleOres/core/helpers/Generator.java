package alexndr.SimpleOres.core.helpers;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import alexndr.SimpleOres.api.helpers.LogHelper;
import alexndr.SimpleOres.api.helpers.WorldGenHelper;
import alexndr.SimpleOres.core.Content;
import alexndr.SimpleOres.core.Settings;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import cpw.mods.fml.common.IWorldGenerator;

public class Generator implements IWorldGenerator 
{	
	public String dimensionRange;
	/**
	 * Generates the ores in the world. Depending on which 'world' the player is in (ie. Nether or Surface), different methods are called.
	 * These two methods are generateSurface and generateNether, which are below.
	 */
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		if(world.provider.dimensionId == -1)
		{
			generateNether(world, random, chunkX*16, chunkZ*16);
		}
		
		if(world.provider.dimensionId == 0)
		{
			generateSurface(world, random, chunkX*16, chunkZ*16);
		}
		
		if(Settings.enableCustomGeneration && Settings.numCustomGenerationRules > 0)
		{
    		for(int i = 0; i < Settings.numCustomGenerationRules; i++)
    		{
    			String customRule = Settings.settings.get("Custom Generation Rules", "Custom Rule #" + (i+1), new String()).getString();
    			
    			if(world.provider.dimensionId == splitCustomRuleInts(customRule, "dimensionId") || splitCustomRuleInts(customRule, "dimensionId") == -99999 || (splitCustomRuleInts(customRule, "dimensionId") == 99999 && isInRange(world.provider.dimensionId, dimensionRange)))
    			{
    				generateHigher(customRule, world, random, chunkX*16, chunkZ*16);
    			}
    		}
		}
	}
	
	/**
	 * Sets the details for how the blocks should spawn on the surface world. 
	 * 
	 * Configurable options are spawn rate, spawn height, vein size, and the block which spawns. 
	 * Lowest and highest spawn heights can be set. 
	 * 
	 * Will only spawn if the toggle booleans return true. This is so ores can be prevented from spawning.
	 * 
	 * WorldGenMinable determines which block the ores generate in.
	 * 
	 * WorldGenMinable will generate in stone, ie. for surface ores.
	 */
	private void generateSurface(World world, Random random, int blockX, int blockZ) 
	{
		for(int x = 0; x < Settings.copperSpawnRate; x++)
		{
		    int Xcoord = blockX + random.nextInt(16);
		    int Ycoord = random.nextInt(Settings.copperMaxHeight - Settings.copperMinHeight);
		    int Zcoord = blockZ + random.nextInt(16);
		    new WorldGenHelper(Content.copper_ore, Settings.copperVeinSize, Blocks.stone).generate(world, random, Xcoord, Ycoord + Settings.copperMinHeight, Zcoord);		   
		}
		
		for(int x = 0; x < Settings.tinSpawnRate; x++)
		{
			int Xcoord = blockX + random.nextInt(16);
		    int Ycoord = random.nextInt(Settings.tinMaxHeight - Settings.tinMinHeight);
		    int Zcoord = blockZ + random.nextInt(16);
		    new WorldGenHelper(Content.tin_ore, Settings.tinVeinSize, Blocks.stone).generate(world, random, Xcoord, Ycoord + Settings.tinMinHeight, Zcoord);
		}

		for(int x = 0; x < Settings.mythrilSpawnRate; x++)
		{
		    int Xcoord = blockX + random.nextInt(16);
		    int Ycoord = random.nextInt(Settings.mythrilMaxHeight - Settings.mythrilMinHeight);
		    int Zcoord = blockZ + random.nextInt(16);
		    new WorldGenHelper(Content.mythril_ore, Settings.mythrilVeinSize, Blocks.stone).generate(world, random, Xcoord, Ycoord + Settings.mythrilMinHeight, Zcoord);

		}

		for(int x = 0; x < Settings.adamantiumSpawnRate; x++)
		{
		    int Xcoord = blockX + random.nextInt(16);
		    int Ycoord = random.nextInt(Settings.adamantiumMaxHeight - Settings.adamantiumMinHeight);
		    int Zcoord = blockZ + random.nextInt(16);
		    new WorldGenHelper(Content.adamantium_ore, Settings.adamantiumVeinSize, Blocks.stone).generate(world, random, Xcoord, Ycoord + Settings.adamantiumMinHeight, Zcoord);
		}
	}
	
	/**
	 * Sets the details for how the blocks should spawn in the nether world. 
	 * 
	 * Configurable options are spawn rate, spawn height, vein size, and the block which spawns. 
	 * Lowest and highest spawn heights can be set. 
	 * 
	 * Will only spawn if the toggle booleans return true. This is so ores can be prevented from spawning.
	 * 
	 * WorldGenMinableNether determines which block the ores generate in.
	 * 
	 * WorldGenMinableNether (a SimpleOres custom class BTW) will generate in netherrack, ie. for nether ores.
	 */
	private void generateNether(World world, Random rand, int baseX, int baseZ) 
	{
	    for(int i = 0; i < Settings.onyxSpawnRate; i++)
	    {
	    	int randPosX = baseX + rand.nextInt(16);
	        int randPosY = rand.nextInt(Settings.onyxMaxHeight - Settings.onyxMinHeight);
	        int randPosZ = baseZ + rand.nextInt(16);
	        new WorldGenHelper(Content.onyx_ore, Settings.onyxVeinSize, Blocks.netherrack).generate(world, rand, randPosX, randPosY + Settings.onyxMinHeight, randPosZ);
	    }
	}
	
	/**
	 * Generates the main surface ores in dimensions other than the vanilla ones.
	 * This is all configurable through the settings file, and is classified as "Advanced".
	 * 
	 * Each different dimension can have different spawn rates, with support for up to ~30000 dimensions (I think).
	 */
	private void generateHigher(String customRule, World world, Random random, int blockX, int blockZ) 
	{
		if(Settings.enableCustomGeneration)
		{
			int spawnRate = splitCustomRuleInts(customRule, "spawnRate");
			int maxHeight = splitCustomRuleInts(customRule, "maxHeight");
			int minHeight = splitCustomRuleInts(customRule, "minHeight");
			int veinSize = splitCustomRuleInts(customRule, "veinSize");
			Block hostBlock = splitCustomRuleBlocks(customRule, "hostBlock");
			Block spawningBlock = splitCustomRuleBlocks(customRule, "spawningBlock");
			
		    for(int i = 0; i < spawnRate; i++)
		    {	
			    int Xcoord = blockX + random.nextInt(16);
			    int Ycoord = random.nextInt(maxHeight - minHeight);
			    int Zcoord = blockZ + random.nextInt(16);
			    new WorldGenHelper(spawningBlock, veinSize, hostBlock).generate(world, random, Xcoord, Ycoord + minHeight, Zcoord);
		    }
		}
	}
	
	private int splitCustomRuleInts(String customRule, String requestedComponent)
	{
		String rule = customRule;
		List ruleParts = Lists.newArrayList(Splitter.on(',').trimResults().split(rule));
		
		if(requestedComponent == "dimensionId")
		{
			if(ruleParts.get(0).toString() == "ALL")
			{
				return -99999;
			}
			else if(ruleParts.get(0).toString().contains(":"))
			{
				dimensionRange = ruleParts.get(0).toString();
				return 99999;
			}
			else
				return Integer.parseInt(ruleParts.get(0).toString());
		}
		
		if(requestedComponent == "spawnRate")
		{
			return Integer.parseInt(ruleParts.get(3).toString());
		}
			
		if(requestedComponent == "maxHeight")
		{
			return Integer.parseInt(ruleParts.get(4).toString());
		}
		
		if(requestedComponent == "minHeight")
		{
			return Integer.parseInt(ruleParts.get(5).toString());
		}
		
		if(requestedComponent == "veinSize")
		{
			return Integer.parseInt(ruleParts.get(6).toString());
		}
		
		else
		{
			return 0;
		}
	}
	
	private Block splitCustomRuleBlocks(String customRule, String requestedComponent)
	{
		String rule = customRule;
		List ruleParts = Lists.newArrayList(Splitter.on(',').trimResults().split(rule));
		List hostBlockInfo = Lists.newArrayList(Splitter.on('@').split(ruleParts.get(1).toString()));
		List spawningBlockInfo = Lists.newArrayList(Splitter.on('@').split(ruleParts.get(2).toString()));
		
		if(requestedComponent == "hostBlock")
		{
			Block hostBlock = (Block) Block.blockRegistry.getObject(hostBlockInfo.get(0).toString());
			int meta = Integer.parseInt(hostBlockInfo.get(1).toString());
			ItemStack stack = new ItemStack(hostBlock, 1, meta);
			return Block.getBlockFromItem(stack.getItem());
		}
		
		if(requestedComponent == "spawningBlock")
		{
			Block spawningBlock = (Block) Block.blockRegistry.getObject(spawningBlockInfo.get(0).toString());
			int meta = Integer.parseInt(spawningBlockInfo.get(1).toString());
			ItemStack stack = new ItemStack(spawningBlock, 1, meta);
			return Block.getBlockFromItem(stack.getItem());
		}
		
		else
		{
			return null;
		}
	}
	
	private boolean isInRange(int worldId, String customRule)
	{
		List dimensionRange = Lists.newArrayList(Splitter.on(':').split(customRule));
		try
		{
			int lowerId = Integer.parseInt(dimensionRange.get(0).toString());
			int upperId = Integer.parseInt(dimensionRange.get(1).toString());
			if(lowerId < upperId)
			{
				if(worldId >= lowerId && worldId <= upperId)
				{
					return true;
				}
			}
			
			else
				return false;
		}
		catch(Exception e)
		{
			LogHelper.warning("Error processing custom dimension generation rule: " + customRule);
			LogHelper.warning("You attempted to enter a dimension range, but have done so incorrectly. Make sure the first number is LESS THAN the second number.");;
		}
		
		return false;
	}
}		