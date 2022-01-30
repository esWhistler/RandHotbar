package com.whistler.randhotbar;


import com.whistler.randhotbar.variables.Variables;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(RandomizeHotbar.MOD_ID)
public class RandomizeHotbar {
    public static final String MOD_ID = "randhotbar";

    public RandomizeHotbar() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        registerCommonEvents(modEventBus);
    }

    public void registerCommonEvents(IEventBus eventBus) {
        eventBus.register(StartupCommon.class);
    }

    public static Variables variables;

}

