package net.galgan.skyupplus.utility;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

public class ServerRestrictor {
    private static boolean allowedServer = false;

    public static void serverRestrictor() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            String address = handler.getConnection().getAddress().toString();
            allowedServer = address.contains("skyup.pl");
        });

        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> {
            allowedServer = false;
        });
    }

    public static boolean isAllowed() {
        return allowedServer;
    }
}