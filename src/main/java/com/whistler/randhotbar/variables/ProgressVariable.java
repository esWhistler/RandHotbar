package com.whistler.randhotbar.variables;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

@OnlyIn(Dist.CLIENT)
public class ProgressVariable extends Variable {
    protected final float steps;
    protected double currentValue;
    protected final double minValue;
    protected double maxValue;
    private final Function<Variables, Double> getter;
    private final BiConsumer<Variables, Double> setter;
    private final BiFunction<Variables, ProgressVariable, Component> toString;
    private final Function<Minecraft, List<FormattedCharSequence>> tooltipSupplier;

    public ProgressVariable(String name, double currentValue, double minValue, double maxValue, float steps, Function<Variables, Double> getter, BiConsumer<Variables, Double> setter, BiFunction<Variables, ProgressVariable, Component> toString, Function<Minecraft, List<FormattedCharSequence>> tooltipSupplier) {
        super(name);
        this.steps = steps;
        this.currentValue = currentValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.getter = getter;
        this.setter = setter;
        this.toString = toString;
        this.tooltipSupplier = tooltipSupplier;
    }

    public ProgressVariable(String name, double currentValue, double minValue, double maxValue, float steps, Function<Variables, Double> getter, BiConsumer<Variables, Double> setter, BiFunction<Variables, ProgressVariable, Component> toString) {
        this(name, currentValue, minValue, maxValue, steps, getter, setter, toString, (minecraft) -> ImmutableList.of());
    }

    public AbstractWidget createButton(Variables p_92227_, int p_92228_, int p_92229_, int p_92230_) {
        List<FormattedCharSequence> list = this.tooltipSupplier.apply(Minecraft.getInstance());
        return new VariableSlider(p_92227_, p_92228_, p_92229_, p_92230_, 20, this, list);
    }

    public double toPct(double p_92218_) {
        return Mth.clamp((this.clamp(p_92218_) - this.minValue) / (this.maxValue - this.minValue), 0.0D, 1.0D);
    }

    public double toValue(double p_92231_) {
        return this.clamp(Mth.lerp(Mth.clamp(p_92231_, 0.0D, 1.0D), this.minValue, this.maxValue));
    }

    private double clamp(double p_92237_) {
        if (this.steps > 0.0F) {
            p_92237_ = this.steps * (float)Math.round(p_92237_ / (double)this.steps);
        }

        return Mth.clamp(p_92237_, this.minValue, this.maxValue);
    }

    public double getMinValue() {
        return this.minValue;
    }

    public double getMaxValue() {
        return this.maxValue;
    }

    public void setMaxValue(float p_92220_) {
        this.maxValue = p_92220_;
    }

    public double getCurrentValue() {
        return this.currentValue;
    }

    public void set(Variables p_92224_, double p_92225_) {
        this.currentValue = p_92225_;
        this.setter.accept(p_92224_, p_92225_);
    }

    public double get(Variables p_92222_) {
        return this.getter.apply(p_92222_);
    }

    public Component getMessage(Variables p_92234_) {
        return this.toString.apply(p_92234_, this);
    }
}
