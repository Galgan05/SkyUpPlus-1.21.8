package net.galgan.skyupplus;

import net.fabricmc.api.ClientModInitializer;
import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.features.*;
import net.galgan.skyupplus.hud.RenderHUD;
import net.galgan.skyupplus.utility.Commands;
import net.galgan.skyupplus.utility.ServerRestrictor;

public class SkyUpPlusClient implements ClientModInitializer {
	public static final String MOD_ID = "skyupplus";

	@Override
	public void onInitializeClient() {
        Config.load();
        ServerRestrictor.init();
        Commands.commands();
        Quests.quests();
        Fishing.fishing();
        Abilities.abilities();
        Dungeon.dungeon();
        Crates.crates();
        RenderHUD.renderHUD();
	}
}