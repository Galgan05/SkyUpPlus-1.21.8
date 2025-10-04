package net.galgan.skyupplus.features;


import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.utility.Chat;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.random.Random;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dungeon {
    public static int min = -1;
    public static int sec = -1;

    public static void dungeon() {
        if (!Config.INSTANCE.dungeonCooldownToggle) return;

        ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
            if (!overlay && message.getString().startsWith("Dungeon » Opuszczono Du")) {
                Config.INSTANCE.nextEntryTime = System.currentTimeMillis() + 1800000;
                Config.INSTANCE.onCooldown = true;
                Config.save();
            }

            if (!overlay && message.getString().startsWith("Dungeon » Nie musisz czekać")) {
                Config.INSTANCE.nextEntryTime = System.currentTimeMillis();
                Config.INSTANCE.onCooldown = false;
                Config.save();
            }

            if (!overlay && message.getString().startsWith("Dungeon » Musisz odczekać jeszcze")) {

                int minutes = 0, seconds = 0;

                Matcher mMin = Pattern.compile("(\\d+)\\s*min").matcher(message.getString());
                if (mMin.find()) minutes = Integer.parseInt(mMin.group(1));

                Matcher mSec = Pattern.compile("(\\d+)\\s*sek").matcher(message.getString());
                if (mSec.find()) seconds = Integer.parseInt(mSec.group(1));

                int timeremaining = (minutes * 60 + seconds) * 1000;

                Config.INSTANCE.nextEntryTime = System.currentTimeMillis() + timeremaining;
                Config.INSTANCE.onCooldown = true;
                Config.save();
            }
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            ZonedDateTime czasPolski = ZonedDateTime.now(ZoneId.of("Europe/Warsaw"));

            if (czasPolski.getHour() == 3 && czasPolski.getMinute() == 0 && czasPolski.getSecond() == 0) {
                Config.INSTANCE.nextEntryTime = -1L;
                Config.INSTANCE.onCooldown = false;
                Config.save();
            }

            if(Config.INSTANCE.onCooldown) {
                long czas = Config.INSTANCE.nextEntryTime - System.currentTimeMillis();
                int dungeonyTimer = (int) czas/1000;
                min = dungeonyTimer / 60;
                sec = dungeonyTimer % 60;

                if(System.currentTimeMillis() > Config.INSTANCE.nextEntryTime) {
                    playDungeonSound();
                    Chat.send(Text.literal("Cooldown na wejście do dungeonu skończył się!").formatted(Formatting.GREEN));
                    Config.INSTANCE.nextEntryTime = -1L;
                    Config.INSTANCE.onCooldown = false;
                    Config.save();
                }
            }
        });
    }

    private static void playDungeonSound() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null) {
            client.getSoundManager().play(
                    new PositionedSoundInstance(
                            Config.INSTANCE.dungeonSound.sound(),
                            SoundCategory.MASTER,
                            1.0f,
                            1.0f,
                            Random.create(),
                            client.player.getX(), client.player.getY(), client.player.getZ()
                    )
            );
        }
    }
}