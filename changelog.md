# Dev-14
* Continued to add crafting recipes to blocks and items
  * Wire's
  * Treated Wood Scaffolding
  * Iron Mech Component

# Dev-13
* Updated buildscript to use latest ForgeDevEnv template
* Added an "Improvements" page to the manual
* Fixed Jump Cushion being rock instead of cloth
* Changed id of coke to storage_coke
* Added Treated Wood Scaffolding and Treated Wood Scaffolding Stairs
* Started to add crafting recipes to blocks and items
  * All 'storage' blocks
  * Scaffolding Stairs (Steel, Aluminum)
  * Novice Hammer can now make plates
  * Wirecoil Blocks (LV, MV, HV)


# Dev-12
* Started to add oredict to blocks and items
  * Treated Stick and Rods
    * Also added general `stick` tag to us and vanilla 
  * Bricks
    * Also added general `blockBrick` tag to us and vanilla
  * Steel Scaffolding
  * Aluminum Scaffolding
* Started to add crafting recipes to blocks and items
  * Sheetmetal chutes
  * Sheetmetal ladder chutes
  * Rods
  * Steel Ladder
  * Steel Scaffolding
  * Aluminum Scaffolding
  * Copper Wire
  * Concrete Layer
  * Treated Wood Fences
  * Treated Wood Stairs (Normal, Vertical, Packaged)
* Added durability to tools 
* Created a new `openengie:tool_damage_shaped` factory to let recipes like wire crafting damage the tool
* Replaced Concrete chunk/panel/sheet with one block that has all 8 layers
* Added grooyscript support to `openengie:tool_damage_shaped`. Also serves as the base for when we will need more compatibility.
* Changed smelting xp values.
* Texture downloader can now split larger images. 


# Dev-11
* Recreated Steel Ladder
* Recreated the Covered Ladder's as Chute Ladders 
* Recreated Aluminum Scaffolding and Aluminum Scaffolding Stairs
* Fixed Scaffolding types not being correctly transparent 
* Fixed Insulated Glass not being correctly translucent 
* Made Chutes and Ladder Chute use `base/base_chute.json` and `base/base_chute_ladder.json` respectively to cut down on file size   
* Fixed chutes having no break partices
* Added some oredict to some easy to add blocks and items  