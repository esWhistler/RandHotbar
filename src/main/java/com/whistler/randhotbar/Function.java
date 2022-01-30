package com.whistler.randhotbar;

import com.whistler.randhotbar.variables.Variables;
import net.minecraft.world.entity.player.Player;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Function {
    public static void randomizeHotbar(Player player){

        double[] hotbarchance = new double[9];

        hotbarchance[0] = RandomizeHotbar.variables.hotbarChance[0];

        for (int i = 1; i < 9; ++i) {
            hotbarchance[i] = RandomizeHotbar.variables.hotbarChance[i] + hotbarchance[i-1];
        }

        int result = randomNum((int)hotbarchance[8]*100);


        if(hotbarchance[0] > 0 && result < hotbarchance[0]*100){
            player.getInventory().selected = 0;
            return;
        }

        for (int i = 1; i < 9; ++i){
            if(hotbarchance[i] > hotbarchance[i - 1] && result < hotbarchance[i]*100){
                player.getInventory().selected = i;
                return;
            }
        }

    }

    private static int randomNum(int max){
        return ThreadLocalRandom.current().nextInt(0, max + 1);
    }

    public static void setRh() { Variables.rhActivated = !Variables.rhActivated; }

}
