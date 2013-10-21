package SimpleOres.core.handlers;

import java.util.Random;

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
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class Generator implements IWorldGenerator 
{	
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
		
		else if(world.provider.dimensionId == 0)
		{
			generateSurface(world, random, chunkX*16, chunkZ*16);
		}
		
		else if(Settings.dimensionIDsArray.length >= 1)
		{
			for(int i = 0; i < Settings.dimensionIDsArray.length; i++)
			{
				if(world.provider.dimensionId == Settings.dimensionIDsArray[i])
				{
					generateHigher(world, random, chunkX*16, chunkZ*16, Settings.dimensionIDsArray[i]);
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
		    new WorldGenMinable(Blocks.copperOre.blockID, Settings.copperVeinSize).generate(world, random, Xcoord, Ycoord + Settings.copperMinHeight, Zcoord);
		}
		
		for(int x = 0; x < Settings.tinSpawnRate; x++)
		{
			int Xcoord = blockX + random.nextInt(16);
		    int Ycoord = random.nextInt(Settings.tinMaxHeight - Settings.tinMinHeight);
		    int Zcoord = blockZ + random.nextInt(16);
		    new WorldGenMinable(Blocks.tinOre.blockID, Settings.tinVeinSize).generate(world, random, Xcoord, Ycoord + Settings.tinMinHeight, Zcoord);
		}

		for(int x = 0; x < Settings.mythrilSpawnRate; x++)
		{
		    int Xcoord = blockX + random.nextInt(16);
		    int Ycoord = random.nextInt(Settings.mythrilMaxHeight - Settings.mythrilMinHeight);
		    int Zcoord = blockZ + random.nextInt(16);
		    new WorldGenMinable(Blocks.mythrilOre.blockID, Settings.mythrilVeinSize).generate(world, random, Xcoord, Ycoord + Settings.mythrilMinHeight, Zcoord);
		}

		for(int x = 0; x < Settings.adamantiumSpawnRate; x++)
		{
		    int Xcoord = blockX + random.nextInt(16);
		    int Ycoord = random.nextInt(Settings.adamantiumMaxHeight - Settings.adamantiumMinHeight);
		    int Zcoord = blockZ + random.nextInt(16);
		    new WorldGenMinable(Blocks.adamantiumOre.blockID, Settings.adamantiumVeinSize).generate(world, random, Xcoord, Ycoord + Settings.adamantiumMinHeight, Zcoord);
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
	        new GenNetherrack(Blocks.onyxOre.blockID, Settings.onyxVeinSize).generate(world, rand, randPosX, randPosY + Settings.onyxMinHeight, randPosZ);       
	    }
	}
	
	/**
	 * Generates the main surface ores in dimensions other than the vanilla ones.
	 * This is all configurable through the settings file, and is classified as "Advanced".
	 * 
	 * Each different dimension can have different spawn rates, with support for up to ~30000 dimensions (I think).
	 */
	private void generateHigher(World world, Random random, int blockX, int blockZ, int dimensionID) 
	{
		if(Settings.enableHigherDimensionGen)
		{
			for(int i = 0; i < Settings.dimensionIDsArray.length; i++)
			{
				int copperRate = Settings.settings.get("Higher Dimension ID: " + dimensionID, "Copper Spawn Rate", 35).getInt();
				int tinRate = Settings.settings.get("Higher Dimension ID: " + dimensionID, "Tin Spawn Rate", 30).getInt();
				int mythrilRate = Settings.settings.get("Higher Dimension ID: " + dimensionID, "Mythril Spawn Rate", 8).getInt();
				int adamantiumRate = Settings.settings.get("Higher Dimension ID: " + dimensionID, "Adamantium Spawn Rate", 4).getInt();
				
				for(int x = 0; x < copperRate; x++)
				{
					int maxHeight = Settings.settings.get("Higher Dimension ID: " + dimensionID, "Copper Max Spawn Height", 90).getInt();
					int minHeight = Settings.settings.get("Higher Dimension ID: " + dimensionID, "Copper Min Spawn Height", 0).getInt();
					int veinSize = Settings.settings.get("Higher Dimension ID: " + dimensionID, "Copper Vein Size", 7).getInt();
					
				    int Xcoord = blockX + random.nextInt(16);
				    int Ycoord = random.nextInt(maxHeight - minHeight);
				    int Zcoord = blockZ + random.nextInt(16);
				    new WorldGenMinable(Blocks.copperOre.blockID, veinSize).generate(world, random, Xcoord, Ycoord + minHeight, Zcoord);
				    //System.out.println("SimpleOres has generated " + copperRate + " Copper in Dimension " + Settings.dimensionIDsArray[i] + " with MinHeight " + minHeight + " and MaxHeight " + maxHeight + " and VeinSize " + veinSize);
				}
				
				for(int x = 0; x < tinRate; x++)
				{
					int maxHeight = Settings.settings.get("Higher Dimension ID: " + dimensionID, "Tin Max Spawn Height", 90).getInt();
					int minHeight = Settings.settings.get("Higher Dimension ID: " + dimensionID, "Tin Min Spawn Height", 0).getInt();
					int veinSize = Settings.settings.get("Higher Dimension ID: " + dimensionID, "Tin Vein Size", 7).getInt();
					
				    int Xcoord = blockX + random.nextInt(16);
				    int Ycoord = random.nextInt(maxHeight - minHeight);
				    int Zcoord = blockZ + random.nextInt(16);
				    new WorldGenMinable(Blocks.tinOre.blockID, veinSize).generate(world, random, Xcoord, Ycoord + minHeight, Zcoord);
				    //System.out.println("SimpleOres has generated " + copperRate + " Tin in Dimension " + Settings.dimensionIDsArray[i] + " with MinHeight " + minHeight + " and MaxHeight " + maxHeight + " and VeinSize " + veinSize);
				}
				
				for(int x = 0; x < mythrilRate; x++)
				{
					int maxHeight = Settings.settings.get("Higher Dimension ID: " + dimensionID, "Mythril Max Spawn Height", 35).getInt();
					int minHeight = Settings.settings.get("Higher Dimension ID: " + dimensionID, "Mythril Min Spawn Height", 0).getInt();
					int veinSize = Settings.settings.get("Higher Dimension ID: " + dimensionID, "Mythril Vein Size", 4).getInt();
					
				    int Xcoord = blockX + random.nextInt(16);
				    int Ycoord = random.nextInt(maxHeight - minHeight);
				    int Zcoord = blockZ + random.nextInt(16);
				    new WorldGenMinable(Blocks.mythrilOre.blockID, veinSize).generate(world, random, Xcoord, Ycoord + minHeight, Zcoord);
				    //System.out.println("SimpleOres has generated " + copperRate + " Mythril in Dimension " + Settings.dimensionIDsArray[i] + " with MinHeight " + minHeight + " and MaxHeight " + maxHeight + " and VeinSize " + veinSize);
				}
				
				for(int x = 0; x < adamantiumRate; x++)
				{
					int maxHeight = Settings.settings.get("Higher Dimension ID: " + dimensionID, "Adamantium Max Spawn Height", 20).getInt();
					int minHeight = Settings.settings.get("Higher Dimension ID: " + dimensionID, "Adamantium Min Spawn Height", 0).getInt();
					int veinSize = Settings.settings.get("Higher Dimension ID: " + dimensionID, "Adamantium Vein Size", 4).getInt();
					
				    int Xcoord = blockX + random.nextInt(16);
				    int Ycoord = random.nextInt(maxHeight - minHeight);
				    int Zcoord = blockZ + random.nextInt(16);
				    new WorldGenMinable(Blocks.mythrilOre.blockID, veinSize).generate(world, random, Xcoord, Ycoord + minHeight, Zcoord);
				    //System.out.println("SimpleOres has generated " + copperRate + " Adamantium in Dimension " + Settings.dimensionIDsArray[i] + " with MinHeight " + minHeight + " and MaxHeight " + maxHeight + " and VeinSize " + veinSize);
				}
			}
		}
	}
	
	private void generateNothing()
	{
		
	}
}
