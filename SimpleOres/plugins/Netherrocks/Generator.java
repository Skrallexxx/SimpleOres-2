package SimpleOres.plugins.Netherrocks;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class Generator implements IWorldGenerator
{
	/**
	 * Calls the generateNether constructor if the dimension ID is -1 (ie. Nether),
	 * or calls the generateSurface constructor if the dimension ID is 0 (ie. Surface).
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
	 * Generates blocks in the surface. Not used by Netherrocks obviously.
	 */
	private void generateSurface(World world, Random random, int blockX, int blockZ) 
	{
		
	}
	
	/**
	 * Generates blocks in the Nether.
	 */
	private void generateNether(World world, Random rand, int baseX, int baseZ) 
	{
	       for(int i = 0; i < Settings.fyriteSpawnRate; i++)
	        {
	            int randPosX = baseX + rand.nextInt(16);
	            int randPosY = rand.nextInt(256);
	            int randPosZ = baseZ + rand.nextInt(16);
	            new GenNetherrack(Blocks.fyriteOre.blockID, Settings.fyriteVeinSize).generate(world, rand, randPosX, randPosY, randPosZ);          
	        }
	       for(int i = 0; i < Settings.malachiteSpawnRate; i++)
	        {
	            int randPosX = baseX + rand.nextInt(16);
	            int randPosY = rand.nextInt(256);
	            int randPosZ = baseZ + rand.nextInt(16);
	            new GenNetherrack(Blocks.malachiteOre.blockID, Settings.malachiteVeinSize).generate(world, rand, randPosX, randPosY, randPosZ);          
	        }
	       for(int i = 0; i < Settings.ashstoneSpawnRate; i++)
	        {
	            int randPosX = baseX + rand.nextInt(16);
	            int randPosY = rand.nextInt(256);
	            int randPosZ = baseZ + rand.nextInt(16);
	            new GenNetherrack(Blocks.ashstoneOre.blockID, Settings.ashstoneVeinSize).generate(world, rand, randPosX, randPosY, randPosZ);           
	        }
	       for(int i = 0; i < Settings.illumeniteSpawnRate; i++)
	        {
	            int randPosX = baseX + rand.nextInt(16);
	            int randPosY = rand.nextInt(256);
	            int randPosZ = baseZ + rand.nextInt(16);
	            new GenGlowstone(Blocks.illumeniteOre.blockID, Settings.illumeniteVeinSize).generate(world, rand, randPosX, randPosY, randPosZ);          
	        }
	       for(int i = 0; i < Settings.dragonstoneSpawnRate; i++)
	        {
	            int randPosX = baseX + rand.nextInt(16);
	            int randPosY = rand.nextInt(256);
	            int randPosZ = baseZ + rand.nextInt(16);
	            new GenNetherrack(Blocks.dragonstoneOre.blockID, Settings.dragonstoneVeinSize).generate(world, rand, randPosX, randPosY, randPosZ);         
	        }
	       for(int i = 0; i < Settings.argoniteSpawnRate; i++)
	        {
	            int randPosX = baseX + rand.nextInt(16);
	            int randPosY = rand.nextInt(256);
	            int randPosZ = baseZ + rand.nextInt(16);
	            new GenNetherrack(Blocks.argoniteOre.blockID, Settings.argoniteVeinSize).generate(world, rand, randPosX, randPosY, randPosZ);          
	        }
	}
}
