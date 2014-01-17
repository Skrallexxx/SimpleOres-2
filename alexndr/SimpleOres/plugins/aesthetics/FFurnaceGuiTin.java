package alexndr.SimpleOres.plugins.aesthetics;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import alexndr.SimpleOres.api.helpers.CoreHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FFurnaceGuiTin extends GuiContainer
{
    private FFurnaceTileEntityTin furnaceInventory;
    
    private static String defaultGui = "simpleoresfusion:" + "textures/gui/fusionFurnace.png";
    private static String coloredGui = "aestheticsplugin:" + "textures/gui/tinFusionFurnace.png";

    private static final ResourceLocation field_110410_t = new ResourceLocation(CoreHelper.coreSettings.enableColoredGuis ? coloredGui : defaultGui);
    
    public FFurnaceGuiTin(InventoryPlayer par1InventoryPlayer, FFurnaceTileEntityTin par2TileEntityFurnace)
    {
        super(new FFurnaceContainerTin(par1InventoryPlayer, par2TileEntityFurnace));
        this.furnaceInventory = par2TileEntityFurnace;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
    	this.fontRenderer.drawString("   Fusion             Furnace", this.xSize / 2 - this.fontRenderer.getStringWidth("   Fusion             Furnace") / 2, 6, 4210752);
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
            i1 = this.furnaceInventory.getBurnTimeRemainingScaled(12); //Flames
            this.drawTexturedModalRect(k + 105, l + 55 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
            
            i1 = this.furnaceInventory.getBurnTimeRemainingScaled(12); //Flames
            this.drawTexturedModalRect(k + 55, l + 55 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        i1 = this.furnaceInventory.getCookProgressScaled(24); //Left Arrow
        this.drawTexturedModalRect(k + 51, l + 34, 176, 14, i1 + 1, 16);
        
        i1 = this.furnaceInventory.getCookProgressScaled(24); //Right Arrow
        this.drawTexturedModalRect(k + 100, l + 34, 176, 31, 23, 16);
        
        i1 = this.furnaceInventory.getCookProgressScaled(24); //Right Arrow Grey Overlay
        this.drawTexturedModalRect(k + 100, l + 34, 176, 47, 23 - i1, 16);
        
        i1 = this.furnaceInventory.getCookProgressScaled(30); //Bubbles
        this.drawTexturedModalRect(k + 64, l + 4 + 29 - i1, 176, 92 - i1, 12, 29);
        
        i1 = this.furnaceInventory.getCookProgressScaled(30); //Bubbles
        this.drawTexturedModalRect(k + 98, l + 4 + 29 - i1, 188, 92 - i1, 12, 29);
    }
}
