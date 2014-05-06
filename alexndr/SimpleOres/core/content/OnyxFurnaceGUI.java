package alexndr.SimpleOres.core.content;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import alexndr.SimpleOres.core.Settings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class OnyxFurnaceGUI extends GuiContainer
{
    private OnyxFurnaceTileEntity furnaceInventory;
    
    private static String defaultGui = "textures/gui/container/furnace.png";
    private static String coloredGui = "simpleores:" + "textures/gui/onyx_furnace_gui.png";

    private static final ResourceLocation field_110410_t = new ResourceLocation(Settings.enableColoredGuis ? coloredGui : defaultGui);
    
    public OnyxFurnaceGUI(InventoryPlayer par1InventoryPlayer, OnyxFurnaceTileEntity par2TileEntityFurnace)
    {
        super(new OnyxFurnaceContainer(par1InventoryPlayer, par2TileEntityFurnace));
        this.furnaceInventory = par2TileEntityFurnace;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRendererObj.drawString(StatCollector.translateToLocal("tile.onyx_furnace.name"), this.xSize / 2 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("tile.onyxFurnace.name")) / 2, 6, Settings.enableColoredGuis ? 0xFFFFFF : 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(field_110410_t);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;

        if (this.furnaceInventory.isBurning())
        {
            i1 = this.furnaceInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        i1 = this.furnaceInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
    }
}
