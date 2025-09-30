package net.galgan.skyupplus;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;

public final class Chat {
    private Chat() {}

    public static void send(Text text) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null) return;

        Runnable r = () -> {
            if (client.inGameHud == null) return;
            ChatHud chat = client.inGameHud.getChatHud();
            if (chat != null) chat.addMessage(Text.empty()
                    .append(Text.literal("Sky").styled(style -> style.withColor(0x55FFFF).withBold(true)))
                    .append(Text.literal("UP").styled(style -> style.withColor(0xFFFFFF).withBold(true)))
                    .append(Text.literal("+ ").styled(style -> style.withColor(0xFFFF55).withBold(true)))
                    .append(Text.literal("» ").styled(style -> style.withColor(0x555555).withBold(true)))
                    .append(text));
        };

        if (client.isOnThread()) r.run(); else client.execute(r);
    }

    public static void sendString(String string) {
        send(Text.literal(string));
    }
}