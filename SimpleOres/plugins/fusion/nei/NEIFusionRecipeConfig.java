package SimpleOres.plugins.fusion.nei;

import SimpleOres.plugins.fusion.GuiFusionFurnace;
import SimpleOres.plugins.fusion.ModInfo;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIFusionRecipeConfig implements IConfigureNEI {
	@Override public void loadConfig() {
		API.registerRecipeHandler(new FusionRecipeHandler());
		API.registerUsageHandler(new FusionRecipeHandler());
	}

	@Override public String getName() {
		return ModInfo.NAME;
	}

	@Override public String getVersion() {
		return ModInfo.VERSION;
	}
}
