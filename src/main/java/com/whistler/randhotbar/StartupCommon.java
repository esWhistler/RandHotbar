package com.whistler.randhotbar;


import com.whistler.randhotbar.commands.RegisterCommandEvent;
import com.whistler.randhotbar.event.KeyInit;
import com.whistler.randhotbar.variables.Variables;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class StartupCommon {
    @SubscribeEvent
    public static void onCommonSetupEvent(FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(RegisterCommandEvent.class);
        KeyInit.register();
        RandomizeHotbar.variables = new Variables();
    }
}
