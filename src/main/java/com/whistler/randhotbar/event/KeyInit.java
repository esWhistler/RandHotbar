package com.whistler.randhotbar.event;

import com.mojang.blaze3d.platform.InputConstants;
import com.whistler.randhotbar.RandomizeHotbar;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.fmlclient.registry.ClientRegistry;

public final class KeyInit {

    public static KeyMapping actDeactHotbarRand;
    public static KeyMapping randomizationOptions;

    public static void register(){
        actDeactHotbarRand = create("hotbar_randomization", InputConstants.KEY_H);
        ClientRegistry.registerKeyBinding(actDeactHotbarRand);

        randomizationOptions = create("hotbar_randomization_options", InputConstants.KEY_R);
        ClientRegistry.registerKeyBinding(randomizationOptions);
    }

    public static KeyMapping create(String name, int key){
        return new KeyMapping("key." + RandomizeHotbar.MOD_ID + "." + name, key,  "key.category." + RandomizeHotbar.MOD_ID);
    }

}
