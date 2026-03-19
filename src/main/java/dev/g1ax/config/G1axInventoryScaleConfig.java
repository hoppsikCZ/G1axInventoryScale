package dev.g1ax.config;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.FloatSliderControllerBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class G1axInventoryScaleConfig {
    public static final ConfigClassHandler<G1axInventoryScaleConfig> CONFIG = ConfigClassHandler.createBuilder(G1axInventoryScaleConfig.class)
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(FabricLoader.getInstance().getConfigDir().resolve("g1axinventoryscale.json"))
                    .build())
            .build();

    @SerialEntry public float containerSize = 1F;
    @SerialEntry public float tooltipSize = 1F;

    public static Screen configScreen(Screen parent) {
        return YetAnotherConfigLib.create(CONFIG, ((defaults, config, builder) -> builder
                .title(Component.translatable("g1ax-inventory-scale.title"))
                .category(ConfigCategory.createBuilder()
                        .name(Component.translatable("g1ax-inventory-scale.title"))
                        .option(Option.<Float>createBuilder()
                                .name(Component.translatable("g1ax-inventory-scale.container-scale"))
                                .description(OptionDescription.of(Component.translatable("g1ax-inventory-scale.container-scale.description")))
                                .binding(1F, () -> config.containerSize, newVal -> config.containerSize = newVal)
                                .controller(opt -> FloatSliderControllerBuilder.create(opt)
                                        .formatValue(value -> Component.literal(String.format("%.1f", value) + "x"))
                                        .range(0.5F, 8F)
                                        .step(0.1F))
                                .build())
                        .option(Option.<Float>createBuilder()
                                .name(Component.translatable("g1ax-inventory-scale.tooltip-scale"))
                                .description(OptionDescription.of(Component.translatable("g1ax-inventory-scale.tooltip-scale.description")))
                                .binding(1F, () -> config.tooltipSize, newVal -> config.tooltipSize = newVal)
                                .controller(opt -> FloatSliderControllerBuilder.create(opt)
                                        .formatValue(value -> Component.literal(String.format("%.1f", value) + "x"))
                                        .range(0.5F, 2F)
                                        .step(0.1F))
                                .build())
                        .build())
        )).generateScreen(parent);
    }
}
