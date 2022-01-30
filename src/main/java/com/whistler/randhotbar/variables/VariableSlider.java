package com.whistler.randhotbar.variables;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.components.TooltipAccessor;
import net.minecraft.util.FormattedCharSequence;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class VariableSlider extends AbstractVariableSlider implements TooltipAccessor {
    private final ProgressVariable variable;
    private final List<FormattedCharSequence> tooltip;

    protected VariableSlider(Variables variables, int a, int b, int c, int d, ProgressVariable progressVariable, List<FormattedCharSequence> formattedCharSequenceList) {
        super(variables, a, b, c, d, (float)progressVariable.toPct(progressVariable.get(variables)));
        this.variable = progressVariable;
        this.tooltip = formattedCharSequenceList;
        this.updateMessage();
    }

    protected void updateMessage() { this.setMessage(this.variable.getMessage(this.variables)); }

    protected void applyValue() {
        this.variable.set(this.variables, this.variable.toValue(this.value));
    }

    public List<FormattedCharSequence> getTooltip() { return this.tooltip; }
}
