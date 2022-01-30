package com.whistler.randhotbar.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import com.whistler.randhotbar.variables.Variable;
import com.whistler.randhotbar.variables.Variables;
import com.whistler.randhotbar.variables.VariablesList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public abstract class SimpleVariablesSubScreen extends VariablesSubScreen {
    private final Variable[] smallVariables;
    private VariablesList list;

    public SimpleVariablesSubScreen(Variables variables, Component screenName, Variable[] smallVariables) {
        super(variables, screenName);
        this.smallVariables = smallVariables;
    }

    protected void init() {
        this.list = new VariablesList(this.minecraft, this.width, this.height, 32, this.height - 32, 25);
        this.list.addSmall(this.smallVariables);
        this.addWidget(this.list);
        this.createFooter();
    }

    protected void createFooter() {
        this.addRenderableWidget(new Button(this.width / 2 - 100, this.height - 27, 200, 20, CommonComponents.GUI_DONE, (buttonPress) -> Minecraft.getInstance().setScreen(null)));
    }

    public void render(PoseStack p_96675_, int p_96676_, int p_96677_, float p_96678_) {
        this.renderBackground(p_96675_);
        this.list.render(p_96675_, p_96676_, p_96677_, p_96678_);
        drawCenteredString(p_96675_, this.font, this.title, this.width / 2, 20, 16777215);
        super.render(p_96675_, p_96676_, p_96677_, p_96678_);
        List<FormattedCharSequence> list = tooltipAt(this.list, p_96676_, p_96677_);
        this.renderTooltip(p_96675_, list, p_96676_, p_96677_);
    }
}
