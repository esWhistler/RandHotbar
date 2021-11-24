package com.whistler.randhotbar.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class RandomizeHotbarCommand {

    public static void register(CommandDispatcher<CommandSourceStack> pDispatcher)  {
        pDispatcher.register(Commands.literal("randomHotbar")
                .then(Commands.literal("activate")
                        .executes(context -> {
                            min = 0;
                            max = 8;
                            rhActivated = true;
                            return 1;
                        })
                .then(Commands.argument("from", HotbarArgument.slot())
                .then(Commands.argument("to" , HotbarArgument.slot())
                .executes(context -> {
                    int from = HotbarArgument.getSlot(context, "from");
                    int to = HotbarArgument.getSlot(context, "to");
                    min = Math.min(from, to);
                    max = Math.max(from, to);
                    rhActivated = true;
                    return 1;
                }))))
                .then(Commands.literal("deactivate")
                .executes(context -> {
                    rhActivated = false;
                    return 1;
                })));
    }

    public static boolean isRhActivated() {
        return rhActivated;
    }

    public static int getMax() {
        return max;
    }

    public static int getMin() {
        return min;
    }

    private static boolean rhActivated = false;

    private static int min;

    private static int max;
}
