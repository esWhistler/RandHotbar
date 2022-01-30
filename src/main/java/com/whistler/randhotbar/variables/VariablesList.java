package com.whistler.randhotbar.variables;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.whistler.randhotbar.RandomizeHotbar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class VariablesList extends ContainerObjectSelectionList<VariablesList.Entry> {
    public VariablesList(Minecraft minecraft, int a, int b, int c, int d, int e) {
        super(minecraft, a, b, c,d, e);
        this.centerListVertically = false;
    }

    public int addBig(Variable variable) {
        return this.addEntry(VariablesList.Entry.big(RandomizeHotbar.variables, this.width, variable));
    }

    public void addSmall(Variable variable1, @Nullable Variable variable2) {
        this.addEntry(VariablesList.Entry.small(RandomizeHotbar.variables, this.width, variable1, variable2));
    }

    public void addSmall(Variable[] variableArray) {
        for(int i = 0; i < variableArray.length; i += 2) {
            this.addSmall(variableArray[i], i < variableArray.length - 1 ? variableArray[i + 1] : null);
        }

    }

    public int getRowWidth() {
        return 400;
    }

    protected int getScrollbarPosition() {
        return super.getScrollbarPosition() + 32;
    }

    @Nullable
    public AbstractWidget findVariable(Variable p_94479_) {
        for(VariablesList.Entry variableslist$entry : this.children()) {
            AbstractWidget abstractwidget = variableslist$entry.variables.get(p_94479_);
            if (abstractwidget != null) {
                return abstractwidget;
            }
        }

        return null;
    }

    public Optional<AbstractWidget> getMouseOver(double p_94481_, double p_94482_) {
        for(VariablesList.Entry variableslist$entry : this.children()) {
            for(AbstractWidget abstractwidget : variableslist$entry.children) {
                if (abstractwidget.isMouseOver(p_94481_, p_94482_)) {
                    return Optional.of(abstractwidget);
                }
            }
        }

        return Optional.empty();
    }


    @OnlyIn(Dist.CLIENT)
    protected static class Entry extends ContainerObjectSelectionList.Entry<VariablesList.Entry> {
        final Map<Variable, AbstractWidget> variables;
        final List<AbstractWidget> children;

        private Entry(Map<Variable, AbstractWidget> p_169047_) {
            this.variables = p_169047_;
            this.children = ImmutableList.copyOf(p_169047_.values());
        }

        public static VariablesList.Entry big(Variables p_94507_, int p_94508_, Variable p_94509_) {
            return new VariablesList.Entry(ImmutableMap.of(p_94509_, p_94509_.createButton(p_94507_, p_94508_ / 2 - 155, 0, 310)));
        }

        public static VariablesList.Entry small(Variables p_94511_, int p_94512_, Variable p_94513_, @Nullable Variable p_94514_) {
            AbstractWidget abstractwidget = p_94513_.createButton(p_94511_, p_94512_ / 2 - 155, 0, 150);
            return p_94514_ == null ? new VariablesList.Entry(ImmutableMap.of(p_94513_, abstractwidget)) : new VariablesList.Entry(ImmutableMap.of(p_94513_, abstractwidget, p_94514_, p_94514_.createButton(p_94511_, p_94512_ / 2 - 155 + 160, 0, 150)));
        }

        public void render(PoseStack p_94496_, int p_94497_, int p_94498_, int p_94499_, int p_94500_, int p_94501_, int p_94502_, int p_94503_, boolean p_94504_, float p_94505_) {
            this.children.forEach((p_94494_) -> {
                p_94494_.y = p_94498_;
                p_94494_.render(p_94496_, p_94502_, p_94503_, p_94505_);
            });
        }

        public List<? extends GuiEventListener> children() {
            return this.children;
        }

        public List<? extends NarratableEntry> narratables() {
            return this.children;
        }
    }

}
