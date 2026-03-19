package dev.g1ax.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.g1ax.Scale;
import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MouseHandler.class)
public class MouseHandlerMixin {
    @ModifyExpressionValue(method = "getScaledXPos(Lcom/mojang/blaze3d/platform/Window;D)D", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/Window;getGuiScaledWidth()I"))
    private static int onScaledXPos(int originalScaledWidth) {
        return Scale.getScale() == 1.0F ? originalScaledWidth : (int) (originalScaledWidth / Scale.getScale());
    }

    @ModifyExpressionValue(method = "getScaledYPos(Lcom/mojang/blaze3d/platform/Window;D)D", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/Window;getGuiScaledHeight()I"))
    private static int onScaledYPos(int originalScaledHeight) {
        return Scale.getScale() == 1.0F ? originalScaledHeight : (int) (originalScaledHeight / Scale.getScale());
    }
}
