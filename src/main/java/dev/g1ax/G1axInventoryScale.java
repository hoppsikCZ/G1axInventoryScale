package dev.g1ax;

import dev.g1ax.config.G1axInventoryScaleConfig;
import net.fabricmc.api.ModInitializer;

public class G1axInventoryScale implements ModInitializer {
	@Override
	public void onInitialize() {
		G1axInventoryScaleConfig.CONFIG.load();
	}
}