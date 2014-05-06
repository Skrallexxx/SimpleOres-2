package alexndr.SimpleOres.core.helpers;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import alexndr.SimpleOres.core.Content;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class JoinWorldHelper
{
  public static double rand;
  public static int range;

  public static RandomRange random = new RandomRange();
  
  public static final String HANDLED_KEY = "simpleores.spawn.handled";
  
  /**
   * This class allows zombies and skeletons to spawn holding/wearing SimpleOres items.
   */
  @SubscribeEvent
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
        living.setCurrentItemOrArmor(4, new ItemStack(Content.copper_helmet));
      }

      if (range == 2) {
        living.setCurrentItemOrArmor(3, new ItemStack(Content.copper_chestplate));
      }

      if (range == 3) {
        living.setCurrentItemOrArmor(2, new ItemStack(Content.copper_leggings));
      }

      if (range == 4) {
        living.setCurrentItemOrArmor(1, new ItemStack(Content.copper_boots));
      }

      if (range == 5) {
        living.setCurrentItemOrArmor(4, new ItemStack(Content.mythril_helmet));
      }

      if (range == 6) {
        living.setCurrentItemOrArmor(3, new ItemStack(Content.mythril_chestplate));
      }

      if (range == 7) {
        living.setCurrentItemOrArmor(2, new ItemStack(Content.mythril_leggings));
      }

      if (range == 8) {
        living.setCurrentItemOrArmor(1, new ItemStack(Content.mythril_boots));
      }

      if (range == 9) {
        living.setCurrentItemOrArmor(4, new ItemStack(Content.adamantium_helmet));
      }

      if (range == 10) {
        living.setCurrentItemOrArmor(3, new ItemStack(Content.onyx_chestplate));
      }

      if (range == 11) {
        living.setCurrentItemOrArmor(2, new ItemStack(Content.adamantium_leggings));
      }

      if (range == 12) {
        living.setCurrentItemOrArmor(1, new ItemStack(Content.onyx_boots));
      }
      
      if (range == 13) {
          living.setCurrentItemOrArmor(0, new ItemStack(Content.copper_sword));
        }
      
      if (range == 14) {
          living.setCurrentItemOrArmor(0, new ItemStack(Content.mythril_sword));
        }
      
      if (range == 15) {
          living.setCurrentItemOrArmor(0, new ItemStack(Content.adamantium_sword));
        }
      
      if (range == 16) {
          living.setCurrentItemOrArmor(0, new ItemStack(Content.onyx_sword));
        }
    }
  }
}
