package com.whistler.randhotbar.commands;

import com.google.common.collect.Maps;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.Util;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.network.chat.TranslatableComponent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Deprecated
public class HotbarArgument implements ArgumentType<Integer> {
    private static final Collection<String> EXAMPLES = Arrays.asList("hotbar.2", "hotbar.5", "hotbar.8");
    private static final DynamicCommandExceptionType ERROR_UNKNOWN_SLOT = new DynamicCommandExceptionType((p_111283_) ->
            new TranslatableComponent("slot.unknown", p_111283_));
    private static final Map<String, Integer> SLOTS = Util.make(Maps.newHashMap(), (p_111285_) -> {

        for(int j = 0; j < 9; ++j) {
            p_111285_.put("hotbar." + j, j);
        }

    });

    public static HotbarArgument slot() {
        return new HotbarArgument();
    }

    public static int getSlot(CommandContext<CommandSourceStack> pContext, String pName) {
        return pContext.getArgument(pName, Integer.class);
    }

    public Integer parse(StringReader pReader) throws CommandSyntaxException {
        String s = pReader.readUnquotedString();
        if (!SLOTS.containsKey(s)) {
            throw ERROR_UNKNOWN_SLOT.create(s);
        } else {
            return SLOTS.get(s);
        }
    }

    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> pContext, SuggestionsBuilder pBuilder) {
        return SharedSuggestionProvider.suggest(SLOTS.keySet(), pBuilder);
    }

    public Collection<String> getExamples() {
        return EXAMPLES;
    }
}