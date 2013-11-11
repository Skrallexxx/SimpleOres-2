package SimpleOres.plugins.akkamaddi.hadite.code;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;
import SimpleOres.plugins.akkamaddi.hadite.code.HaditeCoalCore;

public class HaditeFuel implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.itemID == HaditeCoalCore.haditeCoalIngot.itemID) return 13000;
		if(fuel.itemID == HaditeCoalCore.blockHaditeCoalBlock.blockID) return 130000;
		
		return 0;
	}

}
