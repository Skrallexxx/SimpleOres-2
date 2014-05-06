package alexndr.SimpleOres.plugins.netherrocks;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import alexndr.SimpleOres.api.helpers.WorldGenHelper;
import cpw.mods.fml.common.IWorldGenerator;

public class Generator implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.dimensionId)
		{
		   case -1: generateNether(world, random, chunkX*16, chunkZ*16);
		   case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
		}
	}
	
	/**
	 * Generates blocks in the surface. Not used by Netherrocks.
	 */
	private void generateSurface(World world, Random random, int Xcoord, int Zcoord)
	{
		
	}
	
	/**
	 * Generates blocks in the nether.
	 */
	private void generateNether(World world, Random random, int Xcoord, int Zcoord)
	{
		for(int i = 0; i < Settings.fyriteSpawnRate; i++)
		{
			int randPosX = Xcoord + random.nextInt(16);
            int randPosY = random.nextInt(Settings.fyriteSpawnHeightMax);
            int randPosZ = Zcoord + random.nextInt(16);
            new WorldGenHelper(Content.fyrite_ore, Settings.fyriteVeinSize, Blocks.netherrack).generate(world, random, randPosX, randPosY + Settings.fyriteSpawnHeightMin, randPosZ); 
		}
		
		for(int i = 0; i < Settings.malachiteSpawnRate; i++)
		{
			int randPosX = Xcoord + random.nextInt(16);
            int randPosY = random.nextInt(Settings.malachiteSpawnHeightMax);
            int randPosZ = Zcoord + random.nextInt(16);
            new WorldGenHelper(Content.malachite_ore, Settings.malachiteVeinSize, Blocks.netherrack).generate(world, random, randPosX, randPosY + Settings.malachiteSpawnHeightMin, randPosZ); 
		}
		
		for(int i = 0; i < Settings.ashstoneSpawnRate; i++)
		{
			int randPosX = Xcoord + random.nextInt(16);
            int randPosY = random.nextInt(Settings.ashstoneSpawnHeightMax);
            int randPosZ = Zcoord + random.nextInt(16);
            new WorldGenHelper(Content.ashstone_ore, Settings.ashstoneVeinSize, Blocks.netherrack).generate(world, random, randPosX, randPosY + Settings.ashstoneSpawnHeightMin, randPosZ); 
		}
		
		for(int i = 0; i < Settings.illumeniteSpawnRate; i++)
		{
			int randPosX = Xcoord + random.nextInt(16);
            int randPosY = random.nextInt(Settings.illumeniteSpawnHeightMax);
            int randPosZ = Zcoord + random.nextInt(16);
            new WorldGenHelper(Content.illumenite_ore, Settings.illumeniteVeinSize, Blocks.glowstone).generate(world, random, randPosX, randPosY + Settings.illumeniteSpawnHeightMin, randPosZ); 
		}
		
		for(int i = 0; i < Settings.dragonstoneSpawnRate; i++)
		{
			int randPosX = Xcoord + random.nextInt(16);
            int randPosY = random.nextInt(Settings.dragonstoneSpawnHeightMax);
            int randPosZ = Zcoord + random.nextInt(16);
            new WorldGenHelper(Content.dragonstone_ore, Settings.dragonstoneVeinSize, Blocks.netherrack).generate(world, random, randPosX, randPosY + Settings.dragonstoneSpawnHeightMin, randPosZ); 
		}
		
		for(int i = 0; i < Settings.argoniteSpawnRate; i++)
		{
			int randPosX = Xcoord + random.nextInt(16);
            int randPosY = random.nextInt(Settings.argoniteSpawnHeightMax);
            int randPosZ = Zcoord + random.nextInt(16);
            new WorldGenHelper(Content.argonite_ore, Settings.argoniteVeinSize, Blocks.netherrack).generate(world, random, randPosX, randPosY + Settings.argoniteSpawnHeightMin, randPosZ); 
		}
	}
}
