package dev.g1ax.mixin.compat.blur;

import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import dev.g1ax.Scale;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Pseudo
@IfModLoaded(value = "blur", minVersion = "5.0.0")
@Mixin(targets = "eu.midnightdust.blur.Blur", remap = false)
public abstract class BlurMixin {
    @ModifyVariable(method = "renderRotatedGradient", at = @At(value = "HEAD"), index = 1, argsOnly = true, require = 0)
    private static int modifyWidth(int width) {
        return (int) (width * Scale.getScale());
    }

    @ModifyVariable(method = "renderRotatedGradient", at = @At(value = "HEAD"), index = 2, argsOnly = true, require = 0)
    private static int modifyHeight(int height) {
        return (int) (height * Scale.getScale());
    }
}
