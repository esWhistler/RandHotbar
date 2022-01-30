package com.whistler.randhotbar.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.whistler.randhotbar.variables.Variables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class RandomizeHotbarCommand {

    public static void register(CommandDispatcher<CommandSourceStack> pDispatcher)  {
        pDispatcher.register(Commands.literal("randomHotbar")

                .then(Commands.literal("activate")
                        .executes(context -> {
                            Variables.rhActivated = true;
                            return 1;
                        })
                )

                .then(Commands.literal("deactivate")
                    .executes(context -> {
                        Variables.rhActivated = false;
                        return 1;
                    })
                )
        );
    }

}
