package com.whistler.randhotbar.screen;

import com.whistler.randhotbar.RandomizeHotbar;
import com.whistler.randhotbar.variables.ProgressVariable;
import com.whistler.randhotbar.variables.Variable;
import com.whistler.randhotbar.variables.Variables;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RandomizeHotbarScreen extends SimpleVariablesSubScreen {
    private static final ProgressVariable[] RANDOMIZEHOTBAR_VARIABLES = new ProgressVariable[]{Variable.HOTBAR0_CHANCE, Variable.HOTBAR1_CHANCE, Variable.HOTBAR2_CHANCE, Variable.HOTBAR3_CHANCE, Variable.HOTBAR4_CHANCE, Variable.HOTBAR5_CHANCE, Variable.HOTBAR6_CHANCE, Variable.HOTBAR7_CHANCE, Variable.HOTBAR8_CHANCE};

    public RandomizeHotbarScreen(Variables variables) {
        super(variables, new TranslatableComponent("hotbar.screen.title"), RANDOMIZEHOTBAR_VARIABLES);
    }

    @Override
    public void onClose() {
        for (int i = 0; i < 9; ++i){
            RandomizeHotbar.variables.hotbarChance[i] = RANDOMIZEHOTBAR_VARIABLES[i].getCurrentValue();
        }
        super.onClose();
    }
}
