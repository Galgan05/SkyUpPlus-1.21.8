package net.galgan.skyupplus;

import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class Cooldown {
    public static void cooldownNotifier() {
        ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
            if (!overlay && !ConfigGenerator.togglecooldown) return;
            if (message.getString().startsWith("§6§lPrace §8§l» §e§aUmiejętność")) {
                Chat.send(Text.literal("Wykryto cooldown!").formatted(Formatting.GREEN));
                MinecraftClient client = MinecraftClient.getInstance();
                if (client.player != null) {
                    //TODO: Add custom sounds and custom sound manager
                    client.getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_TOAST_IN, 1.0F, 1.0F));
                }
            }
        });
    }
}
