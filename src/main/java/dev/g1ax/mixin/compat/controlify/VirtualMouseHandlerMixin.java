package dev.g1ax.mixin.compat.controlify;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import dev.g1ax.Scale;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Pseudo
@IfModLoaded(value = "controlify", minVersion = "2.2.1")
@Mixin(targets = "dev.isxander.controlify.virtualmouse.VirtualMouseHandler")
public class VirtualMouseHandlerMixin {
    @ModifyExpressionValue(method = "snapToClosestPoint", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/Window;getGuiScaledWidth()I"), require = 0)
    private int onSnapToClosestPointWidth(int original) {
        return (int) (original / Scale.getScale());
    }

    @ModifyExpressionValue(method = "snapToClosestPoint", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/Window;getGuiScaledHeight()I"), require = 0)
    private int onSnapToClosestPointHeight(int original) {
        return (int) (original / Scale.getScale());
    }

    @ModifyExpressionValue(method = "snapInDirection", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/Window;getGuiScaledWidth()I"), require = 0)
    private int onSnapInDirectionWidth(int original) {
        return (int) (original / Scale.getScale());
    }

    @ModifyExpressionValue(method = "snapInDirection", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/Window;getGuiScaledHeight()I"), require = 0)
    private int onSnapInDirectionHeight(int original) {
        return (int) (original / Scale.getScale());
    }

    @ModifyArg(method = "renderVirtualMouse", at = @At(value = "INVOKE", target = "Ldev/isxander/controlify/utils/render/CGuiPose;translate(FF)Ldev/isxander/controlify/utils/render/CGuiPose;"), index = 0, require = 0)
    private float modifyXScale(float x) {
        return x / Scale.getScale();
    }

    @ModifyArg(method = "renderVirtualMouse", at = @At(value = "INVOKE", target = "Ldev/isxander/controlify/utils/render/CGuiPose;translate(FF)Ldev/isxander/controlify/utils/render/CGuiPose;"), index = 1, require = 0)
    private float modifyYScale(float y) {
        return y / Scale.getScale();
    }
}
