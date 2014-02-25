package alexndr.SimpleOres.core.handlers;

import java.util.Random;

import alexndr.SimpleOres.core.Armor;
import alexndr.SimpleOres.core.Tools;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class HandlerJoinWorld
{
  public static double rand;
  public static int range;

  public static RandomRange random = new RandomRange();
  
  public static final String HANDLED_KEY = "simpleores.spawn.handled";
  
  /**
   * This class allows zombies and skeletons to spawn holding/wearing SimpleOres items.
   */
  @ForgeSubscribe
  public void EntityJoinWorldEvent(EntityJoinWorldEvent event)
  {
    if (event.world.isRemote
        || !(event.entity instanceof EntitySkeleton || event.entity instanceof EntityZombie)
        || event.entity.getEntityData().getBoolean(HANDLED_KEY))
      return;
    event.entity.getEntityData().setBoolean(HANDLED_KEY, true);
      
    rand = Math.random();
    range = random.nextInt(1, 16);
    if (rand <= 0.03D)
    {
      EntityLiving living = (EntityLiving)event.entity;
      if (range == 1) {
        living.setCurrentItemOrArmor(4, new ItemStack(Armor.copperHelm));
      }

      if (range == 2) {
        living.setCurrentItemOrArmor(3, new ItemStack(Armor.copperChest));
      }

      if (range == 3) {
        living.setCurrentItemOrArmor(2, new ItemStack(Armor.copperLegs));
      }

      if (range == 4) {
        living.setCurrentItemOrArmor(1, new ItemStack(Armor.copperBoots));
      }

      if (range == 5) {
        living.setCurrentItemOrArmor(4, new ItemStack(Armor.mythrilHelm));
      }

      if (range == 6) {
        living.setCurrentItemOrArmor(3, new ItemStack(Armor.mythrilChest));
      }

      if (range == 7) {
        living.setCurrentItemOrArmor(2, new ItemStack(Armor.mythrilLegs));
      }

      if (range == 8) {
        living.setCurrentItemOrArmor(1, new ItemStack(Armor.mythrilBoots));
      }

      if (range == 9) {
        living.setCurrentItemOrArmor(4, new ItemStack(Armor.adamantiumHelm));
      }

      if (range == 10) {
        living.setCurrentItemOrArmor(3, new ItemStack(Armor.onyxChest));
      }

      if (range == 11) {
        living.setCurrentItemOrArmor(2, new ItemStack(Armor.adamantiumLegs));
      }

      if (range == 12) {
        living.setCurrentItemOrArmor(1, new ItemStack(Armor.onyxBoots));
      }
      
      if (range == 13) {
          living.setCurrentItemOrArmor(0, new ItemStack(Tools.copperSword));
        }
      
      if (range == 14) {
          living.setCurrentItemOrArmor(0, new ItemStack(Tools.mythrilSword));
        }
      
      if (range == 15) {
          living.setCurrentItemOrArmor(0, new ItemStack(Tools.adamantiumSword));
        }
      
      if (range == 16) {
          living.setCurrentItemOrArmor(0, new ItemStack(Tools.onyxSword));
        }
    }
  }
}

class RandomRange extends Random
{
	public int nextInt(int min, int max)
	{
		return nextInt(max - min + 1) + min;
	}
}
