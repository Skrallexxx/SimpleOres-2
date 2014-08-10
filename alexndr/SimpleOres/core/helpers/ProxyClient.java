package alexndr.SimpleOres.core.helpers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.util.ResourceLocation;
import alexndr.SimpleOres.api.helpers.ZoomEventHelper;
import alexndr.SimpleOres.core.Content;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ProxyClient extends ProxyCommon
{
    public float fovModifierHand = 0F;  
    protected float speedOnGround = 0.1F;
    
	/**
	 * Adds the armor 'names' to the RenderingRegistry. Must be client side.
	 */
    @Override
    public int addArmor(String armor)
    {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
    
    @Override
    public void registerClientTickHandler()
    {
    	FMLCommonHandler.instance().bus().register(new ZoomEventHelper());
    }
    
    @Override
    public void setZoomAmounts()
    {
  		ZoomEventHelper.setZoomAmount(Content.mythril_bow, 0.25F);
  		ZoomEventHelper.setZoomAmount(Content.onyx_bow, 0.25F);
    }
}
