package net.galgan.skyupplus;

import net.fabricmc.api.ClientModInitializer;

public class SkyUpPlusClient implements ClientModInitializer {
	public static final String MOD_ID = "skyupplus";

	@Override
	public void onInitializeClient() {
        Config.load();
        Zadania.handlerZadan();
        Rybak.handlerRybaka();
        Umiejetnosci.handlerUmiejetnosci();
        HUD.renderHUD();
	}
}