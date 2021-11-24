package com.whistler.randhotbar;


import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(RandHotbar.MOD_ID)
public class RandHotbar {
    public static final String MOD_ID = "randhotbar";

    public RandHotbar() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        registerCommonEvents(modEventBus);
    }

    public void registerCommonEvents(IEventBus eventBus) {
        eventBus.register(com.whistler.randhotbar.commands.StartupCommon.class);
    }
}

