package SimpleOres.core.handlers;

import java.util.Random;

public class RandomRange extends Random
{
  public int nextIntII(int min, int max)
  {
    return nextInt(max - min + 1) + min;
  }
}