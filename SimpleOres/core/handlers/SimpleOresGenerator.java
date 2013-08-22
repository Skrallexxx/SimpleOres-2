package SimpleOres.core.handlers;

import java.util.Random;

import SimpleOres.core.Achievements;
import SimpleOres.core.Armor;
import SimpleOres.core.Blocks;
import SimpleOres.core.Items;
import SimpleOres.core.Recipes;
import SimpleOres.core.SimpleOres;
import SimpleOres.core.Tools;
import SimpleOres.core.conf.IDs;
import SimpleOres.core.conf.Localisation;
import SimpleOres.core.conf.Settings;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class SimpleOresGenerator implements IWorldGenerator 
{
	/**
	 * Linking to the classes for easier reference.
	 */
	public static SimpleOres mod;
	public static Achievements achievements;
	public static Armor armor;
	public static Blocks blocks;
	public static IDs config;
	public static Items items;
	public static Localisation local;
	public static Recipes recipes;
	public static Settings settings;
	public static Tools tools;
	
	/**
	 * Generates the ores in the world. Depending on which 'world' the player is in (ie. Nether or Surface), different methods are called.
	 * These two methods are generateSurface and generateNether, which are below.
	 */
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch (world.provider.dimensionId)
		{
		   case -1: generateNether(world, random, chunkX*16, chunkZ*16);
		   case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
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
		for(int x =0; x < settings.copperSpawnRate; x++)
		{
		    int Xcoord = blockX + random.nextInt(16);
		    int Ycoord = random.nextInt(settings.copperSpawnHeight);
		    int Zcoord = blockZ + random.nextInt(16);
		    new WorldGenMinable(blocks.copperOre.blockID, settings.copperVeinSize).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
		
		for(int x =0; x < settings.tinSpawnRate; x++)
		{
			int Xcoord = blockX + random.nextInt(16);
		    int Ycoord = random.nextInt(settings.tinSpawnHeight);
		    int Zcoord = blockZ + random.nextInt(16);
		    new WorldGenMinable(blocks.tinOre.blockID, settings.tinVeinSize).generate(world, random, Xcoord, Ycoord, Zcoord);
		}

		for(int x =0; x < settings.mythrilSpawnRate; x++)
		{
		    int Xcoord = blockX + random.nextInt(16);
		    int Ycoord = random.nextInt(settings.mythrilSpawnHeight);
		    int Zcoord = blockZ + random.nextInt(16);
		    new WorldGenMinable(blocks.mythrilOre.blockID, settings.mythrilVeinSize).generate(world, random, Xcoord, Ycoord, Zcoord);
		}

		for(int x =0; x < settings.adamantiumSpawnRate; x++)
		{
		    int Xcoord = blockX + random.nextInt(16);
		    int Ycoord = random.nextInt(settings.adamantiumSpawnHeight);
		    int Zcoord = blockZ + random.nextInt(16);
		    new WorldGenMinable(blocks.adamantiumOre.blockID, settings.adamantiumVeinSize).generate(world, random, Xcoord, Ycoord, Zcoord);
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
	    for(int i = 0; i < settings.onyxSpawnRate; i++)
	    {
	    	int randPosX = baseX + rand.nextInt(16);
	        int randPosY = rand.nextInt(settings.onyxSpawnHeight);
	        int randPosZ = baseZ + rand.nextInt(16);
	        new WorldGenMinableNether(blocks.onyxOre.blockID, settings.onyxVeinSize).generate(world, rand, randPosX, randPosY, randPosZ);       
	    }
	}
}
