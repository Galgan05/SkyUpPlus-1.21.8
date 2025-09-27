package net.galgan.skyupextras;

import net.fabricmc.api.ClientModInitializer;

public class SkyUpExtrasClient implements ClientModInitializer {
	public static final String MOD_ID = "skyupextras";

	@Override
	public void onInitializeClient() {
        DetectQuest.questDetection();
	}
}