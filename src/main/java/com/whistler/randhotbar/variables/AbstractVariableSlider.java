package com.whistler.randhotbar.variables;

import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.network.chat.TextComponent;

public abstract class AbstractVariableSlider extends AbstractSliderButton {
    protected final Variables variables;

    protected AbstractVariableSlider(Variables variables, int a, int b, int c, int d, double e){
        super(a, b, c, d, TextComponent.EMPTY, e);
        this.variables = variables;
    }
}
