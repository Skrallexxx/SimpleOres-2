Version 1.3.1
-Fixed Onyx not dropping the gem again.
-Fixed the server crashing due to tooltips.
-Removed tooltip ability in the API content classes for the moment, due to the above.

Version 1.3.0
Core
-Preparation for 1.7 update.
-Restructuring of the code. 
-Lots of tidying and improving of the code.
-Block and Item IDs are now grabbed from a list of free Ids. Should eliminate any ID conflicts with mods loaded BEFORE SimpleOres (mods are loaded in alphabetical order unless a special load order is specified). Old conflicts will still be compatible and shouldn't have any negative effects.
-Config directory has changed to being in a folder called "SimpleOres" rather than "SimpleOres Configuration". If you wish to keep your old config, you must copy the values over to the new files. Some file names have changed also, in an attempt to standardise a bit more.
-Coloured the Onyx and Mythril Furnace GUI's in their respective colours.
-Additional OreDictionary entries for Adamantium and Mythril as Adamantite/Adamantine and Mithril.
-Support for the new WorldGenHelper added to the Higher Dimension Generation code, to allow the user to choose which block the ores spawn inside of. Defaults to stone (duh!).
-Removed SimpleOres stuff spawning in dungeon chests, etc. for the moment. May return in the future.
-Added developer capes (only for developers, unless you are really clever ;)).
-Fixed update checker displaying the version number more than once (properly this time). 
-Fixed the Onyx Furnace not giving extra ingots if used with a hopper/not giving extra ingots on the first smelt.
-Fixed Copper Buckets turning into Iron Buckets when picking up fluids from other mods (ie. oil).
-Fixed Copper Buckets turning into Iron Buckets when picking up water if you had more than one Copper Bucket in the stack.
-Fixed tool mining levels not being configurable.
-New Settings toggle to enable/disable colored GUI's for SimpleOres machines (Mythril/Onyx Furnaces). Enabled by default.
-New Settings toggle to enable/disable verbose logging mode. Useful for debugging. Disabled by default.
-New Settings toggle to enable/disable SimpleOres Creative tabs completely. All blocks and items go in the vanilla tabs if disabled. Enabled by default, and applies to any plugins that use the new TabHelper class (all official ones and any unofficial ones that choose to).
-[API] Added a new class to easily trigger achievements on crafting/smelting/pickup (StatTriggersHelper).
-[API] Cleaned up the HandlerLoot class. Renamed to LootHelper.
-[API] Added a class for getting free item and block ids. 
-[API] Block Registering now handled by the SimpleOre class.
-[API] Added the update checker to the API, so it can check for updates for all plugin if supported.
-[API] Added new CoreHelper class, to easily have access to core files that you may not be able to import (ie. if they have the same names as your own, like Content or Settings).
-[API] Added new WorldGenHelper class, to easily specify the block you want to replace during world gen. 
-[API] Added a TabHelper class to determine where items should be placed. Supports plugin tabs, and has built in support for the Toggles that effect tabs, making them universal for any plugins using the TabHelper.
-[API] Added tool tip support (addInfo()) to all content classes (except SimpleOre).

Fusion Version 1.3.0
-The Small Thyrium Chunk is no longer entered into the OreDictionary as a Copper Ingot.
-Made Bronze slightly better (+200 uses, +1.5x Mining Speed, +1 Enchantability).
-Added a toggle to enable extra chunk compounding recipes.
-Added a FusionHelper class to allow plugins to access Fusion classes without hard references. Means less work if I change class names.
-Altered Thyrium and Sinisite armor defense stats so they aren't so OP.

Netherrocks Version 1.0.0
-Now a plugin for SimpleOres, utilising the SimpleOres Plugin API.
-Lots of code improvements.
-Tool recipes now use the OreDictionary version of sticks.
-Added an integrated Localisation, in the same fashion as how SimpleOres does it. Please go ahead and translate Netherrocks to your preferred language :).
-Added Settings toggles to enable/disable advanced Tool, Armor and Block stat modification, all of which can be changed. Disabled by default.
-Added Settings toggles to enable/disable special armor effects. Enabled by default.
-Added Settings toggles to enable/disable special tool effects (Fyrite Pickaxe, Illumenite Sword, Fyrite Sword, etc.). Enabled by default.
-Added Settings options to change certain properties of the the special tools/armor.
-Added support for the new Verbose Logging of SimpleOres 1.3. Enabling it in SimpleOres will enable it in Netherrocks. Prints extra info to the console.
-Added a special armor effect for Malachite Armor. Wearing a full set allows you to jump 2 blocks high. Hold sneak to jump only one.
-Added tool tips to the armor items with special effects showing what the set bonus is if the whole set is worn.
-Added tool tips to the tools/weapons with special effects showing what the special effect is.
-Added a coloured GUI for the Nether Furnace. Enabled by default, can be disabled by using the appropriate toggle in the SimpleOres settings file.
-Changed Nether Furnace fuel values: Blaze Rods (24 items), Netherrack (2 items), Fyrite Ingot (80 items).
-Changed Ore Harvest Levels. Ashstone, Dragonstone and Argonite all require Diamond or better pickaxes to mine.
-Changed Dragonstone Armor durability. It is now much higher.
-Fixed shift-clicking in the Nether Furnace.
-Fixed the Fyrite Pickaxe crashing the game when enchanted.
-Fixed the Fyrite Pickaxe dropping items when player is in creative.
-Fixed the Dragonstone Pickaxe being called the Dragonstone Hoe.
-Fixed the Fyrite and Illumenite swords having their durability reduced twice for every hit.

Version 1.2.1
Core
-Fixed Mythril Furnace not doubling the coal block length/fuel value.
-Fixed the Onyx Gem not dropping from Onyx Ore.
-Fixed Adamantium not generating in higher dimensions.
-Fixed Copper Buckets not being destroyed when picking up lava.
-Lava blocks no longer disappear when you attempt to pick them up with a Copper Bucket.
-Copper Bucket now plays a burning sound when you attempt to pick up lava.
-Decorations tab now has correct name.
-Fixed the "Enable Separate Tabs" toggled not working as intended.
-Fixed the update checker adding version number on world reload (but not game quit), and then displaying the update message.

Fusion
-Removed old localisation as it is now redundant.
-Fusion Furnace no longer crashes SMP.

Version 1.2.0
Core
-Updated Localisations.
-Moved update checker to login section to prevent increased world load time when offline.
-Advanced config options (tools, armor and block stats).
-Significant restructuring of the code.
-Added a min spawn height setting for ores.
-Added Higher Dimension Generation options.
-Removed the old localisation because it was redundant.

Fusion Plugin
-Updated Localisations.
-Re-done Fusion Furnace code to support Metadata, OreDictionary, Wildcard Value, and made it Stack Size aware.
-Fixed Shift Clicking in the Fusion Furnace.
-Advanced config options (tools, armor and block stats).
-Allowed returning of buckets from the Fusion Furnace.
-Added Hopper support for the Fusion Furnace.
-Fixed the Fusion Furnace achievements not working.
-The Fusion Furnace can now auto-load custom Fusion Recipes from the Settings file, without the need to create a plugin.

Plugin API
-[API] Added a new class to the API to easily create new custom creative tabs (SimpleTab).
-[API] Updated content classes (SimpleArmor, SimpleOre, etc) to allow a defined Creative Tab.
-[API] Fixed HandlerLoot not accepting ItemStacks, therefore no metadata.

Version 1.1.1
Core:
-Fixed a bug with the Onyx Ore not dropping the Onyx Gem.

Version 1.1.0
Core:
-Updated to Minecraft 1.6.4 and Forge 9.11.0.884.
-SimpleOres 2 now has an integrated localisation which will change the language of SimpleOres when you change the language of Minecraft (if there is a language file available for your language).
-Added a new Settings toggle to enable the old Localisation file if you wish.
-Added an update checker. It will let you know if there is a new version of SimpleOres available. It won't do any updating itself.
-Added a Settings toggle to turn off the update checker.
-Changed the recipes involving sticks (ie. tools) to use OreDictionary sticks rather than normal ones. This will make them compatible with other mods that add different wood sticks, etc.
-Tweaked spawn rates of copper and tin.
-Tweaked tin stats very slightly.
-[API] Split the SimpleOre class into SimpleOre and SimpleGemOre to allow support for dropping an item rather than the block itself.

Fusion Plugin:
Fixed it so that 5 items can be fused with no remaining energy.
[API] Added proper meta-data compatibility for Fusion Furnace recipes.
[API] Allowed the Fusion Furnace to use OreDictionary alternatives to items. This Furnace checks if there are any alternatives ingredients in the Dictionary, so no recipes will need to be modified.

Version 1.0.2
Core:
-Fusion Furnace is now an optional plugin. Added far better plugin support.
-Fixed a localisation bug (there were 2 sections for bow tooltips)
-Added coal blocks to the fuel list for Mythril and Onyx Furnaces.
-Fixed the fatal onyx door bug.
-I have re-done most of the textures, including alloy textures, to be a bit more consistent.
-The new Plugin API includes support for adding blocks, items, tools, armor and loot.

Fusion Furnace Plugin:
-Fusion Furnace now gives experience when you create a chunk.
-Added coal blocks to the fuel list for the Fusion Furnace.
-Small and medium chunks now craft into a large chunk. The large chunk can then be smelted into an ingot.
-Reduced smelting time by 25% (because you have to smelt it in a regular furnace again, which adds that 25% 	back on :P)
-Changed the enchantability of the alloys. They are now 6, 28 and 11 for bronze, thyrium and sinisite 	respectively.
-Other plugins can add recipes to the Fusion Furnace.
	
Version 1.0.1
-Fixed tin smelting recipe.
-Fixed fusion furnace GUI.

Version 1.0.0:
- Updated to 1.6.2
- Added the Fusion Furnace.
- Added 3 new alloys and their respective items and blocks.
- Replaced Silver with Tin.
- Added Copper, Tin, Mythril, Adamantium and Onyx bars, like Iron Bars, but with different blast resistances.
- Added Copper and Onyx doors.
- Added Tin, Adamantium and Onyx shears.
- Removed Silver bow, and added Sinisite and Thyrium bows, with their rods.
- Added 2 new achievements, and removed an old one.
- Added the Settings.cfg file. This is where spawn rate, spawn heigh, vein size and any other toggles can be configured.
- Improved localisation.lang file. Achievement names and descriptions can now be translated too.
- All items and blocks can now be moved to a single Creative Tab with one of the Settings toggles.
- Reduced the loot spawn rate, and total number of SimpleOres lootable items, so they don't overpower vanilla ones.
- Furnaces now have the right little icon.
- Tools can now be repaired properly.
- Tweaked a lot of balancing settings, such as ore spawn rates, armor and tool strengths, speeds and enchantability. The mod should (hopefully) be even more balanced now.
- Much neater code, and now open source. Most of it is commented to explain what it does. This was a large step for me, and has really improved my skill and understanding of modding.