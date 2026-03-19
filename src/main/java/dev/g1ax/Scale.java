package dev.g1ax;

import dev.g1ax.config.G1axInventoryScaleConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;

public class Scale {
    public static float getScale() {
        if (Minecraft.getInstance().screen instanceof AbstractContainerScreen<?>) {
            return G1axInventoryScaleConfig.CONFIG.instance().containerSize;
        }
        return 1F;
    }
}
