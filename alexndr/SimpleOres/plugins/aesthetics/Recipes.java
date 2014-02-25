package alexndr.SimpleOres.plugins.aesthetics;

import alexndr.SimpleOres.api.helpers.LogHelper;

public class Recipes 
{
	public static void initialize()
	{
		try{doRecipes(); LogHelper.verboseInfo("Aesthetics Plugin: All recipes were added successfully.");}
		catch(Exception e){LogHelper.severe("Aesthetics Plugin: Recipes were not added successfully. This is a serious problem!"); e.printStackTrace();}
	}
	
	public static void doRecipes()
	{
		
	}
}
