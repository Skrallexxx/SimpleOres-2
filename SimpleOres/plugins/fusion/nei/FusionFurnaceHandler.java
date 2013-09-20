package SimpleOres.plugins.fusion.nei;

import java.awt.Rectangle;
import java.util.*;

import SimpleOres.plugins.fusion.TileEntityFusionFurnace;
import SimpleOres.plugins.fusion.api.FusionRecipes;
import SimpleOres.plugins.fusion.api.FusionRecipes.FusionRecipeInput;
import codechicken.nei.ItemList;
import codechicken.nei.NEIClientUtils;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;
import org.lwjgl.opengl.GL11;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

import static codechicken.core.gui.GuiDraw.*;

public class FusionFurnaceHandler extends TemplateRecipeHandler
{
    public FusionFurnaceHandler() {
        super();
    }

    @Override
    public int recipiesPerPage() {
        return 1;
    }

    public static ArrayList<FuelPair> afuels;
    private int ticksPassed;

    public String getRecipeId()
    {
        return "simpleores.fusion";
    }

    @Override
    public String getRecipeName() {
        return "Fusion Furnace";
    }

    @Override
    public void drawBackground(int i)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        changeTexture(getGuiTexture());
        drawTexturedModalRect(12, 0, 28, 5, 144, 78);
    }

    @Override
    public void drawExtras(int i)
    {
        //float f = ticksPassed >= 40 ? (ticksPassed - 40) % 40 / 40.0F : 0.0F;
        float f = ticksPassed <= 40 ? ticksPassed / 40.0F : (ticksPassed - 40) % 40 / 40.0F;

        // arrows
        drawProgressBar(36, 30, 176, 14, 200-176, 31-14, f, 0); //right pointing arrow
        drawProgressBar(84, 30, 176, 31, 200-176, 31-14, f, 2); //left pointing arrow
        // bubbles
        drawProgressBar(47, 0, 176, 64, 11, 92-64, f, 3);
        drawProgressBar(82, 0, 188, 64, 11, 92-64, f, 3);

        // fire from fuel
        //f = ticksPassed <= 40 ? ticksPassed / 40.0F : (ticksPassed - 40) % 40 / 40.0F;
        drawProgressBar(40, 50, 176, 0, 190-176, 14, f, 3);
        drawProgressBar(90, 51, 176, 0, 190-176, 14, f, 3);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        ticksPassed++;
    }

    @Override
    public void loadTransferRects()
    {
        // @todo - We should have more of these probably
        transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(
                new Rectangle(40, 45, 24, 12),
                getRecipeId(),
                new Object[0]));
    }

    private Set<Map.Entry<FusionRecipeInput, ItemStack>> getRecipes() {
        return FusionRecipes.smelting().getRecipes().entrySet();
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results)
    {
        if( outputId.equals(getRecipeId()) )
        {
            for(Map.Entry irecipe : getRecipes())
            {
                FusionRecipeInput fri = (FusionRecipeInput)irecipe.getKey();
                ItemStack output = (ItemStack)irecipe.getValue();
                arecipes.add(new CachedFusionRecipe(fri, output));
            }
        }
        else
        {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result)
    {
        for(Map.Entry irecipe : getRecipes())
        {
            FusionRecipeInput fri = (FusionRecipeInput)irecipe.getKey();
            ItemStack is = (ItemStack)irecipe.getValue();
            if(NEIServerUtils.areStacksSameTypeCrafting(is, result))
            {
                arecipes.add(new CachedFusionRecipe(fri, is));
            }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient)
    {
        for(Map.Entry irecipe : getRecipes())
        {
            FusionRecipeInput key = (FusionRecipeInput) irecipe.getKey();
            ItemStack output = (ItemStack) irecipe.getValue();
            if( key.utilizes(ingredient) )
                arecipes.add( new CachedFusionRecipe(key, output) );
        }
    }

    @Override
    public String getGuiTexture() {
        return "simpleoresfusion:textures/gui/fusionFurnace.png";
    }

    private static void findFuels()
    {
        afuels = new ArrayList<FuelPair>();
        for(ItemStack item : ItemList.items)
        {
            if(item!=null)
            {
                int burnTime = TileEntityFusionFurnace.getItemBurnTime(item);
                if(burnTime > 0)
                    afuels.add(new FuelPair(item.copy(), burnTime));
            }
        }
    }

    private static class FuelPair
    {
        public FuelPair(ItemStack ingred, int burnTime)
        {
            this.stack = new PositionedStack(ingred, 63, 57, false);
            this.burnTime = burnTime;
        }

        public PositionedStack stack;
        public int burnTime;
    }

    public class CachedFusionRecipe extends TemplateRecipeHandler.CachedRecipe
    {
        PositionedStack inputLeft;
        PositionedStack inputRight;
        PositionedStack catalyst;
        PositionedStack output;
        int hashCode = 1;
        private PositionedStack[] ingredients;

        public CachedFusionRecipe(FusionRecipeInput inputs, ItemStack outputt) {
            super();

            inputLeft = new PositionedStack(inputs.leftInput, 17, 30);
            inputRight = new PositionedStack(inputs.rightInput, 110, 29);
            catalyst = new PositionedStack(inputs.catalyst, 63, 2);
            output = new PositionedStack(outputt, 63, 29);
            hashCode = inputs.hashCode();

            ingredients = new PositionedStack[] {
                inputLeft, inputRight, catalyst, output
            };
        }

        @Override
        public List<PositionedStack> getIngredients()
        {
            int cycle = cycleticks / 48;
            PositionedStack[] cycledstacks = new PositionedStack[4];
            for( int i = 0; i < ingredients.length; i++ )
            {
                PositionedStack basestack = ingredients[i];
                if( basestack==null )
                    continue;
                PositionedStack stack = basestack.copy();
                int id;
                if( 0<(id=OreDictionary.getOreID(stack.item)) )
                {
                    List<ItemStack> ores = OreDictionary.getOres(id);
                    stack.item = ores.get( cycle % ores.size() );
                }
                cycledstacks[i] = stack;
            }
            return Arrays.asList(cycledstacks);
        }

        @Override
        public PositionedStack getResult()
        {
            return output;
        }

        @Override
        public boolean equals(Object obj) {
            if( ! (obj instanceof CachedFusionRecipe) )
                return false;
            CachedFusionRecipe cfr = (CachedFusionRecipe)obj;
            return cfr.hashCode()==this.hashCode();
        }

        @Override
        public PositionedStack getOtherStack() {
            if(afuels == null)
                findFuels();

            return afuels.get((cycleticks / 48) % afuels.size()).stack;
        }
    }
}
