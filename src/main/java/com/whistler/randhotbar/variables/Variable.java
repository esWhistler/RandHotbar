package com.whistler.randhotbar.variables;

import com.whistler.randhotbar.RandomizeHotbar;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class Variable {

    public static final ProgressVariable HOTBAR0_CHANCE = new ProgressVariable("variables.hotbar0", RandomizeHotbar.variables.hotbarChance[0], 0.0D, 1.0D, 0.01F, (variables) -> variables.hotbarChance[0], (variables, aDouble) -> variables.hotbarChance[0] = aDouble,
            (variables, variable) -> {
        double d0 = variable.get(variables);
        return variable.percentValueLabel(d0);
    });

    public static final ProgressVariable HOTBAR1_CHANCE = new ProgressVariable("variables.hotbar1", RandomizeHotbar.variables.hotbarChance[1], 0.0D, 1.0D, 0.01F, (variables) -> variables.hotbarChance[1], (variables, aDouble) -> variables.hotbarChance[1] = aDouble,
            (variables, variable) -> {
        double d0 = variable.get(variables);
        return variable.percentValueLabel(d0);
    });

    public static final ProgressVariable HOTBAR2_CHANCE = new ProgressVariable("variables.hotbar2", RandomizeHotbar.variables.hotbarChance[2], 0.0D, 1.0D, 0.01F, (variables) -> variables.hotbarChance[2], (variables, aDouble) -> variables.hotbarChance[2] = aDouble,
            (variables, variable) -> {
        double d0 = variable.get(variables);
        return variable.percentValueLabel(d0);
    });

    public static final ProgressVariable HOTBAR3_CHANCE = new ProgressVariable("variables.hotbar3", RandomizeHotbar.variables.hotbarChance[3], 0.0D, 1.0D, 0.01F, (variables) -> variables.hotbarChance[3], (variables, aDouble) -> variables.hotbarChance[3] = aDouble,
            (variables, variable) -> {
        double d0 = variable.get(variables);
        return variable.percentValueLabel(d0);
    });

    public static final ProgressVariable HOTBAR4_CHANCE = new ProgressVariable("variables.hotbar4", RandomizeHotbar.variables.hotbarChance[4], 0.0D, 1.0D, 0.01F, (variables) -> variables.hotbarChance[4], (variables, aDouble) -> variables.hotbarChance[4] = aDouble,
            (variables, variable) -> {
        double d0 = variable.get(variables);
        return variable.percentValueLabel(d0);
    });

    public static final ProgressVariable HOTBAR5_CHANCE = new ProgressVariable("variables.hotbar5", RandomizeHotbar.variables.hotbarChance[5], 0.0D, 1.0D, 0.01F, (variables) -> variables.hotbarChance[5], (variables, aDouble) -> variables.hotbarChance[5] = aDouble,
            (variables, variable) -> {
        double d0 = variable.get(variables);
        return variable.percentValueLabel(d0);
    });

    public static final ProgressVariable HOTBAR6_CHANCE = new ProgressVariable("variables.hotbar6", RandomizeHotbar.variables.hotbarChance[6], 0.0D, 1.0D, 0.01F, (variables) -> variables.hotbarChance[6], (variables, aDouble) -> variables.hotbarChance[6] = aDouble,
            (variables, variable) -> {
        double d0 = variable.get(variables);
        return variable.percentValueLabel(d0);
    });

    public static final ProgressVariable HOTBAR7_CHANCE = new ProgressVariable("variables.hotbar7", RandomizeHotbar.variables.hotbarChance[7], 0.0D, 1.0D, 0.01F, (variables) -> variables.hotbarChance[7], (variables, aDouble) -> variables.hotbarChance[7] = aDouble,
            (variables, variable) -> {
        double d0 = variable.get(variables);
        return variable.percentValueLabel(d0);
    });

    public static final ProgressVariable HOTBAR8_CHANCE = new ProgressVariable("variables.hotbar8", RandomizeHotbar.variables.hotbarChance[8], 0.0D, 1.0D, 0.01F, (variables) -> variables.hotbarChance[8], (variables, aDouble) -> variables.hotbarChance[8] = aDouble,
            (variables, variable) -> {
        double d0 = variable.get(variables);
        return variable.percentValueLabel(d0);
    });


    private final Component caption;

    public Variable(String name) {
        this.caption = new TranslatableComponent(name);
    }

    public abstract AbstractWidget createButton(Variables p_91719_, int p_91720_, int p_91721_, int p_91722_);

    protected Component getCaption() {
        return this.caption;
    }

    protected Component percentValueLabel(double p_91763_) {
        return new TranslatableComponent("options.percent_value", this.getCaption(), (int)(p_91763_ * 100.0D));
    }

}
