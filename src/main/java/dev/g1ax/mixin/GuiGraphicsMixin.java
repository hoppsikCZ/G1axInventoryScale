package dev.g1ax.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.g1ax.config.G1axInventoryScaleConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner;
import org.joml.Matrix3x2fStack;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(GuiGraphics.class)
public class GuiGraphicsMixin {
    @Shadow @Final private Matrix3x2fStack pose;
    @Unique private int frameX, frameY;

    @WrapOperation(method = "renderTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/inventory/tooltip/ClientTooltipPositioner;positionTooltip(IIIIII)Lorg/joml/Vector2ic;"))
    private Vector2ic calculateTooltipPos(ClientTooltipPositioner instance, int width, int height, int mouseX, int mouseY, int i, int j, Operation<Vector2ic> original) {
        float scale = G1axInventoryScaleConfig.CONFIG.instance().tooltipSize;
        if (!(Minecraft.getInstance().screen instanceof AbstractContainerScreen) || scale == 1.0F) {
            return original.call(instance, width, height, mouseX, mouseY, i, j);
        }
        return calculatePos((int) (i * scale), (int) (j * scale), width, height, mouseX, mouseY);
    }

    @Inject(method = "renderTooltip", at = @At(value = "INVOKE", target = "Lorg/joml/Matrix3x2fStack;pushMatrix()Lorg/joml/Matrix3x2fStack;", shift = At.Shift.AFTER))
    private void scalePose(Font font, List<ClientTooltipComponent> tooltipLines, int mouseX, int mouseY, ClientTooltipPositioner tooltipPositioner, net.minecraft.resources.Identifier sprite, CallbackInfo ci) {
        float scale = G1axInventoryScaleConfig.CONFIG.instance().tooltipSize;
        if (Minecraft.getInstance().screen instanceof AbstractContainerScreen && scale != 1.0F) {
            this.pose.translate(frameX, frameY);
            pose.scale(scale, scale);
        }
    }

    @Unique
    public Vector2ic calculatePos(int tw, int th, int sw, int sh, int mouseX, int mouseY) {
        frameX = mouseX + 12;
        frameY = mouseY - 12;

        if (frameX + tw > sw) frameX = Math.max(mouseX - 12 - tw, 4);
        if (frameY + th + 3 > sh) frameY =  sh - th - 3;

        return new Vector2i(0, 0);
    }
}
