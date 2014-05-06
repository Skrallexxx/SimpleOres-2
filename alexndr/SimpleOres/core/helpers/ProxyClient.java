package alexndr.SimpleOres.core.helpers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.util.ResourceLocation;
import alexndr.SimpleOres.api.helpers.LogHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;

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
    
	/**
	 * Adds capes for AleXndr and a select few plugin developers as a sign of appreciation.
	 */
    @Override
    public void addModderCapes()
	{
    	LogHelper.verboseInfo("Developer capes added!");
    	String capeURL = "https://dl.dropboxusercontent.com/u/66466201/SimpleOres/SimpleOres%20Cape.png";
		String[] devs = {"AleXndrTheGr8st", "akkamaddi"};

		ThreadDownloadImageData image = new ThreadDownloadImageData(capeURL, null, null);

		for (String username : devs) 
		{
			LogHelper.verboseInfo("Adding cape for developer " + username);
			Minecraft.getMinecraft().renderEngine.loadTexture(new ResourceLocation("cloaks/" + username), (ITextureObject) image);
		}
	}
}
