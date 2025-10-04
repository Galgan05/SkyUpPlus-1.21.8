package net.galgan.skyupplus.features;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.mixin.BossBarHudAccessor;
import net.galgan.skyupplus.utility.ServerRestrictor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.BossBarHud;
import net.minecraft.client.gui.hud.ClientBossBar;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.random.Random;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Abilities {

    private static final Map<UUID, Integer> lastTriggered = new HashMap<>();

    public static void abilities() {
        ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
            if (overlay) {
                if (Config.INSTANCE.cooldownPlug && message.getString().startsWith("§6§lPrace §8§l» §e§aUmiejętność §6§c§lPług")) {
                    playMain();
                }
                if (Config.INSTANCE.cooldownWiertlo && message.getString().startsWith("§6§lPrace §8§l» §e§aUmiejętność §6§c§lWiertło")) {
                    playMain();
                }
                if (Config.INSTANCE.cooldownRozbiorka && message.getString().startsWith("§6§lPrace §8§l» §e§aUmiejętność §6§c§lRozbiórka")) {
                    playMain();
                }
                if (Config.INSTANCE.cooldownPila && message.getString().startsWith("§6§lPrace §8§l» §e§aUmiejętność §6§c§lPiła")) {
                    playMain();
                }
                if (Config.INSTANCE.cooldownSieciRybackie && message.getString().startsWith("§6§lPrace §8§l» §e§aUmiejętność §6§c§lSieci rybackie")) {
                    playMain();
                }
                if (Config.INSTANCE.cooldownNawalnica && message.getString().startsWith("§6§lPrace §8§l» §e§aUmiejętność §6§c§lNawałnica")) {
                    playMain();
                }
            }
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null || client.inGameHud == null) return;

            BossBarHud hud = client.inGameHud.getBossBarHud();
            if(hud == null) return;

            for (ClientBossBar bar : ((BossBarHudAccessor) hud).getBossBarsMap().values()) {
                UUID id = bar.getUuid();

                String title = bar.getName().getString();

                if (Config.INSTANCE.countdownPlug && title.startsWith("Pług")) {
                    playCountdown(client, title, id);
                }
                if (Config.INSTANCE.countdownRozbiorka && title.startsWith("Rozbiórka")) {
                    playCountdown(client, title, id);
                }
                if (Config.INSTANCE.countdownNawalnica && title.startsWith("Nawałnica")) {
                    playCountdown(client, title, id);
                }
                if (Config.INSTANCE.countdownSieciRybackie && title.startsWith("Sieci rybackie")) {
                    playCountdown(client, title, id);
                }
                if (Config.INSTANCE.countdownPila && title.startsWith("Piła")) {
                    playCountdown(client, title, id);
                }
                if (Config.INSTANCE.countdownWiertlo && title.startsWith("Wiertło")) {
                    playCountdown(client, title, id);
                }
            }
        });
    }

    private static void playMain() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null) {
            client.getSoundManager().play(
                    new PositionedSoundInstance(
                            Config.INSTANCE.mainSound.sound(),
                            SoundCategory.MASTER,
                            1.0f,
                            1.0f,
                            Random.create(),
                            client.player.getX(), client.player.getY(), client.player.getZ()
                    )
            );
        }
    }

    private static void playCountdown(MinecraftClient client, String title, UUID id) {
        if (client.player == null) return;

        int minutes = 0, seconds = 0;

        Matcher mMin = Pattern.compile("(\\d+)\\s*min").matcher(title);
        if (mMin.find()) minutes = Integer.parseInt(mMin.group(1));

        Matcher mSec = Pattern.compile("(\\d+)\\s*sek").matcher(title);
        if (mSec.find()) seconds = Integer.parseInt(mSec.group(1));

        int timeremaining = minutes * 60 + seconds;

        int last = lastTriggered.getOrDefault(id, -1);

        if (timeremaining != last) {
            if(timeremaining == 4) {
                client.getSoundManager().play(
                        new PositionedSoundInstance(
                                Config.INSTANCE.countdownSound.sound(),
                                SoundCategory.MASTER,
                                1.0f,
                                0.9f,
                                Random.create(),
                                client.player.getX(), client.player.getY(), client.player.getZ()
                        )
                );
            }
            if(timeremaining == 3) {
                client.getSoundManager().play(
                        new PositionedSoundInstance(
                                Config.INSTANCE.countdownSound.sound(),
                                SoundCategory.MASTER,
                                1.0f,
                                1.0f,
                                Random.create(),
                                client.player.getX(), client.player.getY(), client.player.getZ()
                        )
                );
            }
            if(timeremaining == 2) {
                client.getSoundManager().play(
                        new PositionedSoundInstance(
                                Config.INSTANCE.countdownSound.sound(),
                                SoundCategory.MASTER,
                                1.0f,
                                1.1f,
                                Random.create(),
                                client.player.getX(), client.player.getY(), client.player.getZ()
                        )
                );
            }
            if(timeremaining == 1) {
                client.getSoundManager().play(
                        new PositionedSoundInstance(
                                Config.INSTANCE.mainSound.sound(),
                                SoundCategory.MASTER,
                                1.0f,
                                1.0f,
                                Random.create(),
                                client.player.getX(), client.player.getY(), client.player.getZ()
                        )
                );
            }
            lastTriggered.put(id, timeremaining);
        }
    }

}
