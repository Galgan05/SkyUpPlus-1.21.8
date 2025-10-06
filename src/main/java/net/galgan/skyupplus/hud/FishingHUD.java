package net.galgan.skyupplus.hud;

import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.features.Fishing;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.List;

public class FishingHUD {

    public static void generateBody() {
        List<Text> bodyText = new ArrayList<>();

        if (Config.INSTANCE.fishingDisplay.mode().equals("always") || (Fishing.isFishing && Config.INSTANCE.fishingDisplay.mode().equals("fishing_rod"))) {

            if (Config.INSTANCE.toggleNiewielka) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Niewielka: ").formatted(Formatting.GRAY, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.niewielkaCount)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.togglePrzecietna) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Przeciętna: ").formatted(Formatting.YELLOW, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.przecietnaCount)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.toggleWymiarowa) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Wymiarowa: ").formatted(Formatting.GREEN, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.wymiarowaCount)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.toggleOgromna) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Ogromna: ").formatted(Formatting.GOLD, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.ogromnaCount)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.toggleMamucia) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Mamucia: ").formatted(Formatting.DARK_PURPLE, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.mamuciaCount)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.toggleSuma) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Suma: ").formatted(Formatting.BLUE, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.totalCount)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.toggleZarobek) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Zarobek: ").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal(String.format("%.2f", Config.INSTANCE.totalEarned)).append(" SC").formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.toggleWaga) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Waga: ").formatted(Formatting.LIGHT_PURPLE, Formatting.BOLD))
                        .append(Text.literal(String.format("%.2f", Config.INSTANCE.totalWeight)).append("g").formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.toggleNajwieksza) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Max: ").formatted(Formatting.DARK_GREEN, Formatting.BOLD))
                        .append(Text.literal(String.format("%.2f", Config.INSTANCE.biggestWeight)).append("g").formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.toggleNajmniejsza) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Min: ").formatted(Formatting.DARK_RED, Formatting.BOLD))
                        .append(Text.literal(String.format("%.2f", Config.INSTANCE.smallestWeight)).append("g").formatted(Formatting.WHITE)));
            }
        }

        RenderHUD.fishingHUD = bodyText;
    }
}
