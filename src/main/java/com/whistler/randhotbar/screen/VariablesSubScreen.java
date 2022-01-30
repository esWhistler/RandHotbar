package com.whistler.randhotbar.screen;

import com.google.common.collect.ImmutableList;
import com.whistler.randhotbar.variables.Variables;
import com.whistler.randhotbar.variables.VariablesList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.TooltipAccessor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;

import java.util.List;
import java.util.Optional;

public class VariablesSubScreen extends Screen {
    Minecraft minecraft = Minecraft.getInstance();
    protected final Variables variables;

    public VariablesSubScreen(Variables variable, Component screenName) {
        super(screenName);
        this.variables = variable;
    }

    public void onClose() {
        minecraft.setScreen(null);
    }

    public static List<FormattedCharSequence> tooltipAt(VariablesList p_96288_, int p_96289_, int p_96290_) {
        Optional<AbstractWidget> optional = p_96288_.getMouseOver(p_96289_, p_96290_);
        return optional.isPresent() && optional.get() instanceof TooltipAccessor ? ((TooltipAccessor)optional.get()).getTooltip() : ImmutableList.of();
    }
}
