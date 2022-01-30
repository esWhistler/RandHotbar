package com.whistler.randhotbar.event;


import com.whistler.randhotbar.Function;
import com.whistler.randhotbar.RandomizeHotbar;
import com.whistler.randhotbar.screen.RandomizeHotbarScreen;
import com.whistler.randhotbar.variables.Variables;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RandomizeHotbar.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {

    @SubscribeEvent
    public static void onBlockPlacement(final BlockEvent.EntityPlaceEvent event){
        if (Variables.rhActivated) {
            Player player = Minecraft.getInstance().player;
            assert player != null;
            Function.randomizeHotbar(player);
        }
    }

    @SubscribeEvent
    public static void clientTick(final TickEvent.ClientTickEvent event) {
        Minecraft minecraft = Minecraft.getInstance();

        if(KeyInit.actDeactHotbarRand.consumeClick()){
            Function.setRh();
        }

        if(KeyInit.randomizationOptions.consumeClick() && minecraft.screen == null){
            minecraft.setScreen(new RandomizeHotbarScreen(RandomizeHotbar.variables));
        }


    }

}
