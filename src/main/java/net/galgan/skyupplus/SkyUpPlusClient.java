package net.galgan.skyupplus;

import net.fabricmc.api.ClientModInitializer;

public class SkyUpPlusClient implements ClientModInitializer {
	public static final String MOD_ID = "skyupplus";

	@Override
	public void onInitializeClient() {
        ConfigGenerator.load();
        Quests.questHandler();
        Fishing.fishingStats();
        Cooldown.cooldownNotifier();
        Commands.registerCommands();
        HUD.renderHud();
	}
}