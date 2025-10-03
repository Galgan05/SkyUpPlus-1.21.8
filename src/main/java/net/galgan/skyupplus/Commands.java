package net.galgan.skyupplus;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;

public class Commands {
    public static void registerCommands() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {

            dispatcher.register(ClientCommandManager.literal("sup").executes(ctx -> {

                MinecraftClient client = MinecraftClient.getInstance();

                client.execute(() -> client.send(() -> client.setScreen(Ustawienia.create(client.currentScreen))));

                return 1;
            }));
        });
    }
}