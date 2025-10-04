package net.galgan.skyupplus.utility;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public final class Chat {
    private Chat() {}

    public static void send(Text text) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null) return;

        Runnable r = () -> {
            if (client.inGameHud == null) return;
            ChatHud chat = client.inGameHud.getChatHud();
            if (chat != null) chat.addMessage(Text.empty()
                    .append(Text.literal("Sky").formatted(Formatting.AQUA, Formatting.BOLD))
                    .append(Text.literal("UP").formatted(Formatting.WHITE, Formatting.BOLD))
                    .append(Text.literal("+ ").formatted(Formatting.LIGHT_PURPLE, Formatting.BOLD))
                    .append(Text.literal("» ").formatted(Formatting.DARK_GRAY, Formatting.BOLD))
                    .append(text));
        };

        if (client.isOnThread()) r.run(); else client.execute(r);
    }

    public static void sendString(String string) {
        send(Text.literal(string));
    }
}