# Money Making Maker MC Mod

## IMPORTANT NOTE, THIS USES LATEST VERSION OF FORGE 1.8.9!!

## Overview 
This is a minecraft mod that helps you make ingame coins in minecraft hypixel skyblock by generating flips

## Features
- Auction Flipping - This searches through the auction house and finds the best items to flip using their price. It also makes sure that the item is close to selling
- Bin Flipping - This does the same but with buy it nows, and finds the best flip using the items prices.

## Installation Proccess
Steps  
1. Click on this link: https://github.com/sujaykonda/money-making-maker-mod/releases/latest 
2. Then click on the jar file and move to mod folder  

## Set up
To change the config of Money Making Maker, you must click esc  
Click on "mod options"  
![Mod options](https://user-images.githubusercontent.com/50930165/112737442-08e00280-8f31-11eb-9aa8-5a5494d67a01.png)
Then click on MoneyMakingMaker in your mods list, and then click on config  
![MoneyMakingMaker](https://user-images.githubusercontent.com/50930165/112737476-40e74580-8f31-11eb-8ec2-cfbfb517e0f4.png)
In the config you must input api key (To get api key in hypixel you must type /api new)
Macro Safeness is pretty self explanitory  
If you worry about getting banned put it to 0  
If you dont care then but it to 2  
Else just but it at 1  
![Config](https://user-images.githubusercontent.com/50930165/112737533-9ae80b00-8f31-11eb-8747-af85bb285938.png)
**After this you MUST RE LOG**

## Usage/Commands

- /binflip (budget)
- /auctionflip (budget)

Usage Examples:  
You want to flip 1 million coins
/binflip 1000000  
After 50 seconds or so a bunch of text will pop up
You can click on the text and click enter to get into the /ah
![Result](https://user-images.githubusercontent.com/50930165/112737707-c4556680-8f32-11eb-8e99-7516ae1a16b1.png)

## Extra Notes
This mod has been optimizer to be very fast and very convienent.

# Help by suppporting the mod
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

Step 1: Open your command-line and browse to the folder where you extracted the zip file.

Step 2: Once you have a command window up in the folder that the downloaded material was placed, type:

Windows: "gradlew setupDecompWorkspace"
Linux/Mac OS: "./gradlew setupDecompWorkspace"

Step 3: After all that finished, you're left with a choice.
For eclipse, run "gradlew eclipse" (./gradlew eclipse if you are on Mac/Linux)

If you preffer to use IntelliJ, steps are a little different.
1. Open IDEA, and import project.
2. Select your build.gradle file and have it import.
3. Once it's finished you must close IntelliJ and run the following command:

"gradlew genIntellijRuns" (./gradlew genIntellijRuns if you are on Mac/Linux)

Step 4: The final step is to open Eclipse and switch your workspace to /eclipse/ (if you use IDEA, it should automatically start on your project)

If at any point you are missing libraries in your IDE, or you've run into problems you can run "gradlew --refresh-dependencies" to refresh the local cache. "gradlew clean" to reset everything {this does not effect your code} and then start the processs again.

Should it still not work, 
Refer to #ForgeGradle on EsperNet for more information about the gradle environment.

Tip:
If you do not care about seeing Minecraft's source code you can replace "setupDecompWorkspace" with one of the following:
"setupDevWorkspace": Will patch, deobfusicated, and gather required assets to run minecraft, but will not generated human readable source code.
"setupCIWorkspace": Same as Dev but will not download any assets. This is useful in build servers as it is the fastest because it does the least work.

Tip:
When using Decomp workspace, the Minecraft source code is NOT added to your workspace in a editable way. Minecraft is treated like a normal Library. Sources are there for documentation and research purposes and usually can be accessed under the 'referenced libraries' section of your IDE.

Forge source installation
=========================
MinecraftForge ships with this code and installs it as part of the forge
installation process, no further action is required on your part.

LexManos' Install Video
=======================
https://www.youtube.com/watch?v=8VEdtQLuLO0&feature=youtu.be

For more details update more often refer to the Forge Forums:
http://www.minecraftforge.net/forum/index.php/topic,14048.0.html
