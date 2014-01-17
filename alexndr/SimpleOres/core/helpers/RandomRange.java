package alexndr.SimpleOres.core.helpers;

import java.util.Random;

public class RandomRange extends Random
{
	public int nextInt(int min, int max)
	{
		return nextInt(max - min + 1) + min;
	}
}
