package com.whistler.randhotbar.event;


import com.whistler.randhotbar.RandHotbar;
import com.whistler.randhotbar.commands.RandomizeHotbarCommand;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.whistler.randhotbar.blockPlacement.RandomizeHotbar.randomizeHotbar;

@Mod.EventBusSubscriber(modid = RandHotbar.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {

    @SubscribeEvent
    public static void onBlockPlacement(final BlockEvent.EntityPlaceEvent event){
        if (RandomizeHotbarCommand.isRhActivated()) {
            Player player = Minecraft.getInstance().player;
            assert player != null;
            randomizeHotbar(player);
        }
    }
}
