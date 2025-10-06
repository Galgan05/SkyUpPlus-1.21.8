package net.galgan.skyupplus.features;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.mixin.BossBarHudAccessor;
import net.galgan.skyupplus.utility.Chat;
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

    public static int[] timePlug;
    public static int[] timeWiertlo;
    public static int[] timeRozbiorka;
    public static int[] timePila;
    public static int[] timeSieciRybackie;
    public static int[] timeNawalnica;

    public static boolean isActivePlug = false;
    public static boolean isActiveWiertlo = false;
    public static boolean isActiveRozbiorka = false;
    public static boolean isActivePila = false;
    public static boolean isActiveSieciRybackie = false;
    public static boolean isActiveNawalnica = false;

    private static long nextPlug = -1L;
    private static long nextWiertlo = -1L;
    private static long nextRozbiorka = -1L;
    private static long nextPila = -1L;
    private static long nextSieciRybackie = -1L;
    private static long nextNawalnica = -1L;

    public static void abilities() {
        ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
            if(!ServerRestrictor.isAllowed()) return;

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
            if(!ServerRestrictor.isAllowed()) return;

            if (client.player == null || client.inGameHud == null) return;

            isActivePlug = false;
            isActiveWiertlo = false;
            isActiveRozbiorka = false;
            isActivePila = false;
            isActiveSieciRybackie = false;
            isActiveNawalnica = false;

            BossBarHud hud = client.inGameHud.getBossBarHud();
            if(hud == null) return;

            for (ClientBossBar bar : ((BossBarHudAccessor) hud).getBossBarsMap().values()) {
                UUID id = bar.getUuid();
                String title = bar.getName().getString();

                if (Config.INSTANCE.countdownPlug && title.startsWith("Pług")) {
                    isActivePlug = true;

                    int[] result = getTimeRemaining(title, id);
                    int timeremaining = result[0];
                    int last = result[1];

                    playCountdown(client, id, timeremaining, last);

                    nextPlug = System.currentTimeMillis() + 1000L * timeremaining + 300000;
                }

                if (Config.INSTANCE.countdownRozbiorka && title.startsWith("Rozbiórka")) {
                    isActiveRozbiorka = true;

                    int[] result = getTimeRemaining(title, id);
                    int timeremaining = result[0];
                    int last = result[1];

                    playCountdown(client, id, timeremaining, last);

                    nextRozbiorka = System.currentTimeMillis() + 1000L * timeremaining + 300000;
                }

                if (Config.INSTANCE.countdownNawalnica && title.startsWith("Nawałnica")) {
                    isActiveNawalnica = true;

                    int[] result = getTimeRemaining(title, id);
                    int timeremaining = result[0];
                    int last = result[1];

                    playCountdown(client, id, timeremaining, last);

                    nextNawalnica = System.currentTimeMillis() + 1000L * timeremaining + 300000;
                }

                if (Config.INSTANCE.countdownSieciRybackie && title.startsWith("Sieci rybackie")) {
                    isActiveSieciRybackie = true;

                    int[] result = getTimeRemaining(title, id);
                    int timeremaining = result[0];
                    int last = result[1];

                    playCountdown(client, id, timeremaining, last);

                    nextSieciRybackie = System.currentTimeMillis() + 1000L * timeremaining + 300000;
                }

                if (Config.INSTANCE.countdownPila && title.startsWith("Piła")) {
                    isActivePila = true;

                    int[] result = getTimeRemaining(title, id);
                    int timeremaining = result[0];
                    int last = result[1];

                    playCountdown(client, id, timeremaining, last);

                    nextPila = System.currentTimeMillis() + 1000L * timeremaining + 300000;
                }

                if (Config.INSTANCE.countdownWiertlo && title.startsWith("Wiertło")) {
                    isActiveWiertlo = true;

                    int[] result = getTimeRemaining(title, id);
                    int timeremaining = result[0];
                    int last = result[1];

                    playCountdown(client, id, timeremaining, last);

                    nextWiertlo = System.currentTimeMillis() + 1000L * timeremaining + 300000;
                }
            }

            if (System.currentTimeMillis() <= nextPlug) {
                long czas = nextPlug - System.currentTimeMillis();
                int timer = (int) czas/1000;
                timePlug = new int[]{timer / 60, timer % 60};
            } else {
                timePlug = null;
            }

            if (System.currentTimeMillis() <= nextRozbiorka) {
                long czas = nextRozbiorka - System.currentTimeMillis();
                int timer = (int) czas/1000;
                timeRozbiorka = new int[]{timer / 60, timer % 60};
            } else {
                timeRozbiorka = null;
            }

            if (System.currentTimeMillis() <= nextNawalnica) {
                long czas = nextNawalnica - System.currentTimeMillis();
                int timer = (int) czas/1000;
                timeNawalnica= new int[]{timer / 60, timer % 60};
            } else {
                timeNawalnica = null;
            }

            if (System.currentTimeMillis() <= nextSieciRybackie) {
                long czas = nextSieciRybackie - System.currentTimeMillis();
                int timer = (int) czas/1000;
                timeSieciRybackie = new int[]{timer / 60, timer % 60};
            } else {
                timeSieciRybackie = null;
            }

            if (System.currentTimeMillis() <= nextPila) {
                long czas = nextPila - System.currentTimeMillis();
                int timer = (int) czas/1000;
                timePila = new int[]{timer / 60, timer % 60};
            } else {
                timePila = null;
            }

            if (System.currentTimeMillis() <= nextWiertlo) {
                long czas = nextWiertlo - System.currentTimeMillis();
                int timer = (int) czas/1000;
                timeWiertlo = new int[]{timer / 60, timer % 60};
            } else {
                timeWiertlo = null;
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
    private static int[] getTimeRemaining(String title, UUID id) {
        int minutes = 0, seconds = 0;

        Matcher mMin = Pattern.compile("(\\d+)\\s*min").matcher(title);
        if (mMin.find()) minutes = Integer.parseInt(mMin.group(1));

        Matcher mSec = Pattern.compile("(\\d+)\\s*sek").matcher(title);
        if (mSec.find()) seconds = Integer.parseInt(mSec.group(1));

        int timeremaining = minutes * 60 + seconds;
        int last = lastTriggered.getOrDefault(id, -1);

        return new int[]{timeremaining, last};
    }

    private static void playCountdown(MinecraftClient client, UUID id, int timeremaining, int last) {
        if (client.player == null) return;

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
