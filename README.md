# RandHotbar

![Available for](https://cf.way2muchnoise.eu/versions/hotbar-randomizer_all.svg)
[![CurseForge all releases](https://cf.way2muchnoise.eu/549774.svg)](https://www.curseforge.com/minecraft/mc-mods/hotbar-randomizer/files)
[![GitHub all releases](https://img.shields.io/github/downloads/esWhistler/RandHotbar/total?label=github%20downloads)](https://github.com/esWhistler/RandHotbar/releases)
[![GitHub](https://img.shields.io/github/license/esWhistler/RandHotbar)](https://github.com/esWhistler/RandHotbar/blob/main/LICENSE)
[![GitHub release (latest SemVer)](https://img.shields.io/github/v/release/esWhistler/RandHotbar)](https://github.com/esWhistler/RandHotbar/releases/tag/0.1.0)

Minecraft Mod that adds the functionality to change the selected hotbar slot at random after placing a block.

# Usage

## Configuration

The configuration menu screen is brought up by pressing a key (by default the R key, but it can be changed in the key binds menu), in it you can choose the probability that each hotbar slot is selected after placing a block (a 0% chance means the slot won't be selected).

## Activation/Deactivation

A key (by default the H key) is used to activate and deactivate this function.



There are also commands to activate and deactivate this function which you can type in the chat:
> /randHotbar activate
> 
> /randHotbar deactivate

---
# Warning, test version

- Nothing keeps the percentages from adding over or under 100 yet, although it still works if you do that
  - For example if you put hotbar0 at 50, hotbar1 at 100 and the rest at 0, the mod will choose a random number between 0 and 150, choose hotbar0 if its under 50, hotbar1 if its over 50, so the chances are actually ~33%/67% but it will still show 50/100
- There's no way to tell whether or not it's activated yet
- Probably has other problems, I forgot
