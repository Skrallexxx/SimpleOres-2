package SimpleOres.plugins.horseArmor;

import cpw.mods.fml.common.registry.LanguageRegistry;
import SimpleOres.core.SimpleOres;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Content 
{
	public static Item copperHorseArmor;
	
	public static void doContent()
	{
		//Descriptions
		copperHorseArmor = (new Item(Config.copperHorseArmorID)).setMaxStackSize(1).setCreativeTab(SimpleOres.tabSimpleCombat).setUnlocalizedName("simpleoreshorses:copperHorseArmor");
		
		//Naming
		LanguageRegistry.addName(copperHorseArmor, Config.copperHorseArmorName);
	}
}
