package SimpleOres.plugins.fusion.nei;

import SimpleOres.plugins.fusion.GuiFusionFurnace;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIFusionFurnaceConfig implements IConfigureNEI {
    @Override
    public void loadConfig() {
        API.registerRecipeHandler(new FusionFurnaceHandler());
        API.registerUsageHandler(new FusionFurnaceHandler());

        API.setGuiOffset(GuiFusionFurnace.class, 16, 5);
    }

    @Override
    public String getName() {
        return "Simple Ores Fusion Plugin";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }
}
