package com.whistler.randhotbar.blockPlacement;


import com.whistler.randhotbar.commands.RandomizeHotbarCommand;
import net.minecraft.world.entity.player.Player;

import java.util.concurrent.ThreadLocalRandom;


public class RandomizeHotbar {

    public static void randomizeHotbar(Player player){
        int min = RandomizeHotbarCommand.getMin();
        int max = RandomizeHotbarCommand.getMax();
        player.getInventory().selected = randomInt(min, max);
    }

    private static int randomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
