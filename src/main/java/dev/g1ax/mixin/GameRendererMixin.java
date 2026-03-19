package dev.g1ax.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.g1ax.Scale;
import dev.isxander.yacl3.gui.utils.GuiUtils;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Inject(method = "render", at = @At(value = "FIELD", opcode = Opcodes.GETFIELD, target = "Lnet/minecraft/client/Minecraft;screen:Lnet/minecraft/client/gui/screens/Screen;", ordinal = 1))
    private void onScreenRenderPre(DeltaTracker deltaTracker, boolean renderLevel, CallbackInfo ci, @Local GuiGraphics guiGraphics) {
        if (Scale.getScale() == 1.0F) return;
        GuiUtils.pushPose(guiGraphics);
        GuiUtils.scale2D(guiGraphics, Scale.getScale(), Scale.getScale());
    }

    @Inject(method = "render", at = @At(value = "FIELD", opcode = Opcodes.GETFIELD, target = "Lnet/minecraft/client/Minecraft;screen:Lnet/minecraft/client/gui/screens/Screen;", shift = At.Shift.AFTER, ordinal = 3))
    private void onScreenRenderPost(DeltaTracker deltaTracker, boolean renderLevel, CallbackInfo ci, @Local GuiGraphics guiGraphics) {
        if (Scale.getScale() == 1.0F) return;
        GuiUtils.popPose(guiGraphics);
    }
}
