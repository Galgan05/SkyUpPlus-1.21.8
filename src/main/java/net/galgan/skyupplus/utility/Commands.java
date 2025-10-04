package net.galgan.skyupplus.utility;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.galgan.skyupplus.config.Settings;
import net.minecraft.client.MinecraftClient;

public class Commands {
    public static void commands() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            if(!ServerRestrictor.isAllowed()) return;

            dispatcher.register(ClientCommandManager.literal("sup").executes(ctx -> {

                MinecraftClient client = MinecraftClient.getInstance();

                client.execute(() -> client.send(() -> client.setScreen(Settings.create(client.currentScreen))));

                return 1;
            }));
        });
    }
}