package com.whistler.randhotbar.variables;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Variables {
    public Variables(){
    }

    public static boolean rhActivated = false;

    public double[] hotbarChance = {1.0D/9.0D, 1.0D/9.0D, 1.0D/9.0D, 1.0D/9.0D, 1.0D/9.0D, 1.0D/9.0D, 1.0D/9.0D, 1.0D/9.0D, 1.0D/9.0D};

}
