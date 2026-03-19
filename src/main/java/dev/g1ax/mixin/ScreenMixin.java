package dev.g1ax.mixin;

import dev.g1ax.Scale;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static java.lang.Math.ceil;

@Mixin(Screen.class)
public class ScreenMixin {
    @Shadow public int width;
    @Shadow public int height;

    @Inject(method = "init", at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/screens/Screen;height:I", shift = At.Shift.AFTER))
    private void onInitAfterViewportSizeSet(int width, int height, CallbackInfo ci) {
        if (Scale.getScale() == 1.0F) return;
        this.width = (int) ceil((double) width / Scale.getScale());
        this.height = (int) ceil((double) height / Scale.getScale());
    }

    @Inject(method = "resize", at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/screens/Screen;height:I", shift = At.Shift.AFTER))
    private void onResizeAfterViewportSizeSet(int width, int height, CallbackInfo ci) {
        if (Scale.getScale() == 1.0F) return;
        this.width = (int) ceil((double) width / Scale.getScale());
        this.height = (int) ceil((double) height / Scale.getScale());
    }
}
