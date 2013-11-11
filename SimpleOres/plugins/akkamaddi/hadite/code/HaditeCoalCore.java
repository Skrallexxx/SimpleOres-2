package SimpleOres.plugins.akkamaddi.hadite.code;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; 
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.event.ForgeSubscribe;
import SimpleOres.core.api.SimpleIngot;
import SimpleOres.core.api.HandlerLoot;
import SimpleOres.core.api.SimpleTab;
import SimpleOres.plugins.akkamaddi.hadite.code.HaditeOreBlock;
import SimpleOres.plugins.akkamaddi.hadite.code.HaditeRecipes;
import SimpleOres.plugins.akkamaddi.hadite.code.HaditeStorageBlock;

@Mod(modid="haditecoal", name="Hadite Coal, nether utility ore", version="1.0.2", dependencies = "required-after:simpleores; required-after:simpleoresfusion")
@NetworkMod(clientSideRequired=true)

public class HaditeCoalCore {
	

    // The instance of your mod that Forge uses.
    @Instance(value = "haditecoal")
    public static HaditeCoalCore instance;
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="SimpleOres.plugins.akkamaddi.hadite.code.ClientProxy", serverSide="SimpleOres.plugins.akkamaddi.hadite.code.CommonProxy")
    public static CommonProxy proxy;
    
	// Set Item ID's
    
    public static int haditeCoalIngotID;
    public static int blockHaditeCoalOreID;
    public static int blockHaditeCoalBlockID;
    
    // set item names
    public static Item haditeCoalIngot;
    
    // set block names
    public static Block blockHaditeCoalOre;
    public static Block blockHaditeCoalBlock;
    
    // spawning
    public static int haditeSpawnRate;
    public static int haditeVeinSize;
    public static int haditeSpawnHeight;
	
    // Booleans
    public static boolean MakeOreFlame;
    public static boolean MakeBlockFlame;

    // tab
    public static SimpleTab tabAkkamaddiHadite = new SimpleTab("tabAkkamaddiHadite");
 
    // Tab
    public void setTabIcons()
    {
    	/**
    	 * Creating the custom tabs using the API class "SimpleTab" and setting their icon.
    	 */
    	tabAkkamaddiHadite.setIcon(new ItemStack(HaditeCoalCore.blockHaditeCoalOre));
    }
 
    
    
    @EventHandler 
    public void preInit(FMLPreInitializationEvent event) {
            // Stub Method
    	
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        config.load();
        
	    haditeCoalIngotID = config.getItem("1", "Hadite Coal lump ID", 12220).getInt();
        
        blockHaditeCoalOreID = config.getBlock("2", "Hadite Coal ore ID", 1313).getInt();
        blockHaditeCoalBlockID = config.getBlock("3", "Hadite Coal block ID", 1314).getInt();
    
		MakeOreFlame = config.get(Configuration.CATEGORY_GENERAL, "Hadite Ore spits fire", true).getBoolean(true);
		MakeBlockFlame = config.get(Configuration.CATEGORY_GENERAL, "Hadite Block emits flames", true).getBoolean(true);
		        
    	//Adjustable Ore Spawn Rates 
    	haditeSpawnRate = config.get("4 Spawning parameters", "Hadite Coal Spawn Rate", 7).getInt();
		
    	//Adjustable Ore Vein Sizes
    	haditeVeinSize = config.get("4 Spawning parameters", "Hadite Coal Vein Size", 17).getInt();
		
    	//Adjustable Ore Spawn Heights
    	haditeSpawnHeight = config.get("4 Spawning parameters", "Hadite Coal Spawn Height", 256).getInt();

		
		
        config.save();
        
		haditeCoalIngot = new SimpleIngot(haditeCoalIngotID, "haditecoal", HaditeCoalCore.tabAkkamaddiHadite).setUnlocalizedName("haditeCoalIngot");

        // define blocks
        blockHaditeCoalOre = new HaditeOreBlock(blockHaditeCoalOreID, Material.rock, "haditecoal")
        .setHardness(4.0F).setResistance(6.0F).setStepSound(Block.soundStoneFootstep)
        .setUnlocalizedName("blockHaditeCoalOre").setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
        .setLightValue(0.6F);
 
         blockHaditeCoalBlock = new HaditeStorageBlock(blockHaditeCoalBlockID, Material.rock, "haditecoal")
        .setHardness(4.0F).setResistance(6.0F).setStepSound(Block.soundStoneFootstep)
        .setUnlocalizedName("blockHaditeCoalBlock").setCreativeTab(HaditeCoalCore.tabAkkamaddiHadite)
        .setLightValue(0.7F);
         
         // loot
     	HandlerLoot.lootHandler().addLoot("villageBlacksmith", haditeCoalIngot, 1, 2, 2);
     	HandlerLoot.lootHandler().addLoot("strongholdCrossing", haditeCoalIngot, 1, 2, 4);
     	HandlerLoot.lootHandler().addLoot("strongholdCorridor", haditeCoalIngot, 1, 2, 2);
     	HandlerLoot.lootHandler().addLoot("pyramidDesertyChest", haditeCoalIngot, 1, 1, 1);


    	// run tab icon call
    	setTabIcons();
    	
    }
    
    @EventHandler 
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderers();
            
            // Recipes
            HaditeRecipes.doHaditeRecipes();
            
            // world generation
    		GameRegistry.registerWorldGenerator(new HaditeGenerator());

    		// Set fuel burntime
    		GameRegistry.registerFuelHandler(new HaditeFuel());
            
            // name stuff
            LanguageRegistry.addName(haditeCoalIngot, "Hadite Coal");

			LanguageRegistry.addName(blockHaditeCoalOre, "Hadite Coal Ore");
            MinecraftForge.setBlockHarvestLevel(blockHaditeCoalOre, "pickaxe", 1);
            GameRegistry.registerBlock(blockHaditeCoalOre, "blockHaditeCoalOre");

			LanguageRegistry.addName(blockHaditeCoalBlock, "Hadite Coal Block");
            MinecraftForge.setBlockHarvestLevel(blockHaditeCoalBlock, "pickaxe", 0);
            GameRegistry.registerBlock(blockHaditeCoalBlock, "blockHaditeCoalBlock");

            LanguageRegistry.instance().addStringLocalization("itemGroup.tabAkkamaddiHadite", "en_US", "akkamaddi's Hadite Coal");

             
                        
    }
    
    @EventHandler 
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    	
    	
    	
    }

}
