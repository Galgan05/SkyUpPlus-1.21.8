package net.galgan.skyupplus;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.galgan.skyupplus.mixin.BossBarHudAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.BossBarHud;
import net.minecraft.client.gui.hud.ClientBossBar;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.random.Random;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cooldown {

    private static final Map<UUID, Integer> lastTriggered = new HashMap<>();

    public static void cooldownNotifier() {
        ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
            if (!overlay || !ConfigGenerator.togglecooldown) return;

            if (message.getString().startsWith("§6§lPrace §8§l» §e§aUmiejętność")) {
                MinecraftClient client = MinecraftClient.getInstance();

                if (client.player != null) {
                    client.getSoundManager().play(
                            new PositionedSoundInstance(
                                    SoundEvents.BLOCK_BELL_USE,
                                    SoundCategory.MASTER,
                                    1.0f,
                                    1.0f,
                                    Random.create(),
                                    client.player.getX(), client.player.getY(), client.player.getZ()
                            )
                    );
                }
            }
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null || client.inGameHud == null || !ConfigGenerator.togglecooldown) return;
            BossBarHud hud = client.inGameHud.getBossBarHud();
            if(hud == null) return;

            Set<UUID> activeBossBars = new HashSet<>();

            for (ClientBossBar bar : ((BossBarHudAccessor) hud).getBossBarsMap().values()) {
                UUID id = bar.getUuid();
                activeBossBars.add(id);

                String title = bar.getName().getString();

                if (title.startsWith("Pług") || title.startsWith("Rozbiórka") || title.startsWith("Nawałnica") || title.startsWith("Sieci rybackie") || title.startsWith("Piła") || title.startsWith("Wiertło")) {
                    int minutes = 0, seconds = 0;

                    Matcher mMin = Pattern.compile("(\\d+)\\s*min").matcher(title);
                    if (mMin.find()) minutes = Integer.parseInt(mMin.group(1));

                    Matcher mSec = Pattern.compile("(\\d+)\\s*sek").matcher(title);
                    if (mSec.find()) seconds = Integer.parseInt(mSec.group(1));

                    int timeremaining = minutes * 60 + seconds;

                    int last = lastTriggered.getOrDefault(id, -1);

                    if (timeremaining != last) {
                        if(timeremaining == 3) {
                            client.getSoundManager().play(
                                    new PositionedSoundInstance(
                                            SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP,
                                            SoundCategory.MASTER,
                                            1.0f,
                                            0.9f,
                                            Random.create(),
                                            client.player.getX(), client.player.getY(), client.player.getZ()
                                    )
                            );
                        }
                        if(timeremaining == 2) {
                            client.getSoundManager().play(
                                    new PositionedSoundInstance(
                                            SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP,
                                            SoundCategory.MASTER,
                                            1.0f,
                                            1.0f,
                                            Random.create(),
                                            client.player.getX(), client.player.getY(), client.player.getZ()
                                    )
                            );
                        }
                        if(timeremaining == 1) {
                            client.getSoundManager().play(
                                    new PositionedSoundInstance(
                                            SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP,
                                            SoundCategory.MASTER,
                                            1.0f,
                                            1.1f,
                                            Random.create(),
                                            client.player.getX(), client.player.getY(), client.player.getZ()
                                    )
                            );
                        }
                        if(timeremaining == 0) {
                            client.getSoundManager().play(
                                    new PositionedSoundInstance(
                                            SoundEvents.BLOCK_BELL_USE,
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

            Iterator<Map.Entry<UUID, Integer>> it = lastTriggered.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<UUID, Integer> entry = it.next();
                UUID id = entry.getKey();
                int last = entry.getValue();

                if (!activeBossBars.contains(id)) {
                    if (last == 1) {
                        client.getSoundManager().play(
                                new PositionedSoundInstance(
                                        SoundEvents.BLOCK_BELL_USE,
                                        SoundCategory.MASTER,
                                        1.0f,
                                        1.0f,
                                        Random.create(),
                                        client.player.getX(), client.player.getY(), client.player.getZ()
                                )
                        );
                    }
                    it.remove();
                }
            }
        });
    }
}
