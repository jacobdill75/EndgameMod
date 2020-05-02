![Endgame Mod image](https://github.com/jacobdill75/EndgameMod/blob/master/src/main/resources/endgamemod.png | width = 128)
# Endgame Mod
## for Minecraft 1.14.4

A mod to make the End dimension a little more interesting/sensible. Feature sinclude:

* Vanila Adjustments:
	* Phantoms Spawn in the End
	* Totems of Undying save you from the void

* New features:
	* Obsidian ingots can be found in End City Loot. This can be used to craft obsidian tools, a median between iron and diamon which does not burn in lava!
	* A new end cow -- Brahmin -- occupy the End Dimension. These creatures drop their valuable Hyde, which can be used to heal elyctra. They are difficult to hunt, however, as they're movement resembles that of the endermen.
	* Rubies can be found in Stronghold Corridor Chests, and can be crafted into a block. This block appears to be attractive to Brahmin...
	* A new world type - Endgame World - features a WIP dimension called the End Field, which spawns many Brahmin. However, this biome is not featured in the normal world.
	* To occupy this biome, End grass and dirt blocks, Purpueus, and Oliva, have been added, but currently serve for aesthetic purposes.

## Forge README.txt:

-------------------------------------------
Source installation information for modders
-------------------------------------------
This code follows the Minecraft Forge installation methodology. It will apply
some small patches to the vanilla MCP source code, giving you and it access 
to some of the data and functions you need to build a successful mod.

Note also that the patches are built against "unrenamed" MCP source code (aka
srgnames) - this means that you will not be able to read them directly against
normal code.

Source pack installation information:

Standalone source installation
==============================

See the Forge Documentation online for more detailed instructions:
http://mcforge.readthedocs.io/en/latest/gettingstarted/

Step 1: Open your command-line and browse to the folder where you extracted the zip file.

Step 2: You're left with a choice.
If you prefer to use Eclipse:
1. Run the following command: "gradlew genEclipseRuns" (./gradlew genEclipseRuns if you are on Mac/Linux)
2. Open Eclipse, Import > Existing Gradle Project > Select Folder 
   or run "gradlew eclipse" to generate the project.
(Current Issue)
4. Open Project > Run/Debug Settings > Edit runClient and runServer > Environment
5. Edit MOD_CLASSES to show [modid]%%[Path]; 2 times rather then the generated 4.

If you prefer to use IntelliJ:
1. Open IDEA, and import project.
2. Select your build.gradle file and have it import.
3. Run the following command: "gradlew genIntellijRuns" (./gradlew genIntellijRuns if you are on Mac/Linux)
4. Refresh the Gradle Project in IDEA if required.

If at any point you are missing libraries in your IDE, or you've run into problems you can run "gradlew --refresh-dependencies" to refresh the local cache. "gradlew clean" to reset everything {this does not affect your code} and then start the processs again.

Should it still not work, 
Refer to #ForgeGradle on EsperNet for more information about the gradle environment.
or the Forge Project Discord discord.gg/UvedJ9m

Forge source installation
=========================
MinecraftForge ships with this code and installs it as part of the forge
installation process, no further action is required on your part.

LexManos' Install Video
=======================
https://www.youtube.com/watch?v=8VEdtQLuLO0&feature=youtu.be

For more details update more often refer to the Forge Forums:
http://www.minecraftforge.net/forum/index.php/topic,14048.0.html
