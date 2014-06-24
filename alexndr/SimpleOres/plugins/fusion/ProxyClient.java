package alexndr.SimpleOres.plugins.fusion;

import alexndr.SimpleOres.api.helpers.ZoomEventHelper;

public class ProxyClient extends ProxyCommon
{
	@Override
	public void setZoomAmounts()
	{
    	ZoomEventHelper.setZoomAmount(Content.thyrium_bow, new Float(Settings.thyriumBowZoomModifier / new Float(100)));
    	ZoomEventHelper.setZoomAmount(Content.sinisite_bow, 0.25F);
	}
}
